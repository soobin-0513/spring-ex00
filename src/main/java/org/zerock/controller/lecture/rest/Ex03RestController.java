package org.zerock.controller.lecture.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.domain.BoardVO;
import org.zerock.service.BoardService;

import lombok.Setter;

@RestController
@RequestMapping("/rest03")
public class Ex03RestController {

	@Setter(onMethod_ = @Autowired)
	private BoardService service;

	@GetMapping("/sub01")
	public BoardVO method01(Long bno) {
		BoardVO vo = service.get(bno);

		return vo;
	}
	
	@GetMapping("/sub02")
	public ResponseEntity<BoardVO> method02(Long bno) {
		BoardVO vo = service.get(bno);

		if (vo == null) {
			// 값이 없을 때
			return new ResponseEntity<BoardVO>(HttpStatus.NOT_FOUND);
		} else {
			// 값이 있을 때 OK
			return new ResponseEntity<BoardVO>(vo, HttpStatus.OK);
		}

	}
}