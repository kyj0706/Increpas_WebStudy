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
		
		//model를 통해서 request binding
		model.addAttribute("list", list);
		
		return "member/member_list";
	}
	
	@RequestMapping("insert_form.do")
	public String insert_form() {

		return "member/member_insert_form";
	}
	
	@RequestMapping("insert.do")
	public String insert(MemberVo vo) {

		int res = member_dao.insert(vo);
		
		return "redirect:login_form.do";
	}
	
	@RequestMapping("login_form.do")
	public String login_form() {

		return "member/member_login_form";
	}
	
	
	// /member/login.do?mem_id=hong&mem_pwd=1234&url=null
	@RequestMapping("login.do")
	public String login(String mem_id,String mem_pwd,
			            @RequestParam(value="url",defaultValue="empty")String url,Model model) {

		MemberVo user = member_dao.selectOne(mem_id);
		
		//아이디가 틀린경우
		if(user==null) {
			//로그인폼으로 다시접속해라
			//response.sendRedirect("login_form.do?reason=fail_id");
			
			//model(DispatcherServlet가 반환값에 따라서 용도에 맞게금 이용)
			//1.return정보가 뷰면 : request binding
			//2.return redirect면 : parameter(query)로 사용
			
			model.addAttribute("reason", "fail_id");
			model.addAttribute("url",url);
			return "redirect:login_form.do";
		}
		
		//비밀번호가 틀린경우
		if(user.getMem_pwd().equals(mem_pwd)==false) {
			//로그인폼으로 다시접속해라
			//response.sendRedirect("login_form.do?reason=fail_pwd&mem_id="+mem_id);
			model.addAttribute("reason", "fail_pwd");
			model.addAttribute("mem_id", mem_id);
			model.addAttribute("url",url);
			return "redirect:login_form.do";
		}
		//로그인 처리
		session.setAttribute("user", user);
			
		if(url.equals("empty")) {
			//메인페이지로 이동
			return "redirect:../board/list.do";
		}
		
		return "redirect:" + url;
	}
	
	@RequestMapping("logout.do")
	public String logout() {

		//로그아웃 처리
		session.removeAttribute("user");
		
		//메인페이지로 이동
		return "redirect:../board/list.do";
	}
	
	@RequestMapping(value="check_id.do")
	@ResponseBody
	public Map check_id(String mem_id) {

		MemberVo vo = member_dao.selectOne(mem_id);
		boolean bResult = false;
		
		if(vo==null)
			bResult = true;//사용가능해
		
		Map map = new HashMap();
		map.put("result", bResult);
		
		return map;
	}
	
	@RequestMapping("delete.do")
	public String delete(int mem_idx) {
		
		int res = member_dao.delete(mem_idx);
		
		//삭제한 유저가 로그인 상태면..로그아웃
		MemberVo    user    = (MemberVo) session.getAttribute("user");
		
		if(user.getMem_idx() == mem_idx) {
			
			session.removeAttribute("user");
		}
		return "redirect:list.do";
	}
	
	@RequestMapping("modify_form.do")
	public String modify_form(int mem_idx, Model model) {

		//mem_idx에 해당되는 객체 1개 가져오기
		MemberVo  vo = member_dao.selectOne(mem_idx);
				
		model.addAttribute("vo", vo);
		
		return "member/member_modify_form";
	}
	
	@RequestMapping("modify.do")
	public String modify(MemberVo vo) {

		//DB update
		int res = member_dao.update(vo);
				
		return "redirect:list.do";
	}
	
	
	
}
