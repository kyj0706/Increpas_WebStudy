package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//POJO(Plain Old Java Object) : ������ �ڹ� ��ü 

public class ViewAction {

	public String execute(HttpServletRequest request, HttpServletResponse response) {

		String book = request.getParameter("book");
		String content = "";

		switch (book.toUpperCase()) {
		case "JAVA":
			content = "���ӽ� ������ ���� ���� �ʱ⿣ ������ǰ�� �����ϱ� ����....";
			break;
		case "ORACLE":
			content = "�����ϴ� DBMS�� ���� ������ ���� �����ͺ��̽� ���α׷��̴�.";
			break;
		case "HTML":
			content = "HyperText Markup Language ������� ��ǥ���";
			break;
		case "CSS":
			content = "Cascading Style Sheets���ڷ� �����ϰ� ���� �ƴϴ�(���� �̺��̶� ���� �ʳ�...)";
			break;
		case "JAVASCRIPT":
			content = "������ ���� ���. �̺�Ʈ�� �������� �����ϴ� ���";
			break;
		default:
			content ="�̰� ���� ?";
			break;
		}
		
		//request binding
		request.setAttribute("book", book);
		request.setAttribute("content", content);
		
		
		return "view.jsp";
	}
}
