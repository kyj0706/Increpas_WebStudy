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

import dao.C_memberDao;
import vo.C_memberVo;

@Controller
@RequestMapping("/c_member/")
public class C_memberController {

	@Autowired
	HttpSession session;
	
	C_memberDao c_member_dao;

	public void setMember_dao(C_memberDao c_member_dao) {
		this.c_member_dao = c_member_dao;
	}
	
	@RequestMapping("list.do")
	public String list(Model model) {

		List<C_memberVo> list = c_member_dao.selectList();
		
		//model�� ���ؼ� request binding
		model.addAttribute("list", list);
		
		return "c_member/c_member_list";
	}
	
	@RequestMapping("insert_form.do")
	public String insert_form() {

		return "c_member/c_member_insert_form";
	}
	
	@RequestMapping("insert.do")
	public String insert(C_memberVo vo) {

		int res = c_member_dao.insert(vo);
		
		return "redirect:login_form.do";
	}
	
	@RequestMapping("login_form.do")
	public String login_form() {

		return "c_member/c_member_login_form";
	}
	
	
	// /member/login.do?mem_id=hong&mem_pwd=1234&url=null
	@RequestMapping("login.do")
	public String login(String c_mem_id,String c_mem_pwd,
			            @RequestParam(value="url",defaultValue="empty")String url,Model model) {

		C_memberVo user = c_member_dao.selectOne(c_mem_id);
		
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
		if(user.getC_mem_pwd().equals(c_mem_pwd)==false) {
			//�α��������� �ٽ������ض�
			//response.sendRedirect("login_form.do?reason=fail_pwd&mem_id="+mem_id);
			model.addAttribute("reason", "fail_pwd");
			model.addAttribute("c_mem_id", c_mem_id);
			model.addAttribute("url",url);
			return "redirect:login_form.do";
		}
		//�α��� ó��
		session.setAttribute("user", user);
			
		if(url.equals("empty")) {
			//������������ �̵�
			return "redirect:list.do";
		}
		
		return "redirect:" + url;
	}
	
	@RequestMapping("logout.do")
	public String logout() {

		//�α׾ƿ� ó��
		session.removeAttribute("user");
		
		//������������ �̵�
		return "redirect:list.do";
	}
	
	@RequestMapping(value="check_id.do")
	@ResponseBody
	public Map check_id(String c_mem_id) {

		C_memberVo vo = c_member_dao.selectOne(c_mem_id);
		boolean bResult = false;
		
		if(vo==null)
			bResult = true;//��밡����
		
		Map map = new HashMap();
		map.put("result", bResult);
		
		return map;
	}
	
	@RequestMapping("delete.do")
	public String delete(int c_mem_idx) {
		
		int res = c_member_dao.delete(c_mem_idx);
		
		//������ ������ �α��� ���¸�..�α׾ƿ�
		C_memberVo    user    = (C_memberVo) session.getAttribute("user");
		
		if(user.getC_mem_idx() == c_mem_idx) {
			
			session.removeAttribute("user");
		}
		return "redirect:list.do";
	}
	
	@RequestMapping("modify_form.do")
	public String modify_form(int c_mem_idx, Model model) {

		//mem_idx�� �ش�Ǵ� ��ü 1�� ��������
		C_memberVo  vo = c_member_dao.selectOne(c_mem_idx);
				
		model.addAttribute("vo", vo);
		
		return "c_member/c_member_modify_form";
	}
	
	@RequestMapping("modify.do")
	public String modify(C_memberVo vo) {

		//DB update
		int res = c_member_dao.update(vo);
				
		return "redirect:list.do";
	}
	
}
