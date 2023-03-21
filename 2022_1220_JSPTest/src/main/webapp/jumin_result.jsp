<%@page import="myutil.Jumin"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	
	String jumin_no = request.getParameter("jumin_no");
 	Jumin jumin = new Jumin();
 	
 	jumin.setJumin_no(jumin_no);
 	
	int 	year 	= jumin.getYear();
	String  ganji 	= jumin.getGanji(); 
	int 	age		= jumin.getAge();
	String	gender	= jumin.getGender();
	String  tti		= jumin.getTti2();
	String  season	= jumin.getSeason();
	String 	local 	= jumin.getLocal();
	

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
 #box1{
 	width: 500px;
 	margin: auto;
 	margin-top: 50px;
 	float: left;
 
 }
 #box2{
 	width: 500px;
 	height: 300px;
 	margin-left: 100px;
 	margin-top: 50px;
 	float: left;
 	overflow: auto;
 
 }
 table th{
	text-align: center;
	font-size: 20px;
}
 td {
	text-align: center;
}
 .panel-heading{
 	text-align: center;
 	font-size: 40px;
 	text-shadow: 2px 2px 2px gray;
 	
 }
 	
</style>
<script type="text/javascript">
$(document).ready(function(){
	  $("#myInput").on("keyup", function() {
	    var value = $(this).val().toLowerCase();
	    $("#myTable tr").filter(function() {
	      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
	    });
	  });
	});
	
	
</script>





</head>
<body>
	
	<div id= "box1">
	
		<div class="panel panel-primary">
		<div class="panel-heading" style="background-color: black;" >주민번호 정보</div>
			<div class="panel-body">
				<table class="table table-striped">
						<tr>
							<th>주민번호</th>
							<td><%=jumin_no %></td>		
						</tr>
						<tr>
							<th>출생년도</th>
							<td><%=year %>년 [<%=ganji %>]</td>		
						</tr>
						<tr>
							<th>나이</th>
							<td><%=age %>(살)</td>		
						</tr>
						<tr>
							<th>성별</th>
							<td><%=gender %></td>		
						</tr>
						<tr>
							<th>띠</th>
							<td><%=tti %></td>		
						</tr>
						<tr>
							<th>출생계절</th>
							<td><%=season %></td>		
						</tr>
						<tr>
							<th>출생지역</th>
							<td><%=local %></td>		
						</tr>
						<tr>
							<th colspan="2">
							<a href="jumin.html">
							<button class="btn btn-success">다시하기</button>
							</a>
							</th>
						</tr>
			
				</table>
			
					
			</div>
		</div>		
	</div>
	<div id="box2">
	<div class="form-group has-success has-feedback">
	지역입력 :<input class="from-control" id="myInput" placeholder="검색"></div>
	<div class="panel">			
	
				
				<table class="table table-striped">
					<thead>
						<tr>
							<th>지역</th>
							<th>코드</th>
						</tr>
					</thead>
					<tbody  id="myTable">	
						<tr>
							<th>서울</th>
							<td>0 ~ 8</td>
						</tr>
						<tr>
							<th>부산</th>
							<td>9 ~ 12</td>
						</tr>
						<tr>
							<th>인천</th>
							<td>13 ~ 15</td>
						</tr>
						<tr>
							<th>경기도</th>
							<td>16 ~ 25</td>
						</tr>
						<tr>
							<th>강원도</th>
							<td>16 ~ 25</td>
						</tr>
						<tr>
							<th>충청북도</th>
							<td>16 ~ 25</td>
						</tr>
						<tr>
							<th>대전</th>
							<td>16 ~ 25</td>
						</tr>
						<tr>
							<th>세종시</th>
							<td>16 ~ 25</td>
						</tr>
						<tr>
							<th>충청남도</th>
							<td>16 ~ 25</td>
						</tr>
						<tr>
							<th>전라남도</th>
							<td>16 ~ 25</td>
						</tr>
						<tr>
							<th>광주광역시</th>
							<td>16 ~ 25</td>
						</tr>
						<tr>
							<th>대구광역시</th>
							<td>16 ~ 25</td>
						</tr>
						<tr>
							<th>경기도</th>
							<td>16 ~ 25</td>
						</tr>
						<tr>
							<th>경기도</th>
							<td>16 ~ 25</td>
						</tr>
						<tr>
							<th>경기도</th>
							<td>16 ~ 25</td>
						</tr>
						
						
					</tbody>
				</table>
		</div>
	</div>
</body>
</html>