package action.photo;

import java.io.File;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PhotoDao;
import vo.PhotoVo;

/**
 * Servlet implementation class PhotoDeleteAction
 */
@WebServlet("/photo/delete.do") //URL 경로
public class PhotoDeleteAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int p_idx = Integer.parseInt(request.getParameter("p_idx"));
		//String p_filename = request.getParameter("p_filename");
		
		/*
		 * String web_path = "/upload/"; String save_path = "";//"c:\\work\\upload";
		 * //저장위치
		 * 
		 * //웹경로 ->절대경로 구하는 객체 ServletContext application= request.getServletContext();
		 * //리퀘스트가 관장 ? 관리하는값을 줘 save_path = application.getRealPath(web_path);
		 * System.out.println(save_path);
		 */
		
		String save_path =request.getServletContext().getRealPath("/upload");
		//upload 사진 삭제
		PhotoVo vo = PhotoDao.getInstance().selectOne(p_idx);
		
		File f = new File(save_path, vo.getP_filename());
		
		f.delete();
		
		
	
		 
		
		
		int res = PhotoDao.getInstance().delete(p_idx);
		
		
		response.sendRedirect("list.do");
		
		

	}

}

