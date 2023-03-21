package action;

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

/**
 * Servlet implementation class FileUploadAction
 */
@WebServlet("/upload2.do")
public class FileUploadAction2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// /upload.do?title=제목&photo=a.jpg
		
		
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
		String filename_1="no_file";
		String filename_2="no_file";
		
		//방법1
		File f_1 = mr.getFile("photo1"); //getFile("parameter name");
		File f_2 = mr.getFile("photo2"); //getFile("parameter name");
		if(f_1 != null) {
			filename_1 = f_1.getName();
		}
		
		if(f_2 != null) {
			filename_2 = f_2.getName();
		}
		
		//방법2
		/*
		filename = mr.getOriginalFileName("photo");
		if(filename ==null) {
			filename = "no_file";
		}
		*/
		
		//String title = request.getParameter("title"); //이렇게 하면 null이 나온다
		//파라메터 정보 구하기(주의: 파일업로드시에는 mr를 이용해야한다.
		String title = mr.getParameter("title");
		
		//request binding
		request.setAttribute("title", title);
		request.setAttribute("filename_1", filename_1);
		request.setAttribute("filename_2", filename_2);
		
		//forward
		String forward_page = "result_photo2.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);

	}

}
