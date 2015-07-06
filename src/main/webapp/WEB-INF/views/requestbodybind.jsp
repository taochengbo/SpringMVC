<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>

<script src="<%=basePath%>js/jquery-2.1.0.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form:form modelAttribute="account" method="post"> 	
		账 号  ：<form:input path="username"/><br/><br/>
		密 码  ：<form:password path="password"/><br/>
		<input type="button" id="submit" value="Submit" />
	</form:form>
	
	<fieldset id="login" style="width:600px; border:1px solid #000;border-left:none;border-right:none">   
		<legend style="">用户登录</legend>   
		<p align="center">账号：<input type="text" name="username" /></p>   
		<p align="center">密码：<input type="password" name="password" /></p>   
		<p align="center"><input type="submit" id="submit2" value="登录" /></p>   
	</fieldset>
	
	<script type="text/javascript">
		$(function() {
			$("#submit").click(function() {   
	            var postdata = '{"username":"' + $('#username').val() + '","password":"' + $('#password').val() + '"}';   
			    $.ajax({  
			        type : 'POST',  
			        contentType : 'application/json',  
			        url : '<%=basePath%>databind/requestbodybind',
			        processData : false,  
			        dataType : 'json',  
			        data : postdata,  
			        success : function(data) {  
			            alert('username : '+data.username+'\npassword : '+data.password);  
			        },  
			        error : function() {  
			            alert('error...');  
			        }  
			    }); 
			});
			$("#submit2").click(function(){   
	               // 序列化表单的值
	                var params = $("#login").serialize();//username=admin&password=123456
					$.ajax({
						// 数据发送方式
						type: "POST",
						// 后台处理程序
						url:  '<%=basePath%>databind/requestbodybind',
						// 接受数据格式
						dataType: "JSON",
						// 要传递的数据
						data: params,
						success: function(data){
							 alert('username : '+data.username+'\npassword : '+data.password);
						}
					});                
			});   
	    });
	</script> 
</body>
</html>