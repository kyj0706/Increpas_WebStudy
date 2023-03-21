

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%!
	//선언부(Java code가 작성되는 부분)
	
	//변수선언 
	int a = 10;


	//메소드선언
	public void sub(){
		
	}


%>

<%
	//Scriptlet -> Java Code를 작성 할수 있는 부분 
	//_jspService()내에 작성이 된다.
	
	int local_a = 10;

%>    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
JSP가 Servlet 이래?
<br>
<table border="1">
   		<caption>::::분기별실적::::</caption>
   		
   		<!-- 1번째줄 -->
   		<tr>
   		   <th rowspan="2">구분</th>
   		   <th colspan="3">1사분기</th>
   		   <th colspan="3">2사분기</th>
   		   <th colspan="3">3사분기</th>
   		   <th colspan="3">4사분기</th>
   		   
   		</tr>
   		<!-- 2번째줄 -->
   		<tr>
   		   <th>1월</th>
   		   <th>2월</th>
   		   <th>3월</th>
   		   
   		   <th>4월</th>
   		   <th>5월</th>
   		   <th>6월</th>
   		   
   		   <th>7월</th>
   		   <th>8월</th>
   		   <th>9월</th>
   		   
   		   <th>10월</th>
   		   <th>11월</th>
   		   <th>12월</th>
   		</tr>
   		<!-- 3번째줄 -->
   		<tr>
   		   <th>강남</th>
   		   <th>1</th>
   		   <th>2</th>
   		   <th>3</th>
   		   
   		   <th>1</th>
   		   <th>2</th>
   		   <th>3</th>
   		   
   		   <th>1</th>
   		   <th>2</th>
   		   <th>3</th>
   		   
   		   <th>1</th>
   		   <th>2</th>
   		   <th>3</th>
   		</tr>
   		<!-- 4번째줄 -->
   		<tr>
   		   <th>강북</th>
   		   <th>4</th>
   		   <th>5</th>
   		   <th>6</th>
   		   
   		   <th>4</th>
   		   <th>5</th>
   		   <th>6</th>
   		   
   		   <th>4</th>
   		   <th>5</th>
   		   <th>6</th>
   		   
   		   <th>4</th>
   		   <th>5</th>
   		   <th>6</th>
   		   
   		</tr>
   		<!-- 5번째줄 -->
   		<tr>
   		   <th>관악</th>
   		   <th>7</th>
   		   <th>8</th>
   		   <th>9</th>
   		   
   		   <th>7</th>
   		   <th>8</th>
   		   <th>9</th>
   		   
   		   <th>7</th>
   		   <th>8</th>
   		   <th>9</th>
   		   
   		   <th>7</th>
   		   <th>8</th>
   		   <th>9</th>
   		   
   		</tr>
   		
   		
   		
   </table>


</body>
</html>