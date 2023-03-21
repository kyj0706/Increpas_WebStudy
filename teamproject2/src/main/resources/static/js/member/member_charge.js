function charge(){
		
		var point =$("th input:checked").val();
		var point1 =$("input:checked").next().html();
		
  		var check = confirm("["+point1+"] 원을 결제 합니다");
  		
		if(check == false){
			alert("결제를 취소 하셨습니다");
			return false;
		}else{
			alert("결제 되었습니다");
			alert("["+point+"] p가 충전 되었습니다");
		}	
		
  	}