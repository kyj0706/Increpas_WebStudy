package controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import service.ProductService;
import vo.ProductVo;

@Controller
@RequestMapping("/product/")
public class ProductController {

	
	ProductService product_service;
	
	public ProductController(ProductService product_service) {
		super();
		this.product_service = product_service;
	}


	@RequestMapping("list.do")
	public String list(Model model) {

		Map map = product_service.selectTotalList();
		
		model.addAttribute("map", map);
		
		return "product/product_list";
	}
	
	
	@RequestMapping("insert_in.do")
	public String insert_in(ProductVo vo) {
		
		try {
			product_service.insert_in(vo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		return "redirect:list.do";
	}
	
	
	@RequestMapping("insert_out.do")
	public String insert_out(ProductVo vo, Model model) {
		
		try {
			product_service.insert_out(vo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			//System.out.println(e.getMessage());
			model.addAttribute("error", e.getMessage());
		}
		

		return "redirect:list.do";
	}
	
	//입고취소
	//product/delete_in.do?idx=7
	@RequestMapping("delete_in.do")
	public String delete_in(int idx, Model model) {
		
		try {
			product_service.delete_in(idx);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			model.addAttribute("error", e.getMessage());
			
		}

		return "redirect:list.do";
	}
	
	//출고취소
	//product/delete_out.do?idx=7
	@RequestMapping("delete_out.do")
	public String delete_out(int idx, Model model) {
			
		try {
			product_service.delete_out(idx);
		} catch (Exception e) {
			// TODO: handle exception
			//model.addAttribute("error", e.getMessage());
		}

		return "redirect:list.do";
	}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
