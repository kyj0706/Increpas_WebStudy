package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Url;

import action.ListAction;
import action.ViewAction;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.do") //URL 경로
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//URL 과 URI의 차이점 
		//URL :  http://localhost:9090/2023_0125_MVCTest/*.do   => 클라이언트가 요청하는 전체주소 
		//URI : 					  /2023_0125_MVCTest/*.do
		
		//System.out.println("FrontController");
		String Uri = request.getRequestURI();
		//System.out.println(Uri);
		
		//이렇게 값이 들어오면 /list.do  또는 /view.do 만 빼와야한다.
		//uri = "/2023_0125_MVCTest/list.do"
		//uri = "/2023_0125_MVCTest/view.do"
		
		String forward_page ="";
		
		//방법1
		if(Uri.contains("list")) {
			
			//System.out.println("--list:목록보기--");
			ListAction action = new ListAction();
			forward_page = action.execute(request, response);
			
			request.getRequestDispatcher(forward_page).forward(request, response);
			
		}else if(Uri.contains("view")) {
			
			//System.out.println("--view:상세보기--");
			ViewAction action = new ViewAction();
			forward_page = action.execute(request, response);
			
			request.getRequestDispatcher(forward_page).forward(request, response);
			
		}
		
		
		//forward 코드
		/*
		String forward_page = "";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);
		*/
	}

}

