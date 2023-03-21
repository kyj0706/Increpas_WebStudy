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
@WebServlet("*.do") //URL ���
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//URL �� URI�� ������ 
		//URL :  http://localhost:9090/2023_0125_MVCTest/*.do   => Ŭ���̾�Ʈ�� ��û�ϴ� ��ü�ּ� 
		//URI : 					  /2023_0125_MVCTest/*.do
		
		//System.out.println("FrontController");
		String Uri = request.getRequestURI();
		//System.out.println(Uri);
		
		//�̷��� ���� ������ /list.do  �Ǵ� /view.do �� ���;��Ѵ�.
		//uri = "/2023_0125_MVCTest/list.do"
		//uri = "/2023_0125_MVCTest/view.do"
		
		String forward_page ="";
		
		//���1
		if(Uri.contains("list")) {
			
			//System.out.println("--list:��Ϻ���--");
			ListAction action = new ListAction();
			forward_page = action.execute(request, response);
			
			request.getRequestDispatcher(forward_page).forward(request, response);
			
		}else if(Uri.contains("view")) {
			
			//System.out.println("--view:�󼼺���--");
			ViewAction action = new ViewAction();
			forward_page = action.execute(request, response);
			
			request.getRequestDispatcher(forward_page).forward(request, response);
			
		}
		
		
		//forward �ڵ�
		/*
		String forward_page = "";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);
		*/
	}

}

