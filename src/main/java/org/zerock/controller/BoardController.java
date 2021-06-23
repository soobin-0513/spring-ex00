package org.zerock.controller;


import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVO;
import org.zerock.service.BoardService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/board/*")
@AllArgsConstructor
@Log4j
public class BoardController {
	
	private BoardService service;
	
		/*
		 @Autowired
		public BoardController(BoardService service) {
			this.service = service;
		}
			 
		 */
	@GetMapping("/list")
	public void list(Model model) {
		log.info("board/list method.....");
		
		// service getList() 실행 결과를
		List<BoardVO> list = service.getList();
		// model에 attribute로 넣고
		model.addAttribute("list",list);
		// view로 포워드
	}
	
	@PostMapping("/register")
	public String register(BoardVO board, RedirectAttributes rttr) {
		
		//service에게 등록업무 시키고 
		service.register(board); //title, content, writer
		
		// redirect목적지로 정보 전달
		rttr.addFlashAttribute("result", board.getBno());
		rttr.addFlashAttribute("messageTitle", "등록 성공");
		rttr.addFlashAttribute("messageBody", board.getBno() + "번 게시물 등록 되었습니다.");

		// /board/list redirect
		return "redirect:/board/list";
		
	}
	
	@GetMapping({"/get","/modify"})
	public void get(@RequestParam("bno") Long bno, Model model ){
		
		log.info("board/get method");
		
		//service에게 일 시킴
		BoardVO vo = service.get(bno);
		
		//결과를 모델에 넣음 
		model.addAttribute("board",vo);
		
		//forward
		
		
	}
	
	@PostMapping("/modify")
	public String modify(BoardVO board, RedirectAttributes rttr) {
		//	request parameter 수집 
		
		// service 일 시킴
		boolean success = service.modify(board);

		// 결과를 모델(또는 FlashMap)에 넣고
		if (success) {
			rttr.addFlashAttribute("result", "success");
			rttr.addFlashAttribute("messageTitle", "수정 성공");
			rttr.addFlashAttribute("messageBody", "수정 되었습니다.");
			
		}

		// forward or redirect
		return "redirect:/board/list";
		
	}
	
	
	@PostMapping("/remove")
	public String remove(@RequestParam("bno")Long bno, RedirectAttributes rttr) {
		//		request parameter 수집 
		
		// service 일
				boolean success = service.remove(bno);
				// 결과 담고
				if (success) {
					rttr.addFlashAttribute("result", "success");
					rttr.addFlashAttribute("messageTitle", "삭제 성공");
					rttr.addFlashAttribute("messageBody", "삭제 되었습니다.");
				}

				// forward or redirect
				return "redirect:/board/list";
			
	}
	
	@GetMapping("/register")
	public void register() {
		// forward /WEB-INF/views/board/register.jsp
	}
	
	
}
