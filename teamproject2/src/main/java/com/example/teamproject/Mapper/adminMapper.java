package com.example.teamproject.Mapper;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.teamproject.Vo.EventBoardVo;
import com.example.teamproject.Vo.FmanagerVo;
import com.example.teamproject.Vo.FreeBoardMemberVo;
import com.example.teamproject.Vo.FreeBoardSellerVo;
import com.example.teamproject.Vo.MemberVo;
import com.example.teamproject.Vo.NoriBoardVo;
import com.example.teamproject.Vo.NoticeBoardVo;
import com.example.teamproject.Vo.QBoardVo;
import com.example.teamproject.Vo.QnaBoardVo;

@Mapper
public interface adminMapper {
	// 관리자 시설관리자 목록 리스트
	List<FmanagerVo> adminFmAllList();

	// 관리자 회원 목록 리스트
	ArrayList<MemberVo> adminMAllList();

	// 관리자 문의 사항 리스트
	List<QnaBoardVo> adminQAllList();

	// 관리자 이벤트 게시판 리스트
	List<EventBoardVo> adminEventAllList();

	// 관리자 회원 자유게시판 리스트
	List<FreeBoardMemberVo> adminFbmAllList();

	// 관리자 시설관리자 자유게시판 리스트
	ArrayList<FreeBoardSellerVo> adminFbsAllList();

	// 관리자 노리게시판 리스트
	List<NoriBoardVo> amdinNoriAllList();

	// 관리자 공지사항 게시판 리스트
	List<NoticeBoardVo> adminNotictAllList();

	ArrayList<QBoardVo> selectMemberQBoard();

	ArrayList<QBoardVo> selectSellerQBoard();

	ArrayList<QnaBoardVo> selectAdminQnaList();

	int selectMemberCount();

	int selectFmanagerCount();

	ArrayList<EventBoardVo> eventBoard();

	ArrayList<EventBoardVo> eventBoard2();

	List<NoticeBoardVo> adminNotictAllList2();
}
