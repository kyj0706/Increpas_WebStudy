package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SungTBDao;
import vo.SungVo;

/**
 * Servlet implementation class SungInsertAction
 */
@WebServlet("/sung/insert.do") //URL 경로
public class SungInsertAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//sung/insert.do?name=김영주&kor=100&eng=100&mat=100
		
		//1수신인코딩 설정
		request.setCharacterEncoding("utf-8");
		
		//2parameter받기
		String name = request.getParameter("name");
		int kor		= Integer.parseInt(request.getParameter("kor"));
		int eng		= Integer.parseInt(request.getParameter("eng"));
		int mat		= Integer.parseInt(request.getParameter("mat"));
		
		//3vo 감싸기
		SungVo vo = new SungVo(name, kor, eng, mat);
		
		//4DB inset
		int res= SungTBDao.getInstance().insert(vo);
		
		//5목록보기
		response.sendRedirect("list.do");
		
	}

}

