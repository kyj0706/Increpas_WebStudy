package com.increpas.interceptor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/admin/")
public class AdminController {
	
	@RequestMapping(value =  "main.do", produces = "text/html; charset=utf-8;" )
	@ResponseBody
	public String main() {
		
		
		
		
		return "관리자 메인";
	}

}
