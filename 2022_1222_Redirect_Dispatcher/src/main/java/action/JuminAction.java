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
		//�������ڵ� ����
		request.setCharacterEncoding("utf-8");

		///2022_1219_ServletParameter/jumin.do?jumin_no=801212-1234560
		//parameter �ޱ�
		String jumin_no = request.getParameter("jumin_no");
		
		//�迭
		
		//�ֹΰ�ü����
		Jumin jumin = new Jumin();
		jumin.setJumin_no(jumin_no); //�ֹι�ȣ �ֱ�
		
		//�ΰ����� ����
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
		
		//�����͸� �迭�� �����
		
		request.setAttribute("map", map);
		
		
		RequestDispatcher disp = request.getRequestDispatcher("jumin_result.jsp");
		
		disp.forward(request, response);
		
	}

}
