package core.test2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component("bag")
@Component
//value 값을 안쓰면 클래스 이름으로 자동으로 빈을 생성해줌 !
public class Bag {
	private Book book;
	
	//생성자를 통해 값을 주입 
	
	public Bag() {
		
	}
	
	@Autowired
	public Bag(Book book) {
		this.book=book;
	}
	
	
	// --------------
	
	@Override
	public String toString() {
		return "Bag [book=" + book + "]";
	}

	// --------------
	
	//set 메소드를 통해 값을 주입 

	//@Autowired
	public void setBook(Book book) {
		this.book = book;
	}
}
