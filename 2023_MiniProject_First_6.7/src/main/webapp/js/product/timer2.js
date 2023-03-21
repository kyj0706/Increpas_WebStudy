CountDownTimer2('4/28/2023', 'countdown2'); /*남은 시간*/

 function CountDownTimer2(dt2, id2) {

     var end2 = new Date(dt2);

     var _second2 = 1000;

     var _minute2 = _second2 * 60;

     var _hour2 = _minute2 * 60;

     var _day2 = _hour2 * 24;

     var timer2;

     function showRemaining2() {

         var now2 = new Date();

         var distance2 = end2 - now2;



         // 시간 종료 시 뜨는 문구

         if (distance2 < 0) {

             clearInterval(timer2);

            return;

         }

         var days2 = Math.floor(distance2 / _day2);

         var hours2 = Math.floor((distance2 % _day2) / _hour2);

         var minutes2 = Math.floor((distance2 % _hour2) / _minute2);

		 var seconds2 = Math.floor((distance2 % _minute2) / _second2);        

		 if(hours2<10)hours2 = '0' + hours2;
		 if(minutes2<10)minutes2 = '0' + minutes2;
		 if(seconds2<10)seconds2 = '0' + seconds2;
	
         document.getElementById(id2).innerHTML = days2 + '일 ';
	     if(days2<=0)document.getElementById(id2).innerHTML = '';
         document.getElementById(id2).innerHTML += hours2 + ' : ';

         document.getElementById(id2).innerHTML += minutes2 + ' : ';

         document.getElementById("_second2").innerHTML = seconds2 + ' ';
     }

     timer2 = setInterval(showRemaining2, 1000);

 }