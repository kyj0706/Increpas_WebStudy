CountDownTimer('4/28/2023', 'countdown'); /*남은 시간*/

function CountDownTimer(dt, id) {

	var end = new Date(dt);
	var _second = 1000;
	var _minute = _second * 60;
	var _hour = _minute * 60;
	var _day = _hour * 24;
	var timer;
	
	function showRemaining() {
	
		var now = new Date();
		var distance = end - now;
		// 시간 종료 시 뜨는 문구
		
		if (distance < 0) {
		clearInterval(timer);
		return;
		}
		
		var days = Math.floor(distance / _day);
		var hours = Math.floor((distance % _day) / _hour);
		var minutes = Math.floor((distance % _hour) / _minute);
		var seconds = Math.floor((distance % _minute) / _second);        
		
		if(hours<10)hours = '0' + hours;
		if(minutes<10)minutes = '0' + minutes;
		if(seconds<10)seconds = '0' + seconds;
	
		document.getElementById(id).innerHTML = days + '일&nbsp;';
        if(days<=0)document.getElementById(id).innerHTML = '';
        document.getElementById(id).innerHTML += hours + ' : &nbsp;';
 		document.getElementById(id).innerHTML += minutes + ' : &nbsp;';
		document.getElementById("_second").innerHTML = seconds + ' ';
		
	}
	
	timer = setInterval(showRemaining, 1000);

}