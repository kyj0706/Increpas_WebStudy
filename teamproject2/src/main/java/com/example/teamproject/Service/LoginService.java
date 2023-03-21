package com.example.teamproject.Service;

import com.example.teamproject.Vo.AdminVo;
import com.example.teamproject.Vo.FmanagerVo;
import com.example.teamproject.Vo.MemberVo;

public interface LoginService {

	// 회원 로그인 기능
	MemberVo member_login_check(String m_id, String m_pw);

	// 시설관리자 로그인 기능
	FmanagerVo Fmanager_login_check(String fm_id, String fm_pw);

	// 회원 회원가입 기능
	int member_register_check(MemberVo memberVo);

	// 시설관리자 회원가입 기능
	int fac_register_check(FmanagerVo fmanagerVo);

	// 회원 아이디 찾기
	MemberVo member_ld_find_check(String m_nickname, String m_email);

	// 회원 비밀번호 찾기
	MemberVo member_pw_find_check(String m_id, String m_email);

	// 시설 아이디 찾기
	FmanagerVo fac_ld_find_check(String fm_name, String fM_PHONE);

	// 시설 비밀번호 찾기
	FmanagerVo fac_pw_find_check(String fm_id, String fM_PHONE);

	// 관리자 로그인
	AdminVo admin_login(String a_id, String a_pw);

	// 회원 아이디 중복검사
	MemberVo member_id_check(String m_id);

	// 시설관리자 아이디 중복검사
	FmanagerVo fmanager_id_check(String fm_id);

}
