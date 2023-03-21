package com.increpas.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {

	public TestController() {
		// TODO Auto-generated constructor stub
		System.out.println("--TestController()--");
	}
	
	//RequestMapping(value =  "/hello.do", method = RequestMethod.GET)
	@RequestMapping("/hello.do")
	public String hello() {
		
		System.out.println("--test4.do ���� �Խ��ϴ�.--");
		return "hello"; //-> DispatcherServlet���� ���޵� �� �̸� 
	}
	
	//������ 
	
	@RequestMapping("/test.do")
	public String test(Model model) {
		//				Model : DispatcherServlet���� ���� ����� ��û 
		String msg = "�ȳ�";
		
		//model�� ���ؼ� ���޵� �����͸� DS�� request binding �����ش�.
		model.addAttribute("msg",msg);
		
		
		return "test"; // view name = test.jsp -> ViewResolver�� ���ؼ� ��θ� �ϼ��ؼ� forward�����ش�_)
	}
	
	
	@RequestMapping("/test2.do")
	public ModelAndView test2() {
		
		String msg = "Hi~ EveryOne";
		
		ModelAndView mv = new ModelAndView();
		//������ ������ : DS -> request binding�� ��Ų��.
		mv.addObject("msg",msg);
		
		//������		: DS -> ViewResolver�� ��θ� �ϼ����Ѽ� forward ��Ų��.
		mv.setViewName("test2");
		
		
		
		return mv;
	}
	
	//�����̷�Ʈ ���
	//@RequestMapping("/test3.do")
	@RequestMapping(value = "/test3.do", produces = "text/plain; charset=utf-8;")
	@ResponseBody
	public String test3() {
		
		return "�̸޼����� �ٷ� ������";
	}
	
	
	
	@RequestMapping("/test4.do")
	public String test4() {
		
		//redirect
		//���°� 
		//response.sendReirect("hello.do");
		System.out.println("--test4.do�� �����߱���--> hello.do�� redirect �մϴ�.");
		return "redirect:hello.do"; //DS�� hello.do �� redirect ��Ų��.
	}
	
	
	
	
}
