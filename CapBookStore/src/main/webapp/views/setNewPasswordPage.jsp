<html>
<body>
	<form action="setNewPassword">
		<div id="container">
			<div id="header">
				<h1>Change Password</h1>
			</div>
			<div align="center" id="form">
				Hello Please Set New Password <br> 
				<input type="password"	placeholder="Old Password" name="oldPassword" /><br><br>
				<input type="password"	placeholder="New Password" name="newPassword" /><br><br> 
				<input type="password" placeholder="Confirm Password" name="confirmPassword" />
				
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
				<a href="profilePage">Click Here To Go Back To Profile</a>
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