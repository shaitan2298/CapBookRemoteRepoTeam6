<html>
<body>
<form action="loggingout" method="post">
<font size="10">CapBook</font><br>
	${user.email}
<div align="right">

<input type="submit" name="logout" value="logout" />
</div>
<div align="center">
<a href="setPassword" >Change Password</a>
<br><br>
</div>
</form>
<div align="center">
<form action="uploadImage" enctype="multipart/form-data" method="post">
<input type="file" name="imageFile">
<input type="submit" value="Upload"/>
</form>
</div>
</body>
</html>