package action.product;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import dao.ProductDao;
import vo.ProductVo;

/**
 * Servlet implementation class ProductCheckNumAction
 */
@WebServlet("/product/check_num.do") //URL °æ·Î
public class ProductCheckNumAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("utf-8");
		
		String p_num =request.getParameter("p_num");
		
		ProductVo vo = ProductDao.getInstance().selectOne(p_num);
		
		boolean bResult = (vo == null);
		
		JSONObject json = new JSONObject();
		json.put("res", bResult);
	
		response.setContentType("Text/json; charset=utf-8;");
		response.getWriter().print(json.toString());

	}

}

