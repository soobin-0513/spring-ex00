package core.test3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		String path = "core/test3/core-test3.xml";
		ApplicationContext context = new ClassPathXmlApplicationContext(path);

		Hero hero = context.getBean("hero", Hero.class);

		System.out.println(hero);
		System.out.println(hero.getSword());

		System.out.println("프로그램 종료.");
		
		
		//Object o1 = context.getBean("hero");
		//System.out.println(o1);
		
	}
}	
