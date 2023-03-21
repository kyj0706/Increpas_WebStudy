package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import annotation.RequestMapping;
import annotation.ResponseBody;

public class TestAction2 {

	
	
	@RequestMapping(value="/test2.do",produces="text/json;charset=utf-8;")
	@ResponseBody
	public String json(HttpServletRequest request,HttpServletResponse response) {
		
		return "{\"result\":\"test2222\"}";
	}
	
}
