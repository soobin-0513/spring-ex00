package core.test1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App1 {
	public static void main(String[] args) {
		System.out.println("프로그램 실핼1");
		
		
		//객체 만들기 
		//Desk desk = new Desk();
		
		
		//우리가 필요한 객체를 만들어줌, 단 어떤 객체를 만들고 할건지 설명서를 만들어줘야함 .
		String path = "core/test1/core-test1.xml";
		ApplicationContext context = new ClassPathXmlApplicationContext(path);
		//desk라는 이름이있는 빈을 가지와서 객체 생성 ,  getBean은 Object
		Object o = context.getBean("desk");
		System.out.println(o);
		
		Object o2 = context.getBean("leg");
		System.err.println(o2);
		
		Object o3 = context.getBean("chair");
		System.err.println(o3);
	}
}
