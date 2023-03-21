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
            
            //�����е��� ������ ����
            String web_path = "/resources/upload/";
            
            
            String abs_path = application.getRealPath(web_path);
            //String uploadPath = "������/" + fileName;//������
            File f = new File(abs_path,fileName);
            //����ȭ���� �ִ°��
            if(f.exists()){
            	 long time = System.currentTimeMillis();
            	 int index = fileName.lastIndexOf('.');
            	 String f_name = fileName.substring(0,index);
            	 String f_ext  = fileName.substring(index);
            	 
            	 fileName = String.format("%s_%d%s", f_name,time,f_ext);
            	 f = new File(abs_path,fileName);
            }
            //���ε�ȭ�� ������ ��ġ�� ����
            upload.transferTo(f);
            
            
            String url = request.getRequestURL().toString().replaceAll("/ckeditorImageUpload.do", "");
            String fileUrl = url + web_path + fileName;//url���
            
            //String res_data = "{\"filename\" : \"" + fileName + "\", \"uploaded\" : 1, \"url\":\"" + fileUrl + "\"}";
            
            
            //JSON����
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