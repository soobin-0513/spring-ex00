package org.zerock.controller.lecture.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.controller.lecture.domain.User;

//@Controller
//@ResponseBody //모든 메소드에 붙인 과 같음

@RestController  //@Controller,@ResponseBody  2줄조합 
@RequestMapping("/rest02")
public class Ex02RestController {
	
	@RequestMapping("/sub01")
	public String method01() {
		return "response body1";
	}
	
	@RequestMapping("/sub02")
	public User method02 () {
		User user = new User();
		user.setId("korea");
		user.setAge(1);
		
		return user;
	}
	
	@RequestMapping("/sub03")
	public List<String> method03(){
		List<String> list = new ArrayList<>();
		list.add("java");
		list.add("script");
		list.add("obejcet");
		
		return list;
	}	
	
	@RequestMapping("/sub04")
	public List<User> method04() {
		List<User> list = new ArrayList<>();
		User user = new User();
		user.setId("seoul");
		user.setAge(3);

		list.add(user);
		list.add(user);
		list.add(user);


		return list;
	}
	
	@RequestMapping("/sub05")
	public String[] method05() {
		return new String[] {"java","script","soobin","heh"
		};	
		
	}
	
	@RequestMapping("/sub06")
	public Map<String,String> method06 (){
		Map<String,String> map = new HashMap< >();
		map.put("k1","V1");
		map.put("k2","V2");
		map.put("k3","V3");
		return map;
	}
	
	@RequestMapping("/sub07")
	public Map<String, User> method07() {
		Map<String, User> map = new HashMap<>();

		User user = new User();
		user.setId("korea");
		user.setAge(99);
		map.put("u1", user);
		map.put("u2", user);
		map.put("u3", user);

		return map;
	}
	
}
