package com.example.teamproject.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.teamproject.Mapper.memberMapper;



@Service
public class EmailServiceImpl implements EmailService {

	@Autowired
	private JavaMailSender mailSender; //메일 발송 객체
	
	@Autowired
	memberMapper memberMapper;
	
	@Override//이메일 발송
	public String emailSend(String email) {
		//메일내용저장 객체 선언
		SimpleMailMessage message = new SimpleMailMessage();
		//임시번호 생성 - 10자리 임시번호 
		String pwCode =getCreateKey();
		message.setTo(email);                   // 받는사람 이메일주소
		message.setFrom("fbdrkd327@naver.com");//자신의 이메일 주소
		message.setSubject("이메일인증 번호 안내"); //제목
		
		//메일 내용 저장
		String msgCountent="";
		msgCountent += "[회원가입 이메일 인증 비밀번호]";
		msgCountent += " 인증번호 :" + pwCode;
		
		//메일 내용
		message.setText(msgCountent);
		
		//메일발송
		mailSender.send(message);
		System.out.println("비밀번호 :" +pwCode);
		System.out.println("메일발송 완료!");
		
		return pwCode;
	}
	
	//임시 비밀번호 생성
	public String getCreateKey() {
		String pwCode ="";
		char[] charSet = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F',
                'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
		
		int idx = 0;
		for(int i=0; i<10; i++) {
			//36*Math.random()
			idx =(int)(charSet.length*Math.random());
			pwCode = pwCode +charSet[idx];
			
			
		}
		
		
		return pwCode;
	}

	
	 @Override 
	 public int email_check(String email_check,String m_email,String m_id) { 
		 int result = 0;
	  
	  result = memberMapper.email_check(email_check,m_email,m_id);
	  	System.out.println("이메일 체크 여부 " +email_check);
	  return result; }
	 


	
}