package action.cart;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import dao.CartDao;
import vo.CartVo;

/**
 * Servlet implementation class CartInsertAction
 */
@WebServlet("/product/cart_insert.do") //URL 경로
public class CartInsertAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//1.파라미터 받기
		int p_idx = Integer.parseInt(request.getParameter("p_idx"));
		int mem_idx = Integer.parseInt(request.getParameter("mem_idx"));
		
		//2. CartVo 포장
		CartVo vo = new CartVo();
		vo.setP_idx(p_idx);
		vo.setMem_idx(mem_idx);
		
		//3.p_idx & mem_idx 장바구니 정보검색
		CartVo resVo = CartDao.getInstance().selectOne(vo);
		
		String result ="success";
		
		if(resVo!=null) {
			result = "exist";
		}else {
			
			int res = CartDao.getInstance().insert(vo);
		}
		//결과 Json생성
		JSONObject json = new JSONObject();
		json.put("result", result);
		
		
		
		//결과전송
		response.setContentType("text/json; charset=utf-8;");
		response.getWriter().print(json.toString());
		
		
	}

}

