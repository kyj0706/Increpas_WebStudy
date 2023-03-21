package Action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloAction
 */
@WebServlet("/hello.do")
public class HelloAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(
			HttpServletRequest  request, //��ûó����ü(Ŭ���̾�Ʈ�� ��û������ ���´�)
			HttpServletResponse response //����ó����ü
			) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//System.out.println("---HellowAction:service()(3.1)---");
		//��ûó��
	    //  /2022_1216_ServletEx1_3x/hello.do
		//  /2022_1216_ServletEx1_3x/hello.do?nation=kor
		
		String nation = request.getParameter("nation");
		//System.out.println(nation);
		if(nation==null) nation = "kor";
		
		String nation_name="";
		String greeting="";
		
		if(nation.equals("kor")) {
			
			nation_name  = "���ѹα�";
			greeting     = "�ȳ��ϼ���";
			
		}else if(nation.equals("eng")) {
			
			nation_name  = "����/����";
			greeting     = "Hi Everyone";
			
		}else if(nation.equals("jpn")) {
			
			nation_name  = "�Ϻ�";
			greeting     = "���۳�������";
			
		}else if(nation.equals("chn")) {
			
			nation_name  = "�߱�";
			greeting     = "���Ͽ�(��)";
			
		}else if(nation.equals("ger")) {
			
			nation_name  = "����";
			greeting     = "����Ź";
			
		}else if(nation.equals("fra")) {
			
			nation_name  = "������";
			greeting     = "���丣";
			
		}else {
			nation_name  = "�����Ҹ�";
			greeting     = "����?";
		}
		
		
		
		//����ó��               mime-type: text/html or text/mxl or text/json
		//                                  image/jpg or image/jpeg or image/tiff..      
		response.setContentType("text/html; charset=utf-8;");
		
		PrintWriter out = response.getWriter();//���(����)��Ʈ��
		//out�� �̿��ؼ� ������ �����Ͱ� Ŭ���̾�Ʈ(������)���� ���۵ȴ�
		out.println("<html>");
		out.println("<head><title>�λ縻</title></head>");
		out.println("<body>");
		out.printf("�����: %s<br>", nation_name);
		out.printf("�λ縻: %s<br>", greeting);
		out.println("<a href='hello.html'>�ٽ��ϱ�</a>");
		out.println("</body>");
		out.println("</html>");
		
		
	}

}
