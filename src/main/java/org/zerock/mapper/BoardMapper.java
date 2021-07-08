package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.MemberVO;

public interface BoardMapper {

	//@Select("SELECT * FROM tbl_board")
	
	public List<BoardVO> getList();
	
	public List<BoardVO> getListWithPaging(Criteria cri);
	
	// INSERT INTRO tbl_board (title, content, writer) 
	// VALUSE ( #{title},#{content}, #{writer})
	
	public int insert(BoardVO board);
	
	/*
	 * 
		String sql = "INSERT INTO tbl_board (title, content, writer) VALUES (?,?,?) ";
		...
		pstmt.setString(1,board.getTitle());
		pstmt.setString(2,board.getContent());
		pstmt.setString(3,board.getWriter());
		
		pstmt.executeUpdate();
		
	 */
	//BoardVO - > 타입 !! board 파라미터 
	public int insertSelectKey(BoardVO board);
	
	public BoardVO read(long bno);
	
	public int delete(long bno);
	
	public int update(BoardVO board);

	public int getTotalCount(Criteria cri);

	public void removeByUserid(MemberVO vo);
	
	
}