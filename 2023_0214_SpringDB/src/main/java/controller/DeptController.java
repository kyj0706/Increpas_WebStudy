package controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.DeptDao;
import vo.DeptVo;

@Controller
public class DeptController {
	
	DeptDao dept_Dao;

	
	public DeptController(DeptDao dept_Dao) {
		super();
		this.dept_Dao = dept_Dao;
	}




	@RequestMapping("/dept/list.do")
	public String list(Model model) {
		
		List<DeptVo> list = dept_Dao.selectList();
		
		//model을 통해서 list(data)를 DispacherServlet에게 전달 .
		//결과적으로 forward될 뷰의 request로 binding된다.
		model.addAttribute("list",list);
		
		//DispacherSerlert에게 ViewName을 반환하면
		//DS가 ViewResolver에게 
		//prefix = "/WEB-INF/views/"
		//suffix = ".jsp"
		
		return "dept/dept_list";//ViewName
	}
	

}
