package org.zerock.controller;

import java.security.Principal;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.Criteria;
import org.zerock.domain.MemberVO;
import org.zerock.security.domain.CustomUser;
import org.zerock.service.MemberService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/member")
@Log4j
public class MemberController {
	
	@Setter(onMethod_ = @Autowired)
	private MemberService service;
	

	@RequestMapping("/login")
	public void login() {
		
	}
	
	@GetMapping("/signup")
	public void signup(Criteria cri) {
		
	}
	
	@GetMapping("/info")
	@PreAuthorize("isAuthenticated()")
	public void info(Criteria cri, Principal principal, Model model) {
		log.info(principal.getName());

		MemberVO member = service.read(principal.getName());

		model.addAttribute("member", member);
	}

	@PostMapping("/signup")
	public String signupPost(MemberVO vo, RedirectAttributes rttr) {
		log.info(vo);
		
		boolean ok = service.insert(vo);
		
		if (ok) {
			return "redirect:/board/list";
		} else {
			return "redirect:/member/signup?error";
		}
	}
	
	
	@PostMapping("/modify")
	@PreAuthorize("principal.username == #vo.userid")
	public String modify(MemberVO vo, RedirectAttributes rttr, Authentication auth, String oldPassword) {
		boolean ok = service.modify(vo, oldPassword);
		if (ok) {
			rttr.addAttribute("status", "success");
			// session의 authentication 을 수정
			CustomUser user = (CustomUser) auth.getPrincipal();
			user.setMember(vo);
		} else {
			rttr.addAttribute("status", "error");
		}
		return "redirect:/member/info";
	}
	
	@PostMapping("/remove")
	@PreAuthorize("principal.username == #vo.userid")
	public String remove(MemberVO vo, RedirectAttributes rttr, HttpServletRequest req, String oldPassword) throws ServletException {
		boolean ok = service.remove(vo, oldPassword);
		
		if(ok) {
			req.logout();
			return "redirect:/board/list";
		}else {
			rttr.addAttribute("status","error");
			return "redirect:member/info";
		}
	}
	
	
	@GetMapping("/dup")
	@ResponseBody
	public ResponseEntity<String> duplicate(String id) {
		log.info("duplicate method");

		// 서비스 일 시키고
		MemberVO vo = service.read(id);

		if (vo == null) {
			return new ResponseEntity<>("success", HttpStatus.OK);
		} else {
			return new ResponseEntity<> ("exist", HttpStatus.OK);
		}

	}
}




