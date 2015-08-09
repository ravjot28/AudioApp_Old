<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="LoginRegistration.css" type="text/css"
	media="screen">
<link rel="stylesheet" href="footer.css" type="text/css" media="screen">
<title>FameDen</title>

</head>
<body>
	<div>
		<s:form action="login">
			<div align="right">
				<s:textfield name="userName" label="Username"></s:textfield>
				<s:password name="password" label="Password" />
				<center>
					<s:submit value="Login"></s:submit>
				</center>
			</div>
		</s:form>
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


			<li class="left"><a href="#" class="drop">About</a>

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