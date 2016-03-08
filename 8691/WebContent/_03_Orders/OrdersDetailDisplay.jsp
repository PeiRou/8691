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

    <title>About - Business Casual - Start Bootstrap Theme</title>

    <!-- Bootstrap Core CSS -->
    <link href="<%= request.getContextPath() %>/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="<%= request.getContextPath() %>/css/business-casual.css" rel="stylesheet">

    <!-- Fonts -->
    <link href="http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800" rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/css?family=Josefin+Slab:100,300,400,600,700,100italic,300italic,400italic,600italic,700italic" rel="stylesheet" type="text/css">

    
</head>
<body>
<jsp:include page="/fragment/top.jsp" />
	<div class="container">
		<div class="row">
			<div class="box">		
				<div class="col-lg-12 text-center">
				<c:if test="${not empty select}">
					<table class="table">
						<thead>
						<tr class="text-center">
								<th>訂單編號</th>
								<th>品名</th>
								<th>數量</th>
								<th>價格</th>
								<th>備註</th>
						</tr>
						</thead>
						<tbody>
						<c:forEach var="bean" items="${select}">
						<tr>
							<td>${bean.ordersID}</td>
							<td>${bean.Drink_name}</td>
							<td>${bean.quantity}</td>
							<td>${bean.originalPrice}</td>
							<td>${bean.note}</td>
						</tr>
					</c:forEach>	
						</tbody>
					</table>
					</c:if>
					<input class="btn btn-primary" type="button" value="上一頁" onclick="location.href='<%= request.getContextPath() %>/_04_Members/Members.jsp'">
<%-- 					<h3><a href="<c:url value="/_03_Orders/OrdersTotal.jsp" />">OrdersTotal Table</a></h3> --%>


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