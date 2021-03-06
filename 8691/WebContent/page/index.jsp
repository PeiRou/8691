<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Homepage</title>
	<link rel="apple-touch-icon" href="<%= request.getContextPath() %>/images/logo.png">
	<link rel="icon" href="<%= request.getContextPath() %>/images/logo.png">
</head>
<body>
<fmt:setBundle basename="Message" var="bundle" />
<h3><fmt:message key="index.welcome" bundle="${bundle}" /> ${user.RoleID}</h3>

<h3><a href="<c:url value="/page/login.jsp" />">Login</a></h3>
<h3><a href="<c:url value="/page/register.jsp" />">會員註冊</a></h3>
<h3><a href="<c:url value="/page/visitor.jsp" />">店家註冊(訪客)</a></h3>
<h3><a href="<c:url value="/page/logout.jsp"  />">登出</a></h3>
<h3><a href="<c:url value="index.jsp" /> ">回首頁</a></h3>

</body>
</html>