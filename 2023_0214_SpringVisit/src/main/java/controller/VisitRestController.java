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
-일반@Controller 와의 차이점- 
	@RestController 안에 => @Controller + @ResponesBody 가 들어 있다.
		=> 그래서  @ResponensBody를 선언하지 않아도 실행이 된다.
	
 -형식-
 	중요한건	  method		     URI
 	전제조회 : 	  GET(무조건)		/visits  						 => 일반적으로 s 를 붙여 준다.
 				  GET				/visits/{search}/{search_text}   => 결과 : /visits/name/길동
 	1건 조회 :	  GET				/visit/{idx}					 => 결과 : /visit/1
 	비번조회 :	  GET				/visit/check-pwd{idx}/{c_pwd}	 => 결과 : /visit/1/1234
 	
 	
 	추가	 :	  POST				/visit
 	
 	수정	 :	  PUT				/visit
 	삭제	 :	  DELETE			/visit/{idx}
 

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
		
		//검색조건을 담을 map
		Map<String,String> map = new HashMap<String,String>();
		
		if(search.equals("name_content")) {
			//이름+내용
			map.put("name", search_text);
			map.put("content", search_text);
		}else if(search.equals("name")) {
			//이름
			map.put("name", search_text);
		}else if(search.equals("content")) {
			//내용
			map.put("content", search_text);
			
		}else if(search.equals("modifydate")) {
			//날짜
			map.put("modifydate", search_text);
		}
		
		//목록 가져오기
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
	
	
	
	
	//추가
	@RequestMapping(value="/visit", method=RequestMethod.POST)
	public Map insert(@RequestBody VisitVo vo) {

		//1.상대방(작성자)측 아이피
		String ip		= request.getRemoteAddr();
		//2.ip를 vo에추가
		vo.setIp(ip);
			
		//5.DB insert
		int res = visit_dao.insert(vo);
			
		Map map = new HashMap();
		map.put("result", (res==1)? "success" : "fail");
		// {"result":"success"} or {"result":"fail"}		
		return map;
	}
	
	//비밀번호 체크
	@RequestMapping(value = "/visit/check-pwd/{idx}/{c_pwd}", method = RequestMethod.GET)
	public Map check_pwd(@PathVariable int idx, @PathVariable String c_pwd) {
		
		//1.idx에 해당되는 게시물 1건 얻어온다
		VisitVo vo = visit_dao.selectOne(idx);
				
		//원래비번==입력한비번
		boolean bResult = vo.getPwd().equals(c_pwd);
				
		Map map = new HashMap();
		map.put("result", bResult);

		return map;
	}
	
	//수정
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
	
	
	//삭제
	@RequestMapping(value =  "/visit/{idx}",method = RequestMethod.DELETE)
	public Map delete(@PathVariable int idx) {
		
		//1-1.게시물 내용 1건 얻어온다
		VisitVo  vo = visit_dao.selectOne(idx);
		
		String save_path = application.getRealPath("/resources/upload/");
		
		//내용의 HTML문서를 읽어들인다
		Document doc   = Jsoup.parse(vo.getContent());
		
		//HTML내 <img>목록을 검색한다=>결과는 ArrayList<Element>로 저장
		Elements  imgs = doc.select("img");
		for(Element img : imgs) {
					
			//<img src="http://localhost:9090....../a.jpg">  src 값을 읽어온다
			String img_path = img.attr("src");
			// "/" 를 뒷쪽부터 검색한다(검색위치: index)
			int    index    = img_path.lastIndexOf("/");
			//화일명만 잘라온다
			String filename = img_path.substring(index+1);		
					
			//System.out.println(filename);
			//화일 삭제 과정
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
