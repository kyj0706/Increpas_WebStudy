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

import dao.BoardDao;
import mycommon.MyConstant;
import util.Paging;
import vo.BoardVo;

@Controller
@RequestMapping("/board/")
public class BoardController {
	//세션정보
	@Autowired
	HttpSession session;
	//ip정보
	@Autowired
	HttpServletRequest request;
	//dao정보
	BoardDao board_dao;
	
	

	public void setBoard_Dao(BoardDao board_dao) {
		this.board_dao = board_dao;
	}
	
	// /bbs/board/list.do
	// /bbs/board/list.do?page=1
	// /bbs/board/list.do?search=all&search_text=
	// /bbs/board/list.do?search=subject&search_text=수정
	// /bbs/board/list.do?search=content&search_text=수정
	// /bbs/board/list.do?search=name&search_text=수정
	// /bbs/board/list.do?search=subject_content_name&search_text=수정
	@RequestMapping("list.do")
	public String list( @RequestParam(value="search",defaultValue="all") String search,
			            @RequestParam(value="search_text",defaultValue="") String search_text,   
			            @RequestParam(value="page",defaultValue="1") int nowPage,
			            Model model) {

		//세션에 기록된 정보 지우기(show)
		session.removeAttribute("show");
		
		
		
		//Paging처리 
		//1.start & end 계산
		int start = (nowPage-1) * MyConstant.Board.BLOCK_LIST + 1;
		int end   = start + MyConstant.Board.BLOCK_LIST - 1;
		
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
		int rowTotal = board_dao.selectRowTotal(map);
		//System.out.println(rowTotal);
		
		//검색필터 :                          search=name&search_text=홍길동
		String search_filter = String.format("search=%s&search_text=%s", search,search_text);
		
		//페이지 메뉴 생성하기
		String pageMenu = Paging.getPaging("list.do", 
				                            search_filter,
				                            nowPage, 
				                            rowTotal,
				                            MyConstant.Board.BLOCK_LIST,
				                            MyConstant.Board.BLOCK_PAGE
				                            );
		//System.out.println(pageMenu);
		
		
		//게시판목록 읽어오기
		List<BoardVo> list = board_dao.selectList(map);
		
		//결과적으로 request binding
		model.addAttribute("list", list);
		model.addAttribute("pageMenu", pageMenu);
		
		return "board/board_list";//ViewName
	}
	
	
	//게시판 상세보기
	// /board/view.do?b_idx=3
	@RequestMapping("view.do")
	public String view(int b_idx, Model model) {
		
		
		BoardVo vo = board_dao.selectOne(b_idx);
		//System.out.println(vo.getB_readhit());
		
		//계속 증가시키는 문제를 이르킬수 있으니 
		//세션에서 게시물을 조회여부 확인 
		if(session.getAttribute("show")==null) {
			//230228_강사님ver
			board_dao.update_readhit(b_idx);
			
			//해당 세션이 봤다는 것을 기록
			session.setAttribute("show", true);
		}
		
		//230227_내가한거
		/*
		int readhit_cnt = board_dao.update_readhit(b_idx);
		vo.setB_readhit(readhit_cnt);
		*/
		model.addAttribute("vo",vo);
		
		
		return "board/board_view";
	}
	
	//board 글쓰기 폼 띄우기
	@RequestMapping("insert_form.do")
	public String insert_form() {

		return "board/board_insert_form";
	}
	
	//board/insert.do?mem_idx=2&mem_name=홍관리&b_subject=ddd&b_content=sdlkj
	//board 글쓰기 (insert)
	@RequestMapping("insert.do")
	public String insert(BoardVo vo, Model model) {
		
		//세션 만료시 처리
		if (session.getAttribute("user") == null) {
			// response.sendRedirect("../member/login_form.do?reason=logout");
			model.addAttribute("reason", "logout");
			return "redirect:../member/login_form.do";
		}
		
		//CkEditor 사용시 필요 없음 (자동처리됨 )
		//b_content "\n", "<br>" 처리
		String b_content = vo.getB_content().replaceAll("\n", "<br>");
		vo.setB_content(b_content);
		
		//ip구하기
		String ip = request.getRemoteAddr();
		vo.setB_ip(ip); //vo에 ip넣기
		
		//DB insert 작업
		int res = board_dao.insert(vo);
		
		return "redirect:list.do";
	}
	
	
	//board 삭제  삭제지만 상태 업데이트를하는 거다
	@RequestMapping("delete.do")
	public String delete(int b_idx, int page, String search, String search_text, Model model) {
		
		int res = board_dao.delete(b_idx);

		model.addAttribute("page", page);
		model.addAttribute("search", search);
		model.addAttribute("search_text",search_text);
		
		return "redirect:list.do";
	}
	
	//board답글 폼 띄우기
	@RequestMapping("reply_form.do")
	public String reply_form() {

		return "board/board_reply_form";
	}
	
	//board/reply.do?mem_idx=5&mem_name=테스트5&b_idx=17&b_subject=sss&b_content=sss
	//board답글 쓰기
	@RequestMapping("reply.do")
	public String reply(BoardVo vo, int page, Model model) {
		
		//기준글번호의 게시물정보 얻어온다.
		BoardVo baseVo = board_dao.selectOne(vo.getB_idx());
		
		//기준글 아래글들의 step을 1씩증가
		int res = board_dao.update_step(baseVo);
		
		//답글의 상태정보(b_ref, b_step, b_depth)설정
		vo.setB_ref(baseVo.getB_ref());			//그룹의 참조글 번호
		vo.setB_step(baseVo.getB_step()+1); 	//글순서
		vo.setB_depth(baseVo.getB_depth()+1);	//글의 깊이
		
		//CkEditor 사용시 필요 없음 (자동처리됨 )
		//b_content "\n", "<br>" 처리
		String b_content = vo.getB_content().replaceAll("\n", "<br>");
		vo.setB_content(b_content);
		
		//ip구하기
		String ip = request.getRemoteAddr();
		vo.setB_ip(ip); //vo에 ip넣기
		
		//DB reply보내기
		res = board_dao.reply(vo);
		
		model.addAttribute("page", page);
		System.out.println(page);
		
		return "redirect:list.do";
	}
	
	
	//수정 폼 띄우기
	@RequestMapping("update_form.do")
	public String update_form(int b_idx, Model model) {
		
		BoardVo vo = board_dao.selectOne(b_idx);
		
		String b_content = vo.getB_content().replaceAll("<br>","\n");
		vo.setB_content(b_content);
		
		model.addAttribute("vo", vo);

		return "board/board_update_form";
	}
	
	//수정하기
	@RequestMapping("update.do")
	public String update(BoardVo vo, int page, 
							String search, 
							String search_text, 
							Model model) {
		
		//세션 만료시 처리
		if (session.getAttribute("user") == null) {
			// response.sendRedirect("../member/login_form.do?reason=logout");
			model.addAttribute("reason", "logout");
			return "redirect:../member/login_form.do";
		}
		
		//ip구하기
		String ip = request.getRemoteAddr();
		vo.setB_ip(ip); //vo에 ip넣기
		
		String b_content = vo.getB_content().replaceAll("\n", "<br>");
		vo.setB_content(b_content);
		
		//idx구하기
		/*
		int b_idx = vo.getB_idx();
		System.out.println(b_idx);
		*/
		
		int res = board_dao.update(vo);

		//Model을 통해서 query로 전달하자
		model.addAttribute("b_idx", vo.getB_idx());
		model.addAttribute("page", page);
		model.addAttribute("search", search);
		model.addAttribute("search_text", search_text);
		
		
		//Spring은 이렇게 하는것을 권장하지 않는다 model 을 활용하자
		//return "redirect:view.do?b_idx="+b_idx;
		
		return "redirect:view.do";
	}
	
	
	

}
