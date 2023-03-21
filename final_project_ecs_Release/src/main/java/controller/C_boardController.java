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

		//���ǿ� ��ϵ� ���� �����(show)
		session.removeAttribute("show");
		
		//Pagingó�� 
		//1.start & end ���
		int start = (nowPage-1) * MyConstant.C_Board.BLOCK_LIST + 1;
		int end   = start + MyConstant.C_Board.BLOCK_LIST - 1;
		
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
		int rowTotal = c_board_dao.selectRowTotal(map);
		//System.out.println(rowTotal);
		
		//�˻����� :                          search=name&search_text=ȫ�浿
		String search_filter = String.format("search=%s&search_text=%s", search,search_text);
		
		//������ �޴� �����ϱ�
		String pageMenu = Paging.getPaging("list.do", 
				                            search_filter,
				                            nowPage, 
				                            rowTotal,
				                            MyConstant.C_Board.BLOCK_LIST,
				                            MyConstant.C_Board.BLOCK_PAGE
				                            );
		//System.out.println(pageMenu);
		
		
		//�Խ��Ǹ�� �о����
		List<C_boardVo> list = c_board_dao.selectList(map);
		
		//��������� request binding
		model.addAttribute("list", list);
		model.addAttribute("pageMenu", pageMenu);
		
		return "c_board/c_board_list";//ViewName
	}
	
	@RequestMapping("view.do")
	public String view(int c_b_idx, Model model) {
		C_boardVo vo = c_board_dao.selectOne(c_b_idx); 
		if(session.getAttribute("show")==null) { //���ǿ��� �Խù� ��ȸ üũ
			c_board_dao.update_readhit(c_b_idx); //��ȸ�� ���� ȣ��
			session.setAttribute("show", true);	// ���ǿ� ������ ��´�.
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
		if(session.getAttribute("user")==null){ //���� ����� ó��
			model.addAttribute("reason", "logout");
			return "redirect:../c_member/login_form.do";
		}
		//CKEditor����ϸ� �̺κ� �����Ұ�
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
	
	//����� ����
	@RequestMapping("reply_form.do")
	public String reply_form() {
		
		return "c_board/c_board_reply_form";
	}
	
	@RequestMapping("reply.do")
	public String reply(C_boardVo vo, Model model, int page) {
		C_boardVo baseVo = c_board_dao.selectOne(vo.getC_b_idx()); //���ر۹�ȣ�� �Խù����� ���´�
		int res = c_board_dao.update_step(baseVo); //���ر� �Ʒ��۵��� step�� 1�� ����
		vo.setC_b_ref(baseVo.getC_b_ref());       //�����۹�ȣ
		vo.setC_b_step(baseVo.getC_b_step()+1);   //�ۼ���
		vo.setC_b_depth(baseVo.getC_b_depth()+1); //�۱���
		String b_ip = request.getRemoteAddr(); //ip���ϱ�
		vo.setC_b_ip(b_ip); //ip�� vo�� ���
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

		//���Ǹ���� ó��
		if(session.getAttribute("user")==null) {
			
			model.addAttribute("reason", "logout");
			
			return "redirect:../c_member/login_form.do";
		}
		
		//ip���ϱ�
		String c_b_ip = request.getRemoteAddr();
		vo.setC_b_ip(c_b_ip);
		
		//DB update
		int res = c_board_dao.update(vo);
		
		//model���ؼ� query�� ����
		model.addAttribute("c_b_idx", vo.getC_b_idx());
		model.addAttribute("page", page);
		model.addAttribute("search", search);
		model.addAttribute("search_text", search_text);
		
		return "redirect:view.do";
	}
	
}