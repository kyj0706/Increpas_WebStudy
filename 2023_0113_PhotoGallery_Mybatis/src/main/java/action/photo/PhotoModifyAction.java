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
@WebServlet("/photo/modify.do") //URL 경로
public class PhotoModifyAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		///photo/modify.do?p_idx=6&p_title=고양이다&p_content=이녀석은+%0D%0A톰캣의+고양이로%0D%0A톰양이다
		request.setCharacterEncoding("utf-8");
		
		int p_idx = Integer.parseInt(request.getParameter("p_idx"));
		String p_title = request.getParameter("p_title");
		String p_content = request.getParameter("p_content").replaceAll("\n", "<br>");
		
		//ip받기
		String p_ip = request.getRemoteAddr();
		
		//포장
		PhotoVo vo = new PhotoVo(p_idx, p_title, p_content, p_ip);
		
		int res = PhotoDao.getInstance().update(vo);
		
		response.sendRedirect("list.do");

	}

}

