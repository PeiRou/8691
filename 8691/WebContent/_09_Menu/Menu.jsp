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

    
</head>
<body>
<jsp:include page="/fragment/top.jsp" />
	<div class="container">
		<div class="row">
			<div class="box">
				<div class="col-lg-12">
				<div class="table-responsive" id="test">
				<table id="tbl" class="table table-bordered">
				<tr>
					<td width="">品名</td>
					<td>屬性</td>
					<td></td>
				</tr>
				</table>
					<div id="trunkMenu"></div>
					<c:url value="/_10_Menu/GetMenu.controller" var="GetMenupath"></c:url>
								
						<c:set value="${select}" var="FoodStaus"></c:set>
						<input id="hidFoodStaus" type="hidden" value='${FoodStaus}' />
						<c:set value="${selectGroup}" var="Group"></c:set>
						<input id="hidGroup" type="hidden" value='${Group}' />
						<c:set value="${selectSzSts}" var="SzSts"></c:set>
						<input id="hidSzSts" type="hidden" value='${SzSts}' />
						<c:set value="${selectPrCl2}" var="PrCl2"></c:set>
						<input id="hidPrCl2" type="hidden" value='${PrCl2}' />
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
                    <p>Copyright &copy; Your Website 2016</p>
                </div>
            </div>
        </div>
    </footer>

    <!-- jQuery -->
    <script src="<%= request.getContextPath() %>/js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="<%= request.getContextPath() %>/js/bootstrap.min.js"></script>
    <script>
//     var data = $('#hidFoodStaus').val();
//     var Group = $('#hidGroup').val();
//     var SzSts = $('#hidSzSts').val();
//     var PrCl2 = $('#hidPrCl2').val();
    var data = '[{"FoodPrice":[{"FoodSizePriceID":"1","SizeStatusID":"2","FoodID":"1","SizeStatus":[{"SizeStatusID":"2","SizeName":"小"}],"FoodStatusPrice":"40"},{"FoodSizePriceID":"2","SizeStatusID":"3","FoodID":"1","SizeStatus":[{"SizeStatusID":"3","SizeName":"中"}],"FoodStatusPrice":"45"}],"GroupClass3ID":"1","FoodID":"1","ProdStatusClass1ID":"1","AccountUID":"6D4B16EF-F830-4374-AF0B-8E19EA997D5F","FoodPhoto":"","FoodName":"珍珠奶茶"}, {"FoodPrice":[{"FoodSizePriceID":"7","SizeStatusID":"1","FoodID":"4","SizeStatus":[{"SizeStatusID":"1","SizeName":"預設"}],"FoodStatusPrice":"50"}],"GroupClass3ID":"1","FoodID":"4","ProdStatusClass1ID":"1","AccountUID":"6D4B16EF-F830-4374-AF0B-8E19EA997D5F","FoodPhoto":"","FoodName":"奶茶"}, {"FoodPrice":[{"FoodSizePriceID":"8","SizeStatusID":"1","FoodID":"5","SizeStatus":[{"SizeStatusID":"1","SizeName":"預設"}],"FoodStatusPrice":"45"}],"GroupClass3ID":"1","FoodID":"5","ProdStatusClass1ID":"1","AccountUID":"6D4B16EF-F830-4374-AF0B-8E19EA997D5F","FoodPhoto":"","FoodName":"豆漿紅茶"}, {"FoodPrice":[{"FoodSizePriceID":"9","SizeStatusID":"1","FoodID":"6","SizeStatus":[{"SizeStatusID":"1","SizeName":"預設"}],"FoodStatusPrice":"60"}],"GroupClass3ID":"1","FoodID":"6","ProdStatusClass1ID":"1","AccountUID":"6D4B16EF-F830-4374-AF0B-8E19EA997D5F","FoodPhoto":"","FoodName":"綠茶"}, {"FoodPrice":[],"GroupClass3ID":"2","FoodID":"7","ProdStatusClass1ID":"1","AccountUID":"6D4B16EF-F830-4374-AF0B-8E19EA997D5F","FoodPhoto":"","FoodName":"沙士"}, {"FoodPrice":[],"GroupClass3ID":"2","FoodID":"8","ProdStatusClass1ID":"1","AccountUID":"6D4B16EF-F830-4374-AF0B-8E19EA997D5F","FoodPhoto":"","FoodName":"青茶"}, {"FoodPrice":[],"GroupClass3ID":"2","FoodID":"9","ProdStatusClass1ID":"1","AccountUID":"6D4B16EF-F830-4374-AF0B-8E19EA997D5F","FoodPhoto":"","FoodName":"烏龍綠茶"}]';
    var Group = '[{"FoodStatus":[{"ProdStatus":[{"ProdStatusClass3Price":"5","ProdStatusClass2ID":"3","ProdStatusClass3ID":"1","ProdStatusClass3Name":"珍珠"}],"GroupClass3ID":"1","ProdStatusClass3ID":"1"},{"ProdStatus":[{"ProdStatusClass3Price":"5","ProdStatusClass2ID":"3","ProdStatusClass3ID":"2","ProdStatusClass3Name":"椰果"}],"GroupClass3ID":"1","ProdStatusClass3ID":"2"},{"ProdStatus":[{"ProdStatusClass3Price":"5","ProdStatusClass2ID":"3","ProdStatusClass3ID":"3","ProdStatusClass3Name":"粉條"}],"GroupClass3ID":"1","ProdStatusClass3ID":"3"},{"ProdStatus":[{"ProdStatusClass3Price":"5","ProdStatusClass2ID":"3","ProdStatusClass3ID":"4","ProdStatusClass3Name":"綠豆"}],"GroupClass3ID":"1","ProdStatusClass3ID":"4"},{"ProdStatus":[{"ProdStatusClass3Price":"0","ProdStatusClass2ID":"2","ProdStatusClass3ID":"6","ProdStatusClass3Name":"少糖(7分)"}],"GroupClass3ID":"1","ProdStatusClass3ID":"6"},{"ProdStatus":[{"ProdStatusClass3Price":"0","ProdStatusClass2ID":"2","ProdStatusClass3ID":"7","ProdStatusClass3Name":"半糖(5分)"}],"GroupClass3ID":"1","ProdStatusClass3ID":"7"}],"GroupClass3Name":"這是測試","GroupClass3ID":"1"}, {"FoodStatus":[{"ProdStatus":[{"ProdStatusClass3Price":"5","ProdStatusClass2ID":"3","ProdStatusClass3ID":"2","ProdStatusClass3Name":"椰果"}],"GroupClass3ID":"2","ProdStatusClass3ID":"2"},{"ProdStatus":[{"ProdStatusClass3Price":"5","ProdStatusClass2ID":"3","ProdStatusClass3ID":"3","ProdStatusClass3Name":"粉條"}],"GroupClass3ID":"2","ProdStatusClass3ID":"3"},{"ProdStatus":[{"ProdStatusClass3Price":"0","ProdStatusClass2ID":"2","ProdStatusClass3ID":"6","ProdStatusClass3Name":"少糖(7分)"}],"GroupClass3ID":"2","ProdStatusClass3ID":"6"},{"ProdStatus":[{"ProdStatusClass3Price":"0","ProdStatusClass2ID":"2","ProdStatusClass3ID":"7","ProdStatusClass3Name":"半糖(5分)"}],"GroupClass3ID":"2","ProdStatusClass3ID":"7"}],"GroupClass3Name":"我的最愛","GroupClass3ID":"2"}]';
    var SzSts = '[{"SizeStatusID":"1","SizeName":"預設"}, {"SizeStatusID":"2","SizeName":"小"}, {"SizeStatusID":"3","SizeName":"中"}, {"SizeStatusID":"4","SizeName":"大"}]';
    var PrCl2 = '[{"ProdStatusClass2ID":"1","ProdStatusClass1ID":"1","ProdStatusClass2Name":"冷熱"}, {"ProdStatusClass2ID":"2","ProdStatusClass1ID":"1","ProdStatusClass2Name":"甜度"}, {"ProdStatusClass2ID":"3","ProdStatusClass1ID":"1","ProdStatusClass2Name":"加料"}]';
    var jsonVal = JSON.parse(data);
    var jsonGroup = JSON.parse(Group);
    var jsonSzSts = JSON.parse(SzSts);
    var jsonPrCl2 = JSON.parse(PrCl2);
    
 	LoadTable(jsonVal,jsonGroup);
	$(":text").hide();
	$(":input").attr('disabled', true);
	$(":text").attr("maxlength",6);
	$(":text").attr("size",6);
	$(".tdok").hide();
	
	$('.tdupd').click(function() {	
		var theTr = $(this).parent().parent().attr("id");
		$("tr[id="+theTr+"] :text").show();
		$("tr[id="+theTr+"] :input").attr('disabled', false);
		$("tr[id="+theTr+"] .tdfont").hide();		
		$(this).hide();
		$("tr[id="+theTr+"] .tdok").show();
	});
	$('.tdok').click(function() {
		$(":text").hide();
		$(".tdfont").show();			
		$(this).hide();
		$('.tdupd').show();
		$(":input").attr('disabled', true);
		var theTr = $(this).parent().parent().attr("id");
		UpdTable(theTr);
		//把輸入的欄位覆蓋回頁面
		funChangeVal(theTr);
	});	
	//第一次載入
    function LoadTable(jsonVal,jsonGroup){ 	    	
    	$.each(jsonGroup, function(index,GroupVal){
        	var trunkStusTd = $("<td></td>");
        	var trunkFoodTd = $("<td></td>");
        	var btnIns = $('<a class="btn btn-warning tdinsfood"></a>').text('新增食物');
        	var btnUpd = $('<a class="btn btn-success tdupd"></a>').text('修改');
        	var btnOk = $('<a class="btn btn-success tdok"></a>').text('確定');
        	var trunkbtn = $("<td></td>").append(btnUpd).append(btnOk);
    		var GroupStus = insGroupStus(GroupVal.FoodStatus);	    	
	    	trunkStusTd.append(GroupStus);
	    	$.each(jsonVal, function(index,FodStuVal){
	    		if (GroupVal.GroupClass3ID==FodStuVal.GroupClass3ID){    		
		    		var GroupFoods = insGroupFood(FodStuVal.FoodID,FodStuVal.FoodName,FodStuVal.FoodPrice);
		    		trunkFoodTd.append(GroupFoods);
	        	}
	    	});
	    	trunkFoodTd.append(btnIns);
	    	var trunkTr = $("<tr id=GroupTr"+ GroupVal.GroupClass3ID +"></tr>").append(trunkFoodTd).append(trunkStusTd).append(trunkbtn);
	    	$('#tbl tr:last').after(trunkTr);
    	});
    }
	function loopceltextPrices(FoodID,PriceStus){
		var appPrices = $("<a/>");
		$.each(PriceStus,function(index,PriceVal){
			$.each(PriceVal.SizeStatus,function(index,SzSts){
				if(PriceVal.SizeStatusID==SzSts.SizeStatusID){
					var lblPrice = insPrice(SzSts.SizeStatusID,PriceVal.FoodSizePriceID,PriceVal.FoodStatusPrice);
					if(FoodID==PriceVal.FoodID){
						appPrices.append(lblPrice).html();
					}
				}
			});
		});
		return appPrices;
	}
	
	//尺寸下拉式選單，給定值後順便綁定
	function selectSizeName(SizePriceID,ID){
		var select = $('<select id=selSizePrice'+ SizePriceID +'></select>');
		$.each(jsonSzSts,function(index,Sizeval){
			if(Sizeval.SizeStatusID==ID){
				select.append($('<option></option>').val(Sizeval.SizeStatusID).text(Sizeval.SizeName).attr('selected',true));
			}else{
				select.append($('<option></option>').val(Sizeval.SizeStatusID).text(Sizeval.SizeName));
			}
		});
		return select;
	}
	
	//組多個size+名稱的label
	function insPrice(ID,SizePriceID,SizePrice) {
		var celtextName = $('<input type=text id=txtSizePrice'+SizePriceID+'>').val(SizePrice);
		var celfont = $('<font class="tdfont" id=fontSizePrice'+SizePriceID+'></font>').text(SizePrice);
		var celSeld = selectSizeName(SizePriceID,ID);
		var cellabel = $('<label class="btn btn-default active" id=lblSizePrice'+SizePriceID +' style="margin: 2px"></label>').append(celSeld).append(celfont).append(celtextName);
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
					var btnIns = $('<a class="btn btn-info tdinsC3"></a>').text('新增細項');
					appClass3.append(btnIns);
					var Class2 =insclass2(PrCl2val.ProdStatusClass2ID,PrCl2val.ProdStatusClass2Name);	
					appeds.append(Class2).append(appClass3).html();
				}
			}
		});
		var btnIns = $('<a class="btn btn-primary tdinsC2"></a>').text('新增類別');
		appeds.append(btnIns);
		$('#trunkMenu').append(appeds);
		return appeds;
	}
	//多個食物品名含有多個價錢
	function insGroupFood(celFoodID,celFoodName,celFoodPrice) {
		var celtextName = $('<input type=text id=txtFood'+celFoodID+'>').val(celFoodName);
		var celfont = $('<font class="tdfont" id=fontFood'+celFoodID+'></font>').text(celFoodName);
		var celPrices = loopceltextPrices(celFoodID,celFoodPrice);
		var cellabel = $('<label class="btn btn-default" id=lblFood'+celFoodID +' style="margin: 2px"></label>').append(celfont).append(celtextName).append(celPrices);		
		
		return cellabel;
	}
	//class2屬性值
	function insclass2(Class2ID,Class2Name) {		
		var celtextName = $('<input type=text class="tdtext" id=Class2'+Class2ID+'>').val(Class2Name);		
		var celfont = $('<font class="tdfont" id=celfont'+Class2ID+'></font>').text(Class2Name);
		var cellabel = $('<label class="btn btn-default btn-lg active" id=cellbl'+Class2ID +' style="margin: 2px"></label>').append(celtextName).append(celfont);
		return cellabel;
	}
	//class3屬性值
	function insClass3(Class3ID,Class3Name,Class3Price) {		
		var celtextName = $('<input type=text class="tdtext" id=celClass3Name'+Class3ID+'>').val(Class3Name);
		var celtextPrice = $('<input type=text class="tdtext" id=celPrice'+Class3ID+'>').val(Class3Price);
		var celfont = $('<font class="tdfont" id=celfont'+Class3ID+'></font>').text(Class3Name+Class3Price);
		var cellabel = $('<label class="btn btn-default" id=cellbl'+Class3ID +' style="margin: 2px"></label>').append(celtextName).append(celtextPrice).append(celfont).append("元");
		return cellabel;
	}   
	//修改資料
	function UpdTable(theTr){
		var dataArray = new Array;
		var foodArray = new Array;
		var SzPzArray = new Array;
		var action = "Update";
		var tmpSize;
		
		$("tr[id="+theTr+"] :input").each(function(index,value){			
			//console.log(index);
			var tmpData = String($(this).attr('id'));
			//console.log(tmpData,$(this).val());
			var leth = tmpData.length;
			
			var culmId = tmpData.substring(0,7);
			var FoodId = tmpData.substring(7,leth);
			
			var culmSzPz = tmpData.substring(0,12);			
			var SzPzId = tmpData.substring(12,leth);
			
			if(culmId=='txtFood'){					
				var tmpFood = $(this).val();
				var objdata = new Object;
				objdata.FoodID = FoodId;
				objdata.FoodName = tmpFood;
				foodArray.push(objdata);
			}else if(culmSzPz=='selSizePrice'){
				tmpSize= $(this).val();				
			}else if(culmSzPz=='txtSizePrice'){
				var tmpSizePrice= $(this).val();
				var objdata = new Object;
				objdata.FoodSizePriceID = SzPzId;
				objdata.SizeStatusID = tmpSize;
				//用完清空
				tmpSize = "";
				objdata.FoodStatusPrice = tmpSizePrice;
				SzPzArray.push(objdata);
			}
		});
		CovJsonObjectSetAjax(action,"Food",foodArray);
		CovJsonObjectSetAjax(action,"FoodSizePrice",SzPzArray);
	}
	//轉成json物件,再送出ajax
	function CovJsonObjectSetAjax(action,table,status){
		var jsonObj = new Object();
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
					if(data!=0){						
						var Obj = JSON.parse(jsonData);						
						removeNew();
						InsCel(data,Obj.status.ProdStatusClass3Name,Obj.status.ProdStatusClass3Price);						
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
			
			var culmId = tmpData.substring(0,7);
			var FoodId = tmpData.substring(7,leth);
			
			var culmSzPz = tmpData.substring(0,12);			
			var SzPzId = tmpData.substring(12,leth);

			if(culmId=='txtFood'){
				$('font[id="fontFood'+FoodId+'"]').html('');
				$('font[id="fontFood'+FoodId+'"]').append($(this).val());
			}else if(culmSzPz=='txtSizePrice'){
				$('font[id="fontSizePrice'+SzPzId+'"]').html('');
				$('font[id="fontSizePrice'+SzPzId+'"]').append($(this).val());
			}
		});
	}
	//有錯誤的時候則不讓格子隱藏回去
	function fucErorrShow(theTr,thelabel,FoodSizePriceID,OgnPrice){
		$('label[id="'+ thelabel +'"]').attr("class","btn btn-danger")
									   .css("color","black")
									   .append(addBtnNO());
		$('label[id="'+ thelabel +'"] :input').attr('disabled', false)
		$('label[id="'+ thelabel +'"] :hidden').show();
		$('label[id="'+ thelabel +'"] .tdfont').hide();
		//把原先的輸入的還原回去
		$('font[id="fontSizePrice'+FoodSizePriceID+'"]').html('');
		$('font[id="fontSizePrice'+FoodSizePriceID+'"]').append(OgnPrice);
		//把確定的按鈕重新秀回來
		$("tr[id="+theTr+"] .tdupd").hide();
		$("tr[id="+theTr+"] .tdok").show();
		//必須在事件發生後再載入
		beLoad(OgnPrice);
	}
	//取消
	function addBtnNO(){
		var btn = $('<div/>').html('<button type="button" class="btn btn-default NewN" aria-label="Left Align"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></button>');
		return btn;
	}
	//必須在事件發生後再載入
	function beLoad(OgnPrice){
		$('.NewN').click(function() {
			var thelabel = $(this).parent().parent().attr("id");
			console.log("thelabel:  "+thelabel);
			$('label[id="'+ thelabel +'"]').attr("class","btn btn-default");
			$('label[id="'+ thelabel +'"] :input').attr('disabled', true);
			$('label[id="'+ thelabel +'"] :hidden').show();
			$('label[id="'+ thelabel +'"] :text').hide()
												 .val(OgnPrice);
			$(this).remove();			
			
			var errCount = 0; 
			
			$('.NewN').each(function(){
				errCount = 1;
			});
				
			if(errCount==0){
				$('.tdupd').show();
				$('.tdok').hide();				
			}				
		});
	}
</script>
</body>
</html>