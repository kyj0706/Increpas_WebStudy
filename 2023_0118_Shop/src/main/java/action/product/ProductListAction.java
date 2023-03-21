package action.product;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CategoryDao;
import dao.ProductDao;
import vo.CategoryVo;
import vo.ProductVo;

/**
 * Servlet implementation class ProductListAction
 */
@WebServlet("/product/list.do") //URL 경로
public class ProductListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//1.Parameter 받기
		String category = request.getParameter("category");
		if(category==null) category ="com001"; 
		
		//2.카테고리별 상품목록 가져오기
		List<ProductVo> list = ProductDao.getInstance().selectList(category);
		
		//2_1 카테고리 목록 가져오기
		List<CategoryVo> category_list = CategoryDao.getInstance().selectList();
		
		//3.request binding
		request.setAttribute("list", list);
		request.setAttribute("category_list", category_list);
		
		//forward 코드

		String forward_page = "product_list.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);

	}

}

