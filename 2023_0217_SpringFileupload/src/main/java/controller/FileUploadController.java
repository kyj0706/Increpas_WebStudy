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

	
	//수동생성시 : <context:annotation-config/> 반드시 해줘야 한다
	@Autowired
	ServletContext application;
	
	
	//낱개로 받기
	// /upload1.do?title=제목&photo=a.jpg
	//             CommonsMultipartResolver => MultipartFile(임시화일) 
	@RequestMapping("/upload1.do")
	public String upload1(String title,
			              @RequestParam  MultipartFile photo,
			              Model model) {

		//저장경로 설정
		String web_path = "/resources/upload/";
		String abs_path = application.getRealPath(web_path);
		
		System.out.println(abs_path);
		
		String filename = "no_file";
		
		if(!photo.isEmpty()) {//upload된 화일 존재하면
			
			//upload된 화일 이름 얻어오기
			filename = photo.getOriginalFilename();
			
			File f = new File(abs_path, filename);
			
			//저장전에 동일화일 존재유무 체크
			if(f.exists()) {//존재하냐?
				
				long tm = System.currentTimeMillis(); // 1/1000초단위의 시간
				
				//화일명변경 : 시간_원본화일명
				filename = String.format("%d_%s", tm , filename);
				
				f = new File(abs_path, filename);
			}
			
			
			//임시파일->내가 지정한 위치로 복사
			try {
				photo.transferTo(f);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//model을 통해서 데이터를 DS에게 전달 =>결과적으로 request binding
		model.addAttribute("title", title);
		model.addAttribute("filename",filename);
		
		return "result_input";//ViewName
	}
	
	
	//객체로 받기
	// /upload2.do?title=제목&photo=a.jpg
	
	@RequestMapping("/upload2.do")
	public String upload2(PhotoVo vo, Model model) {
		//저장경로 설정
		String web_path = "/resources/upload/";
		String abs_path = application.getRealPath(web_path);
		
		System.out.println(abs_path);
		
		String filename = "no_file";
		
		MultipartFile photo = vo.getPhoto();
		
		if(!photo.isEmpty()) {//upload된 화일 존재하면
			
			//upload된 화일 이름 얻어오기
			filename = photo.getOriginalFilename();
			
			File f = new File(abs_path, filename);
			
			//저장전에 동일화일 존재유무 체크
			if(f.exists()) {//존재하냐?
				
				long tm = System.currentTimeMillis(); // 1/1000초단위의 시간
				
				//화일명변경 : 시간_원본화일명
				filename = String.format("%d_%s", tm , filename);
				
				f = new File(abs_path, filename);
			}
			
			//임시파일->내가 지정한 위치로 복사
			try {
				photo.transferTo(f);
				vo.setFilename(filename);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//model을 통해서 데이터를 DS에게 전달 =>결과적으로 request binding
		model.addAttribute("vo", vo);
		
		return "result_input2";//ViewName
	}
	
	
	//멀티화일 수신
	// /upload3.do?title=제목&photo=a.jpg&photo=b.jpg
	
	@RequestMapping("/upload3.do")
	public String upload3(String title,
			              @RequestParam(name="photo") MultipartFile [] photo_array,
			              Model model) {

		//저장경로 설정
		String web_path = "/resources/upload/";
		String abs_path = application.getRealPath(web_path);
		
		System.out.println(abs_path);
		
		String filename1 = "no_file";
		String filename2 = "no_file";
		
		for(int i=0; i< photo_array.length;i++ ) {
		
		    MultipartFile photo = photo_array[i];
		    
			if(!photo.isEmpty()) {//upload된 화일 존재하면
				
				//upload된 화일 이름 얻어오기
				String filename = photo.getOriginalFilename();
				
				File f = new File(abs_path, filename);
				
				//저장전에 동일화일 존재유무 체크
				if(f.exists()) {//존재하냐?
					
					long tm = System.currentTimeMillis(); // 1/1000초단위의 시간
					
					//화일명변경 : 시간_원본화일명
					filename = String.format("%d_%s", tm , filename);
					
					f = new File(abs_path, filename);
				}
								
				
				//임시파일->내가 지정한 위치로 복사
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
		
		//model을 통해서 데이터를 DS에게 전달 =>결과적으로 request binding
		model.addAttribute("title", title);
		model.addAttribute("filename1",filename1);
		model.addAttribute("filename2",filename2);
		
		return "result_input3";//ViewName
	}
	
	
	
	@RequestMapping("/upload4.do")
	public String upload4(String title,
			              @RequestParam(name="photo") List<MultipartFile> photo_list,
			              Model model) {
		//저장경로 설정
		String web_path = "/resources/upload/";
		String abs_path = application.getRealPath(web_path);
				
		List<String> filename_list = new ArrayList<String>();
		
		for(MultipartFile photo : photo_list) {
			
			if(!photo.isEmpty()) {//upload된 화일 존재하면
				
				//upload된 화일 이름 얻어오기
				String filename = photo.getOriginalFilename();
				
				File f = new File(abs_path, filename);
				
				//저장전에 동일화일 존재유무 체크
				if(f.exists()) {//존재하냐?
					
					long tm = System.currentTimeMillis(); // 1/1000초단위의 시간
					
					//화일명변경 : 시간_원본화일명
					filename = String.format("%d_%s", tm , filename);
					
					f = new File(abs_path, filename);
				}
								
				
				//임시파일->내가 지정한 위치로 복사
				try {
					photo.transferTo(f);
					
					filename_list.add(filename);
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}//end-if
			
		}//end-for
		
		
		//model을 통해서 데이터를 DS에게 전달 =>결과적으로 request binding
		model.addAttribute("title", title);
		model.addAttribute("filename_list",filename_list);
		
		return "result_input4";//ViewName
	}
	
	
	
	
	
	
	
	
	
}
