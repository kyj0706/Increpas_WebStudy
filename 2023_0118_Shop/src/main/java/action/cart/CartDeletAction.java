package action.cart;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CartDao;
import vo.CartVo;

/**
 * Servlet implementation class CartDeletAction
 */
@WebServlet("/product/cart_del.do") //URL °æ·Î
public class CartDeletAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		int c_idx = Integer.parseInt(request.getParameter("c_idx"));
		
		CartVo vo = new CartVo();
		vo.setC_idx(c_idx);
		
		int res = CartDao.getInstance().delete(vo);
		
		response.sendRedirect("cart_list.do");
	}

}

