<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script><link rel="stylesheet" 
      href="${ pageContext.request.contextPath }/resources/css/c_board.css">
<meta charset="UTF-8">

<style type="text/css">
	
	#k_map_bax{
    width: 1024px;
    height: 350px;
    margin: auto;
    margin-top: 20px;
    border: 1px solid black;
}

   .wrap {position: absolute;left: 0;bottom: 40px;width: 288px;height: 132px;margin-left: -144px;text-align: left;overflow: hidden;font-size: 12px;font-family: 'Malgun Gothic', dotum, '돋움', sans-serif;line-height: 1.5;}
    .wrap * {padding: 0;margin: 0;}
    .wrap .info {width: 286px;height: 120px;border-radius: 5px;border-bottom: 2px solid #ccc;border-right: 1px solid #ccc;overflow: hidden;background: #fff;}
    .wrap .info:nth-child(1) {border: 0;box-shadow: 0px 1px 2px #888;}
    .info .title {padding: 5px 0 0 10px;height: 30px;background: #eee;border-bottom: 1px solid #ddd;font-size: 18px;font-weight: bold;}
    .info .close {position: absolute;top: 10px;right: 10px;color: #888;width: 17px;height: 17px;background: url('https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/overlay_close.png');}
    .info .close:hover {cursor: pointer;}
    .info .body {position: relative;overflow: hidden;}
    .info .desc {position: relative;margin: 13px 0 0 90px;height: 75px;}
    .desc .ellipsis {overflow: hidden;text-overflow: ellipsis;white-space: nowrap;}
    .desc .jibun {font-size: 11px;color: #888;margin-top: -2px;}
    .info .img {position: absolute;top: 6px;left: 5px;width: 73px;height: 71px;border: 1px solid #ddd;color: #888;overflow: hidden;}
    .info .img2 {position: absolute;top: 6px;left: 5px;width: 73px;height: 71px;border: 1px solid #ddd;color: #888;overflow: hidden;}
    .info:after {content: '';position: absolute;margin-left: -12px;left: 50%;bottom: 0;width: 22px;height: 12px;background: url('https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/vertex_white.png')}
    .info .link {color: #5085BB;}


	#box_1{
    width: 1024px;
    margin: auto;
    margin-top: 20px;
	}

 .content{
      min-height: 60px;
      border: 1px solid gray;
      box-shadow: -1px -1px 1px #333333;
      padding: 5px;
  }
  
  .regdate_ip , .star {
      border: 1px solid gray;
      box-shadow: 1px 1px 1px #333333;
      padding: 5px;
      margin-top: 10px;
  }
  
   a {
  	  text-decoration: none;
	}
	
	a:link { color: olive; } // 기본 상태
	a:visited { color: brown; } // 사용자가 이미 링크 방문한 상태라면 갈색으로
	a:hover { color: coral; } // 마우스 올려져 있을때 coral색으로
	a:active { color: khaki; } // 마우스로 클릭할떄 khaki색으로 변경
	
	 a:link, a:visited {
     background-color: #FFA500;
     color: maroon;
     padding: 15px 25px;
     text-align: center;
     text-decoration: none;
     display: inline-block;
}
 a:hover, a:active {
     background-color: #FF4500;
}
</style>


<title>Insert title here</title>
</head>
<body>
<!-- 헤더 -->
	<header>
		<jsp:include page="/WEB-INF/views/layout/header/header.jsp"></jsp:include>
	</header>
	<!-- 메뉴 -->
	<nav>
		<jsp:include page="/WEB-INF/views/layout/nav/nav.jsp"></jsp:include>
	</nav>

	<div id="box">
		<div class="panel panel-default">
			<div class="panel-heading">
			   <%-- <h4>[${ FVO.c_mem_name }]님이 작성하신 글</h4> --%>
			   <span>  ${ cvo.f_statNm } [별점평균 : ( ${ fn:substring( svo , 0 , 4 ) } )]</span>
			   <span style="float: right; font-size: 20px;"><a href="insert_form.do?f_statNm=${ cvo.f_statNm }">글쓰기</a></span>
			</div>
			<div class="panel-body" style="display: none;">
                <div id="content">
                위도 : ${ cvo.f_lat }
                </div>		
                <div id="content">
                경도 : ${ cvo.f_lng }
                </div>		
                <div id="content">
                주소 : ${ cvo.f_addr }
                </div>		
                <div id="content">
                사용 가능 시간 : ${ cvo.f_useTime }
                </div>		
                <div id="content">
                충전기 타입 : ${ cvo.f_chgerType }
                </div>		
                <div id="content">
                주차장 무료 여부 : ${ cvo.f_parkingFree }
                </div>	
                <div style="margin-bottom: 5px;">
				
     			</div>	
			</div>	
		</div>
	</div>
	<div id="k_map_bax">
	<div id="map" style="width:100%;height:350px;"></div>
	
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=0341ebc2b6f29f7267150b5c229ca561"></script>
	<script>
	var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
	    mapOption = { 
	        center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
	        level: 3 // 지도의 확대 레벨
	    };
	var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다
	
	// 지도에 마커를 표시합니다 
	var marker = new kakao.maps.Marker({
	    map: map, 
	    position: new kakao.maps.LatLng(${ cvo.f_lat },${ cvo.f_lng })
	});
	
	// 마커가 표시될 위치입니다 
	//var markerPosition  = new kakao.maps.LatLng(${ cvo.f_lat }, ${ cvo.f_lng }); 
	
	
	// 커스텀 오버레이에 표시할 컨텐츠 입니다
	// 커스텀 오버레이는 아래와 같이 사용자가 자유롭게 컨텐츠를 구성하고 이벤트를 제어할 수 있기 때문에
	// 별도의 이벤트 메소드를 제공하지 않습니다 
	var content = '<div class="wrap">' + 
	            '    <div class="info">' + 
	            '        <div class="title">' + 
	            '            ${ cvo.f_statNm }' + 
	            '            <div class="close" onclick="closeOverlay()" title="닫기"></div>' + 
	            '        </div>' + 
	            '        <div class="body">' + 
	            '            <div class="img">' +
	            '                <img src="../resources/images/1_AC3_sang.PNG" width="73" height="70">' +
	            '           </div>' + 
	            '            <div class="desc">' + 
	            '                <div class="ellipsis">${ cvo.f_addr }</div>' + 
	            '                 <div class="jibun ellipsis">사용가능시간: ${ cvo.f_useTime }</div>' + 
	            '                 <div class="jibun ellipsis">주차장 :${ cvo.f_parkingFree eq "N" ? "무료" : "유료"}</div>' + 
	            '                 <div class="jibun ellipsis">충전타입: ${ type_str}</div>' +
	            '            </div>' + 
	            '        </div>' + 
	            '    </div>' +    
	            '</div>';
	
    var overlay = new kakao.maps.CustomOverlay({
        content: content,
        map: map,
        position: marker.getPosition()       
    });
	            
	            
	
	// 마커를 생성합니다
	/*
	var marker = new kakao.maps.Marker({
	    position: markerPosition
	});
	*/
	
	map.setCenter( marker.getPosition() );
	
	// 마커가 지도 위에 표시되도록 설정합니다
	//marker.setMap(map);
	
	
	// 마커를 클릭했을 때 커스텀 오버레이를 표시합니다
	kakao.maps.event.addListener(marker, 'click', function() {
	    overlay.setMap(map);
	});

	// 커스텀 오버레이를 닫기 위해 호출되는 함수입니다 
	function closeOverlay() {
	    overlay.setMap(null);     
	}
	
	
	</script>
	</div>
	
	<div>
	
	</div>
	<div id="box_1" style="overflow-y:scroll; height: 420px;">
	<c:forEach var="vo" items="${ list }" varStatus="i">
		<div id="comment"  class="panel panel-primary">
			<div class="panel-headin">${ i.index+1 } : ${ fn:substring( vo.c_mem_name ,0 , 2 ) }* </div>
			<div class="panel-body">
				<div class="content">내용 : ${ vo.f_content }</div>
				<div class="regdate_ip">작성일자 : ${ fn:substring( vo.f_regdate ,0 ,10 ) }</div>
				<div class="star">별점 : ${ vo.s_no }</div>
			</div>
 		</div> 
	</c:forEach>
    </div> 
    <footer>
		<jsp:include page="/WEB-INF/views/layout/footer/footer.jsp"></jsp:include>
	</footer> 

</body>
</html>