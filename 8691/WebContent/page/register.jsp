<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>register page</title>
</head>

<body>

	<h1>Register</h1>

	<form name="Register"
		action="<c:url value='/page/register.controller' />" method="post">

		<table>
			<tr>
				<td>Enter your name :</td>
				<td><input type="text" name="name" value="${param.name}"></td>
				<td></td>
			</tr>
			<tr>
				<td>Enter your email/Account :</td>
				<td><input type="text" name="acc_email"
					value="${param.acc_email}"></td>
				<td></td>
			</tr>
			<tr>
				<td>Enter your password :</td>
				<td><input type="text" name="psd" value="${param.psd}"></td>
				<td></td>
			</tr>
			<tr>
				<td>Set your gender :</td>
				<td><select name="gender" size="1" value="${param.gender}">
						<option value="male">公</option>
						<option value="female"selected>母</option>
				</select></td>
				<td></td>
			</tr>

			<tr>
				<td>Enter your home-phone number :</td>
				<td><input type="text" name="phone" value="${param.phone}"></td>
				<td></td>
			</tr>
			<tr>
				<td>Enter your cell-phone number :</td>
				<td><input type="text" name="cellphone"
					value="${param.cellphone}"></td>
				<td></td>
			</tr>
			<tr>
				<td>Enter your Address :</td>
				<td><input type="text" name="acc_email"
					value="${param.acc_email}"></td>
				<td></td>
			</tr>
			<tr>
				<td>Enter your backup email :</td>
				<td><input type="text" name="email2" value="${param.email2}"></td>
				<td></td>
			</tr>
			<tr>

				<td align="right"><input type="submit" value="Register"></td>
			</tr>
		</table>
	</form>

</body>
</html>