/**
 * 
 */
 function deleteView(){
	if(confirm("정말로 삭제하시겠습니까?")==true){
		 $.ajax({
             url: "/freeBoardMemberDelete",
             type: "post",
             data:{
             	"fbm_num":${param.fbm_num}
             	},
             success: function(data){
             	location.href = "freeBoardMemberList?page=${param.page }&searchCategory=${param.searchCategory}&sportsCategory=${param.sportsCategory }&searchWord=${param.searchWord}";
             },
             error: function(){
                alert("삭제 실패");
             }
         }); 
	
	}
}