<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
<link href="css/list.css" rel="stylesheet">
<script src="./js/list.js"></script>
</head>
<body>
	<div id="div">
		<div id="header_div">
			<div id="header_img">
				<h1 style="color: white; font-size: 50px; margin-left: 100px; padding-top: 10px;">노리</h1>
			</div>
		</div>
		<div id="body_div">
				<div id="body_nav">
					<div id="div_nav">
						<ul id="ul_nav">
							<li><a href="">자유 게시판</a></li>
							<li><a href="">노리 게시판</a></li>
							<li><a href="">공지사항</a></li>
							<li><a href="">문의사항</a></li>
						</ul>
						
							<div id="body_header_div">
								<div id="body_header_div1">
									<form action="">
									<select class="form-select" aria-label="Default select example" id="category_select">
										<option selected>전체</option>
										<option value="1">제목</option>
										<option value="2">내용</option>
										<option value="3">작성자</option>
									  </select>
									<input type="email" class="form-control" id="exampleFormControlInput1" placeholder="검색 내용을 입력하시오">
									<button type="button" class="btn btn-outline-secondary" id="check_btn">검색</button>
									</form>
								</div>
							</div>			
						
					</div>
				</div>
				<div id="body_list">
					<table id="list_table">

						<colgroup>
							<col width="10%">
							<col width="50%">
							<col width="10%">
							<col width="15%">
							<col width="15%">
						  </colgroup>

						<!-- 제목부분 -->
						<tr class="list_tr_td" id="list_tr">
						  <td>남바</td>
						  <td>제목</td>
						  <td>작성자</td>
						  <td>작성일</td>
						  <td>조회수</td>
						</tr>
						<!-- 내용부분 -->
						
						<tr class="list_tr_td">
						  <td><span class="table-notice">1</span></td>
						  <td class="table-title">
						  <a href="">2</a>
						  </td>
						  <td>3</td>
						  <td>작성자</td>
						  <td>4</td>
						</tr>
						<tr class="list_tr_td">
						  <td><span class="table-notice">1</span></td>
						  <td class="table-title">
						  <a href="">2</a>
						  </td>
						  <td>3</td>
						  <td>작성자</td>
						  <td>4</td>
						</tr>
						<tr class="list_tr_td">
						  <td><span class="table-notice">1</span></td>
						  <td class="table-title">
						  <a href="">2</a>
						  </td>
						  <td>3</td>
						  <td>작성자</td>
						  <td>4</td>
						</tr>
						<tr class="list_tr_td">
						  <td><span class="table-notice">1</span></td>
						  <td class="table-title">
						  <a href="">2</a>
						  </td>
						  <td>3</td>
						  <td>작성자</td>
						  <td>4</td>
						</tr>
						<tr class="list_tr_td">
						  <td><span class="table-notice">1</span></td>
						  <td class="table-title">
						  <a href="">2</a>
						  </td>
						  <td>3</td>
						  <td>작성자</td>
						  <td>4</td>
						</tr>
						<tr class="list_tr_td">
						  <td><span class="table-notice">1</span></td>
						  <td class="table-title">
						  <a href="">2</a>
						  </td>
						  <td>3</td>
						  <td>작성자</td>
						  <td>4</td>
						</tr>
						<tr class="list_tr_td">
						  <td><span class="table-notice">1</span></td>
						  <td class="table-title">
						  <a href="">2</a>
						  </td>
						  <td>3</td>
						  <td>작성자</td>
						  <td>4</td>
						</tr>
						<tr class="list_tr_td">
						  <td><span class="table-notice">1</span></td>
						  <td class="table-title">
						  <a href="">2</a>
						  </td>
						  <td>3</td>
						  <td>작성자</td>
						  <td>4</td>
						</tr>
						<tr class="list_tr_td">
						  <td><span class="table-notice">1</span></td>
						  <td class="table-title">
						  <a href="">2</a>
						  </td>
						  <td>3</td>
						  <td>작성자</td>
						  <td>4</td>
						</tr>
						<tr class="list_tr_td">
						  <td><span class="table-notice">1</span></td>
						  <td class="table-title">
						  <a href="">2</a>
						  </td>
						  <td>3</td>
						  <td>작성자</td>
						  <td>4</td>
						</tr>
					  </table>
				</div>
				<div id="footer_div_btn">
					<button type="button" class="btn btn-outline-secondary" id="btn_write">쓰기</button>
				</div>
		</div>
		<div id="footer_div">

		</div>
	</div>
</body>
</html>
