package action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.KakaoSearchUtils;
import vo.LocalVo;

/**
 * Servlet implementation class KakaoLocalAction
 */
@WebServlet("/local_search.do")
public class KakaoLocalAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 들어오는 정보
		// /local_search.do?keyword=지역&page=1&size=15&radius=1000&latitude=32.1111&longitude=126.1111
		//local_search.do?latitude=37.483782&longitude=126.9003409&keyword=약국&page=1&size=15&radius=200
		request.setCharacterEncoding("utf-8");
		
		//파라미터 받기
		
		String keyword = request.getParameter("keyword");
		
		
		int page = 1;
		int size = 15;
		int radius = 200;
		double latitude =0;
		double longitude=0;
		
		
		try {
			page = Integer.parseInt(request.getParameter("page"));
			size = Integer.parseInt(request.getParameter("size"));
			radius = Integer.parseInt(request.getParameter("radius"));
			latitude = Double.parseDouble(request.getParameter("latitude"));
			longitude = Double.parseDouble(request.getParameter("longitude"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e1.printStackTrace();
		}
		
		List<LocalVo> list = null;
		
		try {
			list = KakaoSearchUtils.getLocalListFromJson(keyword, latitude, longitude, radius, page, size);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		
		
		
		
		page = (page -1) * size+1;
		
		
		//request binding
		request.setAttribute("list", list);
		request.setAttribute("page", page);
		
		
		
		
		RequestDispatcher disp = request.getRequestDispatcher("kakao_local_list.jsp");
		disp.forward(request, response);
	}

}
