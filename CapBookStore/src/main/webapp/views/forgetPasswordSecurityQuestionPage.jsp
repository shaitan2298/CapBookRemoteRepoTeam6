<html>
<head>
<style>
.error {
	color: "red";
	font-weight: bold;
}
</style>
</head>
<body>
	<div align="center">
		<form action="forgetPasswordSuccess" method="post">
			<table>
				<tr>
					<td><h2>Please Do Answer The Following</h2></td>
				</tr>
				<tr>
					<td>${user.securityQuestion }</td>
				</tr>
				<tr>
					<td>Enter Answer:<input type="text" name="securityAnswer"
						placeholder="securityAnswer" /></td>
				</tr>
				<tr>
					<td><input type="submit" name="submit" value="submit" /></td>
				</tr>
			</table>
		</form>
	</div>
	<div align="center" class="error">${errorMessage}</div>
</body>
</html>
