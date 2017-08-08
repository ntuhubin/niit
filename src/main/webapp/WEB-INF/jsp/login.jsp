<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>系统登录</title>
</head>
<body>
	<form action="<%=request.getContextPath() %>/Info/login" name="loginform" method="post">  
         <h2 align="center" style=" font-family:隶书">欢迎登陆信息查询管理系统</h2><br>           
       <table align="center" style="border:1px solid">  
         <tr>  
            <td><font color="blue"><b>账 号：</b></font></td>  
            <td><input name="lname" type="text"> </td>  
         </tr>  
         <tr>  
            <td><font color="blue"><b>密 码：</b></font></td>  
            <td><input name="pwd" type="password" size="20"> </td>  
         </tr>  
         <tr>  
            <td></td>  
            <td><input type="button" value="登  录" onclick="login()">  
                  
             <input type="button" value="立即注册" onclick="register()">    
            </td>            
         </tr>  
       </table>            
     </form>  
</body>
<script language="javascript">
	window.onload = function(){
		var msg = "${msg}";
		if(msg != ""){
			window.alert(msg);
		}
	}
	function login(){  
        if(document.loginform.lname.value==""){  
          window.alert("账号不能为空！");  
          return ;  
        }  
        if(document.loginform.pwd.value==""){  
          window.alert("密码不能为空！");  
          return ;  
        }  
        loginform.submit(); 
        }
	function register(){  
        document.loginform.method="post";  
        document.loginform.target="rightframe";  
        document.loginform.action="<%=request.getContextPath() %>/Info/insert";  
        document.loginform.submit();  
    }  

</script>
</html>