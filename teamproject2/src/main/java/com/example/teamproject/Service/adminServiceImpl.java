package com.example.teamproject.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.teamproject.Mapper.adminMapper;
import com.example.teamproject.Vo.EventBoardVo;
import com.example.teamproject.Vo.FmanagerVo;
import com.example.teamproject.Vo.FreeBoardMemberVo;
import com.example.teamproject.Vo.FreeBoardSellerVo;
import com.example.teamproject.Vo.MemberVo;
import com.example.teamproject.Vo.NoriBoardVo;
import com.example.teamproject.Vo.NoticeBoardVo;
import com.example.teamproject.Vo.QBoardVo;
import com.example.teamproject.Vo.QnaBoardVo;

@Service
public class adminServiceImpl implements adminService {

	@Autowired
	adminMapper adminMapper;

	// 관리자 시설관리자 목록 리스트
	@Override
	public List<FmanagerVo> adminFmAllList() {
		List<FmanagerVo> list = adminMapper.adminFmAllList();
		return list;
	}

	// 관리자 회원 목록 리스트
	@Override
	public ArrayList<MemberVo> adminMAllList() {
		ArrayList<MemberVo> list = adminMapper.adminMAllList();
		return list;
	}

	// 관리자 문의 사항 리스트
	@Override
	public List<QnaBoardVo> adminQAllList() {
		List<QnaBoardVo> list = adminMapper.adminQAllList();
		return list;
	}


	// 관리자 회원 자유게시판 리스트
	@Override
	public List<FreeBoardMemberVo> adminFbmAllList() {
		List<FreeBoardMemberVo> list = adminMapper.adminFbmAllList();
		return list;
	}

	// 관리자 시설관리자 자유게시판 리스트
	@Override
	public ArrayList<FreeBoardSellerVo> adminFbsAllList() {
		ArrayList<FreeBoardSellerVo> list = adminMapper.adminFbsAllList();
		return list;
	}

	// 관리자 노리게시판 리스트
	@Override
	public List<NoriBoardVo> amdinNoriAllList() {
		List<NoriBoardVo> list = adminMapper.amdinNoriAllList();
		return list;
	}

	// 관리자 공지사항 게시판 리스트
	@Override
	public List<NoticeBoardVo> adminNoticeAllList() {
		List<NoticeBoardVo> list = adminMapper.adminNotictAllList();
		return list;
	}

	@Override
	public Map<String, Object> selectAllQBoardList() {
		Map<String,Object> map = new HashMap<String,Object>();
		ArrayList<QBoardVo> memberList = adminMapper.selectMemberQBoard();
		ArrayList<QBoardVo> sellerList = adminMapper.selectSellerQBoard();
		map.put("memberList", memberList);
		map.put("sellerList", sellerList);
		return map;
	}

	@Override
	public ArrayList<QnaBoardVo> adminQnaList() {
		ArrayList<QnaBoardVo> list = adminMapper.selectAdminQnaList();
		return list;
	}

	@Override
	public Map<String, Object> selectAllMember() {
		Map<String,Object> map = new HashMap<String,Object>();
		int memberCount = adminMapper.selectMemberCount();
		int fmanagerCount = adminMapper.selectFmanagerCount();
		ArrayList<EventBoardVo> eList = adminMapper.eventBoard2();
		List<NoticeBoardVo> nList = adminMapper.adminNotictAllList2();
		map.put("memberCount", memberCount);
		map.put("fmanagerCount", fmanagerCount);
		map.put("eList", eList);
		map.put("nList", nList);
		return map;
	}

	@Override
	public Map<String, Object> eventBoard() {
		Map<String,Object> map = new HashMap<String,Object>();
		ArrayList<EventBoardVo> list = adminMapper.eventBoard(); 
		map.put("list", list);
		return map;
	}

}
