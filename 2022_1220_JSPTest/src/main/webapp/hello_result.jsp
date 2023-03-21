<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%
	//Scriptlet
	// /hello_result.jsp?nation=kor
	//JSP내장객체:
		//숨은객체(pageContext,request,session,application,response,out)
	
	String nation = request.getParameter("nation");
	
	//JSP내부에서는 Java template기능이 제한적이다.
	//System.out.println(nation);
	
	if(nation==null) nation = "kor";
		
		String nation_name="";
		String greeting="";
		
		if(nation.equals("kor")) {
			
			nation_name  = "대한민국";
			greeting     = "안녕하세요";
			
		}else if(nation.equals("eng")) {
			
			nation_name  = "미쿡/영국";
			greeting     = "Hi Everyone";
			
		}else if(nation.equals("jpn")) {
			
			nation_name  = "일본";
			greeting     = "오겡끼데스까";
			
		}else if(nation.equals("chn")) {
			
			nation_name  = "중국";
			greeting     = "니하오(마)";
			
		}else if(nation.equals("ger")) {
			
			nation_name  = "독일";
			greeting     = "구텐탁";
			
		}else if(nation.equals("fra")) {
			
			nation_name  = "프랑스";
			greeting     = "봉뷰르";
			
		}else {
			nation_name  = "국적불명";
			greeting     = "뭐지?";
		}
%>
<!-- ↑ 여기까지가 Business Logic 		: Data 처리-->


<!-- ↓ 아래부터가 Presentation Logic   : UI(화면) 구현 -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2><%= nation_name %> 인사말</h2>
<h3><%= greeting %></h3>


<a href="hello.html">다시하기</a>
</body>
</html>