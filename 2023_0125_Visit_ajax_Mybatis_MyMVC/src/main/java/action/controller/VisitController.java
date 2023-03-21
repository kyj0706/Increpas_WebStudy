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
		// 2.파라미터 받기
		String search = request.getParameter("search");
		String search_text = request.getParameter("search_text");

		if (search == null)
			search = "all";

		// 검색조건을 담을 map
		Map<String, String> map = new HashMap<String, String>();

		if (search.equals("name_content")) {
			// 이름+내용
			map.put("name", search_text);
			map.put("content", search_text);
		} else if (search.equals("name")) {
			// 이름
			map.put("name", search_text);
		} else if (search.equals("content")) {
			// 내용
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

	// 등록 form 띄우기
	@RequestMapping("/visit/insert_form.do")
	public String insert_form(HttpServletRequest request, HttpServletResponse response) {

		return "visit_insert_form.jsp";
	}

	// 등록 하기
	@RequestMapping("/visit/insert.do")
	public String insert(HttpServletRequest request, HttpServletResponse response) {
		// 2.파라미터 받는다.!!

		String name = request.getParameter("name");
		String content = request.getParameter("content").replaceAll("\n", "<br>");

		String pwd = request.getParameter("pwd");

		// 3.작성자의 IP구하기
		String ip = request.getRemoteAddr();
		// System.out.println(ip);

		// 4.vo로 포장
		VisitVo vo = new VisitVo(name, content, pwd, ip);

		// DB에 insert처리
		int res = VisitDao.getInstance().insert(vo);

		return "redirect:list.do"; // FrontContriller에게 redirect정보 전달
									// redirect(접두어)를빼고 response.sendRedirect("list.do")를 한다.
	}

	// 비밀번호체크하기
	@RequestMapping(value = "/visit/check_pwd.do", produces = "text/json; charset=utf-8;")
	@ResponseBody
	public String check_pwd(HttpServletRequest request, HttpServletResponse response) {

		// 2.parameter받기
		int idx = Integer.parseInt(request.getParameter("idx"));
		String c_pwd = request.getParameter("c_pwd");

		// 3.idx에 해당되는 게시물에 1건 얻어온다.
		VisitVo vo = VisitDao.getInstance().selectOne(idx);

		boolean bResult = vo.getPwd().equals(c_pwd);

		// Json데이터로 생성
		JSONObject json = new JSONObject();
		json.put("result", bResult);

		return json.toString();
	}

	// 삭제하기
	@RequestMapping("/visit/delete.do")
	public String delete(HttpServletRequest request, HttpServletResponse response) {

		int idx = Integer.parseInt(request.getParameter("idx"));

		int res = VisitDao.getInstance().delete(idx);

		return "redirect:list.do";
	}

	// 수정 form띄우기
	@RequestMapping("/visit/modify_form.do")
	public String modify_form(HttpServletRequest request, HttpServletResponse response) {

		int idx = Integer.parseInt(request.getParameter("idx"));

		VisitVo vo = VisitDao.getInstance().selectOne(idx);
		// content에 <br> -> \n로 변환
		String content = vo.getContent().replaceAll("<br>", "\n");
		vo.setContent(content);

		request.setAttribute("vo", vo);
		return "visit_modify_form.jsp";
	}

	// 수정하기
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
