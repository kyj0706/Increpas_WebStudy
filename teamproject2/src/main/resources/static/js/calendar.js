
         
    function checkLeapYear(year){
        
        if(year%400 == 0){
            return true;
        }else if(year%100 == 0){
            return false;
        }else if(year%4 == 0){
            return true;
        }else{
            return false;
        }
    }

    function getFirstDayOfWeek(year,month){
        if(month<10) month = "0" + month;
        return (new Date(year+"-"+month+"-01")).getDay();
    }

    function changeYearMonth(year,month,day){
        let month_day = [31,28,31,30,31,30,31,31,30,31,30,31];

        if(month == 2){
            if(checkLeapYear(year)) month_day[1] = 29;
        }
        let first_day_of_week = getFirstDayOfWeek(year,month);
        let arr_calender = [];
        for(let i =0; i<first_day_of_week; i++){
            arr_calender.push("");
        }

        for(let i=1; i<= month_day[month-1]; i++){
            arr_calender.push(String(i));
        }

        let remain_day = 7-(arr_calender.length%7);
        if(remain_day<7){
            for(let i =0; i< remain_day; i++){
                arr_calender.push("");
            }
        }
        renderCalendar(arr_calender,day);
    }

    function renderCalendar(data,day){
        
        let h = [];
        for(let i =0; i<data.length;i++){
            if(i==0){
                h.push('<tr>');
            }else if(i%7 == 0){
                h.push('</tr>');
                h.push('<tr>');
            }
            if(data[i] == ""){
                h.push('<td class = "none_day" style = "background-color: #cccccc;"></td>');    
            }else if(data[i] < day){
                h.push('<td class = "none_day" id = "day'+data[i]+'" style = "background-color: #cccccc;">'+ data[i] +'</td>');
	
						}else{
                h.push('<td class = "isDay" id = "day'+data[i]+'"onclick = "setDate('+data[i]+')" style = "cursor:pointer;">'+ data[i] +'</td>');

            }
        }
        h.push('</tr>');
        $("#td_body").html(h.join(""));
    }

    function setDate(day){
        $(".isDay").css("background-color","white");
        $("#day"+day).css("background-color","#d5c7ff");
        $(".isDay").css("color","black");
        $("#day"+day).css("color","white");
        $("#r_time").text("");
				$("#r_price").text("");
        if(day<10) day = "0" + day;
        if(current_month <10){
            $("#input_date").val(current_year+"-0"+current_month+"-"+day);
            $("#r_date").text(current_year+"-0"+current_month+"-"+day);
            $("#reser_status").text(current_year+"-0"+current_month+"-"+day+"예약")

        }else{
            $("#input_date").val(current_year+"-"+current_month+"-"+day);
            $("#r_date").text(current_year+"-"+current_month+"-"+day);
            $("#reser_status").text(current_year+"-"+current_month+"-"+day+"예약")
        }
    }
    function changeMonth(diff){
        if(diff == undefined){
            current_month = parseInt($("#month").val());
        }else{
            current_month = current_month + diff;

            if(current_month == 0){
                current_year = current_year -1 ;
                current_month = 12;
            }else if(current_month == 13){
                current_year = current_year + 1;
                current_month = 1;
            }
        }
        loadCalendar();
    }
    function loadCalendar(){
        $("#year").val(current_year);
        $("#month").val(current_month);
        changeYearMonth(current_year,current_month);

    }
    let current_year = (new Date()).getFullYear();
    let current_month = (new Date()).getMonth() + 1;
    let current_day = (new Date()).getDate();
    $("#year").val(current_year+"년");
    $("#month").val(current_month+"월");
    
    
        
     changeYearMonth(current_year,current_month,current_day);
    
