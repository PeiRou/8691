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


    
</head>
<body>
<jsp:include page="/fragment/top.jsp" />
	<div class="container">
		<div class="row">
            <div class="box">
            <form name="Forum" action="<c:url value='/forum.controller' />" method="post">
                <div class="col-lg-12">
                	<label class="control-label col-md-6" for="comment">8691討論專區:</label>   
                </div>
                <div id="div1" class="col-md-6">
					<textarea class="auto-height" id="comment" name="comment" rows="6" cols="80"></textarea>
                	<input type="submit" id="btn" value="送出" /><span id="msgsp" style="color:red">${error.comment}</span>
                	<br>
                	<br>
                </div>
                <div class="col-md-6"></div>
                <div class="clearfix"></div>
           	</form>	
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
    <script type="text/javascript">
    
       var comment = $("#comment").val();
  
       $(function LoadComment(){
     	   $.ajax({
     		  'type':'get',
     		  'url':'<%= request.getContextPath() %>/GetComment',
     		  'data':{},
     		  'dataType':'json',
     		  'success': function(data){
     			 $("#msgsp").empty();
     			 $.each(data,function(index){
     	 			var cellcomment = JSON.parse(JSON.stringify(data[index].comment));
     	 			var cellinsdate = JSON.parse(JSON.stringify(data[index].insdate));
     	 			var cellconnect = $('<small></small>').append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;發表於")
     	 			var index = index+1;
    				var cellmsg = $('<h3 id="h'+index+'"></h3>').append("#"+(index)).append("&nbsp;&nbsp;").append(cellcomment).append(cellconnect).append(cellinsdate);
    	   			$('#div1').append(cellmsg);
    	   			
     			 });
     		 }});
        });
    
    
    
    $("#btn").click(function(){
        	$.ajax({
       		  'type':'get',
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