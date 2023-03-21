package com.example.teamproject.Mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.teamproject.Vo.AdminVo;
import com.example.teamproject.Vo.FmanagerVo;
import com.example.teamproject.Vo.MemberVo;

@Mapper
public interface LoginMapper {

	// 회원로그인 체크
	MemberVo member_login_check(String m_id, String m_pw);

	// 시설관리자 로그인 체크
	FmanagerVo Fmanager_login_check(String fm_id, String fm_pw);

	// 회원 회원가입 기능
	int member_register_check(MemberVo memberVo);

	// 시설 관리자 회원가입 기능
	int fac_register_check(FmanagerVo fmanagerVo);

	// 회원 아이디 찾기 기능
	MemberVo member_ld_find_check(String m_nickname, String m_email);

	// 시설 아이디 찾기 기능
	FmanagerVo fac_ld_find_check(String fm_name, String fm_phone);

	// 회원 비밀번호 찾기 기능
	MemberVo member_pw_find_check(String m_id, String m_email);

	// 시설 비밀번호 찾기 기능
	FmanagerVo fac_pw_find_check(String fm_id, String fm_phone);

	// 관리자 로그인
	AdminVo admin_login(String a_id, String a_pw);

	// 회원 아이디 중복검사
	MemberVo member_id_check(String m_id);

	// 시설관리자 아이디 중복검사
	FmanagerVo fmanager_id_check(String fm_id);
}
