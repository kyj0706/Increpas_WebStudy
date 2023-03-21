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
		//  /member_register.do?name=홍길동&id=hong&pwd=1234&gender=남자&.....
		
		//POST방식일경우 수신인코딩 설정
		request.setCharacterEncoding("utf-8");
		
	    String name 	=	request.getParameter("name");
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
	    
	    
	    
	    //응답처리               mime-type: image/jpg   
	    response.setContentType("text/html; charset=utf-8;");
	    
	    PrintWriter out = response.getWriter();
	    
	    out.println("<html>");
	    out.println("<head><title></title></head>");
	    out.println("<body>");
	    out.println("<table width='400' border='1'>");
	    out.printf("<tr><th width=\'30%%\'>이름</th><td>%s</td></tr>", name);
	    out.printf("<tr><th>아이디</th><td>%s</td></tr>", id);
	    out.printf("<tr><th>비밀번호</th><td>%s</td></tr>", pwd);
	    out.printf("<tr><th>성별</th><td>%s</td></tr>", gender);
	    out.printf("<tr><th>혈액형</th><td>%s</td></tr>", blood);
	    out.printf("<tr><th>취미</th><td>%s</td></tr>", hobby_list);
	    out.printf("<tr><th>친구</th><td>%s</td></tr>", friend_list);
	    out.printf("<tr><th>자기소개</th><td>%s</td></tr>", profile);
	    out.println("</table>");
	    
	    out.println("<a href='_07_form_tag_table.html'>다시하기</a>");
	    out.println("</body>");
	    out.println("</html>");
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
		
	}

}
