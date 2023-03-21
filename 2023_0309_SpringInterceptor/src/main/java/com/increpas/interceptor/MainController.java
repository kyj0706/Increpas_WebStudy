package com.increpas.interceptor;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("main")
public class MainController {

	@Autowired
	HttpSession session;
	
	@RequestMapping("main.do")
	public String main() {

		return "main/main";
	}
	
	
	//일반로그인 
	@RequestMapping("login.do")
	public String loggin() {
		
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("name", "김일반");
		map.put("grade", "일반");
		map.put("age", "18");
		
		//로그인정보 세션에 넣는다
		session.setAttribute("user", map);
		
		
		return "redirect:main.do";
	}
	//관리자로그인 
	@RequestMapping("login_admin.do")
	public String admin() {
		
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("name", "김관리");
		map.put("grade", "관리");
		map.put("age", "17");
		
		//로그인정보 세션에 넣는다
		session.setAttribute("user", map);
		
		
		return "redirect:main.do";
	}
	
	//성인로그인 
	@RequestMapping("login_adult.do")
	public String adult() {
		
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("name", "김성인");
		map.put("grade", "일반");
		map.put("age", "20");
		
		//로그인정보 세션에 넣는다
		session.setAttribute("user", map);
		
		
		return "redirect:main.do";
	}
	
	//로그아웃
	@RequestMapping("logout.do")
	public String logout() {
		
		session.removeAttribute("user");
		
		
		return "redirect:main.do";
	}
	
	
}
