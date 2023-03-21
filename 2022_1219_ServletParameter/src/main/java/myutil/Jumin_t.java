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
	    �����ڵ��� ��
	  
	               ������       �ܱ���  
	               ��  ��       ��  �� 
	     1900      1   2        5   6         
	     2000      3   4        7   8
	     1800      9   0
	
	*/
	
	//����⵵ ���ϱ�
	public int getYear() {
		
		String str_year = this.jumin_no.substring(0, 2);// "80"
		
		//���ڿ� -> ������ ��ȯ : Integer.parseInt("���ڿ�") ->����
		int year = Integer.parseInt(str_year);// "80" -> 80
		
		//�ֹι�ȣ���� �����ڸ����� ���� 1�� ����
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
	
	
	
	//���� ���ϱ�
	public int getAge() {
		
		int age = 0;
		
		//���� �ý��� ��¥ ���ϱ�
		Calendar c    = Calendar.getInstance();
		int curr_year = c.get(Calendar.YEAR);//�⵵���ϱ�
		
		//���� = ����⵵-����⵵ + 1   <= �ѱ�����
		//           �ڽ��Ǹ޼ҵ� ȣ��
		age = curr_year - this.getYear() + 1;
		
		return age;
		
	}//end-getAge()
	

	//            01234567890123   <- index
	//jumin_no = "801212-1234560";
	
	//�������
	public String getLocal() {
		
		String str_local = jumin_no.substring(8, 8+2); // "23"
		int    local     = Integer.parseInt(str_local);// "23" -> 23
		
		
		if(local>=0 && local<=8) return "����";
		else if(local>=9 && local<=12) return "�λ걤����";
		else if(local>=13 && local<=15) return "��õ������";
		else if(local>=16 && local<=25) return "��⵵";
		else if(local>=26 && local<=34) return "������";
		else if(local>=35 && local<=39) return "��û�ϵ�";
		else if(local==40) return "����";
		else if(local==44 || local==96) return "������"; //41  47 ���̿� �ɸ��� ������ ������ �ٲ����Ѵ�.
		else if(local>=41 && local<=47) return "��û����";
		else if(local>=48 && local<=54) return "����ϵ�";
		else if(local>=55 && local<=64) return "���󳲵�";
		else if(local>=65 && local<=66) return "���ֱ�����";
		else if(local>=67 && local<=69 || local==76) return "�뱸������";
		else if(local>=70 && local<=81) return "���ϵ�";
		else if(local==85) return "���";
		else if(local>=82 && local<=93) return "��󳲵�";
		else if(local>=94 && local<=95) return "���ֵ�";
		
		
		return "����";
	}
	
	
	//�������ϱ�
	public String getSeason() {
		
		String str_month = jumin_no.substring(2, 4);   //"12"
		int    month     = Integer.parseInt(str_month);//"12" -> 12
		
		//���1(if��)
		/*
		if(month>=3 && month <=5) return "��";
		else if(month>=6 && month <=8) return "����";
		else if(month>=9 && month <=11) return "����";
		*/
		
		//���2(switch ��)
		/*
		  switch (month) 
		 
		{
		case 3:case 4:case 5: return "��";
		}
		*/
		
		//���(switch�� ������ ������ )
		
		switch (month/3) 
		{
		case 1: return "��"; 	// 3 4 5   /3->��1
		case 2: return "����"; // 6 7 8   /3->��2
		case 3: return "����"; // 9 10 11 /3->��3
		}
		
		return "�ܿ�";
		
	}//end-getSeason()
	
	//���� ���ϱ�
	public String getGender() {
		
		char gender = this.jumin_no.charAt(7); // '1'

		//���1
		if(gender=='1' || gender=='3' || gender=='5' || gender=='7' || gender=='9')
			return "����";
		
		//���2
		//int gender_num = gender - '0';// ���� : 1
		//if(gender_num%2==1) return "����";
				
		
		return "����";
		
	}//end-getGender()
	
	
	//12��
	// 4  5  6  7  8  9  10 11 0  1  2  3  <- tti_index (����⵵%12)                                        
	// �� �� �� �� �� �� �� �� �� �� �� ��
	// �� �� �� �� �� �� �� �� �� �� �� ��
	// ����⵵%12 -> 0 ~ 11������ ��
	
	
	// �� ���ϱ�
	/*
	public String getTti() {
		
		int tti_index = this.getYear()%12; // 0 ~11 ����
		
		switch(tti_index)
		{
		   //      return ��:ȣ���Ѱ����� ���� ���� ����   
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
		}
		
		return "��";
	}//end-getTti
	*/
	
	
	//221019 �߰� �迭�� ������ϱ�
	public String getTti2() {
		
		String [] Tti_array = {"������","��","��","����","��","��","ȣ����","�䳢","��","��","��","��" };
		
		int tti_index = this.getYear()%12;// 0 ~11 ����
		
		return Tti_array[tti_index] ;
	}
	
	
	//10��
	
	//4  5  6  7  8  9  0  1  2  3    		<= ����⵵%10
	//�� �� �� �� �� �� �� �� �� ��
	
	
	//12��
	//4  5  6  7  8  9  10 11 0  1  2  3	<= ����⵵%12
	//�� �� �� �� �� �� �� �� �� �� �� ��
	
	public String getGanji() {
		
		char gan=' ';
		char ji =' ';
		
		
		
		
		//���1) switch
		//10�����ϱ�
		/*
		switch(this.getYear()%10) 
		{
			case 0: gan ='��'; break;
			case 1: gan ='��'; break;
			case 2: gan ='��'; break;
			case 3: gan ='��'; break;
			case 4: gan ='��'; break;
			case 5: gan ='��'; break;
			case 6: gan ='��'; break;
			case 7: gan ='��'; break;
			case 8: gan ='��'; break;
			case 9: gan ='��'; break;
		}
		
		//12�����ϱ�
		switch(this.getYear()%12) 
		{
			case 0:  ji='��'; break;
			case 1:  ji='��'; break;
			case 2:  ji='��'; break;
			case 3:  ji='��'; break;
			case 4:  ji='��'; break;
			case 5:  ji='��'; break;
			case 6:  ji='��'; break;
			case 7:  ji='��'; break;
			case 8:  ji='��'; break;
			case 9:  ji='��'; break;
			case 10: ji='��'; break;
			case 11: ji='��'; break;
		}
		*/
		
		//���2) String.charAt(index) ��� 
		//String ��� 
		//				   0 1 2 3 4 5 6 7 8 9 		<-����⵵%10
		String gan_list = "����Ӱ谩����������";
		//				  0 1 2 3 4 5 6 7 8 9 10 11 <-����⵵%12
		String ji_list 	="�������������ι��������";
		
		gan = gan_list.charAt(this.getYear()%10);
		ji 	= ji_list.charAt(this.getYear()%12);
		
		
		
		return String.format("%c%c��", gan,ji);
	}//end-getGanji
	
	
	//			01234567890123  <-index
	//jumin_no "801212-1234560";
	//			234567 892345   <-check_sum
	
	
	//�ֹι�ȣ ��ȿ��
	//is�� �����ϴ� method�� �������� Ȯ���ϴ� �Ŵ�.
	public boolean isValid() {
		
		int sum = 0;
		
		//���1) ����������
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

		
		//���2) for��
	     /*		
			int check_su = 2;
			for(int i=0;i<=12;i++) { // i = 0 1 2 3 ... 12
				if(i==6) continue;
				
				sum = sum +  (jumin_no.charAt(i) -'0') * check_su  ;
				check_su++;
				if(check_su>9) check_su=2;
			}
		*/
		
		//���3) for�� + check_su �迭
		//                    0 1 2 3 4 5 6 7 8 9 0 1 2
		int [] check_array = {2,3,4,5,6,7,0,8,9,2,3,4,5};
		for(int i=0; i<=12 ; i++) {
			sum= sum+(jumin_no.charAt(i)-'0')*check_array[i];
		}
		
		
		
		
		
		//���� �Ѱ�
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
		//�˰��� �����̴�. �������� .... ����غ���
		sum = sum%11;
		sum = 11-sum;
		sum = sum%10; // 0 ~ 9���� 
		
		
		
		System.out.println(sum);
		
		//�ֹι�ȣ�� ������ ����
		int last_no = jumin_no.charAt(13)-'0';
		
		
		
		
		return (sum==last_no);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
