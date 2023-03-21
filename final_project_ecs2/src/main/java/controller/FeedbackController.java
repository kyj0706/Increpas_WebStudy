package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dao.FeedbackDao;
import mycommon.MyConstant;
import util.Paging;
import vo.FeedbackVo;

@Controller
@RequestMapping("/feedback/")
public class FeedbackController {
	
	@Autowired
	HttpSession session;
	
	FeedbackDao feedback_dao;
	
	public void setMember_dao(FeedbackDao feedback_dao) {
		this.feedback_dao = feedback_dao;
	}
	
	@RequestMapping("list.do")
	public String list( @RequestParam(value="search",defaultValue="all") String search,
			            @RequestParam(value="search_text",defaultValue="") String search_text,   
			            @RequestParam(value="page",defaultValue="1") int nowPage,
			            Model model) {

		//세션에 기록된 정보 지우기(show)
		session.removeAttribute("show");
		
		//Paging처리 
		//1.start & end 계산
		int start = (nowPage-1) * MyConstant.Car.BLOCK_LIST + 1;
		int end   = start + MyConstant.Car.BLOCK_LIST - 1;
		
		Map <String,Object>map = new HashMap<String,Object>();
		map.put("start", start);
		map.put("end"  , end);
		
		//검색조건 설정
		if(search.equals("subject_content_name")) {
			//제목+내용+이름
			map.put("subject", search_text);
			map.put("content", search_text);
			map.put("name"   , search_text);
		}else if(search.equals("subject")) {
			//제목
			map.put("subject", search_text);
			
		}else if(search.equals("content")) {
			//내용
			map.put("content", search_text);
			
		}else if(search.equals("name")) {
			//이름
			map.put("name"   , search_text);
		}
		
		
		//검색조건별 게시물수 얻어오기
		int rowTotal = feedback_dao.selectRowTotal(map);
		//System.out.println(rowTotal);
		
		//검색필터 :                          search=name&search_text=홍길동
		String search_filter = String.format("search=%s&search_text=%s", search,search_text);
		
		//페이지 메뉴 생성하기
		String pageMenu = Paging.getPaging("list.do", 
				                            search_filter,
				                            nowPage, 
				                            rowTotal,
				                            MyConstant.Car.BLOCK_LIST,
				                            MyConstant.Car.BLOCK_PAGE
				                            );
		//System.out.println(pageMenu);
		
		
		//게시판목록 읽어오기
		List<FeedbackVo> list = feedback_dao.selectList(map);
		
		//결과적으로 request binding
		model.addAttribute("list", list);
		model.addAttribute("pageMenu", pageMenu);
		
		return "feedback/feedback_list";//ViewName
	}
	
	
	
}
