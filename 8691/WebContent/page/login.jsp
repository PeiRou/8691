<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" type="text/css" href="" />

<title>Login</title>
</head>
<body>

<h3>Login</h3>

<form action="<c:url value="/page/login.controller" />" method="get">
<table>
	<tr>
		<td>Email : </td>
		<td><input type="text" name="acc_email" value="${param.acc_email}"></td>
		<td>${error.acc_email}</td>
	</tr>
	<tr>
		<td>Password : </td>
		<td><input type="text" name="psd" value="${param.psd}"></td>
		<td>${error.psd}</td>
	</tr>
	<tr>
		<td>　</td>
		<td align="right"><input type="submit" value="Login"></td>
	</tr>
</table>
</form>

</body>
</html>