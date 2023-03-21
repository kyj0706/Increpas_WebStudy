package action;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.VisitDao;
import vo.VisitVo;

/**
 * Servlet implementation class VisitInsertAction
 */
@WebServlet("/visit/insert.do") //URL ���
public class VisitInsertAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//1.���� ���ڵ� ���� 
		request.setCharacterEncoding("utf-8");
		
		//2.�Ķ���� �޴´�.!!
		
		String name 	= request.getParameter("name");
		String content 	= request.getParameter("content").replaceAll("\n", "<br>");
		
		
		String pwd		= request.getParameter("pwd");
		
		//3.�ۼ����� IP���ϱ� 
		String ip 		= request.getRemoteAddr();
		//System.out.println(ip);
		
		//4.vo�� ����
		VisitVo vo = new VisitVo(name, content, pwd, ip);
		
		//DB�� insertó��
		int res = VisitDao.getInstance().insert(vo);
		
		
		
		

		
		//������� �̵���Ű��
		response.sendRedirect("list.do");
	}

}

