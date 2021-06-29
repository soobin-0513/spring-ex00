package org.zerock.controller.lecture.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.controller.lecture.domain.User;

import lombok.extern.log4j.Log4j;

@Log4j
@RestController
@RequestMapping("/rest09")
public class Ex09RestController {
	@RequestMapping("/sub01")
	public User method01(String id, int age) {
		User user = new User();
		user.setId(id);
		user.setAge(age);

		return user;
	}
}
