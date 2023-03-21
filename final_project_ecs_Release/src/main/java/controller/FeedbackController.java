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

		//���ǿ� ��ϵ� ���� �����(show)
		session.removeAttribute("show");
		
		//Pagingó�� 
		//1.start & end ���
		int start = (nowPage-1) * MyConstant.Car.BLOCK_LIST + 1;
		int end   = start + MyConstant.Car.BLOCK_LIST - 1;
		
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
		int rowTotal = feedback_dao.selectRowTotal(map);
		//System.out.println(rowTotal);
		
		//�˻����� :                          search=name&search_text=ȫ�浿
		String search_filter = String.format("search=%s&search_text=%s", search,search_text);
		
		//������ �޴� �����ϱ�
		String pageMenu = Paging.getPaging("list.do", 
				                            search_filter,
				                            nowPage, 
				                            rowTotal,
				                            MyConstant.Car.BLOCK_LIST,
				                            MyConstant.Car.BLOCK_PAGE
				                            );
		//System.out.println(pageMenu);
		
		
		//�Խ��Ǹ�� �о����
		List<FeedbackVo> list = feedback_dao.selectList(map);
		
		//��������� request binding
		model.addAttribute("list", list);
		model.addAttribute("pageMenu", pageMenu);
		
		return "feedback/feedback_list";//ViewName
	}
	
	
	
}
