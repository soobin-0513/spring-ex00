package core.test3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Hero {

	private Sword sword;
	
	@Autowired
	@Qualifier("waterSword")
	public void setSword(Sword sword) {
		this.sword = sword;
	}
	
	public Sword getSword() {
		return sword;
	}
}
