  //화면의 폭/높이
  const W = 800;
  const H = 600;
  
  //블럭의 행/열의 갯수
  var   BLOCK_ROWS = 10;
  var   BLOCK_COLS = 8; 
  const BLOCK_H    = 30;
  
  var block_w; 
  var block_h = BLOCK_H;
  
  var ctx   = null;
  var timer = null;

  var ball  = null;
  var block_array = null;

  var bar   = null;

  var key_state = 0;

  var life_count= 3;
  var img_monkey;

  var stage = 1;
  var block_count = 0;

  var score = 0; 

