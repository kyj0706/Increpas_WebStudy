package action.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import annotation.RequestMapping;
import dao.ProductDao;
import vo.ProductVo;

public class ProductController {

//상품목록
	@RequestMapping("/product/list.do")
	public String list(HttpServletRequest request, HttpServletResponse response) {

		// 상품목록 리스트
		List<ProductVo> list = ProductDao.getInstance().selectList();

		//System.out.println( list + "product_list_controller");
		// request binding
		request.setAttribute("list", list);

		return "main_page.jsp";
	}
	
	@RequestMapping("/product/detail.do")
	public String detail(HttpServletRequest request, HttpServletResponse response) {

		int product_idx = Integer.parseInt(request.getParameter("product_idx"));
		
		ProductVo vo = ProductDao.getInstance().selectOne(product_idx);
		
		request.setAttribute("vo", vo);

		return "detail.jsp";
	}
	
	@RequestMapping("/product/insert_form.do")
	public String insert_form(HttpServletRequest request, HttpServletResponse response) {

		return "product_insert_form.jsp";
	}
	
	@RequestMapping("/product/insert.do")
	public String insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String web_path  = "/images/";
		String save_path = "";
		
		//웹경로->절대경로 구하는 객체
		ServletContext application = request.getServletContext();
		save_path                  = application.getRealPath(web_path);
		System.out.println(application);
		System.out.println(save_path);
		
		int    max_size  = 1024*1024*100;      //업로드최대용량:100MB
		
		//화일업로드용 파라메터처리
		MultipartRequest mr = new MultipartRequest( request,   //request위임
				                                    save_path, //저장위치
				                                    max_size,  //저장크키  
				                                    "utf-8",   //수신인코딩
				                                    //이미화일이 존재하면 이름을 변경해서 업로드
				                                    new DefaultFileRenamePolicy() 
				                                    );
		System.out.println(mr);
		//업로드된 화일정보 구하기
		String product_image1= "no_file";
		String product_image2= "no_file";
		String product_image3= "no_file";
		String product_image4= "no_file";
		
		//방법1)
		File  f1 = mr.getFile("product_image1"); //getFile("parameter name")
		if(f1 != null) {
			product_image1 = f1.getName();
		}
		System.out.println(f1);
		
		File  f2 = mr.getFile("product_image2"); //getFile("parameter name")
		if(f2 != null) {
			product_image2 = f2.getName();
		}
		System.out.println(f2);
		
		File  f3 = mr.getFile("product_image3"); //getFile("parameter name")
		if(f3 != null) {
			product_image3 = f3.getName();
		}
		System.out.println(f3);
		
		File  f4 = mr.getFile("product_image4"); //getFile("parameter name")
		if(f4 != null) {
			product_image4 = f4.getName();
		}
		System.out.println(f4);
		
		String product_name     = mr.getParameter("product_name");
		int    product_price    = Integer.parseInt(mr.getParameter("product_price"));
		String product_company  = mr.getParameter("product_company");
		String product_category = mr.getParameter("product_category");
		String product_content  = mr.getParameter("product_content");
		System.out.println(product_name);
		System.out.println(product_price);
		System.out.println(product_company);
		System.out.println(product_category);
		System.out.println(product_content);
		/*
		 * try { product_price = Integer.parseInt(mr.getParameter("product_price"));
		 * 
		 * } catch (NumberFormatException e) { // TODO Auto-generated catch block
		 * //e.printStackTrace(); }
		 */
		
		// 3.MemberVo 포장
		ProductVo vo = new ProductVo(product_name, product_content, product_price, 
									 product_company, product_category,
									 product_image1, product_image2, product_image3, product_image4);

		// 4.DB insert
		int res = ProductDao.getInstance().insert(vo);
		System.out.println(res);
		
		return "redirect:../product/list.do";
	}
	

}