package com.example.teamproject.Controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.teamproject.Service.QBoardService;
import com.example.teamproject.Vo.QBoardVo;
import com.example.teamproject.Vo.ReplyVo;



@Controller
public class QBoardController {
	
	@Autowired
	QBoardService qBoardService;
	@GetMapping("qBoardWrite")
	public String openQBoardWrite() {
		return "/questionBoard/qBoardWrite";
	}
	
	
	@PostMapping("qBoardWrite")
	public String qBoardWrite(Model model,QBoardVo qBoardVo,HttpSession session) {
		String member = (String)session.getAttribute("session_member");
		String url = "";
		System.out.println(qBoardVo.getQ_title());
		qBoardService.qBoardWrite(qBoardVo,member);
		if(member.equals("member")) {
			url = "member_qua";
		}else if(member.equals("seller")) {
			url = "fac_qna";
		}
		return "redirect:"+url;
	}
	
	@GetMapping("qBoardView")
	public String qBoardView(@RequestParam(value = "q_num") int q_num,Model model) {
		Map<String,Object> map = qBoardService.selectView(q_num);
		model.addAttribute("map",map);
		return "/questionBoard/qBoardView";
	}
	
	@GetMapping("qBoardReply")
	public String openQBoardReply(@RequestParam(value = "q_num") int q_num,Model model) {
		QBoardVo qVo = qBoardService.selectQBoardInfo(q_num);
		model.addAttribute("qVo",qVo);
		
		return "/questionBoard/qBoardReply";
	}
	@PostMapping("qBoardReply")
	public String qBoardReply(ReplyVo replyVo,Model model) {
		qBoardService.qBoardReply(replyVo);
		return "redirect:qBoardView?q_num="+replyVo.getQ_num();
	}
}
