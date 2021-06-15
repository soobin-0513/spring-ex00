package core.test2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App2 {
	public static void main(String[] args) {
		System.out.println("프로그램 실행2");
		
		//설명서 사용 
		String path="core/test2/core-test2.xml";
		ApplicationContext context = new ClassPathXmlApplicationContext(path);
		
		Object o1 = context.getBean("bag");
		Object o2 = context.getBean("book");
		
		System.out.println(o1);
		System.out.println(o2);
	}
}
