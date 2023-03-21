package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dao.ChargingDao;
import dao.FeedbackDao;
import util.ElecCarUtil;
import vo.ChargingVo;
import vo.FeedbackVo;

@Controller
@RequestMapping("/charging/")
public class ChargingController {
	
	@Autowired
	HttpSession session;
	
	@Autowired
	HttpServletRequest request;
	
	ChargingDao chargingdao;
	FeedbackDao feedbackdao;
	
	public void setFeedbackdao(FeedbackDao feedbackdao) {
		this.feedbackdao = feedbackdao;
	}
	
	@RequestMapping("list.do")
	public static String list(ChargingVo vo ,Model model) {
		
		int pageNo = vo.getPageNo();
		int zscode = vo.getZscode();
		
		List<ChargingVo> list = ElecCarUtil.getElecCarPosition(vo,pageNo, zscode);
		
		model.addAttribute("list" ,list);
		return "main/e_list";
	}
	
	@RequestMapping("view.do")
	public String view(@RequestParam(value="statNm") String statNm,
				       @RequestParam(value="lat") String lat,
				       @RequestParam(value="lng") String lng,
				       @RequestParam(value="addr") String addr,
				       @RequestParam(value="useTime") String useTime,
				       @RequestParam(value="chgerType") String chgerType,
				       @RequestParam(value="parkingFree") String parkingFree,
			Model model) {
		//ChargingVo vo = chargingdao.selectOne(statNm); 
		FeedbackVo cvo = new FeedbackVo();
		cvo.setF_statNm(statNm);
		cvo.setF_lat(lat);
		cvo.setF_lng(lng);
		cvo.setF_addr(addr);
		cvo.setF_useTime(useTime);
		cvo.setF_chgerType(chgerType);
		cvo.setF_parkingFree(parkingFree);
		
		
		//������Ÿ�� ���� ��Ŀ���� ǥ��
		String type_str = null;
		
		switch (cvo.getF_chgerType()) {
		case "01": type_str = "DC������"; break;
		case "02": type_str = "AC�ϼ�"; break;
		case "03": type_str = "DC������+AC3��"; break;
		case "04": type_str = "DC�޺�"; break;
		case "05": type_str = "DC������+DC�޺�"; break;
		case "06": type_str = "DC������+AC3��+DC�޺�"; break;
		case "07": type_str = "AC3��"; break;
				
		default:
			break;
		}
		
		
		model.addAttribute("cvo", cvo);
		model.addAttribute("type_str",type_str );
		//FeedbackVo fvo = feedbackdao.selectOne3(statNm);
		//model.addAttribute("fvo",fvo);
		return "main/e_view";            
	}
												
}