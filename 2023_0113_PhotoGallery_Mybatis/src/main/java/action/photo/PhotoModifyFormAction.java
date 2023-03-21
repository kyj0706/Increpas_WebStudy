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
 * Servlet implementation class PhotoModifyFormAction
 */
@WebServlet("/photo/modify_form.do") //URL 경로
public class PhotoModifyFormAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// /photo/modify_form.do?p_idx=6
		
		int p_idx = Integer.parseInt(request.getParameter("p_idx"));
		
		PhotoVo vo = PhotoDao.getInstance().selectOne(p_idx);
		
		String p_content = vo.getP_content().replaceAll("<br>", "\n");
		vo.setP_content(p_content);
		
		
		
		//request Binding
		request.setAttribute("vo", vo);
		
		//forward 코드

		String forward_page = "photo_modify_form.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);

	}

}

