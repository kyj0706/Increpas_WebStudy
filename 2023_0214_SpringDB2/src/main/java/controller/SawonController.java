package controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.SawonDao;
import vo.SawonVo;

@Controller
public class SawonController {

	SawonDao sawon_Dao;

	public SawonController(SawonDao sawon_Dao) {
		super();
		this.sawon_Dao = sawon_Dao;
	}
	
	
	@RequestMapping("/sawon/list.do")
	public String list(Model model ) {
		
		List<SawonVo> list = sawon_Dao.selectList();
		
		model.addAttribute("list",list);
		
		return "sawon/sawon_list";
	}
	
	
}
