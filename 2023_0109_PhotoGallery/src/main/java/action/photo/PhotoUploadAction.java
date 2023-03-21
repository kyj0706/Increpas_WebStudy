package action.photo;

import java.io.File;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.PhotoDao;
import vo.PhotoVo;

/**
 * Servlet implementation class PhotoUploadAction
 */
@WebServlet("/photo/photo_upload.do") //URL ���
public class PhotoUploadAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String web_path = "/upload/";
		String save_path = "";//"c:\\work\\upload"; //������ġ
		
		//����� ->������ ���ϴ� ��ü
		ServletContext application= request.getServletContext(); //������Ʈ�� ���� ? �����ϴ°��� ��
		save_path = application.getRealPath(web_path);
		//System.out.println(""+save_path);
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
		String p_filename="no_file";
		
		//���1
		File f = mr.getFile("photo"); //getFile("parameter name");
		if(f != null) {
			p_filename = f.getName();
		}
		
		//Parameter �ޱ�
		int p_idx = Integer.parseInt(mr.getParameter("p_idx"));
		
		//�����ִ� ���� ���� 
		PhotoVo vo = PhotoDao.getInstance().selectOne(p_idx);
		File f_del = new File(save_path, vo.getP_filename());
		f_del.delete();
		
		
		//������ �������� ���� 
		vo.setP_filename(p_filename);//���� ���ε�� ���ϸ����� ����
		
		//DB����
		int res = PhotoDao.getInstance().update_filename(vo);
		
		//���۵����� ����
		JSONObject json = new JSONObject();
		json.put("p_filename", p_filename);
		
		//�������
		response.setContentType("text/json; charset=utf-8;");
		response.getWriter().print(json.toString());;
		


	}

}

