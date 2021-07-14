package org.zerock.service;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.FileVO;
import org.zerock.mapper.BoardMapper;
import org.zerock.mapper.FileMapper;
import org.zerock.mapper.ReplyMapper;

//import lombok.AllArgsConstructor;
import lombok.Setter;
import software.amazon.awssdk.auth.credentials.ProfileCredentialsProvider;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.profiles.ProfileFile;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.DeleteObjectRequest;
import software.amazon.awssdk.services.s3.model.ObjectCannedACL;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

//@AllArgsConstructor
@Service
public class BoardServiceImpl implements BoardService{
	
	private String bucketName;
	private String profileName;
	private S3Client s3;

	
	@Setter (onMethod_ = @Autowired)
	private BoardMapper mapper;
	
	@Setter (onMethod_ = @Autowired)
	private ReplyMapper replyMapper;
	
	@Setter (onMethod_ = @Autowired)
	private FileMapper fileMapper;
	
	
	public BoardServiceImpl() {
		this.bucketName = "choongang-soobin";
		this.profileName = "spring1";
		
		/*  
		 * create
		 *  /home/tomcat/.aws/credentials
		 */
		
		Path contentLocation = new File(System.getProperty("user.home") + "/.aws/credentials").toPath();
		ProfileFile pf = ProfileFile.builder()
				.content(contentLocation)
				.type(ProfileFile.Type.CREDENTIALS)
				.build();
		ProfileCredentialsProvider pcp = ProfileCredentialsProvider.builder()
				.profileFile(pf)
				.profileName(profileName)
				.build();
		
		this.s3 = S3Client.builder()
				.credentialsProvider(pcp)
				.build();
	}
	
//	public BoardServiceImpl() {
//		this.bucketName = "choongang-soobin";
//		this.profileName = "spring1";
//		this.s3 = S3Client.builder()
//				.credentialsProvider(ProfileCredentialsProvider.create(profileName))
//				.build();
//	}
	
//	@Autowired
//	public BoardServiceImpl(BooardMapper mapper) {
//		this.mapper = mapper;
//	}
	
	@Override
	public void register(BoardVO board) {
		mapper.insertSelectKey(board);
		
	}

	@Override
	public BoardVO get(Long bno) {
		// TODO Auto-generated method stub
		return mapper.read(bno);
	}

	//파일 업로드 !!!!하는코드들 !!!!!????? ㅠㅠ 
	
	@Override
	@Transactional
	public void register(BoardVO board, MultipartFile file) {
		register(board);
		
		if(file !=null && file.getSize() > 0) {
			
		
		FileVO vo = new FileVO();
		vo.setBno(board.getBno());
		vo.setFileName(file.getOriginalFilename());
		
		fileMapper.insert(vo);
		upload(board, file);
		}
	}

	private void upload(BoardVO board, MultipartFile file) {

		try (InputStream is = file.getInputStream()) {
//			String bucketName = "choongang-soobin";
//			String profileName = "spring1";
//			S3Client s3 = S3Client.builder()
//					.credentialsProvider(ProfileCredentialsProvider.create(profileName))
//					.build();
			
			PutObjectRequest objectRequest = PutObjectRequest.builder()
					.bucket(bucketName)
					.key(board.getBno() + "/" + file.getOriginalFilename())
					.contentType(file.getContentType())
					.acl(ObjectCannedACL.PUBLIC_READ)
					.build();
			
			s3.putObject(objectRequest, 
					RequestBody.fromInputStream(is, file.getSize()));
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}
	
	
	@Override
	@Transactional
	public boolean modify(BoardVO board, MultipartFile file) {

		if (file != null & file.getSize() > 0) {
			// s3는 삭제 후 재업로드
			BoardVO oldBoard = mapper.read(board.getBno());
			removeFile(oldBoard);
			upload(board, file);

			// tbl_board_file은 삭제 후 인서트
			fileMapper.deleteByBno(board.getBno());

			FileVO vo = new FileVO();
			vo.setBno(board.getBno());
			vo.setFileName(file.getOriginalFilename());
			fileMapper.insert(vo);
		}
		return modify(board);
	}
	@Override
	@Transactional
	public boolean remove(Long bno) {
		
		//게시물댓글 삭제 
		replyMapper.deleteByBno(bno);
		
		//파일 삭제 (s3 )
		BoardVO vo = mapper.read(bno); //파일삭제할려면 파일명을 읽어와야되서 한번 읽어와줘야해 
		removeFile(vo);
		
		//파일삭제 (DB )
		fileMapper.deleteByBno(bno);
		
		
		
		//게시물 삭제 
		int cnt = mapper.delete(bno);
		return cnt ==1;
		
		//return mapper.delete(bno) ==1 ;
	}

	private void removeFile(BoardVO vo) {
//		String bucketName = "";
		String key = vo.getBno() + "/" + vo.getFileName();

		DeleteObjectRequest deleteObjectRequest = DeleteObjectRequest.builder()
				.bucket(bucketName)
				.key(key)
				.build();

		s3.deleteObject(deleteObjectRequest);
	}
	
	
	
//	@Override
//	public List<BoardVO> getList() {
//		// TODO Auto-generated method stub
//		return mapper.getList();
//	}

	@Override
	public List<BoardVO> getList(Criteria cri) {
		return mapper.getListWithPaging(cri);
	}
	
	@Override
	public int getTotal(Criteria cri) {
		// TODO Auto-generated method stub
		return mapper.getTotalCount(cri);
	}

	@Override
	public boolean modify(BoardVO board) {
		// TODO Auto-generated method stub
		return mapper.update(board) == 1;
	}

}