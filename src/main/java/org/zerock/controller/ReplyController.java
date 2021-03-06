package org.zerock.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.domain.ReplyVO;
import org.zerock.service.ReplyService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@RestController
@RequestMapping("/replies")
@Log4j
@AllArgsConstructor
public class ReplyController {
	
	
	//필드사용이요 ReplyService인터페이스에  ReplyServicelmpl 객체를 가져오는거 
	//	필드  타입 			필드명 
	private ReplyService service;
	
	/*
	 * @AllArgsConstructor 하는일이 똑같음 
	@Autowired
	public ReplyController(ReplyService service) {
		this.service =service;
	}
	*/
	
	
	@PostMapping("/new")
	@PreAuthorize("isAuthenticated()")//P673
	public ResponseEntity<String> create(@RequestBody ReplyVO vo){
		log.info("reply new");
//		service.register(vo);
		
		int cnt = service.register(vo);
		
		if(cnt == 1 ) {
			return new ResponseEntity<String> ("success", HttpStatus.OK);
		} else {
			return new ResponseEntity<String> (HttpStatus.INTERNAL_SERVER_ERROR);
		}	
	}
	
	
	@GetMapping("/pages/{bno}")
	public List<ReplyVO> getList(@PathVariable("bno") Long bno) {

		return service.getList(bno);
	} 
	
	
	
	
	@GetMapping("/{rno}")
	public ReplyVO get(@PathVariable Long rno) {

		log.info("댓글줘!!");
		return service.get(rno);
	}
	
	
//	@RequestMapping(value = "/{rno}", method = RequestMethod.DELETE)
	@DeleteMapping("/{rno}")
	//@PreAuthorize("isAuthenticated()")//P673
	@PreAuthorize("principal.username == #vo.replyer")
	public ResponseEntity<String> remove(@RequestBody ReplyVO vo, @PathVariable Long rno) {

		int cnt = service.remove(rno);

		if (cnt == 1) {
			return new ResponseEntity<String>("success", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
	@RequestMapping(value="/{rno}", method ={RequestMethod.PUT, RequestMethod.PATCH})
	//@PreAuthorize("isAuthenticated()")//P673
	//로그인할때만 수정할수있어  !! 책에서 작성한 방법 p720 
	@PreAuthorize("principal.username == #vo.replyer")
	public ResponseEntity<String> modify(@RequestBody ReplyVO vo, @PathVariable Long rno){
		int cnt = service.modify(vo);
		
		if (cnt == 1) {
			return new ResponseEntity<String>("success", HttpStatus.OK);
		} else {
											//오류가 생긴 코드 
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
