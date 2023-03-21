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

		// model�� ���ؼ� request binding
		model.addAttribute("list", list);

		return "member/member_list";
	}

	// insert_form����
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

	// login_form����
	@RequestMapping("login_form.do")
	public String login_form() {

		return "member/member_login_form";
	}

	@RequestMapping("login.do")
	public String login(String mem_id, String mem_pwd, 
							@RequestParam(value = "url",defaultValue = "empty") String url, Model model) {

		MemberVo user = member_dao.selectOne(mem_id);

		// ���̵� Ʋ�����
		if (user == null) {
			// response.sendRedirect("login_form.do?reason=fail_id");
			// return "redirect:login_form.do?reason=fail_id"; �������� �̷����ص� �Ǵµ� �������� �ʴ��� .

			// model�� 2���� ������� ���������� ��������.
			// 1. return������ ���̸� : request binding
			// 2. return������ redirect�� : parameter(query)�� ���

			model.addAttribute("reason", "fail_id");
			model.addAttribute( "url", url);
			return "redirect:login_form.do";
		}

		// ����� Ʋ�����
		if (user.getMem_pwd().equals(mem_pwd) == false) {
			
			model.addAttribute("reason", "fail_pwd");
			model.addAttribute("mem_id", mem_id);
			model.addAttribute( "url", url);
			
			return "redirect:login_form.do";
		}
		
		//�α���ó��
		session.setAttribute("user", user);
		
		if(url.equals("empty")) {
			//������������ �̵�
			return "redirect:../board/list.do";
		}

		return "redirect:" + url;
	}
	
	@RequestMapping("logout.do")
	public String logout() {
		
		//�α׾ƿ�ó��
		session.removeAttribute("user");
		

		return "redirect:../board/list.do";
	}
	
	//���̵� �ߺ�üũ
	@RequestMapping(value =  "check_id.do")
	@ResponseBody
	public Map check_id(String mem_id) {
		
		MemberVo vo = member_dao.selectOne(mem_id);
		boolean bResult = (vo == null);
		
		Map map = new HashMap();
		
		map.put("result", bResult);
		
		return map;
	}
	
	
	//ȸ��update(����)_form
	@RequestMapping("modify_form.do")
	public String modify_form(int mem_idx, Model model) {
		MemberVo vo = member_dao.selectOne(mem_idx);

		model.addAttribute("vo",vo);
		
		return "member/member_modify_form";
	}
	
	//ȸ��udate(����)
	@RequestMapping("modify.do")
	public String modify(MemberVo vo) {
	
		
		System.out.println(vo.getMem_grade());
		int res = member_dao.update(vo);
		


			return "redirect:../board/list.do";	
		
	}
	
	//ȸ�� ����
	@RequestMapping("delete.do")
	public String delete(int mem_idx) {
		
		int res = member_dao.delete(mem_idx);
		
		//ȸ�� ������ ���ǰ� ������
		MemberVo user = (MemberVo) session.getAttribute("user");
		
		if(user.getMem_idx() == mem_idx) {
			session.removeAttribute("user");
		}
		
		
		return "redirect:list.do";
	}
	
	
	
	

}
