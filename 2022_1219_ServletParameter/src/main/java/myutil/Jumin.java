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
	 	�����ڵ��� ��
	 	
	 			������			�ܱ���
	 			��  ��			��  ��
	 	1900	1	2			5	6	
	 	2000	3	4			7	8
	 	1800	9	0
	 */
	
	//����⵵ ���ϱ�
	public int getYear() {
		
		String str_year =this.jumin_no.substring(0, 2);//"80"
		
		//���ڿ��� -> ������ ��ȯ : Integer.parsInt('���ڿ�') -> ������ ��ȯ 
		int year = Integer.parseInt(str_year);// "80" -> 80���� �ȴ�.
		
		//�ֹι�ȣ���� �����ڸ����� ���� 1�� ����
		char gender = jumin_no.charAt(7);// '1'
		
		//�⵵ ���ϱ� switch
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
	
	//���̱��ϱ�
	public int getAge() {
		
		int age =0;
		int cyear;//calendar  ����
		
		//����⵵ ���
		Calendar c = Calendar.getInstance();
		cyear =c.get(Calendar.YEAR);
		
		//���� = ����⵵ - ����⵵ +1 <=�ѱ�����
		
		age= cyear - this.getYear() +1;
		
		
		
		return age;
	}//getAge_end
	
	//12�� ���ϱ�
	//4	 5  6  7  8  9  10  11  0  1  2  3 <-tit_index(����⵵%12)
	//�� �� �� �� �� ��	��  ��  �� �� �� ��
	//�� �� �� �� �� ��	��	��	�� �� �� ��
	//����⵵%12 -> 0 ~ 11�����ǰ�
	public String getTti() {
		int tti_index = this.getYear()%12;
		
		switch (tti_index) {
		case 0:return "������";
		case 1:return "��";
		case 2:return "��";
		case 3:return "����";
		case 4:return "��";
		case 5:return "��";
		case 6:return "ȣ����";
		case 7:return "�䳢";
		case 8:return "��";
		case 9:return "��";
		case 10:return "��";
		case 11:return "��";
		}
		return "��";
	}//Tti_end
	
	//�������ϱ�
	public String getGender() {
		
		String str_gender= this.jumin_no.substring(7,8);
		int gender_num =Integer.parseInt(str_gender);
		
		switch(gender_num) {
		case 1:case 5: case 3: case 7: case 9:
			return "����";
			
		case 2:case 4:case 6: case 8: case 0:
			return "����";
		}//switch_end
		
		return str_gender ;
	}
	//�������ϱ�
	public String getLocal() {
		
		//���� ���
		String str_local= this.jumin_no.substring(8,10);
		int local = Integer.parseInt(str_local);
		
		//����⵵ �Ÿ��� 2020.10 ���� ���� ���� 
		//String year_de = this.jumin_no.substring(0, 2);
		//int del_year = Integer.parseInt(year_de);
			
		
	
			
			if(local>=0 && local<=8) {
				return "����";
			}else if (local>=9 && local<=12) {
				return "�λ�";
				
			}else if (local>=97 && local<=99) {
				return "���������Դϴ�";
			}
			
		
			
		
		
			
			
			
		
		
		
	
		
//		if(local>=0 && local<=8) return "����Ư����";
//		if(local>=9 && local<=12) return "�λ걤����";
//		if(local>=13 && local<=15) return "��õ������";
//		if(local>=16 && local<=25) return "��⵵";
//		if(local>=26 && local<=34) return "������";
//		if(local>=35 && local<=39) return "��û�ϵ�";
//		if(local>=40 && local<=41) return "����������";
//		if(local>=42 && local<=43) return "��û����";
//		if(local>=45 && local<=47) return "��û����";
//		if(local>=48 && local<=54) return "����ϵ�";
//		if(local>=55 && local<=65) return "���󳲵�";

	
		return "�Է����ּ���";
	}
	

	
	//���� ���ϱ�
	public String Season() {
		
		String str_month =this.jumin_no.substring(2, 4);
		int month =Integer.parseInt(str_month);
		switch (month) {
		case 3:case 4:case 5:
			return "��";
		case 6:case 7:case 8:
			return "����";
		case 9:case 10:case 11:
			return "����";
		case 12:case 1:case 2:
			return "�ܿ�";
			
		}
		
		
		return "�ܿ�";
	}//season_end
	
	
	
	//���� ����
	//õ�� : ��, ��, ��, ��, ��, ��, ��, ��, ��, �踦 ���ڸ� ���� 4���� �����ϰ�, 10�� �ֱ� ����
	//���� : ��, ��, ��, ��, ��, ��, ��, ��, ��, ��, ��, �ظ� ���� 12�� ���� �������� 4���� ����, 12�� �ֱ� ����
	
	
	
	//�������ϱ�
	public String getGanji() {
		
		String str_ganji = this.jumin_no.substring(0, 3);
		
		
		
		return "dd";
	}
	

	

	
}
