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

import org.json.JSONObject;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.PhotoDao;
import vo.PhotoVo;

/**
 * Servlet implementation class PhotoUploadAction
 */
@WebServlet("/photo/photo_upload.do") //URL 경로
public class PhotoUploadAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String web_path = "/upload/";
		String save_path = "";//"c:\\work\\upload"; //저장위치
		
		//웹경로 ->절대경로 구하는 객체
		ServletContext application= request.getServletContext(); //리퀘스트가 관장 ? 관리하는값을 줘
		save_path = application.getRealPath(web_path);
		//System.out.println(""+save_path);
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
		
		//Parameter 받기
		int p_idx = Integer.parseInt(mr.getParameter("p_idx"));
		
		//기존있던 파일 삭제 
		PhotoVo vo = PhotoDao.getInstance().selectOne(p_idx);
		File f_del = new File(save_path, vo.getP_filename());
		f_del.delete();
		
		
		//수정할 파일정보 포함 
		vo.setP_filename(p_filename);//새로 업로드된 파일명으로 수정
		
		//DB수정
		int res = PhotoDao.getInstance().update_filename(vo);
		
		//전송데이터 포장
		JSONObject json = new JSONObject();
		json.put("p_filename", p_filename);
		
		//결과전송
		response.setContentType("text/json; charset=utf-8;");
		response.getWriter().print(json.toString());;
		


	}

}

