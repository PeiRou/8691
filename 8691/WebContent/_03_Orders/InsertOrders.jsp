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

    <title>8691訂單資訊</title>

    <!-- Bootstrap Core CSS -->
    <link href="<%= request.getContextPath() %>/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="<%= request.getContextPath() %>/css/business-casual.css" rel="stylesheet">

    <!-- Fonts -->
    <link href="http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800" rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/css?family=Josefin+Slab:100,300,400,600,700,100italic,300italic,400italic,600italic,700italic" rel="stylesheet" type="text/css">
	<title>訂單資訊</title>
</head>
<body>
<jsp:include page="/fragment/top.jsp" />
	<div class="container">
		<div class="row">
			<div class="box">		
				<div class="col-md-12">
					<h2 class="text-center">結帳</h2>
					<form id=myform action="<c:url value='/_03_Orders/InsertOrdersServlet' />" method="post">
					<table id="t01" class="table">
						<tr style="display:none">
							<td class="col-xs-8 col-sm-6 text-right">Account_UID : </td>
							<td><input type="text" name="account_UID" value="${param.account_UID}"></td>
							<td>${error.account_UID}</td>
						</tr>
						<tr style="display:none">
							<td class="col-xs-8 col-sm-6 text-right">seller_UID : </td>
							<td><input type="text" name="seller_UID" value="6D4B16EF-F830-4374-AF0B-8E19EA997D5F"></td>
							<td>${error.seller_UID}</td>
						</tr>
						<tr style="display:none">
							<td class="col-xs-8 col-sm-6 text-right">ordersID : </td>
							<td><input type="text" name="ordersID" value="7010"></td>
							<td>${error.ordersID}</td>
						</tr>
						<tr>
							<td class="col-xs-8 col-sm-6 text-right">訂購人姓名 : </td>
							<td><input type="text" name="name" value="大安陳奕迅"></td>
							<td>${error.name}</td>
						</tr>
						<tr>
							<td class="text-right">訂購人手機 : </td>
							<td><input type="text" name="cel" value="0989123456"></td>
							<td>${error.cel}</td>
						</tr>
						<tr>
							<td class="text-right">請選擇住址(縣/市) :</td>
							<td><select name="GUAR_CT" size="1" value="${param.GUAR_CT}">
													<option value="" selected>請選擇</option>
									                <option value="A">臺北市</option>
												    <option value="B">臺中市 </option>
													<option value="C">基隆市</option>
												    <option value="D">臺南市</option>
													<option value="E">高雄市</option>
													<option value="F">新北市</option>
													<option value="G">宜蘭縣</option>
													<option value="H">桃園市</option>
													<option value="I">嘉義市</option>
													<option value="J">新竹縣</option>
													<option value="K">苗栗縣</option>
													<option value="M">南投縣</option>
													<option value="N">彰化縣</option>
													<option value="O">新竹市</option>
													<option value="P">雲林縣</option>
													<option value="Q">嘉義縣</option>
													<option value="T">屏東縣</option>
													<option value="U">花蓮縣</option>
													<option value="V">臺東縣</option>
													<option value="W">金門縣</option>
													<option value="X">澎湖縣</option>
													<option value="Z">連江縣</option>
							</select></td>
							<td></td>
						</tr>
						
						<tr>
							<td class="text-right">住址(區/鄉/鎮/市) :</td>
								<td><select id="select1" name="GUAR_AR">
								<option value="" selected>請選擇</option>
								</select></td>
							<td></td>
						</tr>
						
						<tr>
							<td class="text-right">請輸入住址(路/街/巷) :</td>
							<td><input id="keyword" type="text" value=""> <input id="textval" name="GUAR_ROAD" type="text" style="display:none"><span id="roadsp" style="color:red"></span></td>
							<td></td>
						</tr>
				
						<tr>
							<td></td>
							<td id="tb"></td>
							<td></td>
						</tr>
						
						<tr>
							<td class="text-right">請輸入住址(號) :</td>
							<td><input type="text" name="GUAR_NO" value="${param.GUAR_NO}" id="addrinput"><span id="addrsp" style="color:red"></span></td>
							<td>${error.GUAR_NO}</td>
						</tr>
						<tr>
							<td class="text-right">付款方式 : </td>
							<td>	
							<select name="pay_metho" value="${param.pay_metho}">
					        <option value="貨到付款" selected>貨到付款</option>
					        <option value="信用卡">信用卡</option></select>
					        </td>
							<td>${error.pay_metho}</td>
						</tr>
						<tr style="display:none">
							<td class="text-right">食物ID: </td>
							<td><input type="text" name="Food_ID" value="309"></td>
							<td>${error.Food_ID}</td>
						</tr>
						<tr style="display:none">
							<td class="text-right">品名: </td>
							<td><input type="text" name="drink_name" value="波霸紅茶拿鐵"></td>
							<td>${error.drink_name}</td>
						</tr>
						<tr>
							<td class="col-xs-8 col-sm-6 text-right">訂購店家: </td>
							<td>${storeName}</td>
							<td></td>
						</tr>	
						<tr style="display:none">
							<td>食物總金額: </td>
							<td><input type="text" id=hidfoodPrice name="food_price" value="${total}"></td>
							<td>${error.ship_price}</td>
						</tr>					
						<tr>
							<td class="text-right">食物總金額: </td>
							<td>${total}元</td>
							<td></td>
						</tr>
						<tr style="display:none">
							<td>運費: </td>
							<td><input type="text" id=hidSipPrice name="ship_price" value="150"></td>
							<td>${error.ship_price}</td>
						</tr>
						<tr>
							<td class="text-right">運費: </td>
							<td>150元</td>
							<td>${error.ship_price}</td>
						</tr>
						<tr style="display:none">
							<td>總金額: </td>
							<td><input type="text" id=hidTT name="total_amount" value="123"></td>
							<td>${error.ship_price}</td>
						</tr>							
							<tr>
							<td class="text-right">總金額: </td>
							<td><input type="text" name="total_amount" value="123" disabled="disabled"></td>
							<td>${error.total_amount}</td>
						</tr>
						<tr style="display:none">
							<td class="text-right">備註: </td>
							<td><input type="text" name="note" value="半糖去冰"></td>
							<td>${error.note}</td>
						</tr>
						<tr>
							<td class="text-right">備註: </td>
							<td>半糖去冰</td>
							<td></td>
						</tr>												
						<tr>
							<td></td>
							<td><input id=btnsub type="button" value="確認結帳" class="btn btn-primary"></td>
							<td></td>
						</tr>
					</table>
					</form>
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
    <script>
    
    	var tmpF = $('#hidfoodPrice').val();
    	var tmpP = $('#hidSipPrice').val();
    	var tmpTT = parseInt(tmpF)+parseInt(tmpP);
    	$('input[name=total_amount]').val(tmpTT);
    	$('#hidTT').val(tmpTT);
    
    $('#btnsub').click(function(){
    	$('#myform').submit();
    });
		//進入首頁後立刻從資料庫讀取區域的下拉式選單內容
	    $(function(){
				   $.ajax({
					  'type':'get',
					  'url':'<%= request.getContextPath() %>/GetAddress',
					  'data':{},
					  'dataType':'xml',
					  'success':function(data){
						$(data).find("Category").each(function(){
							var categoryId = $(this).children("GUAR_AR").text();
							var categoryName = $(this).children("GUAR_AR_name").text();
							var opt = $("<option></option>").val(categoryId).text(categoryName);
							$('#select1').append(opt);
						})
					  }
				   });
				   $('#tb').empty();
			});
	    
	    //當更換選單內容時，清空路名&關鍵字查詢
	    $('#select1').change(function(){
	    		$('#tb').empty();
	    		$("#keyword").val('');
		   });
	    
	    //關鍵字輸入事件
	        var timer;
	        $("#keyword").on('keyup',function() {
	        	$('#tb').empty();
	            timer && clearTimeout(timer);
	            timer = setTimeout(LoadRoad, 500);
	        });
	    
	    //路名查詢autocomplete
	    function LoadRoad(){
	    	   if($('#keyword').val() =='' || $('#keyword').val().trim() ==''){
				   $('#tb').empty();
			   }else{
				   $.getJSON('<%= request.getContextPath() %>/GetRoad',
						   	{'GUAR_AR':$('#select1').val(), 
					   		 'keyword':$('#keyword').val()},
					function(datas){
					   			$.each(datas,function(index,road){
					   				var celltext = $('<input type=text class="txt" style="display:none">').val(road.GUAR_ROAD);
					   				var cellGUAR_ROAD_name = $('<label class="txt1"></label>').text(road.GUAR_ROAD_name);
					   				var cell1 = $("<td></td>").append(celltext).append(cellGUAR_ROAD_name);
					   				//var cell1 = $("<td></td>").text(road.GUAR_ROAD_name);
									var row = $("<tr></tr>").append([cell1])
									                        .mouseover(function(){
									                        	$(this).css('color', 'red');
									                        })
									                        .mouseout(function(){
									                        	$(this).css('color', 'black');
									                        })
									                        .click(function(){
									                        	$('#textval').val($(this).children().children(".txt").val());
									                        	$('#keyword').val($(this).children().children(".txt1").text());
									                        	$('#tb').empty();
									                        });
									$('#tb').append(row);
								});
							});
			  		 }
		  	 };
		  	</script>
    <!-- Bootstrap Core JavaScript -->
    <script src="<%= request.getContextPath() %>/js/bootstrap.min.js"></script>
</body>
</html>