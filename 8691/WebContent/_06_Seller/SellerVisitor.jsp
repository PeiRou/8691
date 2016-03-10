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
	    <style>
	    	td{
	    		font-size:1.1em;
	    	}
	    	table#t01 tr:nth-child(even) {
			    background-color: #fff;
			}
			table#t01 tr:nth-child(odd) {
			   background-color:#eee;
			}
    	</style>
    
</head>
<body>
<jsp:include page="/fragment/top.jsp" />
	<div class="container">
		<div class="row">
			<div class="box">		
				<div class="col-md-12">
				<form name="Visitor"
					action="<c:url value='/page/visitor.controller' />" method="post">
					<h2 class="text-center"><strong>註冊為店家</strong></h2>
					<table id="t01" class="table">
						<tr>
							<td class="col-xs-8 col-sm-6 text-right">請輸入您的E-mail:</td>
							<td><input type="text" name="acc_email" value="${param.acc_email}" placeholder="此E-mail將成為您的帳號 " id="acc_emailinput"><span id="acc_emailsp" style="color:red"></span></td>
							<td>${error.acc_email}</td>
						</tr>
						
						<tr>
							<td class="col-xs-8 col-sm-6 text-right">請輸入您的密碼 :</td>
							<td><input type="text" name="psd" value="${param.psd}" id="psdinput"><span id="psdsp" style="color:red"></span></td>
							<td>${error.psd}</td>
						</tr>
						<tr>
							<td class="col-xs-8 col-sm-6 text-right">請輸入您的統一編號 :</td>
							<td><input type="text" name="FEIN" value="${param.FEIN}" id="FEINinput"><span id="FEINsp" style="color:red"></span></td>
							<td>${error.FEIN}</td>
						</tr>
						<tr>
							<td class="col-xs-8 col-sm-6 text-right">請輸入您的店家名稱 :</td>
							<td><input type="text" name="name" value="${param.name}" id="nameinput"><span id="namesp" style="color:red"></span></td>
							<td>${error.name}</td>
						</tr>
						<tr>
							<td class="col-xs-8 col-sm-6 text-right">請輸入負責人姓名 :</td>
							<td><input type="text" name="Con_name" value="${param.Con_name}" id="Con_nameinput"><span id="Con_namesp" style="color:red"></span></td>
							<td>${error.Con_name}</td>
						</tr>
					      <tr height='36'>
					    		<td class="col-xs-8 col-sm-6 text-right">輸入您的店家圖片:</td>
					       <!-- <td width="45" align="center" class="title_font">圖片</td>--> 
					        	<td colspan="3">
					            <input style="background:#FFFFFF" class='InputClass'  type="file" 
					            name="uploadFile" size="40" />    
					    </tr>
						<tr>
							<td class="col-xs-8 col-sm-6 text-right">請輸入您的店家電話號碼 :</td>
							<td><input type="text" name="tel" value="${param.tel}" placeholder="Ex:02-23456789" id="telinput"><span id="teldsp" style="color:red"></span></td>
							<td>${error.tel}</td>
						</tr>
						<tr>
							<td class="col-xs-8 col-sm-6 text-right">請輸入負責人手機號碼 :</td>
							<td><input type="text" name="Con_cel"
								value="${param.Con_cel}" placeholder="Ex:0912345678" id="Con_celinput"><span id="Con_celsp" style="color:red"></span></td>
							<td>${error.Con_cel}</td>
						</tr>
						<tr>
							<td class="col-xs-8 col-sm-6 text-right">請選擇您所在的縣市 :</td>
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
							<td class="col-xs-8 col-sm-6 text-right">住址(區/鄉/鎮/市) : </td>
							<td>
			
							<select id="select1" name="GUAR_AR">
							<option value="" selected>請選擇</option>
							</select>
							<td>${error.GUAR_AR}</td>
						</tr>
						<tr>
							<td class="col-xs-8 col-sm-6 text-right">住址(路/街/巷) : </td>
			                <td><input type="text" id="keyword"><input id="textval" type="text" name="GUAR_ROAD" style="display:none"><span id="roadsp" style="color:red"></span></td><td>${error.GUAR_ROAD}</td>
						</tr>                                                        
						<tr>
						<td></td>
						<td></td>
						<td id="tb"></td>
						</tr>
						<tr>
							<td class="col-xs-8 col-sm-6 text-right">住址(號) : </td>
							<td><input type="text" name="GUAR_NO" value="${param.GUAR_NO}" id="GUAR_NOinput"><span id="GUAR_NOsp" style="color:red"></span></td>
							<td>${error.GUAR_NO}</td>
						</tr>						
						<tr>
							<td class="col-xs-8 col-sm-6 text-right">請輸入備用EMAIL :</td>
							<td><input type="text" name="email2"
								value="${param.email2}" id="email2input"><span id="email2sp" style="color:red"></span></td>
							<td>${error.email2}</td>
						</tr>
							<tr>
							<td class="col-xs-8 col-sm-6 text-right">請選擇收款方式 : </td>
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
								<td class="col-xs-8 col-sm-6 text-right">運費 : </td>
								<td><input type="text" name="Ship_price" value="${param.Ship_price}"></td>
								<td>${error.Ship_price}</td>
							</tr>
							<tr>
								<td class="col-xs-8 col-sm-6 text-right">消費最低金額: </td>
								<td><input type="text" name="Lowest_price" value="${param.Lowest_price}"></td>
								<td>${error.Lowest_price}</td>
							</tr>
							
						<tr>
							<td></td>
							<td><input class="btn btn-primary" type="submit" value="註冊"></td>
							<td></td>
						</tr>
					</table>
				</form>
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
<script>
		        window.onload = function () {
		            document.getElementById("FEINinput").onblur = blur;
		            document.getElementById("nameinput").onblur = blur2;
		            document.getElementById("acc_emailinput").onblur = blur3;
		            document.getElementById("psdinput").onblur = blur4;
		            document.getElementById("telinput").onblur = blur5;
		            document.getElementById("keyword").onblur = blur6;
		            document.getElementById("GUAR_NOinput").onblur = blur7;
		            document.getElementById("Con_nameinput").onblur = blur8;
		            document.getElementById("Con_celinput").onblur = blur9;
		            document.getElementById("email2input").onblur = blur10;
		        
		        }
		     
		        function blur() {
		            if (document.getElementById("FEINinput").value == "") {
		                document.getElementById("FEINsp").innerHTML = "<img src='<%= request.getContextPath() %>/img/error.jpg' />不可空白";
		            }
		            else if (document.getElementById("FEINinput").value != "") {
		            	chkFEIN();          
		            }
		        }
		        function chkFEIN() {
		        	var chkFEIN = document.getElementById("FEINinput").value;
		    		
		            var FEINre = /^\d{8}$/;
		
		            if (FEINre.test(chkFEIN)) {
		                document.getElementById("FEINsp").innerHTML = "<img src='<%= request.getContextPath() %>/img/right.png' />";
		                
		            }   
		             else {
		                document.getElementById("FEINsp").innerHTML = "<img src='<%= request.getContextPath() %>/img/error.jpg' />格式錯誤";
		               }
		        } 
		        
		     
		        function blur2() {
		            if (document.getElementById("nameinput").value == "") {
		            	document.getElementById("namesp").innerHTML = "<img src='<%= request.getContextPath() %>/img/error.jpg' />不可空白";
		            }		            
		        }
		
		        
		        function blur3() {
		            if (document.getElementById("acc_emailinput").value == "") {
		                document.getElementById("acc_emailsp").innerHTML = "<img src='<%= request.getContextPath() %>/img/error.jpg' />不可空白";
		            }
		            else if (document.getElementById("acc_emailinput").value != "") {
		            	chkacc_email();          
		            }
		        }
		        function chkacc_email() {
		            var chkacc_email = document.getElementById("acc_emailinput").value;
		
		            var namere = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
		
		            if (namere.test(chkacc_email)) {
		                document.getElementById("acc_emailsp").innerHTML = "<img src='<%= request.getContextPath() %>/img/right.png' />";
		                
		            }   
		             else {
		                document.getElementById("acc_emailsp").innerHTML = "<img src='<%= request.getContextPath() %>/img/error.jpg' />格式錯誤";
		               }
		        } 
		        
		        function blur4() {
		            if (document.getElementById("psdinput").value == "") {
		                document.getElementById("psdsp").innerHTML = "<img src='<%= request.getContextPath() %>/img/error.jpg' />不可空白";
		           
		            }		            
		        }
		        
		        
		        function blur5() {
		            if (document.getElementById("telinput").value == "") {
		            	document.getElementById("teldsp").innerHTML = "<img src='<%= request.getContextPath() %>/img/error.jpg' />不可空白";
		            }
		            else if (document.getElementById("telinput").value != "") {
		                chktel();
		            }
		        }

		        function chktel() {
		            var thetel = document.getElementById("telinput").value;

		            var telre = /^[02]{2}-[0-9]{8}$/;

		            if (telre.test(thetel)) {
		            	document.getElementById("teldsp").innerHTML = "<img src='<%= request.getContextPath() %>/img/right.png' />";

		            }
		            else {
		            	document.getElementById("teldsp").innerHTML = "<img src='<%= request.getContextPath() %>/img/error.jpg' />格式錯誤";
		            }
		        }
		        
		        function blur6() {
		            if (document.getElementById("keyword").value == "") {
		            	document.getElementById("roadsp").innerHTML = "<img src='<%= request.getContextPath() %>/img/error.jpg' />不可空白";
		            }		            
		        }
		        
		        function blur7() {
		            if (document.getElementById("GUAR_NOinput").value == "") {
		            	document.getElementById("GUAR_NOsp").innerHTML = "<img src='<%= request.getContextPath() %>/img/error.jpg' />不可空白";
		            }		            
		        }
		        
		        function blur8() {
		            if (document.getElementById("Con_nameinput").value == "") {
		            	document.getElementById("Con_namesp").innerHTML = "<img src='<%= request.getContextPath() %>/img/error.jpg' />不可空白";
		            }		            
		        }
		        
		        function blur9() {
		            if (document.getElementById("Con_celinput").value == "") {
		            	document.getElementById("Con_celsp").innerHTML = "<img src='<%= request.getContextPath() %>/img/error.jpg' />不可空白";
		            }
		            else if (document.getElementById("Con_celinput").value != "") {
		                chkCon_cel();
		            }
		        }

		        function chkCon_cel() {
		            var theCon_cel = document.getElementById("Con_celinput").value;

		            var Con_celre = /^09[0-9]{8}$/;

		            if (Con_celre.test(theCon_cel)) {
		            	document.getElementById("Con_celsp").innerHTML = "<img src='<%= request.getContextPath() %>/img/right.png' />";

		            }
		            else {
		            	document.getElementById("Con_celsp").innerHTML = "<img src='<%= request.getContextPath() %>/img/error.jpg' />格式錯誤";
		            }
		        }
		        
		        
		        function blur10() {
		            if (document.getElementById("email2input").value == "") {
		                document.getElementById("email2sp").innerHTML = "<img src='<%= request.getContextPath() %>/img/error.jpg' />不可空白";
		            }
		            else if (document.getElementById("email2input").value != "") {
		            	chkemail2();          
		            }
		        }
		        function chkemail2() {
		            var chkemail2 = document.getElementById("email2input").value;
		
		            var namere = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
		
		            if (namere.test(chkemail2)) {
		                document.getElementById("email2sp").innerHTML = "<img src='<%= request.getContextPath() %>/img/right.png' />";
		                
		            }   
		             else {
		                document.getElementById("email2sp").innerHTML = "<img src='<%= request.getContextPath() %>/img/error.jpg' />格式錯誤";
		               }
		        } 
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