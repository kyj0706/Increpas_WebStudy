package Action;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestAction
 */
@WebServlet("/TestAction")
public class TestAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//변수선언
	int a = 10;
	
	int count = 0;
	
	//메소드 선언
	public void sub() {
		
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//지역변수
		int local_a = 10;
		
		count++;
		
		System.out.printf("[%d]번째 방문자",count);
		
		response.setContentType("text/html; charset=utf-8;");
		response.getWriter().printf("[%d]번째 방문자",count);
		
		
	}

}
