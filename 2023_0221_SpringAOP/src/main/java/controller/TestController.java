package controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import service.TestService;

@Controller
public class TestController {
	
	TestService test_service;

	//����Ʈ���� ������ �������� �뵵
	public TestController(TestService test_service) {
		super();
		this.test_service = test_service;
	}
	
	@RequestMapping("/total_list.do")
	public String total_list(Model model) {
		
		Map map = test_service.selectTotalList();
		
		model.addAttribute("map",map);
		
		return "total_list";
	}

}
