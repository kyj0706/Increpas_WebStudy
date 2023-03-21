package action;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class CKEditorImageUploadAction
 */
@WebServlet("/ckeditorImageUpload.do")
public class CKEditorImageUploadAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter printWriter = null;

        try{
        	String web_path = "/upload/";
            String abs_path = request.getServletContext().getRealPath(web_path);
            int    max_size = 1024*1024*100;
            
            MultipartRequest mr = new MultipartRequest(request, abs_path,max_size,"utf-8",
            		                       new DefaultFileRenamePolicy() 
            		);
            
            File f = mr.getFile("upload");
            String fileName="";
            if(f!=null){
            	fileName = f.getName();
            }
        	
            
            response.setContentType("text/html;charset=utf-8");
            printWriter = response.getWriter();
            
            String url = request.getRequestURL().toString().replaceAll("/ckeditorImageUpload.do", "");
            //System.out.println(url);
            
            String fileUrl = url + web_path + fileName;//url°æ·Î
            String sendData = String.format("{\"filename\" : \"%s\", \"uploaded\" : 1, \"url\":\"%s\"}", 
            		                                         fileName,       fileUrl
            		);
            printWriter.println(sendData);
            printWriter.flush();
 
        }catch(IOException e){
            e.printStackTrace();
        } finally {
            try {
                
                if (printWriter != null) {
                    printWriter.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
		
	}

}
