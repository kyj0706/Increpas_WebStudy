package Action;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JuminAction
 */
@WebServlet("/Jumin.do")
public class JuminAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		//��û
		//int jumin = Integer.parseInt (request.getParameter("jumin_no"));
		
//==========================================		
		//�ֹι�ȣ
		String jumin = request.getParameter("jumin_no");		
//==========================================		
		//����⵵
		int year = Integer.parseInt(jumin.substring(0,2));
		//����
		String gender = jumin.substring(7,8);
		int gender_no = Integer.parseInt(gender);
		
		//int gender = Integer.parseInt(jumin.substring(7,8));
		switch (gender_no) {
		case 1: case 2: case 5: case 6: year +=1900; break;
		case 3: case 4: case 7: case 8: year +=2000; break;
		default: year += 1800;
		}
		
		//���� ����
		  if (gender_no%2==1) {
			  gender="����"; 
		  }else{
			  gender="����";
		  }	
//==========================================		
		//���� 
		
		//���� �ѱ� ��¥ ? [���� ǥ�ؽ� ���� ]
		ZonedDateTime now_Seoul_time = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy");
		String nst_str = now_Seoul_time.format(fmt);
		int nst_year = Integer.parseInt(nst_str);
		
		System.out.println("���ƽð� ���� ���� �ð�: "+nst_str);
//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		//���� �ѱ���¥ ���ϱ�
		//���� �ð� 
		LocalDate now = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy");
		String formattedNow = now.format(formatter);
		//���糯¥ ���� ��ȯ
		int now_year = Integer.parseInt(formattedNow);
		//���� ���� ���ϱ�
		int me_year = nst_year-year;
//==========================================
		//��
		String [] tti_array = {"������","��","��","����","��","��","ȣ����","�䳢","��","��","��","��"};
		String tti ="";
		
		tti = tti_array[year%12];
//==========================================
		//õ��
		String [] gan_array = {"��","��","��","��","��","��","��","��","��","��"};
		String [] ji_array = {"��","��","��","��","��","��","��","��","��","��","��","��"};
		
		String gan = "";
		String ji = "";
		
		gan = gan_array[year%10];
		ji = ji_array[year%12];
		
		
//==========================================
		//�������
		int month = Integer.parseInt(jumin.substring(2,4)); 
		String season = " ";
		switch (month/3) {
		case 1: season="��"; break;
		case 2: season="����"; break;
		case 3: season="����"; break;
		default: season="�ܿ�"; break;
		}
//==========================================		
		//�������
		int local = Integer.parseInt(jumin.substring(8,10));
		
		
		
		
		
//==========================================		
		System.out.println(now_year-year);
		System.out.println(year);
		System.out.println(gender);
		System.out.println(month);
		System.out.println(season);
		System.out.println(tti);
		System.out.println(gan);
		System.out.println(ji);
		System.out.println(local);
		
		//���̱��ϱ� (��)
		
		
		
		
		
		
		
		
		//���
		response.setContentType("text/html; charset=utf-8;");
		PrintWriter out = response.getWriter();
		out.println("<style type=\"text/css\">\r\n"
				+ "	table,td,th{\r\n"
				+ "	border: 1px solid black;\r\n"
				+ "	border-collapse: collapse; \r\n"
				+ "	width: 400px;\r\n"
				+ "	height: 50px;\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ "	th{\r\n"
				+ "		width: 150px;\r\n"
				+ "		font-size: 20px;\r\n"
				+ "	\r\n"
				+ "	}\r\n"
				+ "	\r\n"
				+ "	td{\r\n"
				+ "		text-align: center;\r\n"
				+ "		font-size: 25px;\r\n"
				+ "	\r\n"
				+ "	}\r\n"
				+ "</style>");
		
		
		out.println("<html>");
		out.println("<head><title>�ֹι�ȣ</title></head>");
		out.println("<body>");
		out.println("<table>");
		out.println("	<tr>\r\n"
				+ "			<th>�ֹι�ȣ</th>\r\n"
				+ "			<td>"+jumin+"</td>\r\n"
				+ "		</tr>\r\n"
				+ "		<tr>\r\n"
				+ "			<th>����⵵</th>\r\n"
				+ "			<td>"+year+"</td>\r\n"
				+ "		</tr>\r\n"
				+ "		<tr>\r\n"
				+ "			<th>����</th>\r\n"
				+ "			<td>"+me_year+"</td>\r\n"
				+ "		</tr>\r\n"
				+ "		<tr>\r\n"
				+ "			<th>����</th>\r\n"
				+ "			<td>"+gender+"</td>\r\n"
				+ "		</tr>\r\n"
				+ "		<tr>\r\n"
				+ "			<th>��</th>\r\n"
				+ "			<td>"+tti+"</td>\r\n"
				+ "		</tr>\r\n"
				+ "		<tr>\r\n"
				+ "			<th>õ��</th>\r\n"
				+ "			<td>"+gan+ji+"��</td>\r\n"
				+ "		</tr>\r\n"
				+ "		<tr>\r\n"
				+ "			<th>�������</th>\r\n"
				+ "			<td>"+season+"</td>\r\n"
				+ "		</tr>\r\n"
				+ "		<tr>\r\n"
				+ "			<th>�������</th>\r\n"
				+ "			<td>������...</td>\r\n"
				+ "		</tr>\r\n"
				+ "		<tr>\r\n"
				+ "			<th colspan='2'><a href='jumin.html'>�ٽ��ϱ�</a></th>\r\n"
				+ "		</tr>");
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
		
		
		
		
	}

}
