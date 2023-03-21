<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%



%>    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>


<style type="text/css">
 #box{
 	width: 500px;
 	margin: auto;
 	margin-top: 50px;
 }
 table th{
	text-align: center;
	font-size: px;
}
 td {
	text-align: center;
}
 .panel-heading{
 	text-align: center;
 	font-size: 30px;
 	text-shadow: 2px 2px 2px gray;
 	
 }
 input{
 	width: 60px;
 
 }
 #btn{
 	margin-left: 30px;
 }
 
  li{
 	list-style: none;
 	
 	 
 }

	

 .la_1{
 	margin-left: 50px;
 
 }
 
 .la_2{
 	margin-left: 70px; 
 	margin-right: 90px;
 }


</style>

<script type="text/javascript">

	function sand(f) {
		
		var how_height = f.how_height.value;
		var how_weight = f.how_weight.value;
		
		alert(how_height);
		alert(how_weight);
		
		$("#bntclac").click(function(){
			
			if(how_height == ""){
				alert("신장 입력");
				f.how_height.value ="";
				return this.send(f);
			}
			
			
			
			
			
			
			
			/* if($("#how_height").val()==""){
				alert("신장을 입력해주세요");
				return false;
			}
			
			if($("#how_weight").val()==""){
				alert("체중을 입력해주세요");
				return false;
			} */
			
			
		});
		
		$("#reset").click(function () {
			$("#bi_result").text("");
			$("#bmi_result").text("");
		});
		
		
		
		f.submit();
		
	}



</script>


</head>
<body>

<form name="f" action="bmi_register.do" method="get">
	<div id="box">
		<div class="panel panel-default">
			<div class="panel-heading">:::나의 체질량지수(BMI):::</div>
			<div class="panel-body">
				<table class="table table-striped">
					<tr>
						<th>이름</th>
						<th>나이</th>
					</tr>
				</table>
				<div class="form-group">
				
					<label for="how_height">신장 : </label> 
						<input type="text" name="how_height" id="how_height" value="" placeholder="입력">
					<span>cm</span> 
					<span> / </span>
					<label for="how_weight">체중 :</label> 
						<input type="text" name="how_weight" id="how_weight" value="" placeholder="입력"> 						
					<span>kg </span>
					<span id="btn">
						<input type="button" id="bntclac" value="계산" onclick="sand(this.form);">
						<input type="reset" value="초기화">
					</span>
				</div>
				<hr>
				<div>
					<dl>
						<dt>비만도 결과</dt>
						<dd id="bi_result"> ${b_state }</dd>
						<dt>BMI지수	:</dt>
						<dd id="bmi_result">${ bmi_str }</dd>
					
					
					</dl>
				</div>
				<hr>
				
				
				<ul>
					<li class="list-group">
						<label>BMI</label>
						<label class="la_1">18.5</label>
						<label class="la_2">23</label>
						<label>25.00</label>
						<div class="progress">
						
							<div class="progress-bar progress-bar-info" role="progressbar" style="width: 18.5%;">
								저체중
							</div>
							<div class="progress-bar progress-bar-success" role="progressbar" style="width:  23%;">
		   						정상
						 	</div> 
							<div class="progress-bar progress-bar-warning" role="progressbar" style="width:  25%;">
		   						과체중
						 	</div> 
							<div class="progress-bar progress-bar-danger" role="progressbar" style="width:  33.5%;">
		   						비만
						 	</div> 
							
						</div>
						<label>체중</label>
					</li>
				
				
				
				</ul>
				
				
			</div>
		</div>
	</div>
	
	
	
	
	
</form>

</body>
</html>