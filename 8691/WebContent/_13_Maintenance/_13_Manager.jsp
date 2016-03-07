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
    
    <!-- jquery.css -->
    
    <link href="<%= request.getContextPath() %>/css/jquery.dataTable.min.css" rel="stylesheet">
    <link href="<%= request.getContextPath() %>/css/jquery-ui/jquery-ui.min.css" rel="stylesheet">    
</head>
<body>
<jsp:include page="/fragment/top.jsp" />
	<div class="container">
		<div class="row">
			<div class="box">
				<div class="col-lg-12 text-center">
					<table id="vistorTable"
						class="table table-striped table-hover dataTable" cellspacing="0">
						<thead>
							<tr class="customer-font">
								<th>店家名稱</th>
								<th>是否審核</th>
								<th>店家狀態</th>
								<th>申請日期</th>
								<th>店家資訊</th>
							</tr>
						</thead>
						<tbody style="text-align: left;" class="customer-font">
						</tbody>
					</table>
					<c:set value="${select}" var="VistorStaus"></c:set>
					<input id="hidVistorStaus" type="hidden" value='${VistorStaus}' />
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

    <!-- Bootstrap Core JavaScript -->
    <script src="<%= request.getContextPath() %>/js/bootstrap.min.js"></script>
    
    <!-- Json -->
    <script src="<%= request.getContextPath() %>/js/json.js"></script>
    
    <!-- jQuery -->
    <script src="<%= request.getContextPath() %>/js/jquery.js"></script>
    <script src="<%= request.getContextPath() %>/js/jquery.dataTable.min.js"></script>
	<script src="<%= request.getContextPath() %>/js/jquery-ui.min.js"></script>
</body>
<script type="text/javascript">
$(document).ready(function() {
	//var data = JSON.parse(JSON.stringify(${'#hidVistorStaus'}.val()));
	
	var data = [{"isCheck":"0","sellerSstatus":"0","name":"小隻老","insdate":"2016-03-07","accountUID":"A6105F1F-80A1-459C-B5D3-420BCDBED06A"}, {"isCheck":"0","sellerSstatus":"0","name":"000","insdate":"2016-03-07","accountUID":"1A91A662-869A-4EFA-9DC2-BD519AD8C710"}, {"isCheck":"0","sellerSstatus":"0","name":"1111","insdate":"2016-03-07","accountUID":"359FD003-1052-481F-9BD2-DE90E1F60329"}];
	var prodInfo = JSON.parse(JSON.stringify(data));
	
	$('#vistorTable').DataTable({
		data:prodInfo,
		columns: 
			[
	            { data: "name" },
	           // { data: "isCheck" },
	            { data: function(prodInfo){
	            	var temp = '<form><input type="radio" name="rdoIsCheck" value="0" checked> 否';
	            	temp = temp.concat('<input type="radio" name="rdoIsCheck" value="1">是</form>');
	            	return temp;
	            } },
	            { data: "sellerSstatus" },
	            { data: "insdate" },
	            { data: function(prodInfo){
	            	var url = "<%= request.getContextPath() %>";
	            	var acc = prodInfo.accountUID;
	            	console.log(acc);
	            	var temp = '<a class="btn btn-primary" href="'+url+'/_13_Maintenance/_13_SellerInfor.jsp?accountUID='+ acc +'">按我看店家資訊</a>';	            	
	            	return temp;
	            }}
	            //{ data: "accountUID" }	            
	        ],
	});
		
});	


</script>
</html>