package com.increpas.interceptor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/adult/")
public class AdulltController {
	
	
	@RequestMapping("main.do")
	public String main() {

		return "adult/adult_main";
	}

}
