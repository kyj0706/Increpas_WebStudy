package action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GuGudanAction
 */
@WebServlet("/gugudan.do")
public class GuGudanAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//요청
		// /gugudan.do?dan=5
		
		int dan = Integer.parseInt(request.getParameter("dan"));
		
		StringBuffer sb = new StringBuffer(String.format("<h4>[%d]단보기</h4>", dan));
		
		for(int i=1; i<=9; i++) {
			sb.append(String.format("%d x %d = %2d<br>", dan,i, dan*i));
		}
		
		
				
		response.setContentType("text/html; charset=utf-8;");		
		response.getWriter().print(sb.toString());
	}

}
