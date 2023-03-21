package action;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import myutil.Bmi;

/**
 * Servlet implementation class BmiResisterAction
 */
@WebServlet("/bmi_register.do")
public class BmiResisterAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("utf-8");
		
		String how_height = request.getParameter("how_height");
		String how_weight = request.getParameter("how_weight");
		
		String bmi_str = request.getParameter("bmi_str");
		String b_state = request.getParameter("b_state");
		
		Bmi bmi = new Bmi();
		bmi.setHeight_no(how_height);
		bmi.setWeight_no(how_weight);
		
		
		
		Map<String, Object> bmi_res_map = bmi.getBmi(); 
		//bmi_res_map.put("bmi_str",bmi_str);
		//bmi_res_map.get(bmi_str);
		//bmi.getBmi();
		//bmi_res_map.put("bmi_str", bmi_str);
		//bmi_res_map.put("b_state", b_state);
		
		//bmi_res_map.put(how_weight, bmi_res_map);
		//b_state
		
		
		//request.setAttribute("bmi_str", bmi_str);
		//request.setAttribute("b_state", b_state);
		
		request.setAttribute("bmi_str", bmi_res_map.put("bmi_str", bmi_str));
		request.setAttribute("b_state", bmi_res_map.put("b_state", b_state));
		
		RequestDispatcher disp= request.getRequestDispatcher("bmi_result.jsp");
		
		disp.forward(request, response);
		
		
	
		
	}

}
