package action;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

import vo.PersonVo;

/**
 * Servlet implementation class PersonXmlAction
 */
@WebServlet("/person.do")
public class PersonXmlAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try {
			//XML Parser : SAXBuilder(jdom-2.0.6.1.jar)
			SAXBuilder builder = new SAXBuilder();
			
			
			//방법1: url을 이용해서 xml 파일 읽어 오기
			/*
			String str_url = "http://localhost:9090/2022_1226_XmlTest/person.xml";
			URL  url       =  new URL(str_url);
			*/
			
			//방법2: file -> 웹경로가 아닌 결대 결로를 작성해야 한다.
			String web_path = "/";
			ServletContext application =  request.getServletContext();
			String abs_path = application.getRealPath(web_path);
			
			//System.out.println(abs_path);
			File file = new File(abs_path, "person.xml");
			Document doc = builder.build(file);
			System.out.println(doc);
			
			Element root = doc.getRootElement();
			
			
			List<Element> person_list = root.getChildren("person");
			
			//XML -> PersonVo List로 담을객체
			List<PersonVo> p_list = new ArrayList<PersonVo>();
			
			
			
			for(Element person : person_list) {
				String name = person.getChildText("name");
				String nickname = person.getChild("name").getAttributeValue("nickname");
				int age = Integer.parseInt(person.getChildText("age"));
				String tel = person.getChildText("tel");
				String hometel = person.getChild("tel").getAttributeValue("hometel");
				
				
				//추출된 정보 VO로 포장
				PersonVo personVo = new PersonVo();
				personVo.setName(name);
				personVo.setNickname(nickname);
				personVo.setAge(age);
				personVo.setTel(tel);
				personVo.setHometel(hometel);
				
				p_list.add(personVo);
				
			}//end-for
			
			//request binding
			request.setAttribute("p_list", p_list);
			
			//forward 해야한다.
			RequestDispatcher disp = request.getRequestDispatcher("person_list.jsp");
			disp.forward(request, response);
			
			
			
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

}
