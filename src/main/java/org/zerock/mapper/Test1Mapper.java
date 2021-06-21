package org.zerock.mapper;

import java.util.List;

import org.zerock.domain.Test1VO;

public interface Test1Mapper {

	public List<Test1VO> getList();


	public int Tinsert(Test1VO test);
	
	//public Test1VO read(int id);
	
	public int TinsertSelectKey(Test1VO test);
	
	public int Tupdate(Test1VO test);
	
	public int Tdelete(int id);
}