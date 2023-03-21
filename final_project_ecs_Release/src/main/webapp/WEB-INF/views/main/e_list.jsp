<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.table{
		display: block;
		overflow: auto;
	}
	
	table {
		height: 500px;
		border-spacing: 0; 
	}
	


</style>
</head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=0341ebc2b6f29f7267150b5c229ca561
&libraries=services"></script>
<script type="text/javascript">
 
   window.onload = function(){
		document.getElementById("zscode").value = '${ empty param.zscode ? 11110  : param.zscode }';
		document.getElementById("pageNo").value = '${ empty param.pageNo ? 1 : param.pageNo }';;
	};
  
	

	
</script>
<script type="text/javascript">
	function send(f){
		f.action="list.do";
		f.submit();//누구에게 전송?
	}
</script>



<body>
	<!-- 헤더 -->
	<header>
		<jsp:include page="/WEB-INF/views/layout/header/header.jsp"></jsp:include>
	</header>
	<!-- 메뉴 -->
	<nav>
		<jsp:include page="/WEB-INF/views/layout/nav/nav.jsp"></jsp:include>
	</nav>
	<div id = "box" style="margin: auto; margin-bottom: 50px;" >
		<!-- 검색메뉴 -->
		<form>
			<div style="text-align: center; margin-bottom: 50px;">			 
				검색명 : <input name="keyword">
						 <input type="button" value="검색" onclick="send(this.form);">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;		
				
				검색 지역:
				<select name="zscode"  id="zscode">
					<option value="11530">구로구</option>
					<option value="11620">관악구</option>
					<option value="11110">종로구</option>
					<option value="11140">중구</option>
					<option value="11170">용산구</option>
					<option value="11200">성동구</option>
					<option value="11215">광진구</option>
					<option value="11230">동대문구</option>
					<option value="11260">중랑구</option>
					<option value="11290">성북구</option>
					<option value="11305">강북구</option>
					<option value="11320">도봉구</option>
					<option value="11350">노원구</option>
				</select>
				
				페이지: 
				<select name="pageNo"  id="pageNo">
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
					<option value="5">5</option>
					<option value="6">6</option>
					<option value="7">7</option>
					<option value="8">8</option>
					<option value="9">9</option>
					<option value="10">10</option>
				</select>
		        <input type="button"  value="검색" onclick="send(this.form);">
		        </div>
				</form>
			<div id="t_box" style="float:left; margin-left: 150px; " >
				<table class="table" style="width: 100%;">
					<tr class="success">
						   <th>No</th>
			               <th>충전소명</th>                   
			               <th>주소</th>                   
			               <th style="display: none;">상세위치</th>                   
			               <th style="display: none;">이용가능시간</th>                   
			               <th style="display: none;">충전기상태</th>                   
			               <th style="display: none;">충전기타입</th>                   
			               <th style="display: none;">충전용량</th>                   
			               <th style="display: none;">충전방식</th>                   
			               <th style="display: none;">지역구분 상세 코드</th>                   
			               <th style="display: none;">주차료무료</th>                   
			               <th style="display: none;">충전소 안내</th>                   
			               <th style="display: none;">위도</th>                   
			               <th style="display: none;">경도</th>                     
			          </tr>
					<c:if test="${ empty list }">
						<tr>
						   <td colspan="13" align="center">
						      <font color="red">검색된 정보가 없습니다</font>
						   </td>
						</tr>
					</c:if>
					
					<c:forEach var="c_vo" items="${ list }" varStatus="i" >
						<tr>
							<td>${ i.index+1 }</td>
							<td>
								<a href="view.do?statNm=${ c_vo.statNm }&lat=${ c_vo.lat }&lng=${ c_vo.lng }
								&addr=${ c_vo.addr }&useTime=${ c_vo.useTime }&chgerType=${ c_vo.chgerType }
								&parkingFree=${ c_vo.parkingFree }&note=${ c_vo.note }">
								${ c_vo.statNm }
								</a>
							</td>
							<td>${ c_vo.addr }</td>
							<td style="display: none;">${ c_vo.location }</td>
							<td style="display: none;">${ c_vo.useTime }</td>
							<td style="display: none;">${ c_vo.stat }</td>
							<td style="display: none;">${ c_vo.chgerType }</td>
							<td style="display: none;">${ c_vo.output }</td>
							<td style="display: none;">${ c_vo.method }</td>
							<td style="display: none;">${ c_vo.zscode }</td>
							<td style="display: none;">${ c_vo.parkingFree }</td>
							<td style="display: none;">${ c_vo.note }</td>
							<td style="display: none;">${ c_vo.lat }</td>
							<td style="display: none;">${ c_vo.lng }</td>
						</tr>
					</c:forEach>
					
					<tr> 
			        	<td colspan="5" align="center" style="font-size: 20px;">
			        		<!-- <a href="plus.do?page=">&lt;</a>&nbsp;
			        		<a href="list.do?page=1">1</a>&nbsp;
			        		<a href="list.do?page=2">2</a>&nbsp;
			        		<a href="list.do?page=3">3</a>&nbsp;
			        		<a href="minus.do?page=">&gt;</a>&nbsp; -->
			        		${ pageMenu }
			        	</td>
			        </tr>
				</table>
		</div>
		
		<div id="m_box" style="float:right: ;">
		<div id="map" style="width:50%;height:500px;"></div>

		<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=0341ebc2b6f29f7267150b5c229ca561"></script>
		<script>
		//javacript
		
		var mapContainer = document.getElementById('map'), // 지도를 표시할 div  
	    mapOption = { 
	        center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
	        level: 7 // 지도의 확대 레벨
	    };
		
		var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다
		 
		// 마커를 표시할 위치와 내용을 가지고 있는 객체 배열입니다 (확인용)
		let list = new Array();
		<c:forEach var="list" items="${list}" varStatus="status">
		list.push("${list.statNm}");
		list.push("${list.lat}");
		list.push(${status.count},"${list.lng}");
		</c:forEach>
		
		var positions = [
			<c:forEach var="list" items="${list}" varStatus="status">
    		{
       			 content: 
       				'<div style="width:300px;padding:6px 0;">'+
	       				 '<div>${list.statNm}</div>'+
	       				 '<div>${list.addr}</div>'+
	       				 '<div>${list.useTime},${list.chgerType},(${list.method})</div>'+
       				 '</div>'
       				 , 
        		latlng: new kakao.maps.LatLng(${list.lat}, ${list.lng})
    		},
			</c:forEach>
    
			];
		
		
		for (var i = 0; i < positions.length; i ++) {
		    // 마커를 생성합니다
		    var marker = new kakao.maps.Marker({
		        map: map, // 마커를 표시할 지도
		        position: positions[i].latlng // 마커의 위치
		    });
			
		    // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
		    map.setCenter(positions[i].latlng);
		    
		    // 마커에 표시할 인포윈도우를 생성합니다 
		    var infowindow = new kakao.maps.InfoWindow({
		        content: positions[i].content // 인포윈도우에 표시할 내용
		    });
		
		    // 마커에 mouseover 이벤트와 mouseout 이벤트를 등록합니다
		    // 이벤트 리스너로는 클로저를 만들어 등록합니다 
		    // for문에서 클로저를 만들어 주지 않으면 마지막 마커에만 이벤트가 등록됩니다
		    kakao.maps.event.addListener(marker, 'mouseover', makeOverListener(map, marker, infowindow));
		    kakao.maps.event.addListener(marker, 'mouseout', makeOutListener(infowindow));
		}
		
		// 인포윈도우를 표시하는 클로저를 만드는 함수입니다 
		function makeOverListener(map, marker, infowindow) {
		    return function() {
		        infowindow.open(map, marker);
		    };
		}
		
		// 인포윈도우를 닫는 클로저를 만드는 함수입니다 
		function makeOutListener(infowindow) {
		    return function() {
		        infowindow.close();
		    };
		}
		
</script>
</div>

	</div>
	<footer>
		<jsp:include page="/WEB-INF/views/layout/footer/footer.jsp"></jsp:include>
	</footer>
</body>
</html>