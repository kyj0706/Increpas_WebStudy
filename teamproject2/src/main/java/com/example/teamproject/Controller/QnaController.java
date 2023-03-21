package com.example.teamproject.Controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.teamproject.Service.QnaBoardService;
import com.example.teamproject.Vo.QnaBoardVo;

@Controller
public class QnaController {
	@Autowired
	QnaBoardService qnaBoardService;
	
	@GetMapping("qnaBoardList")
	public String openQnA(@RequestParam(defaultValue = "") String category,@RequestParam(defaultValue = "1") int page,Model model) {
		System.out.println(category);
		Map<String,Object> map = qnaBoardService.selectQnaBoard(category,page);
		model.addAttribute("map",map);
		return "/QnA/qnaBoardList";
	}
	@GetMapping("qnaBoardWrite")
	public String openQnaWrite() {
		return "/QnA/qnaBoardWrite";
	}
	@PostMapping("qnaBoardWrite")
	public String qnaWrite(QnaBoardVo qnaBoardVo) {
		qnaBoardService.qnaBoardWrite(qnaBoardVo);
		return "redirect:qnaBoardList";
	}
	
	@GetMapping("qnaBoardModify")
	public String openQnaModify(@RequestParam(value = "qb_num") int qb_num ,Model model) {
		QnaBoardVo qnaBoardVo = qnaBoardService.selectQnaInfo(qb_num);
		model.addAttribute("qnaBoardVo",qnaBoardVo);
		return "/QnA/qnaBoardModify";
	}
	@PostMapping("qnaBoardModify")
	@ResponseBody
	public void QnaModify(QnaBoardVo qnaBoardVo ,Model model) {
		qnaBoardService.qnaModify(qnaBoardVo);
	}
	@PostMapping("qnaBoardDelete")
	@ResponseBody
	public void qnaDelete(@RequestParam (value = "qb_num") int qb_num) {
		qnaBoardService.qnaDelete(qb_num);
	}
}
