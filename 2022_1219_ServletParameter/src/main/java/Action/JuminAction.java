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
		
		
		//요청
		//int jumin = Integer.parseInt (request.getParameter("jumin_no"));
		
//==========================================		
		//주민번호
		String jumin = request.getParameter("jumin_no");		
//==========================================		
		//출생년도
		int year = Integer.parseInt(jumin.substring(0,2));
		//성별
		String gender = jumin.substring(7,8);
		int gender_no = Integer.parseInt(gender);
		
		//int gender = Integer.parseInt(jumin.substring(7,8));
		switch (gender_no) {
		case 1: case 2: case 5: case 6: year +=1900; break;
		case 3: case 4: case 7: case 8: year +=2000; break;
		default: year += 1800;
		}
		
		
		
		//성별 구분
		  if (gender_no%2==1) {
			  gender="남자"; 
		  }else{
			  gender="여자";
		  }	
//==========================================		
		//나이 
		
		//현재 한국 날짜 ? [유럽 표준시 기준 ]
		ZonedDateTime now_Seoul_time = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy");
		String nst_str = now_Seoul_time.format(fmt);
		int nst_year = Integer.parseInt(nst_str);
		
		System.out.println("유렵시간 기준 서울 시간: "+nst_str);
//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		//현재 한국날짜 구하기
		//로컬 시간 
		LocalDate now = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy");
		String formattedNow = now.format(formatter);
		//현재날짜 숫자 변환
		int now_year = Integer.parseInt(formattedNow);
		//현재 나이 구하기
		int me_year = nst_year-year;
//==========================================
		//띠
		String [] tti_array = {"원숭이","닭","개","돼지","쥐","소","호랑이","토끼","용","뱀","소","양"};
		String tti ="";
		
		tti = tti_array[year%12];
//==========================================
		//천간
		String [] gan_array = {"경","신","임","계","갑","을","병","정","무","기"};
		String [] ji_array = {"신","유","술","해","자","축","인","묘","진","사","오","미"};
		
		String gan = "";
		String ji = "";
		
		gan = gan_array[year%10];
		ji = ji_array[year%12];
		
		
//==========================================
		//출생계절
		int month = Integer.parseInt(jumin.substring(2,4)); 
		String season = " ";
		switch (month/3) {
		case 1: season="봄"; break;
		case 2: season="여름"; break;
		case 3: season="가을"; break;
		default: season="겨울"; break;
		}
//==========================================		
		//출생지역
		int local = Integer.parseInt(jumin.substring(8,10));
		String local_str = "";
		
		
		if(local>=0 && local<=8) 		  local_str ="서울특별시";
		else if (local>=9 && local<=12)  local_str ="부산광역시";
		else if (local>=13 && local<=15) local_str ="인천광역시";
		else if (local>=16 && local<=25) local_str ="경기도";
		else if (local>=26 && local<=34) local_str ="강원도";
		else if (local>=35 && local<=39) local_str ="충청북도";
		else if (local>=40 && local<=41) local_str ="대전광역시";
		else if (local == 44) local_str ="(구)세종특별자치시";	
		else if (local == 99) local_str ="(신)세종특별자치시";	
		else if (local>=42 && local<=43 || local>=45 && local<=47) local_str ="충청남도";
		else if (local>=48 && local<=54) local_str="전라북도";
		else if (local==56) local_str="(구)광주광역시";
		else if (local>=55 && local<=64) local_str="전라남도";	
		else if (local>=65 && local<=66) local_str="(신)광주광역시";
		else if (local>=67 && local<=69) local_str="대구광역시";
		else if (local>=70 && local<=81) local_str="경상북도";
		else if (local==85 || local==90) local_str="울산광역시"; 
		else if (local>=82 && local<=84 || local>=86 && local<=91) local_str="경상남도";
		else if (local>=92 && local<=95) local_str="제주특별자치도";
		
		//2020년 10월 이전 지역 코드 있음 
		
		
		//2020년 10월 이후 지역 코드 없음 
		
		
		
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
		
		//나이구하기 (만)
		
		
		
		
		
		
		
		
		//결과
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
		out.println("<head><title>주민번호</title></head>");
		out.println("<body>");
		out.println("<table>");
		out.println("	<tr>\r\n"
				+ "			<th>주민번호</th>\r\n"
				+ "			<td>"+jumin+"</td>\r\n"
				+ "		</tr>\r\n"
				+ "		<tr>\r\n"
				+ "			<th>출생년도</th>\r\n"
				+ "			<td>"+year+"년</td>\r\n"
				+ "		</tr>\r\n"
				+ "		<tr>\r\n"
				+ "			<th>나이</th>\r\n"
				+ "			<td>"+me_year+"살</td>\r\n"
				+ "		</tr>\r\n"
				+ "		<tr>\r\n"
				+ "			<th>성별</th>\r\n"
				+ "			<td>"+gender+"</td>\r\n"
				+ "		</tr>\r\n"
				+ "		<tr>\r\n"
				+ "			<th>띠</th>\r\n"
				+ "			<td>"+tti+"</td>\r\n"
				+ "		</tr>\r\n"
				+ "		<tr>\r\n"
				+ "			<th>천간</th>\r\n"
				+ "			<td>"+gan+ji+"년</td>\r\n"
				+ "		</tr>\r\n"
				+ "		<tr>\r\n"
				+ "			<th>출생계절</th>\r\n"
				+ "			<td>"+season+"</td>\r\n"
				+ "		</tr>\r\n"
				+ "		<tr>\r\n"
				+ "			<th>출생지역</th>\r\n"
				+ "			<td>"+((year>=2000) ? ((month>=10)? "20년10월이후 출생자는 지역코드가 없습니다." : local_str):local_str)+"</td>\r\n"
				+ "		</tr>\r\n"
				+ "		<tr>\r\n"
				+ "			<th colspan='2'><a href='jumin.html'>다시하기</a></th>\r\n"
				+ "		</tr>");
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
		
		
		
		
	}

}
