<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>visitor page</title>
</head>

<body>

	<h1>店家訪客</h1>

	<form name="Visitor"
		action="<c:url value='/page/visitor.controller' />" method="post">

		<table>
			<tr>
				<td>輸入您的統一編號 :</td>
				<td><input type="text" name="FEIN" value="${param.FEIN}"></td>
				<td></td>
			</tr>
		
			<tr>
				<td>輸入您的店家名稱 :</td>
				<td><input type="text" name="name" value="${param.name}"></td>
				<td></td>
			</tr>
			<tr>
				<td>輸入您的帳號/email :</td>
				<td><input type="text" name="acc_email"
					value="${param.acc_email}"></td>
				<td></td>
			</tr>
			<tr>
				<td>輸入您的密碼 :</td>
				<td><input type="text" name="psd" value="${param.psd}"></td>
				<td></td>
			</tr>
			<tr>
				<td>輸入您的連絡市話  :</td>
				<td><input type="text" name="phone" value="${param.phone}"></td>
				<td></td>
			</tr>
			<tr>
				<td>輸入您的地址 :</td>
				<td><input type="text" name="acc_email"
					value="${param.acc_email}"></td>
				<td></td>
			</tr>
			<tr>
				<td>輸入您的備用 email :</td>
				<td><input type="text" name="email2" value="${param.email2}"></td>
				<td></td>
			</tr>
			<tr>
				<td>輸入聯絡人姓名 :</td>
				<td><input type="text" name="Con_name" value="${param.name}"></td>
				<td></td>
			</tr>
			<tr>
				<td>輸入連絡人手機 :</td>
				<td><input type="text" name="cellphone"
					value="${param.cellphone}"></td>
				<td></td>
			</tr>
			<tr>

				<td align="right"><input type="submit" value="註冊"></td>
			</tr>
		</table>
	</form>

</body>
</html>