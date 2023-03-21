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
		//��¥ ��������ž�???
		System.out.println("--ParamController()--");
		
	}
	
	//�Է��� ����
	@RequestMapping("/insert_form.do")
	public String insert_from() {
		
		
		return "insert_form";
	}
	
	
	//������ �ޱ� 
	@RequestMapping("/insert1.do")
	@ResponseBody
	public String insert1(String name, int age, String tel  ) {
		
		//���ŵ� �Ķ���� �ޱ�
		System.out.println("--���ŵ� ���� �Ķ���� �ޱ�--");
		
		System.out.printf("�̸�:%s\n",name);		
		System.out.printf("����:%d\n",age);		
		System.out.printf("��ȣ:%s\n",tel);		
		return "success";
	}
	//��ü�� �ޱ�
	@RequestMapping("/insert2.do")
	@ResponseBody
	public String insert2(PersonVo vo) {
		System.out.println("--���ŵ� ��ü�� �Ķ���� �ޱ�--");
		System.out.printf("�̸�:%s\n",vo.getName());		
		System.out.printf("����:%d\n",vo.getAge());		
		System.out.printf("��ȣ:%s\n",vo.getTel());		
		
		return "success2";
	}
	
	//������ �ޱ�
	@RequestMapping("/insert3.do")
	@ResponseBody
	public String insert3(@RequestParam Map map) {
		
		
		System.out.println("--map������� �ޱ�--");
		System.out.println(map);
		System.out.println(map.keySet());
		System.out.println(map.values());
		
		System.out.printf("�̸�:%s\n",map.get("name"));		
		System.out.printf("����:%s\n",map.get("age"));		
		System.out.printf("��ȣ:%s\n",map.get("tel"));	
		
		
		return "success3";
	}
	
	
}
