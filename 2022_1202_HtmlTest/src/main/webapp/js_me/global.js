//모든 변수 사용

  //화면의 폭/높이
  const W = 800;
  const H = 600;
  
  //블럭의 행/열의 갯수
  var BLOCK_ROWS ;
  var BLOCK_COLS ; 
  const BLOCK_H    = 30; 

//바크기  
  var bar_w;	
  var bar_h;
  var bar_x;
  var bar_y;	
  
//블럭크기	
  var block_w;  
  var block_h;


//
  var ctx   = null;
  var timer = null;

  var ball  = null;
  var block_array = null;
  var bar =  null;
	
//키눌림상태
  var key_state =0;


//count
 var life_count = 3;
 var img_monkey;

//블럭의 갯수
 var block_count =0;

//점수
 var score = 0;

 var stage;
	