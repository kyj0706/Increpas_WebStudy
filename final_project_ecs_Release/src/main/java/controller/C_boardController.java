package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dao.C_boardDao;
import mycommon.MyConstant;
import util.Paging;
import vo.C_boardVo;

@Controller
@RequestMapping("/c_board/")
public class C_boardController {
	
	@Autowired
	HttpSession session;
	
	@Autowired
	HttpServletRequest request;
	
	C_boardDao c_board_dao;

	public void setC_boardDao(C_boardDao c_board_dao) {
		this.c_board_dao = c_board_dao;
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
		int start = (nowPage-1) * MyConstant.C_Board.BLOCK_LIST + 1;
		int end   = start + MyConstant.C_Board.BLOCK_LIST - 1;
		
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
		int rowTotal = c_board_dao.selectRowTotal(map);
		//System.out.println(rowTotal);
		
		//검색필터 :                          search=name&search_text=홍길동
		String search_filter = String.format("search=%s&search_text=%s", search,search_text);
		
		//페이지 메뉴 생성하기
		String pageMenu = Paging.getPaging("list.do", 
				                            search_filter,
				                            nowPage, 
				                            rowTotal,
				                            MyConstant.C_Board.BLOCK_LIST,
				                            MyConstant.C_Board.BLOCK_PAGE
				                            );
		//System.out.println(pageMenu);
		
		
		//게시판목록 읽어오기
		List<C_boardVo> list = c_board_dao.selectList(map);
		
		//결과적으로 request binding
		model.addAttribute("list", list);
		model.addAttribute("pageMenu", pageMenu);
		
		return "c_board/c_board_list";//ViewName
	}
	
	@RequestMapping("view.do")
	public String view(int c_b_idx, Model model) {
		C_boardVo vo = c_board_dao.selectOne(c_b_idx); 
		if(session.getAttribute("show")==null) { //세션에서 게시물 조회 체크
			c_board_dao.update_readhit(c_b_idx); //조회수 증가 호출
			session.setAttribute("show", true);	// 세션에 정보를 담는다.
		}
		model.addAttribute("vo", vo);
		return "c_board/c_board_view";            
	}
	
	@RequestMapping("insert_form.do")
	public String insert_form() {
		return "c_board/c_board_insert_form";
	}
	
	@RequestMapping("insert.do")
	public String insert(C_boardVo vo, Model model) {
		if(session.getAttribute("user")==null){ //세션 만료시 처리
			model.addAttribute("reason", "logout");
			return "redirect:../c_member/login_form.do";
		}
		//CKEditor사용하면 이부분 삭제할것
		String b_content = vo.getC_b_content().replaceAll("\n", "<br>");
		vo.setC_b_content(b_content);
		String b_ip = request.getRemoteAddr();
		vo.setC_b_ip(b_ip);
		int res = c_board_dao.insert(vo);
		return "redirect:list.do";
	}	
	 
	@RequestMapping("delete.do")
	public String delete(int b_idx, int page, Model model) {
		int res = c_board_dao.delete(b_idx);
		model.addAttribute("page",page); // list.do?page=3
		return "redirect:list.do";
	}
	
	//답글폼 띄우기
	@RequestMapping("reply_form.do")
	public String reply_form() {
		
		return "c_board/c_board_reply_form";
	}
	
	@RequestMapping("reply.do")
	public String reply(C_boardVo vo, Model model, int page) {
		C_boardVo baseVo = c_board_dao.selectOne(vo.getC_b_idx()); //기준글번호의 게시물정보 얻어온다
		int res = c_board_dao.update_step(baseVo); //기준글 아래글들의 step을 1씩 증가
		vo.setC_b_ref(baseVo.getC_b_ref());       //참조글번호
		vo.setC_b_step(baseVo.getC_b_step()+1);   //글순서
		vo.setC_b_depth(baseVo.getC_b_depth()+1); //글깊이
		String b_ip = request.getRemoteAddr(); //ip구하기
		vo.setC_b_ip(b_ip); //ip를 vo에 담기
		res = c_board_dao.reply(vo); //DB reply
		model.addAttribute("page",page); // list.do?page=3
		System.out.println(page);
		return "redirect:list.do";
	}
	
	@RequestMapping("modify_form.do")
	public String modify_form(int c_b_idx, int page, Model model) {
		C_boardVo vo = c_board_dao.selectOne(c_b_idx);
		model.addAttribute("page",page); // list.do?page=3
		model.addAttribute("vo", vo);
		return "c_board/c_board_modify_form";
	}
	
	@RequestMapping("modify.do")
	public String modify(C_boardVo vo,int page,String search,String search_text,Model model) {

		//세션만료시 처리
		if(session.getAttribute("user")==null) {
			
			model.addAttribute("reason", "logout");
			
			return "redirect:../c_member/login_form.do";
		}
		
		//ip구하기
		String c_b_ip = request.getRemoteAddr();
		vo.setC_b_ip(c_b_ip);
		
		//DB update
		int res = c_board_dao.update(vo);
		
		//model통해서 query를 전달
		model.addAttribute("c_b_idx", vo.getC_b_idx());
		model.addAttribute("page", page);
		model.addAttribute("search", search);
		model.addAttribute("search_text", search_text);
		
		return "redirect:view.do";
	}
	
}