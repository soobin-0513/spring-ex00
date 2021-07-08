package org.zerock.mapper;

import org.zerock.domain.FileVO;
import org.zerock.domain.MemberVO;

public interface FileMapper {

	public int insert(FileVO vo);

	public void deleteByBno(Long bno);
	
	public void removeByUserid(MemberVO vo);
}
