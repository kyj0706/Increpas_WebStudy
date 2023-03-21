function init_block(){
	  
	 block_w = W / BLOCK_COLS;
	 block_h = BLOCK_H;
	 
	 var color_array = ['red','green','blue','yellow','cyan','magenta','purple'];
	 
	 //block_array = [];
	 block_array = new Array();
	 
	 for(var i=0;i<BLOCK_ROWS;i++){ //행 i = 0 1 2 3 4
		 
		 //var array = [];
		 var array = new Array();
		 for(var k=0;k<BLOCK_COLS;k++){ //열 k
			 
			 var color = color_array[(i+k)%color_array.length];
		 
			 var block = new Block(block_w*k,block_h*i,block_w,block_h,color);
			 
			 //if(i==0 || k==0 || k==(BLOCK_COLS-1))
				//block.bShow=false;
			 block_count++;
			 
			 //if(block.bShow) block_count++;
			 
			 
			 array[k] = block;
		 }
		 block_array[i] = array;
	 }
	 console.log("블럭카운트"+block_count);
	 draw_score();
	
  }



 //마름모 블럭
  function init_block2(){
	 
	 BLOCK_ROWS = 15;
	 BLOCK_COLS = 15;
	 block_count= 0;
	  
	 block_w = W / BLOCK_COLS;
	 block_h = BLOCK_H;
	 
	 
	 var center = Math.floor(BLOCK_COLS/2);
	 
	 
	 var color_array = ['red','green','blue','yellow','cyan','magenta','purple'];
	 
	 //block_array = [];
	 block_array = new Array();
	 
	 for(var i=0;i<BLOCK_ROWS;i++){ //행 i = 0 1 2 3 4
		 
		 //var array = [];
		 var array = new Array();
		 for(var k=0;k<BLOCK_COLS;k++){ //열 k
			 
			 var color = color_array[(i+k)%color_array.length];
		 
			 var block = new Block(block_w*k,block_h*i,block_w,block_h,color);
			 
			 if(i<=center){
				 if(k >= (center-i) && k<= (center+i))
					 block.bShow=true;
				 else
					 block.bShow=false;
			 }else{
				 var a = BLOCK_COLS-i-1;
				 if(k >= (center-a) && k<= (center+a))
					 block.bShow=true;
				 else
					 block.bShow=false;
			 }
			 
		
			 
			 if(block.bShow) block_count++;
			 
			 array[k] = block;
		 }
		 block_array[i] = array;
	 }
	 
	 console.log("깨야할 블럭수:" + block_count);
	 
  }