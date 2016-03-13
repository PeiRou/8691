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

    <title>8691店家中心</title>

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
</head>
<body>
<jsp:include page="/fragment/top.jsp" />
	<div class="container">
		<div class="row">
			<div class="box">
				<div class="col-lg-12 text-center">
					<div class="col-lg-9 text-center"></div>
					<div id="divimg" class="col-lg-3 text-right">
						<form id=photoForm enctype="multipart/form-data"
							action="<c:url value='/_06_Seller/_06_UpdSellerPhoto.controller' />"
							method="post">
							<input id="btnUpload" type="file" name="upl" />
							<input id="hidPhotoID" type="hidden" name="hidPhotoID" />
							<input id="btnSubmit"
								type="button" class="btn btn-default" value="選好圖片送出" />								
						</form>
					</div>
				</div>
				
				
				<div class="col-lg-12 text-left">
				<a id="btndialog" class="btn btn-primary">修改</a>
					<table id="example" class="display" cellspacing="0" width="100%">
						<thead>
							<tr>
								<td>統一編號</td>
								<td>店家名稱</td>
<!-- 								<td>店家圖片</td> -->
								<td>電話</td>
								<td>住址(縣/市)</td>
								<td>住址(區/鄉/鎮/市)</td>
								<td>村或里</td>
								<td>住址(號)</td>
								<td>備用email</td>
								<td>聯絡人</td>
								<td>聯絡人手機</td>
								<td>收款方式</td>
								<td>運費</td>
								<td>消費最低金額</td>
							</tr>
						</thead>						
					</table>
<!-- 					dialog位置                -->
					<div id="dialog" title="修改店家資訊">
						<input type="hidden" id="hidError" value="${error}">
					</div>
				</div>
				<div class="col-lg-12 text-center">
				<HR>
				</div>
				<div class="col-lg-12 text-center">
					<div class="col-lg-2"></div>
					<div class="col-lg-2">
						<a id=img1></a>
					</div>
					<div class="col-lg-2">
						<a id=img2></a>
					</div>
					<div class="col-lg-2">
						<a id=img3></a>
					</div>
					<div class="col-lg-2">
						<a id=img4></a>
					</div>
					<div class="col-lg-2"></div>
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
var data = ${select};
var jsonVal = JSON.parse(JSON.stringify(data));
console.log("jsonVal:"+JSON.stringify(data));
beload();

//datatables位置
$(document).ready(function() {
    $('#example').DataTable( {
        "data": jsonVal,
        "bFilter":false,//把搜尋關掉
        "bPaginate":false,//把左上角的筆數關掉
        "bInfo":false,//把底下筆數關掉
        "columns": [
            { "data": "FEIN" },
			{ "data": "name" },
			{ "data": "tel" },
			{ "data": "GuarCTName" },
			{ "data": "GuarARName" },
			{ "data": "GuarROADName" },
			{ "data": "GUARNO" },
			{ "data": "email2" },
			{ "data": "ConName" },
			{ "data": "ConCel" },
			{ "data": "ReceiptsMetho" },
			{ "data": "shipPrice" },
			{ "data": "LowestPrice" }
        ]
    } );
} );
var url = '<%=request.getContextPath()%>';
var imgURL = '/upload'
$('#divimg').prepend(ShowPhoto());

//顯示店家的照片
function ShowPhoto(){
	var temp;
	$.each(jsonVal,function(inx,SellerVistorval){
		$('#hidPhotoID').val(SellerVistorval.SellerPhoto);
		var imageURL = SellerVistorval.ImageURL;
		temp = '<img style="width: 100%" src="'+ imgURL+ imageURL +'" class=img-thumbnail>';
	});
	return temp;
}

//下方亂數顯示店家照片
var rdmArray = new Array;
var imgArray = ["","2.jpg","3.jpg","4.jpg","5.jpg","6.jpg","7.jpg","8.png","9.jpg"];
rdmArray = getRandomArray(1,8,5);

for(var i =1 ; i<5 ; i++){
	var num = rdmArray[i];
	var temp = '<img style="width: 100%" src="'+ url + '/image/store/'+ imgArray[num] +'">';
	$('#img'+i).html(temp);
}

//隨機產生不重覆的n個數字
function getRandomArray(minNum, maxNum, n) {	
	var rdmArray = [n];		//儲存產生的陣列
 
	for(var i=0; i<n; i++) {
		var rdm = 0;		//暫存的亂數
 
		do {
			var exist = false;			//此亂數是否已存在
			rdm = getRandom(minNum, maxNum);	//取得亂數
 
			//檢查亂數是否存在於陣列中，若存在則繼續回圈
			if(rdmArray.indexOf(rdm) != -1) exist = true;
 
		} while (exist);	//產生沒出現過的亂數時離開迴圈
 
		rdmArray[i] = rdm;
	}
	return rdmArray;
}
function getRandom(minNum, maxNum) {	//取得 minNum(最小值) ~ maxNum(最大值) 之間的亂數
	return Math.floor( Math.random() * (maxNum - minNum + 1) ) + minNum;
}

//btn固定位置
$('#btnSubmit').click(function(){
	var temp = $('#btnUpload').val();
	if(temp==""){
		alert('請選一張圖片');
	}else{		
		$('#photoForm').submit();
	}
});
//必須載入事件
function beload(){	
	$('#btndialog').click(function() {
		//載入dailog的資料
		loadDailogData();
		$("#dialog").dialog( "open" );	
	});
	//dialog位置
	$( "#dialog" ).dialog({
			  resizable: false,
		      autoOpen: false,
		      modal: true,
		      height: 800,
		      width: 800,
		      buttons: {
		          "離開": function() {
		            $(this).dialog( "close" );
					location.reload(true);}
					}
		    });		    
}
//載入dailog的資料
function loadDailogData(){
	var temp = '<form id="dgform" action="<c:url value="/_06_Seller/_06_UpdSeller.controller" />" method="post">';
	temp = temp.concat('<table id="tbldialog" class="display table table-bordered" cellspacing="0" width="100%">');
	$.each(jsonVal,function(inx,SellerVistorval){	
	temp = temp.concat('<tr>');
	temp = temp.concat('<td class="col-xs-8 col-sm-6 text-right">請輸入您的統一編號 :</td>');
	temp = temp.concat('<td><input type="text" name="FEIN" value="'+SellerVistorval.FEIN+'" id="FEINinput"><span id="FEINsp" style="color:red"></span></td>');
	temp = temp.concat('<td>${error.FEIN}</td>');
	temp = temp.concat('</tr>');
	temp = temp.concat('<tr>');
	temp = temp.concat('<td class="col-xs-8 col-sm-6 text-right">請輸入您的店家名稱 :</td>');
	temp = temp.concat('<td><input type="text" name="name" value="'+SellerVistorval.name+'" id="nameinput"><span id="namesp" style="color:red"></span></td>');
	temp = temp.concat('<td>${error.name}</td>');
	temp = temp.concat('</tr>');
	temp = temp.concat('<tr>');
	temp = temp.concat('<td class="col-xs-8 col-sm-6 text-right">請輸入負責人姓名 :</td>');
	temp = temp.concat('<td><input type="text" name="Con_name" value="'+SellerVistorval.ConName+'" id="Con_nameinput"><span id="Con_namesp" style="color:red"></span></td>');
	temp = temp.concat('<td>${error.Con_name}</td>');
	temp = temp.concat('</tr>');
	temp = temp.concat('<tr>');
	temp = temp.concat('<td class="col-xs-8 col-sm-6 text-right">請輸入您的店家電話號碼 :</td>');
	temp = temp.concat('<td><input type="text" name="tel" value="'+ SellerVistorval.tel +'" placeholder="Ex:02-23456789" id="telinput"><span id="teldsp" style="color:red"></span></td>');
	temp = temp.concat('<td>${error.tel}</td>');
	temp = temp.concat('</tr>');
	temp = temp.concat('<tr>');
	temp = temp.concat('<td class="col-xs-8 col-sm-6 text-right">請輸入負責人手機號碼 :</td>');
	temp = temp.concat('<td><input type="text" name="Con_cel"');
	temp = temp.concat('value="'+SellerVistorval.ConCel+'" placeholder="Ex:0912345678" id="Con_celinput"><span id="Con_celsp" style="color:red"></span></td>');
	temp = temp.concat('<td>${error.Con_cel}</td>');
	temp = temp.concat('</tr>');
	temp = temp.concat('<tr>');
	temp = temp.concat('<td class="col-xs-8 col-sm-6 text-right">請選擇您所在的縣市 :</td>');
	temp = temp.concat('<td><select name="GUAR_CT" size="1" value="'+SellerVistorval.GUARCT+'">');
	temp = temp.concat('<option value="">請選擇</option>');
	temp = temp.concat('<option value="A" selected>臺北市</option>');
	temp = temp.concat('<option value="B">臺中市 </option>');
	temp = temp.concat('<option value="C">基隆市</option>');
	temp = temp.concat('<option value="D">臺南市</option>');
	temp = temp.concat('<option value="E">高雄市</option>');
	temp = temp.concat('<option value="F">新北市</option>');
	temp = temp.concat('<option value="G">宜蘭縣</option>');
	temp = temp.concat('<option value="H">桃園市</option>');
	temp = temp.concat('<option value="I">嘉義市</option>');
	temp = temp.concat('<option value="J">新竹縣</option>');
	temp = temp.concat('<option value="K">苗栗縣</option>');
	temp = temp.concat('<option value="L">南投縣</option>');
	temp = temp.concat('<option value="M">彰化縣</option>');
	temp = temp.concat('<option value="N">新竹市</option>');
	temp = temp.concat('<option value="O">雲林縣</option>');
	temp = temp.concat('<option value="P">嘉義縣</option>');
	temp = temp.concat('<option value="Q">屏東縣</option>');
	temp = temp.concat('<option value="R">花蓮縣</option>');
	temp = temp.concat('<option value="S">臺東縣</option>');
	temp = temp.concat('<option value="T">金門縣</option>');
	temp = temp.concat('<option value="U">澎湖縣</option>');
	temp = temp.concat('<option value="V">連江縣</option>');
	temp = temp.concat('</select></td>');
	temp = temp.concat('<td>${error.GUAR_CT}</td>');
	temp = temp.concat('</tr>');
	temp = temp.concat('<tr>');
	temp = temp.concat('<td class="col-xs-8 col-sm-6 text-right">住址(區/鄉/鎮/市) : </td>');
	temp = temp.concat('<td>');
	temp = temp.concat('<select id="select1" name="GUAR_AR">');
	temp = temp.concat('<option value="'+ SellerVistorval.GUARAR +'" selected>'+ SellerVistorval.GuarARName+'</option>');
	temp = temp.concat('</select>');
	temp = temp.concat('<td>${error.GUAR_AR}</td>');
	temp = temp.concat('</tr>');
	temp = temp.concat('<tr>');
	temp = temp.concat('<td class="col-xs-8 col-sm-6 text-right">住址(路/街/巷) : </td>');
	temp = temp.concat('<td><input type="text" id="keyword"><input id="textval" type="text" name="GUAR_ROAD" style="display:none"><span id="roadsp" style="color:red"></span></td><td>${error.GUAR_ROAD}</td>');
	temp = temp.concat('</tr>');
	temp = temp.concat('<tr>');
	temp = temp.concat('<td></td>');
	temp = temp.concat('<td></td>');
	temp = temp.concat('<td id="tb"></td>');
	temp = temp.concat('</tr>');
	temp = temp.concat('<tr>');
	temp = temp.concat('<td class="col-xs-8 col-sm-6 text-right">住址(號) : </td>');
	temp = temp.concat('<td><input type="text" name="GUAR_NO" value="" id="GUAR_NOinput"><span id="GUAR_NOsp" style="color:red"></span></td>');
	temp = temp.concat('<td>${error.GUAR_NO}</td>');
	temp = temp.concat('</tr>						');
	temp = temp.concat('<tr>');
	temp = temp.concat('<td class="col-xs-8 col-sm-6 text-right">請輸入備用EMAIL :</td>');
	temp = temp.concat('<td><input type="text" name="email2"');
	temp = temp.concat('value="'+SellerVistorval.email2+'" id="email2input"><span id="email2sp" style="color:red"></span></td>');
	temp = temp.concat('<td>${error.email2}</td>');
	temp = temp.concat('</tr>');
	temp = temp.concat('<tr>');
	temp = temp.concat('<td class="col-xs-8 col-sm-6 text-right">請選擇收款方式 : </td>');
	temp = temp.concat('<td>');
	temp = temp.concat('<select name="receipts_metho" value="'+SellerVistorval.SellerStatus+'">');
	temp = temp.concat('<option value="" >請選擇</option>');
	temp = temp.concat('<option value="0">貨到付款</option>');
	temp = temp.concat('<option value="1">信用卡付款</option>');
	temp = temp.concat('<option value="3">都有使用</option></select>');
	temp = temp.concat('</td>');
	temp = temp.concat('<td>${error.receipts_metho}</td>');
	temp = temp.concat('</tr>');
	temp = temp.concat('<tr>');
	temp = temp.concat('<td class="col-xs-8 col-sm-6 text-right">運費 : </td>');
	temp = temp.concat('<td><input type="text" name="Ship_price" value="'+SellerVistorval.shipPrice+'"></td>');
	temp = temp.concat('<td>${error.Ship_price}</td>');
	temp = temp.concat('</tr>');
	temp = temp.concat('<tr>');
	temp = temp.concat('<td class="col-xs-8 col-sm-6 text-right">消費最低金額: </td>');
	temp = temp.concat('<td><input type="text" name="Lowest_price" value="'+SellerVistorval.LowestPrice+'"></td>');
	temp = temp.concat('<td>${error.Lowest_price}</td>');
	temp = temp.concat('</tr>');
	temp = temp.concat('<tr>');
	temp = temp.concat('<td></td>');
	temp = temp.concat('<td><input class="btn btn-primary dgsubmit" type="button" value="確定"></td>');
	temp = temp.concat('<td></td>');
	temp = temp.concat('</tr>');
	temp = temp.concat('</table>');
	temp = temp.concat('</form>');
	});
	$('#dialog').append(temp);
	dialogSubmit()
}
function dialogSubmit(){	
	$('.dgsubmit').click(function(){
		{		
			$('#dgform').submit();
		}
	});
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
}
var error = $('#hidError').val();

if(error!=""){
	$("#btndialog").click();
	$('#hidError').val('');
}
 </script>
</html>