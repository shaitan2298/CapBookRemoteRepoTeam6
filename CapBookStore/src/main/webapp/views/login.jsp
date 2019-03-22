<html>
<body>
	<form action="loginUser" method="post">
		<div class="container">
			<label for="email"><b>Username</b></label> <input type="email"
				placeholder="Enter Username" name="email" required> <label
				for="password"><b>Password</b></label> <input type="password"
				placeholder="Enter Password" name="password" required>

			<button type="submit">Login</button>
			<label> <input type="checkbox" checked="checked"
				name="remember"> Remember me
			</label>
		</div>
		</form>
		<form name="f1">
		<div class="container" style="background-color: #f1f1f1">
		<a href="forgetpass">Forgot Password?</a>
			
			<%-- <span class="password">Forgot<a href="${pageContext.request.contextPath}/views/forgetPasswordPage.jsp">password?</a></span> --%>
		</div>
	</form>
</body>
</html>