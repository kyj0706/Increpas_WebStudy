package action.photo;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.PhotoDao;
import vo.MemberVo;
import vo.PhotoVo;

/**
 * Servlet implementation class PhotoInsertAction
 */
@WebServlet("/photo/insert.do") //URL 경로
public class PhotoInsertAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//로그인 상태확인
		//세션에 보관되어 있는 로그인정보를 얻어온다.
		MemberVo user = (MemberVo) request.getSession().getAttribute("user");
		//세션이 만료가 된 경우
		if(user==null) {
			
			response.sendRedirect("../member/login_form.do?reason=logout");
			
			
			return;
		}
		
		int mem_idx = user.getMem_idx();
		
		
		String web_path = "/upload/";
		String save_path = "";//"c:\\work\\upload"; //저장위치
		
		//웹경로 ->절대경로 구하는 객체
		ServletContext application= request.getServletContext(); //리퀘스트가 관장 ? 관리하는값을 줘
		save_path = application.getRealPath(web_path);
		System.out.println(save_path);
		//실제경로
		
		
		//전역관리객체이다.
		
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
		String p_filename="no_file";
		
		//방법1
		File f = mr.getFile("photo"); //getFile("parameter name");
		if(f != null) {
			p_filename = f.getName();
		}
		
		//방법2
		/*
		filename = mr.getOriginalFileName("photo");
		if(filename ==null) {
			filename = "no_file";
		}
		*/
		
		//MultipartRequest로 했으면 무조건 MultipartRequest로 받아라
		//String title = request.getParameter("title"); //이렇게 하면 null이 나온다
		//파라메터 정보 구하기(주의: 파일업로드시에는 mr를 이용해야한다.
		String p_title = mr.getParameter("p_title");
		String p_content = mr.getParameter("p_content").replaceAll("\n", "<br>");
		
		//ip구하기(request 사용)
		String p_ip = request.getRemoteAddr();
		
		//vo로 포장 (포장하는 이유 vo로 한번에 묶에서 보내는 이유이다)
		PhotoVo vo = new PhotoVo(p_title, p_content, p_filename, p_ip, mem_idx);
		
		int res = PhotoDao.getInstance().insert(vo);
		
		response.sendRedirect("list.do");
		
		
	}

}

