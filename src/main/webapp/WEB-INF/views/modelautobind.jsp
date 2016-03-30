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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form:form modelAttribute="account" method="post"> 	
		用户名：<form:input path="username"/><br/>
		密 码：<form:password path="password"/><br/>
		<input type="submit" value="Submit" />
	</form:form>
	<hr>
	<form action="<%=path%>/databind/modelautobind2" method="post">
		用户名：<input type="text" name="username"><br/>
		密 码：<input type="password" name="password"><br/>
		<input type="submit" value="Submit" />
	</form>
	<hr>
	<a href="<%=path%>/databind/modelautobind2?username=admin&password=123456">link</a>
</body>
</html>