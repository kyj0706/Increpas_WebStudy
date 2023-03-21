var xhr = null;

function createRequest(){
	if(xhr!=null)return;
	if(window.ActiveXObject)
		xhr = new ActiveXObject("Microsoft.XMLHTTP");
	else
		xhr = new XMLHttpRequest();
}


function sendRequest(url, param, callBack, method){
	createRequest();
	var httpMethod = 
	(method!='POST' && method!='post')?'GET':'POST';
	
	var httpParam = 
	(param==null || param == '')?null:param;
	
	var httpURL = url;
	
	//요청 방식이 get방식이고, 전달할 파라미터 값이 있다면
	//url경로를 제작 해야 한다.(.../test.jsp?ch=123)
	if(httpMethod == 'GET' && httpParam != null)
		httpURL = httpURL+"?"+httpParam;
	
	xhr.open(httpMethod, httpURL, true);
	xhr.setRequestHeader("Content-Type",
	  "application/x-www-form-urlencoded");
	xhr.onreadystatechange = callBack;
	
	xhr.send(httpMethod == 'POST'?httpParam:null);
}













