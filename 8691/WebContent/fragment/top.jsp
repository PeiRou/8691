<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- jQuery -->
    <script src="<%= request.getContextPath() %>/js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="<%= request.getContextPath() %>/js/bootstrap.min.js"></script>
<div class="brand">巴豆揪么  8691</div>
    <div class="address-bar">就是要吃喝之美食飲料訂購網站</div>

    <!-- Navigation -->
    <nav class="navbar navbar-default" role="navigation">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <!-- navbar-brand is hidden on larger screens, but visible when the menu is collapsed -->
                <a class="navbar-brand" href="index.jsp">Business Casual</a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li>
                        <a href="<%= request.getContextPath() %>/index.jsp">首頁</a>
                    </li>
                    <li>
                        <a href="<%= request.getContextPath() %>/about.jsp">店家</a>
                    </li>
                    <li>
                    <c:url value="/_08_Products/product.controller" var="path"></c:url>
                        <a href="${path}">我要訂餐</a>
                    </li>
                    <li>
                        <a href="<%= request.getContextPath() %>/_04_Members/Members.jsp">會員中心</a>
                    </li>
                    <li>
                        <a href="<%= request.getContextPath() %>/_05_Forum/Forum.jsp">留言板</a>
                    </li>
                    <li><c:choose>
                    	<c:when test="${empty LoginOK }">
                        <a href="<%= request.getContextPath() %>/_02_Login/Login.jsp">登入</a>
                    	</c:when>
                    	<c:otherwise>                    	
                        <a href="<%= request.getContextPath() %>/_02_Login/Logout.jsp">登出</a>
                    	</c:otherwise>              
                    
                        </c:choose>
                    </li>
                    
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>