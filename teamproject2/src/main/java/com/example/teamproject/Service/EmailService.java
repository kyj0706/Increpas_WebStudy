package com.example.teamproject.Service;


public interface EmailService {

	String emailSend(String email);
	
	//번호 찍기
	public String getCreateKey();

	//인증
	int email_check(String email_check,String m_email, String m_id);
	

}
