package action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import myutil.Jumin;

/**
 * Servlet implementation class JuminAction
 */
@WebServlet("/jumin.do")
public class JuminAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String jumin_no =request.getParameter("jumin_no");
		
		Jumin jumin = new Jumin();
		jumin.setJumin_no(jumin_no);
		
		
		
		
		JSONObject json = new JSONObject();
		
		json.put("year", jumin.getYear());
		json.put("age", jumin.getAge());
		json.put("tti", jumin.getTti2());
		json.put("ganji", jumin.getGanji());
		json.put("gender", jumin.getGender());
		json.put("season", jumin.getSeason());
		json.put("local", jumin.getLocal());
		
		
		
		response.setContentType("text/json; charset=utf-8");
		response.getWriter().print(json.toString());
		
		
		
	}

}
