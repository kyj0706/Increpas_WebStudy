package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import annotation.RequestMapping;

public class TestController {

	
	@RequestMapping("/product/list.do")
	public String list(HttpServletRequest request, HttpServletResponse response) {
		
		return "list.jsp"; //view Á¤º¸
	}
	
}
