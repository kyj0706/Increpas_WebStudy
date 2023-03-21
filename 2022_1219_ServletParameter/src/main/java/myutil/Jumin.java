package myutil;

import java.util.Calendar;

public class Jumin {
	
	
	private String jumin_no;

	
	//setter 
	public void setJumin_no(String jumin_no) {
		this.jumin_no = jumin_no;
	}
	
	//index 	  01234567890123 <- index
	//jomin_no = "801212-1234560;
	
	/*
	 	성별코드의 값
	 	
	 			내국인			외국인
	 			남  여			남  여
	 	1900	1	2			5	6	
	 	2000	3	4			7	8
	 	1800	9	0
	 */
	
	//출생년도 구하기
	public int getYear() {
		
		String str_year =this.jumin_no.substring(0, 2);//"80"
		
		//문자열을 -> 정수로 변환 : Integer.parsInt('문자열') -> 정수로 변환 
		int year = Integer.parseInt(str_year);// "80" -> 80으로 된다.
		
		//주민번호에서 성별자리수의 문자 1개 추출
		char gender = jumin_no.charAt(7);// '1'
		
		//년도 구하기 switch
		switch(gender)
		{
			case '1': case '2': case '5': case '6': 
				year = year + 1900; 
				break;
			case '3': case '4': case '7': case '8': 
				year = year + 2000; 
				break;
			case '9':case '0': 
				year = year + 1800; 
			
		}//switch_end
		
		return year;
	}//getyear_end
	
	//나이구하기
	public int getAge() {
		
		int age =0;
		int cyear;//calendar  변수
		
		//현재년도 출력
		Calendar c = Calendar.getInstance();
		cyear =c.get(Calendar.YEAR);
		
		//나이 = 현재년도 - 출생년도 +1 <=한국나이
		
		age= cyear - this.getYear() +1;
		
		
		
		return age;
	}//getAge_end
	
	//12지 구하기
	//4	 5  6  7  8  9  10  11  0  1  2  3 <-tit_index(출생년도%12)
	//자 축 인 묘 진 사	오  미  신 유 술 해
	//쥐 소 범 토 용 뱀	말	양	원 닭 개 돼
	//출생년도%12 -> 0 ~ 11사이의값
	public String getTti() {
		int tti_index = this.getYear()%12;
		
		switch (tti_index) {
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
		case 11:return "양";
		}
		return "양";
	}//Tti_end
	
	//성별구하기
	public String getGender() {
		
		String str_gender= this.jumin_no.substring(7,8);
		int gender_num =Integer.parseInt(str_gender);
		
		switch(gender_num) {
		case 1:case 5: case 3: case 7: case 9:
			return "남자";
			
		case 2:case 4:case 6: case 8: case 0:
			return "여자";
		}//switch_end
		
		return str_gender ;
	}
	//지역구하기
	public String getLocal() {
		
		//지역 출력
		String str_local= this.jumin_no.substring(8,10);
		int local = Integer.parseInt(str_local);
		
		//출생년도 거르기 2020.10 이후 지역 없음 
		//String year_de = this.jumin_no.substring(0, 2);
		//int del_year = Integer.parseInt(year_de);
			
		
	
			
			if(local>=0 && local<=8) {
				return "서울";
			}else if (local>=9 && local<=12) {
				return "부산";
				
			}else if (local>=97 && local<=99) {
				return "없는지역입니다";
			}
			
		
			
		
		
			
			
			
		
		
		
	
		
//		if(local>=0 && local<=8) return "서울특별시";
//		if(local>=9 && local<=12) return "부산광역시";
//		if(local>=13 && local<=15) return "인천광역시";
//		if(local>=16 && local<=25) return "경기도";
//		if(local>=26 && local<=34) return "강원도";
//		if(local>=35 && local<=39) return "충청북도";
//		if(local>=40 && local<=41) return "대전광역시";
//		if(local>=42 && local<=43) return "충청남도";
//		if(local>=45 && local<=47) return "충청남도";
//		if(local>=48 && local<=54) return "전라북도";
//		if(local>=55 && local<=65) return "전라남도";

	
		return "입력해주세요";
	}
	

	
	//계절 구하기
	public String Season() {
		
		String str_month =this.jumin_no.substring(2, 4);
		int month =Integer.parseInt(str_month);
		switch (month) {
		case 3:case 4:case 5:
			return "봄";
		case 6:case 7:case 8:
			return "여름";
		case 9:case 10:case 11:
			return "가을";
		case 12:case 1:case 2:
			return "겨울";
			
		}
		
		
		return "겨울";
	}//season_end
	
	
	
	//간지 계산법
	//천간 : 갑, 을, 병, 정, 무, 기, 경, 신, 임, 계를 끝자리 연도 4부터 시작하고, 10년 주기 고정
	//지지 : 자, 축, 인, 묘, 진, 사, 오, 미, 신, 유, 술, 해를 연도 12로 나눈 나머지를 4부터 시작, 12년 주기 고정
	
	
	
	//간지구하기
	public String getGanji() {
		
		String str_ganji = this.jumin_no.substring(0, 3);
		
		
		
		return "dd";
	}
	

	

	
}
