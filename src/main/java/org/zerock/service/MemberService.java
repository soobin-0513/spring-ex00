package org.zerock.service;

import org.zerock.domain.MemberVO;

public interface MemberService {

	boolean insert(MemberVO vo);
	
	MemberVO read(String name);
	
	boolean modify(MemberVO vo);

	boolean remove(MemberVO vo);
}
