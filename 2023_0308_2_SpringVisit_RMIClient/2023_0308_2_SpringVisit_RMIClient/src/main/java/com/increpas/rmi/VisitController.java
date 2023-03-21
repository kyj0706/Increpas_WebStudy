package com.increpas.rmi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import dao.VisitDao;
import vo.VisitVo;

@Controller
public class VisitController {
	
	@Autowired
	VisitDao visit_dao;
	
	@RequestMapping("/visit/list.do")
	public String list(Model model) {

		List<VisitVo> list = visit_dao.selectList();
		
		System.out.println("--size--" + list.size());
		
		model.addAttribute("list", list);
		
		
		return "visit/visit_list";
	}
}
