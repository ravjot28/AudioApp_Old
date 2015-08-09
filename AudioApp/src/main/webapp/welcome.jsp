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

<title>Audio App</title>

</head>
<body>

	<%-- <div class="modal fade" id="login-modal" tabindex="-1" role="dialog"
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
	</center> --%>


	<!-- Button trigger modal -->

	<div class="container">
		<hr class="prettyline">
		<br>
		<center>
			<h1>
				<b>Welcome</b>
			</h1>
			<h3>You need to sign in or register for using this application</h3>
			<button class="btn btn-primary btn-lg" href="#signup"
				data-toggle="modal" data-target=".bs-modal-sm">Sign In/Sign
				Up</button>
		</center>
		<br>
		<hr class="prettyline">
	</div>


	<!-- Modal -->
	<div class="modal fade bs-modal-sm" id="myModal" tabindex="-1"
		role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-sm">
			<div class="modal-content">
				<br>
				<div class="bs-example bs-example-tabs">
					<ul id="myTab" class="nav nav-tabs">
						<li class="active"><a href="#signin" data-toggle="tab">Sign
								In</a></li>
						<li class=""><a href="#signup" data-toggle="tab">Sign Up</a></li>
						<li class=""><a href="#why" data-toggle="tab">Why?</a></li>
					</ul>
				</div>
				<div class="modal-body">
					<div id="myTabContent" class="tab-content">
						<div class="tab-pane fade in" id="why">
							<p>We need this information so that you can receive access to
								the site and its content. Rest assured your information will not
								be sold, traded, or given to anyone.</p>
							<p></p>
							<br> Please contact <a mailto:href="rsingh@cs.queensu.ca"></a>rsingh@cs.queensu.ca</a>
							for any other inquiries.
							</p>
						</div>
						<div class="tab-pane fade active in" id="signin">
							<s:form class="form-horizontal" action="login">
								<fieldset>
									<!-- Sign In Form -->
									<!-- Text input-->
									<div class="control-group">
										<label class="control-label" for="userid">Alias:</label>
										<div class="controls">
											<input required="" id="userName" name="userid" type="text"
												class="form-control" placeholder="Email Address"
												class="input-medium" required="">
										</div>
									</div>

									<!-- Password input-->
									<div class="control-group">
										<label class="control-label" for="passwordinput">Password:</label>
										<div class="controls">
											<input required="" id="password" name="password"
												class="form-control" type="password" placeholder="********"
												class="input-medium">
										</div>
									</div>

									<!-- Button -->
									<div class="control-group">
										<label class="control-label" for="signin"></label>
										<div class="controls">
											<button id="signin" name="signin" type="submit"
												class="btn btn-success">Sign In</button>
										</div>
									</div>
								</fieldset>
							</s:form>
						</div>
						<div class="tab-pane fade" id="signup">
							<s:form class="form-horizontal" action="register">
								<fieldset>
									<!-- Sign Up Form -->
									<!-- Text input-->
									<div class="control-group">
										<label class="control-label" for="Email">Email:</label>
										<div class="controls">
											<input id="email" name="email" class="form-control"
												type="text" placeholder="Email Address" class="input-large"
												required="">
										</div>
									</div>

									<!-- Text input-->
									<div class="control-group">
										<label class="control-label" for="userid">Alias:</label>
										<div class="controls">
											<input id="fullname" name="fullname" class="form-control"
												type="text" placeholder="Full Name" class="input-large"
												required="">
										</div>
									</div>

									<!-- Password input-->
									<div class="control-group">
										<label class="control-label" for="password">Password:</label>
										<div class="controls">
											<input id="password" name="password" class="form-control"
												type="password" placeholder="********" class="input-large"
												required=""> <em>1-8 Characters</em>
										</div>
									</div>

									<!-- Text input-->
									<div class="control-group">
										<label class="control-label" for="reenterpassword">Re-Enter
											Password:</label>
										<div class="controls">
											<input id="repassword" class="form-control" name="repassword"
												type="password" placeholder="********" class="input-large"
												required="">
										</div>
									</div>

									<!-- Multiple Radios (inline) -->
									<br>
									<div class="control-group">
										<label class="control-label" for="humancheck">Humanity
											Check:</label>
										<div class="controls">
											<label class="radio inline" for="humancheck-0"> <input
												type="radio" name="humancheck" id="humancheck-0"
												value="robot" checked="checked">I'm a Robot
											</label> <label class="radio inline" for="humancheck-1"> <input
												type="radio" name="humancheck" id="humancheck-1"
												value="human">I'm Human
											</label>
										</div>
									</div>

									<!-- Button -->
									<div class="control-group">
										<label class="control-label" for="confirmsignup"></label>
										<div class="controls">
											<button id="confirmsignup" name="confirmsignup"
												class="btn btn-success">Sign Up</button>
										</div>
									</div>
								</fieldset>
							</s:form>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<center>
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					</center>
				</div>
			</div>
		</div>
	</div>







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