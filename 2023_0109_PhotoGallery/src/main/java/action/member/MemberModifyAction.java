package action.member;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDao;
import vo.MemberVo;

/**
 * Servlet implementation class MemberModifyAction
 */
@WebServlet("/member/modify.do") //URL 경로
public class MemberModifyAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//modify.do?mem_idx=3&mem_name=mem_name&mem_id=mem_id&mem_pwd=mem_pwd&mem_zipcode=mem_zipcode&mem_address=mem_address&mem_grade=일반
		
		request.setCharacterEncoding("utf-8");
		
		int mem_idx 		=Integer.parseInt(request.getParameter("mem_idx"));
		String mem_name 	=request.getParameter("mem_name");
		String mem_id 		= request.getParameter("mem_id");
		String mem_pwd 		= request.getParameter("mem_pwd");
		String mem_zipcode 	=request.getParameter("mem_zipcode");
		String mem_address 	=request.getParameter("mem_address");
		String mem_grade	= request.getParameter("mem_grade");
		
		MemberVo vo = new MemberVo(mem_idx, mem_name, mem_id, mem_pwd, mem_zipcode, mem_address, mem_grade);
		
		int res = MemberDao.getInstance().update(vo);
		
		

		//forward 코드

		response.sendRedirect("list.do");

	}

}

