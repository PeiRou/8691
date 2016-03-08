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
	<title>修改訂單資訊</title>
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
					<h2>修改訂單資訊</h2>
					<form action="<c:url value='/_03_Orders/SellerOrdersTotalServlet' />" method="post">
					<jsp:useBean id="hugeStick" scope="page" class="_07_Address.model.AddressJDBC"/>
					<table id="t01" class="table">
						<tr>
							<td class="text-right">訂單編號 : </td>
							<td>${param.ordersID}</td>
						</tr>
						<tr>
							<td class="text-right">訂購人姓名 : </td>
							<td>${param.name}</td>
						</tr>
						<tr>
							<td class="text-right">訂購人手機 : </td>
							<td>${param.cel}</td>
						</tr>
						<tr>
							<td class="text-right">住址(縣/市) : </td>
							<td>${hugeStick.findGUAR_CT_nameByAddress_CT(param.GUAR_CT).getGUAR_CT_name()}</td>
						</tr>
						<tr>
							<td class="text-right">住址(區/鄉/鎮/市) : </td>
							<td>${hugeStick.findGUAR_AR_nameByAddress_AR(param.GUAR_AR).getGUAR_AR_name()}</td>
						</tr>
							<tr>
							<td class="text-right">住址(路/街/巷) : </td>
							<td>${hugeStick.findGUAR_ROAD_nameByAddress_ROAD(param.GUAR_ROAD).getGUAR_ROAD_name()}</td>
						</tr>
							<tr>
							<td class="text-right">住址(號) : </td>
							<td>${param.GUAR_NO}</td>
						</tr>
							<tr>
							<td class="text-right">付款方式 : </td>
							<td>${param.pay_metho}</td>
						</tr>
							<tr>
							<td class="text-right">修改運費 :</td>
							<td><input type="text" name="ship_price" value="${param.ship_price}"></td>
							<td>${error.ship_price}</td>
						</tr>
							<tr>
							<td class="text-right">修改食物金額 :</td>
							<td><input type="text" name="food_price" value="${param.food_price}"></td>
							<td>${error.food_price}</td>
						</tr>
							<tr>
							<td class="text-right">修改總金額 :</td>
							<td><input type="text" name="total_amount" value="${param.total_amount}"></td>
							<td>${error.total_amount}</td>
						</tr>
							<tr>
							<td class="text-right">修改訂單狀態 :</td>
							<td>
							<select name="status" value="${param.status}">
							<option value="處理中" selected>處理中</option>
					        <option value="已出貨">已出貨</option>
					        </select></td>
					    </tr>
						
						<tr class="text-right">
							<td class="text-right">
								<input class="btn btn-success" type="submit" name="orderaction" value="更新訂單">
								<input class="btn btn-danger" type="submit" name="orderaction" value="刪除訂單">
								<input class="btn btn-warning" type="button" value="清空" onclick="clearForm()">
							</td>
						</tr>
					</table>
					
					</form>
					
					<h3><span class="error">${error.action}</span></h3>
					
					<c:if test="${not empty delete and delete}">
					<h3>Delete Product Table Success</h3>
					<script type="text/javascript">clearForm();</script>
					</c:if>
					
<%-- 					<c:if test="${not empty insert}"> --%>
<!-- 					<h3>Insert Product Table Success</h3> -->
<!-- 					<table border="1"> -->
<%-- 						<tr><td>訂單編號 :</td><td>${insert.ordersID}</td></tr> --%>
<%-- 						<tr><td>訂購人姓名 :</td><td>${insert.name}</td></tr> --%>
<%-- 						<tr><td>訂購人手機 :</td><td>${insert.cel}</td></tr> --%>
<%-- 						<tr><td>住址(縣/市) :</td><td>${insert.GUAR_CT}</td></tr> --%>
<%-- 						<tr><td>住址(區/鄉/鎮/市) :</td><td>${insert.GUAR_AR}</td></tr> --%>
<%-- 						<tr><td>住址(路/街/巷) :</td><td>${insert.GUAR_ROAD}</td></tr> --%>
<%-- 						<tr><td>住址(號) :</td><td>${insert.GUAR_NO}</td></tr> --%>
<%-- 						<tr><td>付款方式 :</td><td>${insert.pay_metho}</td></tr> --%>
<%-- 						<tr><td>運費 :</td><td>${insert.ship_price}</td></tr> --%>
<%-- 						<tr><td>食物金額 :</td><td>${insert.food_price}</td></tr> --%>
<%-- 						<tr><td>總金額 :</td><td>${insert.total_amount}</td></tr> --%>
<!-- 					</table> -->
<!-- 					<script type="text/javascript">clearForm();</script> -->
<%-- 					</c:if> --%>
					
					<c:if test="${not empty update}">
					<h3>更新成功</h3>
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
						<tr><td>金額 :</td><td>${update.food_price}</td></tr>
						<tr><td>總金額 :</td><td>${update.total_amount}</td></tr>
						<tr><td>訂單狀態 :</td><td>${update.status}</td></tr>
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