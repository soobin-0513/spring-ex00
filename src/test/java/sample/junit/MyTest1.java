package sample.junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

public class MyTest1 {

	@Test
	public void test() {
		//무조건 실패하는 메소드 
		//fail("Not yet implemented");
		int i = 3;
		if(i !=3 ) {
			fail("i는3이 아닙니다.");
		}
	}
	
	
	@Test
	public void equals() {
		int i = 3;
		boolean b = true;
		Object c = null;
		
		//객체x와y 일치함을 확인, x(예상 값)와 y(실제 값)가 같으면 테스트 통과 
		assertEquals(i,3);
		
		assertEquals(b,true);
		
		//(b)가 true인지 확인 
		assertTrue(b);
		
		//객체 (c) 거 null이 아닌지 확인 
		assertNotNull(c);
	}

	
	public void notEquals(){
		int i = 5;
		boolean b = false;
		Object c = new Object();
		
		assertNotEquals(i, 3);
		
		//(b)가 false 인지 확인 
		assertFalse(b);
		
		assertNotNull(c);
	}
}
