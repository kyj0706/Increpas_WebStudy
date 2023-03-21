package action.cart;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CartDao;
import vo.CartVo;

/**
 * Servlet implementation class CartDeleteAllAction
 */
@WebServlet("/product/cart_delete_all.do") // URL 경로
public class CartDeleteAllAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String [] c_idx_arr  = request.getParameterValues("c_idx");
		
		
//강사님 ver_(방법1)		
//강사님 ver_(방법2)		
		
		
//3차_23-01-25(강사님 참고해서 ver)
		for(String str_c_idx :c_idx_arr) {
			int c_idx = Integer.parseInt(str_c_idx);
			CartVo vo = new CartVo();
			vo.setC_idx(c_idx);
			
			int res = CartDao.getInstance().delete(vo);
		}
		
		response.sendRedirect("cart_list.do");
		
		
		
		
		
//2차시도		
		
//		String c_idx_list = "";
//		StringBuffer sb = new StringBuffer();
//		
//		  if(c_idx_arr !=null) { 
//			  for(String c_idx : c_idx_arr) { 
//		  
//			  sb.append(c_idx);
//			  sb.append(" "); 
//		  
//		  
//			  	} 
//		  }
//		  c_idx_list = sb.toString();
//		  System.out.println(c_idx_list); 
//		 
	
//		  Map<String, String> map = new HashMap<String,String>();
//		  
//		  map.put("c_idx", c_idx_list);
//		  
//		  
//		  System.out.println(map.put("c_idx", c_idx_list));
//		  
//		  List<CartVo> list = CartDao.getInstance().delete_all(map);
		 
		
		
//1차시도
		/*
		 * String[] checked_all_arr = request.getParameterValues(checked_val); String[]
		 * checked_val_arr = request.getParameterValues(checked_val);
		 * System.out.println(checked_val_arr);
		 * 
		 * String checked_all_list =""; String checked_val_list ="";
		 * 
		 * StringBuffer sb_all = new StringBuffer();
		 * 
		 * for(String check_all : checked_all_arr ) { System.out.println(check_all);
		 * sb_all.append(check_all); }
		 * 
		 * StringBuffer sb_val = new StringBuffer();
		 * 
		 * for(String check_val : checked_val_arr ) { System.out.println(check_val);
		 * sb_val.append(check_val); }
		 */
	
		
		
		
		
		
		
		//forward 코드

		//response.sendRedirect("cart_list.do");
	}

}
