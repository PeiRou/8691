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
<jsp:include page="/fragment/top.jsp" />
	<div class="container">
		<div class="row">
			<div class="box">		
				<div class="col-lg-12">
					<h2 class="text-center">訂單資訊</h2>
					<form action="<c:url value='/_03_Orders/OrdersTotalServlet' />" method="post">
					<table class="table">
						<tr>
							<td class="text-right">訂單編號 : </td>
							<td><input type="text" name="ordersID" value="${param.ordersID}"></td>
							<td>${error.ordersID}</td>
						</tr>
						<tr>
							<td class="text-right">訂購人姓名 : </td>
							<td><input type="text" name="name" value="${param.name}"></td>
							<td>${error.name}</td>
						</tr>
					
						<tr>
							<td class="text-right">訂購人手機 : </td>
							<td><input type="text" name="cel" value="${cel.cel}"></td>
							<td>${error.cel}</td>
						</tr>
						<tr>
							<td class="text-right">住址(縣/市) : </td>
							<td><input type="text" name="GUAR_CT" value="${param.GUAR_CT}"></td>
							<td>${error.GUAR_CT}</td>
						</tr>
						<tr>
							<td class="text-right">住址(區/鄉/鎮/市) : </td>
							<td><input type="text" name="GUAR_AR" value="${param.GUAR_AR}"></td>
							<td>${error.GUAR_AR}</td>
						</tr>
							<tr>
							<td class="text-right">住址(路/街/巷) : </td>
							<td><input type="text" name="GUAR_ROAD" value="${param.GUAR_ROAD}"></td>
							<td>${error.GUAR_ROAD}</td>
						</tr>
							<tr>
							<td class="text-right">住址(號) : </td>
							<td><input type="text" name="GUAR_NO" value="${param.GUAR_NO}"></td>
							<td>${error.GUAR_NO}</td>
						</tr>
							<tr>
							<td class="text-right">付款方式 : </td>
							<td>	
							<select name="pay_metho" value="${param.pay_metho}">
							<option value="">請選擇</option>
					        <option value="0">貨到付款</option>
					        <option value="1">信用卡</option></select>
					        </td>
							<td>${error.pay_metho}</td>
						</tr>
							<tr>
							<td class="text-right">測試用自己輸入(運費): </td>
							<td><input type="text" name="ship_price" value="${param.ship_price}"></td>
							<td>${error.ship_price}</td>
						</tr>
							<tr>
							<td class="text-right">測試用自己輸入(食物金額): </td>
							<td><input type="text" name="food_price" value="${param.food_price}"></td>
							<td>${error.food_price}</td>
						</tr>
							<tr>
							<td class="text-right">測試用自己輸入(總金額): </td>
							<td><input type="text" name="total_amount" value="${param.total_amount}"></td>
							<td>${error.total_amount}</td>
						</tr>
						
					
						
						<tr>
							<td class="text-right">
								<input type="submit" name="orderaction" value="Insert">
								<input type="submit" name="orderaction" value="Update">
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
						<tr><td>運費 :</td><td>${insert.ship_price}</td></tr>
						<tr><td>食物金額 :</td><td>${insert.food_price}</td></tr>
						<tr><td>總金額 :</td><td>${insert.total_amount}</td></tr>
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
						<tr><td>運費 :</td><td>${update.ship_price}</td></tr>
						<tr><td>食物金額 :</td><td>${update.food_price}</td></tr>
						<tr><td>總金額 :</td><td>${update.total_amount}</td></tr>
					</table>
					<script type="text/javascript">clearForm();</script>
					</c:if>
	

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