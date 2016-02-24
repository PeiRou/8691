<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<!-- <link rel="stylesheet" type="text/css" href="../css/main.css" /> -->

<title>訂單資訊</title>
<script type="text/javascript">
function clearForm() {
	var inputs = document.getElementsByTagName("input");
	for(var i=0; i<inputs.length; i++) {
		if(inputs[i].type=="text") {
			inputs[i].value="";
		}
	}
}
</script>
</head>
<body>

<%-- <h3>Welcome ${user.custid}</h3> --%>

<h3>訂單資訊</h3>

<form action="<c:url value='/_03_Orders/OrdersTotalServlet' />" method="post">
<table>
	<tr>
		<td>訂單編號 : </td>
		<td><input type="text" name="ordersID" value="${param.ordersID}"></td>
		<td>${error.ordersID}</td>
	</tr>
	<tr>
		<td>訂購人姓名 : </td>
		<td><input type="text" name="name" value="${param.name}"></td>
		<td>${error.name}</td>
	</tr>

	<tr>
		<td>訂購人手機 : </td>
		<td><input type="text" name="cel" value="${cel.cel}"></td>
		<td>${error.cel}</td>
	</tr>
	<tr>
		<td>住址(縣/市) : </td>
		<td><input type="text" name="GUAR_CT" value="${param.GUAR_CT}"></td>
		<td>${error.GUAR_CT}</td>
	</tr>
	<tr>
		<td>住址(區/鄉/鎮/市) : </td>
		<td><input type="text" name="GUAR_AR" value="${param.GUAR_AR}"></td>
		<td>${error.GUAR_AR}</td>
	</tr>
		<tr>
		<td>住址(路/街/巷) : </td>
		<td><input type="text" name="GUAR_ROAD" value="${param.GUAR_ROAD}"></td>
		<td>${error.GUAR_ROAD}</td>
	</tr>
		<tr>
		<td>住址(號) : </td>
		<td><input type="text" name="GUAR_NO" value="${param.GUAR_NO}"></td>
		<td>${error.GUAR_NO}</td>
	</tr>
		<tr>
		<td>付款方式 : </td>
		<td>	
		<select name="pay_metho" value="${param.pay_metho}">
        <option value="0">貨到付款</option>
        <option value="1">信用卡</option></select>
        </td>
		<td>${error.pay_metho}</td>
	</tr>
	

	
	<tr>
		<td>
			<input type="submit" name="orderaction" value="Insert">
			<input type="submit" name="orderaction" value="Update">
		</td>
		<td>
			<input type="submit" name="orderaction" value="Delete">
			<input type="submit" name="orderaction" value="Select">
			<input type="button" value="Clear" onclick="clearForm()">
		</td>
	</tr>
</table>

</form>

<h3><span class="error">${error.action}</span></h3>

<c:if test="${not empty delete and delete}">
<h3>Delete Product Table Success</h3>
<script type="text/javascript">clearForm();</script>
</c:if>

<c:if test="${not empty insert}">
<h3>Insert Product Table Success</h3>
<table border="1">
	<tr><td>訂單編號 :</td><td>${insert.ordersID}</td></tr>
	<tr><td>訂購人姓名 :</td><td>${insert.name}</td></tr>
	<tr><td>訂購人手機 :</td><td>${insert.cel}</td></tr>
	<tr><td>住址(縣/市) :</td><td>${insert.GUAR_CT}</td></tr>
	<tr><td>住址(區/鄉/鎮/市) :</td><td>${insert.GUAR_AR}</td></tr>
	<tr><td>住址(路/街/巷) :</td><td>${insert.GUAR_ROAD}</td></tr>
	<tr><td>住址(號) :</td><td>${insert.GUAR_NO}</td></tr>
	<tr><td>付款方式 :</td><td>${insert.pay_metho}</td></tr>
</table>
<script type="text/javascript">clearForm();</script>
</c:if>

<c:if test="${not empty update}">
<h3>Update Product Table Success</h3>
<table border="1">
	<tr><td>訂單編號 :</td><td>${update.ordersID}</td></tr>
	<tr><td>訂購人姓名 :</td><td>${update.name}</td></tr>
	<tr><td>訂購人手機 :</td><td>${update.cel}</td></tr>
	<tr><td>住址(縣/市) :</td><td>${update.GUAR_CT}</td></tr>
	<tr><td>住址(區/鄉/鎮/市) :</td><td>${update.GUAR_AR}</td></tr>
	<tr><td>住址(路/街/巷) :</td><td>${update.GUAR_ROAD}</td></tr>
	<tr><td>住址(號) :</td><td>${update.GUAR_NO}</td></tr>
	<tr><td>付款方式 :</td><td>${update.pay_metho}</td></tr>
</table>
<script type="text/javascript">clearForm();</script>
</c:if>

</body>
</html>