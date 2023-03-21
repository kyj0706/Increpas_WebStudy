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

/**
 * Servlet implementation class MemberRegisterAction
 */
@WebServlet("/member_register.do")

public class MemberRegisterAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(
			HttpServletRequest  request, 
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//  /member_register.do?name=ȫ�浿&id=hong&pwd=1234&gender=����&.....
		
		//POST����ϰ�� �������ڵ� ����
		request.setCharacterEncoding("utf-8");
		
	    String name 	=	request.getParameter("name");
	    String jumin_no = 	request.getParameter("jumin_no");
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
	    
	    
	    //�׷��� 
	    //����(����) �����͸� 1���� ��ü�� ��������
	    Map<String, String> map = new HashMap<String, String>();
	    map.put("name", name);
	    map.put("jumin_no", jumin_no);
	    map.put("id", id);
	    map.put("pwd", pwd);
	    map.put("gender", gender);
	    map.put("blood", blood);
	    map.put("profile", profile);
	    map.put("hobby_list", hobby_list);
	    map.put("friend_list", friend_list);
	    
	    request.setAttribute("map", map);
	    
	    
	    
	    //request Binding �ϰڴ� ! 
	    //�̷��� �ص� �ȴ�. �ٵ� �߸��ϸ� �����Ͱ� ���ǵǰų� ������ ����� �ֵ���
	    /*
	    request.setAttribute("name", name);
	    request.setAttribute("id", id);
	   */
	    
	    
	    
	    //Data ����� member_result.jsp���� forward�Ҳ��� .
	    RequestDispatcher disp = request.getRequestDispatcher("member_result.jsp");
	    
	    disp.forward(request, response);
		
	}

}
