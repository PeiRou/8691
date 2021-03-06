<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">    
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>8691忘記密碼</title>

    <!-- Bootstrap Core CSS -->
    <link href="<%= request.getContextPath() %>/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="<%= request.getContextPath() %>/css/business-casual.css" rel="stylesheet">

    <!-- Fonts -->
    <link href="http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800" rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/css?family=Josefin+Slab:100,300,400,600,700,100italic,300italic,400italic,600italic,700italic" rel="stylesheet" type="text/css">

    <link rel="apple-touch-icon" href="<%= request.getContextPath() %>/images/logo.png">
	<link rel="icon" href="<%= request.getContextPath() %>/images/logo.png">
</head>
<body>
<jsp:include page="/fragment/top.jsp" />
	<div class="container">
		<div class="row">
			<div class="box"><div class="col-lg-12 text-center"><h2>密碼修改成功，請登入使用本系統！</h2></div></div>
		</div>
		<div class="row">
			<div class="box">		
				<div class="col-lg-12 text-center">
					<form action="<c:url value="/_02_Login/login.controller" />" method="post" >
					<h2 class="intro-text text-center">					
					帳號 :<input type="text" name="acc_email"	value="${param.acc_email}"></h2>
					<h5 class="intro-text text-center">${error.acc_email}</h5>
					<h2 class="intro-text text-center">
					密碼 :<input type="password" name="psd" value="${param.psd}"></h2>
					<h5 class="intro-text text-center" class="red">${error.psd}${error.loginfail}</h5>
<%-- 					<h5 class="intro-text text-center">${error.loginfail}</h5> --%>
                    <div class="checkbox">
			          	<label><input type="checkbox"> Remember me</label>
			        </div>
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input class="btn btn-primary" type="submit" value="登入">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <input class="btn btn-primary" type="button" value="註冊" onclick="location.href='<%= request.getContextPath() %>/_01_Register/SelectRegister.jsp'">                     
                </form>
					

				</div>
			</div>			
		</div>
	</div>
	<!-- /.container -->

    <footer>
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <p>Copyright &copy; Your Website 2016</p>
                </div>
            </div>
        </div>
    </footer>

    <!-- jQuery -->
    <script src="<%= request.getContextPath() %>/js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="<%= request.getContextPath() %>/js/bootstrap.min.js"></script>
</body>
</html>