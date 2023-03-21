
class Bar{
	
	constructor(x,y,w,h,color){
		this._x = x;
		this._y = y;
		this._w = w;
		this._h = h;
		this._color = color;
	}
	
	set x(value){
		this._x = value;
	}
		
	set y(value){
		this._y = value;
	}
		
	set w(value){
		this._w = value;
	}
		
	set h(value){
		this._h = value;
	}
	
	get x(){
		return this._x;
	}
	
	get y(){
		return this._y;
	}
	
	get w(){
		return this._w;
	}
	
	get h(){
		return this._h;
	}
	
		
	
	draw(ctx){
		
		ctx.fillStyle = this._color;
		ctx.fillRect(this._x,this._y,this._w,this._h);
	}
	
	move(){
		const gan = 3;
		
		if(key_state==LEFT){
			this._x -= gan;
			
		}else if(key_state==RIGHT){
			this._x += gan;
			
		}
		
		//벽 닿냐?
		if(this._x + this._w > W){
			this._x = W - this._w;
		}
		
		if(this._x <0){
			this._x = 0;
		}
	}
	
	
}