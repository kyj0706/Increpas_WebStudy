package action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	protected void service(
			HttpServletRequest  request, 
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//수신인코딩 설정
		request.setCharacterEncoding("utf-8");

		///2022_1219_ServletParameter/jumin.do?jumin_no=801212-1234560
		//parameter 받기
		String jumin_no = request.getParameter("jumin_no");
		
		//배열
		
		//주민객체생성
		Jumin jumin = new Jumin();
		jumin.setJumin_no(jumin_no); //주민번호 넣기
		
		//부가정보 추출
		int    year  	= jumin.getYear();
		int    age   	= jumin.getAge();
		String gender  	= jumin.getGender();
		String season	= jumin.getSeason();
		String local	= jumin.getLocal();
		String tti		= jumin.getTti();
		String ganji	= jumin.getGanji();
		

		
	
		
		
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("jumin_no", jumin_no);
		map.put("year",Integer.toString(year));
		map.put("age",Integer.toString(age));
		map.put("gender", gender);
		map.put("season", season);
		map.put("local", local);
		map.put("tti", tti);
		map.put("ganji", ganji);
		
		//보낼것만 배열만 만들어
		
		request.setAttribute("map", map);
		
		
		RequestDispatcher disp = request.getRequestDispatcher("jumin_result.jsp");
		
		disp.forward(request, response);
		
	}

}
