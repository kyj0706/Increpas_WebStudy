package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main/")
public class MainController {

	@RequestMapping("list.do")
	public String main_list() {
		
		

		return "main/main_list";
	}
}
