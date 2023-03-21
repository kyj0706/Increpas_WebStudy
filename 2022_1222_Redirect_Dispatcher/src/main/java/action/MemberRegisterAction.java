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
		//  /member_register.do?name=홍길동&id=hong&pwd=1234&gender=남자&.....
		
		//POST방식일경우 수신인코딩 설정
		request.setCharacterEncoding("utf-8");
		
	    String name 	=	request.getParameter("name");
	    String jumin_no = 	request.getParameter("jumin_no");
	    //System.out.println(name);
	    String id		=	request.getParameter("id");
	    String pwd		=	request.getParameter("pwd");
	    String gender	=	request.getParameter("gender");
	    String blood	=	request.getParameter("blood");
	    String profile	=	request.getParameter("profile");
	    
	    // 취미 받기  : hobby=독서&hobby=영화(checkbox: check된 항목만 넘어온다)
	    // String [] hobby_array= { "독서" , "영화"};
	    String [] hobby_array = request.getParameterValues("hobby");
	    String hobby_list = "취미없음";
	    
	    
	    if(hobby_array !=null) {
	    	
	    	StringBuffer sb1 = new StringBuffer();
	    	//개선 loop
	    	for(String hobby : hobby_array) {
	    		sb1.append(hobby);
	    		sb1.append(" ");
	    	}
	    	
	    	//sb1 => "독서 영화 "
	    	hobby_list = sb1.toString().trim();// "독서 영화"
	    }
	    
	    // 친구 받기 :  friend=&friend=&friend=&friend=
	    // String [] friend_array = { "", "짱구", "철수", "" };
	    String [] friend_array = request.getParameterValues("friend");
	    
	    String friend_list = "";
	    
	    StringBuffer sb2 = new StringBuffer();
	    for(String friend : friend_array) {
	    	
	    	sb2.append(friend);
	    	sb2.append(" ");
	    }
	    
	    //sb2 = "    "  or " 짱구   " or " 짱구 철수  ";
	    friend_list = sb2.toString().trim(); //"" or "짱구" or "짱구 철수"
	    
	    if(friend_list.isEmpty()) friend_list ="친구없음";
	    
	    
	    //그래서 
	    //전송(연결) 데이터를 1개의 객체로 묶어주자
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
	    
	    
	    
	    //request Binding 하겠다 ! 
	    //이렇게 해도 된다. 근데 잘못하면 데이터가 유실되거나 문제가 생길수 있따↑
	    /*
	    request.setAttribute("name", name);
	    request.setAttribute("id", id);
	   */
	    
	    
	    
	    //Data 결과를 member_result.jsp에게 forward할꺼다 .
	    RequestDispatcher disp = request.getRequestDispatcher("member_result.jsp");
	    
	    disp.forward(request, response);
		
	}

}
