$(document).ready(function(){
	
	// 이미지에 마우스오버되면
	// 뿌옇게 보이게 설정
	$("#detail_s_table img").hover(
			function(){
				$(this).css("opacity",0.50);//투명도
			}, function(){
				$(this).css("opacity",1);
			});
	// li 에 마우스 올라오면 영화정보를 
	// 보여주게 설정
	
	
	$("#detail_s_table ul li").click(function(){
		
		
		$(".detail_big_img").show();
        // 마우스 오버된 img의 src속성값얻기
		//var src = $(this).find("img").attr("src");
        //        this의 자식요소(img)알아낸다. 
		var src = $("img",this).attr("src");
		//console.log(src);
		$("#img1").attr("src",src);
		
		//제목얻어오기
		
		
		//제목넣기
		
		
		
		}
	);
	
	
});;