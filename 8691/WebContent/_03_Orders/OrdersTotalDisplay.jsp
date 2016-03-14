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

    <title>8691訂單資訊</title>

    <!-- Bootstrap Core CSS -->
    <link href="<%= request.getContextPath() %>/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="<%= request.getContextPath() %>/css/business-casual.css" rel="stylesheet">

    <!-- Fonts -->
    <link href="http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800" rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/css?family=Josefin+Slab:100,300,400,600,700,100italic,300italic,400italic,600italic,700italic" rel="stylesheet" type="text/css">
	<style>
    
    	th{
    		font-size:1em;
    		text-align:center;
    	}
    	
    	td{
    		font-size:1em;
    	}
    
    </style>
    <link rel="apple-touch-icon" href="<%= request.getContextPath() %>/images/logo.png">
	<link rel="icon" href="<%= request.getContextPath() %>/images/logo.png">
</head>
<body>
<jsp:include page="/fragment/top.jsp" />
	<div class="container">
		<div class="row">
			<div class="box">		
				<div class="col-lg-12 text-center">
				<form action="<c:url value='/_03_Orders/OrdersDetailServlet' />" method="post" >
					<%-- <h3>Select Product Table Result : ${fn:length(select)} row(s) selected</h3> --%>
					<c:if test="${not empty select}">
					<table class="table">
						<thead>
						<tr class="text-center">
							<th>訂單編號</th>
							<th>訂購人姓名</th>
							<th>訂購店家</th>
							<th>手機</th>
							<th>住址(縣/市)</th>
							<th>(區/鄉/鎮)</th>
							<th>(路/街/巷)</th>
							<th>(號)</th>
							<th>付款方式</th>
							<th>運費</th>
							<th>食物金額</th>
							<th>總金額</th>
							<th>訂單明細</th>
						</tr>
						</thead>
						<tbody>
						<jsp:useBean id="hugeStick" scope="page" class="_07_Address.model.AddressJDBC"/>
						<jsp:useBean id="hugeStick2" scope="page" class="_03_Orders.model.OrdersTotalJDBC"/>
						<c:forEach var="bean" items="${select}">
						<tr>
							<td>${bean.ordersID}</td>
							<td>${bean.name}</td>
							<td>${hugeStick2.findNameBySellerPartner(bean.seller_UID).getName()}</td>
							<td>${bean.cel}</td>
							<td>${hugeStick.findGUAR_CT_nameByAddress_CT(bean.GUAR_CT).getGUAR_CT_name()}</td>
							<td>${hugeStick.findGUAR_AR_nameByAddress_AR(bean.GUAR_AR).getGUAR_AR_name()}</td>
							<td>${hugeStick.findGUAR_ROAD_nameByAddress_ROAD(bean.GUAR_ROAD).getGUAR_ROAD_name()}</td>
							<td>${bean.GUAR_NO}</td>
							<td>${bean.pay_metho}</td>
							<td>${bean.ship_price}</td>
							<td>${bean.food_price}</td>
							<td>${bean.total_amount}</td>
<!-- 							<td><input class="btn btn-primary" type="submit" name="orderaction" value="訂單明細"></td> -->
							<td>
							<c:url value="/_03_Orders/OrdersDetailServlet" var="GetDetailPath">
								<c:param name="ordersID" value="${bean.ordersID}" />
								<c:param name="action" value="明細" />
							</c:url>
							<a class="btn btn-success" href="${GetDetailPath}">明細</a>
							</td>
						</tr>
					</c:forEach>	
						</tbody>
					</table>
					</c:if>
					</form>
					<c:url value="/MemberServlet" var="GetMemberPath"></c:url>
					<a class="btn btn-primary" href="${GetMemberPath}">上一頁</a>

				</div>
			</div>			
		</div>
	</div>
	<!-- /.container -->

    <footer>
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <p>Copyright &copy; EEIT83第五小組 2016 | <a href="<%= request.getContextPath() %>/contact.jsp">聯絡我們</a></p>
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