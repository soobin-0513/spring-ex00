package org.zerock.persistence;

import static org.junit.Assert.*;

import java.sql.Connection;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

//sprin test에 컨텍스트 프레임워크 JUnit 확장기능 지정 
@RunWith(SpringJUnit4ClassRunner.class)

//(*****)여기있는 설명서를 사용하겠다 
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")

@Log4j
public class DateSourceTests {

		
	@Setter(onMethod_= {@Autowired} )
	private DataSource dataSource;
	
	@Test
	public void testConnection() {
		assertNotNull(dataSource);
		try(Connection con = dataSource.getConnection()){
			assertNotNull(con);
		}catch(Exception e) {
			fail(e.getMessage());
		}
	}

}
