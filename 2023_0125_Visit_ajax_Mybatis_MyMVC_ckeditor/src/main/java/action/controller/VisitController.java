package action.controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import annotation.RequestMapping;
import annotation.ResponseBody;
import dao.VisitDao;
import vo.VisitVo;

public class VisitController {

	@RequestMapping("/visit/list.do")
	public String list(HttpServletRequest request,HttpServletResponse response) {
		//2.parameter�ޱ�
		String search      = request.getParameter("search");
		String search_text = request.getParameter("search_text");
		
		if(search==null) search = "all";
		
		//�˻������� ���� map
		Map<String,String> map = new HashMap<String,String>();
		
		
		if(search.equals("name_content")) {
			//�̸�+����
			map.put("name", search_text);
			map.put("content", search_text);
		}else if(search.equals("name")) {
			//�̸�
			map.put("name", search_text);
		}else if(search.equals("content")) {
			//����
			map.put("content", search_text);
			
		}else if(search.equals("modifydate")) {
			//��¥
			map.put("modifydate", search_text);
		}
		
		
		//��� ��������
		List<VisitVo> list = VisitDao.getInstance().selectList(map);
		
		//request binding
		request.setAttribute("list", list);
	
		return "visit_list.jsp";// forward view page
	}
	
	//����� ����
	@RequestMapping("/visit/insert_form.do")
	public String insert_form(HttpServletRequest request,HttpServletResponse response) {
		
		return "visit_insert_form.jsp";
	}
	
	
	//�� ����ϱ�
	@RequestMapping("/visit/insert.do")
	public String insert(HttpServletRequest request,HttpServletResponse response) {
		
		//2.parameter�ޱ�
		String name 	= request.getParameter("name");
		String content 	= request.getParameter("content");//.replaceAll("\n", "<br>");
		//content = "���ع���\r\n��λ���\r\n..."
		System.out.println(content);
		
		String pwd 		= request.getParameter("pwd");
		
		//3.����(�ۼ���)�� ������
		String ip		= request.getRemoteAddr();
		
		//4.VisitVo����
		VisitVo  vo = new VisitVo(name, content, pwd, ip);
		
		//5.DB insert
		int res = VisitDao.getInstance().insert(vo);
				
		return "redirect:list.do"; //FrontController���� redirect���� ����
		                           // response.sendRedirect("list.do"); 
	}
	
	//��й�ȣ üũ�ϱ�
	@RequestMapping(value="/visit/check_pwd.do",produces="text/json;charset=utf-8;")
	@ResponseBody
	public String check_pwd(HttpServletRequest request,HttpServletResponse response) {
		
		//2.parameter�ޱ�
		int    idx 		= Integer.parseInt(request.getParameter("idx"));
		String c_pwd 	= request.getParameter("c_pwd");

		//3.idx�� �ش�Ǵ� �Խù� 1�� ���´�
		VisitVo vo = VisitDao.getInstance().selectOne(idx);
		
		
		//�������==�Է��Ѻ��
		boolean bResult = vo.getPwd().equals(c_pwd);
		
		//JSON Data����
		JSONObject json = new JSONObject();
		json.put("result", bResult);
				
		return json.toString();
	}
	
	//����� ����
	@RequestMapping("/visit/modify_form.do")
	public String modify_form(HttpServletRequest request,HttpServletResponse response) {
		
		//1.parameter �ޱ�
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		//2.idx�� �ش�Ǵ� �Խù� ������
		VisitVo vo = VisitDao.getInstance().selectOne(idx);
		// content: <br> -> \n ��ȯ  <br />
		//String content = vo.getContent().replaceAll("<br>", "\n");
		//vo.setContent(content);
		
		//request binding
		request.setAttribute("vo", vo);
		
		
		return "visit_modify_form.jsp";
	}
	
	//�����ϱ�
	@RequestMapping("/visit/modify.do")
	public String modify(HttpServletRequest request,HttpServletResponse response) {
		
		//2.parameter�ޱ�
		int    idx 		= Integer.parseInt(request.getParameter("idx"));
		String name 	= request.getParameter("name");
		String content 	= request.getParameter("content");//.replaceAll("\n", "<br>");
		String pwd		= request.getParameter("pwd");
		
		//3.ip���ϱ�
		String ip		= request.getRemoteAddr();
		
		//4.VisitVo����
		VisitVo vo = new VisitVo(idx, name, content, pwd, ip);
		
		//5.DB update
		int res = VisitDao.getInstance().update(vo); 
		
		return "redirect:list.do#v_" + idx;
	}
		
	
	//�����ϱ�
	@RequestMapping("/visit/delete.do")
	public String delete(HttpServletRequest request,HttpServletResponse response) {
		//���
		//<img alt="" src="http://localhost:9090/2023_0125_Visit_ajax_Mybatis_MyMVC_ckeditor/upload/iu.png"
		
		//1.parameter�ޱ�
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		//1-1 �Խù� ���� 1�� ���´�.
		VisitVo vo = VisitDao.getInstance().selectOne(idx);
		
		
		//1-2 ���� ������ Ȯ�� save_path�� ������ -> ��� �ȿ� �ִ� ���ϸ��� ���;ߵ� 
		String save_path =request.getServletContext().getRealPath("/upload");
		
		//System.out.println("���� ������ Ȯ��: "+save_path);
		
		Document doc = Jsoup.parse(vo.getContent());
		Elements elems = doc.select("img");
		for(Element imgs : elems ) {
			String img_path = imgs.attr("src");
			int index 		= img_path.lastIndexOf("/");
			String filename = img_path.substring(index+1);
			
			//System.out.println("�����̸�:"+filename);
			
			File f = new File(save_path,filename );
			//System.out.println(f);
			
			f.delete();
		}
				
		
		//2.DB delete
		int res = VisitDao.getInstance().delete(idx);
		
		//3.��Ϻ���
		//response.sendRedirect("list.do");
		
		
		return "redirect:list.do";
	}
		
	
	
	
	
}
