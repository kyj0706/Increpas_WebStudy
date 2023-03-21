package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;


/**
 * Servlet implementation class JSONParseAction
 */
@WebServlet("/JSONParseAction")
public class JSONParseAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try {
			
			String str_json = "{\"name\":\"ȫ�浿\", \"age\":\"30\", \"tel\":\"010-111-1234\" }";
			
			JSONObject json =  new JSONObject(str_json);
			
			String name = json.getString("name");
			int    age  = json.getInt("age");
			String tel  = json.getString("tel");
			
			System.out.printf("name:%s age:%d tel:%s\n",name,age,tel);
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
