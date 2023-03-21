package action.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDao;
import vo.MemberVo;

/**
 * Servlet implementation class MemberLoginAction
 */
@WebServlet("/member/login.do") //URL ���
public class MemberLoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		//member/login.do?mem_id=test2&mem_pwd=aaaa
		
		//�������ڵ� ���� 
		request.setCharacterEncoding("utf-8");
		
		//2.�Ķ���� �޾�
		String mem_id 	= request.getParameter("mem_id");
		String mem_pwd  = request.getParameter("mem_pwd");
		
		String url = request.getParameter("url");
		
		MemberVo user = MemberDao.getInstance().selectOne(mem_id);
		
		//���̵� Ʋ�����
		if(user==null) {
			response.sendRedirect("login_form.do?reason=fail_id&url="+url);
			return;
		}
		//����� Ʋ�����
		if(user.getMem_pwd().equals(mem_pwd)==false) {
			//+������ �� �Ⱦ��°� ����!
			//response.sendRedirect("login_form.do?reason=fail_pwd&mem_id="+mem_id+"&url="+url);
			//�׷��� �����͸� ���°� ����.
			
			response.sendRedirect(String.format("login_form.do?reason=fail_pwd&mem_id=%s&url=%s",mem_id,url));
			return;
		}
		
		//�α���ó��
		HttpSession session = request.getSession();
		
		session.setAttribute("user", user);
		
		
		if(url.isEmpty()==false) {
			response.sendRedirect(url);
		}else {
			
			//������������ �̵�.
			response.sendRedirect("../product/list.do");
			
		}
		
		
		
	}

}

