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
				<div class="col-lg-12">
				
<form name="updatePsd" action="<c:url value='/PsdUpdate' />" method="post">
			<h2 class="text-center">修改密碼</h2>
			<table class="table">

			<tr>
				<td class="col-xs-8 col-sm-6 text-right">請輸入舊密碼 :</td>
				<td><input type="password" name="OldPsd" value="${param.OldPsd}" id="OldPsdinput"><span id="OldPsdsp" style="color:red"></span></td>
				<td>${error.OldPsd}</td> 				
			</tr>

			<tr>
				<td class="col-xs-8 col-sm-6 text-right">請輸入新密碼 :</td>
				<td><input type="password" name="NewPsd" value="${param.NewPsd}" id="NewPsdinput"><span id="NewPsdsp" style="color:red"></span></td>
				<td>${error.NewPsd}</td>
			</tr>
			<tr>
				<td class="col-xs-8 col-sm-6 text-right">請再次輸入新密碼 :</td>
				<td><input type="password" name="NewPsd1" value="${param.NewPsd1}" id="NewPsd1input"><span id="NewPsd1sp" style="color:red"></span></td>
				<td>${error.NewPsd1}</td>
			</tr>
		    	<td></td>
				<td><input type="submit" value="確定修改" class="btn btn-primary"></td>
			    <td>${error.action}</td>
		</table>
	</form>
	</div>
	</div>			
	</div>
	</div>
	<!-- /.container -->

		<script src="//code.jquery.com/jquery-1.12.0.min.js"></script>
 		<script>
		        window.onload = function () {
		            document.getElementById("OldPsdinput").onblur = blur3;
		            document.getElementById("NewPsdinput").onblur = blur4;
		            document.getElementById("NewPsd1input").onblur = blur5;
		        }
		        
		        function blur3() {
		            if (document.getElementById("OldPsdinput").value == "") {
		            	document.getElementById("OldPsdsp").innerHTML = "<img src='<%= request.getContextPath() %>/img/error.jpg' />不可空白";
		            }		            
		        }
		        
		        function blur4() {
		            if (document.getElementById("NewPsdinput").value == "") {
		            	document.getElementById("NewPsdsp").innerHTML = "<img src='<%= request.getContextPath() %>/img/error.jpg' />不可空白";
		            }
		        }
		        
		        function blur5() {
		            if (document.getElementById("NewPsd1input").value == "") {
		            	document.getElementById("NewPsd1sp").innerHTML = "<img src='<%= request.getContextPath() %>/img/error.jpg' />不可空白";
		            }
		        }
		        
        </script>

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