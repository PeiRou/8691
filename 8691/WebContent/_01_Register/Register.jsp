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

    <title>Register</title>

    <!-- Bootstrap Core CSS -->
    <link href="<%= request.getContextPath() %>/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="<%= request.getContextPath() %>/css/business-casual.css" rel="stylesheet">

    <!-- Fonts -->
    <link href="http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800" rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/css?family=Josefin+Slab:100,300,400,600,700,100italic,300italic,400italic,600italic,700italic" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
	<jsp:include page="/fragment/top.jsp" />
	<div class="container">
		<div class="row">
			<div class="box">
				<div class="col-md-6">
				<form name="Register" action="<c:url value='/page/register.controller' />" method="post">
<table>
			<tr>
				<td>請輸入您的名字 :</td>
				<td><input type="text" name="name" value="${param.name}"></td>
				<td>${error.name}</td>
			</tr>
			<tr>
				<td>請輸入您的E-mail, 此E-mail將成為您的帳號 :</td>
				<td><input type="text" name="acc_email"
					value="${param.acc_email}"></td>
				<td>${error.acc_email}</td>
			</tr>
			<tr>
				<td>請設定您的密碼 :</td>
				<td><input type="text" name="psd" value="${param.psd}"></td>
				<td>${error.psd}</td>
			</tr>
			<tr>
				<td>請輸入您的性別 :</td>
				<td><select name="gender" size="1" value="${param.gender}">
						<option value="男">男</option>
						<option value="女"selected>女</option>
				</select></td>
				<td></td>
			</tr>

			<tr>
				<td>請輸入您的家用電話號碼 :</td>
				<td><input type="text" name="tel" value="${param.phone}"></td>
				<td>${error.tel}</td>
			</tr>
			<tr>
				<td>請輸入您的家用手機號碼 :</td>
				<td><input type="text" name="cel"
					value="${param.cel}"></td>
				<td>${error.cel}</td>
			</tr>
		
			<tr>
				<td>請輸入您住的縣市 :</td>
				<td><select name="GUAR_CT" size="1" value="${param.GUAR_CT}">
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
				<td></td>
			</tr>
			
			<tr>
				<td>請輸入您住的區域 :</td>
					<td><select id="select1">
					<option value="" selected>Please Select</option>
					</select></td>
				<td></td>
			</tr>
			
			<tr>
				<td>請輸入您住的路名 :</td>
				<td><input id="keyword" type="text" value=""> <input id="textval" type="text" style="display:none"></td>
			</tr>
	
			<tr>
				<td></td>
				<td id="tb"></td>
			</tr>
			
			<tr>
				<td>請完成輸入您的地址 :</td>
				<td><input type="text" name="GUAR_NO" value="${param.GUAR_NO}"></td>
				<td>${error.GUAR_NO}</td>
			</tr>
						
			<tr>
				<td>請輸入您的備用E-mail :</td>
				<td><input type="text" name="email2" value="${param.email2}"></td>
				<td>${error.email2}</td>
			</tr>
			<tr>

				<td align="right"><input type="submit" value="Register"></td>
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

    <footer>
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <p>Copyright &copy; Your Website 2014</p>
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