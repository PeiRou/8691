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

.checkbox-font {
	margin-top:0px;
	height: 32px;
	display: inline-block;
	padding: 0 0 0 0px;
}

input[type=checkbox] {
	display: none;
}

input[type=checkbox]+label {
	background:  url(../image/icon/blank-check-box.png) no-repeat;
	height: 32px;
	width: 75px;
	display: inline-block;
	padding: 0 0 0 40px;
	margin-left: 25px;
}

input[type=checkbox]:checked+label {
	background: url(../image/icon/check-box.png) no-repeat;
	height: 32px;
	width: 75px;
	display: inline-block;
	padding: 0 0 0 40px;
	margin-left: 25px;
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
    <footer>
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <p>Copyright &copy; Your Website 2016</p>
                </div>
            </div>
        </div>
    </footer>
    
	<div id="editDialog" style="display: none">
		<form>
			<div>
				<p>
					<label for="spinner"> 數量 : </label> 
					<input id="spinner"name="value">
				</p>
			</div>
			<div class="ui-dialog-buttonpane ui-widget-content ui-helper-clearfix">
				<div>
					<label class="customer-font">冷熱調整 </label>
				</div>
				<div>
					<div>
						<input type='checkbox' name='thing' value='valuable' id="ice0"/>
						<label for="ice0" class="">去冰</label>
						<input type='checkbox' name='thing' value='valuable' id="ice1"/>
						<label for="ice1" class="">微冰</label>
						<input type='checkbox' name='thing' value='valuable' id="ice2"/>
						<label for="ice2" class="">少冰</label>
						<input type='checkbox' name='thing' value='valuable' id="ice3"/>
						<label for="ice3" class="">正常</label>
					</div>
					<div>
						
					</div>
				</div>
			</div>
		</form>
	</div>

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

//商品副選項資料送出
function customerProdInfoSubmit() {
	alert("");
}

//開啟Dialog 
function doModify(FoodName) {
	$('div[id="editDialog"]').dialog({
		modal : true,
		minHeight : 700,
		minWidth : 730,
		maxWidth : 730,
		show: { effect: "slideDown", duration: 300 },
		hide: { effect: "slideUp", duration: 200 },
		title : FoodName,
		buttons: [{
			text: function() {
				$(this).hover(function() {
					$( this ).addClass("ui-state-hover");
				},
				function() {
					$( this ).removeClass("ui-state-hover");
				});
				$(this).append('<span class="ui-button-text">送出</span>');
			},
			class: "ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only",
		    click: function() {
		    	customerProdInfoSubmit();
		    	$(this).dialog("close");
		    }
		}],
		
	});
	console.log(FoodName);
	$('.ui-dialog-title').addClass('customer-font');
	var spinner = $("#spinner").spinner().css('width','50px');;
	$('.ui-spinner').css('width','80px');
	
	
}

</script>
</html>