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
@WebServlet("/photo/delete.do") //URL ���
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
		 * //������ġ
		 * 
		 * //����� ->������ ���ϴ� ��ü ServletContext application= request.getServletContext();
		 * //������Ʈ�� ���� ? �����ϴ°��� �� save_path = application.getRealPath(web_path);
		 * System.out.println(save_path);
		 */
		
		String save_path =request.getServletContext().getRealPath("/upload");
		//upload ���� ����
		PhotoVo vo = PhotoDao.getInstance().selectOne(p_idx);
		
		File f = new File(save_path, vo.getP_filename());
		
		f.delete();
		
		
	
		 
		
		
		int res = PhotoDao.getInstance().delete(p_idx);
		
		
		response.sendRedirect("list.do");
		
		

	}

}

