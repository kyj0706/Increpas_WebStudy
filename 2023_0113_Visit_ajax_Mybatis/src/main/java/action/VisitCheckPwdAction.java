package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import dao.VisitDao;
import vo.VisitVo;

/**
 * Servlet implementation class VisitCheckPwdAction
 */
@WebServlet("/visit/check_pwd.do") //URL 경로
public class VisitCheckPwdAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//1.수신인코딩 설벙 
		request.setCharacterEncoding("utf-8");
		
		//2.parameter받기
		int idx = Integer.parseInt(request.getParameter("idx"));
		String c_pwd = request.getParameter("c_pwd");
		
		//3.idx에 해당되는 게시물에 1건 얻어온다.
		VisitVo vo = VisitDao.getInstance().selectOne(idx);
		
		boolean bResult = vo.getPwd().equals(c_pwd);
		
		//Json데이터로 생성
		JSONObject json = new JSONObject();
		json.put("result", bResult);
		
		//응답처리
		response.setContentType("text/json; charset=utf-8;");
		response.getWriter().print(json.toString());
		
		
		
		


	}

}

