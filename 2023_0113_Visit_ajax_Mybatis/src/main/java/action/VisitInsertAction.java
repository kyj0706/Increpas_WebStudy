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
@WebServlet("/visit/insert.do") //URL 경로
public class VisitInsertAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//1.수신 인코딩 설정 
		request.setCharacterEncoding("utf-8");
		
		//2.파라미터 받는다.!!
		
		String name 	= request.getParameter("name");
		String content 	= request.getParameter("content").replaceAll("\n", "<br>");
		
		
		String pwd		= request.getParameter("pwd");
		
		//3.작성자의 IP구하기 
		String ip 		= request.getRemoteAddr();
		//System.out.println(ip);
		
		//4.vo로 포장
		VisitVo vo = new VisitVo(name, content, pwd, ip);
		
		//DB에 insert처리
		int res = VisitDao.getInstance().insert(vo);
		
		
		
		

		
		//목록으로 이동시키기
		response.sendRedirect("list.do");
	}

}

