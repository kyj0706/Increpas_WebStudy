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
import mycommon.MyMConstant;
import util.Paging;
import vo.BoardVo;
import vo.MemberVo;

@Controller
@RequestMapping("/board/")
public class BoardController {
	
	@Autowired
	HttpSession session;
	
	@Autowired
	HttpServletRequest request;
	
	BoardDao board_dao;

	public void setBoard_dao(BoardDao board_dao) {
		this.board_dao = board_dao;
	}
	
	@RequestMapping("list.do")
	public String list(@RequestParam(value="page",defaultValue="1") int nowPage, Model model) {
		session.removeAttribute("show"); //세션에 기록된 정보 지우기(show)
		//page 처리
		int start  = (nowPage-1) * MyMConstant.Board.BLOCK_LIST+1; //1. start & end 계산
		int end    = start       + MyMConstant.Board.BLOCK_LIST-1; 
		Map map = new HashMap<>();
		map.put("start", start);
		map.put("end", end);
		int rowTotal = board_dao.selectRowTotal(); //전체 게시물 수 얻어오기
		String pageMenu = Paging.getPaging("list.do", nowPage, rowTotal, MyMConstant.Board.BLOCK_LIST, MyMConstant.Board.BLOCK_LIST);
		List<BoardVo> list = board_dao.selectList(map); //게시판 목록 가져오기
		model.addAttribute("list", list); //결과적으로 request binding
		model.addAttribute("pageMenu", pageMenu); //결과적으로 request binding
		return "board/board_list"; //ViewName
	}
	
	@RequestMapping("view.do")
	public String view(int b_idx, Model model) {
		BoardVo vo = board_dao.selectOne(b_idx); 
		if(session.getAttribute("show")==null) { //세션에서 게시물 조회 체크
			board_dao.update_readhit(b_idx); //조회수 증가 호출
			session.setAttribute("show", true);	// 세션에 정보를 담는다.
		}
		model.addAttribute("vo", vo);
		return "board/board_view";            
	}
	
	@RequestMapping("insert_form.do")
	public String insert_form() {
		return "board/board_insert_form";
	}
	
	@RequestMapping("insert.do")
	public String insert(BoardVo vo, Model model) {
		if(session.getAttribute("user")==null){ //세션 만료시 처리
			model.addAttribute("reason", "logout");
			return "redirect:../member/login_form.do";
		}
		//CKEditor사용하면 이부분 삭제할것
		String b_content = vo.getB_content().replaceAll("\n", "<br>");
		vo.setB_content(b_content);
		String b_ip = request.getRemoteAddr();
		vo.setB_ip(b_ip);
		int res = board_dao.insert(vo);
		return "redirect:list.do";
	}	
	 
	@RequestMapping("delete.do")
	public String delete(int b_idx, int page, Model model) {
		int res = board_dao.delete(b_idx);
		model.addAttribute("page",page); // list.do?page=3
		return "redirect:list.do";
	}
	
	//답글폼 띄우기
	@RequestMapping("reply_form.do")
	public String reply_form() {
		
		return "board/board_reply_form";
	}
	
	@RequestMapping("reply.do")
	public String reply(BoardVo vo, Model model, int page) {
		BoardVo baseVo = board_dao.selectOne(vo.getB_idx()); //기준글번호의 게시물정보 얻어온다
		int res = board_dao.update_step(baseVo); //기준글 아래글들의 step을 1씩 증가
		vo.setB_ref(baseVo.getB_ref());       //참조글번호
		vo.setB_step(baseVo.getB_step()+1);   //글순서
		vo.setB_depth(baseVo.getB_depth()+1); //글깊이
		String b_ip = request.getRemoteAddr(); //ip구하기
		vo.setB_ip(b_ip); //ip를 vo에 담기
		res = board_dao.reply(vo); //DB reply
		model.addAttribute("page",page); // list.do?page=3
		System.out.println(page);
		return "redirect:list.do";
	}
	
	@RequestMapping("modify_form.do")
	public String modify_form(int b_idx, int page, Model model) {
		BoardVo vo = board_dao.selectOne(b_idx);
		model.addAttribute("page",page); // list.do?page=3
		return "board/board_modify_form";
	}
	
	@RequestMapping("modify.do")
	public String modify(BoardVo vo, Model model/*, int b_idx*/, int page) {
		/*MemberVo user = (MemberVo) session.getAttribute("user");
		int mem_idx = user.getMem_idx();
		String b_ip = request.getRemoteAddr();  
		
		vo.setB_ip(b_ip);
		vo.setMem_idx(mem_idx);
		int res = board_dao.update(vo);
		return "redirect:view.do?b_idx="+b_idx;*/ //내가 작성한 것 
		//세션만료시 처리
		if(session.getAttribute("user")==null) {
			model.addAttribute("reason", "logout");
			return "redirect:../member/login_form.do";
		}
		//CKEditor사용하면 이부분 삭제할것
		/* String b_content = vo.getB_content().replaceAll("\n", "<br>");
		vo.setB_content(b_content);*/
		String b_ip = request.getRemoteAddr();//ip구하기
		vo.setB_ip(b_ip);//ip담기
		int res = board_dao.update(vo); //DB update
		model.addAttribute("b_idx", vo.getB_idx()); //model통해서 query를 전달
		model.addAttribute("page",page); // list.do?page=3
		return "redirect:view.do";
	}
	
}