package Action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class calcAction
 */
@WebServlet("/calc.do")
public class calcAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//��û
		String su1_str = request.getParameter("su1");
		String su2_str = request.getParameter("su2");
		
		int su1 = Integer.parseInt(su1_str);
		int su2 = Integer.parseInt(su2_str);
		
		
		
		
		//������
		response.setContentType("text/html; charset=utf-8;");
		
		PrintWriter out = response.getWriter();//���(����
		out.println("<html>");
		out.println("<head>><title>���...</head></title>");
		out.println("<body>");
		out.println("<h3>:::�����:::</h3>");
		
		out.printf("<h3>%d + %d = %d</h3>",su1,su2,su1+su2);
		out.printf("<h3>%d - %d = %d</h3>",su1,su2,su1-su2);
		out.printf("<h3>%d * %d = %d</h3>",su1,su2,su1*su2);
		
		if(su1==0 || su2==0) {
			out.println("<h3  style='color: red;'>0���δ� ������ �����ϴ�.</h3><br>");
		}else {
			out.printf("<h3>%d / %d = %d</h3>",su1,su2,su1/su2);
			out.printf("<h3>%d %% %d = %d</h3>",su1,su2,su1%su2);
		}
		
		
		
		
		out.println("<a href='calc.html'>�ٽ��ϱ�</a>");
		out.println("</body>");
		out.println("</thml>");
		
		
		
	}

}
