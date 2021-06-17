package org.zerock.controller.lecture;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/ex05/*")
public class Ex05Controller {

	@RequestMapping("/sub01")
	public void method01(@DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
		log.info("ex05, sub01 method");
		log.info(date);
	}
}