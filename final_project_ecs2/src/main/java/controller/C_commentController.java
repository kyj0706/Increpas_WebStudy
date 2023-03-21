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

import dao.C_commentDao;
import vo.C_commentVo;

@Controller
@RequestMapping("/c_board/")
public class C_commentController {

	@Autowired
	HttpServletRequest request;
	
	C_commentDao c_comment_dao;

	public void setComment_dao(C_commentDao c_comment_dao) {
		this.c_comment_dao = c_comment_dao;
	}
	
	
	// /board/comment_insert.do?cmt_content=내용&b_idx=3&mem_idx=1&mem_id=one&mem_name=일길동
	@RequestMapping("comment_insert.do")
	@ResponseBody
	public Map comment_insert(C_commentVo vo) {
		
		System.out.println(vo.getC_cmt_idx());
		
		String c_cmt_ip = request.getRemoteAddr(); //IP구하기
		vo.setC_cmt_ip(c_cmt_ip);
		String c_cmt_content = vo.getC_cmt_content().replaceAll("\n", "<br>"); // \n -> <br>
		vo.setC_cmt_content(c_cmt_content);
		
		
		int res = c_comment_dao.insert(vo); //DB insert
		System.out.println(res);
		
		
		
		Map map = new HashMap(); //(context-7-jsonconverter)에 의해서 JSON코드로 반환된다
		map.put("result", (res==1) ? "success" : "fail" );
		return map;
	}
	
	// /board/comment_list.do?b_idx=3&page=1
	@RequestMapping("comment_list.do")
	public String comment_list(int c_b_idx,
							   @RequestParam(value="page", defaultValue="1") int nowPage,
							   Model model) {
		List<C_commentVo> list = c_comment_dao.selectList(c_b_idx); //b_idx에 해당하는 댓글목록 가져오기
		model.addAttribute("list", list);
		return "c_board/c_comment_list";
	}
	
	@RequestMapping("comment_delete.do")
	@ResponseBody
	public Map comment_delete(int c_cmt_idx) {
		int res = c_comment_dao.delete(c_cmt_idx);
		Map map = new HashMap(); //(context-7-jsonconverter)에 의해서 JSON코드로 반환된다
		map.put("result", (res==1) ? "success" : "fail" );
		return map;
	}
}
