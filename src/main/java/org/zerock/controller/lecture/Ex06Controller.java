package org.zerock.controller.lecture;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/ex06/*")
public class Ex06Controller {

	@RequestMapping("/sub01")
	public String method01() {
		log.info("ex06, sub01 method");

		/*
		request.getRequestDispatcher("/WEB-INF/viewsex06/sub01.jsp).forward(request, response);
		*/
		return "ex06/sub01";
		

		// /WEB-INF/views/ex06/sub01.jsp
	}
	
	
	@RequestMapping("/sub02")
	public void method02() {
		
		log.info("ex06, sub02 method2");
	}
	
	
	@RequestMapping("/sub03")
	public String method03() {
		log.info("ex06, sub03 method3");
		
		return"forward:/ex06/sub02";
	}
	
	@RequestMapping("/sub04")
	public String method04() {
		log.info("ex06, sub04 method04");
		
		return"redirect:/ex06/sub02";
	}
	
	
}