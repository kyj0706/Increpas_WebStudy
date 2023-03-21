package controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.C_memberDao;
import vo.C_memberVo;

@Controller
@RequestMapping("/main/")
public class MainController {

	@Autowired
	HttpSession session;
	
	C_memberDao c_member_dao;

	public void setMember_dao(C_memberDao c_member_dao) {
		this.c_member_dao = c_member_dao;
	}
	
	@RequestMapping("list.do")
	public String main_list(Model model) {
		
		List<C_memberVo> list = c_member_dao.selectList();
		
		
		model.addAttribute("list", list);
		
		return "main/main_list";
	}
}
