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
		<p align="center"><input type="submit" id="submit3" value="登录3" /></p> 
	</fieldset>
	
	<script type="text/javascript">
		$(function() {
			
			<%-- $("#submit").click(function(){   
			        /* 序列化表单的值username=admin&password=123456 */
	                var params = $("#login").serialize();
	                alert(params);
					$.ajax({
						type: "POST",
						url:  '<%=path%>/response/responsebodybind',
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
                     url:  '<%=path%>/response/responsebodybind',
                     dataType: "xml",
                     data: {username:$("#login :input[name=username]").val(),
                    	 password:$("#login :input[name=password]").val()},
                     success: function(data){
                    	  $(data).find("Account").each(function(i){
                    		  alert('username : '+$(this).find("username").text()+'\npassword : '+ $(this).find("password").text());
                    	  });
                          
                     }
                 }); 
            });
			/*username=admin&password=123456 */
			$("#submit2").click(function(){
                 $.ajax({
                     type: "POST",
                     /* contentType : 'application/x-www-form-urlencoded',*/
                     url:  '<%=path%>/response/responsebodybind2',
                     dataType: "json",
                     data: {username:$("#login :input[name=username]").val(),
                    	 password:$("#login :input[name=password]").val()},
                     success: function(data){
                          alert('username : '+data.username+'\npassword : '+data.password);
                     }
                 }); 
            });
			$("#submit3").click(function(){
				$.ajax({
		             type: "get",
		             async: false,
		             url:  '<%=path%>/response/responsebodybind3',
		             dataType: "jsonp",
		             jsonp: "callback",//传递给请求处理程序或页面的，用以获得jsonp回调函数名的参数名(一般默认为:callback)
		             jsonpCallback:"callback",//自定义的jsonp回调函数名称，默认为jQuery自动生成的随机函数名
		             success: function(data){
		            	 alert('username : '+data.username+'\npassword : '+data.password);
		             },
		             error: function(){
		                 alert('fail');
		             }
		         });
           });
	    });
	</script> 
</body>
</html>