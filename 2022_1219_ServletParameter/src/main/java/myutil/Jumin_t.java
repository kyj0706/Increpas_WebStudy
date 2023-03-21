package myutil;

import java.util.Calendar;

public class Jumin_t {

	private String jumin_no;

	//setter
	public void setJumin_no(String jumin_no) {
		this.jumin_no = jumin_no;
	}
	
	
	//            01234567890123   <- index
	//jumin_no = "801212-1234560";
	
	/*
	    성별코드의 값
	  
	               내국인       외국인  
	               남  여       남  여 
	     1900      1   2        5   6         
	     2000      3   4        7   8
	     1800      9   0
	
	*/
	
	//출생년도 구하기
	public int getYear() {
		
		String str_year = this.jumin_no.substring(0, 2);// "80"
		
		//문자열 -> 정수로 변환 : Integer.parseInt("문자열") ->정수
		int year = Integer.parseInt(str_year);// "80" -> 80
		
		//주민번호에서 성별자릿수의 문자 1개 추출
		char gender = jumin_no.charAt(7); //  '1'
		
		switch(gender)
		{
			case '1': 
			case '2': 
			case '5': 
			case '6': year = year + 1900; break;
			case '3': 
			case '4': 
			case '7': 
			case '8': year = year + 2000; break;
			case '9':
			case '0': year = year + 1800; 
		}
		return year;
		
	}//end-getYear()
	
	
	
	//나이 구하기
	public int getAge() {
		
		int age = 0;
		
		//현재 시스템 날짜 구하기
		Calendar c    = Calendar.getInstance();
		int curr_year = c.get(Calendar.YEAR);//년도구하기
		
		//나이 = 현재년도-출생년도 + 1   <= 한국나이
		//           자신의메소드 호출
		age = curr_year - this.getYear() + 1;
		
		return age;
		
	}//end-getAge()
	

	//            01234567890123   <- index
	//jumin_no = "801212-1234560";
	
	//출생지역
	public String getLocal() {
		
		String str_local = jumin_no.substring(8, 8+2); // "23"
		int    local     = Integer.parseInt(str_local);// "23" -> 23
		
		
		if(local>=0 && local<=8) return "서울";
		else if(local>=9 && local<=12) return "부산광역시";
		else if(local>=13 && local<=15) return "인천광역시";
		else if(local>=16 && local<=25) return "경기도";
		else if(local>=26 && local<=34) return "강원도";
		else if(local>=35 && local<=39) return "충청북도";
		else if(local==40) return "대전";
		else if(local==44 || local==96) return "세종시"; //41  47 사이에 걸리기 때문에 순서가 바뀌어야한다.
		else if(local>=41 && local<=47) return "충청남도";
		else if(local>=48 && local<=54) return "전라북도";
		else if(local>=55 && local<=64) return "전라남도";
		else if(local>=65 && local<=66) return "광주광역시";
		else if(local>=67 && local<=69 || local==76) return "대구광역시";
		else if(local>=70 && local<=81) return "경상북도";
		else if(local==85) return "울산";
		else if(local>=82 && local<=93) return "경상남도";
		else if(local>=94 && local<=95) return "제주도";
		
		
		return "제주";
	}
	
	
	//계절구하기
	public String getSeason() {
		
		String str_month = jumin_no.substring(2, 4);   //"12"
		int    month     = Integer.parseInt(str_month);//"12" -> 12
		
		//방법1(if문)
		/*
		if(month>=3 && month <=5) return "봄";
		else if(month>=6 && month <=8) return "여름";
		else if(month>=9 && month <=11) return "가을";
		*/
		
		//방법2(switch 문)
		/*
		  switch (month) 
		 
		{
		case 3:case 4:case 5: return "봄";
		}
		*/
		
		//방법(switch문 나누기 몫으로 )
		
		switch (month/3) 
		{
		case 1: return "봄"; 	// 3 4 5   /3->몫1
		case 2: return "여름"; // 6 7 8   /3->몫2
		case 3: return "가을"; // 9 10 11 /3->몫3
		}
		
		return "겨울";
		
	}//end-getSeason()
	
	//성별 구하기
	public String getGender() {
		
		char gender = this.jumin_no.charAt(7); // '1'

		//방법1
		if(gender=='1' || gender=='3' || gender=='5' || gender=='7' || gender=='9')
			return "남자";
		
		//방법2
		//int gender_num = gender - '0';// 숫자 : 1
		//if(gender_num%2==1) return "남자";
				
		
		return "여자";
		
	}//end-getGender()
	
	
	//12지
	// 4  5  6  7  8  9  10 11 0  1  2  3  <- tti_index (출생년도%12)                                        
	// 자 축 인 묘 진 사 오 미 신 유 술 해
	// 쥐 소 범 토 용 뱀 말 양 원 닭 개 돼
	// 출생년도%12 -> 0 ~ 11사이의 값
	
	
	// 띠 구하기
	/*
	public String getTti() {
		
		int tti_index = this.getYear()%12; // 0 ~11 사이
		
		switch(tti_index)
		{
		   //      return 값:호출한곳으로 값을 갖고 복귀   
		case 0:return "원숭이";
		case 1:return "닭";
		case 2:return "개";
		case 3:return "돼지";
		case 4:return "쥐";
		case 5:return "소";
		case 6:return "호랑이";
		case 7:return "토끼";
		case 8:return "용";
		case 9:return "뱀";
		case 10:return "말";
		}
		
		return "양";
	}//end-getTti
	*/
	
	
	//221019 추가 배열을 배웠으니깐
	public String getTti2() {
		
		String [] Tti_array = {"원숭이","닭","개","돼지","쥐","소","호랑이","토끼","용","뱀","말","양" };
		
		int tti_index = this.getYear()%12;// 0 ~11 사이
		
		return Tti_array[tti_index] ;
	}
	
	
	//10간
	
	//4  5  6  7  8  9  0  1  2  3    		<= 출생년도%10
	//갑 을 병 정 무 기 경 신 임 계
	
	
	//12지
	//4  5  6  7  8  9  10 11 0  1  2  3	<= 출생년도%12
	//자 축 인 묘 진 사 오 미 신 유 술 해
	
	public String getGanji() {
		
		char gan=' ';
		char ji =' ';
		
		
		
		
		//방법1) switch
		//10간구하기
		/*
		switch(this.getYear()%10) 
		{
			case 0: gan ='경'; break;
			case 1: gan ='신'; break;
			case 2: gan ='임'; break;
			case 3: gan ='계'; break;
			case 4: gan ='갑'; break;
			case 5: gan ='을'; break;
			case 6: gan ='병'; break;
			case 7: gan ='정'; break;
			case 8: gan ='무'; break;
			case 9: gan ='기'; break;
		}
		
		//12지구하기
		switch(this.getYear()%12) 
		{
			case 0:  ji='신'; break;
			case 1:  ji='유'; break;
			case 2:  ji='술'; break;
			case 3:  ji='해'; break;
			case 4:  ji='자'; break;
			case 5:  ji='축'; break;
			case 6:  ji='인'; break;
			case 7:  ji='묘'; break;
			case 8:  ji='진'; break;
			case 9:  ji='사'; break;
			case 10: ji='오'; break;
			case 11: ji='미'; break;
		}
		*/
		
		//방법2) String.charAt(index) 기능 
		//String 기능 
		//				   0 1 2 3 4 5 6 7 8 9 		<-출생년도%10
		String gan_list = "경신임계갑을병정무기";
		//				  0 1 2 3 4 5 6 7 8 9 10 11 <-출생년도%12
		String ji_list 	="신유술해자축인묘진사오미";
		
		gan = gan_list.charAt(this.getYear()%10);
		ji 	= ji_list.charAt(this.getYear()%12);
		
		
		
		return String.format("%c%c년", gan,ji);
	}//end-getGanji
	
	
	//			01234567890123  <-index
	//jumin_no "801212-1234560";
	//			234567 892345   <-check_sum
	
	
	//주민번호 유효성
	//is로 시작하는 method는 참거짓을 확인하는 거다.
	public boolean isValid() {
		
		int sum = 0;
		
		//방법1) 직관적으로
		/*
		sum = sum + (jumin_no.charAt(0)  - '0') * 2;
		sum = sum + (jumin_no.charAt(1)  - '0') * 3;
		sum = sum + (jumin_no.charAt(2)  - '0') * 4;
		sum = sum + (jumin_no.charAt(3)  - '0') * 5;
		sum = sum + (jumin_no.charAt(4)  - '0') * 6;
		sum = sum + (jumin_no.charAt(5)  - '0') * 7;
		sum = sum + (jumin_no.charAt(7)  - '0') * 8;
		sum = sum + (jumin_no.charAt(8)  - '0') * 9;
		sum = sum + (jumin_no.charAt(9)  - '0') * 2;
		sum = sum + (jumin_no.charAt(10) - '0') * 3;
		sum = sum + (jumin_no.charAt(11) - '0') * 4;
		sum = sum + (jumin_no.charAt(12) - '0') * 5;
		*/

		
		//방법2) for문
	     /*		
			int check_su = 2;
			for(int i=0;i<=12;i++) { // i = 0 1 2 3 ... 12
				if(i==6) continue;
				
				sum = sum +  (jumin_no.charAt(i) -'0') * check_su  ;
				check_su++;
				if(check_su>9) check_su=2;
			}
		*/
		
		//방법3) for문 + check_su 배열
		//                    0 1 2 3 4 5 6 7 8 9 0 1 2
		int [] check_array = {2,3,4,5,6,7,0,8,9,2,3,4,5};
		for(int i=0; i<=12 ; i++) {
			sum= sum+(jumin_no.charAt(i)-'0')*check_array[i];
		}
		
		
		
		
		
		//내가 한거
		/*
		for (int i=0, j=2; i<=12; i++, j++) {
			
			if(i==6) {
				j=7;
				continue;
			}
					
			if(j>9) j=2;
			
			sum += (jumin_no.charAt(i)-'0')*j; 
			System.out.println((jumin_no.charAt(i)-'0')*j);
			
		}*/	
		
		
		
		
		
		//System.out.println(sum);
		//알고리즘 공식이다. 왜인지는 .... 계산해보자
		sum = sum%11;
		sum = 11-sum;
		sum = sum%10; // 0 ~ 9사이 
		
		
		
		System.out.println(sum);
		
		//주민번호의 마지막 숫자
		int last_no = jumin_no.charAt(13)-'0';
		
		
		
		
		return (sum==last_no);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
