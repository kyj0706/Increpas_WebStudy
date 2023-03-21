
class Ball{
	
	constructor(x,y,r,bRight,bDown){
		this._x = x;
		this._y = y;
		this._r = r;
		this._bRight = bRight;
		this._bDown  = bDown;
	}
	
	set x(value){
		this._x = value;
	}
	
	set y(value){
		this._y = value;
	}
	
	set r(value){
		this._r = value;
	}
	
	set bRight(value){
		this._bRight = value;
	}
	
	set bDown(value){
		this._bDown = value;
	}
	
	get x(){
		return this._x;
	}
	
	get y(){
		return this._y;
	}
	
	get r(){
		return this._r;
	}
	
	get bRight(){
		return this._bRight;
	}
	
	get bDown(){
		return this._bDown;
	}
	
	
	move(){
	   	const gan = 1;
 
        //좌우이동 
        if(this._bRight){
	       this._x += gan;
        }else{
	       this._x -= gan;
        }        

        //상하이동
        if(this._bDown){
	       this._y += gan;
        }else{
	       this._y -= gan;
        }   


        //오른쪽벽에 닿았냐?
        if( (this._x + this._r) > W ){
	        this._bRight = false;   
        }else if( (this._x - this._r) < 0){//왼쪽벽에 닿았냐?
            this._bRight = true;
        }  

        //아랫쪽에 닿았냐?
        if( (this._y + this._r) > H ){
	        //this._bDown = false;
			return false;
			   
        }else if( (this._y - this._r) < 0){//윗쪽벽에 닿았냐?
            this._bDown = true;
        }    
		
		return true;
	}
	
	draw(ctx){
		
		//원
		ctx.beginPath();
		
		var radgrad = ctx.createRadialGradient(this._x-this._r/2,this._y-this._r/2,0,
		                                       this._x-this._r/2,this._y-this._r/2,this._r*2); 
		radgrad.addColorStop(0, 'white'); 
		radgrad.addColorStop(1, 'black'); 
		ctx.fillStyle = radgrad; 
		ctx.arc(this._x,this._y,this._r,0,Math.PI*2,true);
		ctx.fill();
		
	}
	
}