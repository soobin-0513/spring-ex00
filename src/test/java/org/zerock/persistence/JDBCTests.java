package org.zerock.persistence;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

public class JDBCTests {

	@Test
	public void test() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		}catch(Exception e) {
			fail();
		}
		
		String url ="jdbc:mariadb://52.79.195.216/test";
		String user = "root";
		String password ="wnddkdwjdqhcjfl1";
		
		try(Connection con = DriverManager.getConnection(url,user,password)){
			assertNotNull(con);
		}catch (Exception e) {
			fail();
		}
	}

}
