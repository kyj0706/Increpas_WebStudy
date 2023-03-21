package controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import dao.VisitDao;
import vo.VisitVo;



@Controller
public class VisitController {

	//@Autowired : �ڵ�����(����)
	// ����) @Autowired�Ӽ��� ���� ������Ʈ������ ���������� ��쿡��
	//       <context:annotation-config/>�� �ݵ�� �������� �����ؾ� �Ѵ�
	//DispacherServlet���� �ڵ����� ��û
	// : �޼ҵ� ȣ��� ���� �ڵ� Injection �����ش�
	@Autowired
	ServletContext application;
	
	@Autowired
	HttpServletRequest request;
	
	@Autowired
	HttpSession session;
	
	
	
	
	VisitDao visit_dao;
	
	public void setVisit_dao(VisitDao visit_dao) {
		this.visit_dao = visit_dao;
	}

	
	// /visit/list.do
	// /visit/list.do?search=name&search_text=�浿
	
	
	@RequestMapping("/visit/list.do")
	public String list(@RequestParam(name="search",defaultValue="all") String search,
			            String search_text,
			            Model model) {
		
		//�˻������� ���� map
		Map<String,String> map = new HashMap<String,String>();
		
		if(search.equals("name_content")) {
			//�̸�+����
			map.put("name", search_text);
			map.put("content", search_text);
		}else if(search.equals("name")) {
			//�̸�
			map.put("name", search_text);
		}else if(search.equals("content")) {
			//����
			map.put("content", search_text);
			
		}else if(search.equals("modifydate")) {
			//��¥
			map.put("modifydate", search_text);
		}
		
		
		//��� ��������
		List<VisitVo> list = visit_dao.selectList(map);
		
		//DispatcherServlet�� ������ Model�� ���ؼ� ������ ����
		//DispatcherServlet�� model�� ������ �����͸� request�� binding�� �����ش�
		model.addAttribute("list",list);
	
		return "visit/visit_list";// forward view page
	}
	
	
	
	
	//����� ����
	@RequestMapping("/visit/insert_form.do")
	public String insert_form() {
		
		return "visit/visit_insert_form";
	}
	
	
	// /visit/insert.do?name=�ϱ浿&content=����&pwd=1234
	
	//�� ����ϱ�
	@RequestMapping("/visit/insert.do")
	public String insert(VisitVo vo) {
		// �޼ҵ����� : DS�� ���� �䱸���� 
		
		//1.����(�ۼ���)�� ������
		String ip		= request.getRemoteAddr();
		//2.ip�� vo���߰�
		vo.setIp(ip);
		
		//5.DB insert
		int res = visit_dao.insert(vo);
				
		return "redirect:list.do"; // DispatcherServlet���� redirect���� ����
		                           // response.sendRedirect("list.do"); 
	}
	
	
	// /visit/check_pwd.do?idx=2&c_pwd=1234
	
	//��й�ȣ üũ�ϱ�
	@RequestMapping("/visit/check_pwd.do")
	@ResponseBody
	public Map check_pwd(int idx , String c_pwd) {
		//                  �޼ҵ�����: DS������ �䱸����
		
		//1.idx�� �ش�Ǵ� �Խù� 1�� ���´�
		VisitVo vo = visit_dao.selectOne(idx);
		
		//�������==�Է��Ѻ��
		boolean bResult = vo.getPwd().equals(c_pwd);
		
		
		/*
		@ResponseBody : �Ʒ��� ���� ����� DispacherServlet�� �����Ѵ� 
		                produces -> ���信 ���� content-type ���� ���ȴ� 
		response.setContentType("text/json;charset=utf-8;");
		response.getWriter().print(json.toString());
		*/
		
		Map map = new HashMap();
		map.put("result", bResult);
		
		return map;
	}
	
	
	// visit/modify_form.do?idx=5
	
	//������ ����
	@RequestMapping("/visit/modify_form.do")
	public String modify_form(int idx , Model model) {
		
		//1.idx�� �ش�Ǵ� �Խù� ������
		VisitVo vo = visit_dao.selectOne(idx);
		
		//request binding
		model.addAttribute("vo", vo);//��������� request binding
		
		return "visit/visit_modify_form";// DS ViewName����->ViewResolver ���ι� Ȯ���� ���δ�
		                                 // ->forward��Ų��
	}
	
	
	// /visit/modify.do?idx=2&name=��浿&content=����&pwd=1234
		
	//�����ϱ�
	@RequestMapping("/visit/modify.do")
	public String modify(VisitVo vo) {
		
		//1.ip���ϱ�
		String ip		= request.getRemoteAddr();
		
		vo.setIp(ip);
		
		//5.DB update
		int res = visit_dao.update(vo);
		
		return "redirect:list.do#v_" + vo.getIdx();
	}
	
	
	//�����ϱ�
	@RequestMapping("/visit/delete.do")
	public String delete(int idx) {
		
	
		//1-1.�Խù� ���� 1�� ���´�
		VisitVo  vo = visit_dao.selectOne(idx);
		
		//ȭ���� ������ ���ϱ�
		String save_path = application.getRealPath("/resources/upload/");
		System.out.println(save_path);
		
		System.out.println(vo.getContent());
		//JSOUP : Java Html Parser(jsoup-1.12.1.jar)
		
		
		//������ HTML������ �о���δ�
		Document doc   = Jsoup.parse(vo.getContent());
		
		//HTML�� <img>����� �˻��Ѵ�=>����� ArrayList<Element>�� ����
		Elements  imgs = doc.select("img");
		for(Element img : imgs) {
			
			//<img src="http://localhost:9090....../a.jpg">  src ���� �о�´�
			String img_path = img.attr("src");
			// "/" �� ���ʺ��� �˻��Ѵ�(�˻���ġ: index)
			int    index    = img_path.lastIndexOf("/");
			//ȭ�ϸ� �߶�´�
			String filename = img_path.substring(index+1);		
			
			System.out.println(filename);
			//ȭ�� ���� ����
			File  f = new File(save_path, filename);
			f.delete();
			
		}
		
		//2.DB delete
		int res = visit_dao.delete(idx);
		
		
		
		return "redirect:list.do";
	}
		
	
	
	
	
}
