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
@WebServlet("/product/cart_insert.do") //URL ���
public class CartInsertAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//1.�Ķ���� �ޱ�
		int p_idx = Integer.parseInt(request.getParameter("p_idx"));
		int mem_idx = Integer.parseInt(request.getParameter("mem_idx"));
		
		//2. CartVo ����
		CartVo vo = new CartVo();
		vo.setP_idx(p_idx);
		vo.setMem_idx(mem_idx);
		
		//3.p_idx & mem_idx ��ٱ��� �����˻�
		CartVo resVo = CartDao.getInstance().selectOne(vo);
		
		String result ="success";
		
		if(resVo!=null) {
			result = "exist";
		}else {
			
			int res = CartDao.getInstance().insert(vo);
		}
		//��� Json����
		JSONObject json = new JSONObject();
		json.put("result", result);
		
		
		
		//�������
		response.setContentType("text/json; charset=utf-8;");
		response.getWriter().print(json.toString());
		
		
	}

}

