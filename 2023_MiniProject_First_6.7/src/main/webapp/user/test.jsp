<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="./login.css">
    
    <style type="text/css">
    * {
	  margin: 0;
	  padding: 0;
	  box-sizing: border-box;
	  font-family: 'Space Grotesk';
	}
		
	a {
	  text-decoration: none;
	  color: black;
	}
	
	.wrap {
	  width: 100%;
	  height: 100vh;
	  display: flex;
	  align-items: center;
	  justify-content: center;
	  background: rgba(0, 0, 0, 0.1);
	}
	
	.login {
	  width: 30%;
	  height: 600px;
	  background: white;
	  border-radius: 20px;
	  display: flex;
	  justify-content: center;
	  align-items: center;
	  flex-direction: column;
	}
	
	h2 {
	  color: black;
	  font-size: 2em;
	}
	
	.login_id {
	  margin-top: 20px;
	  width: 80%;
	}
	
	.login_id input {
	  width: 100%;
	  height: 50px;
	  border-radius: 30px;
	  margin-top: 10px;
	  padding: 0px 20px;
	  border: 1px solid lightgray;
	  outline: none;
	}
	
	.login_pw {
	  margin-top: 20px;
	  width: 80%;
	}
	
	.login_pw input {
	  width: 100%;
	  height: 50px;
	  border-radius: 30px;
	  margin-top: 10px;
	  padding: 0px 20px;
	  border: 1px solid lightgray;
	  outline: none;
	}
	
	.login_etc {
	  padding: 10px;
	  width: 80%;
	  font-size: 14px;
	  display: flex;
	  justify-content: space-between;
	  align-items: center;
	  font-weight: bold;
	}
	
	.submit {
	  margin-top: 50px;
	  width: 80%;
	}
	.submit input {
	  width: 100%;
	  height: 50px;
	  border: 0;
	  outline: none;
	  border-radius: 40px;
	  background: linear-gradient(to left, rgb(255, 77, 46), rgb(255, 155, 47));
	  color: white;
	  font-size: 1.2em;
	  letter-spacing: 2px;
	}
    
    </style>
</head>
<body>
    <div class="wrap">
        <div class="login">
            <h2>LOG-IN</h2>
            <div class="login_id">
                <h4>ID</h4>
                <input type="login_id" name="" id="" placeholder="ID">
            </div>
            <div class="login_pw">
                <h4>PASSWORD</h4>
                <input type="password" name="" id="" placeholder="PASSWORD">
            </div>
            <div class="login_etc">
                <div class="checkbox">
                <input type="checkbox" name="" id=""> Remember Me?
                </div>
                <div class="forgot_pw">
                <a href="">Forgot Password?</a>
            </div>
            </div>
            <div class="submit">
                <input type="submit" value="submit">
            </div>
        </div>
    </div>
</body>
</html>