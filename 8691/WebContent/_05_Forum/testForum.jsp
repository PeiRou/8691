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

    <title>8691留言板</title>

    <!-- Bootstrap Core CSS -->
    <link href="<%= request.getContextPath() %>/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="<%= request.getContextPath() %>/css/business-casual.css" rel="stylesheet">

    <!-- Fonts -->
    <link href="http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800" rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/css?family=Josefin+Slab:100,300,400,600,700,100italic,300italic,400italic,600italic,700italic" rel="stylesheet" type="text/css">

	<link type="text/css" rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css" />

	<!-- Jquery UI CSS -->
    <link href="<%= request.getContextPath() %>/css/jquery.dataTable.min.css" rel="stylesheet">
	<link href="<%= request.getContextPath() %>/css/jquery-ui/jquery-ui.min.css" rel="stylesheet">

<style>

</style>
</head>
<body>
<jsp:include page="/fragment/top.jsp" />
	<div class="container">
		<div class="row">
			<div class="box">
				<div class="col-lg-7 text-left">
					<!-- datatable的資料位置 -->
					<table id="example" class="display" cellspacing="0" width="100%">
<!--        					 <thead> -->
<!--            				 	 <tr> -->
<!--            				 	     <th></th> -->
<!--          					     <th></th> -->
<!--        					         <th></th> -->
<!--      					     </tr> -->
<!--         				 </thead> -->
    				</table>
				</div>
				<div class="col-lg-5 text-center">
					<form name="Forum" action="<c:url value='/forumIns.controller'/>" >
<!-- 					<form name="Forum"> -->
						<div class="form-group">
							<h3 id="msgsp" style="color: red">${error.comment}</h3>
							<div id="con">
								<div class="bottomcover" style="z-index: 2;"></div>
								<ul id="ul1"></ul>
							</div>
						</div>
						<div class="col-lg-1 text-right">
						</div>
						<div class="col-lg-10 text-right">
							<div class="form-group">
								<select id="select2" name="seller" class="form-control">
									<option value="" selected>請選擇討論店家:</option>
								</select>
							</div>
							<div class="form-group">
								<textarea id="comment" name="comment" placeholder="請輸入留言" class="form-control"></textarea>
	
								<input type="submit" id="btn" value="送出" class="btn btn-primary"/>
							</div>
						</div>
						<div class="col-lg-1 text-right">
						</div>
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

   <!-- Bootstrap Core JavaScript -->
    <script src="<%= request.getContextPath() %>/js/bootstrap.min.js"></script>
    <!--jQuery-->
	<script type="text/javascript" src="<%= request.getContextPath() %>/js/jquery2.js"></script>
<%--     <script type="text/javascript" src="<%= request.getContextPath() %>/js/jquery-1.12.1.min.js"></script> --%>
    <script type="text/javascript" src="<%= request.getContextPath() %>/js/jquery.dataTable.min.js"></script>
	<!--jQuery动画暂停插件-->
	<script type="text/javascript" src="<%= request.getContextPath() %>/js/jquery.pause.min.js"></script>
	<!--滚动效果js-->
	<script type="text/javascript">
	
	var comment = $("#comment").val();
	var seller = null;
	
	
	//進入留言板後立刻從資料庫讀取已存在的留言
    $(function(){
  	   $.ajax({
  		  'type':'post',
  		  'url':'<%= request.getContextPath() %>/GetComment',
  		  'data':{},
  		  'dataType':'json',
  		  'success': function(data){
  			 $("#msgsp").empty();
  			 $.each(data,function(index){
  	 			var cellcomment = JSON.parse(JSON.stringify(data[index].comment));
  	 			var cellname1 = JSON.parse(JSON.stringify(data[index].name));
  	 			var cellseller1 = JSON.parse(JSON.stringify(data[index].seller_Name));
  	 			var cellinsdate = JSON.parse(JSON.stringify(data[index].insdate));
  	 			var ForumUID = JSON.parse(JSON.stringify(data[index].Forum_UID));
  	 			var index = index+1;
  	 			
   	 			var cellname2 = $('<strong></strong>').append(cellname1);
   	 			var cellseller2 = $('<strong></strong>').append(cellseller1);
   	 			
  	 			var cellmsg1 = $('<p style="text-align:left;"></p>').prepend(cellname2).append("&nbsp;&nbsp;&nbsp;&nbsp;想對&nbsp;&nbsp;&nbsp;&nbsp;").append(cellseller2).append("&nbsp;&nbsp;&nbsp;&nbsp;說:");
  	 			var cellmsg2 = $('<h6 style="text-align:right;"></h6>').append("發表於").append(cellinsdate);
  	 			
  	 			var cellreport = $('<input type="button" id="'+ForumUID+'" class="btn btn-danger" onclick="report(this)" value="檢舉" style="text-align:right;" />');
 	   			var celltotal = $('<h5 id="h'+index+'" class="total" style="text-align:left;"></h5>').append("#"+(index)).append("&nbsp;&nbsp;").append(cellcomment)
								.before(cellmsg1).after(cellmsg2);
				var celltotal2 =  $('<li></li>').append(celltotal).append(cellreport);
 				$('#ul1').append(celltotal2);
 	   			
  			 });
  		 }});
     });
	

		//留言滾動效果	
		$(function() {
			var scrtime;

			var $ul = $("#con ul");
			var liFirstHeight = $ul.find("li:first").height();//第一个li的高度
			$ul.css({
				top : "-" + liFirstHeight - 20 + "px"
			});//利用css的top属性将第一个li隐藏在列表上方	 因li的上下padding:10px所以要-20

			$("#con").hover(function() {
				$ul.pause();//暂停动画
				clearInterval(scrtime);
			}, function() {
				$ul.resume();//恢复播放动画	
				scrtime = setInterval(function scrolllist() {
					//动画形式展现第一个li
					$ul.animate({
						top : 0 + "px"
					}, 1500, function() { //留言移動速度
						//动画完成时
						$ul.find("li:last").prependTo($ul);//将ul的最后一个剪切li插入为ul的第一个li
						liFirstHeight = $ul.find("li:first").height();//刚插入的li的高度
						$ul.css({
							top : "-" + liFirstHeight - 20 + "px"
						});//利用css的top属性将刚插入的li隐藏在列表上方  因li的上下padding:10px所以要-20					
					});
				}, 2500); //留言置頂速度

			}).trigger("mouseleave");//通过trigger("mouseleave")函数来触发hover事件的第2个函数

		});

		
		//更換店家選單
		$('#select2').change(function() {
			seller = $("#select2 option:selected").val();
			console.log(seller);
		});

		//將留言輸入資料庫 (跟form的差異尚未完全搞懂)
		$("#btn").click(function() {
			$.ajax({
				'type' : 'post',
				'url' : '<%= request.getContextPath() %>/ForumInsServlet',
       		  	'data':{'comment':comment,
       			  	 	'seller' :seller
       			  	 },
       		  'dataType':'json',
       		  'success': function(data){
       		 		}
       		  });
    	});
    
  	//進入留言板後立刻從資料庫讀取店家的下拉式選單內容
    $(function(){
			   $.ajax({
				  'type':'get',
				  'url':'<%= request.getContextPath() %>/GetSeller',
				  'data':{},
				  'dataType':'json',
				  'success':function(data){
					  $.each(data,function(index){
			  	 		var cellUID = JSON.parse(JSON.stringify(data[index].Account_UID));
			  	 		var cellname = JSON.parse(JSON.stringify(data[index].name));
						var opt = $("<option></option>").val(cellUID).text(cellname);
						$('#select2').append(opt);
					})
				  }
			   });
			});
  	
  	
 	//顯示datatable
	$(function(){
		$.ajax({
		  type: 'POST',
	  	   url: '<%= request.getContextPath() %>/GetDataTable',
	   	  data: {},
	  dataType: 'json',
	   success: function(resultData) {
	   	   var opt={ "oLanguage":{"sUrl":"dataTables.zh-tw.txt"},
	   			     "bProcessing":true,
	                 "bJQueryUI":true,
	                 "aoColumns":[{"sTitle":"店家","mData":"name"},
	                             {"sTitle":"最新留言","mData":"comment"},
	                             {"sTitle":"評分","mData":"rating"}],
	                 "aaData": resultData
	               };         
	        	   $("#example").dataTable(opt);
	    	    }
			});
		});
 	
	//檢舉功能
	function report(myBtn) {
		var Forum_UID = myBtn.id;
		document.forms[0].action="/8691/forumUpdate.controller?aa=" + Forum_UID ;
		document.forms[0].method="post";
		document.forms[0].submit();
		
	}
		
// 		$.ajax({
// 			'type' : 'post',
<%-- 			'url' : '<%= request.getContextPath() %>/ForumUpdateServlet', --%>
//    		  	'data':{'aa': Forum_UID },
//    		    'success': function(data){
//    		 		}
//    		    });
  		
		
		
	</script>
</body>
</html>