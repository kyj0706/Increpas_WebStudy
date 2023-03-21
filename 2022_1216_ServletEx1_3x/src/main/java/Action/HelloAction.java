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
			HttpServletRequest  request, //요청처리객체(클라이언트의 요청정보가 들어온다)
			HttpServletResponse response //응답처리객체
			) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//System.out.println("---HellowAction:service()(3.1)---");
		//요청처리
	    //  /2022_1216_ServletEx1_3x/hello.do
		//  /2022_1216_ServletEx1_3x/hello.do?nation=kor
		
		String nation = request.getParameter("nation");
		//System.out.println(nation);
		if(nation==null) nation = "kor";
		
		String nation_name="";
		String greeting="";
		
		if(nation.equals("kor")) {
			
			nation_name  = "대한민국";
			greeting     = "안녕하세요";
			
		}else if(nation.equals("eng")) {
			
			nation_name  = "미쿡/영국";
			greeting     = "Hi Everyone";
			
		}else if(nation.equals("jpn")) {
			
			nation_name  = "일본";
			greeting     = "오겡끼데스까";
			
		}else if(nation.equals("chn")) {
			
			nation_name  = "중국";
			greeting     = "니하오(마)";
			
		}else if(nation.equals("ger")) {
			
			nation_name  = "독일";
			greeting     = "구텐탁";
			
		}else if(nation.equals("fra")) {
			
			nation_name  = "프랑스";
			greeting     = "봉뷰르";
			
		}else {
			nation_name  = "국적불명";
			greeting     = "뭐지?";
		}
		
		
		
		//응답처리               mime-type: text/html or text/mxl or text/json
		//                                  image/jpg or image/jpeg or image/tiff..      
		response.setContentType("text/html; charset=utf-8;");
		
		PrintWriter out = response.getWriter();//출력(전송)스트림
		//out을 이용해서 전송한 데이터가 클라이언트(브라우저)에게 전송된다
		out.println("<html>");
		out.println("<head><title>인사말</title></head>");
		out.println("<body>");
		out.printf("나라명: %s<br>", nation_name);
		out.printf("인사말: %s<br>", greeting);
		out.println("<a href='hello.html'>다시하기</a>");
		out.println("</body>");
		out.println("</html>");
		
		
	}

}
