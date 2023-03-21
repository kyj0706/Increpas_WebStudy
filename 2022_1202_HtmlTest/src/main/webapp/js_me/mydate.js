
/* 멤버변수를 갖는 클래스 설계 */
class MyDate{
 
       /* default인자를 통한 Overload구현 */  
	   constructor(year=1970,month=1,day=1){
		   this._year = year;
		   this._month= month;
		   this._day  = day;
	   }
	   
	   //getter / setter
	   set year(value){
           //recursive방지를 위해서 내부변수형태 작성 : _변수
		   this._year = value;
	   }
	   
	   get year(){
		   return this._year;
	   }

       set month(value){
	       this._month = value; 
       }

       get month(){
	       return this._month;    
       }

       set day(value){
	       this._day = day;
       }
 
       get day(){
	       return this._day;
       }

       //클래스내부에서 함수선언시 function 안붙인다  
       info(){
           return this._year + "년" + this._month + "월" + this._day +"일";  
       }
	   
}