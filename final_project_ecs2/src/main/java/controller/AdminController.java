package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.AdminDao;
import dao.C_boardDao;
import dao.C_memberDao;
import util.ElecCarUtil;
import vo.C_boardVo;
import vo.C_memberVo;
import vo.ChargingVo;

@Controller
@RequestMapping("/admin/")
public class AdminController {

	@Autowired
	HttpSession session;
	
	//관리자
	AdminDao admin_dao;
	
	C_memberDao c_member_dao;
	
	C_boardDao c_board_dao;

	public void setAdmin_dao(C_memberDao c_member_dao) {
		this.c_member_dao = c_member_dao;
	}
	

	public void setAdmin_dao(AdminDao admin_dao) {
		this.admin_dao = admin_dao;
	}
	
	



	@RequestMapping("list.do")
	public String list(Model model) {
			
		//회원리스트
		List<C_memberVo> m_list = admin_dao.adminCmemberList();
		
		//게시판리스트
		List<C_boardVo> b_list = admin_dao.adminCboardList();
		
		ChargingVo vo = new ChargingVo();
		
		
		List<ChargingVo> c_list = new ArrayList<ChargingVo>();
		
		System.out.println(c_list.size());
		
		
		//회원
		model.addAttribute("m_list", m_list);
		//게시판
		model.addAttribute("b_list", b_list);
		
		
		return "admin/index";
	}
	
	
	

	

}
