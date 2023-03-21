package action;

import java.io.File;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class FileUploadAction
 */
@WebServlet("/upload.do")
public class FileUploadAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// /upload.do?title=����&photo=a.jpg
		
		
		String web_path = "/upload/";
		String save_path = "";//"c:\\work\\upload"; //������ġ
		
		//����� ->������ ���ϴ� ��ü
		ServletContext application= request.getServletContext(); //������Ʈ�� ���� ? �����ϴ°��� ��
		save_path = application.getRealPath(web_path);
		System.out.println(save_path);
		//�������
		
		
		//����������ü�̴�.
		
		int    max_size  = 1024*1024*100;      //���ε��ִ�뷮:100MB
		
		//ȭ�Ͼ��ε�� �Ķ����ó��
		MultipartRequest mr = new MultipartRequest( request,   //request����
				                                    save_path, //������ġ
				                                    max_size,  //����ũŰ  
				                                    "utf-8",   //�������ڵ�
				                                    //�̹�ȭ���� �����ϸ� �̸��� �����ؼ� ���ε�
				                                    new DefaultFileRenamePolicy() 
				                                    );
		
		
		//���ε�� �������� ���ϱ�
		String filename="no_file";
		
		//���1
		File f = mr.getFile("photo"); //getFile("parameter name");
		if(f != null) {
			filename = f.getName();
		}
		
		//���2
		/*
		filename = mr.getOriginalFileName("photo");
		if(filename ==null) {
			filename = "no_file";
		}
		*/
		
		//String title = request.getParameter("title"); //�̷��� �ϸ� null�� ���´�
		//�Ķ���� ���� ���ϱ�(����: ���Ͼ��ε�ÿ��� mr�� �̿��ؾ��Ѵ�.
		String title = mr.getParameter("title");
		
		//request binding
		request.setAttribute("title", title);
		request.setAttribute("filename", filename);
		
		//forward
		String forward_page = "result_photo.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);

	}

}
