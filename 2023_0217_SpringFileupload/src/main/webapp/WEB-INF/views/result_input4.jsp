<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib  prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
  
  #box{
     width: 550px;
     margin: auto;
  }
  #img_box{
      border: 2px solid blue;
  }
  
  img{
     width: 100px;
     height: 100px;
     border: 1px solid gray;
     outline: 1px solid black; 
     margin: 30px;
  }
  
  img:hover{
     border-color: red;
  }
</style>
</head>
<body>

<div id="box">

<hr>
제목:${ title }
<hr>

  <div id="img_box">
    <!-- for(String filename: filename_list) -->
    <c:forEach var="filename"  items="${ filename_list }">
        <img src="resources/upload/${ filename }"  width="200">
    </c:forEach>
  </div>  
</div>

</body>
</html>