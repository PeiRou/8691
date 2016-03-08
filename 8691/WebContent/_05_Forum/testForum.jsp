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

<style>
	.label1{
		font-size:450%;
	}

	form{
		text-align:center;
	}

	textarea {
    width: 35%;
    height: 150px;
    padding: 12px 20px;
    box-sizing: border-box;
    border: 2px solid #ccc;
    border-radius: 4px;
    background-color: #f8f8f8;
    font-size: 16px;
    resize: none;
}

	form.p{
		margin-left:20px;
	
	}
		

</style>
</head>
<body>
<jsp:include page="/fragment/top.jsp" />
	<div class="container">
		<div class="row">
            <div class="box">
            <form name="Forum" action="<c:url value='/forum.controller' />" method="post">
            	<div class="col-lg-12">
                	<label class="label1" for="comment">8691巴豆揪么討論區:</label><br>
                	<h3 id="msgsp" style="color:red">${error.comment}</h3>  
                </div>
                
                <div id="con">
				<div class="bottomcover" style="z-index:2;"></div>
				<ul id="ul1"></ul>
				</div>
				
                <div>
					<textarea id="comment" name="comment" ></textarea>
                	<p><input type="submit" id="btn" value="送出" /></p>
                	<br><br>
                </div>
           	</form>	
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

    <!-- Bootstrap Core JavaScript -->
    <script src="<%= request.getContextPath() %>/js/bootstrap.min.js"></script>
    <!--jQuery-->
	<script type="text/javascript" src="<%= request.getContextPath() %>/js/jquery2.js"></script>
	<!--jQuery动画暂停插件-->
	<script type="text/javascript" src="<%= request.getContextPath() %>/js/jquery.pause.min.js"></script>
	<!--滚动效果js-->
	<script type="text/javascript">
	
	var comment = $("#comment").val();
	  
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
  	 			var cellinsdate = JSON.parse(JSON.stringify(data[index].insdate));
  	 			var cellword = $('<small></small>').append("發表於").append(cellinsdate);
  	 			var cellname2 = $('<h5 style="text-align:right;"></h5>').append(cellname1).append(cellword);
  	 			
  	 			var index = index+1;
 	   			var cellmsg1 = $('<h2 id="h'+index+'" style="text-align:left;"></h2>').append("#"+(index)).append("&nbsp;&nbsp;").append(cellcomment)
								.after(cellname2);
				var cellmsg2 =  $('<li></li>').append(cellmsg1);
 				$('#ul1').append(cellmsg2);
 	   			
  			 });
  		 }});
     });
	
	
$(function () {
    var scrtime;

    var $ul = $("#con ul");
    var liFirstHeight = $ul.find("li:first").height();//第一个li的高度
    $ul.css({ top: "-" + liFirstHeight - 20 + "px" });//利用css的top属性将第一个li隐藏在列表上方	 因li的上下padding:10px所以要-20

    $("#con").hover(function () {
        $ul.pause();//暂停动画
        clearInterval(scrtime);
    }, function () {
        $ul.resume();//恢复播放动画	
        scrtime = setInterval(function scrolllist() {
            //动画形式展现第一个li
            $ul.animate({ top: 0 + "px" }, 1500, function () { //留言移動速度
                //动画完成时
                $ul.find("li:last").prependTo($ul);//将ul的最后一个剪切li插入为ul的第一个li
                liFirstHeight = $ul.find("li:first").height();//刚插入的li的高度
                $ul.css({ top: "-" + liFirstHeight - 20 + "px" });//利用css的top属性将刚插入的li隐藏在列表上方  因li的上下padding:10px所以要-20					
            });
        }, 3000); //留言置頂速度

    }).trigger("mouseleave");//通过trigger("mouseleave")函数来触发hover事件的第2个函数

});

    
    $("#btn").click(function(){
        	$.ajax({
       		  'type':'post',
       		  'url':'<%= request.getContextPath() %>/ForumServlet',
       		  'data':{'comment':comment},
       		  'dataType':'json',
       		  'success': function(data){
       		 		}
       		  });
    	});
    
    </script>
		        
</body>
</html>