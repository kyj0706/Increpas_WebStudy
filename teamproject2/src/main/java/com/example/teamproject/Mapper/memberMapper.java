package com.example.teamproject.Mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.example.teamproject.Vo.MemberVo;
import com.example.teamproject.Vo.QBoardVo;
import com.example.teamproject.Vo.ReservationVo;

@Mapper
public interface memberMapper {

	// 마이페이지 이동
	MemberVo memberMypage(String m_id);

	// 개인정보 수정확인
	int member_Modify(MemberVo memberVo);

	// 충전페이지 이동
	MemberVo member_charge(String m_id);

	// 포인트 충전
	int member_pointcharge(String m_id, String m_point);

	ArrayList<ReservationVo> selectReserList(int m_no);

	ArrayList<QBoardVo> selectQBoardList(String member, String m_id);

	// 이메일 인증
	int email_check(String email_check, String m_email, String m_id);

	ArrayList<QBoardVo> selectQBoardList2(String member, String m_id);

	ArrayList<ReservationVo> selectReserList2(int m_no);

}
