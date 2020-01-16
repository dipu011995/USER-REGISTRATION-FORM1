<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>login_info</title>


</head>
<body bgcolor="black" style="width: 100%; height: 250%">
	<br>
	<h1 style="color: silver; text-align: center;">Welcome To
		TekLeads. Please login...</h1>

	<h2 style="color: red; text-align: center;">${accLockedMsg}</h2>
	<h2 style="color: red; text-align: center;">${errorMsg}</h2>

	<form:form action="checkCredential" method="POST"
		modelAttribute="loginInfo">
		<table border="5" align="center"
			style="border-color: red; background-color: maroon;">
			<tr>
				<td style="color: silver;"><b>Email :: </b></td>
				<td><form:input path="email" /></td>
			</tr>
			<tr>
				<td style="color: silver;"><b>Password :: </b></td>
				<td><form:input path="password" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="Sign In" /></td>
			</tr>
			</tr>
			<tr>
				<td align="center"><a href="forgetPwd" style="color: silver;"><b>Forget
							Password ? </b></a></td>
				<td align="center"><a href="signup" style="color: silver;"><b>Sign
							Up</b></a></td>
			</tr>
		</table>
	</form:form>

</body>
</html>