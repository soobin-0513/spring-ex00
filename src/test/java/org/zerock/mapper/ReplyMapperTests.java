package org.zerock.mapper;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.ReplyVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ReplyMapperTests {

	@Setter(onMethod_= @Autowired)
	private ReplyMapper mapper;
	
	@Test
	public void testMapper() {
		assertNotNull(mapper);
	}
	
	@Test
	public void testInser() {
		
		ReplyVO vo = new ReplyVO();
		vo.setReply("댓글!추가 ");
		vo.setReplyer("user00");
		vo.setBno(94L);

		int cnt = mapper.insert(vo);
		assertEquals(1, cnt);
	}
	
	@Test
	public void testRead() {
		ReplyVO vo = mapper.read(1L);

		assertEquals("댓글!추가 ", vo.getReply());
	}
	
	@Test
	public void testDelete() {
		ReplyVO vo = new ReplyVO();
		vo.setBno(94L);
		vo.setReply("댓글~한개 추가요 ~");
		vo.setReplyer("user00");
		
		mapper.insertSelectKey(vo);
		
		int cnt = mapper.delete(vo.getRno());
		
		assertEquals(1,cnt);
	}

	@Test
	public void testUpdate() {
		ReplyVO vo = mapper.read(2L);

		String re = "수정된 댓글";

		vo.setReply(re);

		assertEquals(1, mapper.update(vo));

		vo = mapper.read(2L);
		assertEquals(re, vo.getReply());

	}
	
}
