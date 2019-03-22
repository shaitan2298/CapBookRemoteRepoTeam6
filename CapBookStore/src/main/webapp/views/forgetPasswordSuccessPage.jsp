<html>
<body>
	<form action="changePassword">
		<div id="container">
			<div id="header">
				<h1>Change Password</h1>
			</div>
			<div align="center" id="form">
				Hello Please Set New Password <br> <input type="password"
					placeholder="New Password" id="newPassword" name="newPassword" /><br>
				<br> <input type="password" placeholder="Confirm Password"
					id="confirmPassword" name="confirmPassword" />
				
					<br>
					<button type="submit" name="change" value="change">Click
						Here to Change Password</button>
			</div>
			</div>

			<%
				if ((request.getParameter("change") != null)) {
			%>
			<div align="center">
				Your Password Has Been Successfully Changed<br>
				<a href="loggingout">Click Here To Log-In</a>
			</div>
			<%
				} else {
			%>
			<div align="center">Mismatch Password Try Again</div>
			<%
				}
			%>
	</form>
</body>
</html>