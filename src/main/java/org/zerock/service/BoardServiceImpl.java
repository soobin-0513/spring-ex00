package org.zerock.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.mapper.BoardMapper;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class BoardServiceImpl implements BoardService{

	private BoardMapper mapper;
	
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

	@Override
	public boolean modify(BoardVO board) {
		// TODO Auto-generated method stub
		return mapper.update(board) == 1;
	}

	@Override
	public boolean remove(Long bno) {
		// TODO Auto-generated method stub
		return mapper.delete(bno) ==1 ;
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

}