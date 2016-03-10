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
								<th>統一編號</th>
								<th>店家名稱</th>
								<th>電話</th>
								<th>住址(縣/市)</th>
								<th>住址(區/鄉/鎮/市)</th>
								<th>住址(路)</th>
								<th>住址(號)</th>
								<th>聯絡人</th>
								<th>聯絡人手機</th>
								<th>收款方式(0:貨到付款,1:信用卡,3:都有)</th>
								<th>是否審核(0:未審核,1:已審核</th>
								<th>是否為合作店家(0:否,1:是)</th>
								<th>運費</th>
								<th>最低金額</th>
								<th>新增日期</th>
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
                    <p>Copyright &copy; EEIT83第五小組 2016 | <a href="<%= request.getContextPath() %>/contact.jsp">聯絡我們</a></p>
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
	var data = $('#hidVistorStaus').val();	
	//var data = '';
	var prodInfo = JSON.parse(data);
	
	$('#vistorTable').DataTable({
		data:prodInfo,
		columns: 
			[
	            { data: "fein"},
				{ data: "name"},
				{ data: "tel"},
				{ data: "guarCT"},
				{ data: "guarAR"},
				{ data: "guarROAD"},
				{ data: "guarNO"},
				{ data: "conName"},
				{ data: "conCel"},
				//{ data: "receiptsMetho"},
				{ data: function(prodInfo){
					var receiptsMetho = parseInt(prodInfo.receiptsMetho);
					var temp;
					switch(receiptsMetho) {
				    case 0:				        
				    	temp = "貨到付款";
				    	break;
				    case 1:				        
				    	temp = "信用卡";
				    	break;
				    case 3:
				    	temp = "都有";
				    	break;
				    default:
				    	temp = "啊!錯了";
				    	break;
				    }
					var temphtml = '<a class="btn btn-primary">'+temp+'</a>';
					return temphtml;
				}},
				{ data: "sellerStatus"},
				{ data: "shipPrice"},
				{ data: "lowestPrice"},
				{ data: "insdate"}	            
	        ],
	});
		
});	


</script>
</html>