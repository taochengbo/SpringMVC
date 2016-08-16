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
			
			<%-- $("#submit").click(function(){   
			        /* 序列化表单的值username=admin&password=123456 */
	                var params = $("#login").serialize();
	                alert(params);
					$.ajax({
						type: "POST",
						url:  '<%=path%>/databind/responsebodybind',
						dataType: "json",
						data: params,
						success: function(data){
							 alert('username : '+data.username+'\npassword : '+data.password);
						}
					});                
			}); --%>
			
			/*username=admin&password=123456 */
			$("#submit1").click(function(){
                 $.ajax({
                     type: "POST",
                     /* contentType : 'application/x-www-form-urlencoded',*/
                     url:  '<%=path%>/databind/responsebodybind',
                     dataType: "json",
                     data: {username:$("#login :input[name=username]").val(),
                    	 password:$("#login :input[name=password]").val()},
                     success: function(data){
                          alert('username : '+data.username+'\npassword : '+data.password);
                     }
                 }); 
            });
			/*username=admin&password=123456 */
			$("#submit2").click(function(){
                 $.ajax({
                     type: "POST",
                     /* contentType : 'application/x-www-form-urlencoded',*/
                     url:  '<%=path%>/databind/responsebodybind2',
                     dataType: "json",
                     data: {username:$("#login :input[name=username]").val(),
                    	 password:$("#login :input[name=password]").val()},
                     success: function(data){
                          alert('username : '+data.username+'\npassword : '+data.password);
                     }
                 }); 
            });
	    });
	</script> 
</body>
</html>