package org.zerock.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.domain.ReplyVO;
import org.zerock.mapper.ReplyMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
//Service 선언해주는 이유 ReplyServicelmpl빈으로 만들기 
@Service
@Log4j
public class ReplyServicelmpl  implements ReplyService{
	
	@Setter(onMethod_= @Autowired)
	private ReplyMapper mapper;
	
	/*
	 같은의미 	@Setter(onMethod_= @Autowired)
	@Autowired
	public void setMapper(ReplyMapper mapper) {
		this.mapper = mapper;
	}
	*/
	
	@Override
	public int register(ReplyVO vo) {
		// TODO Auto-generated method stub
		return mapper.insertSelectKey(vo);
	}

	@Override
	public ReplyVO get(Long rno) {
		// TODO Auto-generated method stub
		return mapper.read(rno);
	}

	@Override
	public int modify(ReplyVO vo) {
		// TODO Auto-generated method stub
		return mapper.update(vo);
	}

	@Override
	public int remove(Long rno) {
		// TODO Auto-generated method stub
		return mapper.delete(rno);
	}

	@Override
	public List<ReplyVO> getList(Long bno) {
		// TODO Auto-generated method stub
		return mapper.getList(bno);
	}

}
