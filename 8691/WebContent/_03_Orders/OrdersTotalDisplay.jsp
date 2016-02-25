<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>OrdersTotalDisplay</title>
</head>
<body>

<%-- <h3>Select Product Table Result : ${fn:length(select)} row(s) selected</h3> --%>
<c:if test="${not empty select}">
<table>
	<thead>
	<tr>
		<th>訂單編號</th>
		<th>訂購人姓名</th>
		<th>訂購人手機</th>
		<th>住址(縣/市)</th>
		<th>住址(區/鄉/鎮/市)</th>
		<th>住址(路/街/巷)</th>
		<th>住址(號)</th>
		<th>付款方式</th>
	</tr>
	</thead>
	<tbody>
	<c:forEach var="bean" items="${select}">
<%-- 		<c:url value="/_03_Orders/OrdersTotal.jsp" var="path"> --%>
<%-- 			<c:param name="Orders_ID" value="${bean.Orders_ID}" /> --%>
<%-- 			<c:param name="name" value="${bean.name}" /> --%>
<%-- 			<c:param name="cel" value="${bean.cel}" /> --%>
<%-- 			<c:param name="GUAR_CT" value="${bean.GUAR_CT}" /> --%>
<%-- 			<c:param name="GUAR_AR" value="${bean.GUAR_AR}" /> --%>
<%-- 			<c:param name="GUAR_ROAD" value="${bean.GUAR_ROAD}" /> --%>
<%-- 			<c:param name="GUAR_NO" value="${bean.GUAR_NO}" /> --%>
<%-- 			<c:param name="pay_metho" value="${bean.pay_metho}" /> --%>
<%-- 		</c:url> --%>
	<tr>
		<td>${bean.ordersID}</td>
		<td>${bean.name}</td>
		<td>${bean.cel}</td>
		<td>${bean.GUAR_CT}</td>
		<td>${bean.GUAR_AR}</td>
		<td>${bean.GUAR_ROAD}</td>
		<td>${bean.GUAR_NO}</td>
		<td>${bean.pay_metho}</td>
	</tr>
	</c:forEach>	
	</tbody>
</table>
</c:if>

<h3><a href="<c:url value="/_03_Orders/OrdersTotal.jsp" />">OrdersTotal Table</a></h3>
</body>
</html>