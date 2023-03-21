package myutil;

import java.util.HashMap;
import java.util.Map;

public class Bmi {
				//    키		무게
	private String height_no, weight_no;

	
	public Bmi() {
		// TODO Auto-generated constructor stub
	}
	
	public Bmi(String height_no, String weight_no) {
		super();
		this.height_no = height_no;
		this.weight_no = weight_no;
	}
	
	public void setHeight_no(String height_no) {
		this.height_no = height_no;
	}

	public void setWeight_no(String weight_no) {
		this.weight_no = weight_no;
	}

	
	
	public Map<String, Object> getBmi() {
		Map<String,Object> map = new HashMap<String, Object>();
		//double height_no = Double.parseDouble(height_no);
		double h = Double.parseDouble(height_no);
		double w = Double.parseDouble(weight_no);
		
		double bmi = 18.5;
		
		String b_state ="";
		
		
		
		bmi = w/((h/100) * (h/100));
		bmi = (Math.round(bmi *100) /100.0) ;
		
		String bmi_str = Double.toString(bmi);
		
		
		if (bmi<18.5) b_state="저체중";
		else if (bmi>=18.5 && bmi<23) b_state="정상"; 
		else if (bmi>=23 && bmi<25) b_state="과체중"; 
		else if (bmi>=25) b_state="비만"; 
		
		
		map.put("bmi_str", bmi_str);
		map.put("b_state", b_state);
		
		
		
		
		return map;
	}
	
}
