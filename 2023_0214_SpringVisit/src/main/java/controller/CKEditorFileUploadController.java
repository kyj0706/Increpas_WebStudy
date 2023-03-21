package controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


@Controller
public class CKEditorFileUploadController {

	
	@Autowired
	ServletContext application;
	
	@Autowired
	HttpServletRequest request;
	
	
	@RequestMapping("/ckeditorImageUpload.do")
	@ResponseBody
	public Map ckeditorImageUpload(
			@RequestParam MultipartFile upload) throws     Exception {
	
        try{
 
            String fileName = upload.getOriginalFilename(); 
            
            //여러분들의 저장경로 설정
            String web_path = "/resources/upload/";
            
            
            String abs_path = application.getRealPath(web_path);
            //String uploadPath = "저장경로/" + fileName;//저장경로
            File f = new File(abs_path,fileName);
            //동일화일이 있는경우
            if(f.exists()){
            	 long time = System.currentTimeMillis();
            	 int index = fileName.lastIndexOf('.');
            	 String f_name = fileName.substring(0,index);
            	 String f_ext  = fileName.substring(index);
            	 
            	 fileName = String.format("%s_%d%s", f_name,time,f_ext);
            	 f = new File(abs_path,fileName);
            }
            //업로드화일 지정된 위치로 복사
            upload.transferTo(f);
            
            
            String url = request.getRequestURL().toString().replaceAll("/ckeditorImageUpload.do", "");
            String fileUrl = url + web_path + fileName;//url경로
            
            //String res_data = "{\"filename\" : \"" + fileName + "\", \"uploaded\" : 1, \"url\":\"" + fileUrl + "\"}";
            
            
            //JSON생성
            /*
            JSONObject json = new JSONObject();
            json.put("filename", fileName);
            json.put("uploaded", 1);
            json.put("url", fileUrl);
            */
            Map map = new HashMap();           
            map.put("filename", fileName);
            map.put("uploaded", 1);
            map.put("url", fileUrl);
            
            return map;
 
        }catch(IOException e){
            e.printStackTrace();
        } 
        
        return null;
 	}
	
	



	
}