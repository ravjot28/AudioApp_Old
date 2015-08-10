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
<link rel="stylesheet" href="CSS/style.css" type="text/css" media="screen">
<link rel="stylesheet" href="CSS/footer.css" type="text/css" media="screen">
<!-- Latest compiled and minified CSS -->

<title>Audio App</title>

</head>
<body>

	<%-- <div class="navbar navbar-default navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<button class="navbar-toggle" type="button" data-toggle="collapse"
					data-target="#navbar-main">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">Audio App</a>
			</div>


			<div class="nav pull-right" id="navbar-main">
				<ul class="nav navbar-nav">
					<li class="active"><a href="#" data-toggle="modal"
						data-target="#login-modal">Sign Up</a></li>
					<li class="active"><a href="#" data-toggle="modal"
						data-target="#login-modal">Sign In</a></li>
				</ul>
				<s:form class="navbar-form navbar-right" role="search" action="login">
					<div class="form-group">
						<input type="text" class="form-control" name="username"
							placeholder="Username">
					</div>
					<div class="form-group">
						<input type="text" class="form-control" name="password"
							placeholder="Password">
					</div>
					<button type="submit" class="btn btn-default">Sign In</button>
				</s:form>
			</div>

			<div class="nav pull-right">
				
			</div>

		</div>
	</div> --%>

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
						<!-- <li class="active"><a href="#">Link</a></li> -->
						<li class="active"><a href="#" data-toggle="modal"
							data-target="#login-modal">Sign Up</a></li>
						<!-- <li><a href="#">Link</a></li>
						<li><a href="#">Link</a></li>
						<li><a href="#">Link</a></li>
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown">Dropdown <b class="caret"></b></a>
							<ul class="dropdown-menu">
								<li><a href="#">Action</a></li>
								<li><a href="#">Another action</a></li>
								<li><a href="#">Something else here</a></li>
								<li class="divider"></li>
								<li><a href="#">Separated link</a></li>
								<li class="divider"></li>
								<li><a href="#">One more separated link</a></li>
							</ul></li> -->
					</ul>
					<form class="navbar-form navbar-right" role="search" action="login">
						<div class="form-group">
							<input type="text" class="form-control" name="username"
								placeholder="Username">
						</div>
						<div class="form-group">
							<input type="text" class="form-control" name="password"
								placeholder="Password">
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
				<s:form action="register">
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

	<div id="footer">
		<ul id="footer_menu">
			<li><a href="#" class="drop">About</a>

				<div class="one_column_layout">
					<div>
						<h2>About this website</h2>
					</div>

					<div class="clear"></div>

					<div>
						<p class="black_box">This website records the voices and also
							allows user to hear the voices which are persisted in the
							application</p>
					</div>
					<div class="clear"></div>

					<div>
						<h2>Developer Profile</h2>
					</div>

					<div>
						<!-- Examples of paragraphs with side images -->
						<p>
							<img src="http://www.rankopedia.com/CandidatePix/32307.gif"
								class="img_left whiteBorder" alt="" /> <a
								style="display: inline; font-weight: bold; color: white;">Ravjot
								Singh</a> <a href="http://cultofprogramming.blogspot.ca">Read
								more...</a>
						</p>
					</div>
				</div></li>
		</ul>
	</div>
</body>
</html>