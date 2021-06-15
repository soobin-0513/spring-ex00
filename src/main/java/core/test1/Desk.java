package core.test1;

//import lombok.Setter;
//import lombok.ToString;

//@Setter
//@ToString
public class Desk {
	private Leg leg;

	@Override
	public String toString() {
		return "Desk [leg=" + leg + "]";
	}
	
	//생성자를 사용해서 값을 넣는방법 
	//public Desk(Leg leg) {
	//	this.leg = leg;
//	}
	
	//set메소드를 사용해서 값을 넣는 방법 .
}
