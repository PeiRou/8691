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

    <title>8691</title>

    <!-- Bootstrap Core CSS -->
    <link href="<%= request.getContextPath() %>/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="<%= request.getContextPath() %>/css/business-casual.css" rel="stylesheet">

    <!-- Fonts -->
    <link href="http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800" rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/css?family=Josefin+Slab:100,300,400,600,700,100italic,300italic,400italic,600italic,700italic" rel="stylesheet" type="text/css">
	 <style>
    	th{
    		font-size:1em;
    		text-align:center;
    	}
    	td{
    		font-size:1em;
    	}
    	table#t01 tr:nth-child(even) {
		    background-color: #fff;
		}
		table#t01 tr:nth-child(odd) {
		   background-color:#eee;
		}
    </style>
    <link rel="apple-touch-icon" href="<%= request.getContextPath() %>/images/logo.png">
	<link rel="icon" href="<%= request.getContextPath() %>/images/logo.png">
</head>
<body>
<jsp:include page="/fragment/top.jsp" />
	<div class="container">
		<div class="row">
			<div class="box">		
				<div class="col-lg-12">
			<form name="Register" action="<c:url value='/AddrUpdate' />" method="post">
			<h2 class="text-center">修改地址</h2>
			<table id="t01" class="table">
			<tr>
				<td class="col-xs-8 col-sm-6 text-right">修改您所在的縣市 :</td>
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
				<td class="col-xs-8 col-sm-6 text-right">修改住址(區/鄉/鎮/市) :</td>
					<td><select id="select1" name="GUAR_AR">
					<option value="" selected>請選擇</option>
					</select></td>
					<td></td>
			</tr>
			<tr>
				<td class="col-xs-8 col-sm-6 text-right">修改住址(路/街/巷) :</td>
				<td><input id="keyword" type="text" value=""> <input id="textval" name="GUAR_ROAD" type="text" style="display:none"><span id="roadsp" style="color:red"></span></td>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<td id="tb"></td>
				<td></td>
			</tr>
			
			<tr>
				<td class="text-right">修改住址(號) :</td>
				<td><input type="text" name="GUAR_NO" value="${param.GUAR_NO}" id="addrinput"><span id="addrsp" style="color:red"></span></td>
				<td>${error.GUAR_NO}</td>
			</tr>
						
			<tr>

				<td></td>
				<td><input type="submit" value="確定修改" class="btn btn-primary"></td>
				<td></td>
			</tr>
		</table>
	</form>
	</div>
	</div>			
	</div>
	</div>
	<!-- /.container -->

		<script src="//code.jquery.com/jquery-1.12.0.min.js"></script>
		<script>
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
		
			 $('#select1').change(function(){
				 if($('#keyword').val() ==''){
					 $('#tb').empty();
				 }
				 else{
					 LoadRoads();
				 }
			   });
		
			 $('#keyword').keyup(function(){
				 if($('#keyword').val() ==''){
					 $('#tb').empty();
				 }
				 else{
					 LoadRoads();
				 }
			   });
			   
			   function LoadRoads(){
				   $('#tb').empty();
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
			   };
		</script>

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

    <!-- Bootstrap Core JavaScript -->
    <script src="<%= request.getContextPath() %>/js/bootstrap.min.js"></script>
</body>
</html>