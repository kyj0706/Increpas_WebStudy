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

//��ǰ���
	@RequestMapping("/product/list.do")
	public String list(HttpServletRequest request, HttpServletResponse response) {

		// ��ǰ��� ����Ʈ
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
		
		//�����->������ ���ϴ� ��ü
		ServletContext application = request.getServletContext();
		save_path                  = application.getRealPath(web_path);
		System.out.println(application);
		System.out.println(save_path);
		
		int    max_size  = 1024*1024*100;      //���ε��ִ�뷮:100MB
		
		//ȭ�Ͼ��ε�� �Ķ����ó��
		MultipartRequest mr = new MultipartRequest( request,   //request����
				                                    save_path, //������ġ
				                                    max_size,  //����ũŰ  
				                                    "utf-8",   //�������ڵ�
				                                    //�̹�ȭ���� �����ϸ� �̸��� �����ؼ� ���ε�
				                                    new DefaultFileRenamePolicy() 
				                                    );
		System.out.println(mr);
		//���ε�� ȭ������ ���ϱ�
		String product_image1= "no_file";
		String product_image2= "no_file";
		String product_image3= "no_file";
		String product_image4= "no_file";
		
		//���1)
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
		
		// 3.MemberVo ����
		ProductVo vo = new ProductVo(product_name, product_content, product_price, 
									 product_company, product_category,
									 product_image1, product_image2, product_image3, product_image4);

		// 4.DB insert
		int res = ProductDao.getInstance().insert(vo);
		System.out.println(res);
		
		return "redirect:../product/list.do";
	}
	

}