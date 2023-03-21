  //맴버 수정 스크립트
   
    function sample6_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var addr = ''; // 주소 변수
                var extraAddr = ''; // 참고항목 변수

                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    addr = data.roadAddress;
                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    addr = data.jibunAddress;
                }

                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
                if(data.userSelectedType === 'R'){
                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있고, 공동주택일 경우 추가한다.
                    if(data.buildingName !== '' && data.apartment === 'Y'){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                    if(extraAddr !== ''){
                        extraAddr = ' (' + extraAddr + ')';
                    }
                    // 조합된 참고항목을 해당 필드에 넣는다.
                    document.getElementById("sample6_address").value = addr + extraAddr;
                
                } else {
                    document.getElementById("sample6_address").value = addr;
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('sample6_postcode').value = data.zonecode;
                // 커서를 상세주소 필드로 이동한다.
                document.getElementById("sample6_detailAddress").focus();
            }
        }).open();
    }
    
    //달력 스크립트
    $(document).ready(function(){            
        var now = new Date();
        var year = now.getFullYear();
        var mon = (now.getMonth() + 1) > 9 ? ''+(now.getMonth() + 1) : '0'+(now.getMonth() + 1); 
        var day = (now.getDate()) > 9 ? ''+(now.getDate()) : '0'+(now.getDate());           
        //년도 selectbox만들기               
        for(var i = 2021 ; i >= 1950 ; i--) {
            $('.year').append('<option value="' + i + '">' + i + '년</option>');    
        }

        // 월별 selectbox 만들기            
        for(var i=1; i <= 12; i++) {
            var mm = i > 9 ? i : "0"+i ;            
            $('.month').append('<option value="' + mm + '">' + mm + '월</option>');    
        }
        
        // 일별 selectbox 만들기
        for(var i=1; i <= 31; i++) {
            var dd = i > 9 ? i : "0"+i ;            
            $('.day').append('<option value="' + dd + '">' + dd+ '일</option>');    
        }
        $("#year  > option[value="+year+"]").attr("selected", "true");        
        $("#month  > option[value="+mon+"]").attr("selected", "true");    
        $("#day  > option[value="+day+"]").attr("selected", "true");       
    })
    
  
    
    $(function(){
	
	$(".mem_check").click(function(){
		document.mem_check.submit();
		})
	
	})
	
		//이메일 인증번호 받아오기
	$(function(){
		$("#email_btn").click(function(){
			$("#email").val()
			alert($("#email").val())
			 $.ajax({
				url:"emailcheck",
				type:"post",
				data:{
					"email":$("#email").val()
				},
				success:function(data){//sb.string  pwEmail
					var html = "";
					alert("인증번호를 전송했습니다")
					html='<input type="hidden" value="'+data.pwEmail+'" id="email_pw" readonly="readonly">'
					$("#email_div").prepend(html)
				},
				error:function(){
					alert("에러")
				}
			})
		})
	})
	
	//인증하기
	$(function(){
			$("#email_btn2").click(function(){
				
			
				 $.ajax({
						url:"/member/emailCheck",
						type:"post",
						data:{
							"email_pw":$("#email_pw").val(),
							"email_num":$("#email_num").val(),
							"m_email":$("#email").val(),
							"m_id":$("#m_id").val()
						},
						success:function(data){//sb.string
			
							alert("성공")
						if(data.result == '1'){
						$("#email_check").val(data.check1)
						}else{
						$("#email_check").val(data.check1)	
						}
						},
						error:function(){
							alert("에러")
						}
					});
			})
		})
	
    