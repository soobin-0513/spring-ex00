package org.zerock.mapper;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.Test1VO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class Test1Tests {

	@Setter(onMethod_=@Autowired )
	private Test1Mapper mapper;

	@Test
	public void testGetlist() {
		assertNotNull(mapper);
		
		List<Test1VO> list = mapper.getList();
		
		//assertEquals(5, list.size());
		assertTrue(list.size()>0);
		
		
	}
	
	//새로운 값 넣기 
	@Test
	public void testInsert() {
		Test1VO test = new Test1VO();
		test.setName("binbin");
		test.setAge(10);
		
		//assertEquals(0, test.getId());
		
		int cnt = mapper.Tinsert(test);
		assertEquals(1, cnt);
	}
	
	//키값을 가져와서 새로운 값 넣기 
	@Test
	public void testTinsertSelectKey() {
		Test1VO test = new Test1VO();
		test.setName("binbinss");
		test.setAge(134);
		
		assertEquals(0, test.getId());
		
		int cnt = mapper.TinsertSelectKey(test);
		
		assertEquals(1, cnt);
		assertNotEquals(0, test.getId());
	}
	
	
	//값 갱신하기 
	@Test
	public void testUpdate() {
//		int id = 3;
		Test1VO test = new Test1VO();
		test.setId(4);
		test.setName("im soo");
		test.setAge(22);
		
		int cnt = mapper.Tupdate(test);
		
		assertEquals(1, cnt);
		
	}
	
	//값 삭제 
	@Test
	public void testDelete() {
		
		int cnt =mapper.Tdelete(0);
		
		assertEquals(0, cnt);
		
		Test1VO test = new Test1VO();
		test.setName("im soosoo");
		test.setAge(22);
		
		mapper.TinsertSelectKey(test);
		
		cnt = mapper.Tdelete(test.getId());
		assertEquals(1, cnt);
	}
	
}
