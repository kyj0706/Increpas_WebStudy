package action.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import annotation.RequestMapping;
import annotation.ResponseBody;
import dao.VisitDao;
import vo.VisitVo;

public class VisitController {

	@RequestMapping("/visit/list.do")
	public String list(HttpServletRequest request, HttpServletResponse response) {
		// 2.�Ķ���� �ޱ�
		String search = request.getParameter("search");
		String search_text = request.getParameter("search_text");

		if (search == null)
			search = "all";

		// �˻������� ���� map
		Map<String, String> map = new HashMap<String, String>();

		if (search.equals("name_content")) {
			// �̸�+����
			map.put("name", search_text);
			map.put("content", search_text);
		} else if (search.equals("name")) {
			// �̸�
			map.put("name", search_text);
		} else if (search.equals("content")) {
			// ����
			map.put("content", search_text);
		} else if (search.equals("modifydate")) {
			map.put("modifydate", search_text);
		} else if (search.equals("all")) {
			map.put("all", search_text);
		}

		List<VisitVo> list = VisitDao.getInstance().selectList(map);

		request.setAttribute("list", list);

		return "visit_list.jsp";
	}

	// ��� form ����
	@RequestMapping("/visit/insert_form.do")
	public String insert_form(HttpServletRequest request, HttpServletResponse response) {

		return "visit_insert_form.jsp";
	}

	// ��� �ϱ�
	@RequestMapping("/visit/insert.do")
	public String insert(HttpServletRequest request, HttpServletResponse response) {
		// 2.�Ķ���� �޴´�.!!

		String name = request.getParameter("name");
		String content = request.getParameter("content").replaceAll("\n", "<br>");

		String pwd = request.getParameter("pwd");

		// 3.�ۼ����� IP���ϱ�
		String ip = request.getRemoteAddr();
		// System.out.println(ip);

		// 4.vo�� ����
		VisitVo vo = new VisitVo(name, content, pwd, ip);

		// DB�� insertó��
		int res = VisitDao.getInstance().insert(vo);

		return "redirect:list.do"; // FrontContriller���� redirect���� ����
									// redirect(���ξ�)������ response.sendRedirect("list.do")�� �Ѵ�.
	}

	// ��й�ȣüũ�ϱ�
	@RequestMapping(value = "/visit/check_pwd.do", produces = "text/json; charset=utf-8;")
	@ResponseBody
	public String check_pwd(HttpServletRequest request, HttpServletResponse response) {

		// 2.parameter�ޱ�
		int idx = Integer.parseInt(request.getParameter("idx"));
		String c_pwd = request.getParameter("c_pwd");

		// 3.idx�� �ش�Ǵ� �Խù��� 1�� ���´�.
		VisitVo vo = VisitDao.getInstance().selectOne(idx);

		boolean bResult = vo.getPwd().equals(c_pwd);

		// Json�����ͷ� ����
		JSONObject json = new JSONObject();
		json.put("result", bResult);

		return json.toString();
	}

	// �����ϱ�
	@RequestMapping("/visit/delete.do")
	public String delete(HttpServletRequest request, HttpServletResponse response) {

		int idx = Integer.parseInt(request.getParameter("idx"));

		int res = VisitDao.getInstance().delete(idx);

		return "redirect:list.do";
	}

	// ���� form����
	@RequestMapping("/visit/modify_form.do")
	public String modify_form(HttpServletRequest request, HttpServletResponse response) {

		int idx = Integer.parseInt(request.getParameter("idx"));

		VisitVo vo = VisitDao.getInstance().selectOne(idx);
		// content�� <br> -> \n�� ��ȯ
		String content = vo.getContent().replaceAll("<br>", "\n");
		vo.setContent(content);

		request.setAttribute("vo", vo);
		return "visit_modify_form.jsp";
	}

	// �����ϱ�
	@RequestMapping("/visit/modify.do")
	public String modify(HttpServletRequest request, HttpServletResponse response) {
		int idx = Integer.parseInt(request.getParameter("idx"));
		String name = request.getParameter("name");
		String content = request.getParameter("content").replaceAll("\n", "<br>");
		String pwd = request.getParameter("pwd");
		String ip = request.getRemoteAddr();

		VisitVo vo = new VisitVo(idx, name, content, pwd, ip);

		int res = VisitDao.getInstance().update(vo);
		return "redirect:list.do#v_" + idx;
		
	}
}
