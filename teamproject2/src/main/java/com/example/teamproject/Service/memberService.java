package com.example.teamproject.Service;

import java.util.ArrayList;
import java.util.Map;

import com.example.teamproject.Vo.MemberVo;
import com.example.teamproject.Vo.ReservationVo;

public interface memberService {

	//마이페이지 이동
	MemberVo memberMypage(String m_id);

	//개인정보 수정등록
	int member_Modify(MemberVo memberVo);

	//충전 페이지 이동
	MemberVo member_charge(String m_id);

	//포인트 충전
	int member_pointcharge(String m_id, String m_point);

	ArrayList<ReservationVo> selectReserList(int m_no);

	Map<String, Object> selectQBoardList(String member, String m_id);


	Map<String, Object> selectMemberInfo(String m_id, int m_no, String member);

}
