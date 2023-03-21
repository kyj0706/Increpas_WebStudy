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
		//2.parameter받기
		String search      = request.getParameter("search");
		String search_text = request.getParameter("search_text");
		
		if(search==null) search = "all";
		
		//검색조건을 담을 map
		Map<String,String> map = new HashMap<String,String>();
		
		
		if(search.equals("name_content")) {
			//이름+내용
			map.put("name", search_text);
			map.put("content", search_text);
		}else if(search.equals("name")) {
			//이름
			map.put("name", search_text);
		}else if(search.equals("content")) {
			//내용
			map.put("content", search_text);
			
		}else if(search.equals("modifydate")) {
			//날짜
			map.put("modifydate", search_text);
		}
		
		
		//목록 가져오기
		List<VisitVo> list = VisitDao.getInstance().selectList(map);
		
		//request binding
		request.setAttribute("list", list);
	
		return "visit_list.jsp";// forward view page
	}
	
	//등록폼 띄우기
	@RequestMapping("/visit/insert_form.do")
	public String insert_form(HttpServletRequest request,HttpServletResponse response) {
		
		return "visit_insert_form.jsp";
	}
	
	
	//글 등록하기
	@RequestMapping("/visit/insert.do")
	public String insert(HttpServletRequest request,HttpServletResponse response) {
		
		//2.parameter받기
		String name 	= request.getParameter("name");
		String content 	= request.getParameter("content");//.replaceAll("\n", "<br>");
		//content = "동해물과\r\n백두산이\r\n..."
		System.out.println(content);
		
		String pwd 		= request.getParameter("pwd");
		
		//3.상대방(작성자)측 아이피
		String ip		= request.getRemoteAddr();
		
		//4.VisitVo포장
		VisitVo  vo = new VisitVo(name, content, pwd, ip);
		
		//5.DB insert
		int res = VisitDao.getInstance().insert(vo);
				
		return "redirect:list.do"; //FrontController에게 redirect정보 전달
		                           // response.sendRedirect("list.do"); 
	}
	
	//비밀번호 체크하기
	@RequestMapping(value="/visit/check_pwd.do",produces="text/json;charset=utf-8;")
	@ResponseBody
	public String check_pwd(HttpServletRequest request,HttpServletResponse response) {
		
		//2.parameter받기
		int    idx 		= Integer.parseInt(request.getParameter("idx"));
		String c_pwd 	= request.getParameter("c_pwd");

		//3.idx에 해당되는 게시물 1건 얻어온다
		VisitVo vo = VisitDao.getInstance().selectOne(idx);
		
		
		//원래비번==입력한비번
		boolean bResult = vo.getPwd().equals(c_pwd);
		
		//JSON Data생성
		JSONObject json = new JSONObject();
		json.put("result", bResult);
				
		return json.toString();
	}
	
	//등록폼 띄우기
	@RequestMapping("/visit/modify_form.do")
	public String modify_form(HttpServletRequest request,HttpServletResponse response) {
		
		//1.parameter 받기
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		//2.idx에 해당되는 게시물 얻어오기
		VisitVo vo = VisitDao.getInstance().selectOne(idx);
		// content: <br> -> \n 변환  <br />
		//String content = vo.getContent().replaceAll("<br>", "\n");
		//vo.setContent(content);
		
		//request binding
		request.setAttribute("vo", vo);
		
		
		return "visit_modify_form.jsp";
	}
	
	//수정하기
	@RequestMapping("/visit/modify.do")
	public String modify(HttpServletRequest request,HttpServletResponse response) {
		
		//2.parameter받기
		int    idx 		= Integer.parseInt(request.getParameter("idx"));
		String name 	= request.getParameter("name");
		String content 	= request.getParameter("content");//.replaceAll("\n", "<br>");
		String pwd		= request.getParameter("pwd");
		
		//3.ip구하기
		String ip		= request.getRemoteAddr();
		
		//4.VisitVo포장
		VisitVo vo = new VisitVo(idx, name, content, pwd, ip);
		
		//5.DB update
		int res = VisitDao.getInstance().update(vo); 
		
		return "redirect:list.do#v_" + idx;
	}
		
	
	//삭제하기
	@RequestMapping("/visit/delete.do")
	public String delete(HttpServletRequest request,HttpServletResponse response) {
		//경로
		//<img alt="" src="http://localhost:9090/2023_0125_Visit_ajax_Mybatis_MyMVC_ckeditor/upload/iu.png"
		
		//1.parameter받기
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		//1-1 게시물 내용 1건 얻어온다.
		VisitVo vo = VisitDao.getInstance().selectOne(idx);
		
		
		//1-2 파일 절대경로 확인 save_path가 절대경로 -> 경로 안에 있는 파일명을 빼와야데 
		String save_path =request.getServletContext().getRealPath("/upload");
		
		//System.out.println("파일 절대경로 확인: "+save_path);
		
		Document doc = Jsoup.parse(vo.getContent());
		Elements elems = doc.select("img");
		for(Element imgs : elems ) {
			String img_path = imgs.attr("src");
			int index 		= img_path.lastIndexOf("/");
			String filename = img_path.substring(index+1);
			
			//System.out.println("파일이름:"+filename);
			
			File f = new File(save_path,filename );
			//System.out.println(f);
			
			f.delete();
		}
				
		
		//2.DB delete
		int res = VisitDao.getInstance().delete(idx);
		
		//3.목록보기
		//response.sendRedirect("list.do");
		
		
		return "redirect:list.do";
	}
		
	
	
	
	
}
