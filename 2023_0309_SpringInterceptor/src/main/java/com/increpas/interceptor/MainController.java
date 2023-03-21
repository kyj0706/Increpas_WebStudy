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
	
	
	//�Ϲݷα��� 
	@RequestMapping("login.do")
	public String loggin() {
		
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("name", "���Ϲ�");
		map.put("grade", "�Ϲ�");
		map.put("age", "18");
		
		//�α������� ���ǿ� �ִ´�
		session.setAttribute("user", map);
		
		
		return "redirect:main.do";
	}
	//�����ڷα��� 
	@RequestMapping("login_admin.do")
	public String admin() {
		
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("name", "�����");
		map.put("grade", "����");
		map.put("age", "17");
		
		//�α������� ���ǿ� �ִ´�
		session.setAttribute("user", map);
		
		
		return "redirect:main.do";
	}
	
	//���ηα��� 
	@RequestMapping("login_adult.do")
	public String adult() {
		
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("name", "�輺��");
		map.put("grade", "�Ϲ�");
		map.put("age", "20");
		
		//�α������� ���ǿ� �ִ´�
		session.setAttribute("user", map);
		
		
		return "redirect:main.do";
	}
	
	//�α׾ƿ�
	@RequestMapping("logout.do")
	public String logout() {
		
		session.removeAttribute("user");
		
		
		return "redirect:main.do";
	}
	
	
}
