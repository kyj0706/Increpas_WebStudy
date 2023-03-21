package action.product;

import java.io.File;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.ProductDao;
import vo.MemberVo;
import vo.ProductVo;

/**
 * Servlet implementation class ProductInsertAction
 */
@WebServlet("/product/insert.do") //URL 경로
public class ProductInsertAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		MemberVo user = (MemberVo) request.getSession().getAttribute("user");
		
		if(user==null) {
			response.sendRedirect("../member/login_form.do?reason=logout");
			
			return;
		}
		
		String web_path = "/images/";
		String save_path = "";//"c:\\work\\upload"; //저장위치
		
		//웹경로 ->절대경로 구하는 객체
		ServletContext application= request.getServletContext(); //리퀘스트가 관장 ? 관리하는값을 줘
		save_path = application.getRealPath(web_path);
		System.out.println(save_path);
		
		int    max_size  = 1024*1024*100;      //업로드최대용량:100MB
		
		//화일업로드용 파라메터처리
		MultipartRequest mr = new MultipartRequest( request,   //request위임
				                                    save_path, //저장위치
				                                    max_size,  //저장크키  
				                                    "utf-8",   //수신인코딩
				                                    //이미화일이 존재하면 이름을 변경해서 업로드
				                                    new DefaultFileRenamePolicy() 
				                                    );
		
		//업로드된 파일정보 구하기
		String p_image_s="no_file";
		String p_image_l="no_file";
				
		File f_1 = mr.getFile("p_image_s"); //getFile("parameter name");
		File f_2 = mr.getFile("p_image_l"); //getFile("parameter name");
		if(f_1 != null) {
			p_image_s = f_1.getName();
		}
		
		if(f_2 != null) {
			p_image_l = f_2.getName();
		}
		
		String category 	= mr.getParameter("category");
		String p_num		= mr.getParameter("p_num");
		String p_name		= mr.getParameter("p_name");
		String p_company 	= mr.getParameter("p_company");
		int p_price			= Integer.parseInt(mr.getParameter("p_price"));
		int p_saleprice		= Integer.parseInt(mr.getParameter("p_saleprice"));
		String p_content	= mr.getParameter("p_content").replaceAll("\n", "<br>");
		
		ProductVo vo = new ProductVo(category, p_num, p_name, p_company, p_price, p_saleprice, p_image_s, p_image_l, p_content);
		
		int res = ProductDao.getInstance().insert(vo);
		System.out.println(res);
		
		response.sendRedirect("list.do");
		
		
	}

}

