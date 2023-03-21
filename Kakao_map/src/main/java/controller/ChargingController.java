package controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import util.ElecCarUtil;
import vo.ChargingVo;


@Controller
public class ChargingController {
	
	@RequestMapping("list.do")
	public static String list(ChargingVo vo ,Model model) {
		
		int pageNo = vo.getPageNo();
		int zscode = vo.getZscode();
		
		List<ChargingVo> list = ElecCarUtil.getElecCarPosition(vo,pageNo, zscode);
		
		
		model.addAttribute("list" ,list);
		return "e_list";
	}
	
	
}
