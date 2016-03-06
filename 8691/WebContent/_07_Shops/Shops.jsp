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
<style>
	.customer-font {
		font-weight: bold; 
		font-size: 20px;
	}
</style>
<body>
	<jsp:include page="/fragment/top.jsp" />
	<div class="container">
		<ul class="nav nav-tabs customer-font">
  			<li class="active"><a href="#">菜單</a></li>
  			<li><a href="#">評論</a></li>
  			<li><a href="#">資訊</a></li>
		</ul>
		<div class="menu">
			<div class="box">
				<div class="col-lg-10 text-center">
				<h4>${StoreUID}</h4>
				<table id="prodTable" class="table table-striped table-hover dataTable" cellspacing="0" >
					<thead>
						<tr class="customer-font">
							<th>商品名稱</th>
							<th>價格</th>
							<th>商品副選項</th>
							<th>商品明細</th>
						</tr>
					</thead>
					<tbody style="text-align: left;" class="customer-font">
					</tbody>
				</table>
				</div>
				<div class="col-lg-2 text-center">
				</div>
			</div>
		</div>
	</div>
	<!-- /.container -->
	
	<div id="editDialog" class="">
	</div>
	
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
	<script src="<%= request.getContextPath() %>/js/jquery.dataTable.min.js"></script>
	<script src="<%= request.getContextPath() %>/js/jquery-ui.min.js"></script>
	
    <!-- Bootstrap Core JavaScript -->
    <script src="<%= request.getContextPath() %>/js/bootstrap.min.js"></script>
    <!-- Json -->
    <script src="<%= request.getContextPath() %>/js/json.js"></script>
</body>
<script type="text/javascript">
$(document).ready(function() {
	//var prodInfo = JSON.parse(JSON.stringify(${prodInfo}));
	
	var data = [{"FoodPrice":[{"FoodSizePriceID":"1","SizeStatusID":"2","FoodID":"1","SizeStatus":[{"SizeStatusID":"2","SizeName":"小"}],"FoodStatusPrice":"40"},{"FoodSizePriceID":"2","SizeStatusID":"3","FoodID":"1","SizeStatus":[{"SizeStatusID":"3","SizeName":"中"}],"FoodStatusPrice":"45"}],"GroupClass3ID":"1","FoodID":"1","ProdStatusClass1ID":"1","AccountUID":"6D4B16EF-F830-4374-AF0B-8E19EA997D5F","FoodPhoto":"","FoodName":"珍珠奶茶"}, {"FoodPrice":[{"FoodSizePriceID":"7","SizeStatusID":"1","FoodID":"4","SizeStatus":[{"SizeStatusID":"1","SizeName":"預設"}],"FoodStatusPrice":"50"}],"GroupClass3ID":"1","FoodID":"4","ProdStatusClass1ID":"1","AccountUID":"6D4B16EF-F830-4374-AF0B-8E19EA997D5F","FoodPhoto":"","FoodName":"奶茶"}, {"FoodPrice":[{"FoodSizePriceID":"8","SizeStatusID":"1","FoodID":"5","SizeStatus":[{"SizeStatusID":"1","SizeName":"預設"}],"FoodStatusPrice":"45"}],"GroupClass3ID":"1","FoodID":"5","ProdStatusClass1ID":"1","AccountUID":"6D4B16EF-F830-4374-AF0B-8E19EA997D5F","FoodPhoto":"","FoodName":"豆漿紅茶"}, {"FoodPrice":[{"FoodSizePriceID":"9","SizeStatusID":"1","FoodID":"6","SizeStatus":[{"SizeStatusID":"1","SizeName":"預設"}],"FoodStatusPrice":"60"}],"GroupClass3ID":"1","FoodID":"6","ProdStatusClass1ID":"1","AccountUID":"6D4B16EF-F830-4374-AF0B-8E19EA997D5F","FoodPhoto":"","FoodName":"綠茶"}, {"FoodPrice":[],"GroupClass3ID":"2","FoodID":"7","ProdStatusClass1ID":"1","AccountUID":"6D4B16EF-F830-4374-AF0B-8E19EA997D5F","FoodPhoto":"","FoodName":"沙士"}, {"FoodPrice":[],"GroupClass3ID":"2","FoodID":"8","ProdStatusClass1ID":"1","AccountUID":"6D4B16EF-F830-4374-AF0B-8E19EA997D5F","FoodPhoto":"","FoodName":"青茶"}, {"FoodPrice":[],"GroupClass3ID":"2","FoodID":"9","ProdStatusClass1ID":"1","AccountUID":"6D4B16EF-F830-4374-AF0B-8E19EA997D5F","FoodPhoto":"","FoodName":"烏龍綠茶"}];
    var prodInfo = JSON.parse(JSON.stringify(data));
    
	$('#prodTable').DataTable({
		data:prodInfo,
		columns: 
			[
	            { data: "FoodName" },
	            { data: "FoodPrice[ / ].FoodStatusPrice",},
	            { data: function(prodInfo) { 
	            	var temp = '<input type="button" value="+" class="btn btn-primary "';
	            	temp = temp.concat('onclick="doModify(\'');
	            	temp = temp.concat(prodInfo.FoodName);
	            	temp = temp.concat('\')"');
	            	temp = temp.concat(' id="');
	            	temp = temp.concat(prodInfo.FoodID);
	            	temp = temp.concat('" >');
	            	temp = temp.concat('</input>');
	            	
	            	return temp;
	            	}
	            },
	            { data: function() {
	            	var temp = '';
	            	
	            	return temp;
	            	}
	            }
	        ],
	});
	
			
});

function doModify(FoodName) {
	$('div[id="editDialog"]').dialog({
		modal : true,
		minHeight : 700,
		minWidth : 730,
		maxWidth : 730,
		title : FoodName,
		buttons: {
			"送出" : function() {
				$(this).dialog('close');
			}
		},
		create: function(event, ui) {
	        var widget = $(this).dialog("widget");
	        $(".ui-dialog-titlebar-close", widget).removeClass()
	        	.addClass('ui-state-default ui-dialog-titlebar-close')
	        	.append('<span class="ui-button-icon-primary ui-icon ui-icon-closethick"></span>')
	    }
	})
	console.log(FoodName);
}

</script>
</html>