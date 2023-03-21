package com.example.teamproject.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.teamproject.Service.adminService;
import com.example.teamproject.Vo.FmanagerVo;
import com.example.teamproject.Vo.FreeBoardMemberVo;
import com.example.teamproject.Vo.FreeBoardSellerVo;
import com.example.teamproject.Vo.MemberVo;
import com.example.teamproject.Vo.NoriBoardVo;
import com.example.teamproject.Vo.NoticeBoardVo;
import com.example.teamproject.Vo.QnaBoardVo;

@Controller
public class admin_controller {

	@Autowired
	adminService adminService;

	// 관리자 메인 페이지
	@GetMapping("admin_main")
	public String addmin_main(Model model) {
		Map<String,Object> map = adminService.selectAllMember();
		model.addAttribute("map",map);
		return "/admin/admin_main";
	}

	// 관리자 블랙 리스트 페이지
	@GetMapping("admin_blacklist")
	public String admin_blacklist() {
		return "/admin/admin_blacklist";
	}

	// 관리자 시설관리자 목록 리스트
	@GetMapping("admin_fac_list")
	public String admin_fac_list(Model model) {
		List<FmanagerVo> list = adminService.adminFmAllList();
		model.addAttribute("list", list);
		return "/admin/admin_fac_list";
	}

	//관리자 회원 목록 리스트
		@GetMapping("admin_member_list")
		public String admin_member_list(Model model) {
			ArrayList<MemberVo> list = adminService.adminMAllList();
			model.addAttribute("list", list);
			return"/admin/admin_member_list";
		}

	// 관리자 문의 사항 리스트
	@GetMapping("askboard_list")
	public String askboard_list(Model model) {
		Map<String,Object> map = adminService.selectAllQBoardList();
		model.addAttribute("map",map);
		return "/admin/askboard_list";
	}

	//관리자 회원 자유게시판 리스트
	@GetMapping("freeboardmember_list")
	public String freeboardmember_list(Model model) {
		List<FreeBoardMemberVo> list=adminService.adminFbmAllList();
		model.addAttribute("list",list);
		return"/admin/freeboardmember_list";
	}

	//관리자 노리 게시판 리스트
		@GetMapping("noriboard_list")
		public String noriboard_list(Model model) {
			List<NoriBoardVo> list=adminService.amdinNoriAllList();
			model.addAttribute("list",list);
			return"/admin/noriboard_list";
		}
		
		//관리자 시설관리자 자유게시판 리스트
		@GetMapping("freeboardseller_list")
		public String freeboardseller_list(Model model) {
			ArrayList<FreeBoardSellerVo> list=adminService.adminFbsAllList();
			model.addAttribute("list",list);
			return"/admin/freeboardseller_list";
		}
		//관리자 공지사항 게시판 리스트
		@GetMapping("noticeboard_list")
		public String noticeboard_list(Model model) {
			List<NoticeBoardVo> list=adminService.adminNoticeAllList();
			model.addAttribute("list",list);
			return"/admin/noticeboard_list";
		}

	// 관리자 qna 게시판 리스트
	@GetMapping("qnaboard_list")
	public String qnaboard_list(Model model) {
		ArrayList<QnaBoardVo> list = adminService.adminQnaList();
		model.addAttribute("list",list);
		return "/admin/qnaboard_list";
	}
	
	//시설 이벤트 게시판 리스트
	@GetMapping("eventBoard")
	public String eventBoard(Model model) {
		Map<String,Object> map = adminService.eventBoard();
		model.addAttribute("map",map);
		return "/admin/eventBoard";
	}
}
