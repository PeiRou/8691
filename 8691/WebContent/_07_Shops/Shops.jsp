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

    <title>8691菜單</title>

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
    <link rel="apple-touch-icon" href="<%= request.getContextPath() %>/images/logo.png">
	<link rel="icon" href="<%= request.getContextPath() %>/images/logo.png">	
</head>
<style>

.prod-car {
	background-color: #FFFFFF;
}

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

.errText {
	font-weight: bold;
	font-size: 16px;
	color: red;
	letter-spacing: 3px;
}

input[type=checkbox] {
	display: none;
}

input[type=checkbox]+label {
	background:  url(../image/icon/square_blank.png) no-repeat;
	height: 32px;
	width: 120px;
	display: inline-block;
	padding: 0 0 0 28px;
	margin-left: 0px;
}

input[type=checkbox]:checked+label {
	background: url(../image/icon/sign.png) no-repeat;
	height: 32px;
	width: 120px;
	display: inline-block;
	padding: 0 0 0 28px;
	margin-left: 0px;
}

td.details-control {
	background: url('<%= request.getContextPath() %>/images/details_open.png') no-repeat center center;
	cursor: pointer;
}
	
tr.shown td.details-control {
	background: url('<%= request.getContextPath() %>/images/details_close.png') no-repeat center
		center;
}
</style>
<body>
	<jsp:include page="/fragment/top.jsp" />
	<div class="container">
		<ul class="nav nav-tabs customer-font">
  			<li class="active"><a href="#">菜單</a></li>
		</ul>
		<div class="menu">
			<div class="box">
			
				<!-- 商品 -->
				<div class="col-lg-9 text-center">
					<h4>${SellerName}</h4>
					<table id="prodTable" class="table table-striped table-hover dataTable" cellspacing="0" >
						<thead>
							<tr class="customer-font">
								<th>商品名稱</th>
								<th>價格</th>
								<th>副選項</th>
								<th>商品明細</th>
							</tr>
						</thead>
						<tbody style="text-align: left;" class="customer-font">
						</tbody>
					</table>
				</div>
				
				<!-- 訂單 -->
				<div class="col-lg-3 text-center">
					<div class="prod-car" id="carDiv">
						<label class="customer-font">
							<span class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span>
							您的訂單
						</label>
						<table id="prodCar" style="font-size: 15px; font-weight: bold; text-align: left;" width=100%>
<!-- 							<thead style="font-size: 18px; font-weight: bold; text-align: left;"></thead> -->
							<tr>
								<td  colspan="2"><hr></td>
							</tr>
							<tr>
								<td>總金額:</td>
								<td><label id=lblsum></label><input type="hidden" id=hidsum></td>
							</tr>
							<tr>
								<td  colspan="2" class="text-center"><a class="btn btn-primary btnpay">結帳</a></td>
							</tr>
						</table>
					</div>
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
    
	<div id="editDialog" style="display: none">
		<form>
			<div>
				<p>
					<label for="spinner"> 數量 : </label> 
					<input id="spinner" name="prodAmount" value="0">
					<span id="errorText" class="errText"></span>
				</p>
			</div>
		</form>		
		<div id=divimg></div>
		<table id="editDialogTable" style="width: 100%" class="table table-striped table-hover dataTable " cellspacing="0">
		</table>
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
var prodInfo = JSON.parse(JSON.stringify(${prodInfo}));
var SzSts = ${selectSzSts};
var jsonSzSts = JSON.parse(JSON.stringify(SzSts));

$(document).ready(function() {
	console.log(prodInfo);
	$('#prodTable').DataTable({
		data:prodInfo,
		"columnDefs": [
		               { "width": "20%", "targets": 0 },
		               { "width": "20%", "targets": 1 },
		               { "width": "20%", "targets": 2 },
		               { "width": "40%", "targets": 3 },
		   		],    
		columns: 
			[
	            { data: "FoodName" },
	            { data: "FoodPrice[ / ].FoodStatusPrice" },
	            { data: function(prodInfo) { 
	            	var temp = '<input type="button" value="+" class="btn btn-primary customer-font "';
	            	
	            	var foodPrice = prodInfo.FoodPrice[0].FoodStatusPrice;
	            	var foodPriceArray = prodInfo.FoodPrice;
	            	
	            	if(foodPriceArray.length >= 2) {
	            		var foodPrice2 = prodInfo.FoodPrice[1].FoodStatusPrice;
	            	}
	            		
	            	temp = temp.concat('onclick="doModify(\'');
	            	temp = temp.concat(prodInfo.FoodName);
	            	temp = temp.concat("','foodID" + prodInfo.FoodID);
	            	temp = temp.concat("','" + prodInfo.GroupClass3ID);
	            	temp = temp.concat("','" + foodPrice);
	            	temp = temp.concat("','" + foodPrice2);
	            	temp = temp.concat('\')"');
	            	temp = temp.concat(' id="');
	            	temp = temp.concat(prodInfo.FoodID);
	            	temp = temp.concat('" >');
	            	temp = temp.concat('</input>');
	            	
	            	return temp;
	            	}
	            },
	            { data: function(prodInfo) {
	            	var temp = '<span style="font-size: 16px" id="foodID';
	            	
	            	temp = temp.concat(prodInfo.FoodID);
	            	temp = temp.concat('"></span>');
	            	
	            	return temp;
	            	}
	            }
	        ],
	});
	
	var sellerInfo = JSON.parse(JSON.stringify(${SellerInfo}));
	
});

//商品副選項資料送出 → 加入購物車
function customerProdInfoSubmit(FoodName, foodId, prodPrice, prodPrice2) {
	var customerProdArray = new Array();
	var prodName = FoodName;
	var jsonObj;	
	
	$("#" + foodId).text("");
	
	$('#editDialogTable :checked').each(function() {
		jsonObj = JSON.parse($(this).val());
		
		$("#" + foodId).append(jsonObj.ProdStatusClass3Name + "  /  ");
		
		customerProdArray.push(jsonObj);
	});
	
	jsonObj = customerProdArray;
	
	var prodAmount = $('input[name=prodAmount]').val();
	var total = prodAmount*prodPrice;
	console.log(total);
	
	var prodCarTable = $('#prodCar').DataTable({
		"bPaginate": false,
        "bFilter": false,
        "bInfo": false,
        "data": jsonObj,
        "language": {
            "emptyTable": "無調整"
         },
        "columnDefs": [
            { "width": "40%", "targets": 0 },
			{ "title": FoodName + "  X  " + prodAmount + "  =  $ " + total, "targets": 0 },
         ],
        columns: [
			{data: 'ProdStatusClass3Name', "targets": 0},
	         ],
	});
	
	$('#carDiv').append("<span>test</span>");
}

//確認清單
function checkCumsterInfo() {
	var prodAmount =  $('input[name=prodAmount]').val();
	var reg = /^[0-9]*$/;
	
	if(prodAmount <= 0 || !reg.test(prodAmount)) {
		$('#errorText').text("商品數量錯誤");
		
		return false;
	}
	
	var iceChecked = $('#editDialogTable tbody tr:first :checked').length;
	
	if(iceChecked > 1) {
		$('#errorText').text("冷熱調整請擇一");
		
		return false;
	}
	
	var sugarChecked = $('#editDialogTable tbody tr:last :checked').length;
	
	if(iceChecked > 1) {
		$('#errorText').text("甜度調整請擇一");
		
		return false;
	}
	
	return true;
}

//開啟Dialog 
function doModify(FoodName, foodId, groudId, prodPrice, prodPrice2) {
	var prodName = FoodName;
	
	//console.log("foodId:"+foodId);
	var leth = foodId.length;
	var tmpfoodId = foodId.substring(6,leth);
	var FoodPrice;
	$.each(prodInfo,function(inx,prodInfoVal){
		if(prodInfoVal.FoodID==tmpfoodId){	
			var tmpRdo = ('<form>');
			$.each(prodInfoVal.FoodPrice,function(inx,FoodPriceVal){	
				tmpRdo = tmpRdo.concat('<label class="btn btn-default">');
				console.log(FoodPriceVal.FoodSizePriceID,FoodPriceVal.SizeStatusID);
				var sel = '<select id=sel'+ FoodPriceVal.FoodSizePriceID +' disabled="true">';
				$.each(jsonSzSts,function(index,Sizeval){
					if(Sizeval.SizeStatusID==FoodPriceVal.SizeStatusID){
						console.log(111);
						sel = sel.concat('<option value="'+Sizeval.SizeStatusID+'" selected>'+Sizeval.SizeName+'</option>');
					}
				});
				sel = sel.concat('</select>');
				tmpRdo = tmpRdo.concat('<input type="radio" name="location" value="'+FoodPriceVal.FoodStatusPrice+'" checked>'+sel+FoodPriceVal.FoodStatusPrice+'<br>');
				tmpRdo = tmpRdo.concat('</label>');
			});
			tmpRdo = tmpRdo.concat('</form>');
			console.log(tmpRdo);
			$('#divimg').html(tmpRdo);			
		}
	});
	
	$('div[id="editDialog"]').dialog({
		modal : true,
		minHeight : 700,
		minWidth : 730,
		maxWidth : 730,
		show: { effect: "slideDown", duration: 300 },
		hide: { effect: "slideUp", duration: 200 },
		title : FoodName,
		close: function(event, ui) {
            $(this).dialog("close");
            $('#errorText').text("");
        },
		buttons: [{
			text: function() {
				$(this).hover(function() {
					$(this).addClass("ui-state-hover");
				},
				function() {
					$(this).removeClass("ui-state-hover");
				});
				$(this).append('<span class="ui-button-text">送出</span>');
			},
			class: "ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only",
		    click: function() {
		    	if(!checkCumsterInfo()) {
		    		return;
		    	}
		    		
		    	shopSubmit(tmpfoodId,FoodName);
		    	
		    	$(this).dialog("close");
		    	$('#editDialogTable :checked').prop('checked',false);
		    	$('#errorText').text("");
		    }
		}],
	});
	
	$('.ui-dialog-title').addClass('customer-font');
	var spinner = $("#spinner").spinner().css('width','50px');;
	$('.ui-spinner').css('width','80px');
	
	genEditTable(groudId);
}
var totalSum = 0;
function shopSubmit(tmpfoodId,FoodName){
	var tmpcel ='<tr>';
	tmpcel = tmpcel.concat('<td>'+FoodName+':</td>');
	tmpcel = tmpcel.concat('<td>'+$('input[name=location]:checked').val()+'</td>');
	var prodAmount = $('input[name=prodAmount]').val();
	var prodPrice =$('input[name=location]:checked').val();
	var total = prodAmount*prodPrice;
	console.log(prodAmount,total);
	tmpcel = tmpcel.concat('</tr>');
	$("input:checkbox:checked").each(function(index,value){
		var tmp = JSON.parse($(this).val());
		console.log("ProdStatusClass3Price:"+tmp.ProdStatusClass3Price);
		console.log(index,value);

		tmpcel = tmpcel.concat('<tr>');
		tmpcel = tmpcel.concat('<td><span class="glyphicon glyphicon-plus" aria-hidden="true"></span>'+tmp.ProdStatusClass3Name+':</td>');
		tmpcel = tmpcel.concat('<td>'+tmp.ProdStatusClass3Price+'</td>');
		tmpcel = tmpcel.concat('</tr>');
		
		totalSum = totalSum+parseInt(tmp.ProdStatusClass3Price);
	});
	totalSum = totalSum+total;
	console.log("totalSum:"+totalSum);
	$('#prodCar').prepend(tmpcel).prepend;
	$('#lblsum').text(totalSum);
	$('#hidsum').val(totalSum);
}

//dialog裡的datatable
function genEditTable(groupId) {
	var editDialogTable = $('#editDialogTable').DataTable({
		"bDestroy": true,
		"bPaginate": false,
        "bFilter": false,
        "bInfo": false,
    	"ajax": {
            'type': 'POST',
            'url': '/8691/_10_Menu/GetC1C2.controller',
            'data': {GroupID: groupId}
            },
        "columnDefs": [
            { "width": "32%", "targets": 0 }
		],    
        columns: [
            { "data": "ProdStatusClass2Name" },
            { "data": function(data) {
            	var temp = '<div>';
            	
            	$.each(data.Class3Status, function(index, Class3Status) {
            		var celClass3ID = Class3Status.ProdStatusClass3ID;
            		var	celPrice = Class3Status.ProdStatusClass3Price;
            		var	celName = Class3Status.ProdStatusClass3Name;
            		var prodJsonValue = JSON.stringify(Class3Status); 
            		
            		var celchk = '<input type="checkbox"';
            		celchk = celchk.concat('value=\'' + prodJsonValue + '\'');
            		celchk = celchk.concat('id="celClass3ID' + celClass3ID + '"/>');
            		
            		var cellabel = '<label for="';
            		cellabel = cellabel.concat('celClass3ID' + celClass3ID + '">');
            		cellabel = cellabel.concat(celName+celPrice + '元</label>');
            		
            		celchk = celchk.concat(cellabel);
            		
            		temp = temp.concat(celchk);
            	});
            	
            	temp = temp.concat('</div>');
            	
            	return temp;
            	}
            },
        ]
    });
}
$('.btnpay').click(function(){
	var money = $('#hidsum').val();
	var storeUID = '${StoreUID}';
	var url = '<%= request.getContextPath() %>'
	location.href = url+'/_08_GetStore/Payment.controller?storeUID='+storeUID+'&total='+money;
});
</script>
</html>