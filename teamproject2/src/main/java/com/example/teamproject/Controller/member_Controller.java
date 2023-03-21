package com.example.teamproject.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.teamproject.Service.EmailService;
import com.example.teamproject.Service.memberService;
import com.example.teamproject.Vo.MemberVo;
import com.example.teamproject.Vo.ReservationVo;

@Controller
public class member_Controller {

	@Autowired
	memberService memberService;
	
	@Autowired
	EmailService emailService;

	// 회원 메인페이지 이동
	@GetMapping("member_Main")
	public String member_Main(HttpSession session , Model model) {
		String m_id = (String)session.getAttribute("session_id");
		int m_no = (int)session.getAttribute("session_no");
		String member = (String)session.getAttribute("session_member");
		Map<String,Object> map = memberService.selectMemberInfo(m_id,m_no,member);
		model.addAttribute("map",map);
		return "/member/member_Main";
	}

	// 회원 마이페이지 이동
	@GetMapping("member_mypage")
	public String member_Register(HttpSession session, Model model) {

		String M_ID = (String) session.getAttribute("session_id");

		System.out.println("test");
		System.out.println(M_ID);
		MemberVo memberVo = new MemberVo();

		memberVo = memberService.memberMypage(M_ID);

		model.addAttribute("memberVo", memberVo);

		return "/member/member_mypage";
	}

	// 회원 정보 수정 페이지 이동
	@GetMapping("member_Modify")
	public String member_Modify(HttpSession session, Model model) {

		String M_ID = (String) session.getAttribute("session_id");

		System.out.println("수정");
		System.out.println(M_ID);

		MemberVo memberVo = new MemberVo();

		memberVo = memberService.memberMypage(M_ID);

		model.addAttribute("memberVo", memberVo);

		return "/member/member_Modify";
	}

	// 회원 정보 수정 등록
	@PostMapping("member_Modify")
	public String member_Modify(HttpServletRequest request, Model model) {

		MemberVo memberVo = new MemberVo();

		String m_id = request.getParameter("m_id");
		String m_name = request.getParameter("m_name");
		String m_nickname = request.getParameter("m_nickname");
		String birth1 = request.getParameter("birth1");
		String birth2 = request.getParameter("birth2");
		String birth3 = request.getParameter("birth3");
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		String post = request.getParameter("post");
		String add1 = request.getParameter("add1");
		String add2 = request.getParameter("add2");
		String phone = request.getParameter("phone");

		memberVo.setM_id(m_id);
		memberVo.setM_name(m_name);
		System.out.println(memberVo.getM_name());
		memberVo.setM_nickname(m_nickname);
		memberVo.setM_birth(birth1 + birth2 + birth3);
		memberVo.setM_gender(gender);
		memberVo.setM_email(email);
		memberVo.setM_post(post);
		memberVo.setM_add1(add1);
		memberVo.setM_add2(add2);
		memberVo.setM_phone(phone);
		System.out.println("성별" + memberVo.getM_gender());
		int result = memberService.member_Modify(memberVo);

		System.out.println("result 타입 " + result);

		model.addAttribute("result", result);

		return "/member/member_Modify";
	}

	// 회원 1대1문의 현황 게시판
	@GetMapping("member_qua")
	public String member_qua(HttpSession session, Model model) {
		String member = (String) session.getAttribute("session_member");
		String m_id = (String) session.getAttribute("session_id");
		Map<String, Object> map = memberService.selectQBoardList(member, m_id);
		model.addAttribute("map", map);
		return "/member/member_qua";
	}

	// 회원 포인트 충전페이지
	@GetMapping("member_charge")
	public String member_charge(HttpSession session, Model model) {

		String M_ID = (String) session.getAttribute("session_id");

		MemberVo memberVo = new MemberVo();

		memberVo = memberService.member_charge(M_ID);

		model.addAttribute("memberVo", memberVo);

		return "/member/member_charge";
	}

	// 회원 포인트 충전
	@PostMapping("member_charge")
	public String member_charge(@RequestParam(value = "point") int Point1,
			@RequestParam(value = "m_Point") String Point2, @RequestParam(value = "m_id") String m_id, Model model) {

		int point3 = Integer.parseInt(Point2);

		int chargepoint = Point1 + point3;
		String m_point = Integer.toString(chargepoint);

		int result = memberService.member_pointcharge(m_id, m_point);

		return "redirect:member_charge";
	}

	// 회원 예약 정보 확인
	@GetMapping("member_reserve")
	public String member_reserve(HttpSession session, Model model) {
		int m_no = (int) session.getAttribute("session_no");
		ArrayList<ReservationVo> list = memberService.selectReserList(m_no);
		model.addAttribute("list", list);
		return "/member/member_reserve";
	}

	// 회원 이메일 인증 번호 전송
	@RequestMapping("emailcheck")
	@ResponseBody
	public Map<String, Object> emailcheck(@RequestParam String email) {

		Map<String, Object> map = new HashMap<String, Object>();

		System.out.println("email" + email);

		// 이름,이메일 주소를 넘겨서 비밀번호 생성후 이메일 발송 처리
		String pwEmail = emailService.emailSend(email);
		System.out.println("pwEmail" + pwEmail);

		map.put("pwEmail", pwEmail);
		return map;
	}

	// 회원 이메일 인증
	@RequestMapping("/member/emailCheck")
	@ResponseBody
	public Map<String, Object> emailCheck(@RequestParam String email_pw, @RequestParam String email_num,
			@RequestParam String m_email, @RequestParam String m_id) {
		Map<String, Object> map = new HashMap<String, Object>();
		String check = "";
		String email_check = "";

		int result = 0;

		if (email_pw.equals(email_num)) {
			check = "일치합니다";
			email_check = "ok";
			System.out.println(check);
		} else {
			check = "일치하지 않습니다";
			email_check = "no";
			System.out.println(check);
		}
		System.out.println("이메일체크여부" + email_check);
		result = emailService.email_check(email_check, m_email, m_id);

		map.put("check", check);
		map.put("check1", email_check);
		map.put("result", result);

		return map;
	}

}
