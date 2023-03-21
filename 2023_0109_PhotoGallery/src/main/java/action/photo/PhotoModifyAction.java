package action.photo;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PhotoDao;
import vo.PhotoVo;

/**
 * Servlet implementation class PhotoModifyAction
 */
@WebServlet("/photo/modify.do") //URL ���
public class PhotoModifyAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		///photo/modify.do?p_idx=6&p_title=����̴�&p_content=�̳༮��+%0D%0A��Ĺ��+����̷�%0D%0A����̴�
		request.setCharacterEncoding("utf-8");
		
		int p_idx = Integer.parseInt(request.getParameter("p_idx"));
		String p_title = request.getParameter("p_title");
		String p_content = request.getParameter("p_content").replaceAll("\n", "<br>");
		
		//ip�ޱ�
		String p_ip = request.getRemoteAddr();
		
		//����
		PhotoVo vo = new PhotoVo(p_idx, p_title, p_content, p_ip);
		
		int res = PhotoDao.getInstance().update(vo);
		
		response.sendRedirect("list.do");

	}

}

