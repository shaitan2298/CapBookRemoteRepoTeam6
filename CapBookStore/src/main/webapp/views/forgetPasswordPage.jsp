<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<body>
	<form action="forgetPassword" method="post">
		<div id="highlighted" class="hl-basic hidden-xs">
			<div class="container-fluid">
				<div class="row">
					<div
						class="col-sm-9 col-sm-offset-3 col-md-9 col-md-offset-3 col-lg-10 col-lg-offset-2">
						<h1>Forgot Password</h1>
					</div>
				</div>
			</div>
		</div>
		<div id="content" class="interior-page">
			<div class="container-fluid">
				<div class="row">

					<!--Content-->
					<div class="col-sm-9 col-md-9 col-lg-10 content equal-height">
						<div class="content-area-right">
							<div class="content-crumb-div">
								<a href="">Home</a> | <a href="">Your Account</a> | Forgot
								Password
							</div>
							<div class="row">
								<div class="col-md-5 forgot-form">
									<p>Please enter your email address below to change your
										password.</p>
									<input type="email" name="email1" placeholder="Enter Email Here">
									<input type="submit" name="process" value="submit">
								</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div><%-- 
									<%
										if ((request.getParameter("process") == null)) {
									%>
										You've Entered An Incorrect Email
									<%
										} else {
									%>
								
									<div align="center">
										Security Question : ${user.securityQuestion}
										<table>
											<tr>
												<td><input type="text" name="securityAnswer"></td>
											</tr>
										</table>
									</div>
									<%
										}
									%> --%>
		<script
			src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
		<link rel="stylesheet"
			href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		<script
			src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	</form>
</body>

</html>