package action.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import annotation.RequestMapping;
import annotation.ResponseBody;
import dao.UserDao;
import vo.UserVo;

public class UserController {

//ȸ����� ��ȸ
	@RequestMapping("/user/list.do")
	public String list(HttpServletRequest request, HttpServletResponse response) {

		// ȸ����� ��������
		List<UserVo> list = UserDao.getInstance().selectList();

		request.setAttribute("list", list);

		return "user_list.jsp";
	}

//ȸ������ �� ��� ����
	@RequestMapping("/user/insert_form.do")
	public String insert_form(HttpServletRequest request, HttpServletResponse response) {

		return "user_insert_form.jsp";
	}

//ȸ�������ϱ�
	@RequestMapping("/user/insert.do")
	public String insert(HttpServletRequest request, HttpServletResponse response) {

		String user_name     = request.getParameter("user_name"    );
		String user_id       = request.getParameter("user_id"      );
		String user_pw       = request.getParameter("user_pw"      );
		String user_email    = request.getParameter("user_email"   );
		String user_address1 = request.getParameter("user_address1");
		String user_address2 = request.getParameter("user_address2");
		String user_post     = request.getParameter("user_post"    );
		String user_grade    = request.getParameter("user_grade"   );
		
		System.out.println(user_grade);
		
		// 3.MemberVo ����
		UserVo vo = new UserVo(user_name , user_id      , user_pw      , 
							   user_email, user_address1, user_address2, 
							   user_post , user_grade                   );
		// 4.DB insert
		int res = UserDao.getInstance().insert(vo);
		System.out.println(res);
		return "redirect:../product/list.do";
	}

//ȸ�����̵�üũ Ajax
	@RequestMapping(value = "/user/check_id.do", produces = "text/json; charset=utf-8;")
	@ResponseBody
	public String check_pwd(HttpServletRequest request, HttpServletResponse response) {
		// 2.parameter�ޱ�
		String user_id = request.getParameter("user_id");

		// 3.id �ִ��� �˻�
		UserVo vo = UserDao.getInstance().selectOne(user_id);

		// boolean bResult = (vo == null);

		boolean bResult = false;

		if (vo == null)
			bResult = true;// ��밡��

		JSONObject json = new JSONObject();
		json.put("result", bResult);

		return json.toString();
	}

//�α��� ����� ����
	@RequestMapping("/user/login_form.do")
	public String login_form(HttpServletRequest request, HttpServletResponse response) {

		return "user_login_form.jsp";

	}

//�α����ϱ�
	@RequestMapping("/user/login.do")
	public String login(HttpServletRequest request, HttpServletResponse response) {

		// 2.parameter�ޱ�
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		System.out.println(user_id);

		// 3.idȮ��
		UserVo user = UserDao.getInstance().selectOne(user_id);

		// ���̵� Ʋ�����
		if (user == null) {
			return ("redirect:login_form.do?reason=fail_id");
		} // ����� Ʋ�����
		if (user.getUser_pw().equals(user_pw) == false) {

			return ("redirect:login_form.do?reason=fail_pwd&mem_id=" + user_id);
		}

		// �α���ó��
		HttpSession session = request.getSession();

		session.setAttribute("user", user);

		return "redirect:../product/list.do";
	}

	// �α׾ƿ�
	@RequestMapping("/user/logout.do")
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();

		session.removeAttribute("user");

		return "redirect:../product/list.do";

	}

}
