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
    <link href="<%=request.getContextPath() %>/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="<%=request.getContextPath() %>/css/business-casual.css" rel="stylesheet">

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
					<h1>註冊為店家</h1>

	<form name="Visitor"
		action="<c:url value='/page/visitor.controller' />" method="post">
		<table>
			<tr>
				<td>輸入您的統一編號 :</td>
				<td><input type="text" name="FEIN" value="${param.FEIN}"></td>
				<td></td>
			</tr>
			<tr>
				<td>輸入您的店家名稱 :</td>
				<td><input type="text" name="name" value="${param.name}"></td>
				<td>${error.name}</td>
			</tr>
			<tr>
				<td>輸入您的帳號 或 email :</td>
				<td><input type="text" name="acc_email" value="${param.acc_email}"></td>
				<td>${error.acc_email}</td>
			</tr>
			<tr>
				<td>輸入您的密碼 :</td>
				<td><input type="text" name="psd" value="${param.psd}"></td>
				<td>${error.psd}</td>
			</tr>
			
			
		     <tr height='36'>
		    <td>輸入您的店家圖片:</td>
<!-- 		        <td width="45" align="center" class="title_font">圖片</td> -->
		        <td colspan="3">
		            <input style="background:#FFFFFF" class='InputClass'  type="file" 
		            name="uploadFile" size="40" />    
		    </tr>
			

			<tr>
				<td>輸入您的連絡市話  :</td>
				<td><input type="text" name="phone" value="${param.tel}"></td>
				<td>${error.tel}</td>
			</tr>
			<tr>
				<td>請輸入您住的縣市 :</td>
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
												<option value="L">南投縣</option>
												<option value="M">彰化縣</option>
												<option value="N">新竹市</option>
												<option value="O">雲林縣</option>
												<option value="P">嘉義縣</option>
												<option value="Q">屏東縣</option>
												<option value="R">花蓮縣</option>
												<option value="S">臺東縣</option>
												<option value="T">金門縣</option>
												<option value="U">澎湖縣</option>
												<option value="V">連江縣</option>
						
				</select></td>
				<td>${error.GUAR_CT}</td>
			</tr>
			<tr>
				<td>住址(區/鄉/鎮/市) : </td>
				<td>
<!-- 				<select name="GUAR_AR" ></select> -->
				<select id="select1" >
				<option value="" selected>請選擇</option>
				</select>
				<td>${error.GUAR_AR}</td></td>
			</tr>
			<tr>
				<td>住址(路/街/巷) : </td>
<%-- 				<td><input type="text" name="GUAR_ROAD" value="${param.GUAR_ROAD}"></td> --%>
                <td><input type="text" id="keyword"><input id="textval" type="text" style="display:none"><td>${error.GUAR_ROAD}</td></td>
			</tr>
			<tr>
			<td></td>
			<td id="tb"></td>
			</tr>
			<tr>
				<td>住址(號) : </td>
				<td><input type="text" name="GUAR_NO" value="${param.GUAR_NO}"></td>
				<td>${error.GUAR_NO}</td>
			</tr>
			<tr>
				<td>輸入聯絡人姓名 :</td>
				<td><input type="text" name="Con_name" value="${param.Con_name}"></td>
				<td>${error.Con_name}</td>
			</tr>
			<tr>
				<td>輸入連絡人手機 :</td>
				<td><input type="text" name="Con_cel"
					value="${param.Con_cel}"></td>
				<td>${error.Con_cel}</td>
			</tr>
				<tr>
				<td>收款方式 : </td>
				<td>	
				<select name="receipts_metho" value="${param.receipts_metho}">
				<option value="" selected>請選擇</option>
		        <option value="0">貨到付款</option>
		        <option value="1">信用卡付款</option>
		        <option value="3">都有使用</option></select>
		        </td>
				<td>${error.receipts_metho}</td>
				</tr>
				
			
			<tr>
				<td align="right"><input class="btn btn-primary" type="submit" value="註冊"></td>
			</tr>
		</table>
	</form>
<script src="<%= request.getContextPath() %>/js/jquery-2.2.1.min.js"></script>
<script>

$(function(){
	   $.ajax({
		  'type':'get',
		  'url':'<%= request.getContextPath() %>/XMLServlet8691',
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
			 LoadRoads('b');
		 }
	   });
	   
	   function LoadRoads(key){
		   console.log('key: '+key);
		   $('#tb').empty();
		   $.getJSON('<%= request.getContextPath() %>/GetRoad',
				   	{'GUAR_AR':$('#select1').val(), 
			   		 'keyword':$('#keyword').val()},
			function(datas){
			   			console.log('datas: '+datas);
			   			$.each(datas,function(index,road){
				   			console.log('GUAR_ROAD: '+road.GUAR_ROAD);
				   			console.log('GUAR_ROAD_name: '+road.GUAR_ROAD_name);
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
</body>
</html>