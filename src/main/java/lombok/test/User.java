package lombok.test;

import lombok.Getter;
import lombok.Setter;

public class User {
	
	
	@Getter
	private String name;
	
	@Getter
	private String nick;
	
	@Getter
	@Setter
	private boolean loggedIn;
}
