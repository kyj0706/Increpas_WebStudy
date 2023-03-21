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
@WebServlet("/sung/insert.do") //URL ���
public class SungInsertAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//sung/insert.do?name=�迵��&kor=100&eng=100&mat=100
		
		//1�������ڵ� ����
		request.setCharacterEncoding("utf-8");
		
		//2parameter�ޱ�
		String name = request.getParameter("name");
		int kor		= Integer.parseInt(request.getParameter("kor"));
		int eng		= Integer.parseInt(request.getParameter("eng"));
		int mat		= Integer.parseInt(request.getParameter("mat"));
		
		//3vo ���α�
		SungVo vo = new SungVo(name, kor, eng, mat);
		
		//4DB inset
		int res= SungTBDao.getInstance().insert(vo);
		
		//5��Ϻ���
		response.sendRedirect("list.do");
		
	}

}

