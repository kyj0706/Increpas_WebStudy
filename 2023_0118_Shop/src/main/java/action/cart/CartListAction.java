package action.cart;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CartDao;
import dao.CategoryDao;
import vo.CartVo;
import vo.CategoryVo;
import vo.MemberVo;

/**
 * Servlet implementation class CartListAction
 */
@WebServlet("/product/cart_list.do") //URL 경로
public class CartListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		MemberVo user = (MemberVo) request.getSession().getAttribute("user");
		
		if(user==null) {
			
			response.sendRedirect("../member/login_form.do?reason=logout");
			
			
			return;
		}
		
		int mem_idx = user.getMem_idx();
		
		List<CartVo> list = CartDao.getInstance().selectList(mem_idx);
		
		//총액가지고 오기
		int total_amount = CartDao.getInstance().selectTotalAmount(mem_idx);
		
		List<CategoryVo> category_list = CategoryDao.getInstance().selectList();
		
		request.setAttribute("list", list);
		request.setAttribute("total_amount", total_amount);
		request.setAttribute("category_list", category_list);
		
		
		
		//forward 코드

		String forward_page = "cart_list.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);

	}

}

