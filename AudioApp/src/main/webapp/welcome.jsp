<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">


<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="CSS/style.css" type="text/css"
	media="screen">
<link rel="stylesheet" href="CSS/footer.css" type="text/css"
	media="screen">
<!-- Latest compiled and minified CSS -->

<title>Audio App</title>

</head>
<body>

	<div class="navbar navbar-default navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<button class="navbar-toggle" type="button" data-toggle="collapse"
					data-target="#navbar-main">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">Audio App</a>
			</div>
			<center>
				<div class="navbar-collapse collapse" id="navbar-main">
					<ul class="nav navbar-nav">
						<li class="active"><a href="#" data-toggle="modal"
							data-target="#login-modal">Sign Up</a></li>

					</ul>
					<form class="navbar-form navbar-right" role="search"
						action="login.action" method="post">
						<div class="form-group">
							<input type="text" class="form-control" name="userName"
								id="userName" placeholder="Username">
						</div>
						<div class="form-group">
							<input type="password" class="form-control" name="password"
								id="password" placeholder="Password">
						</div>
						<button type="submit" class="btn btn-default">Sign In</button>
					</form>
				</div>
			</center>
		</div>
	</div>
	<div class="modal fade" id="login-modal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true"
		style="display: none;">
		<div class="modal-dialog">
			<div class="loginmodal-container">
				<h1>Sign Up</h1>
				<br>
				<s:form action="register" method="post">
					<input type="text" id="emailAddress" name="emailAddress"
						placeholder="Email Address">
					<input type="text" id="userName" name="userName"
						placeholder="User Name">
					<input type="password" id="password" name="password"
						placeholder="Password">
					<input type="password" id="repassword" name="repassword"
						placeholder="Re enter the Password">
					<input type="submit" name="login" class="login loginmodal-submit"
						value="Login">
				</s:form>
			</div>
		</div>
	</div>
	<%@include file="footer.html"%>

</body>
</html>