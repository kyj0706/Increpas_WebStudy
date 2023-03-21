package controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import dao.PhotoDao;
import vo.MemberVo;
import vo.PhotoVo;

@Controller

@RequestMapping("/photo/")
public class PhotoController {

	@Autowired
	HttpSession session;

	@Autowired
	HttpServletRequest request;

	@Autowired
	ServletContext application;

	PhotoDao photo_dao;

	public void setPhoto_dao(PhotoDao photo_dao) {
		this.photo_dao = photo_dao;
	}

	// ���丮��Ʈ
	@RequestMapping("list.do")
	public String list(Model model) {

		List<PhotoVo> list = photo_dao.selectList();

		model.addAttribute("list", list);

		return "photo/photo_list";
	}

	// ������ ����
	@RequestMapping("insert_form.do")
	public String insert_form() {

		return "photo/photo_insert_form";
	}

	// ������
	@RequestMapping("insert.do")
	public String insert(PhotoVo vo, @RequestParam MultipartFile photo, Model model) throws Exception {

		// ���ǿ� �����Ǿ� �ִ� �α��������� ���´�.
		MemberVo user = (MemberVo) session.getAttribute("user");
		// ������ ���ᰡ �� ���
		if (user == null) {
			// response.sendRedirect("../member/login_form.do?reason=logout");
			model.addAttribute("reason", "logout");
			return "redirect:..//member/login_form.do";
		}

		// ȸ����ȣ
		int mem_idx = user.getMem_idx();

		// ����������
		String abs_path = application.getRealPath("/resources/upload");
		System.out.println(abs_path);

		// ���ε�� �������� ���ϱ�
		String p_filename = "no_file";
		if (photo.isEmpty() == false) {

			p_filename = photo.getOriginalFilename();
			File f = new File(abs_path, p_filename);
			if (f.exists()) {// �������ϸ��� �ִ��� Ȯ��
				long tm = System.currentTimeMillis();// 1/1000�� �� ���ð�����
				p_filename = String.format("%d_%s", tm, p_filename);

				f = new File(abs_path, p_filename);
			}
			photo.transferTo(f);

		}
		// ip���ϱ�(request ���)
		String p_ip = request.getRemoteAddr();

		// ����
		String p_content = vo.getP_content().replaceAll("\n", "<br>");
		vo.setP_content(p_content);

		// �����̸� �־��ֱ�
		vo.setP_filename(p_filename);
		vo.setP_ip(p_ip);
		vo.setMem_idx(mem_idx);

		// DB ��������ֱ�
		int res = photo_dao.insert(vo);

		return "redirect:list.do";
	}

	// �������
	@RequestMapping(value = "photo_detail.do", produces = "text/json; charset=utf-8;")
	@ResponseBody
	public String photo_detail(int p_idx) {

		PhotoVo vo = photo_dao.selectOne(p_idx);

		JSONObject json = new JSONObject();
		json.put("p_idx", vo.getP_idx());
		json.put("p_title", vo.getP_title());
		json.put("p_content", vo.getP_content());
		json.put("p_filename", vo.getP_filename());
		json.put("p_ip", vo.getP_ip());
		json.put("p_regdate", vo.getP_regdate());
		json.put("p_modifydate", vo.getP_modifydate());
		json.put("mem_idx", vo.getMem_idx());

		return json.toString();
	}

	// ���� ����������
	@RequestMapping("modify_form.do")
	public String modify_form(int p_idx, Model model) {

		PhotoVo vo = photo_dao.selectOne(p_idx);

		String p_content = vo.getP_content().replaceAll("<br>", "\n");
		vo.setP_content(p_content);

		model.addAttribute("vo", vo);

		return "photo/photo_modify_form";
	}

	// ���� ����(����)
	@RequestMapping("modify.do")
	public String modify(PhotoVo vo) {

		// ip���ϱ�(request ���)
		String p_ip = request.getRemoteAddr();

		//
		String p_title =vo.getP_title();
		
		// ����
		String p_content = vo.getP_content().replaceAll("\n", "<br>");
		vo.setP_content(p_content);
		vo.setP_title(p_title);
		vo.setP_ip(p_ip);

		int res = photo_dao.update(vo);

		return "redirect:list.do";
	}
	
	//��������
	@RequestMapping(value =  "photo_upload.do" ,produces ="text/json; charset=utf-8;" )
	@ResponseBody
	public String photo_upload(int p_idx, @RequestParam MultipartFile photo) throws Exception {
		
		String abs_path = application.getRealPath("/resources/upload");
		System.out.println("���� :" +abs_path);
		
		
		// ���ε�� �������� ���ϱ�
				String p_filename = "no_file";
				if (photo.isEmpty() == false) {

					p_filename = photo.getOriginalFilename();
					File f = new File(abs_path, p_filename);
					if (f.exists()) {// �������ϸ��� �ִ��� Ȯ��
						long tm = System.currentTimeMillis();// 1/1000�� �� ���ð�����
						p_filename = String.format("%d_%s", tm, p_filename);

						f = new File(abs_path, p_filename);
					}
					photo.transferTo(f);

				}
		
			
		
		PhotoVo vo = photo_dao.selectOne(p_idx);
		File f_del = new File(abs_path, vo.getP_filename());
		f_del.delete();
		
		vo.setP_filename(p_filename);
		
		int res = photo_dao.update_filename(vo);
		
		JSONObject json = new JSONObject();
		json.put("p_filename", p_filename);
		
		return json.toString();
	}
	
	
	//�������
	@RequestMapping("delete.do")
	public String delete(int p_idx) {
		
		
		String abs_path = application.getRealPath("/resources/upload");
		
		PhotoVo vo = photo_dao.selectOne(p_idx);
		File f = new File(abs_path,vo.getP_filename());
		f.delete();
		
		
		int res = photo_dao.delete(p_idx);

		return "redirect:list.do";
	}
	

}
