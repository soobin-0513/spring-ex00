package org.zerock.controller.lecture.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.controller.lecture.domain.User;

import lombok.extern.log4j.Log4j;

@Log4j
@RestController
@RequestMapping("/rest10")
public class Ex10RestController {

	private List<User> list = new ArrayList<>();
	private int like = 10;
	
	@PostMapping("/add")
	public User addUser(User user) {
		list.add(user);
		
		log.info(list);
		
		return user;
	}
	
	@GetMapping("/list")
	public List<User> list(){
		return list;
	}
	
	@PostMapping("/like")
	public Integer like() {
		like++;

		return like;
	}
	@PostMapping("/dislike")
	public Integer diselike() {
		like--;
		
		return like;
	}
	
}
