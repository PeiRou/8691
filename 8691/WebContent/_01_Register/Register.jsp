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
<div class="brand">Business Casual</div>
    <div class="address-bar">3481 Melrose Place | Beverly Hills, CA 90210 | 123.456.7890</div>

    <!-- Navigation -->
    <nav class="navbar navbar-default" role="navigation">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <!-- navbar-brand is hidden on larger screens, but visible when the menu is collapsed -->
                <a class="navbar-brand" href="index.jsp">Business Casual</a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li>
                        <a href="<%= request.getContextPath() %>/index.jsp">Home</a>
                    </li>
                    <li>
                        <a href="<%= request.getContextPath() %>/about.jsp">About</a>
                    </li>
                    <li>
                        <a href="<%= request.getContextPath() %>/blog.jsp">Blog</a>
                    </li>
                    <li>
                        <a href="<%= request.getContextPath() %>/contact.jsp">Contact</a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>

	<div class="container">
		<div class="row">
			<div class="box">
				<div class="col-md-6">
				<form name="Register" action="<c:url value='/page/register.controller' />" method="post">
		<table>
			<tr>
				<td>Enter your name :</td>
				<td><input type="text" name="name" value="${param.name}"></td>
				<td></td>
			</tr>
			<tr>
				<td>Enter your email/Account :</td>
				<td><input type="text" name="acc_email"
					value="${param.acc_email}"></td>
				<td></td>
			</tr>
			<tr>
				<td>Enter your password :</td>
				<td><input type="text" name="psd" value="${param.psd}"></td>
				<td></td>
			</tr>
			<tr>
				<td>Set your gender :</td>
				<td><select name="gender" size="1" value="${param.gender}">
						<option value="" selected>請選擇</option>
						<option value="male">男♂</option>
						<option value="female">女♀</option>
				</select></td>
				<td></td>
			</tr>

			<tr>
				<td>Enter your home-phone number :</td>
				<td><input type="text" name="phone" value="${param.phone}"></td>
				<td></td>
			</tr>
			<tr>
				<td>Enter your cell-phone number :</td>
				<td><input type="text" name="cellphone"
					value="${param.cellphone}"></td>
				<td></td>
			</tr>
			<tr>
				<td>Enter your Address :</td>
				<td><input type="text" name="acc_email"
					value="${param.acc_email}"></td>
				<td></td>
			</tr>
			<tr>
				<td>Enter your backup email :</td>
				<td><input type="text" name="email2" value="${param.email2}"></td>
				<td></td>
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