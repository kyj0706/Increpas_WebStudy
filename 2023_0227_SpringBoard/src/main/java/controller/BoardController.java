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
	//��������
	@Autowired
	HttpSession session;
	//ip����
	@Autowired
	HttpServletRequest request;
	//dao����
	BoardDao board_dao;
	
	

	public void setBoard_Dao(BoardDao board_dao) {
		this.board_dao = board_dao;
	}
	
	// /bbs/board/list.do
	// /bbs/board/list.do?page=1
	// /bbs/board/list.do?search=all&search_text=
	// /bbs/board/list.do?search=subject&search_text=����
	// /bbs/board/list.do?search=content&search_text=����
	// /bbs/board/list.do?search=name&search_text=����
	// /bbs/board/list.do?search=subject_content_name&search_text=����
	@RequestMapping("list.do")
	public String list( @RequestParam(value="search",defaultValue="all") String search,
			            @RequestParam(value="search_text",defaultValue="") String search_text,   
			            @RequestParam(value="page",defaultValue="1") int nowPage,
			            Model model) {

		//���ǿ� ��ϵ� ���� �����(show)
		session.removeAttribute("show");
		
		
		
		//Pagingó�� 
		//1.start & end ���
		int start = (nowPage-1) * MyConstant.Board.BLOCK_LIST + 1;
		int end   = start + MyConstant.Board.BLOCK_LIST - 1;
		
		Map <String,Object>map = new HashMap<String,Object>();
		map.put("start", start);
		map.put("end"  , end);
		
		//�˻����� ����
		if(search.equals("subject_content_name")) {
			//����+����+�̸�
			map.put("subject", search_text);
			map.put("content", search_text);
			map.put("name"   , search_text);
		}else if(search.equals("subject")) {
			//����
			map.put("subject", search_text);
			
		}else if(search.equals("content")) {
			//����
			map.put("content", search_text);
			
		}else if(search.equals("name")) {
			//�̸�
			map.put("name"   , search_text);
		}
		
		//�˻����Ǻ� �Խù��� ������
		int rowTotal = board_dao.selectRowTotal(map);
		//System.out.println(rowTotal);
		
		//�˻����� :                          search=name&search_text=ȫ�浿
		String search_filter = String.format("search=%s&search_text=%s", search,search_text);
		
		//������ �޴� �����ϱ�
		String pageMenu = Paging.getPaging("list.do", 
				                            search_filter,
				                            nowPage, 
				                            rowTotal,
				                            MyConstant.Board.BLOCK_LIST,
				                            MyConstant.Board.BLOCK_PAGE
				                            );
		//System.out.println(pageMenu);
		
		
		//�Խ��Ǹ�� �о����
		List<BoardVo> list = board_dao.selectList(map);
		
		//��������� request binding
		model.addAttribute("list", list);
		model.addAttribute("pageMenu", pageMenu);
		
		return "board/board_list";//ViewName
	}
	
	
	//�Խ��� �󼼺���
	// /board/view.do?b_idx=3
	@RequestMapping("view.do")
	public String view(int b_idx, Model model) {
		
		
		BoardVo vo = board_dao.selectOne(b_idx);
		//System.out.println(vo.getB_readhit());
		
		//��� ������Ű�� ������ �̸�ų�� ������ 
		//���ǿ��� �Խù��� ��ȸ���� Ȯ�� 
		if(session.getAttribute("show")==null) {
			//230228_�����ver
			board_dao.update_readhit(b_idx);
			
			//�ش� ������ �ôٴ� ���� ���
			session.setAttribute("show", true);
		}
		
		//230227_�����Ѱ�
		/*
		int readhit_cnt = board_dao.update_readhit(b_idx);
		vo.setB_readhit(readhit_cnt);
		*/
		model.addAttribute("vo",vo);
		
		
		return "board/board_view";
	}
	
	//board �۾��� �� ����
	@RequestMapping("insert_form.do")
	public String insert_form() {

		return "board/board_insert_form";
	}
	
	//board/insert.do?mem_idx=2&mem_name=ȫ����&b_subject=ddd&b_content=sdlkj
	//board �۾��� (insert)
	@RequestMapping("insert.do")
	public String insert(BoardVo vo, Model model) {
		
		//���� ����� ó��
		if (session.getAttribute("user") == null) {
			// response.sendRedirect("../member/login_form.do?reason=logout");
			model.addAttribute("reason", "logout");
			return "redirect:../member/login_form.do";
		}
		
		//CkEditor ���� �ʿ� ���� (�ڵ�ó���� )
		//b_content "\n", "<br>" ó��
		String b_content = vo.getB_content().replaceAll("\n", "<br>");
		vo.setB_content(b_content);
		
		//ip���ϱ�
		String ip = request.getRemoteAddr();
		vo.setB_ip(ip); //vo�� ip�ֱ�
		
		//DB insert �۾�
		int res = board_dao.insert(vo);
		
		return "redirect:list.do";
	}
	
	
	//board ����  �������� ���� ������Ʈ���ϴ� �Ŵ�
	@RequestMapping("delete.do")
	public String delete(int b_idx, int page, String search, String search_text, Model model) {
		
		int res = board_dao.delete(b_idx);

		model.addAttribute("page", page);
		model.addAttribute("search", search);
		model.addAttribute("search_text",search_text);
		
		return "redirect:list.do";
	}
	
	//board��� �� ����
	@RequestMapping("reply_form.do")
	public String reply_form() {

		return "board/board_reply_form";
	}
	
	//board/reply.do?mem_idx=5&mem_name=�׽�Ʈ5&b_idx=17&b_subject=sss&b_content=sss
	//board��� ����
	@RequestMapping("reply.do")
	public String reply(BoardVo vo, int page, Model model) {
		
		//���ر۹�ȣ�� �Խù����� ���´�.
		BoardVo baseVo = board_dao.selectOne(vo.getB_idx());
		
		//���ر� �Ʒ��۵��� step�� 1������
		int res = board_dao.update_step(baseVo);
		
		//����� ��������(b_ref, b_step, b_depth)����
		vo.setB_ref(baseVo.getB_ref());			//�׷��� ������ ��ȣ
		vo.setB_step(baseVo.getB_step()+1); 	//�ۼ���
		vo.setB_depth(baseVo.getB_depth()+1);	//���� ����
		
		//CkEditor ���� �ʿ� ���� (�ڵ�ó���� )
		//b_content "\n", "<br>" ó��
		String b_content = vo.getB_content().replaceAll("\n", "<br>");
		vo.setB_content(b_content);
		
		//ip���ϱ�
		String ip = request.getRemoteAddr();
		vo.setB_ip(ip); //vo�� ip�ֱ�
		
		//DB reply������
		res = board_dao.reply(vo);
		
		model.addAttribute("page", page);
		System.out.println(page);
		
		return "redirect:list.do";
	}
	
	
	//���� �� ����
	@RequestMapping("update_form.do")
	public String update_form(int b_idx, Model model) {
		
		BoardVo vo = board_dao.selectOne(b_idx);
		
		String b_content = vo.getB_content().replaceAll("<br>","\n");
		vo.setB_content(b_content);
		
		model.addAttribute("vo", vo);

		return "board/board_update_form";
	}
	
	//�����ϱ�
	@RequestMapping("update.do")
	public String update(BoardVo vo, int page, 
							String search, 
							String search_text, 
							Model model) {
		
		//���� ����� ó��
		if (session.getAttribute("user") == null) {
			// response.sendRedirect("../member/login_form.do?reason=logout");
			model.addAttribute("reason", "logout");
			return "redirect:../member/login_form.do";
		}
		
		//ip���ϱ�
		String ip = request.getRemoteAddr();
		vo.setB_ip(ip); //vo�� ip�ֱ�
		
		String b_content = vo.getB_content().replaceAll("\n", "<br>");
		vo.setB_content(b_content);
		
		//idx���ϱ�
		/*
		int b_idx = vo.getB_idx();
		System.out.println(b_idx);
		*/
		
		int res = board_dao.update(vo);

		//Model�� ���ؼ� query�� ��������
		model.addAttribute("b_idx", vo.getB_idx());
		model.addAttribute("page", page);
		model.addAttribute("search", search);
		model.addAttribute("search_text", search_text);
		
		
		//Spring�� �̷��� �ϴ°��� �������� �ʴ´� model �� Ȱ������
		//return "redirect:view.do?b_idx="+b_idx;
		
		return "redirect:view.do";
	}
	
	
	

}
