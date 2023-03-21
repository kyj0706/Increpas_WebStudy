package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import dao.CommentDao;
import mycommon.MyConstant;
import util.Paging;
import vo.CommentVo;

@Controller
@RequestMapping("/board/")
public class CommentController {

	@Autowired
	HttpServletRequest request;
	
	CommentDao comment_dao;
	
	//comment_dao -> setter injection
	public void setComment_dao(CommentDao comment_dao) {
		this.comment_dao = comment_dao;
	}
	
	//댓글 추가
	@RequestMapping("comment_insert.do")
	@ResponseBody()
	public Map comment_insert(CommentVo vo) {

		//ip구하기
		String cmt_ip = request.getRemoteAddr();
		vo.setCmt_ip(cmt_ip);
		
		//엔터처리 \n => <br>
		String cmt_content = vo.getCmt_content().replaceAll("<\n>", "<br>");
		vo.setCmt_content(cmt_content);
		
		//DB에 insert
		int res = comment_dao.insert(vo);
		
		
		Map map = new HashMap();
		map.put("result", (res==1) ? "success" : "fail");
		
		return map;
	}
	
	//댓글리스트
	// /board/comment_list.do?b_idx=3&page=1
	@RequestMapping("comment_list.do")
	public String comment_list(int b_idx,
			@RequestParam(value = "page", defaultValue = "1") int nowPage, 
			Model model) {

		//가져올 게시물의 시작과 끝을 구한다.
		int start = (nowPage-1) * MyConstant.Comment.BLOCK_LIST + 1;
		int end   = start + MyConstant.Comment.BLOCK_LIST -1;
		
		Map map = new HashMap();
		
		map.put("start", start);
		map.put("end", end);
		map.put("b_idx", b_idx);
		
		//전체게시물수 구하기
		
		//전체게시물 가지고 오기
		int rowTotal = comment_dao.selectRowTotal(map);
		
		//b_idx에 해당되는 댓글목록 가지고 오기(230307추가)
		List<CommentVo> list = comment_dao.selectList(map);
		
		
		String pageMenu = Paging.getCommentPaging(nowPage,
													rowTotal,
													MyConstant.Comment.BLOCK_LIST, 
													MyConstant.Comment.BLOCK_PAGE);
		
		
		model.addAttribute("list",list);
		model.addAttribute("pageMenu", pageMenu);
		
		return "board/comment_list";
	}
	
	
	
	//댓글 삭제
	@RequestMapping("comment_delete.do")
	@ResponseBody()
	public Map comment_delete(int cmt_idx) {
		
		int res = comment_dao.delete(cmt_idx);
		Map map = new HashMap();
		map.put("result", (res==1) ? "success" : "fail");
		
		return map;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
