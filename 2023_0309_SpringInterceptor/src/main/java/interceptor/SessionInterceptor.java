package interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class SessionInterceptor extends HandlerInterceptorAdapter {
	
	@Autowired
	HttpSession session;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
			
		Map<String, String>	user = (Map<String, String>) session.getAttribute("user");
		
		if(user == null) {
			
			response.sendRedirect("../main/main.do?reason=not_login");
			
			return false;
		}
		
		
		String uri = request.getRequestURI();
		System.out.println(uri);
		
		//包府磊 ("/admin/")
		if(uri.contains("/admin/")) {
			
			if(user.get("grade").equals("包府")==false) {
				
				response.sendRedirect("../main/main.do?reason=not_admin");
				
				return false;
				
			}
			
		}
		
		//己牢咯何("/adult/")
		
		if(uri.contains("/adult/")) {
			
			int age = Integer.parseInt(user.get("age")) ;
			if(( age >= 18)==false) {
				response.sendRedirect("../main/main.do?reason=not_adult");
				
				return false;
				
			}
		
		}
		
	   return super.preHandle(request, response, handler);
   }

}
