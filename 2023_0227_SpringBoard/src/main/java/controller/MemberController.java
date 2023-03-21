package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import dao.MemberDao;
import vo.MemberVo;

@Controller
@RequestMapping("/member/")
public class MemberController {

	@Autowired
	HttpSession session;
	
	MemberDao member_dao;

	public void setMember_dao(MemberDao member_dao) {
		this.member_dao = member_dao;
	}

	@RequestMapping("list.do")
	public String list(Model model) {

		List<MemberVo> list = member_dao.selectList();

		// model를 통해서 request binding
		model.addAttribute("list", list);

		return "member/member_list";
	}

	// insert_form띄우기
	@RequestMapping("insert_form.do")
	public String insert_form() {

		return "member/member_insert_form";
	}

	// insert
	@RequestMapping("insert.do")
	public String insert(MemberVo vo) {

		int res = member_dao.insert(vo);

		return "redirect:login_form.do";
	}

	// login_form띄우기
	@RequestMapping("login_form.do")
	public String login_form() {

		return "member/member_login_form";
	}

	@RequestMapping("login.do")
	public String login(String mem_id, String mem_pwd, 
							@RequestParam(value = "url",defaultValue = "empty") String url, Model model) {

		MemberVo user = member_dao.selectOne(mem_id);

		// 아이디가 틀린경우
		if (user == null) {
			// response.sendRedirect("login_form.do?reason=fail_id");
			// return "redirect:login_form.do?reason=fail_id"; 스프링은 이렇게해도 되는데 좋아하지 않느다 .

			// model은 2가지 방식으로 선택적으로 쓰여진다.
			// 1. return정보가 뷰이면 : request binding
			// 2. return정보가 redirect면 : parameter(query)로 사용

			model.addAttribute("reason", "fail_id");
			model.addAttribute( "url", url);
			return "redirect:login_form.do";
		}

		// 비번을 틀린경우
		if (user.getMem_pwd().equals(mem_pwd) == false) {
			
			model.addAttribute("reason", "fail_pwd");
			model.addAttribute("mem_id", mem_id);
			model.addAttribute( "url", url);
			
			return "redirect:login_form.do";
		}
		
		//로그인처리
		session.setAttribute("user", user);
		
		if(url.equals("empty")) {
			//메인페이지로 이동
			return "redirect:../board/list.do";
		}

		return "redirect:" + url;
	}
	
	@RequestMapping("logout.do")
	public String logout() {
		
		//로그아웃처리
		session.removeAttribute("user");
		

		return "redirect:../board/list.do";
	}
	
	//아이디 중복체크
	@RequestMapping(value =  "check_id.do")
	@ResponseBody
	public Map check_id(String mem_id) {
		
		MemberVo vo = member_dao.selectOne(mem_id);
		boolean bResult = (vo == null);
		
		Map map = new HashMap();
		
		map.put("result", bResult);
		
		return map;
	}
	
	
	//회원update(수정)_form
	@RequestMapping("modify_form.do")
	public String modify_form(int mem_idx, Model model) {
		MemberVo vo = member_dao.selectOne(mem_idx);

		model.addAttribute("vo",vo);
		
		return "member/member_modify_form";
	}
	
	//회원udate(수정)
	@RequestMapping("modify.do")
	public String modify(MemberVo vo) {
	
		
		System.out.println(vo.getMem_grade());
		int res = member_dao.update(vo);
		


			return "redirect:../board/list.do";	
		
	}
	
	//회원 삭제
	@RequestMapping("delete.do")
	public String delete(int mem_idx) {
		
		int res = member_dao.delete(mem_idx);
		
		//회원 삭제시 세션값 날리기
		MemberVo user = (MemberVo) session.getAttribute("user");
		
		if(user.getMem_idx() == mem_idx) {
			session.removeAttribute("user");
		}
		
		
		return "redirect:list.do";
	}
	
	
	
	

}
