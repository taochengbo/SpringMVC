<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
		<p align="center"><input type="submit" id="submit2" value="登录2" /></p>  
		<p align="center"><input type="submit" id="submit3" value="登录3" /></p>  
	</fieldset>
	
	<script type="text/javascript">
		$(function() {
			$("#submit").click(function() {
				var json = {
			         'username':$('#username').val(),
			         'password':$('#password').val()
			    };
				//json字符串 {"username":"admin","password":"123456"}
			    var postdata = JSON.stringify(json);
			    $.ajax({  
			        type : 'POST',  
			        contentType : 'application/json',
			        /**
                     *(默认: true) 默认情况下，通过data选项传递进来的数据，如果是一个对象(技术上讲只要不是字符串)，
                     * 都会处理转化成一个查询字符串，以配合默认内容类型 "application/x-www-form-urlencoded"。
                     * 如果要发送 DOM 树信息或其它不希望转换的信息，请设置为 false。
                     */
			        processData : false,
			        url : '<%=basePath%>databind/requestbodybind',
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
			        /* 序列化表单的值username=admin&password=123456 */
	                var params = $("#login").serialize();
	                alert(params);
					$.ajax({
						type: "POST",
						url:  '<%=basePath%>databind/json',
						dataType: "json",
						data: params,
						success: function(data){
							 alert('username : '+data.username+'\npassword : '+data.password);
						}
					});                
			});
			
			//@RequestParam 接收传 json对象
			/*username=admin&password=123456 */
			$("#submit3").click(function(){
                 $.ajax({
                     type: "POST",
                     /* contentType : 'application/x-www-form-urlencoded',*/
                     url:  '<%=basePath%>databind/json',
                     dataType: "json",
                     data: {'username':$("#login :input[name=username]").val(),
                    	 'password':$("#login :input[name=password]").val()},
                     success: function(data){
                          alert('username : '+data.username+'\npassword : '+data.password);
                     }
                 }); 
            });
	    });
	</script> 
</body>
</html>