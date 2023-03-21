<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
   #disp{
      width: 200px;
      height: 200px;
      border: 1px solid blue;
      box-shadow: 1px 1px 1px black;
   }

</style>

</head>
<body>
<h1>${ book }</h1>
<div id="disp">${ description }</div>

<a href="list.do">목록보기</a>

</body>
</html>