<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Welcome to 8691</title>

    <!-- Bootstrap Core CSS -->

    <link href="<%=request.getContextPath() %>/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/css/business-casual.css" rel="stylesheet">

    <!-- Fonts -->
    <link href="http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800" rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/css?family=Josefin+Slab:100,300,400,600,700,100italic,300italic,400italic,600italic,700italic" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

<style>
	
</style>
</head>
<body>
<jsp:include page="/fragment/top.jsp" />
    <div class="container">
    	<div class="row">
            <div class="box">
                <div class="col-lg-12">
                <table class="table">
                <tr>
					<td class="text-right">請輸入縣市 :</td>
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
					
					<td class="text-right">請輸入區域 :</td>
					<td><select id="select1" name="GUAR_AR" size="">
					<option value="" selected>請選擇</option>
					</select></td>
					
					<td class="text-right">請輸入路名 :</td>
					<td><input id="keyword" type="text" value=""> <input id="textval" name="GUAR_ROAD" type="text" style="display:none"><span id="roadsp" style="color:red"></span><input type="button" id="btn1" value="立即搜尋美食"></td>
					<td></td>
				</tr>
				<tr class="tr1">
					<td></td><td></td><td></td><td></td><td></td>
					<td id="tb"></td>
				</tr>
                </table>
                <div class="col-lg-12 text-center" id="map1">
                <input id="mapurl" type="text" value="<%=request.getContextPath() %>/googleAPI.jsp" style="display:none">
                </div>
                </div>
            </div>
        </div>
        
        <div class="row">
            <div class="box">
                <div class="col-lg-12 text-center">
                    <div id="carousel-example-generic" class="carousel slide">
                        <!-- Indicators -->
                        <ol class="carousel-indicators hidden-xs">
                            <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                            <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                            <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                        </ol>

                        <!-- Wrapper for slides -->
                        <div class="carousel-inner">
                            <div class="item active">
                                <img class="img-responsive img-full" src="img/slide-1.jpg" alt="">
                            </div>
                            <div class="item">
                                <img class="img-responsive img-full" src="img/slide-2.jpg" alt="">
                            </div>
                            <div class="item">
                                <img class="img-responsive img-full" src="img/slide-3.jpg" alt="">
                            </div>
                        </div>

                        <!-- Controls -->
                        <a class="left carousel-control" href="#carousel-example-generic" data-slide="prev">
                            <span class="icon-prev"></span>
                        </a>
                        <a class="right carousel-control" href="#carousel-example-generic" data-slide="next">
                            <span class="icon-next"></span>
                        </a>
                    </div>
                    <h2 class="brand-before">
                        <small>Welcome to</small>
                    </h2>
                    <h1 class="brand-name">Business Casual</h1>
                    <hr class="tagline-divider">
                    <h2>
                        <small>By
                            <strong>Start Bootstrap</strong>
                        </small>
                    </h2>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="box">
                <div class="col-lg-12">
                    <hr>
                    <h2 class="intro-text text-center">Build a website
                        <strong>worth visiting</strong>
                    </h2>
                    <hr>
                    <img class="img-responsive img-border img-left" src="img/intro-pic.jpg" alt="">
                    <hr class="visible-xs">
                    <p>The boxes used in this template are nested inbetween a normal Bootstrap row and the start of your column layout. The boxes will be full-width boxes, so if you want to make them smaller then you will need to customize.</p>
                    <p>A huge thanks to <a href="http://join.deathtothestockphoto.com/" target="_blank">Death to the Stock Photo</a> for allowing us to use the beautiful photos that make this template really come to life. When using this template, make sure your photos are decent. Also make sure that the file size on your photos is kept to a minumum to keep load times to a minimum.</p>
                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc placerat diam quis nisl vestibulum dignissim. In hac habitasse platea dictumst. Interdum et malesuada fames ac ante ipsum primis in faucibus. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas.</p>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="box">
                <div class="col-lg-12">
                    <hr>
                    <h2 class="intro-text text-center">Beautiful boxes
                        <strong>to showcase your content</strong>
                    </h2>
                    <hr>
                    <p>Use as many boxes as you like, and put anything you want in them! They are great for just about anything, the sky's the limit!</p>
                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc placerat diam quis nisl vestibulum dignissim. In hac habitasse platea dictumst. Interdum et malesuada fames ac ante ipsum primis in faucibus. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas.</p>
                </div>
            </div>
        </div>

    </div>
    <!-- /.container -->

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

    <!-- Script to Activate the Carousel -->
<script>
    $('.carousel').carousel({
        interval: 3000 //廣告輪播速度(毫秒)
    })
    
    //進入首頁後立刻從資料庫讀取區域的下拉式選單內容
    $(function(){
    		$('#map').hide();
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
            timer = setTimeout(LoadRoad, 600);
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
		   
		   $("#btn1").click(function(){
			   if($("#keyword").val()!=""){
				   var url = $('#mapurl').val();
				  $("#map1").append('<iframe src='+ url +' width="600px" height="400px" frameborder=0 ></iframe>');
				   //$("#mapurl").after('<iframe src=/8691/googleAPI.jsp scrolling=yes width=100% frameborder=0 height=100%></iframe>'); 
			   }
			 });

		   
		   
</script>	
</body>
</html>