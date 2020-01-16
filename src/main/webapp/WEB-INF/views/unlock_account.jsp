<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<p style="color: maroon;">
	<form:errors path="*" />

	<!DOCTYPE html>
	<html>
<head>
<meta charset="ISO-8859-1">
<title>unlock_account</title>

<!-- <script type="text/javascript">
	function checkPassword(){
		var newPassword = document.getElementById("newPwd").value;
		var cnfPassword = document.getElementById("cnfPwd").value;
		if(newPassword == cnfPassword){
			return true;
		}
		else{
			alart("Password Didn't match,Please Enter valid Password..")
		}
	}

</script> -->

</head>
<body bgcolor="black" style="color: orange;">
	<br>
	<h1 style="color: silver; text-align: center">
		<I>UNLOCK ACCOUNT</I>
	</h1>
	<h2 style="color: lime; text-align: center;">${unlkSucessResult}</h2>
	<h2 style="color: red; text-align: center;">${unlkFailuresResult}</h2>
	<br>
	<form:form action="activeAccount" method="POST"
		modelAttribute="unlockUsrRegstion"
		onsubmit="return checkPassword()">
		<table border="5" align="center"
			style="border-color: red; background-color: maroon;"center">
			<tr>
				<td style="color: silver;"><b>Email :</b></td>
				<td><form:input path="email" readonly="true" /></td>
			</tr>
			<tr>
				<td style="color: silver;"><b>Temp Password : </b></td>
				<td><form:input path="tempPwd" /><br> <span
					id="tempPwdError"> </span></td>
			</tr>
			<tr>
				<td style="color: silver;"><b>New Password : </b></td>
				<td><form:input path="newPwd" /><br> <span
					id="newPwdError"> </span></td>
			</tr>
			<tr>
				<td style="color: silver;"><b>Confirm Password : </b></td>
				<td><form:input path="cnfPwd" /><br> <span
					id="cnfPwdError"> </span></td>
			</tr>
			<tr>
				<td align="center"><input type="reset" value="Reset"></td>
				<td align="center"><input type="submit" value="Submit"></td>
			</tr>
		</table>
			<a href="/"><h3 style="color: red; text-align: center;">Login</h3></a>
	</form:form>
	
	<script type="text/javascript">
	
	function checkPassword(){
		
		var tpwd=tempPwd.value;
		var npwd = newPwd.value;
		var cpwd= cnfPwd.value;
		
		document.getElementById("tempPwdError").innerHTML = " ";
		document.getElementById("newPwdError").innerHTML = " ";
		document.getElementById("cnfPwdError").innerHTML = " ";
		
		if(tpwd == ""){
			document.getElementById("tempPwdError").innerHTML = "Please Enter Temporary Password";
			tempPwd.focus();
			return false;
		}
		if(npwd == ""){
			document.getElementById("newPwdError").innerHTML = "Please Enter a New Password";
			newPwd.focus();
			return false;
		}
		if(cpwd == ""){
			document.getElementById("cnfPwdError").innerHTML = "Please Confirm Password";
			cnfPwd.focus();
			return false;
		}
		if(npwd.localeCompare(cpwd)!=0){
			document.getElementById("cnfPwdError").innerHTML = "Password Didn't Match";
			cnfPwd.focus();
			return false;
		}
		
	}
	</script>
</body>
	</html>