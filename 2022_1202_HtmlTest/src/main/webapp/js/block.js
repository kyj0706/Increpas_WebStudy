
class Block{
	
	constructor(x,y,w,h,color,bShow=true){
		this._x = x;
		this._y = y;
		this._w = w;
		this._h = h;
		this._color = color;
		this._bShow = bShow;
	}
	
	set bShow(value){
		this._bShow = value;
	}
	
	get bShow(){
		return this._bShow;
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
		ctx.fillRect(this._x+1,this._y+1,this._w-2,this._h-2);
	}
	
	
}