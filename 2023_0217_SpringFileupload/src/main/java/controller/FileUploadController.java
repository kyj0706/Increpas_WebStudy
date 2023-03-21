package controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import vo.PhotoVo;

@Controller
public class FileUploadController {

	
	//���������� : <context:annotation-config/> �ݵ�� ����� �Ѵ�
	@Autowired
	ServletContext application;
	
	
	//������ �ޱ�
	// /upload1.do?title=����&photo=a.jpg
	//             CommonsMultipartResolver => MultipartFile(�ӽ�ȭ��) 
	@RequestMapping("/upload1.do")
	public String upload1(String title,
			              @RequestParam  MultipartFile photo,
			              Model model) {

		//������ ����
		String web_path = "/resources/upload/";
		String abs_path = application.getRealPath(web_path);
		
		System.out.println(abs_path);
		
		String filename = "no_file";
		
		if(!photo.isEmpty()) {//upload�� ȭ�� �����ϸ�
			
			//upload�� ȭ�� �̸� ������
			filename = photo.getOriginalFilename();
			
			File f = new File(abs_path, filename);
			
			//�������� ����ȭ�� �������� üũ
			if(f.exists()) {//�����ϳ�?
				
				long tm = System.currentTimeMillis(); // 1/1000�ʴ����� �ð�
				
				//ȭ�ϸ��� : �ð�_����ȭ�ϸ�
				filename = String.format("%d_%s", tm , filename);
				
				f = new File(abs_path, filename);
			}
			
			
			//�ӽ�����->���� ������ ��ġ�� ����
			try {
				photo.transferTo(f);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//model�� ���ؼ� �����͸� DS���� ���� =>��������� request binding
		model.addAttribute("title", title);
		model.addAttribute("filename",filename);
		
		return "result_input";//ViewName
	}
	
	
	//��ü�� �ޱ�
	// /upload2.do?title=����&photo=a.jpg
	
	@RequestMapping("/upload2.do")
	public String upload2(PhotoVo vo, Model model) {
		//������ ����
		String web_path = "/resources/upload/";
		String abs_path = application.getRealPath(web_path);
		
		System.out.println(abs_path);
		
		String filename = "no_file";
		
		MultipartFile photo = vo.getPhoto();
		
		if(!photo.isEmpty()) {//upload�� ȭ�� �����ϸ�
			
			//upload�� ȭ�� �̸� ������
			filename = photo.getOriginalFilename();
			
			File f = new File(abs_path, filename);
			
			//�������� ����ȭ�� �������� üũ
			if(f.exists()) {//�����ϳ�?
				
				long tm = System.currentTimeMillis(); // 1/1000�ʴ����� �ð�
				
				//ȭ�ϸ��� : �ð�_����ȭ�ϸ�
				filename = String.format("%d_%s", tm , filename);
				
				f = new File(abs_path, filename);
			}
			
			//�ӽ�����->���� ������ ��ġ�� ����
			try {
				photo.transferTo(f);
				vo.setFilename(filename);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//model�� ���ؼ� �����͸� DS���� ���� =>��������� request binding
		model.addAttribute("vo", vo);
		
		return "result_input2";//ViewName
	}
	
	
	//��Ƽȭ�� ����
	// /upload3.do?title=����&photo=a.jpg&photo=b.jpg
	
	@RequestMapping("/upload3.do")
	public String upload3(String title,
			              @RequestParam(name="photo") MultipartFile [] photo_array,
			              Model model) {

		//������ ����
		String web_path = "/resources/upload/";
		String abs_path = application.getRealPath(web_path);
		
		System.out.println(abs_path);
		
		String filename1 = "no_file";
		String filename2 = "no_file";
		
		for(int i=0; i< photo_array.length;i++ ) {
		
		    MultipartFile photo = photo_array[i];
		    
			if(!photo.isEmpty()) {//upload�� ȭ�� �����ϸ�
				
				//upload�� ȭ�� �̸� ������
				String filename = photo.getOriginalFilename();
				
				File f = new File(abs_path, filename);
				
				//�������� ����ȭ�� �������� üũ
				if(f.exists()) {//�����ϳ�?
					
					long tm = System.currentTimeMillis(); // 1/1000�ʴ����� �ð�
					
					//ȭ�ϸ��� : �ð�_����ȭ�ϸ�
					filename = String.format("%d_%s", tm , filename);
					
					f = new File(abs_path, filename);
				}
								
				
				//�ӽ�����->���� ������ ��ġ�� ����
				try {
					photo.transferTo(f);
					
					if(i==0)
						filename1 = filename;
					else
						filename2 = filename;
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}//end-for
		
		//model�� ���ؼ� �����͸� DS���� ���� =>��������� request binding
		model.addAttribute("title", title);
		model.addAttribute("filename1",filename1);
		model.addAttribute("filename2",filename2);
		
		return "result_input3";//ViewName
	}
	
	
	
	@RequestMapping("/upload4.do")
	public String upload4(String title,
			              @RequestParam(name="photo") List<MultipartFile> photo_list,
			              Model model) {
		//������ ����
		String web_path = "/resources/upload/";
		String abs_path = application.getRealPath(web_path);
				
		List<String> filename_list = new ArrayList<String>();
		
		for(MultipartFile photo : photo_list) {
			
			if(!photo.isEmpty()) {//upload�� ȭ�� �����ϸ�
				
				//upload�� ȭ�� �̸� ������
				String filename = photo.getOriginalFilename();
				
				File f = new File(abs_path, filename);
				
				//�������� ����ȭ�� �������� üũ
				if(f.exists()) {//�����ϳ�?
					
					long tm = System.currentTimeMillis(); // 1/1000�ʴ����� �ð�
					
					//ȭ�ϸ��� : �ð�_����ȭ�ϸ�
					filename = String.format("%d_%s", tm , filename);
					
					f = new File(abs_path, filename);
				}
								
				
				//�ӽ�����->���� ������ ��ġ�� ����
				try {
					photo.transferTo(f);
					
					filename_list.add(filename);
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}//end-if
			
		}//end-for
		
		
		//model�� ���ؼ� �����͸� DS���� ���� =>��������� request binding
		model.addAttribute("title", title);
		model.addAttribute("filename_list",filename_list);
		
		return "result_input4";//ViewName
	}
	
	
	
	
	
	
	
	
	
}
