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

	//@Autowired : 자동엮기(연결)
	// 주의) @Autowired속성을 갖는 컴포넌트생성시 수동생성일 경우에는
	//       <context:annotation-config/>을 반드시 생성전에 설정해야 한다
	//DispacherServlet에게 자동연결 요청
	// : 메소드 호출시 마다 자동 Injection 시켜준다
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
	// /visit/list.do?search=name&search_text=길동
	
	
	@RequestMapping("/visit/list.do")
	public String list(@RequestParam(name="search",defaultValue="all") String search,
			            String search_text,
			            Model model) {
		
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
		
		//DispatcherServlet이 넘져준 Model를 통해서 데이터 저장
		//DispatcherServlet이 model에 저장한 데이터를 request에 binding을 시켜준다
		model.addAttribute("list",list);
	
		return "visit/visit_list";// forward view page
	}
	
	
	
	
	//등록폼 띄우기
	@RequestMapping("/visit/insert_form.do")
	public String insert_form() {
		
		return "visit/visit_insert_form";
	}
	
	
	// /visit/insert.do?name=일길동&content=내용&pwd=1234
	
	//글 등록하기
	@RequestMapping("/visit/insert.do")
	public String insert(VisitVo vo) {
		// 메소드인자 : DS에 대한 요구사항 
		
		//1.상대방(작성자)측 아이피
		String ip		= request.getRemoteAddr();
		//2.ip를 vo에추가
		vo.setIp(ip);
		
		//5.DB insert
		int res = visit_dao.insert(vo);
				
		return "redirect:list.do"; // DispatcherServlet에게 redirect정보 전달
		                           // response.sendRedirect("list.do"); 
	}
	
	
	// /visit/check_pwd.do?idx=2&c_pwd=1234
	
	//비밀번호 체크하기
	@RequestMapping("/visit/check_pwd.do")
	@ResponseBody
	public Map check_pwd(int idx , String c_pwd) {
		//                  메소드인자: DS에대한 요구사항
		
		//1.idx에 해당되는 게시물 1건 얻어온다
		VisitVo vo = visit_dao.selectOne(idx);
		
		//원래비번==입력한비번
		boolean bResult = vo.getPwd().equals(c_pwd);
		
		
		/*
		@ResponseBody : 아래와 같은 명령을 DispacherServlet이 수행한다 
		                produces -> 응답에 대한 content-type 으로 사용된다 
		response.setContentType("text/json;charset=utf-8;");
		response.getWriter().print(json.toString());
		*/
		
		Map map = new HashMap();
		map.put("result", bResult);
		
		return map;
	}
	
	
	// visit/modify_form.do?idx=5
	
	//수정폼 띄우기
	@RequestMapping("/visit/modify_form.do")
	public String modify_form(int idx , Model model) {
		
		//1.idx에 해당되는 게시물 얻어오기
		VisitVo vo = visit_dao.selectOne(idx);
		
		//request binding
		model.addAttribute("vo", vo);//결과적으로 request binding
		
		return "visit/visit_modify_form";// DS ViewName전달->ViewResolver 뷰경로및 확장자 붙인다
		                                 // ->forward시킨다
	}
	
	
	// /visit/modify.do?idx=2&name=삼길동&content=내용&pwd=1234
		
	//수정하기
	@RequestMapping("/visit/modify.do")
	public String modify(VisitVo vo) {
		
		//1.ip구하기
		String ip		= request.getRemoteAddr();
		
		vo.setIp(ip);
		
		//5.DB update
		int res = visit_dao.update(vo);
		
		return "redirect:list.do#v_" + vo.getIdx();
	}
	
	
	//삭제하기
	@RequestMapping("/visit/delete.do")
	public String delete(int idx) {
		
	
		//1-1.게시물 내용 1건 얻어온다
		VisitVo  vo = visit_dao.selectOne(idx);
		
		//화일의 저장경로 구하기
		String save_path = application.getRealPath("/resources/upload/");
		System.out.println(save_path);
		
		System.out.println(vo.getContent());
		//JSOUP : Java Html Parser(jsoup-1.12.1.jar)
		
		
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
			
			System.out.println(filename);
			//화일 삭제 과정
			File  f = new File(save_path, filename);
			f.delete();
			
		}
		
		//2.DB delete
		int res = visit_dao.delete(idx);
		
		
		
		return "redirect:list.do";
	}
		
	
	
	
	
}
