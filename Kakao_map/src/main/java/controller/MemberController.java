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
		
		//model�� ���ؼ� request binding
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
		
		//���̵� Ʋ�����
		if(user==null) {
			//�α��������� �ٽ������ض�
			//response.sendRedirect("login_form.do?reason=fail_id");
			
			//model(DispatcherServlet�� ��ȯ���� ���� �뵵�� �°Ա� �̿�)
			//1.return������ ��� : request binding
			//2.return redirect�� : parameter(query)�� ���
			
			model.addAttribute("reason", "fail_id");
			model.addAttribute("url",url);
			return "redirect:login_form.do";
		}
		
		//��й�ȣ�� Ʋ�����
		if(user.getMem_pwd().equals(mem_pwd)==false) {
			//�α��������� �ٽ������ض�
			//response.sendRedirect("login_form.do?reason=fail_pwd&mem_id="+mem_id);
			model.addAttribute("reason", "fail_pwd");
			model.addAttribute("mem_id", mem_id);
			model.addAttribute("url",url);
			return "redirect:login_form.do";
		}
		//�α��� ó��
		session.setAttribute("user", user);
			
		if(url.equals("empty")) {
			//������������ �̵�
			return "redirect:../board/list.do";
		}
		
		return "redirect:" + url;
	}
	
	@RequestMapping("logout.do")
	public String logout() {

		//�α׾ƿ� ó��
		session.removeAttribute("user");
		
		//������������ �̵�
		return "redirect:../board/list.do";
	}
	
	@RequestMapping(value="check_id.do")
	@ResponseBody
	public Map check_id(String mem_id) {

		MemberVo vo = member_dao.selectOne(mem_id);
		boolean bResult = false;
		
		if(vo==null)
			bResult = true;//��밡����
		
		Map map = new HashMap();
		map.put("result", bResult);
		
		return map;
	}
	
	@RequestMapping("delete.do")
	public String delete(int mem_idx) {
		
		int res = member_dao.delete(mem_idx);
		
		//������ ������ �α��� ���¸�..�α׾ƿ�
		MemberVo    user    = (MemberVo) session.getAttribute("user");
		
		if(user.getMem_idx() == mem_idx) {
			
			session.removeAttribute("user");
		}
		return "redirect:list.do";
	}
	
	@RequestMapping("modify_form.do")
	public String modify_form(int mem_idx, Model model) {

		//mem_idx�� �ش�Ǵ� ��ü 1�� ��������
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
