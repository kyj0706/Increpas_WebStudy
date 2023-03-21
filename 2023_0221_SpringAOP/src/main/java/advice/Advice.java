package advice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.springframework.beans.factory.annotation.Autowired;

public class Advice {
	
	//DispatcherServlert 연결해주까 ? <context:annotation-config/> 필수
	@Autowired
	HttpServletRequest request;
	
	@Autowired
	HttpSession session;
	
	public void before(JoinPoint jp){
		Signature s =  jp.getSignature();
		
		//시작
		long start = System.currentTimeMillis();
		
		request.setAttribute("start", start);
		
		System.out.println("----before:" + s);
		
		System.out.println("--session_id-- : "+ session.getId());
	}
	
	public void after(JoinPoint jp){
		Signature s =  jp.getSignature();
		
		System.out.println("----after:" + s.toString());
		
		//종료
		long end = System.currentTimeMillis();
		
		long start = (Long)request.getAttribute("start");
		
		System.out.printf("----수행시간%d(ms)\n",end-start);
	}
}
