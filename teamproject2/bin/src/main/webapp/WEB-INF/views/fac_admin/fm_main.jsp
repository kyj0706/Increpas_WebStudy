<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="utf-8">
<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
  <link href="img/logo/logo.png" rel="icon">
  <title>Team of Yul</title>
  <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css">
  <link href="css/ruang-admin.min.css" rel="stylesheet">
  <link href="vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">
  <link href="css/fac_register.css" rel="stylesheet">
   <c:if test="${session_member != 'seller' }">
 		 <script type="text/javascript">
  	 	 alert("잘못된 경로입니다")
  		 location.href="login"
  		 </script>
  	</c:if>
	<style type="text/css">
		.box_outline{
			display: inline-block;
			width: 100%;
			text-align: center;
		}
		.info_box_outline{
			width:200px;
			height: 200px;
			border-radius: 100%;
			text-align: center;
			background-color: #ffffff;
			display: inline-block;
			border:3px solid #f7f7f7;
			margin:2%;
			
		}
		.info_div{
			margin-top:10%;
			font-size: 20px;
			color: #555;
			font-weight: bold;
			display: inline-block;
			
		}
		.info_count{
			margin-top:35px;
			font-size: 50px;
		}
		.number_span{
			color:#9a61ff; 
			font-weight: bold;
			font-size:40px;
		}
	</style>
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script type="text/javascript">
	$(function(){
		$("#finfo_name").change(function(){
			$.ajax({
	             url: "finfoInfo",
	             type: "post",
	             data:{
	             	"finfo_name":$("#finfo_name").val(),
	             	"fm_id":"${session_id}"
	             	},
	             success: function(data){
	            	 $("#reserNo").text(data.reserNo);
	            	 $("#reviewNo").text(data.reviewNo);
	            	 $("#payNo").text(data.payNo);
	            	 $("#refundNo").text(data.refundNo);
	            	 var totalHtml = '';
	            	 totalHtml +='<tr>';
	            	 totalHtml +='<td>'+data.totalPrice +'원</td>';
	            	 totalHtml +='<td>'+data.totalRefund +'원</td>';
	            	 totalHtml +='<td>'+(data.totalPrice-data.totalRefund) +'원</td>';
	            	 totalHtml +='</tr>';
	            	 var paymentVo = data.list;
	            	 var payList = '';
	            	 for(var i =0; i<paymentVo.length; i++){
	            		 if(paymentVo[i].pay_status == '0'){
	            			 payList += '<tr>';
	            			 payList += '<td>'+paymentVo[i].reser_no +'</td>';
	            			 payList += '<td>'+paymentVo[i].m_name +'</td>';
	            			 if(paymentVo[i].pay_status == '0'){
	            				 payList += '<td>결제완료</td>';
	            			 }else if(paymentVo[i].pay_status == '1'){
	            				 payList += '<td>결제취소</td>';
	            			 }
	            			 payList += '<td>'+paymentVo[i].pay_price +'원</td>';
	            			 payList += '<td></td>';
	            			 payList += '<td>'+paymentVo[i].pay_date +'</td>';
	            			 payList += '<td></td>';
	            			 payList += '</tr>';
	            			 
	            		 }else if(paymentVo[i].pay_status == '1'){
	            			 payList += '<tr>';
	            			 payList += '<td>'+paymentVo[i].reser_no +'</td>';
	            			 payList += '<td>'+paymentVo[i].m_name +'</td>';
	            			 payList += '<td>결제완료</td>';
	            			 payList += '<td>'+paymentVo[i].pay_price +'원</td>';
	            			 payList += '<td></td>';
	            			 payList += '<td>'+paymentVo[i].pay_date +'</td>';
	            			 payList += '<td></td>';
	            			 payList += '</tr>';
	            			 payList += '<tr>';
	            			 payList += '<td>'+paymentVo[i].reser_no +'</td>';
	            			 payList += '<td>'+paymentVo[i].m_name +'</td>';
	            			 payList += '<td><span class = "cancel_span">결제취소</span></td>';
	            			 payList += '<td></td>';
	            			 payList += '<td><span class = "cancel_span">'+paymentVo[i].pay_price +'</span>원</td>';
	            			 payList += '<td></td>';
	            			 payList += '<td>'+paymentVo[i].refund_date+'</td>';
	            			 payList += '</tr>';
	            		 }
	            	 }
	  
                     $("#totalPrice").html(totalHtml);
                     $("#payList").html(payList);
  							                   
                     
                   
	             },
	             error: function(){
	                alert("실패");
	             }
	         }); 
		});
	});
	</script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://www.gstatic.com/charts/loader.js"></script>
<script>

	//구글 시각화 API를 로딩하는 메소드

	google.charts.load('current', {
		packages : [ 'corechart' ]
	});

	// 구글 시각화 API가 로딩이 완료되면,

	// 인자로 전달된 콜백함수를 내부적으로 호출하여 차트를 그리는 메소드

	// 화면이 실행될때 함께 실행된다.

	//google.charts.setOnLoadCallback(columnChart1);

	// 묶은 세로 막대형 차트 1

	$(function(){
		$("#finfo_name").change(function(){
			$.ajax({
	             url: "weekPrice",
	             type: "post",
	             data:{
	             	"finfo_name":$("#finfo_name").val(),
	             	"fm_id":"${session_id}"
	             	},
	             success: function(data){
	            	 var arr = [
	            			['통합',  '매출액', '환불액' ],
	            			['정산금액',  data.totalPrice, data.totalRefund ],
	            			];
 							                   
	         		// 실 데이터를 가진 데이터테이블 객체를 반환하는 메소드

	         		var dataTable = google.visualization.arrayToDataTable(arr);

	         		// 옵션객체 준비

	         		var options = {

	         			title : '실적',

	         			hAxis : {

	         				title : '',

	         				titleTextStyle : {

	         					color : 'red'

	         				}

	         			}

	         		};

	         		// 차트를 그릴 영역인 div 객체를 가져옴

	         		var objDiv = document.getElementById('column_chart_div1');

	         		// 인자로 전달한 div 객체의 영역에 컬럼차트를 그릴수 있는 차트객체를 반환

	         		var chart = new google.visualization.ColumnChart(objDiv);

	         		// 차트객체에 데이터테이블과 옵션 객체를 인자로 전달하여 차트 그리는 메소드

	         		chart.draw(dataTable, options);

                  
	             },
	             error: function(){
	                alert("실패");
	             }
	         }); 	
		
		// 버튼 클릭 시 ajax를 사용하여 서버로부터 json 배열 객체를 가져왔다고 가정함

		
		
	 // drawColumnChart1()의 끝
	});
});
</script>
<style type="text/css">
	#column_chart_div1{
		margin-left:400px;
	}
</style>
</head>
<body id="page-top">
  <div id="wrapper">
    <!-- Sidebar -->
    <jsp:include page="../include/sellerSideBar.jsp"></jsp:include>
    <!-- Sidebar -->
    <div id="content-wrapper" class="d-flex flex-column">
      <div id="content">
        <!-- TopBar -->
       <jsp:include page="../include/sellerTopBar.jsp"></jsp:include>
        <!-- Topbar -->
        <select id = "finfo_name">
        	<option value="" >선택</option>
        	<c:forEach items="${map.finfo_name }" var = "finfo_name">
        		<option value = "${finfo_name }">${finfo_name }</option>
        	</c:forEach>
        </select>
        <div id = "info_box">
	        <div class = "box_outline">
	        <a>
	        	<div class = "info_box_outline">
	        		<div class = "info_div">예약 개수</div>
	        		<div class = "info_count"><span class = "number_span" id = "reserNo"></span>개</div>
	        	</div>
	        </a>
	        <a>
	        	<div class = "info_box_outline">
	        		<div class = "info_div">리뷰 개수</div>
	        		<div class = "info_count"><span class = "number_span" id = "reviewNo"></span>개</div>
	        	</div>
	        </a>
	        <a>
	        	<div class = "info_box_outline">
	        		<div class = "info_div">결제 개수</div>
	        		<div class = "info_count"><span class = "number_span" id = "payNo"></span>개</div>
	        	</div>
	        </a>
	        <a>
	        	<div class = "info_box_outline">
	        		<div class = "info_div">환불/취소 개수</div>
	        		<div class = "info_count"><span class = "number_span" id = "refundNo"></span>개</div>
	        	</div>
	        </a>
	        </div>
        </div>
		<!-- 정산 시작 -->
		<div id="column_chart_div1" style="width: 900px; height: 500px;"></div>
        <DIV>
           <div>
              <div id="title_div">
                 <h3 style="margin: 15px;">정산 관리</h3>
                 <hr>
              </div>
              
             <div class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
               <h6 class="m-0 font-weight-bold text-primary">판매정산 현황</h6>
             </div>
             <table class="table align-items-center table-flush table-hover" style="border:1px solid black; padding: 20px;">
                <thead class="thead-light">
                      <tr>
                        <th>판매 금액(A)</th>
                        <th>환불 금액(B)</th>
                        <th>정산 예정금액(A-B)</th>
                      </tr>
                 </thead>
                 <tbody id = "totalPrice">
                 </tbody>
              </table>   
             <div class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
               <h6 class="m-0 font-weight-bold text-primary">판매 상세내역</h6>
             </div>
             <div class="table-responsive p-3">
               <table class="table align-items-center table-flush table-hover" id="dataTableHover">
                 <thead class="thead-light">
                   <tr>
                     <th>예약 번호</th>
                     <th>구매자 이름</th>
                     <th>결제 상태</th>
                     <th>결제 금액</th>
                     <th>환불 금액</th>
                     <th>결제 완료일</th>
                     <th>환불 완료일</th>
                   </tr>
                 </thead>
                 <tbody id = "payList">
                 </tbody>
               </table>
             </div>
           </div>
             
        </DIV>
  
      </div>

      <!-- Footer -->
      <footer class="sticky-footer bg-white">
        <div class="container my-auto">
          <div class="copyright text-center my-auto">
            <span>copyright &copy; <script> document.write(new Date().getFullYear()); </script> - developed by <b><a href="https://indrijunanda.gitlab.io/"
                  target="_blank">indrijunanda</a></b> </span>
          </div>
        </div>
      </footer>

    </div>
  </div>
  <a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
  </a>
  <script src="vendor/jquery/jquery.min.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <script src="vendor/jquery-easing/jquery.easing.min.js"></script>
  <script src="js/ruang-admin.min.js"></script>
</body>

</html>