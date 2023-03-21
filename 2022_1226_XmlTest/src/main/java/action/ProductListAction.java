package action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.MySearchUtil;
import vo.ProductVo;

/**
 * Servlet implementation class ProductListAction
 */
@WebServlet("/product_search.do")
public class ProductListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//product_search.do?p_name=테레비&
		request.setCharacterEncoding("utf-8");
		
		int start = 1;
		int display =10;
		int page =  1;
		
		
		String p_name = request.getParameter("p_name");
		 
		if(p_name == null) p_name = "";
		
		try {
			page = Integer.parseInt(request.getParameter("page"));
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		try {
			display = Integer.parseInt(request.getParameter("display"));
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		//page에 해당되는 시작위치 계산
		start = (page-1) * display+1;
		
		
		
		
		List<ProductVo> list = MySearchUtil.search_shop(p_name, start, display);
		
		request.setAttribute("list", list);
		request.setAttribute("start", start);
		
		
		//forward
		RequestDispatcher disp = request.getRequestDispatcher("product_list.jsp");
		disp.forward(request, response);
	}

}
