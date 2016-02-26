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
				<div class="col-lg-3 text-left">
					<div class="input-group">
						<input type="text" class="form-control"> <span
							class="input-group-btn">
							<button class="btn btn-default" type="button">Go!</button>
						</span>
					</div>
					<div class="btn-group">
						<button class="btn btn-default btn-lg dropdown-toggle"
							type="button" data-toggle="dropdown" aria-expanded="false">
							分類搜尋 <span class="caret"></span>
						</button>
						<ul class="dropdown-menu" role="menu">
							<li><a href="#">評價</a></li>
							<li><a href="#">最低消費</a></li>
							<li><a href="#">運費</a></li>
							<li class="divider"></li>
							<li><a href="#">Separated link</a></li>
						</ul>
					</div>					
				</div>
				<div class="col-md-2">
					<table class="table table-bordered">
						<tr>
							<td>123</td>
							<td></td>
						</tr>
					</table>
				</div>
				<div class="col-md-7">
					<table class="table table-bordered">
						<tr>
							<td>123</td>
							<td>123</td>
						</tr>
						<tr>
							<td>123</td>
							<td>123</td>
						</tr>
					</table>
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
	<script type="text/javascript">
	$('.dropdown-toggle').dropdown();
	</script>
</body>
</html>