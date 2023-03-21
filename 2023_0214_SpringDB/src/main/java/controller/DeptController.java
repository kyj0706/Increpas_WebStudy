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
		
		//model�� ���ؼ� list(data)�� DispacherServlet���� ���� .
		//��������� forward�� ���� request�� binding�ȴ�.
		model.addAttribute("list",list);
		
		//DispacherSerlert���� ViewName�� ��ȯ�ϸ�
		//DS�� ViewResolver���� 
		//prefix = "/WEB-INF/views/"
		//suffix = ".jsp"
		
		return "dept/dept_list";//ViewName
	}
	

}
