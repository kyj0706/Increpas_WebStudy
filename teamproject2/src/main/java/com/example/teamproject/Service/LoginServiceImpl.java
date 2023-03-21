package com.example.teamproject.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.teamproject.Mapper.LoginMapper;
import com.example.teamproject.Vo.AdminVo;
import com.example.teamproject.Vo.FmanagerVo;
import com.example.teamproject.Vo.MemberVo;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	LoginMapper loginMapper;

	//회원 로그인 체크
	@Override
	public MemberVo member_login_check(String m_id, String m_pw) {

		MemberVo memberVo = loginMapper.member_login_check(m_id,m_pw);
		
		return memberVo;
	}
	
	
	//시설 관리자 로그인 체크
	@Override
	public FmanagerVo Fmanager_login_check(String fm_id, String fm_pw) {
	

		
		FmanagerVo fmanagerVo = loginMapper.Fmanager_login_check(fm_id,fm_pw);
		
		return fmanagerVo;
	}


	//회원 회원가입 기능
	@Override
	public int member_register_check(MemberVo memberVo) {

		int result = loginMapper.member_register_check(memberVo);
		
		return result;
	}

	//시설관리자 회원가입 기능
	@Override
	public int fac_register_check(FmanagerVo fmanagerVo) {
		
		int result = loginMapper.fac_register_check(fmanagerVo);
		
		return result;
	}


	//회원 아이디 찾기
	@Override
	public MemberVo member_ld_find_check(String m_nickname, String m_email) {

		MemberVo memberVo = loginMapper.member_ld_find_check(m_nickname,m_email);
		
		return memberVo;
	}

	//시설 아이디 찾기
	@Override
	public FmanagerVo fac_ld_find_check(String fm_name, String fm_phone) {

		FmanagerVo fmanagerVo = loginMapper.fac_ld_find_check(fm_name,fm_phone);
		
		return fmanagerVo;
	}

	//회원 비밀번호 찾기
	@Override
	public MemberVo member_pw_find_check(String m_id, String m_email) {

		MemberVo memberVo = loginMapper.member_pw_find_check(m_id,m_email);
		
		return memberVo;
	}

	//시설 비밀번호 찾기
	@Override
	public FmanagerVo fac_pw_find_check(String fm_id, String fm_phone) {


		FmanagerVo fmanagerVo= loginMapper.fac_pw_find_check(fm_id,fm_phone);
		
		return fmanagerVo;
	}

	//관리자 로그인
	@Override
	public AdminVo admin_login(String a_id, String a_pw) {

		System.out.println("서브시");
		System.out.println(a_id);
		
		AdminVo adminVo = loginMapper.admin_login(a_id,a_pw);
		
		return adminVo;
	}
	

	//회원 아이디 중복검사
		@Override
		public MemberVo member_id_check(String m_id) {

			MemberVo memberVo = new MemberVo();
			
			memberVo = loginMapper.member_id_check(m_id);
			
			
			return memberVo;
		}

		//시설 관리자 아이디 중복검사
		@Override
		public FmanagerVo fmanager_id_check(String fm_id) {

			FmanagerVo fmanagerVo = new FmanagerVo();
			
			fmanagerVo =  loginMapper.fmanager_id_check(fm_id);
			
			return fmanagerVo;
		}
		
	
	
	
}
