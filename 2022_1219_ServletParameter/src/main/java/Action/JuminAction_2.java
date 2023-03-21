package Action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import myutil.Jumin_t;

/**
 * Servlet implementation class JuminAction_2
 */
@WebServlet("/Jumin_2.do")
public class JuminAction_2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//응답
		
		request.setCharacterEncoding("utf-8");
		
		String jumin_no = request.getParameter("jumin_no");
		
		Jumin_t jumin_t = new Jumin_t();
		jumin_t.setJumin_no(jumin_no);
		
		int 	year 	= jumin_t.getYear();
		int 	age 	= jumin_t.getAge();
		String 	gender	= jumin_t.getGender();
		String 	tti		= jumin_t.getTti2();
		String 	ganji 	= jumin_t.getGanji();
		String  sesaon 	= jumin_t.getSeason();
		String  local	= jumin_t.getLocal();
		
		System.out.println(year);
		System.out.println(age);
		System.out.println(gender);
		System.out.println(tti);
		System.out.println(ganji);
		System.out.println(sesaon);
		System.out.println(local);
		
		
		
		
		//결과
		response.setContentType("text/html; charset=utf-8;");
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head><title>되나</title></head>");
		out.println("<body>");
		out.println("<table width='400' border='1'>");
	    out.printf("<tr><th width=\'30%%\'>주민번호</th><td>%s</td></tr>", jumin_no);
	    out.printf("<tr><th>출생년도</th><td>%d</td></tr>", year);
	    out.printf("<tr><th>나이</th><td>%d</td></tr>", age);
	    out.printf("<tr><th>성별</th><td>%s</td></tr>", gender);
	    out.printf("<tr><th>띠</th><td>%s</td></tr>", tti);
	    out.printf("<tr><th>천간</th><td>%s</td></tr>", ganji);
	    out.printf("<tr><th>출생계절</th><td>%s</td></tr>", sesaon);
	    out.printf("<tr><th>출생지역</th><td>%s</td></tr>", local);
	    out.printf("<tr><th colspan='2'><a href='jumin_2.html'>다시하기</a></th></tr>");
	    out.println("</table>");
		out.println("</body>");
		out.println("</html>");
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
