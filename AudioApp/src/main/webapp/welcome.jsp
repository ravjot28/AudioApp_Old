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
<link rel="stylesheet" href="style.css" type="text/css" media="screen">
<link rel="stylesheet" href="footer.css" type="text/css" media="screen">
<!-- Latest compiled and minified CSS -->

<title>FameDen</title>

</head>
<body>

	<div class="modal fade" id="login-modal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true"
		style="display: none;">
		<div class="modal-dialog">
			<div class="loginmodal-container">
				<h1>Login to Your Account</h1>
				<br>
				<s:form action="login">
					<input type="text" name="userName" placeholder="Username">
					<input type="password" name="password" placeholder="Password">
					<input type="submit" name="login" class="login loginmodal-submit"
						value="Login">
				</s:form>

				<div class="login-help">
					<a href="#">Register</a> - <a href="#">Forgot Password</a>
				</div>
			</div>
		</div>
	</div>
	<center>
		<div class=transbox>
			<div id=Registration>
				<s:form action="register">
					<div align="center">
						<s:textfield id="fullname" name="fullname" label="Full Name"></s:textfield>
						<s:textfield id="email" name="email" label="Email"></s:textfield>
						<s:password id="password" name="password" label="Password" />
						<s:password id="repassword" name="re-enter password"
							label="Re-Enter Password" />
						<s:submit value="Sign Up"></s:submit>
					</div>
				</s:form>
			</div>
		</div>
	</center>
	<div id="footer">
		<ul id="footer_menu">
			<li class="homeButton"><a href="#" data-toggle="modal"
				data-target="#login-modal">Login</a></li>
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
		<!-- End Footer Menu -->



	</div>
</body>
</html>