package action.photo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import dao.PhotoDao;
import vo.PhotoVo;

/**
 * Servlet implementation class PhotoDetailAction
 */
@WebServlet("/photo/photo_detail.do") // URL 경로
public class PhotoDetailAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int p_idx = Integer.parseInt(request.getParameter("p_idx"));
		
		PhotoVo vo = PhotoDao.getInstance().selectOne(p_idx);
		
		JSONObject json = new JSONObject();
		json.put("p_idx", vo.getP_idx());
		json.put("p_title", vo.getP_title());
		json.put("p_content", vo.getP_content());
		json.put("p_filename", vo.getP_filename());
		json.put("p_ip", vo.getP_ip());
		json.put("p_regdate", vo.getP_regdate());
		json.put("p_modifydate", vo.getP_modifydate());
		json.put("mem_idx", vo.getMem_idx());
		
		
		//응답 
		response.setContentType("text/json; charset=utf-8;");
		response.getWriter().print(json.toString());
		
		
		
		
	}

}
