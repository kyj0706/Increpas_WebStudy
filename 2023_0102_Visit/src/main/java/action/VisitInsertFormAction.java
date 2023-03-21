package action;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.VisitVo;

/**
 * Servlet implementation class VisitInsertFormAction
 */
@WebServlet("/visit/insert_form.do") //URL 경로
public class VisitInsertFormAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		/*
		 * String r = request.getParameter("regdate"); System.out.println(r);
		 * 
		 * //forward 코드 VisitVo vo = new VisitVo(); String Rdate= vo.getRegdate();
		 * System.out.println(Rdate);
		 */

		String forward_page = "visit_insert_form.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);

	}

}

