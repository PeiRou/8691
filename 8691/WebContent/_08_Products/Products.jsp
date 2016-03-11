<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>About - Business Casual - Start Bootstrap Theme</title>

<!-- Bootstrap Core CSS -->
<link href="<%= request.getContextPath() %>/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom CSS -->
<link href="<%= request.getContextPath() %>/css/business-casual.css"
	rel="stylesheet">

<!-- Fonts -->
<link
	href="http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800"
	rel="stylesheet" type="text/css">
<link
	href="http://fonts.googleapis.com/css?family=Josefin+Slab:100,300,400,600,700,100italic,300italic,400italic,600italic,700italic"
	rel="stylesheet" type="text/css">


</head>
<body>
	<jsp:include page="/fragment/top.jsp" />

	<div class="container">
		<div class="row">
			<div class="box">
				<div class="col-lg-3 text-left">
					<div class="input-group">
						<input type="text" class="form-control"> <span
							class="input-group-btn">
							<button class="btn btn-default" type="button">Go!</button>
						</span>
					</div>
					<div class="btn-group">
						<button class="btn btn-default btn-lg dropdown-toggle"
							type="button" data-toggle="dropdown" aria-expanded="false">
							分類搜尋 <span class="caret"></span>
						</button>
						<ul class="dropdown-menu" role="menu">
							<li>
								<c:url value="/_08_GetStore/Store.controller" var="Oderby"></c:url>
								<a href="${Oderby}?orderby=1">評價</a></li>
							<li><a href="${Oderby}?orderby=2">最低消費</a></li>
							<li><a href="${Oderby}?orderby=3">運費</a></li>
						</ul>
					</div>
				</div>
				<div class="col-lg-9">				
					<c:set value="${select}" var="ShopStaus"></c:set>
					<input id="hidShopStaus" type="hidden" value='${ShopStaus}' />
					<table class="table">
						<c:forEach var="bean" items="${ShopStaus}">
							<tr>
								<td class="col-lg-3" rowspan="2">
								<c:choose>
										<c:when test="${bean.GroupClass3!='[]'}">										
										<img style="width: 100%" src="<%=request.getContextPath()%>${bean.imageStatus[0].ImageURL}">
										</c:when>
										<c:otherwise>
										<img style="width: 100%" src="<%=request.getContextPath()%>/image/store/1.png">
										</c:otherwise>
									</c:choose> 
									</td>
								<td class="text-left">		
									<h4>${bean.Name}</h4>
								</td>
								<td>
									
								</td>
							</tr>
							<tr>
								<td class="text-left">								
								<c:choose>
										<c:when test="${bean.GroupClass3!='[]'}">
										<h6>
											<c:forEach var="GroupClass3" items="${bean.GroupClass3}"
												varStatus="loop">								
												${GroupClass3.ProdStatusClass1Name}
												<c:if test="${!loop.last}">,</c:if>
											</c:forEach>
											</h6>
										</c:when>
										<c:otherwise>
										資料建置中
										</c:otherwise>
									</c:choose><br>
									<c:forEach var="j" begin="0" end="4"
										varStatus="status">
										<%--<c:when test="${j<=countstar}"> --%>
										<c:choose>
											<c:when test="${j<=3}">
												<span class="btn-warning glyphicon glyphicon-star"
													aria-hidden="true"></span>
											</c:when>
											<c:otherwise>
												<span class="glyphicon glyphicon-star-empty"
													aria-hidden="true"></span>
											</c:otherwise>
										</c:choose>
									</c:forEach>
									<table class="table">
										<tr>
											<td>平均外送時間</td>
											<td>外送費</td>
											<td>最低餐點金額</td>
										</tr>
										<tr>
											<td>50分鐘</td>
											<td>${bean.ShipPrice}元</td>
											<td>${bean.LowestPrice}元</td>
										</tr>
									</table>
									
								</td>
								
								<td class="text-left">
									<c:url value="/_07_Shops/Shops.controller" var="path">
										<c:param name="AccountUID" value="${bean.AccountUID}" />
									</c:url>
									<a class="btn btn-success" href="${path}">瀏覽菜單</a>
								</td>
							</tr>
						</c:forEach>
					</table>
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
	<script type="text/javascript">
	$('.dropdown-toggle').dropdown();
	</script>
</body>
</html>