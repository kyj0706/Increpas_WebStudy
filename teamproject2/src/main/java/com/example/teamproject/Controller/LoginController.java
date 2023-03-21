package com.example.teamproject.Controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.teamproject.Service.LoginService;
import com.example.teamproject.Vo.AdminVo;
import com.example.teamproject.Vo.FmanagerVo;
import com.example.teamproject.Vo.MemberVo;

@Controller
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	

	//인덱스 페이지
	@GetMapping("index")
	public String index() {
		return "/index";
	}
	
	//로그아웃
	@GetMapping("logout")
	public String logout() {
		return "/logout";
	}

	//로그인페이지 이동
	@GetMapping("login")
	public String login_page() {
		return "/login/login_page";
	}
	
	//회원 로그인페이지 이동
	@PostMapping("login_member")
	public String login_member(@RequestParam (value = "id") String M_ID,
			@RequestParam (value = "pw") String M_PW,
			HttpServletRequest request
			) {
		HttpSession session = request.getSession();
		
		
		MemberVo memberVo = loginService.member_login_check(M_ID,M_PW);
		
		
		if(memberVo != null) {
		session.setAttribute("session_id", memberVo.getM_id());
		session.setAttribute("session_nick", memberVo.getM_nickname());
		session.setAttribute("session_no", memberVo.getM_no());
		session.setAttribute("session_member", "member");
		}else {
			session.setAttribute("session_member", "fail");	
		}
		return "/index";
	}
	
	//시설 로그인페이지 이동
	@PostMapping("login_fac")
	public String login_fac(@RequestParam (value = "id") String FM_ID,
			@RequestParam (value = "pw") String FM_PW,
			HttpServletRequest request) {
		HttpSession session = request.getSession();

		
		FmanagerVo fmanagerVo = loginService.Fmanager_login_check(FM_ID,FM_PW);

		
		if(fmanagerVo != null) {
		session.setAttribute("session_id", fmanagerVo.getFm_id());
		session.setAttribute("session_name", fmanagerVo.getFm_name());
		session.setAttribute("session_no", fmanagerVo.getFm_no());
		session.setAttribute("session_member", "seller");
		}else {
			session.setAttribute("session_member", "fail");	
		}
		return "/index";
	}

	//회원가입 이동
	@GetMapping("Sign_up_form")
	public String Sign_up_form() {
		return "/login/Sign_up_form";
	}
	
	
	//회원 회원가입
	@PostMapping("register_member")
	public String register_member(MemberVo memberVo,
			Model model
			) {
		System.out.println(memberVo.getM_id());
		int result = loginService.member_register_check(memberVo);
		
		model.addAttribute("result", result);
		
		return "/login/login_page";
	}
	
	
	
	  //시설관리자 회원가입
	 
	  @PostMapping("register_fac") public String register_fac(FmanagerVo
	  fmanagerVo, Model model ) {
		  System.out.println("값");
	  System.out.println(fmanagerVo.getFm_id());
	  int result = loginService.fac_register_check(fmanagerVo);
	  
	  model.addAttribute("result1", result);
	  
	  return "/login/login_page"; 
	  }
	
	//아이디 찾기 이동
	@GetMapping("Find")
	public String Find() {
		return "/login/find";
	}
	
	//비밀번호 찾기 이동
	@GetMapping("Find_PW")
	public String Find_PW() {
		return "/login/find_pw";
	}
	
	//회원 아이디 찾기
	@PostMapping("find_member")
	public String Find_member(@RequestParam (value = "nick") String m_nickname,
			@RequestParam (value = "email") String m_email,
			Model model
			) {
		
		MemberVo memberVo = loginService.member_ld_find_check(m_nickname,m_email);
		
		if(memberVo != null) {
			model.addAttribute("find_nick", memberVo.getM_nickname());
			model.addAttribute("find_id", memberVo.getM_id());
			model.addAttribute("find_check", "success");
		}else {
			model.addAttribute("find_check", "fail");
		}
		
		return "/login/find_check";
	}
	
	//시설 관리자 아이디 찾기
	@PostMapping("find_fmanager")
	public String Find_fac(@RequestParam (value = "name") String FM_NAME,
			@RequestParam (value = "phone") String FM_PHONE,
			Model model
			) {
		
		FmanagerVo fmanagerVo = loginService.fac_ld_find_check(FM_NAME,FM_PHONE);
		if(fmanagerVo != null) {
			model.addAttribute("find_nick",fmanagerVo.getFm_name());
			model.addAttribute("find_id", fmanagerVo.getFm_id());
			model.addAttribute("find_check", "success");
		}else {
			model.addAttribute("find_check", "fail");
		}
		return "/login/find_check";
	}

	//회원 비밀번호 찾기
	@PostMapping("find_member_pw")
	public String Find_member_pw(@RequestParam (value = "m_id") String m_id,
			@RequestParam (value = "m_email") String m_email,
			Model model
			) {
		MemberVo memberVo = loginService.member_pw_find_check(m_id,m_email);
		
		if(memberVo != null) {
			model.addAttribute("find_nick", memberVo.getM_nickname());
			model.addAttribute("find_pw", memberVo.getM_pw());
			model.addAttribute("find_check_pw", "success");
		}else {
			model.addAttribute("find_check_pw", "fail");
		}
		
		return "/login/find_check";
	}
	
	
	//시설 비밀번호 찾기
	@PostMapping("find_fmanager_pw")
	public String find_fmanager_pw(@RequestParam (value = "id") String FM_ID,
			@RequestParam (value = "phone") String FM_PHONE,
			Model model
			) {
		System.out.println(FM_PHONE);
		FmanagerVo fmanagerVo = loginService.fac_pw_find_check(FM_ID,FM_PHONE);
		
		if(fmanagerVo != null) {
			model.addAttribute("find_nick", fmanagerVo.getFm_id());
			model.addAttribute("find_pw", fmanagerVo.getFm_pw());
			model.addAttribute("find_check_pw", "success");
		}else {
			model.addAttribute("find_check_pw", "fail");
		}
		
		return "/login/find_check";
	}
	
	//관리자 로그인페이지 이동
	@GetMapping("admin_login")
	public String admin_login() {
		return "/login/admin_login";
	}
	
	//관리자 로그인
	@PostMapping("admin_login")
	public String admin_login(@RequestParam (value = "admin_id") String a_id,
			@RequestParam (value = "admin_pw") String a_pw,
			HttpServletRequest request
			) {
		HttpSession session = request.getSession();
		
		System.out.println("값"+a_id);
		
		AdminVo adminVo = loginService.admin_login(a_id,a_pw);

		if(adminVo != null) {
			
			session.setAttribute("session_member", "admin");
			session.setAttribute("session_id", adminVo.getA_id());
			
		}else {
			session.setAttribute("session_member", "fail");
		}
		
		return "/index";
	}
	
	//회원 아이디 중복검사
	@PostMapping("/id_check")
	@ResponseBody
	public Map<String, Object> id_check(@RequestParam (value = "id_check") String m_id) {
		Map<String, Object> map = new HashMap<String, Object>();
		System.out.println("아이디");
		System.out.println(m_id);
		int check = 0;
		MemberVo memberVo = new MemberVo();
		
		memberVo = loginService.member_id_check(m_id);
		System.out.println(memberVo);
		if(memberVo != null) {
			map.put("check", check);
		}else {
			check = 1;
			map.put("check", check);
			map.put("m_id", m_id);
		}
		
		return map;
	}
	
	//시설관리자 아이디 중복검사
	@PostMapping("/fm_id_check")
	@ResponseBody
	public Map<String, Object> fm_id_check(@RequestParam (value = "fm_id") String fm_id) {
		Map<String, Object> map = new HashMap<String, Object>();
		System.out.println("아이디");
		System.out.println(fm_id);
		int check = 0;
		FmanagerVo fmanagerVo = new FmanagerVo();
		
		fmanagerVo = loginService.fmanager_id_check(fm_id);
		System.out.println(fmanagerVo);
		if(fmanagerVo != null) {
			map.put("check", check);
		}else {
			check = 1;
			map.put("check", check);
			map.put("fm_id", fm_id);
		}
		
		return map;
	}
	

	//이메일 인증 페이지
	@RequestMapping("email")
	public String email() {
		return "/login/email";
	}
}