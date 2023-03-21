package controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
/*
-�Ϲ�@Controller ���� ������- 
	@RestController �ȿ� => @Controller + @ResponesBody �� ��� �ִ�.
		=> �׷���  @ResponensBody�� �������� �ʾƵ� ������ �ȴ�.
	
 -����-
 	�߿��Ѱ�	  method		     URI
 	������ȸ : 	  GET(������)		/visits  						 => �Ϲ������� s �� �ٿ� �ش�.
 				  GET				/visits/{search}/{search_text}   => ��� : /visits/name/�浿
 	1�� ��ȸ :	  GET				/visit/{idx}					 => ��� : /visit/1
 	�����ȸ :	  GET				/visit/check-pwd{idx}/{c_pwd}	 => ��� : /visit/1/1234
 	
 	
 	�߰�	 :	  POST				/visit
 	
 	����	 :	  PUT				/visit
 	����	 :	  DELETE			/visit/{idx}
 

 */

import dao.VisitDao;
import vo.VisitVo;



@RestController
public class VisitRestController {
	
	@Autowired
	HttpServletRequest request;
	
	@Autowired
	ServletContext application;
	
	VisitDao visit_dao;
	
	public void setVisit_dao(VisitDao visit_dao) {
		this.visit_dao = visit_dao;
	}
	
	@RequestMapping(value =  {"/visits", "/visits/{search}/{search_text}"}, method = RequestMethod.GET)
	public Map visits(@PathVariable(required = false) String search, 
					   @PathVariable(required = false) String search_text) {
		
		if(search==null) search="all";
		
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
		
		Map resultMap = new HashMap();
		resultMap.put("list", list);
		
		return resultMap;
	}
	
	@RequestMapping(value =  "/visit/{idx}" ,method = RequestMethod.GET)
	public VisitVo visit_one(@PathVariable(value = "idx",required = true) int idx) {

		VisitVo vo = visit_dao.selectOne(idx);
		
		if(vo == null) {
			vo = new VisitVo();
			vo.setIdx(0);
		}
		
		
		return vo;
	}
	
	
	
	
	//�߰�
	@RequestMapping(value="/visit", method=RequestMethod.POST)
	public Map insert(@RequestBody VisitVo vo) {

		//1.����(�ۼ���)�� ������
		String ip		= request.getRemoteAddr();
		//2.ip�� vo���߰�
		vo.setIp(ip);
			
		//5.DB insert
		int res = visit_dao.insert(vo);
			
		Map map = new HashMap();
		map.put("result", (res==1)? "success" : "fail");
		// {"result":"success"} or {"result":"fail"}		
		return map;
	}
	
	//��й�ȣ üũ
	@RequestMapping(value = "/visit/check-pwd/{idx}/{c_pwd}", method = RequestMethod.GET)
	public Map check_pwd(@PathVariable int idx, @PathVariable String c_pwd) {
		
		//1.idx�� �ش�Ǵ� �Խù� 1�� ���´�
		VisitVo vo = visit_dao.selectOne(idx);
				
		//�������==�Է��Ѻ��
		boolean bResult = vo.getPwd().equals(c_pwd);
				
		Map map = new HashMap();
		map.put("result", bResult);

		return map;
	}
	
	//����
	@RequestMapping(value =  "/visit", method = RequestMethod.PUT)
	public Map update(@RequestBody VisitVo vo) {
		String ip		= request.getRemoteAddr();
		
		vo.setIp(ip);
		
		//5.DB update
		int res = visit_dao.update(vo);
		
		Map map = new HashMap();
		map.put("result", (res==1)? "success": "fail");
		
		return map;
	}
	
	
	//����
	@RequestMapping(value =  "/visit/{idx}",method = RequestMethod.DELETE)
	public Map delete(@PathVariable int idx) {
		
		//1-1.�Խù� ���� 1�� ���´�
		VisitVo  vo = visit_dao.selectOne(idx);
		
		String save_path = application.getRealPath("/resources/upload/");
		
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
					
			//System.out.println(filename);
			//ȭ�� ���� ����
			File  f = new File(save_path, filename);
			f.delete();
					
		}
		
		//2.DB delete
		int res = visit_dao.delete(idx);
		
		Map map = new HashMap();
		map.put("result", (res==1)? "success": "fail");

		return map;
	}
	
	
	
	
	
	
	
	
	
	

}
