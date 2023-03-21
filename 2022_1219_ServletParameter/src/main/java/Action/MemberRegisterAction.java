package Action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberRegisterAction
 */
@WebServlet("/member_register.do")

public class MemberRegisterAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//  /member_register.do?name=ȫ�浿&id=hong&pwd=1234&gender=����&.....
		
		//POST����ϰ�� �������ڵ� ����
		request.setCharacterEncoding("utf-8");
		
	    String name 	=	request.getParameter("name");
	    //System.out.println(name);
	    String id		=	request.getParameter("id");
	    String pwd		=	request.getParameter("pwd");
	    String gender	=	request.getParameter("gender");
	    String blood	=	request.getParameter("blood");
	    String profile	=	request.getParameter("profile");
	    
	    // ��� �ޱ�  : hobby=����&hobby=��ȭ(checkbox: check�� �׸� �Ѿ�´�)
	    // String [] hobby_array= { "����" , "��ȭ"};
	    String [] hobby_array = request.getParameterValues("hobby");
	    String hobby_list = "��̾���";
	    
	    
	    if(hobby_array !=null) {
	    	
	    	StringBuffer sb1 = new StringBuffer();
	    	//���� loop
	    	for(String hobby : hobby_array) {
	    		sb1.append(hobby);
	    		sb1.append(" ");
	    	}
	    	
	    	//sb1 => "���� ��ȭ "
	    	hobby_list = sb1.toString().trim();// "���� ��ȭ"
	    }
	    
	    // ģ�� �ޱ� :  friend=&friend=&friend=&friend=
	    // String [] friend_array = { "", "¯��", "ö��", "" };
	    String [] friend_array = request.getParameterValues("friend");
	    
	    String friend_list = "";
	    
	    StringBuffer sb2 = new StringBuffer();
	    for(String friend : friend_array) {
	    	
	    	sb2.append(friend);
	    	sb2.append(" ");
	    }
	    
	    //sb2 = "    "  or " ¯��   " or " ¯�� ö��  ";
	    friend_list = sb2.toString().trim(); //"" or "¯��" or "¯�� ö��"
	    
	    if(friend_list.isEmpty()) friend_list ="ģ������";
	    
	    
	    
	    //����ó��               mime-type: image/jpg   
	    response.setContentType("text/html; charset=utf-8;");
	    
	    PrintWriter out = response.getWriter();
	    
	    out.println("<html>");
	    out.println("<head><title></title></head>");
	    out.println("<body>");
	    out.println("<table width='400' border='1'>");
	    out.printf("<tr><th width=\'30%%\'>�̸�</th><td>%s</td></tr>", name);
	    out.printf("<tr><th>���̵�</th><td>%s</td></tr>", id);
	    out.printf("<tr><th>��й�ȣ</th><td>%s</td></tr>", pwd);
	    out.printf("<tr><th>����</th><td>%s</td></tr>", gender);
	    out.printf("<tr><th>������</th><td>%s</td></tr>", blood);
	    out.printf("<tr><th>���</th><td>%s</td></tr>", hobby_list);
	    out.printf("<tr><th>ģ��</th><td>%s</td></tr>", friend_list);
	    out.printf("<tr><th>�ڱ�Ұ�</th><td>%s</td></tr>", profile);
	    out.println("</table>");
	    
	    out.println("<a href='_07_form_tag_table.html'>�ٽ��ϱ�</a>");
	    out.println("</body>");
	    out.println("</html>");
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
		
	}

}
