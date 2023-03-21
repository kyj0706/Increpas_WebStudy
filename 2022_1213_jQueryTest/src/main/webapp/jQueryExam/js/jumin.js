
class Jumin{
	
	constructor(jumin_no=''){
		this._jumin_no = jumin_no;
	}
	
	set jumin_no(value){
		this._jumin_no = value;
	}
	
	get jumin_no(){
		return this._jumin_no;
	}
	
	//              01234567890123  <- index   
	// _jumin_no = "801212-1234560"
	
	/*
	              내국인    외국인  
	              남  여    남  여
	     1800     9   0 
	     1900     1   2     5   6
	     2000     3   4     7   8
	     
	*/
	
	getYear(){
		
		let  year   = parseInt(this._jumin_no.substring(0,2));//문자열 slice
		let  gender = parseInt(this._jumin_no.charAt(7));     //문자열1개 slice
		
		switch(gender)
		{
			case 1: case 2: case 5: case 6: year += 1900; break;
			case 3: case 4: case 7: case 8: year += 2000; break;
			default: year += 1800;
		}
		
		return year;
	}
	
	getAge(){
		//나이 = 현재년도 - 출생년도
		let now = new Date();
		let year = now.getFullYear();
		
		
		return year - this.getYear();
	}
	
	getTti(){
		
		let  year   = parseInt(this._jumin_no.substring(0,2));//문자열 slice
		let  gender = parseInt(this._jumin_no.charAt(7));     //문자열1개 slice
		
		switch(gender)
		{
			case 1: case 2: case 5: case 6: year += 1900; break;
			case 3: case 4: case 7: case 8: year += 2000; break;
			default: year += 1800;
		}
		
		let tti = year%12;
		
		
		switch(tti)
		{
			case 0: tti="원숭이"; 	break; 
			case 1: tti="닭"; 		break; 
			case 2: tti="개"; 		break; 
			case 3: tti="돼지"; 	break; 
			case 4: tti="쥐"; 		break; 
			case 5: tti="소"; 		break; 
			case 6: tti="호랑이"; 	break; 
			case 7: tti="토끼"; 	break; 
			case 8: tti="용"; 		break; 
			case 9: tti="뱀"; 		break; 
			case 10: tti="말"; 		break; 
			case 11: tti="양"; 		break; 
		}
		
		
		return tti;
	}
	
	getTti_t(){
		
		const tti_array=['원숭이','닭','개','돼지','쥐','소','호랑이','토끼','용','뱀','말','양'];
		
		
		return tti_array[this.getYear()%12];
	}
	
	
	
	
	getGanji(){
		let  year   = parseInt(this._jumin_no.substring(0,2));//문자열 slice
		let  gender = parseInt(this._jumin_no.charAt(7));     //문자열1개 slice
		
		switch(gender)
		{
			case 1: case 2: case 5: case 6: year += 1900; break;
			case 3: case 4: case 7: case 8: year += 2000; break;
			default: year += 1800;
		}
		
		var ganji = year%10;
		
		switch(ganji)
		{
			case 0: ganji="경"; 	break; 
			case 1: ganji="신"; 	break; 
			case 2: ganji="임"; 	break; 
			case 3: ganji="계"; 	break; 
			case 4: ganji="갑"; 	break; 
			case 5: ganji="을"; 	break; 
			case 6: ganji="병"; 	break; 
			case 7: ganji="정"; 	break; 
			case 8: ganji="무"; 	break; 
			case 9: ganji="기"; 	break; 
		}
		
		
		let tti = year%12;
		
		
		switch(tti)
		{
			case 0: tti="신"; 	break; 
			case 1: tti="유"; 	break; 
			case 2: tti="술"; 	break; 
			case 3: tti="해"; 	break; 
			case 4: tti="자"; 	break; 
			case 5: tti="축"; 	break; 
			case 6: tti="인"; 	break; 
			case 7: tti="묘"; 	break; 
			case 8: tti="진"; 	break; 
			case 9: tti="사"; 	break; 
			case 10: tti="오"; 	break; 
			case 11: tti="미"; 	break; 
		}
		
		
		ganji = (ganji + tti)+"년";
		
	
		
		return ganji;
	}
	
	getGanji_t(){
		
		const gan_list = '경신임계갑을병정무기';
		const ji_list = '신유술해자축인묘진사오미';
		
		let gan	= gan_list.charAt(this.getYear()%10);
		let ji	= ji_list.charAt(this.getYear()%12); 
		
		
		return gan+ji+"년";
	}
	
	
	
	
	getSeason(){
		
		let month = parseInt(this._jumin_no.substring(2,4));
		
		month= Math.floor(month/3);
		
		let season = "겨울";
		
		
		switch(month)
		{
			case 1: season ="봄"; break;
			case 2: season ="여름"; break;
			case 3: season ="가을"; break;
			
			
		}
		
		
		
		return season;
	}
	
	getGender(){
		let  gender = parseInt(this._jumin_no.charAt(7));     //문자열1개 slice
		
		
		if(gender%2==1){
			gender = "남자"	 
		
		}else{
			gender = "여자"	 
		} 
		
		
		return gender;				
	}
	
	
   
	
}