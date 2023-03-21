package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//POJO(Plain Old Java Object) : 순수한 자바 객체 

public class ViewAction {

	public String execute(HttpServletRequest request, HttpServletResponse response) {

		String book = request.getParameter("book");
		String content = "";

		switch (book.toUpperCase()) {
		case "JAVA":
			content = "제임스 고슬링이 만든 언어다 초기엔 전자제품을 제어하기 위함....";
			break;
		case "ORACLE":
			content = "현존하는 DBMS중 가장 성은이 좋은 데이터베이스 프로그램이다.";
			break;
		case "HTML":
			content = "HyperText Markup Language 웹언어의 대표언어";
			break;
		case "CSS":
			content = "Cascading Style Sheets약자로 유일하게 언어는 아니다(봐라 이불이라 하지 않냐...)";
			break;
		case "JAVASCRIPT":
			content = "브라우저 제어 언어. 이벤트등 브라우저를 통제하는 언어";
			break;
		default:
			content ="이건 뭔데 ?";
			break;
		}
		
		//request binding
		request.setAttribute("book", book);
		request.setAttribute("content", content);
		
		
		return "view.jsp";
	}
}
