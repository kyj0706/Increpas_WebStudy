package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

/**
 * Servlet implementation class CalcAction
 */
@WebServlet("/calc.do")
public class CalcAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int su1 = Integer.parseInt(request.getParameter("su1"));
		int su2 = Integer.parseInt(request.getParameter("su2"));
		
		
		//4Ä¢¿¬»ê
		int plus  		= su1 + su2;
		int minus 		= su1 - su2;
		int multiply	= su1 * su2;
		int divide		= (su2==0)? 0:su1/su2;
		
		//String json = String.format("{\"plus\":%d, \"minus\":%d, \"multiply\":%d, \"divide\":%d}",plus,		minus,			multiply,		divide);
		JSONObject json = new JSONObject();
		json.put("plus", plus);
		json.put("minus", minus);
		json.put("multiply", multiply);
		json.put("divide", divide);

		
		
		
		response.setContentType("text/json; charset=utf-8;");
		response.getWriter().print(json.toString());
		
		
		
	}

}
