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
		table, th, td {
		    border: 0px solid black;
		    border-collapse: collapse;
		}
		th, td {
		    padding: 25px;
		    text-align: center;
		}
	</style>
</head>
<body>
<jsp:include page="/fragment/top.jsp" />
	<div class="container">
		<div class="row">
			<div class="box">		
				<div class="col-lg-12 text-center">
					<h2>親愛的會員您好</h2>
					<!-- json -->
					<table id="memberTable"
						class="table table-striped table-hover dataTable" cellspacing="100">
						<thead>
							<tr class="customer-font">
								<th>會員名稱</th>
								<th>電話</th>
								<th>手機</th>
								<th>住址(縣/市)</th>
								<th>住址(區)</th>
								<th>住址(路)</th>
								<th>住址(號)</th>
								<th>備用email</th>
							</tr>
						</thead>
<!-- 						<tbody style="text-align: left;" class="customer-font"> -->
<!-- 						</tbody> -->
					</table>
					<c:set value="${select}" var="MemberStaus"></c:set>
					<input id="hidMemberStaus" type="hidden" value='${MemberStaus}' />
				</div>
				<!-- 2個按鈕 -->
				<form action="<c:url value="/MemberServlet" />" method="post" >
				<input class="btn btn-primary" type="button" value="點我改資料" onclick="location.href='<%= request.getContextPath() %>/_04_Members/InfoUpdate.jsp'">
				</form>
				<form action="<c:url value='/_03_Orders/OrdersTotalServlet' />" method="post">
				<input class="btn btn-primary" type="submit" name="orderaction" value="查看我的訂單">
				</form>
				<!-- 2個按鈕 -->
				<!--<img class="img-responsive img-border " width="450px" height="450px" src="img/ilovefood.jpg" alt="">-->
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

    <!-- Bootstrap Core JavaScript -->
    <script src="<%= request.getContextPath() %>/js/bootstrap.min.js"></script>
    
    Json
    <script src="<%= request.getContextPath() %>/js/json.js"></script>
    
    <!-- jQuery -->
    <script src="<%= request.getContextPath() %>/js/jquery.js"></script>
    <script src="<%= request.getContextPath() %>/js/jquery.dataTable.min.js"></script>
	<script src="<%= request.getContextPath() %>/js/jquery-ui.min.js"></script>
	
</body>
<script type="text/javascript">
$(document).ready(function() {	
	var data = $('#hidMemberStaus').val();	
	//var data = '[{"guarNO":"6號2樓","lowestPrice":"10","receiptsMetho":"3","sellerStatus":"2","conName":"50blue","fein":"88888888","shipPrice":"100","guarCT":"臺北市","guarAR":"100","email2":"50@50.com","conCel":"0912345678","name":"50嵐","sellerPhoto":null,"tel":"098777","guarROAD":"1000","insdate":"2016-03-02"}]';
	var prodInfo = JSON.parse(data);
	console.log(data)
	$('#memberTable').DataTable({
		data:prodInfo,
		columns: 
			[
				{ data: "name"},
				{ data: "tel"},
				{ data: "cel"},
				{ data: "guarCT"},
				{ data: "guarAR"},
				{ data: "guarROAD"},
				{ data: "guarNO"},
				{ data: "email2"}
	        ],
	});
});
 </script>

</html>