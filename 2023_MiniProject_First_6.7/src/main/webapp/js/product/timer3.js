CountDownTimer3('4/28/2023', 'countdown3'); /*남은 시간*/

 function CountDownTimer3(dt3, id3) {

     var end3 = new Date(dt3);



     var _second3 = 1000;

     var _minute3 = _second3 * 60;

     var _hour3 = _minute3 * 60;

     var _day3 = _hour3 * 24;

     var timer3;



     function showRemaining3() {

         var now3 = new Date();

         var distance3 = end3 - now3;



         // 시간 종료 시 뜨는 문구

         if (distance3 < 0) {

             clearInterval(timer3);

            return;

         }

         var days3 = Math.floor(distance3 / _day3);

         var hours3 = Math.floor((distance3 % _day3) / _hour3);

         var minutes3 = Math.floor((distance3 % _hour3) / _minute3);

		 var seconds3 = Math.floor((distance3 % _minute3) / _second3);        

		 if(hours3<10)hours3 = '0' + hours3;
		 if(minutes3<10)minutes3 = '0' + minutes3;
		 if(seconds3<10)seconds3 = '0' + seconds3;
	
         document.getElementById(id3).innerHTML = days3 + '일 ';
		 if(days3<=0)document.getElementById(id3).innerHTML = '';
         document.getElementById(id3).innerHTML += hours3 + ' : ';

         document.getElementById(id3).innerHTML += minutes3 + ' : ';

         document.getElementById("_second3").innerHTML = seconds3 + ' ';
     }

     timer3 = setInterval(showRemaining3, 1000);

 }