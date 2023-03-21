package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import vo.PersonVo;

@Controller
public class JSONTestController {
	
	@RequestMapping("/map_to_json.do")
	@ResponseBody
	public Map map_to_json() {
		
		Map map = new HashMap();
		
		map.put("name", "�ϱ浿");
		map.put("age", 20);
		map.put("addr", "����� ���Ǳ� ������ 552");
		
		
		return map;
	}
	
	@RequestMapping("/array_to_json.do")
	@ResponseBody
	public String[] array_to_json() {
		
		String [] sido_array = {"����","���","��õ","����","����","����"};
		
		return sido_array;
	}
	
	
	@RequestMapping("/arraylist_to_json.do")
	@ResponseBody
	public List arraylist_to_json() {
		
		List list = new ArrayList();
		
		list.add("���");
		list.add("��");
		list.add("������");
		list.add("�ٳ���");
		
		return list;
	}
	
	
	@RequestMapping("/object_to_json.do")
	@ResponseBody
	public PersonVo object_to_json() {
		
		PersonVo vo = new PersonVo("ȫ�浿",30,"010-1111-1111");
		
		
		return vo;
	}
	
	@RequestMapping("/objects_to_json.do")
	@ResponseBody
	public Map objects_to_json() {
		
		List<PersonVo> list = new ArrayList<PersonVo>();
		
		list.add(new PersonVo("�ʱ浿",10,"010-1111-1111"));
		list.add(new PersonVo("�̱浿",20,"010-2222-2222"));
		list.add(new PersonVo("��浿",30,"010-3333-3333"));
		
		Map map = new HashMap();
		map.put("size", list.size());
		map.put("list", list);
		
		return map;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
