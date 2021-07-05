package org.zerock.mapper;

import org.zerock.domain.FileVO;

public interface FileMapper {

	public int insert(FileVO vo);

	public void deleteByBno(Long bno);
}
