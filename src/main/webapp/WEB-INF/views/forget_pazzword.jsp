<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>forget_pwd</title>
</head>
<body bgcolor="black">
<br>
		<h1 style="color: silver;text-align: center;"><i>Forget Password</i></h1>
		<h2 style="color:orange; text-align: center">${result}</h2>
	
		<form:form action="changePwd" method="POST" modelAttribute="userLogin">
			<table border="5" align="center" style="border-color: red;background-color:maroon; align="center">
				<tr>
					<td style="color: silver;"><b>Email : </b> </td>
					<td><form:input path="email" /></td>
				</tr>
				<tr>
					<td align="center" align="center" colspan="2"><input type="submit" value="Submit" /></td>
				</tr>
			</table>
			
			<a href="/"><h3 style="color: red; text-align: center;">Login</h3></a>
		</form:form>
</body>
</html>