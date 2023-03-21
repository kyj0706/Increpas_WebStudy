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
		
		System.out.println("--test4.do 에서 왔습니다.--");
		return "hello"; //-> DispatcherServlet에게 전달된 뷰 이름 
	}
	
	//포워드 
	
	@RequestMapping("/test.do")
	public String test(Model model) {
		//				Model : DispatcherServlet에게 저장 방법을 요청 
		String msg = "안녕";
		
		//model을 통해서 전달된 데이터를 DS가 request binding 시켜준다.
		model.addAttribute("msg",msg);
		
		
		return "test"; // view name = test.jsp -> ViewResolver를 통해서 경로를 완성해서 forward시켜준다_)
	}
	
	
	@RequestMapping("/test2.do")
	public ModelAndView test2() {
		
		String msg = "Hi~ EveryOne";
		
		ModelAndView mv = new ModelAndView();
		//전달할 데이터 : DS -> request binding을 시킨다.
		mv.addObject("msg",msg);
		
		//뷰정보		: DS -> ViewResolver가 경로를 완성시켜서 forward 시킨다.
		mv.setViewName("test2");
		
		
		
		return mv;
	}
	
	//리다이렉트 방법
	//@RequestMapping("/test3.do")
	@RequestMapping(value = "/test3.do", produces = "text/plain; charset=utf-8;")
	@ResponseBody
	public String test3() {
		
		return "이메세지를 바로 음답해";
	}
	
	
	
	@RequestMapping("/test4.do")
	public String test4() {
		
		//redirect
		//여태것 
		//response.sendReirect("hello.do");
		System.out.println("--test4.do로 접속했구요--> hello.do로 redirect 합니다.");
		return "redirect:hello.do"; //DS가 hello.do 로 redirect 시킨다.
	}
	
	
	
	
}
