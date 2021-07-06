package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/secure")
@Log4j
public class SecureController {
	
	@GetMapping(value = "/all", produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String doAll() {
		log.info("secue all method");
		
		return "모두 접근이 가능하 경로";
	}
	
	@GetMapping(value = "/member", produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String doMemebr() {
		log.info("secure member method! ");
		return "member만 접근 가능한 경로!";
	}
	
	@GetMapping(value = "/admin", produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String doAdmin() {
		log.info("secure Admin  method! ");
		return "Admin만  접근 가능한 경로!";
	}
	
}
