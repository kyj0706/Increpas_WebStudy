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
@WebServlet("/visit/check_pwd.do") //URL ���
public class VisitCheckPwdAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//1.�������ڵ� ���� 
		request.setCharacterEncoding("utf-8");
		
		//2.parameter�ޱ�
		int idx = Integer.parseInt(request.getParameter("idx"));
		String c_pwd = request.getParameter("c_pwd");
		
		//3.idx�� �ش�Ǵ� �Խù��� 1�� ���´�.
		VisitVo vo = VisitDao.getInstance().selectOne(idx);
		
		boolean bResult = vo.getPwd().equals(c_pwd);
		
		//Json�����ͷ� ����
		JSONObject json = new JSONObject();
		json.put("result", bResult);
		
		//����ó��
		response.setContentType("text/json; charset=utf-8;");
		response.getWriter().print(json.toString());
		
		
		
		


	}

}

