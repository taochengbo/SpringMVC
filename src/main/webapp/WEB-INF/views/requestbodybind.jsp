<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
	<script src="<%=path%>/js/jquery-2.1.0.min.js"></script>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<%=path %>||<%=basePath %>
	
	<fieldset id="login" style="width:600px; border:1px solid #000;border-left:none;border-right:none">   
		<legend style="">用户登录</legend>   
		<p align="center">账号：<input type="text" name="username" /></p>   
		<p align="center">密码：<input type="password" name="password" /></p>   
		<p align="center"><input type="submit" id="submit1" value="登录1" /></p>  
		<p align="center"><input type="submit" id="submit2" value="登录2" /></p> 
	</fieldset>
	
	<script type="text/javascript">
		$(function() {
			$("#submit1").click(function() {
				var json = {
			         'username':$(':input[name=username]').val(),
			         'password':$(':input[name=password]').val()
			    };
				//json字符串 {"username":"admin","password":"123456"}
			    var postdata = JSON.stringify(json);
			    alert(postdata);
			    $.ajax({
			        type : 'POST',
			        contentType : 'application/json',
			        /**
                     *(默认: true) 默认情况下，通过data选项传递进来的数据，如果是一个对象(技术上讲只要不是字符串)，
                     * 都会处理转化成一个查询字符串，以配合默认内容类型 "application/x-www-form-urlencoded"。
                     * 如果要发送 DOM 树信息或其它不希望转换的信息，请设置为 false。
                     */
			        processData : false,
			        url : '<%=path%>/databind/requestbodybind',
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
			
			//400 Bad Request, application/json数据发送后台接收必须是Model对象，不能是单个属性
			$("#submit2").click(function() {
				var json = {
					'username':$(':input[name=username]').val(),
				    'password':$(':input[name=password]').val()
			    };
				//json字符串 {"username":"admin","password":"123456"}
			    var postdata = JSON.stringify(json);
			    $.ajax({
			        type : 'POST',
			        contentType : 'application/json',
			        processData : false,
			        url : '<%=path%>/databind/requestbodybind2',
			        dataType : 'json',
			        data : postdata,
			        success : function(data) {
			            alert('username : '+data.username+'\npassword : '+data.password);
			        }
			    }); 
			});
			
	    });
	</script> 
</body>
</html>