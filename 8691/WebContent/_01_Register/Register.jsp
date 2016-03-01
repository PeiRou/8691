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
				<div class="col-md-12">
				<form name="Register" action="<c:url value='/register.controller' />" method="post">
<h2>註冊為一般會員</h2>
<table>
			
			<tr>
				<td>請輸入您的E-mail:</td>
				<td><input type="text" name="acc_email" id="emailinput"
					value="${param.acc_email}" placeholder="此E-mail將成為您的帳號 "><span id="emailsp" style="color:red"></span></td>
				<td>${error.acc_email}</td>
				
			</tr>
			<tr>
				<td>請設定您的密碼 :</td>
				<td><input type="password" name="psd" value="${param.psd}" id="pwdinput"><span id="pwdsp" style="color:red"></span></td>
				<td>${error.psd}</td>
			</tr>
			<tr>
				<td>請輸入您的姓名 :</td>
				<td><input type="text" name="name" value="${param.name}" id="nameinput"><span id="namesp" style="color:red"></span></td>
				<td>${error.name}</td> 				
			</tr>
			<tr>
				<td>請輸入您的性別 :</td>
				<td><select name="gender" size="1" value="${param.gender}">
						<option value="" selected>請選擇</option>
						<option value="男">男♂</option>
						<option value="女">女♀</option>
				</select></td>
				<td></td>
			</tr>

			<tr>
				<td>請輸入您的家用電話號碼 :</td>
				<td><input type="text" name="tel" value="${param.phone}" placeholder="Ex:02-23456789" id="telinput"><span id="teldsp" style="color:red"></span></td>
				<td>${error.tel}</td>
			</tr>
			<tr>
				<td>請輸入您的手機號碼 :</td>
				<td><input type="text" name="cel" value="${param.cel}" placeholder="Ex:0912345678" id="celinput"><span id="celdsp" style="color:red"></span></td>
				<td>${error.cel}</td>
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
				<td></td>
			</tr>
			
			<tr>
				<td>請輸入您住的區域 :</td>
					<td><select id="select1">
					<option value="" selected>請選擇</option>
					</select></td>
				<td></td>
			</tr>
			
			<tr>
				<td>請輸入您住的路名 :</td>
				<td><input id="keyword" type="text" value=""> <input id="textval" type="text" style="display:none"><span id="roadsp" style="color:red"></span></td>
			</tr>
	
			<tr>
				<td></td>
				<td id="tb"></td>
			</tr>
			
			<tr>
				<td>請完成輸入您的地址 :</td>
				<td><input type="text" name="GUAR_NO" value="${param.GUAR_NO}" id="addrinput"><span id="addrsp" style="color:red"></span></td>
				<td>${error.GUAR_NO}</td>
			</tr>
						
			<tr>
				<td>請輸入您的備用E-mail :</td>
				<td><input type="text" name="email2" value="${param.email2}" id="emailinput2"><span id="emailsp2" style="color:red"></span></td>
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

 		<script>
		        window.onload = function () {
		            document.getElementById("emailinput").onblur = blur;
		            document.getElementById("pwdinput").onblur = blur2;
		            document.getElementById("nameinput").onblur = blur3;
		            document.getElementById("telinput").onblur = blur4;
		            document.getElementById("celinput").onblur = blur5;
		            document.getElementById("keyword").onblur = blur6;
		            document.getElementById("addrinput").onblur = blur7;
		            document.getElementById("emailinput2").onblur = blur8;
		        }
		     
		        function blur() {
		            if (document.getElementById("emailinput").value == "") {
		                document.getElementById("emailsp").innerHTML = "<img src='<%= request.getContextPath() %>/img/error.jpg' />不可空白";
		            }
		            else if (document.getElementById("emailinput").value != "") {
		            	chkEmail();          
		            }
		        }
		
		        function chkEmail() {
		            var chkEmail = document.getElementById("emailinput").value;
		
		            var namere = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
		
		            if (namere.test(chkEmail)) {
		                document.getElementById("emailsp").innerHTML = "<img src='<%= request.getContextPath() %>/img/right.png' />";
		                
		            }   
		             else {
		                document.getElementById("emailsp").innerHTML = "<img src='<%= request.getContextPath() %>/img/error.jpg' />格式錯誤";
		               }
		        } 
		        
		        function blur2() {
		            if (document.getElementById("pwdinput").value == "") {
		                document.getElementById("pwdsp").innerHTML = "<img src='<%= request.getContextPath() %>/img/error.jpg' />不可空白";
		            }		            
		        }
		        
		        function blur3() {
		            if (document.getElementById("nameinput").value == "") {
		            	document.getElementById("namesp").innerHTML = "<img src='<%= request.getContextPath() %>/img/error.jpg' />不可空白";
		            }		            
		        }
		        
		        function blur4() {
		            if (document.getElementById("telinput").value == "") {
		            	document.getElementById("teldsp").innerHTML = "<img src='<%= request.getContextPath() %>/img/error.jpg' />不可空白";
		            }
		            else if (document.getElementById("telinput").value != "") {
		                chktel();
		            }
		        }

		        function chktel() {
		            var thetel = document.getElementById("telinput").value;

		            var telre = /[0-9]{2}\-[0-9]{7}/;

		            if (telre.test(thetel)) {
		            	document.getElementById("teldsp").innerHTML = "<img src='<%= request.getContextPath() %>/img/right.png' />";

		            }
		            else {
		            	document.getElementById("teldsp").innerHTML = "<img src='<%= request.getContextPath() %>/img/error.jpg' />格式錯誤";
		            }
		        }
		        
		        function blur5() {
		            if (document.getElementById("celinput").value == "") {
		            	document.getElementById("celdsp").innerHTML = "<img src='<%= request.getContextPath() %>/img/error.jpg' />不可空白";
		            }
		            else if (document.getElementById("celinput").value != "") {
		                chkcel();
		            }
		        }

		        function chkcel() {
		            var thecel = document.getElementById("celinput").value;

		            var celre = /[0-9]{4}\[0-9]{3}\[0-9]{3}/;

		            if (celre.test(thecel)) {
		            	document.getElementById("celdsp").innerHTML = "<img src='<%= request.getContextPath() %>/img/right.png' />";

		            }
		            else {
		            	document.getElementById("celdsp").innerHTML = "<img src='<%= request.getContextPath() %>/img/error.jpg' />格式錯誤";
		            }
		        }
		        
		        function blur6() {
		            if (document.getElementById("keyword").value == "") {
		            	document.getElementById("roadsp").innerHTML = "<img src='<%= request.getContextPath() %>/img/error.jpg' />不可空白";
		            }		            
		        }
		        
		        function blur7() {
		            if (document.getElementById("addrinput").value == "") {
		            	document.getElementById("addrsp").innerHTML = "<img src='<%= request.getContextPath() %>/img/error.jpg' />不可空白";
		            }		            
		        }
		        
		        function blur8() {
		            if (document.getElementById("emailinput2").value == "") {
		                document.getElementById("emailsp2").innerHTML = "<img src='<%= request.getContextPath() %>/img/error.jpg' />不可空白";
		            }
		            else if (document.getElementById("emailinput2").value != "") {
		            	chkEmail2();          
		            }
		        }
		        
		        function chkEmail2() {
		            var chkEmail2 = document.getElementById("emailinput2").value;
		
		            var namere = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
		
		            if (namere.test(chkEmail2)) {
		                document.getElementById("emailsp2").innerHTML = "<img src='<%= request.getContextPath() %>/img/right.png' />";
		                
		            }   
		             else {
		                document.getElementById("emailsp2").innerHTML = "<img src='<%= request.getContextPath() %>/img/error.jpg' />格式錯誤";
		               }
		        } 
		        
		        
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