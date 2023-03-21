package action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import annotation.RequestMapping;
import annotation.ResponseBody;

public class TestAction {

	@RequestMapping("/list.do")
	public String list(HttpServletRequest request,HttpServletResponse response) {
		
		//Book List���� ����	 
		List<String> list = new ArrayList<String>();
		list.add("Java");
		list.add("Oracle");
		list.add("JSP");
		list.add("Html");
		list.add("CSS");
		list.add("Javascript");
		
		//request binding
		request.setAttribute("list", list);
		return "list.jsp";
	}
	
	@RequestMapping("/view.do")
	public String view(HttpServletRequest request,HttpServletResponse response) {
		
		// view.do?book=Java
			String book = request.getParameter("book");
			
			String description="����?";
			
			switch(book)
			{
			   case "Java"		: description="���ӽ� ������ �������?";break;
			   case "Oracle"	: description="DB ���α׷�";break;
			   case "JSP"		: description="Java Server Page";break;
			   case "Html"		: description="HyperText Markup Languge";break;
			   case "CSS"		: description="Cascade StyleSheet";break;
			   case "Javascript": description="Browser����� ���";break;
			}
			
			//����/������ binding
			request.setAttribute("book", book);
			request.setAttribute("description", description);
					
		return "view.jsp";
	}
	
	@RequestMapping("/test.do")
	@ResponseBody
	public String json(HttpServletRequest request,HttpServletResponse response) {
		
		return "{\"result\":true}";
	}
	
}
