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
    <style>
		table, th, td {
		    border: 0px solid black;
		    border-collapse: collapse;
		}
		th, td {
		    padding: 25px;
		    text-align: center;
		}
	</style>
</head>
<body>
<jsp:include page="/fragment/top.jsp" />
	<div class="container">
		<div class="row">
			<div class="box">		
				<div class="col-lg-12 text-center" >
					<form action="<c:url value="/MemberServlet" />" method="post" ></form>
					<form action="<c:url value='/_03_Orders/OrdersTotalServlet' />" method="post">
<%-- 						<input class="btn btn-primary" type="button" value="點我看訂單" onclick="location.href='<%= request.getContextPath() %>/_03_Orders/OrdersTotal.jsp'">  --%>
						<table style="width:100%">
							  <tr>
							    <td colspan="3"><h2>親愛的會員您好</h2></td>		
							  </tr>
							  <tr>
							    <td><input class="btn btn-info" type="submit" name="orderaction" value="查看我的訂單"></td>
							    <td>Jackson</td>		
							    <td>xxx</td>
							  </tr>
							  <tr>
							    <td><input class="btn btn-info" type="button" value="修改會員資料" onclick="location.href='<%= request.getContextPath() %>/_04_Members/InfoUpdate.jsp'"></td>
							    <td>Doe</td>		
							    <td>xxx</td>
							  </tr>
						</table>	
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

    <!-- jQuery -->
    <script src="<%= request.getContextPath() %>/js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="<%= request.getContextPath() %>/js/bootstrap.min.js"></script>
</body>
</html>