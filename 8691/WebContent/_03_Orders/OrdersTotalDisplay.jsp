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
					<%-- <h3>Select Product Table Result : ${fn:length(select)} row(s) selected</h3> --%>
					<c:if test="${not empty select}">
					<table class="table">
						<thead>
						<tr class="text-center">
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