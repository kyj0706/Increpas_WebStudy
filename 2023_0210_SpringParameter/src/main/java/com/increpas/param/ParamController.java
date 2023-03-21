package com.increpas.param;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import vo.PersonVo;

@Controller
public class ParamController {
	
	public ParamController() {
		// TODO Auto-generated constructor stub
		//진짜 만들어진거야???
		System.out.println("--ParamController()--");
		
	}
	
	//입력폼 띄우기
	@RequestMapping("/insert_form.do")
	public String insert_from() {
		
		
		return "insert_form";
	}
	
	
	//낱개로 받기 
	@RequestMapping("/insert1.do")
	@ResponseBody
	public String insert1(String name, int age, String tel  ) {
		
		//수신된 파라미터 받기
		System.out.println("--수신된 낱개 파라미터 받기--");
		
		System.out.printf("이름:%s\n",name);		
		System.out.printf("나이:%d\n",age);		
		System.out.printf("번호:%s\n",tel);		
		return "success";
	}
	//객체로 받기
	@RequestMapping("/insert2.do")
	@ResponseBody
	public String insert2(PersonVo vo) {
		System.out.println("--수신된 객체로 파라미터 받기--");
		System.out.printf("이름:%s\n",vo.getName());		
		System.out.printf("나이:%d\n",vo.getAge());		
		System.out.printf("번호:%s\n",vo.getTel());		
		
		return "success2";
	}
	
	//맵으로 받기
	@RequestMapping("/insert3.do")
	@ResponseBody
	public String insert3(@RequestParam Map map) {
		
		
		System.out.println("--map방식으로 받기--");
		System.out.println(map);
		System.out.println(map.keySet());
		System.out.println(map.values());
		
		System.out.printf("이름:%s\n",map.get("name"));		
		System.out.printf("나이:%s\n",map.get("age"));		
		System.out.printf("번호:%s\n",map.get("tel"));	
		
		
		return "success3";
	}
	
	
}
