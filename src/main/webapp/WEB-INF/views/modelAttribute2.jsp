<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>注册</title>
</head>
<body>
	<fieldset id="login" style="width:600px; border:1px solid #000;border-left:none;border-right:none">   
		<legend style="">注册</legend>
		<form action="<%=path %>/modelAttribute2password" method="post">
		<p align="center">密码：<input type="text" name="password" /></p>   
		<p align="center"><input type="submit"  value="注册" /></p>  
		</form>
	</fieldset>
</body>
</html>