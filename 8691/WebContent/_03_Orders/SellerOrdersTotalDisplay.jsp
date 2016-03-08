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
	<style>
    
    	th{
    		font-size:1em;
    		text-align:center;
    	}
    	
    	td{
    		font-size:1em;
    	}
    	table#t01 tr:nth-child(even) {
		    background-color: #fff;
		}
		table#t01 tr:nth-child(odd) {
		   background-color:#eee;
		}
    </style>
    
</head>
<body>
<jsp:include page="/fragment/top.jsp" />
	<div class="container">
		<div class="row">
			<div class="box">		
				<div class="col-lg-12 text-center">
				<form action="<c:url value='/_03_Orders/SellerOrdersTotalServlet' />" method="post" >
					<c:if test="${not empty select}">
					<table id="t01" class="table">
						<thead>
						<tr class="text-center">
							<th>訂單編號</th>
							<th>訂購人姓名</th>
							<th>手機</th>
							<th>住址(縣/市)</th>
							<th>(區/鄉/鎮)</th>
							<th>(路/街/巷)</th>
							<th>(號)</th>
							<th>付款方式</th>
							<th>運費</th>
							<th>價格</th>
							<th>總金額</th>
							<th>訂單狀態</th>
							<th>訂單明細</th>
						</tr>
						</thead>
						<tbody>
						<jsp:useBean id="hugeStick" scope="page" class="_07_Address.model.AddressJDBC"/>
						<c:forEach var="bean" items="${select}">
							<c:url value="/_03_Orders/UpdateOrdersTotal.jsp" var="path">
								<c:param name="ordersID" value="${bean.ordersID}" />
								<c:param name="name" value="${bean.name}" />
								<c:param name="cel" value="${bean.cel}" />
								<c:param name="GUAR_CT" value="${bean.GUAR_CT}" />
								<c:param name="GUAR_AR" value="${bean.GUAR_AR}" />
								<c:param name="GUAR_ROAD" value="${bean.GUAR_ROAD}" />
								<c:param name="GUAR_NO" value="${bean.GUAR_NO}" />
								<c:param name="pay_metho" value="${bean.pay_metho}" />
								<c:param name="ship_price" value="${bean.ship_price}" />
								<c:param name="food_price" value="${bean.food_price}" />
								<c:param name="total_amount" value="${bean.total_amount}" />
								<c:param name="status" value="${bean.status}" />
							</c:url>
						<tr>
							<td><a href="${path}">${bean.ordersID}</a></td>
							<td>${bean.name}</td>
							<td>${bean.cel}</td>
							<td>${hugeStick.findGUAR_CT_nameByAddress_CT(bean.GUAR_CT).getGUAR_CT_name()}</td>
							<td>${hugeStick.findGUAR_AR_nameByAddress_AR(bean.GUAR_AR).getGUAR_AR_name()}</td>
							<td>${hugeStick.findGUAR_ROAD_nameByAddress_ROAD(bean.GUAR_ROAD).getGUAR_ROAD_name()}</td>
							<td>${bean.GUAR_NO}</td>
							<td>${bean.pay_metho}</td>
							<td>${bean.ship_price}</td>
							<td>${bean.food_price}</td>
							<td>${bean.total_amount}</td>
							<td>${bean.status}</td>
							<td>
							<c:url value="/_03_Orders/SellerOrdersDetailServlet" var="GetDetailPath">
								<c:param name="ordersID" value="${bean.ordersID}" />
								<c:param name="action" value="訂單明細" />
							</c:url>
							<a class="btn btn-success" href="${GetDetailPath}">訂單</a>
							</td>
						</tr>
					</c:forEach>	
						</tbody>
					</table>
					</c:if>
					</form>
					<input class="btn btn-primary" type="button" value="上一頁" onclick="location.href='<%= request.getContextPath() %>/_04_Members/SellerMembers.jsp'">
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