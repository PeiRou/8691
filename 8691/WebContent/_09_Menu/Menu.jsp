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

    <title>8691菜單維護</title>

    <!-- Bootstrap Core CSS -->
    <link href="<%= request.getContextPath() %>/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="<%= request.getContextPath() %>/css/business-casual.css" rel="stylesheet">

    <!-- Fonts -->
    <link href="http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800" rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/css?family=Josefin+Slab:100,300,400,600,700,100italic,300italic,400italic,600italic,700italic" rel="stylesheet" type="text/css">
    
    <!-- Jquery UI CSS -->
    <link href="<%= request.getContextPath() %>/css/jquery.dataTable.min.css" rel="stylesheet">
	<link href="<%= request.getContextPath() %>/css/jquery-ui/jquery-ui.min.css" rel="stylesheet">
	<link rel="apple-touch-icon" href="<%= request.getContextPath() %>/images/logo.png">
	<link rel="icon" href="<%= request.getContextPath() %>/images/logo.png">		
<style type="text/css" class="init">
td.details-control {
	background:
		url('<%=request.getContextPath()%>/images/details_open.png')
		no-repeat center center;
	cursor: pointer;
}

tr.shown td.details-control {
	background:
		url('<%=request.getContextPath()%>/images/details_close.png')
		no-repeat center center;
}

input[type=checkbox] {
	display: none;
}

input[type=checkbox] {
	background: url('../image/icon/blank-check-box.png') no-repeat;
	height: 16px;
	width: 37px;
	display: inline-block;
}

input[type=checkbox]:checked {
	background: url('../image/icon/check-box.png') no-repeat;
	height: 16px;
	width: 37px;
	display: inline-block;
}
</style>
</head>
<body>
<jsp:include page="/fragment/top.jsp" />
	<div class="container">
		<div class="row">
			<div class="box">
				<div class="col-lg-12">	
					<a class="btn btn-warning insGroup">新增食物群組</a>
					<a class="btn btn-primary tdinsSz">修改尺寸</a>			
					<table id="tbl" class="table table-bordered">
						<tr>
							<td></td>
							<td>品名</td>
							<td width="30%">屬性</td>
						</tr>
					</table>					
					<div id="trunkMenu"></div>				
										
					<input id="hidInsC1ID" type="text" style="display:none" value='' />
					<input id="hidInsC3Val" type="text" style="display:none" value='' />					
				</div>
			</div>
		</div>
		<!-- dialog-form -->
		<div id="dialogSz" title="修改你想要尺寸名稱">		
			<table id="tblSz" class="display table table-bordered" cellspacing="0" width="100%">
				<tr>
				</tr>
			</table>
		</div>		
		<div id="dialogClass1" title="請先選擇一個群組">		
			<table id="dtableGP" class="display" cellspacing="0" width="100%">
				<thead>
					<tr>
						<th></th>
						<th>第一層屬性</th>
						<th>第二層屬性</th>
					</tr>
				</thead>
				<tfoot>
					<tr>
						<th></th>
						<th>First</th>
						<th>Second</th>
					</tr>
				</tfoot>
			</table>
		</div>
		<div id="dialogClass2" title="修改屬性">
			<label id=lblC2 class="btn btn-default" style="display: none">
				<input type=text id=txtC2>
				<div>
					<button type="button" class="btn btn-default C2NewY"
						aria-label="Left Align">
						<span class="glyphicon glyphicon-ok" aria-hidden="true"></span>
					</button>
					<button type="button" class="btn btn-default C2NewN"
						aria-label="Left Align">
						<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
					</button>
				</div>
			</label> <a class="btn btn-primary insdgC2">新增</a>
		<br>
		<input id="hidC1" type="hidden" value="">
		<input id="hidGP" type="hidden" value="">
			<table id="example" class="display" cellspacing="0" width="100%">
				<thead>
					<tr>
						<th></th>
						<th></th>
					</tr>
				</thead>
				<tfoot>
					<tr>
						<th></th>
						<th></th>
					</tr>
				</tfoot>
			</table>
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
    
    <!-- jQuery -->
<%--     <script src="<%= request.getContextPath() %>/js/jquery.js"></script> --%>
<script src="https://code.jquery.com/jquery-1.12.0.min.js"></script>
    <script src="<%= request.getContextPath() %>/js/jquery.dataTable.min.js"></script>
	<script src="<%= request.getContextPath() %>/js/jquery-ui.min.js"></script>
    <script>
  //假資料位置
//  var data = '[{"FoodPrice":[{"FoodSizePriceID":"1","SizeStatusID":"3","FoodID":"1","FoodStatusPrice":"40"},{"FoodSizePriceID":"2","SizeStatusID":"3","FoodID":"1","FoodStatusPrice":"45"}],"GroupClass3ID":"1","FoodID":"1","AccountUID":"6D4B16EF-F830-4374-AF0B-8E19EA997D5F","FoodPhoto":"","FoodName":"珍珠奶茶"}, {"FoodPrice":[{"FoodSizePriceID":"7","SizeStatusID":"1","FoodID":"4","FoodStatusPrice":"50"}],"GroupClass3ID":"1","FoodID":"4","AccountUID":"6D4B16EF-F830-4374-AF0B-8E19EA997D5F","FoodPhoto":"","FoodName":"奶茶"}, {"FoodPrice":[{"FoodSizePriceID":"8","SizeStatusID":"1","FoodID":"5","FoodStatusPrice":"45"}],"GroupClass3ID":"1","FoodID":"5","AccountUID":"6D4B16EF-F830-4374-AF0B-8E19EA997D5F","FoodPhoto":"","FoodName":"豆漿紅茶"}, {"FoodPrice":[{"FoodSizePriceID":"9","SizeStatusID":"1","FoodID":"6","FoodStatusPrice":"25"}],"GroupClass3ID":"1","FoodID":"6","AccountUID":"6D4B16EF-F830-4374-AF0B-8E19EA997D5F","FoodPhoto":"","FoodName":"綠茶"}, {"FoodPrice":[{"FoodSizePriceID":"14","SizeStatusID":"1","FoodID":"7","FoodStatusPrice":"30"}],"GroupClass3ID":"2","FoodID":"7","AccountUID":"6D4B16EF-F830-4374-AF0B-8E19EA997D5F","FoodPhoto":"","FoodName":"沙士"}, {"FoodPrice":[{"FoodSizePriceID":"15","SizeStatusID":"1","FoodID":"8","FoodStatusPrice":"30"}],"GroupClass3ID":"2","FoodID":"8","AccountUID":"6D4B16EF-F830-4374-AF0B-8E19EA997D5F","FoodPhoto":"","FoodName":"青茶"}, {"FoodPrice":[{"FoodSizePriceID":"16","SizeStatusID":"1","FoodID":"9","FoodStatusPrice":"35"}],"GroupClass3ID":"2","FoodID":"9","AccountUID":"6D4B16EF-F830-4374-AF0B-8E19EA997D5F","FoodPhoto":"","FoodName":"烏龍綠茶"}, {"FoodPrice":[{"FoodSizePriceID":"10","SizeStatusID":"1","FoodID":"10","FoodStatusPrice":"2000"}],"GroupClass3ID":"1","FoodID":"10","AccountUID":"6D4B16EF-F830-4374-AF0B-8E19EA997D5F","FoodPhoto":"","FoodName":"心痛"}, {"FoodPrice":[{"FoodSizePriceID":"11","SizeStatusID":"2","FoodID":"11","FoodStatusPrice":"2000"},{"FoodSizePriceID":"12","SizeStatusID":"4","FoodID":"11","FoodStatusPrice":"4000"}],"GroupClass3ID":"1","FoodID":"11","AccountUID":"6D4B16EF-F830-4374-AF0B-8E19EA997D5F","FoodPhoto":"","FoodName":"心痛"}, {"FoodPrice":[{"FoodSizePriceID":"13","SizeStatusID":"1","FoodID":"12","FoodStatusPrice":"120"}],"GroupClass3ID":"3","FoodID":"12","AccountUID":"6D4B16EF-F830-4374-AF0B-8E19EA997D5F","FoodPhoto":"","FoodName":"樂意大利麵"}]';
//  var Group = '[{"FoodStatus":[{"ProdStatus":[{"ProdStatusClass3Price":"5","ProdStatusClass2ID":"3","ProdStatusClass3ID":"1","ProdStatusClass3Name":"珍珠"}],"GroupClass3ID":"1","ProdStatusClass3ID":"1"},{"ProdStatus":[{"ProdStatusClass3Price":"5","ProdStatusClass2ID":"3","ProdStatusClass3ID":"2","ProdStatusClass3Name":"椰果"}],"GroupClass3ID":"1","ProdStatusClass3ID":"2"},{"ProdStatus":[{"ProdStatusClass3Price":"5","ProdStatusClass2ID":"3","ProdStatusClass3ID":"3","ProdStatusClass3Name":"粉條"}],"GroupClass3ID":"1","ProdStatusClass3ID":"3"},{"ProdStatus":[{"ProdStatusClass3Price":"5","ProdStatusClass2ID":"3","ProdStatusClass3ID":"4","ProdStatusClass3Name":"綠豆"}],"GroupClass3ID":"1","ProdStatusClass3ID":"4"},{"ProdStatus":[{"ProdStatusClass3Price":"0","ProdStatusClass2ID":"2","ProdStatusClass3ID":"6","ProdStatusClass3Name":"少糖(7分)"}],"GroupClass3ID":"1","ProdStatusClass3ID":"6"},{"ProdStatus":[{"ProdStatusClass3Price":"0","ProdStatusClass2ID":"2","ProdStatusClass3ID":"7","ProdStatusClass3Name":"半糖(5分)"}],"GroupClass3ID":"1","ProdStatusClass3ID":"7"}],"GroupClass3Name":"這是測試","GroupClass3ID":"1","ProdStatusClass1ID":"11"}, {"FoodStatus":[{"ProdStatus":[{"ProdStatusClass3Price":"5","ProdStatusClass2ID":"3","ProdStatusClass3ID":"2","ProdStatusClass3Name":"椰果"}],"GroupClass3ID":"2","ProdStatusClass3ID":"2"},{"ProdStatus":[{"ProdStatusClass3Price":"5","ProdStatusClass2ID":"3","ProdStatusClass3ID":"3","ProdStatusClass3Name":"粉條"}],"GroupClass3ID":"2","ProdStatusClass3ID":"3"},{"ProdStatus":[{"ProdStatusClass3Price":"0","ProdStatusClass2ID":"2","ProdStatusClass3ID":"6","ProdStatusClass3Name":"少糖(7分)"}],"GroupClass3ID":"2","ProdStatusClass3ID":"6"},{"ProdStatus":[{"ProdStatusClass3Price":"0","ProdStatusClass2ID":"2","ProdStatusClass3ID":"7","ProdStatusClass3Name":"半糖(5分)"}],"GroupClass3ID":"2","ProdStatusClass3ID":"7"}],"GroupClass3Name":"我的最愛","GroupClass3ID":"2","ProdStatusClass1ID":"11"}]';
//  var SzSts = '[{"SizeStatusID":"1","SizeName":"預設"}, {"SizeStatusID":"2","SizeName":"小"}, {"SizeStatusID":"3","SizeName":"中"}, {"SizeStatusID":"4","SizeName":"大"}]';
  var PrCl1 = '[{"ProdStatusClass1Name":"下午茶","ProdStatusClass1ID":"1"}, {"ProdStatusClass1Name":"中式料理","ProdStatusClass1ID":"2"}, {"ProdStatusClass1Name":"中西麵食料理","ProdStatusClass1ID":"3"}, {"ProdStatusClass1Name":"便當-小吃","ProdStatusClass1ID":"4"}, {"ProdStatusClass1Name":"其他歐系料理","ProdStatusClass1ID":"5"}, {"ProdStatusClass1Name":"其他異國料理","ProdStatusClass1ID":"6"}, {"ProdStatusClass1Name":"冰品(冰淇淋、刨冰、甜品)","ProdStatusClass1ID":"7"}, {"ProdStatusClass1Name":"南洋料理(越、馬、新)","ProdStatusClass1ID":"8"}, {"ProdStatusClass1Name":"印度料理","ProdStatusClass1ID":"9"}, {"ProdStatusClass1Name":"台菜-熱炒","ProdStatusClass1ID":"10"}, {"ProdStatusClass1Name":"咖啡專賣","ProdStatusClass1ID":"11"}, {"ProdStatusClass1Name":"壽司-生魚片","ProdStatusClass1ID":"12"}, {"ProdStatusClass1Name":"披薩","ProdStatusClass1ID":"13"}, {"ProdStatusClass1Name":"日本料理","ProdStatusClass1ID":"14"}, {"ProdStatusClass1Name":"早午餐","ProdStatusClass1ID":"15"}, {"ProdStatusClass1Name":"泰式料理","ProdStatusClass1ID":"16"}, {"ProdStatusClass1Name":"炸雞速食","ProdStatusClass1ID":"17"}, {"ProdStatusClass1Name":"無國界料理與創意料理","ProdStatusClass1ID":"18"}, {"ProdStatusClass1Name":"粵菜(港式、飲茶、點心)","ProdStatusClass1ID":"19"}, {"ProdStatusClass1Name":"精緻套餐","ProdStatusClass1ID":"20"}, {"ProdStatusClass1Name":"素食","ProdStatusClass1ID":"21"}, {"ProdStatusClass1Name":"美墨料理","ProdStatusClass1ID":"22"}, {"ProdStatusClass1Name":"義式料理","ProdStatusClass1ID":"23"}, {"ProdStatusClass1Name":"蛋糕-西式點心","ProdStatusClass1ID":"24"}, {"ProdStatusClass1Name":"輕食(沙拉、三明治)","ProdStatusClass1ID":"25"}, {"ProdStatusClass1Name":"鍋物(火鍋、豆腐鍋)","ProdStatusClass1ID":"26"}, {"ProdStatusClass1Name":"韓式料理","ProdStatusClass1ID":"27"}, {"ProdStatusClass1Name":"飯類料理(丼飯、飯盒、粥)","ProdStatusClass1ID":"28"}]';
//  var PrCl2 = '[{"ProdStatusClass2ID":"1","ProdStatusClass1ID":"11","ProdStatusClass2Name":"冷熱"}, {"ProdStatusClass2ID":"2","ProdStatusClass1ID":"11","ProdStatusClass2Name":"甜度"}, {"ProdStatusClass2ID":"3","ProdStatusClass1ID":"11","ProdStatusClass2Name":"加料"}, {"ProdStatusClass2ID":"4","ProdStatusClass1ID":"3","ProdStatusClass2Name":"升級成套餐"}]';
 
//  var jsonVal = JSON.parse(data);    
//  var jsonGroup = JSON.parse(Group);
//  var jsonSzSts = JSON.parse(SzSts);
  var jsonPrCl1 = JSON.parse(PrCl1);
//  var jsonPrCl2 = JSON.parse(PrCl2);
//假資料位置------------>
    var data = ${select};
    var Group = ${selectGroup};
    var SzSts = ${selectSzSts};
//    var PrCl1 = ${selectPrCl1};
    var PrCl2 = ${selectPrCl2};
    
    var jsonVal = JSON.parse(JSON.stringify(data));
    var jsonGroup = JSON.parse(JSON.stringify(Group));
    var jsonSzSts = JSON.parse(JSON.stringify(SzSts));
//    var jsonPrCl1 = JSON.parse(JSON.stringify(PrCl1));
    var jsonPrCl2 = JSON.parse(JSON.stringify(PrCl2));
    
    var errArray = null;    
    var newPlusInx = 0;
    var ObjC1C2 = Object;
    
    //紀錄ajax是否回傳response
    var queue = [];
    
    //-----第一次載入--start---
 	LoadTable(jsonVal,jsonGroup);
    beLoad();
    //非同步去撈剩下資料
    SecondToLoad();
	//dialog事件
	$( "#dialogClass1" ).dialog({
	  resizable: false,
      autoOpen: false,
      modal: true,
      height: 700,
      width: 1000   
    });
	$( "#dialogClass2" ).dialog({
		  resizable: false,
	      autoOpen: false,
	      modal: true,
	      height: 500,
	      width: 800,
	      buttons: {	          
	    	  "確定": function() {
	    		  	saveChecked();
		            $(this).dialog( "close" );
					location.reload(true);
					},
	          "離開": function() {
	            $(this).dialog( "close" );
				location.reload(true);
				}}
	    });
	$( "#dialogSz" ).dialog({
		  resizable: false,
	      autoOpen: false,
	      modal: true,
	      height: 400,
	      width: 600,
	      buttons: {
	          "離開": function() {
	            $(this).dialog( "close" );
				location.reload(true);}
				}
	    });
	//------第一次載入-----End-------
	
	//------固定的btn事件--start-----
	$('.insGroup').click(function() {
		//var celSeld = selAttr("insClass1","","");		
		//$("#dialogselect").html(celSeld);
		$("#dialogClass1").dialog( "open" );
		//beLoadDataTable();
	});
	//新增Class2
	$('.insdgC2').click(function(){
		$('#lblC2').show();
		$('#lblC2 :input').attr("maxlength",60)
						  .attr("size",60)
						  .show()
						  .attr('disabled', false);		
	});
	//新增Class2的確定跟取消
	$('.C2NewY').click(function() {	
		var Class2Name = $('#txtC2').val();
		var C1ID =$('#hidC1').val();
		var action = "Insert"
		console.log("C1ID:"+C1ID);
		C2setJson(action,C1ID,Class2Name);		
	});
	$('.C2NewN').click(function() {
		$(this).parent().parent().hide();			
	});
	//修改按鈕click的時候
	$('.tdupd').click(function() {	
		var theTr = $(this).parent().parent().attr("id");
		$("tr[id="+theTr+"] .FoodTd :text").show();
		$("tr[id="+theTr+"] :input").attr('disabled', false);
		$("tr[id="+theTr+"] .FoodTd .tdfont").hide();		
		$(this).hide();
		$("tr[id="+theTr+"] .tdok").show();
	});
	//確定按鈕click的時候
	$('.tdok').click(function() {
		$(":text").hide();
		$(".tdfont").show();			
		$(this).hide();
		$('.tdupd').show();
		$(":input").attr('disabled', true);
		var theTr = $(this).parent().parent().attr("id");		
		//修改資料
		UpdTable(theTr);
		//把輸入的欄位覆蓋回頁面
		funChangeVal(theTr);
	});
	//dialog的click事件
	$(".tdinsSz").click(function() {		
		dialogSz();
      $("#dialogSz").dialog( "open" );
    });
	$(".tdinsC2").click(function() {
		var theTr = $(this).parent().parent().parent().attr("id");
		var leth = theTr.length;
		var GpID = theTr.substring(7,leth);		
		$('#hidGP').val(GpID);
		console.log("GpID:"+GpID)
		var Class1ID = $("#selGpID"+GpID).val();
		$('#hidC1').val(Class1ID);
		console.log("Class1ID:"+Class1ID);
		dialogC2();
      $("#dialogClass2").dialog( "open" );
    });
	//------固定的btn事件---End----	
	
	//------function---start----
	function beLoad(){
		$(":text").hide();
		$(":input").attr('disabled', true);
		$(":text").attr("maxlength",6);
		$(":text").attr("size",6);
		$(".tdok").hide();	
	}
	//第一次載入
    function LoadTable(jsonVal,jsonGroup){ 	    	
    	$.each(jsonGroup, function(index,GroupVal){
        	var trunkStusTd = $("<td class=StusTd></td>");
        	var trunkFoodTd = $("<td class=FoodTd></td>");
        	var btnIns = $('<a class="btn btn-warning tdinsfood"></a>').text('新增食物');
        	var btnUpd = $('<a class="btn btn-success tdupd"></a>').text('修改');
        	var btnOk = $('<a class="btn btn-success tdok"></a>').text('確定');
        	var trunkbtn = $("<td></td>").append(btnUpd).append(btnOk);
        	
        	//每一列的ProdClass1
        	var ProdClass1 = insClass1(GroupVal.GroupClass3ID,GroupVal.ProdStatusClass1ID,GroupVal.GroupClass3Name);
       		trunkFoodTd.prepend(ProdClass1).append('<br>');
       		
        	//右邊欄位屬性值
        	var GroupStus = insGroupStus(GroupVal.FoodStatus);    		
	    	trunkStusTd.append(GroupStus);
	    	
	    	//左邊欄位食物
	    	$.each(jsonVal, function(index,FodStuVal){
	    		if (GroupVal.GroupClass3ID==FodStuVal.GroupClass3ID){    			
		    		var GroupFoods = insGroupFood(FodStuVal.FoodID,FodStuVal.FoodName,FodStuVal.FoodPrice);
		    		trunkFoodTd.append(GroupFoods);
	        	}
	    	});
	    	trunkFoodTd.append(btnIns);
	    	
	    	var trunkTr = $("<tr id=GroupTr"+ GroupVal.GroupClass3ID +"></tr>").append(trunkFoodTd).append(trunkStusTd).prepend(trunkbtn);
	    	$('#tbl tr:last').after(trunkTr);
	    	newBeLoad();
    	});
    }
	//跑迴圈把價錢的按鈕包起來
	function loopceltextPrices(FoodID,PriceStus){
		var JsonData = JSON.stringify(PriceStus);
		//console.log("PriceStus:"+JsonData);
		var appPrices = $("<a/>");
		$.each(PriceStus,function(index,PriceVal){
			var lblPrice = insPrice(PriceVal.SizeStatusID,PriceVal.FoodSizePriceID,PriceVal.FoodStatusPrice);
			appPrices.append(lblPrice).html();			
		});
		return appPrices;
	}	
	//尺寸下拉式選單，給定值後順便綁定
	function selAttr(selName,selID,selectedID){
		if(selName=="SizePrice"){			
			var select = $('<select id=sel'+ selName + selID +'></select>');
			$.each(jsonSzSts,function(index,Sizeval){
				if(Sizeval.SizeStatusID==selectedID){
					select.append($('<option></option>').val(Sizeval.SizeStatusID).text(Sizeval.SizeName).attr('selected',true));
				}else{
					select.append($('<option></option>').val(Sizeval.SizeStatusID).text(Sizeval.SizeName));
				}
			});
		}else if(selName=="Class1"){
			var select = $('<select class=form-control id=selGpID'+selID+'></select>');
			$.each(jsonPrCl1,function(index,PrClval){
				if(PrClval.ProdStatusClass1ID==selectedID){
					select.append($('<option></option>').val(PrClval.ProdStatusClass1ID).text(PrClval.ProdStatusClass1Name).attr('selected',true));
				}
			});
		}else if(selName=="insClass1"){
			var select = $('<select class=form-control id=seldialog></select>');
			$.each(jsonPrCl1,function(index,PrClval){
				select.append($('<option></option>').val(PrClval.ProdStatusClass1ID).text(PrClval.ProdStatusClass1Name));				
			});
		}
		return select;
	}	
	//組多個size+名稱的label
	function insPrice(ID,SizePriceID,SizePrice) {
		var celtextName = $('<input type=text id=txtSizePrice'+SizePriceID+'>').val(SizePrice)
																			   .attr("size",6);
		var celfont = $('<font class="tdfont" id=fontSizePrice'+SizePriceID+'></font>').text(SizePrice);
		var celSeld = selAttr("SizePrice",SizePriceID,ID);
		var cellabel = $('<label class="btn btn-default active" id=lblSizePrice'+SizePriceID +' style="margin: 2px"></label>').append(celSeld).append(celfont).append(celtextName).append('元');
		return cellabel;
	}
	//將class3分門別類到class2
	function insGroupStus(FoodStatus){
		var appeds = $('<a/>');
		$.each(jsonPrCl2,function(idx,PrCl2val){
			if(FoodStatus!=""){								
				var appClass3 = $('<div/>');
				$.each(FoodStatus,function(idx,FodStsval){
					$.each(FodStsval.ProdStatus,function(i,ProdStsval){
						if(PrCl2val.ProdStatusClass2ID==ProdStsval.ProdStatusClass2ID){
							var Class3 = insClass3(ProdStsval.ProdStatusClass3ID,ProdStsval.ProdStatusClass3Name,ProdStsval.ProdStatusClass3Price);
							appClass3.append(Class3);							
						}
					});
				});
				if(appClass3.html()!=""){					
					var Class2 =insClass2(PrCl2val.ProdStatusClass2ID,PrCl2val.ProdStatusClass2Name);	
					appeds.append(Class2).append(appClass3).html();
				}
			}
		});
		var btnIns = $('<a class="btn btn-primary tdinsC2"></a>').text('修改屬性');
		appeds.append(btnIns);
		$('#trunkMenu').append(appeds);
		return appeds;
	}
	//多個食物品名含有多個價錢
	function insGroupFood(celFoodID,celFoodName,celFoodPrice) {
		var celtextName = $('<input type=text id=txtFood'+celFoodID+'>').val(celFoodName)
																		.attr("size",6);
		var celfont = $('<font class="tdfont" id=fontFood'+celFoodID+'></font>').text(celFoodName);
		var celPrices = loopceltextPrices(celFoodID,celFoodPrice);
		//var cellabel = $('<label class="btn btn-default" id=lblFood'+celFoodID +' style="margin: 2px"></label>').append(celtextName).append(celfont).append(celPrices).append(delObj());		
		var cellabel = $('<label class="btn btn-default" id=lblFood'+celFoodID +' style="margin: 2px"></label>').append(celtextName).append(celfont).append(celPrices);
		return cellabel;
	}
	//class1屬性值
	function insClass1(GroupID,Class1ID,GroupClass3Name) {		
		var celSeld = selAttr("Class1",GroupID,Class1ID);		
		var celfont = $('<font id=fontClass1'+Class1ID+'></font>').text(GroupClass3Name);
		var cellabel = $('<label class="btn btn-default btn-lg active" id=lblClass1'+Class1ID +' style="margin: 2px"></label>').text("群組名稱: ").append(celfont).append(celSeld);
		return cellabel;
	}
	
	//class2屬性值
	function insClass2(Class2ID,Class2Name) {		
		var celtextName = $('<input type=text id=txtClass2'+Class2ID+'>').val(Class2Name);		
		var celfont = $('<font class="tdfont" id=fontClass2'+Class2ID+'></font>').text(Class2Name);
		var cellabel = $('<label class="btn btn-default btn-lg active" id=lblClass2'+Class2ID +' style="margin: 2px"></label>').append(celtextName).append(celfont);
		return cellabel;
	}
	//class3屬性值
	function insClass3(Class3ID,Class3Name,Class3Price) {		
		var celtextName = $('<input type=text id=txtClass3'+Class3ID+'>').val(Class3Name);
		var celtextPrice = $('<input type=text id=txtClass3Price'+Class3ID+'>').val(Class3Price);
		var celfont = $('<font class="tdfont" id=fontClass3'+Class3ID+'></font>').text(Class3Name+Class3Price);
		var cellabel = $('<label class="btn btn-default" id=lblClass3'+Class3ID +' style="margin: 2px"></label>').append(celtextName).append(celtextPrice).append(celfont).append("元");
		return cellabel;
	}   
	//修改資料
	function UpdTable(theTr){
		var foodArray = new Array;
		var SzPzArray = new Array;
		var action = "Update";
		var tmpSize;
		
		$("tr[id="+theTr+"] :input").each(function(index,value){			
			//console.log(index,value);
			var tmpData = String($(this).attr('id'));
			//console.log(tmpData,$(this).val());
			var leth = tmpData.length;
			//FoodID
			var culmFId = tmpData.substring(0,7);
			//SizePriceID
			var culmSzPz = tmpData.substring(0,12);
			
			if(culmFId=='txtFood'){					
				var tmpFood = $(this).val();
				var objdata = new Object;
				var FoodID = tmpData.substring(7,leth);
				
				objdata.FoodID = FoodID;
				objdata.FoodName = tmpFood;
				foodArray.push(objdata);
			}else if(culmSzPz=='selSizePrice'){
				tmpSize= $(this).val();				
			}else if(culmSzPz=='txtSizePrice'){
				var tmpSizePrice= $(this).val();
				//console.log("tmpSizePrice:"+tmpSizePrice);
				var objdata = new Object;			
				var SzPzId = tmpData.substring(12,leth);
				
				objdata.FoodSizePriceID = SzPzId;
				objdata.SizeStatusID = tmpSize;
				//用完清空
				tmpSize = "";
				
				objdata.FoodStatusPrice = tmpSizePrice;
				//驗證金額不是輸入數字
				if(!isNaN(tmpSizePrice)){
					SzPzArray.push(objdata);
				}else{					
					var thelabel = $("#"+tmpData).parent().parent().parent().attr("id");					
					var OgnPrice = $("#fontSizePrice"+SzPzId).html();
					console.log("thelabel:"+thelabel);
					objdata.theTr = theTr;
					objdata.thelabel = thelabel;
					objdata.OgnPrice = OgnPrice;	
					if(errArray==null){
						errArray = new Array;
					}
					errArray.push(objdata);
				}
			}
		});	
		CovJsonObjectSetAjax(action,"Food",foodArray);
		CovJsonObjectSetAjax(action,"FoodSizePrice",SzPzArray);
	}
	//轉成json物件,再送出ajax
	function CovJsonObjectSetAjax(action,table,status){
		var jsonObj = new Object;
		jsonObj.action = action;
		jsonObj.table = table;
		jsonObj.status = status;
		var JsonData = JSON.stringify(jsonObj);
		console.log("JsonData:"+JsonData);
		setJson(action,JsonData);					
	}
	//呼叫ajax
	function setJson(action,jsonData) {
		var action = action;
		$.ajax({
			url : '<%= request.getContextPath() %>/_10_Menu/UpdMenu.controller',
	        type: 'get',
	        dataType: 'json',
	        data: "jsonData=" + jsonData,
	        contentType: 'application/json',
	        mimeType: 'application/json',
	        success: function (data) {
	        	if(action == "Insert"){	        		
	        		var Obj = JSON.parse(JSON.stringify(data));
	        		console.log("Obj:"+Obj);
	        		console.log("FoodID:"+Obj.FoodID);
					
					//如果沒有錯
					if(errArray!=null || Obj.FoodID==""){
						$("#lblFoodNewCel").attr("class","btn btn-danger")
										   .css("color","black");
						errArray = null;
					}else {
			    		var GroupFoods = insGroupFood(Obj.FoodID,Obj.FoodName,Obj.FoodPrice);
			    		$("#lblFoodNewCel").before(GroupFoods);
			    		$("#lblFoodNewCel").remove();
			    		beLoad();
					}
				}else if(action == "Update"){
					console.log("Errordata:"+data);
					var idata = 0;
						var datalength= data.length;
						while(idata < datalength){
								var Obj = new Object;
								Obj = JSON.parse(JSON.stringify(data[idata]));
								console.log("Obj.table:"+Obj.table);
								if(Obj.table=="FoodSizePrice"){
									console.log("Obj.FoodSizePriceID:"+Obj.FoodSizePriceID);
									var tmpID = "lblSizePrice"+Obj.FoodSizePriceID;
									var thelabel = $("#"+tmpID).parent().parent().attr("id");
									var theTr = $("#"+thelabel).parent().parent().attr("id");
									console.log("thelabel:"+thelabel);					
									console.log("theTr:"+theTr);
									fucErorrShow(theTr,thelabel,Obj.FoodSizePriceID,Obj.OgnPrice);
								}
								idata = idata + 1;
							}	
				}			
	        }});
	}
	//把輸入的欄位覆蓋回頁面
	function funChangeVal(theTr){
		$("tr[id="+theTr+"] :input").each(function(index,value){
			//console.log("funChangeVal:"+index,value);
			
			var tmpData = String($(this).attr('id'));
			//console.log(tmpData,$(this).val());
			var leth = tmpData.length;
			//FoodID
			var culmFId = tmpData.substring(0,7);
			var FoodId = tmpData.substring(7,leth);
			//SizePriceID
			var culmSzPz = tmpData.substring(0,12);			
			var SzPzId = tmpData.substring(12,leth);

			if(culmFId=='txtFood'){
				$('font[id="fontFood'+FoodId+'"]').html('');
				$('font[id="fontFood'+FoodId+'"]').append($(this).val());
			}else if(culmSzPz=='txtSizePrice'){
				$('font[id="fontSizePrice'+SzPzId+'"]').html('');
				$('font[id="fontSizePrice'+SzPzId+'"]').append($(this).val());
			}
		});
		//前端驗證數字
		if(errArray!=null){
			$.each(errArray,function(index,Obj){
				//console.log(index,Obj.OgnPrice);			
				fucErorrShow(Obj.theTr,Obj.thelabel,Obj.FoodSizePriceID,Obj.OgnPrice);
			});
			errArray = null;
		}
	}
	//有錯誤的時候則不讓格子隱藏回去
	function fucErorrShow(theTr,thelabel,FoodSizePriceID,OgnPrice){
		var thelabelid = 'label[id="'+ thelabel +'"]';
		console.log("$(thelabelid): "+$(thelabelid).attr("class"));
		if($(thelabelid).attr("class")=="btn btn-default"){
			$(thelabelid).attr("class","btn btn-danger")
						 .css("color","black")
						 .append(addBtnNO("errNo"));
		}
		$(thelabelid+' :input').attr('disabled', false)
		$(thelabelid+' :hidden').show();
		$(thelabelid+' .tdfont').hide();
		//把原先的輸入的還原回去
		$('font[id="fontSizePrice'+FoodSizePriceID+'"]').html('');
		$('font[id="fontSizePrice'+FoodSizePriceID+'"]').append(OgnPrice);
		//把確定的按鈕重新秀回來
		$("tr[id="+theTr+"] .tdupd").hide();
		$("tr[id="+theTr+"] .tdok").show();
		//必須在事件發生後再載入
		errBeLoad(OgnPrice);
	}
	//err的取消
	function addBtnNO(name){
		var btn = $('<div/>').html('<button type="button" class="btn btn-default '+ name +'" aria-label="Left Align"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></button>');
		return btn;
	}
	//必須在事件發生後再error相關事件載入
	function errBeLoad(OgnPrice){
		$('.errNo').click(function() {
			var thelabel = $(this).parent().parent().attr("id");
			var thelabelid = 'label[id="'+ thelabel +'"]';
			console.log("thelabel:  "+thelabel);
			$(thelabelid).attr("class","btn btn-default");
			$(thelabelid +' :input').attr('disabled', true);
			$(thelabelid +' :hidden').show();
			$(thelabelid +' :text').hide();
			$(thelabelid).children().find('input:text').val(OgnPrice);
			
			$(this).remove();			
			
			var errCount = 0; 
			
			$('.errNo').each(function(){
				errCount = 1;
			});
				
			if(errCount==0){
				$('.tdupd').show();
				$('.tdok').hide();				
			}				
		});
	}
	//必須在事件發生後再insert相關事件載入
	function newBeLoad(){
		$('.tdinsfood').click(function(){
			var newCount = 0; 			
			$('#lblFoodNewCel').each(function(){newCount = 1;});
			
			if(newCount==0){	
				var PriceStatus = JSON.parse('[{"FoodSizePriceID":"New0","SizeStatusID":"1","FoodID":"NewCel","SizeStatus":[{"SizeStatusID":"1","SizeName":"預設"}],"FoodStatusPrice":""}]');
				var cellabel = insGroupFood("NewCel","",PriceStatus);
				var btnNew = fucBtnOkCancel();
				var btnPlusPrice = fucBtnNewPrice();
				cellabel.append(btnPlusPrice).append(btnNew);
				$(this).before(cellabel);
				//綁定新增欄位的確定跟取消的按鈕事件
				NewBtnAttr();
				//綁定增加價錢的按鈕事件
				PlusBtnAttr();
			}
		});
	}
	//增加after確定跟取消的按鈕
	function fucBtnOkCancel(){
		var btn = $('<div/>').html(
				'<button type="button" class="btn btn-default NewY" aria-label="Left Align"><span class="glyphicon glyphicon-ok" aria-hidden="true"></span></button><button type="button" class="btn btn-default NewN" aria-label="Left Align"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></button>');
		return btn;
	}
	//增加新增價格欄位的按鈕
	function fucBtnNewPrice(){
		var btn = $('<a/>').html(
				'<button type="button" class="btn btn-default PlusPz" aria-label="Left Align"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span></button>');
		return btn;
	}
	//新增欄位的確定跟取消的按鈕事件
	function NewBtnAttr() {		
		$('.NewY').click(function() {
			var theTr = $(this).parent().parent().parent().parent().attr("id");
			InsFood(theTr);			
		});
		$('.NewN').click(function() {
			$(this).parent().parent().remove();			
		});
	}
	//增加價錢的按鈕事件
	function PlusBtnAttr() {		
		$('.PlusPz').click(function() {
			var thePz = $('input[id^=txtSizePriceNew]:last')
			var tmpData = String(thePz.attr("id"));
			console.log("id: "+tmpData);
			newPlusInx = newPlusInx + 1;
			var tmpPz = thePz.val();
			var pluscel
			
			if(tmpPz==""){
				alert("請先輸入金額");
			}else{
				var pluscel = insPrice("1","New"+newPlusInx,"");
				pluscel.append(addBtnNO("plusNo"));
				$(this).before('<br>').before(pluscel);
				plusBeLoad();
			}
		});
	}
	//必須在事件發生後再plus相關事件載入
	function plusBeLoad(){
		$('.plusNo').click(function(){
			$(this).parent().parent().parent().find('br:last').remove();
			$(this).parent().parent().remove();
		});
	}
	//新增食物
	function InsFood(theTr){
		var requestArray = new Array;
		var action = "Insert";
		var tmpSize;
		
		$("[id=lblFoodNewCel] :input").each(function(index,value){			
			//console.log(index,value);
			var tmpData = String($(this).attr('id'));
			//console.log(tmpData,$(this).val());
			var leth = tmpData.length;
			//FoodID
			var culmFId = tmpData.substring(0,7);
			//SizePriceID
			var culmSzPz = tmpData.substring(0,12);
			
			if(culmFId=='txtFood'){					
				var tmpFood = $(this).val();
				var FoodID = tmpData.substring(7,leth);
				var GroupClass3ID = theTr.substring(7,theTr.length);
				//console.log("GroupClass3ID:"+GroupClass3ID);				
				var foodObject = new Object;
				foodObject.GroupClass3ID = GroupClass3ID;
				foodObject.FoodID = FoodID;
				foodObject.FoodName = tmpFood;
				requestArray.push(foodObject);
			}else if(culmSzPz=='selSizePrice'){
				tmpSize= $(this).val();				
			}else if(culmSzPz=='txtSizePrice'){
				var tmpSizePrice= $(this).val();
				console.log("tmpSizePrice:"+tmpSizePrice);
				var SzPzObject = new Object;			
				var SzPzId = tmpData.substring(12,leth);
				
				SzPzObject.FoodSizePriceID = SzPzId;
				SzPzObject.SizeStatusID = tmpSize;
				//用完清空
				tmpSize = "";
				
				SzPzObject.FoodStatusPrice = tmpSizePrice;
				//驗證金額不是輸入數字
				if(!isNaN(tmpSizePrice)){
					requestArray.push(SzPzObject);
				}else{					
					var thelabel = $("#"+tmpData).parent().parent().parent().attr("id");					
					var OgnPrice = $("#fontSizePrice"+SzPzId).html();
					console.log("thelabel:"+thelabel);					
					var objdata = new Object;
					objdata.theTr = theTr;
					objdata.thelabel = thelabel;
					objdata.OgnPrice = OgnPrice;	
					if(errArray==null){
						errArray = new Array;
					}
					errArray.push(objdata);
				}
			}
		});		
		//前端驗證數字
		if(errArray!=null){
			$("#lblFoodNewCel").attr("class","btn btn-danger")
							   .css("color","black");
			errArray = null;
		}else{			
			CovJsonObjectSetAjax(action,"insFood",requestArray);
		}
	}
	
	//dialog事件function	
	function formatGP ( d ) {
		// `d` is the original data object for the row	
		var temp = $('<table></table>')
		var tempTr = null;
		$.each(d.Class2Status,function(index,dataVal){
			
			var temptitle = $('<td>'+ dataVal.ProdStatusClass2Name +'<td>');
			var tempC3Val = $('<a/>');
			$.each(dataVal.Class3Status,function(index,Class3Status){			
				var C3Name = Class3Status.ProdStatusClass3Name;
				var C3Price = Class3Status.ProdStatusClass3Price;
				var C3Label = $('<label class="btn btn-default" style="margin: 2px"></label>').text(C3Name+":"+C3Price+"元");
				tempC3Val.append(C3Label);
			});		
			
			var tempbody = $('<td>'+ tempC3Val.html() +'</td>');
		
			tempTr = $("<tr></tr>").append(temptitle).append(tempbody);
			temp.append(tempTr);
		});
		if(tempTr==null){
			tempTr = "<tr><td>尚未有範本</td></tr>"
		}
		return temp;
	}	
	
	var mslabel = $('<label id="labelInsGroup" class="btn btn-default" style="display:none"></label>');
	$("#dialogClass1").prepend(mslabel);	
	
	//documentReady
$(document).ready(function() {	
	var counter = 1;
    var table = $('#dtableGP').DataTable( {
    	"ajax": "<%= request.getContextPath() %>/_09_Menu/data/arrays.txt",
        "columns": [   
			{
				"className":      'details-control',
				"orderable":      false,
				"data":           function (data){				
					var tempHidVal = '<input id="hidC1ID'+data.ProdStatusClass1ID+'" type="hidden" value='+data.ProdStatusClass1Name+' />';
					var temp = '<a>'+tempHidVal+'</a>';
					return temp;
				} ,
				"defaultContent": ''
			},
			{ "data": "ProdStatusClass1Name" },
			{ "data": function (data) {
				var temp ="";
				if(data.Class2Status!=""){
					var lethC2 = data.Class2Status.length;
					for(var i = 0;i<lethC2;i++){						
						temp = temp + data.Class2Status[i].ProdStatusClass2Name						
						if(i<lethC2-1){
							temp = temp + ",";
						}
					}

					var temphtml = '<a class="btn btn-info">'+ temp +'</a>';
					return temphtml;
				}else{
					temp = temp + "尚未有範本";
				}
				return temp;
		    }}
        ],
        "order": [[1, 'asc']]
    ,initComplete: function () {
		this.api().columns().every( function () {
			var column = this;
			var select = $('<select><option value=""></option></select>')
				.appendTo( column.header() )
				.on( 'change', function () {
					var val = $.fn.dataTable.util.escapeRegex(
						$(this).val()
					);

					column
						.search( val ? '^'+val+'$' : '', true, false )
						.draw();
				} );

			column.data().unique().sort().each( function ( d, j ) {
				select.append( '<option value="'+d+'">'+d+'</option>' )
			} );
		} );
	}
    } );
 	// Add event listener for opening and closing details
	$('#dtableGP tbody').on('click', 'td.details-control', function () {
		var tr = $(this).closest('tr');
		var row = table.row( tr );

		if ( row.child.isShown() ) {
			// This row is already open - close it
			row.child.hide();
			tr.removeClass('shown');
		}
		else {
			// Open this row
			row.child( formatGP(row.data()) ).show();
			tr.addClass('shown');
		}
	} ); 	
	
	$('#dtableGP tbody').on( 'click', 'tr', function () {
        if ( $(this).hasClass('selected') ) {
            $(this).removeClass('selected');
        }
        else {
            table.$('tr.selected').removeClass('selected');
            $(this).addClass('selected');
        }
    } );
 
    $('#dtableGP tbody').click( function () {
    	$('.msok').remove();
    	var hidC1 = $('.selected').children().find('input');    	
    	var hidC1ID = hidC1.attr('id');
    	
    	if(typeof hidC1ID!="undefined"){        	
    		var leth = hidC1ID.length;
        	var C1ID = hidC1.attr('id').substring(7,leth);  
        	$('#hidInsC1ID').val(C1ID);
        	var msok = '<a class="btn btn-info msok"><span class="glyphicon glyphicon-ok" aria-hidden="true"></span></a>';
        	
        	var mstext = $('<input type="text" id="mstxt"></input>');
        	
        	$('#labelInsGroup').show();
            $('#labelInsGroup').text('您選擇是※ ' + hidC1.val() +' ※的類別  請輸入要新增的群組名字').append(mstext).after(msok);
        	
    	}else{
    		$('#labelInsGroup').hide();
    	}
    	msbeload();
    } );  
    function msbeload(){
		 $('.msok').click( function () {	
			 console.log("msbeload");
			 var C1ID = $('#hidInsC1ID').val();
			 console.log("C1ID:"+C1ID);
			 var C3Val = $('#mstxt').val();
			 if(C3Val==""){
				 alert('群組名稱不能留白');
			 }else{
				 insMenuAjax(C1ID,C3Val);
				 SecondToLoad();
				 $("#dialogClass1").dialog( "close" );
					location.reload(true);
			 }
		    } );
	}
    
} );
function insMenuAjax(C1ID,C3Val){
	$.ajax({
		url : '<%= request.getContextPath() %>/_10_Menu/InsMenu.controller',
        type: 'get',
        dataType: 'json',
        'data': {
        	prodStatusClass1ID:C1ID,
        	groupClass3Name:C3Val,
        }});
        
}
//修改尺寸的dialog
function dialogSz(){
	var trunkStusTd = $("<td></td>");
	var btnIns = $('<a class="btn btn-warning Szins"></a>').text('新增尺寸');
	var btnUpd = $('<a class="btn btn-success Szupd"></a>').text('修改');
	var btnOk = $('<a class="btn btn-success Szok"></a>').text('確定');
	var trunkbtn = $("<td width=30px></td>").append(btnUpd).append(btnOk);
	
	$.each(jsonSzSts, function(index,SzStsVal){   
		console.log(index,SzStsVal);
    	//尺寸單一欄位屬性值
    	var GroupStus = insSzSts(SzStsVal.SizeStatusID,SzStsVal.SizeName);    		
    	trunkStusTd.append(GroupStus);   	
	});
	trunkStusTd.append(btnIns); 
	var trunkTr = $("<tr id=SzTr></tr>").prepend(trunkStusTd).append(trunkbtn);
	$('#tblSz tr:last').after(trunkTr);
	SzbeLoad();
	SznewBeLoad();
}
//必須載入
function SzbeLoad(){
	$(":text").hide();
	$(":text").attr("maxlength",10);
	$(":text").attr("size",10);
	$(".Szok").hide();	
}
//必須在事件發生後再insert相關事件載入
function SznewBeLoad(){
	$('.Szins').click(function(){
		var newCount = 0; 			
		$('#lblSzNewCel').each(function(){newCount = 1;});
		
		if(newCount==0){	
			var PriceStatus = JSON.parse('[{"SizeStatusID":"New0","SizeName":""}]');
			var cellabel = insSzSts("NewCel","");
			var btnNew = SzBtnOkCancel();
			var btnPlusPrice = fucBtnNewPrice();
			cellabel.append(btnNew);
			$(this).before(cellabel);
			//綁定新增欄位的確定跟取消的按鈕事件
			SzNewBtnAttr();
		}
	});
	$('.Szupd').click(function(){
		var theTr = $(this).parent().parent().attr("id");
		console.log(theTr);
		$("tr[id="+theTr+"] :text").show();
		$("tr[id="+theTr+"] .szfont").hide();		
		$(this).hide();
		$("tr[id="+theTr+"] .Szok").show();
	});
	$('.Szok').click(function(){
		$(":text").hide();
		$(".szfont").show();			
		$(this).hide();
		$('.Szupd').show();
		var theTr = $(this).parent().parent().attr("id");		
		//修改資料
		UpdSize(theTr);
		//把輸入的欄位覆蓋回頁面
		SzChangeVal(theTr);
	});
}
function SzChangeVal(theTr){
	$("tr[id="+theTr+"] :input").each(function(index,value){
		//console.log("SzChangeVal:"+index,value);
		
		var tmpData = String($(this).attr('id'));
		
		var leth = tmpData.length;
		//SizeID
		var culmC3Id = tmpData.substring(0,5);
		var Class3ID = tmpData.substring(5,leth);

		if(culmC3Id=='txtSz'){
			$('font[id="fontSz'+Class3ID+'"]').html('');
			$('font[id="fontSz'+Class3ID+'"]').append($(this).val());
		}
	});
}
//增加after確定跟取消的按鈕
function SzBtnOkCancel(){
	var btn = $('<div/>').html(
			'<button type="button" class="btn btn-default SzNewY" aria-label="Left Align"><span class="glyphicon glyphicon-ok" aria-hidden="true"></span></button><button type="button" class="btn btn-default SzNewN" aria-label="Left Align"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></button>');
	return btn;
}
//新增欄位的確定跟取消的按鈕事件
function SzNewBtnAttr() {		
	$('.SzNewY').click(function() {
		var theTr = $(this).parent().parent().parent().parent().attr("id");
		console.log(theTr);
		//新增尺寸
		InsSize(theTr);			
	});
	$('.SzNewN').click(function() {
		$(this).parent().parent().remove();			
	});
}
//修改尺吋
function UpdSize(){
	var SizeArray = new Array;
	var action = "Update";
	var tmpSize;
	
	$("tr[id=SzTr] :input").each(function(index,value){			
		//console.log(index,value);
		var tmpData = String($(this).attr('id'));
		//console.log(tmpData,$(this).val());
		var leth = tmpData.length;
		//SizeID
		var culmSzId = tmpData.substring(0,5);
		
		if(culmSzId=='txtSz'){					
			var tmpFood = $(this).val();
			var SizeID = tmpData.substring(5,leth);			
			var Obj = new Object;
			if(tmpFood==""){
				alert("不能空白");
			}else{
				Obj.SizeStatusID = SizeID;
				Obj.SizeName = tmpFood;
				SizeArray.push(Obj);
				}
			}
		});	
	
	//轉換成JSON物件
	SzCovJsonObjectSetAjax(action,"SizeStatus",SizeArray);
	}
//新增尺吋
function InsSize(){
	var SizeArray = new Array;
	var action = "Insert";
	var tmpSize;
	
	$("[id=lblSzNewCel] :input").each(function(index,value){			
		//console.log(index,value);
		var tmpData = String($(this).attr('id'));
		//console.log(tmpData,$(this).val());
		var leth = tmpData.length;
		//SizeID
		var culmSzId = tmpData.substring(0,5);
		
		if(culmSzId=='txtSz'){					
			var tmpFood = $(this).val();
			var SizeID = tmpData.substring(5,leth);			
			var Obj = new Object;
			
			Obj.SizeStatusID = SizeID;
			Obj.SizeName = tmpFood;
			SizeArray.push(Obj);
			}
		});		
	//轉換成JSON物件
	SzCovJsonObjectSetAjax(action,"SizeStatus",SizeArray);
	}
	//轉成json物件,再送出ajax===>Szdialog
	function SzCovJsonObjectSetAjax(action,table,status){
		var jsonObj = new Object;
		jsonObj.action = action;
		jsonObj.table = table;
		jsonObj.status = status;
		var JsonData = JSON.stringify(jsonObj);
		console.log("JsonData:"+JsonData);
		szsetJson(action,JsonData);					
	}
	//呼叫ajax===>Szdialog
	function szsetJson(action,jsonData) {
		var action = action;
		$.ajax({
			url : '<%= request.getContextPath() %>/_10_Menu/UpdSizeStatus.controller',
	        type: 'get',
	        dataType: 'json',
	        data: "jsonData=" + jsonData,
	        contentType: 'application/json',
	        mimeType: 'application/json',
	        success: function (data) {
	        	if(action == "Insert"){	        		
	        		var Obj = JSON.parse(JSON.stringify(data));
	        		console.log("Obj:"+Obj);    
	        		console.log("SizeStatusID:"+Obj.SizeStatusID);
	        		if(typeof Obj.SizeStatusID =="undefined")
	        		{
	        			$("#lblSzNewCel").attr("class","btn btn-danger")
	        							 .css("color","black");        			
	        		}else{	               		
	               		//console.log(celName);
	               		var cellabel = insSzSts(Obj.SizeStatusID,Obj.SizeName)
	               		
	        			$('.Szins').before(cellabel);	               		
	        			$('.SzNewN').click();
	        		}
				}else if(action == "Update"){
					console.log("Errordata:"+data); 				
				}			
	        }});
	}
//尺寸的欄位
function insSzSts(SizeStatusID,SizeName){
	var celtextName = $('<input type=text id=txtSz'+SizeStatusID+' systle="disaplay:none">').val(SizeName)
																	.attr("size",6);
	var celfont = $('<font class="szfont" id=fontSz'+SizeStatusID+'></font>').text(SizeName);
	var cellabel = $('<label class="btn btn-default" id=lblSz'+SizeStatusID +' style="margin: 2px"></label>').append(celtextName).append(celfont);		
	return cellabel;
}

//針對按鈕在哪一個群組，去顯示相對的Class1的資料
function findC1(C1ID){
	var json;
	
	$.each(ObjC1C2.data, function(index,Objval){
		if(Objval.ProdStatusClass1ID==C1ID){			
			json = Objval.Class2Status;		
		}
	});
	
	return json;
}
//修改屬性的dialog
function dialogC2() {
	var GP =$('#hidGP').val();
	var C1ID =$('#hidC1').val();
	var printifo = findC1(C1ID);
	
	//console.log(JSON.stringify(printifo));
	var table = $('#example').DataTable();
	table.destroy();
	table = $('#example').DataTable( {        
    	    'data': printifo,
            "fnCreatedRow": function( nRow, aData, iDataIndex ) {
                $(nRow).attr('id', "dgtrC2"+aData.ProdStatusClass2ID);
            },
            "columns": [   
            { "data": "ProdStatusClass2Name" },
            //{ "data": "Class3Status[,].ProdStatusClass3Name" }
            { "data": function(dataVal){
            	//console.log("dataVal:"+dataVal);
            	var tempC3Val = '<div>';
            	var btnUpd = '<a class="btn btn-success dgupd">修改</a>';
            	var btnOk = '<a class="btn btn-success dgok" style="display:none">確定</a>';
            	var btnIns = '<a class="btn btn-warning dgins">新增屬性</a>';
            	$.each(dataVal.Class3Status,function(index,Class3Status){
            		var celClass3ID = Class3Status.ProdStatusClass3ID,
            			celName = Class3Status.ProdStatusClass3Name,
            			celPrice = Class3Status.ProdStatusClass3Price;
            		//console.log(celName);
            		var celchk = '<input type=checkbox id=dgClass3ID'+celClass3ID+' value='+celClass3ID+'>';
            		var celtextName = '<input class="dgtxtName" type=text id=dgClass3Name'+celClass3ID+' maxlength="20" size="20" value='+celName+' style="display:none">';
            		var celtextPrice = '<input class="dgtxtPrice" type=text id=dgPrice'+celClass3ID+' maxlength="6" size="6" value='+celPrice+' style="display:none">';            		
            		var celfontName = '<font class="dgtdfont" id=dgfontName'+celClass3ID+'>'+celName+'</font>';
            		var celfontPrice = '<font class="dgtdfont" id=dgfontPrice'+celClass3ID+'>'+celPrice+'</font>';
            		var cellabel = '<label class="btn btn-default" id=dglbl'+celClass3ID +' style="margin: 2px">'+celchk+celtextName+celtextPrice+celfontName+celfontPrice+'元</label>';
            		tempC3Val = tempC3Val.concat(cellabel);
            	});	
            	tempC3Val = tempC3Val.concat(btnUpd);
            	tempC3Val = tempC3Val.concat(btnOk);
            	tempC3Val = tempC3Val.concat(btnIns);
            	tempC3Val = tempC3Val.concat('</div>');
            	//console.log("dataVal");
            	return tempC3Val;
            } }
        ],
        "drawCallback": function() {
        	console.log('drawCallback');
        	
        	dgbeload();
        }
    } );
}
//必須載入事件動作
function dgbeload(){
	var GP =$('#hidGP').val();	
	
	$.each(jsonGroup,function(index,GpVal){
		if(GpVal.GroupClass3ID==GP){			
			$.each(GpVal.FoodStatus,function(index,FoodStsVal){
				console.log(FoodStsVal.ProdStatusClass3ID);
				$('#dgClass3ID'+FoodStsVal.ProdStatusClass3ID).attr("checked",true);
			});	
		}				
	});
	$('.dgupd').click(function(){
		var theTr = $(this).parent().parent().parent().attr('id');	
		//console.log("dgtheTr:"+theTr)
		$('tr[id='+theTr+'] :text').show();
		$('tr[id='+theTr+'] .dgtdfont').hide();
		$(this).next().show();
		$(this).hide();		
	});
	$('.dgok').click(function(){
		var theTr = $(this).parent().parent().parent().attr('id');
		
		$('tr[id='+theTr+'] :text').hide();
		$('tr[id='+theTr+'] .dgtdfont').show();
		$(this).prev().show();
		$(this).hide();		
		//修改資料傳送到server端
		UpdStatus(theTr);
		//把輸入的欄位覆蓋回頁面
		dgChangeVal(theTr);
	});
	$('.dgins').click(function(){		
		var newCount = 0; 			
		$('#dglblNewCel').each(function(){newCount = 1;});
		
		if(newCount==0){	
			var Class3 = JSON.parse('[{"ProdStatusClass3ID":"New0","ProdStatusClass3Name":"","ProdStatusClass3Price":""}]');
			var cellabel = insCelStatus("NewCel",Class3);
			var btnNew = dgBtnOkCancel();			
			//cellabel.append(btnNew);
			$(this).before(cellabel);
			//綁定新增欄位的確定跟取消的按鈕事件
			dgNewBtnAttr();
		}		
	});
}
//增加after確定跟取消的按鈕
function dgBtnOkCancel(){
	var btn = $('<div/>').html(
			'<div><button type="button" class="btn btn-default dgNewY" aria-label="Left Align"><span class="glyphicon glyphicon-ok" aria-hidden="true"></span></button><button type="button" class="btn btn-default dgNewN" aria-label="Left Align"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></button></div>');
	return btn;
}
//新增欄位的確定跟取消的按鈕事件
function dgNewBtnAttr() {		
	$('.dgNewY').click(function() {
		var theTr = $(this).parent().parent().parent().parent().parent().attr("id");
		console.log("dgNewBtnAttr.theTr:"+theTr);
		InsStatus(theTr);			
	});
	$('.dgNewN').click(function() {
		$(this).parent().parent().remove();		
	});
}
//新增屬性傳送到Server端
function InsStatus(theTr){
	var Class3Array = new Array;
	var action = "Insert";
	var tmpClass3;
	
	$("[id=dglblNewCel] :input").each(function(index,value){	
		//Class2ID
		var theTrleth = theTr.length;
		var culmC2Id = theTr.substring(6,theTrleth);
		//console.log(index,value);
		var tmpData = String($(this).attr('id'));
		//console.log(tmpData,$(this).val());
		var leth = tmpData.length;
		//Class3ID
		var culmC3Id = tmpData.substring(0,12);
		//PriceID
		var culmPz = tmpData.substring(0,7);
		
		if(culmC3Id=='dgClass3Name'){					
			tmpClass3 = $(this).val();			
		}else if(culmPz=='dgPrice'){
			var tmpPrice= $(this).val();
			//console.log("tmpSizePrice:"+tmpSizePrice);
			var objdata = new Object;			
			var PzId = tmpData.substring(7,leth);
			
			objdata.theTr = theTr;
			objdata.ProdStatusClass3ID = PzId;
			objdata.ProdStatusClass2ID = culmC2Id;
			objdata.ProdStatusClass3Price = tmpPrice;
			objdata.ProdStatusClass3Name = tmpClass3;
			//用完清空
			tmpClass3 = "";
			//驗證金額不是輸入數字
			if(!isNaN(tmpPrice)){
				Class3Array.push(objdata);
			}else{					
				var thelabel = $("#"+tmpData).parent().attr("id");
				var OgnName = $("#dgfontName"+PzId).html();
				var OgnPrice = $("#dgfontPrice"+PzId).html();
				console.log("OgnPricehtml:"+OgnPrice);
				console.log("thelabel:"+thelabel);
				objdata.theTr = theTr;
				objdata.thelabel = thelabel;
				objdata.Class3ID = PzId;
				objdata.OgnName = OgnName;
				objdata.OgnPrice = OgnPrice;	
				if(errArray==null){
					errArray = new Array;
				}
				errArray.push(objdata);
			}
		}
	});	
	//將勾選儲存
	saveChecked();
	//前端驗證數字
	if(errArray!=null){
		$("#dglblNewCel").attr("class","btn btn-danger")
						   .css("color","black");
		errArray = null;
	}else{			
		dgCovJsonObjectSetAjax(action,"ProdStatusClass3",Class3Array);		
	}
}
//將勾選儲存
function saveChecked(){
	var FdStsC3Ararry = new Array;
	$("table[id=example] :checked").each(function(){
		console.log(":checked"+$(this).val());
		var Obj = new Object;
		Obj.GroupClass3ID = $('#hidGP').val();
		Obj.ProdStatusClass3ID = $(this).val();
		FdStsC3Ararry.push(Obj);
	});
	dgCovJsonObjectSetAjax("Update","FoodStatusClass3",FdStsC3Ararry);
}
//新增屬性欄位
function insCelStatus(LabelID,Class3){
	var cellabel;
	$.each(Class3,function(index,Class3Status){
		var celClass3ID = Class3Status.ProdStatusClass3ID,
			celName = Class3Status.ProdStatusClass3Name,
			celPrice = Class3Status.ProdStatusClass3Price;		
		var celchk = '<input type=checkbox id=dgClass3ID'+celClass3ID+' value='+celClass3ID+'>';
		var celtextName = '<input class="dgtxtName" type=text id=dgClass3Name'+celClass3ID+' maxlength="10" size="10" value="'+celName+'">';
		var celtextPrice = '<input class="dgtxtPrice" type=text id=dgPrice'+celClass3ID+' maxlength="6" size="6" value="'+celPrice+'">';
		var celYesNo = '<div><button type="button" class="btn btn-default dgNewY" aria-label="Left Align"><span class="glyphicon glyphicon-ok" aria-hidden="true"></span></button><button type="button" class="btn btn-default dgNewN" aria-label="Left Align"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></button></div>';
		cellabel = '<label class="btn btn-default" id=dglbl'+LabelID +' style="margin: 2px">'+celchk+celtextName+celtextPrice+'元'+celYesNo+'</label>';		
	});	
	return cellabel;
}
//非同步撈資料
function SecondToLoad(){
	$.ajax({
		url : '<%= request.getContextPath() %>/_10_Menu/GetGpC1.controller',
        type: 'get',
        dataType: 'json',
        'data': '',
        contentType: 'application/json',
        mimeType: 'application/json',
        success: function (data) {
        	var Obj = JSON.parse(JSON.stringify(data));
        	ObjC1C2 = Obj;        		
        }});
}
//把輸入的欄位覆蓋回頁面
function dgChangeVal(theTr){
	$("tr[id="+theTr+"] :input").each(function(index,value){
		//console.log("funChangeVal:"+index,value);
		
		var tmpData = String($(this).attr('id'));
		//console.log(tmpData,$(this).val());
		var leth = tmpData.length;
		//Class3ID
		var culmC3Id = tmpData.substring(0,12);
		var Class3ID = tmpData.substring(12,leth);
//		console.log("culmFId:"+culmFId);
		//PriceID
		var culmPz = tmpData.substring(0,7);			
		var PzId = tmpData.substring(7,leth);
		//console.log("culmPz:"+culmPz);
		
		if(culmC3Id=='dgClass3Name'){
			$('font[id="dgfontName'+Class3ID+'"]').html('');
			$('font[id="dgfontName'+Class3ID+'"]').append($(this).val());
		}else if(culmPz=='dgPrice'){
			$('font[id="dgfontPrice'+PzId+'"]').html('');
			$('font[id="dgfontPrice'+PzId+'"]').append($(this).val());
 		}
	});
	//前端驗證數字
	if(errArray!=null){
		$.each(errArray,function(index,Obj){
			//console.log(index,Obj.OgnPrice);			
			dgErorrShow(Obj.theTr,Obj.thelabel,Obj.Class3ID,Obj.OgnName,Obj.OgnPrice);
		});
		errArray = null;
	}
}
//修改右邊屬性欄位
function UpdStatus(theTr){
	var Class3Array = new Array;
	var action = "Update";	
	var tmpClass3;
	
	$("tr[id="+theTr+"] :input").each(function(index,value){			
		//console.log(index,value);
		var tmpData = String($(this).attr('id'));
		//console.log(tmpData,$(this).val());
		var leth = tmpData.length;
		//Class3ID
		var culmC3Id = tmpData.substring(0,12);
		//PriceID
		var culmPz = tmpData.substring(0,7);
		
		if(culmC3Id=='dgClass3Name'){					
			tmpClass3 = $(this).val();			
		}else if(culmPz=='dgPrice'){
			var tmpPrice= $(this).val();
			//console.log("tmpSizePrice:"+tmpSizePrice);
			var objdata = new Object;			
			var PzId = tmpData.substring(7,leth);
			
			objdata.ProdStatusClass3ID = PzId;
			objdata.ProdStatusClass3Price = tmpPrice;
			objdata.ProdStatusClass3Name = tmpClass3;
			//用完清空
			tmpClass3 = "";
			//驗證金額不是輸入數字
			if(!isNaN(tmpPrice)){
				Class3Array.push(objdata);
			}else{					
				var thelabel = $("#"+tmpData).parent().attr("id");
				var OgnName = $("#dgfontName"+PzId).html();
				var OgnPrice = $("#dgfontPrice"+PzId).html();
				//console.log("OgnPricehtml:"+OgnPrice);
				//console.log("thelabel:"+thelabel);
				objdata.theTr = theTr;
				objdata.thelabel = thelabel;
				objdata.Class3ID = PzId;
				objdata.OgnName = OgnName;
				objdata.OgnPrice = OgnPrice;	
				if(errArray==null){
					errArray = new Array;
				}
				errArray.push(objdata);
			}
		}
	});	
	dgCovJsonObjectSetAjax(action,"ProdStatusClass3",Class3Array);
	//將勾選的儲存
	saveChecked();
}
//有錯誤的時候則不讓格子隱藏回去
function dgErorrShow(theTr,thelabel,Class3ID,OgnName,OgnPrice){
	var thelabelid = 'label[id="'+ thelabel +'"]';
	if($(thelabelid).attr("class")=="btn btn-default"){
		$(thelabelid).attr("class","btn btn-danger")
					 .css("color","black")
					 .append(addBtnNO("dgerrNo"));
	}	
	$(thelabelid+' :hidden').show();
	$(thelabelid+' .dgtdfont').hide();
	//把原先的輸入的還原回去
	$('font[id="dgfontName'+Class3ID+'"]').html('');
	$('font[id="dgfontName'+Class3ID+'"]').append(OgnName);
	$('font[id="dgfontPrice'+Class3ID+'"]').html('');	
	$('font[id="dgfontPrice'+Class3ID+'"]').append(OgnPrice);
	//把確定的按鈕重新秀回來
	$("tr[id="+theTr+"] .dgupd").hide();
	$("tr[id="+theTr+"] .dgok").show();
	//必須在事件發生後再載入
	dgerrBeLoad(Class3ID,OgnName,OgnPrice);
}
//必須在事件發生後再error相關事件載入
function dgerrBeLoad(Class3ID,OgnName,OgnPrice){
	$('.dgerrNo').click(function() {
		var thelabel = $(this).parent().parent().attr("id");
		var thelabelid = 'label[id="'+ thelabel +'"]';
		console.log("thelabel:  "+thelabel);
		$(thelabelid).attr("class","btn btn-default");
		$(thelabelid +' :hidden').show();
		$(thelabelid +' :text').hide();
		$('#dgClass3Name'+Class3ID).val(OgnName);
		$('#dgPrice'+Class3ID).val(OgnPrice);
		
		$(this).remove();			
		
		var errCount = 0; 
		
		$('.dgerrNo').each(function(){
			errCount = 1;
		});
			
		if(errCount==0){
			$('.dgupd').show();
			$('.dgok').hide();				
		}				
	});
}
//轉成json物件,再送出ajax===>dialog
function dgCovJsonObjectSetAjax(action,table,status){
	var jsonObj = new Object;
	jsonObj.action = action;
	jsonObj.table = table;
	jsonObj.status = status;
	var JsonData = JSON.stringify(jsonObj);
	console.log("JsonData:"+JsonData);
	dgsetJson(action,JsonData);					
}
//呼叫ajax===>dialog
function dgsetJson(action,jsonData) {
	var action = action;
	$.ajax({
		url : '<%= request.getContextPath() %>/_10_Menu/UpdStatus.controller',
        type: 'get',
        dataType: 'json',
        data: "jsonData=" + jsonData,
        contentType: 'application/json',
        mimeType: 'application/json',
        success: function (data) {
        	if(action == "Insert"){	        		
        		var Obj = JSON.parse(JSON.stringify(data));
        		console.log("Obj:"+Obj);    
        		console.log("ProdStatusClass3ID:"+Obj.ProdStatusClass3ID);
        		if(typeof Obj.ProdStatusClass3ID =="undefined")
        		{
        			$("#dglblNewCel").attr("class","btn btn-danger")
        							 .css("color","black");        			
        		}else{
               		var celClass3ID = Obj.ProdStatusClass3ID,
               			celName = Obj.ProdStatusClass3Name,
               			celPrice = Obj.ProdStatusClass3Price;
               		console.log("Obj.theTr:"+Obj.theTr);
               		var celchk = '<input type=checkbox id=dgClass3ID'+celClass3ID+' value='+celClass3ID+'>';
               		var celtextName = '<input class="dgtxtName" type=text id=dgClass3Name'+celClass3ID+' maxlength="15" size="15" value='+celName+' style="display:none">';
               		var celtextPrice = '<input class="dgtxtPrice" type=text id=dgPrice'+celClass3ID+' maxlength="6" size="6" value='+celPrice+' style="display:none">';            		
               		var celfontName = '<font class="dgtdfont" id=dgfontName'+celClass3ID+'>'+celName+'</font>';
               		var celfontPrice = '<font class="dgtdfont" id=dgfontPrice'+celClass3ID+'>'+celPrice+'</font>';
               		var cellabel = '<label class="btn btn-default" id=dglbl'+celClass3ID +' style="margin: 2px">'+celchk+celtextName+celtextPrice+celfontName+celfontPrice+'元</label>';
               		
               		$('tr[id='+Obj.theTr+'] .dgupd').before(cellabel);
        			$('.dgNewN').click();
        		}
			}else if(action == "Update"){
				console.log("Errordata:"+data); 				
			}			
        }});
}
//呼叫ajax===>新增的C2的按鈕事件
function C2setJson(action,C1ID,Class2Name) {
	var action = action;
	$.ajax({
		url : '<%= request.getContextPath() %>/_10_Menu/InsClass2.controller',
        type: 'get',
        dataType: 'json',
        data: {
        	ProdStatusClass1ID:C1ID,
        	ProdStatusClass2Name:Class2Name
        	},
        contentType: 'application/json',
        mimeType: 'application/json',
        success: function (data) {
        	if(action == "Insert"){	        		
        		var Obj = JSON.parse(JSON.stringify(data));
        		console.log("Obj:"+Obj);    
        		console.log("ProdStatusClass2ID:"+Obj.ProdStatusClass2ID);
        		if(typeof Obj.ProdStatusClass2ID =="undefined")
        		{
        			$("#lblSzNewCel").attr("class","btn btn-danger")
        							 .css("color","black");        			
        		}else{
        			$('.C2NewN').click();
        			$('#dialogClass2').dialog( "close" );
					location.reload(true);
        		}
        	}
        }
    });
}
//刪除物件
function delObj(){
	var deldiv = $('<a/>');
	deldiv.html('<button type="button" class="btn btn-default btnDel" aria-label="Left Align"><span class="glyphicon glyphicon-remove text-danger" aria-hidden="true"></span></button>');
	return deldiv;
}
//刪除物件必須載入的事件
function beLoadDelAttr(){
	$('.btnDel').click(function(){
		alert();
	});
}
</script>
</body>
</html>