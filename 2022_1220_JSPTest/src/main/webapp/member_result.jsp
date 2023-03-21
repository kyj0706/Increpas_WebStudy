<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String name 	= request.getParameter("name");
	String id 		= request.getParameter("id");
	String pwd		= request.getParameter("pwd");
	String gender 	= request.getParameter("gender");
	String blood	= request.getParameter("blood");
	String profile  = request.getParameter("profile");
	
	String [] hobby_arr  = request.getParameterValues("hobby");
	String hobby_list = "취미가 없다.";
	
	StringBuffer sb1 = new StringBuffer();
	
	if(hobby_arr != null){
		//개선 ....
		for(String hobby : hobby_arr){
			sb1.append(hobby);
			sb1.append(" ");
		}
		hobby_list = sb1.toString().trim();
	}
	
	String [] friend_arr = request.getParameterValues("friend");
	String friend_list = "";
	
	StringBuffer sb2 = new StringBuffer();
	
	for(String friend : friend_arr){
		sb2.append(friend);
		sb2.append(" ");
	}
	
	friend_list = sb2.toString().trim();
	
	if(friend_list.isEmpty()) friend_list="친구가 없다.";
	


%>    
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	 table {
    width: 400px;
    border: 1px solid black;
    border-collapse: collapse;
  }
  th, td {
    border: 1px solid black;
  }
	
</style>
</head>
<body>
	<table>
		<tr>
			<th>이름</th>
			<td><%=name %></td>
		</tr>
		<tr>
			<th>아이디</th>
			<td><%=id %></td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><%=pwd %></td>
		</tr>
		<tr>
			<th>성별</th>
			<td><%=gender %></td>
		</tr>
		<tr>
			<th>혈액형</th>
			<td><%=blood %></td>
		</tr>
		<tr>
			<th>취미</th>
			<td><%=hobby_list %></td>
		</tr>
		<tr>
			<th>친구</th>
			<td><%=friend_list %></td>
		</tr>
		<tr>
			<th>자기소개</th>
			<td><%=profile %></td>
		</tr>
		<tr>
			<th colspan="2"><a href="member.html">다시하기</a></th>
		</tr>
	
	
	</table>


</body>
</html>