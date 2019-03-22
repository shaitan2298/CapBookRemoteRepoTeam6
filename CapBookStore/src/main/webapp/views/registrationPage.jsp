<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CapBook Registration Form</title>
</head>
<body>
	<h2 align="center">CAPBOOK REGISTRATION FORM</h2>
	<div class="container">
		<form:form name="registrationForm" action="registerUser" method="post"
			modelAttribute="user">
			<table>
				<!----- First Name----->
				<tr>
					<td>First Name :</td>
					<td><form:input id="firstName" path="firstName" /> <label
						for="firstName">First Name</label></td>
				</tr>
				<!-----Last Name----->
				<tr>
					<td>Last Name :</td>
					<td><form:input id="lastName" path="lastName" /> <label
						for="lastName">Last Name</label></td>
				</tr>
				<!----- Email Id----->
				<tr>
					<td>Email ID :</td>
					<td><form:input id="email" type="email" path="email" /> <label
						for="email">E-mail Id</label>
				</tr>
				
				<form:input id="dob" cssClass="validate" path="dob" />
				<label for="dob">Date of Birth(dd/mm/yyyy)</label>
				
				<form name="password_confirm">
				<!----- Password----->
				<tr>
					<td>New Password :</td>
					<td><form:input id="password" type="password" path="password" />
						<label for="password">Password</label></td>
				</tr>


				<tr>
					<td>Confirm Password</td>
					<td><input type="password" name="confirmPassword"></td>
				</tr>


				<!----- Confirm Password----->
				<tr>
					<td>Confirm New Password :</td>
					<td><input type="password" placeholder="Re-enter Password"
						id="confirmPassword" required></td>
				</tr>
				<br>
			</form>
				<!----- Gender----->
				<!-- <tr>
				<td>Gender :</td>
				<td>Male <input type="radio" name="gender" value="Male" />
					Female <input type="radio" name="gender" value="Female" />
				</td>
			</tr> -->
				<tr>
					<td><form:label path="gender">Gender</form:label></td>
					<td><form:radiobutton path="gender" value="Male" />Male</td>
					<td><form:radiobutton path="gender" value="Female" />Female></td>
				</tr>
				<!----- Date Of Birth----->
				<tr>
				<form:form path>
				 <td>Date Of Birth : </td>
				 <td><form:input type="date" name="dob" id="dob" required></td>
				</form:form>

				<form:input id="dob" cssClass="validate" path="dob" />
				<label for="dob">Date of Birth(dd/mm/yyyy)</label>

				<td>Date Of Birth :</td>
						<td><form:input type="text" id="dob" cssClass="validate"
						path="dob" placeholder="DD-MM-YYYY" required
						pattern="(?:30))|(?:(?:0[13578]|1[02])-31))/(?:0[1-9]|1[0-9]|2[0-9])|(?:(?!02)(?:0[1-9]|1[0-2])/(?:19|20)[0-9]{2}-(?:(?:0[1-9]|1[0-2])"
						title="Enter a date in this format DD-MM-YYYY" /></td>
				<!----- Security Question----->
				<tr>
					<td><form:select name="securityQuestion" id="securityQuestion"
							path="securityQuestion">
							<form:option value="-1">Select a Security Question</form:option>
							<form:option value="1">What is your best friend's name?</form:option>
							<form:option value="2">What is the name of your favorite
							book?</form:option>
							<form:option value="3">What is your favorite game?</form:option>
							<form:option value="4">At what time were you born?</form:option>
							<form:option value="5">What was the name of your first pet?</form:option>
						</form:select></td>

					<td><form:input type="text" id="securityAnswer"
							path="securityAnswer" /></td>
				</tr>
				<!----- Submit and Reset----->
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="Submit"> <input type="reset" value="Reset">
					</td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>
 --%>




<html>

<head>
	<title>CapBook Registration Form</title>
</head>
 
<body>
	<h2 align="center">CAPBOOK REGISTRATION FORM</h2> 
	<p align="center">It's Free and always will be; We don't get paid enough</p>    
	<form action="registerUser" method="post" modelAttribute="user">
		<table align="center" cellpadding = "30" border="2">
			--- First Name---
			<tr>
				<td>First Name : </td>
				<td><input type="text" name="firstName" id="firstName" maxlength="25" required/>
			</tr>
			<br>
			---Last Name---
			<tr>
				<td>Last Name : </td>
				<td><input type="text" name="lastName" id="lastName" maxlength="25" required/>
				</td>
			</tr>
			<br>
			--- Email Id---
			<tr>
				<td>Email ID : </td>
				<td><input type="text" name="email" id="email" maxlength="100" required/></td>
			</tr>
			<br>
			<form name="password_confirm">
				--- Password---
				<tr>
					<td>New Password : </td>
					<td><input type="password" name="password" placeholder="Enter Password" id="password" required></td>
				</tr>
				<br>
				--- Confirm Password---
				<tr>
					<td>Confirm New Password : </td>
					<td><input type="password" placeholder="Re-enter Password" id="confirmPassword" required></td>
				</tr>
				<br>
			</form>
			--- Gender---
			<tr>
				<td>Gender : </td>
				<td>
				Male <input type="radio" name="gender" value="Male" />
				Female <input type="radio" name="gender" value="Female" />
				</td>
			</tr>
			
			<tr></tr>
			
			
			--- Date Of Birth---
			<tr>
				<form>
				 <td>Date Of Birth :</td>
						<td><input type="text" name="dob" placeholder="DD-MM-YYYY" required
						pattern="(?:30))|(?:(?:0[13578]|1[02])-31))/(?:0[1-9]|1[0-9]|2[0-9])|(?:(?!02)(?:0[1-9]|1[0-2])/(?:19|20)[0-9]{2}-(?:(?:0[1-9]|1[0-2])"
						title="Enter a date in this format DD-MM-YYYY" /></td>
				</form>
			</tr>
			<br>
			<br>
			--- Security Question---
			<tr>
				<td>
					<select name="securityQuestion" id="securityQuestion" required>
						<option value="-1">Select a Security Question</option>
						<option value="What is your best friend's name?">What is your best friend's name?</option>
						<option value="What is the name of your favourite book?">What is the name of your favourite book?</option>
						<option value="What is your favourite game?">What is your favourite game?</option>
						<option value="At what time were you born?">At what time were you born?</option>
						<option value="What was the name of your first pet?">What was the name of your first pet?</option>	
					</select>
				</td>
				<td><input type="text" name="securityAnswer" maxlength="25" required/></td>
			</tr>
			--- Submit and Reset---
			<tr>
				<td colspan="2" align="center">
				<input type="submit" value="Submit">
				<input type="reset" value="Reset">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>