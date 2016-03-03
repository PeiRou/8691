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
				<div class="col-lg-12 text-center">
				<div class="table-responsive">
					<table id="tble" class="table text-left">
				<div id="trunkMenu"></div>
					</table>
					<c:url value="/_10_Menu/GetMenu.controller" var="GetMenupath"></c:url>
								<a class="btn btn-success tdupd" href="${path}">修改</a>	
					<c:set value="${select}" var="fuckyou" ></c:set>				
						<input id="hidData" type="hidden" value='${fuckyou}' />
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
    //var data = $('#hidData').val();
    var data = '[{"FoodStatus":[{"ProdStatus":[{"ProdStatusClass3Price":"5","ProdStatusClass2ID":"3","ProdStatusClass3ID":"1","ProdStatusClass3Name":"珍珠"}],"GroupClass3ID":"1","ProdStatusClass3ID":"1"},{"ProdStatus":[{"ProdStatusClass3Price":"5","ProdStatusClass2ID":"3","ProdStatusClass3ID":"2","ProdStatusClass3Name":"椰果"}],"GroupClass3ID":"1","ProdStatusClass3ID":"2"},{"ProdStatus":[{"ProdStatusClass3Price":"5","ProdStatusClass2ID":"3","ProdStatusClass3ID":"3","ProdStatusClass3Name":"粉條"}],"GroupClass3ID":"1","ProdStatusClass3ID":"3"},{"ProdStatus":[{"ProdStatusClass3Price":"5","ProdStatusClass2ID":"3","ProdStatusClass3ID":"4","ProdStatusClass3Name":"綠豆"}],"GroupClass3ID":"1","ProdStatusClass3ID":"4"},{"ProdStatus":[{"ProdStatusClass3Price":"0","ProdStatusClass2ID":"2","ProdStatusClass3ID":"6","ProdStatusClass3Name":"少糖(7分)"}],"GroupClass3ID":"1","ProdStatusClass3ID":"6"},{"ProdStatus":[{"ProdStatusClass3Price":"0","ProdStatusClass2ID":"2","ProdStatusClass3ID":"7","ProdStatusClass3Name":"半糖(5分)"}],"GroupClass3ID":"1","ProdStatusClass3ID":"7"}],"GroupClass3ID":"1","FoodID":"1","ProdStatusClass1ID":1,"AccountUID":"6D4B16EF-F830-4374-AF0B-8E19EA997D5F","FoodPhoto":"","FoodName":"珍珠奶茶"}, {"FoodStatus":[{"ProdStatus":[{"ProdStatusClass3Price":"5","ProdStatusClass2ID":"3","ProdStatusClass3ID":"1","ProdStatusClass3Name":"珍珠"}],"GroupClass3ID":"1","ProdStatusClass3ID":"1"},{"ProdStatus":[{"ProdStatusClass3Price":"5","ProdStatusClass2ID":"3","ProdStatusClass3ID":"2","ProdStatusClass3Name":"椰果"}],"GroupClass3ID":"1","ProdStatusClass3ID":"2"},{"ProdStatus":[{"ProdStatusClass3Price":"5","ProdStatusClass2ID":"3","ProdStatusClass3ID":"3","ProdStatusClass3Name":"粉條"}],"GroupClass3ID":"1","ProdStatusClass3ID":"3"},{"ProdStatus":[{"ProdStatusClass3Price":"5","ProdStatusClass2ID":"3","ProdStatusClass3ID":"4","ProdStatusClass3Name":"綠豆"}],"GroupClass3ID":"1","ProdStatusClass3ID":"4"},{"ProdStatus":[{"ProdStatusClass3Price":"0","ProdStatusClass2ID":"2","ProdStatusClass3ID":"6","ProdStatusClass3Name":"少糖(7分)"}],"GroupClass3ID":"1","ProdStatusClass3ID":"6"},{"ProdStatus":[{"ProdStatusClass3Price":"0","ProdStatusClass2ID":"2","ProdStatusClass3ID":"7","ProdStatusClass3Name":"半糖(5分)"}],"GroupClass3ID":"1","ProdStatusClass3ID":"7"}],"GroupClass3ID":"1","FoodID":"4","ProdStatusClass1ID":1,"AccountUID":"6D4B16EF-F830-4374-AF0B-8E19EA997D5F","FoodPhoto":"","FoodName":"奶茶"}, {"FoodStatus":[{"ProdStatus":[{"ProdStatusClass3Price":"5","ProdStatusClass2ID":"3","ProdStatusClass3ID":"1","ProdStatusClass3Name":"珍珠"}],"GroupClass3ID":"1","ProdStatusClass3ID":"1"},{"ProdStatus":[{"ProdStatusClass3Price":"5","ProdStatusClass2ID":"3","ProdStatusClass3ID":"2","ProdStatusClass3Name":"椰果"}],"GroupClass3ID":"1","ProdStatusClass3ID":"2"},{"ProdStatus":[{"ProdStatusClass3Price":"5","ProdStatusClass2ID":"3","ProdStatusClass3ID":"3","ProdStatusClass3Name":"粉條"}],"GroupClass3ID":"1","ProdStatusClass3ID":"3"},{"ProdStatus":[{"ProdStatusClass3Price":"5","ProdStatusClass2ID":"3","ProdStatusClass3ID":"4","ProdStatusClass3Name":"綠豆"}],"GroupClass3ID":"1","ProdStatusClass3ID":"4"},{"ProdStatus":[{"ProdStatusClass3Price":"0","ProdStatusClass2ID":"2","ProdStatusClass3ID":"6","ProdStatusClass3Name":"少糖(7分)"}],"GroupClass3ID":"1","ProdStatusClass3ID":"6"},{"ProdStatus":[{"ProdStatusClass3Price":"0","ProdStatusClass2ID":"2","ProdStatusClass3ID":"7","ProdStatusClass3Name":"半糖(5分)"}],"GroupClass3ID":"1","ProdStatusClass3ID":"7"}],"GroupClass3ID":"1","FoodID":"5","ProdStatusClass1ID":1,"AccountUID":"6D4B16EF-F830-4374-AF0B-8E19EA997D5F","FoodPhoto":"","FoodName":"豆漿紅茶"}, {"FoodStatus":[{"ProdStatus":[{"ProdStatusClass3Price":"5","ProdStatusClass2ID":"3","ProdStatusClass3ID":"1","ProdStatusClass3Name":"珍珠"}],"GroupClass3ID":"1","ProdStatusClass3ID":"1"},{"ProdStatus":[{"ProdStatusClass3Price":"5","ProdStatusClass2ID":"3","ProdStatusClass3ID":"2","ProdStatusClass3Name":"椰果"}],"GroupClass3ID":"1","ProdStatusClass3ID":"2"},{"ProdStatus":[{"ProdStatusClass3Price":"5","ProdStatusClass2ID":"3","ProdStatusClass3ID":"3","ProdStatusClass3Name":"粉條"}],"GroupClass3ID":"1","ProdStatusClass3ID":"3"},{"ProdStatus":[{"ProdStatusClass3Price":"5","ProdStatusClass2ID":"3","ProdStatusClass3ID":"4","ProdStatusClass3Name":"綠豆"}],"GroupClass3ID":"1","ProdStatusClass3ID":"4"},{"ProdStatus":[{"ProdStatusClass3Price":"0","ProdStatusClass2ID":"2","ProdStatusClass3ID":"6","ProdStatusClass3Name":"少糖(7分)"}],"GroupClass3ID":"1","ProdStatusClass3ID":"6"},{"ProdStatus":[{"ProdStatusClass3Price":"0","ProdStatusClass2ID":"2","ProdStatusClass3ID":"7","ProdStatusClass3Name":"半糖(5分)"}],"GroupClass3ID":"1","ProdStatusClass3ID":"7"}],"GroupClass3ID":"1","FoodID":"6","ProdStatusClass1ID":1,"AccountUID":"6D4B16EF-F830-4374-AF0B-8E19EA997D5F","FoodPhoto":"","FoodName":"綠茶"}]';
    var json = JSON.parse(data);
    //console.log(data);
	LoadTable(json);
    $.each(json,function(index,jsonVal) {
    	//console.log(jsonVal.FoodName);
    	//console.log(jsonVal.GroupClass3ID);
	    if(jsonVal.FoodStatus!="") { 
		    $.each(jsonVal.FoodStatus, function(index,FoodStusVal){
			    $.each(FoodStusVal.ProdStatus,function(index,value){
// 				    console.log("ProdStatusClass3ID: "+value.ProdStatusClass3ID);
// 				    console.log("ProdStatusClass3Name: "+value.ProdStatusClass3Name);
// 				    console.log("ProdStatusClass2ID: "+value.ProdStatusClass2ID);
// 				    console.log("ProdStatusClass3Price: "+value.ProdStatusClass3Price);
			    });
		    });
	    }
	});
    $(function(){
    	//
    	//LoadProdStatusClass3();
    });
    //第一次載入
    function LoadTable(jsonVal){
    	$.each(jsonVal, function(index,FoodStusVal){
    		console.log("FoodName:  "+index+":"+FoodStusVal.FoodName);    		
    		console.log("GroupClass3ID:  "+index+":"+FoodStusVal.GroupClass3ID);
    		InsGroup(FoodStusVal.FoodID,FoodStusVal.FoodName);
        	var trunkTd = $("<td></td>").append("123");
        	var trunkTr = $("<tr id=GroupTr'"+ FoodStusVal.GroupClass3ID +"'></tr>").append(trunkTd);
    	});
    	$('#trunkMenu').append(trunkTr);
    }
	function LoadProdStatusClass3() {
		var action = "Select"
		var Class2ID = "3";
		//InsCel()
	}
	function loopCel(){
		
		
	}
	function InsGroup(celFoodID,celFoodName) {		
		var celchk = $('<input type=checkbox class="tdtext" id=celClass3ID'+celFoodID+'>').val(celFoodID);
		var celtextName = $('<input type=text class="tdtext" id=celFoodName'+celFoodID+' maxlength="6" size="6">').val(celFoodName);
		var celfont = $('<font class="tdfont" id=celfont'+celFoodID+'></font>').text(celFoodName);
		var cellabel = $('<label class="btn btn-default" id=cellbl'+celFoodID +' style="margin: 2px"></label>').prepend(celchk).append(celtextName).append(celfont);
		$('<div id="div'+ celFoodID +'"></div>').append(cellabel);
		$(":text").hide();
	}
	function InsCel(celClass3ID,celName,celPrice) {		
		var celchk = $('<input type=checkbox class="tdtext" id=celClass3ID'+celClass3ID+'>').val(celClass3ID);
		var celtextName = $('<input type=text class="tdtext" id=celClass3Name'+celClass3ID+' maxlength="6" size="6">').val(celName);
		var celtextPrice = $('<input type=text class="tdtext" id=celPrice'+celClass3ID+' maxlength="6" size="6">').val(celPrice);
		var celfont = $('<font class="tdfont" id=celfont'+celClass3ID+'></font>').text(celName+celPrice);
		var cellabel = $('<label class="btn btn-default" id=cellbl'+celClass3ID +' style="margin: 2px"></label>').prepend(celchk).append(celtextName).append(celtextPrice).append(celfont).append("元");
		if(celClass3ID=="NewCel"){
			var btnNew = fucBtnOkCancel();
			cellabel.append(btnNew);
		}
		$('<div id="div'+  +'"></div>').append(cellabel);
		$(":text").hide();
	}
</script>
</body>
</html>