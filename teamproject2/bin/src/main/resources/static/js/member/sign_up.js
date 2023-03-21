


$(function(){
	
	//회원 가입 유효성 검사
	$("#id").focusout(function(){
		
		
		if($("#id").val().length < 6){
			$("#id_check").html("아이디 6글자 이상입력해주세요").css("color","red").css("font-weight","bolder")
		}else{
			$("#id_check").html("").css()
		}
	})
	
	$("#pw").focusout(function(){
		if($("#pw").val().length < 7){
			$("#pw_check").html("비밀번호 7글자 이상입력해주세요").css("color","red").css("font-weight","bolder")
 		}else{
			$("#pw_check").html("").css()
		}
	})
	
	
	
	$("#pw1").focusout(function(){
		if($("#pw").val() != $("#pw1").val()){
			$("#pw_check1").html("비밀번호가 일치하지 않습니다").css("color","red").css("font-weight","bolder")
		}else{
			$("#pw_check1").html("일치합니다").css("color","black").css("font-weight","bolder")
		}
	})
	
        		
//아이디 중복 검사----------------------------------------

      			$("#id_chk_btn").click(function(){
        			if($("#id").val().length < 6){
						$("#id_check").html("아이디 6글자 이상입력해주세요").css("color","red")
					}else{
		        			$.ajax({
		        				url:"/id_check",
		        				type:"post",
								data:{
									"id_check":$("#id").val()
								},  
								success:function(data){
									if(data.check == 0){
										alert("중복되는 아이디가 있습니다")
										$("#id").val("").focus();
										//아이디 중복값 확인 여부
										$("#id_check_value").val("0");
									}else{
										alert("사용할수 있습니다")
										$("#id").val(data.m_id);
										$("#pw").focus();
										$("#id_check_value").val("1");
										
									}
								},
								error:function(){
									alert("실패")				
								}
		        			})
	        			}
        			
        		})
        		
//----------------------------------------------------------

//이메일 인증번호 받아오기---------------------------------------------------
		  $(function(){
        		$("#email_chk_btn").click(function(){
        			$("#email").val()
        			 $.ajax({
        				url:"emailcheck",
        				type:"post",
        				data:{
        					"email":$("#email").val()
        				},
        				success:function(data){//sb.string  pwEmail
        					alert("인증번호를 전송했습니다")
        					var html = "";
        					html +='<input type="text" id="email_num" placeholder="인증번호">';
        					html +='<button type="button" id="email_btn2" onclick="email_chek()">인증하기</button>';
        					html += "<hr>";
        					html +='<input type="hidden" value="'+data.pwEmail+'" id="email_pw" readonly="readonly">';
        					
        					
        					$("#email_check").prepend(html)
        					
        				},
        				error:function(){
        					alert("에러")
        				}
        			})
        		})
        	})
//----------------------------------------------------------------------
       })     
//인증하기-----------------------------------------------------------------

 			function email_chek(){
				var html = "";
				var email_pw = $("#email_pw").val();
				var email_num = $("#email_num").val();
				if(email_pw == email_num){
					
					html = '<span id="email_chk_success" >인증번호가 일치합니다</sapn>';
					html +='  <input type="hidden" id="email_check_value" value="1" readonly="readonly">';
				}else{
					html = '<span id="email_chk_fail">인증번호가 일치하지 않습니다</sapn>'
					html +='  <input type="hidden" id="email_check_value" value="0" readonly="readonly">';
				}
				
				$("#email_check_btn").html(html)
				
			}
	

//------------------------------------------------------------------------		
        		
//회원가입 버튼 --------------------------------------------------------------

	function jbSubmit(){
		var id_check = $("#id_check_value").val(); //아이디값
		var pw_check = $("#pw").val(); //비밀번호 값
		var pw1_check = $("#pw1").val(); //비밀번호 재입력 값
		var name_check = $("#name").val(); //이름 값
		var nick_check = $("#nick").val(); //이름 값
		var email_check = $("#email_check_value").val(); //이메일 인증 확인 값
		
		if(id_check == '0'){
			alert("아이디 중복검사를 해주세요")
			return false;
		}else if(pw_check.length < 7){
			alert("비밀번호를 7글자 이상입력해주세요")
			return false;
		}else if(pw_check != pw1_check ){
			alert("비밀번호가 일치하지 않습니다")
			return false;
		}else if(name_check == "" ){
			alert("이름을 입력해주세요")
			return false;
		}else if(nick_check == "" ){
			alert("닉네임을 입력해주세요")
			return false;
		}else if(nick_check == "" ){
			alert("닉네임을 입력해주세요")
			return false;
		}else if(email_check == "0" ){
			alert("이메일 인증해주세요")
			return false;
		}else{
			alert("회원가입에 성공하셨습니다")
			return true;
		}
		
	}
		

//----------------------------------------------------------------------------------------------------------------
//시설관리자 회원가입-----------------------------------------------------------------------------------------

//시설관리자 유효성 검사
		$(function(){
	
				$("#fm_id").focusout(function(){
					
					
					if($("#fm_id").val().length < 6){
						$("#fm_id_check").html("아이디 6글자 이상입력해주세요").css("color","red").css("font-weight","bolder")
					}else{
						$("#fm_id_check").html("").css()
					}
				})
				
				$("#fm_pw").focusout(function(){
					if($("#fm_pw").val().length < 7){
						$("#fm_pw_check").html("비밀번호 7글자 이상입력해주세요").css("color","red").css("font-weight","bolder")
			 		}else{
						$("#fm_pw_check").html("").css()
					}
				})
				
				
				
				$("#fm_pw1").focusout(function(){
					if($("#fm_pw").val() != $("#fm_pw1").val()){
						$("#fm_pw_check1").html("비밀번호가 일치하지 않습니다").css("color","red").css("font-weight","bolder")
					}else{
						$("#fm_pw_check1").html("일치합니다").css("color","black").css("font-weight","bolder")
					}
				})
		})
	
		
		
//시설관리자 아이디 중복 검사
			$(function(){
			     $("#fm_id_chk_btn").click(function(){
        			if($("#fm_id").val().length < 6){
						$("#fm_id_check").html("아이디 6글자 이상입력해주세요").css("color","red")
					}else{
		        			$.ajax({
		        				url:"/fm_id_check",
		        				type:"post",
								data:{
									"fm_id":$("#fm_id").val()
								},  
								success:function(data){
									if(data.check == 0){
										alert("중복되는 아이디가 있습니다")
										$("#fm_id").val("").focus();
										//아이디 중복값 확인 여부
										$("#fm_id_check_value").val("0");
									}else{
										alert("사용할수 있습니다")
										$("#fm_id").val(data.fm_id);
										$("#fm_pw").focus();
										$("#fm_id_check_value").val("1");
										
									}
								},
								error:function(){
									alert("실패")				
								}
		        			})
	        			}
    	    		})
				})
		
//----------------------------------------------------------------------------------
//이메일 인증 --------------------------------------------------------------------------
		  $(function(){
        		$("#fm_email_chk_btn").click(function(){
					alert("인증번호를 전송합니다")
        			$("#ins_email").val()
        			 $.ajax({
        				url:"emailcheck",
        				type:"post",
        				data:{
        					"email":$("#ins_email").val()
        				},
        				success:function(data){//sb.string  pwEmail
        					alert("인증번호를 전송했습니다")
        					var html = "";
        					html +='<input type="text" id="fm_email_num" placeholder="인증번호">';
        					html +='<button type="button" id="fm_email_btn2" onclick="fm_email_chek()">인증하기</button>';
        					html += "<hr>";
        					html +='<input type="hidden" value="'+data.pwEmail+'" id="fm_email_pw" readonly="readonly">';
        					
        					
        					$("#fm_email_check").prepend(html)
        					
        				},
        				error:function(){
        					alert("에러")
        				}
        			})
        		})
        	})
//-------------------------------------------------------------------------------------------
//인증하기-----------------------------------------------------------------

 			function fm_email_chek(){
				var html = "";
				var email_pw = $("#fm_email_pw").val();
				var email_num = $("#fm_email_num").val();
				if(email_pw == email_num){
					
					html = '<span id="fm_email_chk_success" >인증번호가 일치합니다</sapn>';
					html +='  <input type="hidden" id="fm_email_check_value" value="1" readonly="readonly">';
				}else{
					html = '<span id="fm_email_chk_fail">인증번호가 일치하지 않습니다</sapn>'
					html +='  <input type="hidden" id="fm_email_check_value" value="0" readonly="readonly">';
				}
				
				$("#fm_email_check_btn").html(html)
				
			}
	

//------------------------------------------------------------------------	
//회원가입 버튼-------------------------------------------------------------------------

		function jbSubmit1(){
		var id_check = $("#fm_id_check_value").val(); //아이디값
		var pw_check = $("#fm_pw").val(); //비밀번호 값
		var pw1_check = $("#fm_pw1").val(); //비밀번호 재입력 값
		var name_check = $("#ins_name").val(); //시설 이름 값
		var phone_check = $("#ins_phone").val(); //시설 번호 값
		var email_check = $("#fm_email_check_value").val(); //이메일 인증 확인 값
		
		if(id_check == '0'){
			alert("아이디 중복검사를 해주세요")
			return false;
		}else if(pw_check.length < 7){
			alert("비밀번호를 7글자 이상입력해주세요")
			return false;
		}else if(pw_check != pw1_check ){
			alert("비밀번호가 일치하지 않습니다")
			return false;
		}else if(name_check == "" ){
			alert("시설 이름을 입력해주세요")
			return false;
		}else if(phone_check == "" ){
			alert("시설번호를 입력해주세요")
			return false;
		}else if(email_check == "0" ){
			alert("이메일 인증해주세요")
			return false;
		}else{
			alert("회원가입에 성공하셨습니다")
			return true;
		}
		
	}


