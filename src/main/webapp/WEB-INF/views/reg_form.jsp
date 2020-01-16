<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src=https://code.jquery.com/jquery-1.12.4.js></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script type="text/javascript" src="js/jquery-3.4.1.js"></script>

<meta charset="ISO-8859-1">
<title>user_form</title>

<!-- src="http://code.jquery.com/jquery-3.4.1.min.js" -->

</style>
<!-- <script type="text/javascript"
	src="js/jquery-3.4.1.min.js" >
</script> -->





</head>
<body bgcolor="black">
	<h1 style="color: silver; text-align: center;"><i>User Registration</i></h1>

	<h3 style=" color: lime;text-align: center;"> ${susessResult}</h3>
	<h3 style=" color: red;text-align: center;">${failedResult}</h3>		

	<form:form action="addUser" method="POST" modelAttribute="registration">
		<table border="5" align="center" style="border-color: red;background-color:maroon;  "
			align="center">
			<tr>
				<td style="color:silver; "><b>First Name :</b></td>
				<td><form:input path="fname" /></td>
			</tr>
			<tr>
				<td style="color:silver;"><b>Last Name :</b></td>
				<td><form:input path="lname" /></td>
			</tr>
			<tr>
				<td style="color: silver;"><b>Email :</b></td>
				<td><form:input path="email" id="mai" />
				<div id="dupEmail" style="color:orange"> </div>
				</td>
			</tr>
			<tr>
				<td style="color: silver;"><b>Phone Number :</b></td>
				<td><form:input path="phNo" /></td>
			</tr>
			<%-- <tr>
				<td style="color: silver;"><b>Date of Birth :</b></td>
				<td><form:da path="dob" id="datepicker" /></td>
			</tr> --%>
			<tr>
				<td style="color: silver;"><b>Gender :</b></td>
				<td><form:input path="gender" /></td>
			</tr>
			<tr>
				<td style="color: silver;"><b>Country :</b></td>
				<td><form:input path="country" /></td>
			</tr>
			<tr>
				<td style="color: silver;"><b>State :</b></td>
				<td><form:input path="state" /><td>
			</tr>
			<tr>
				<td style="color: silver;"><b>City :</b></td>
				<td><form:input path="city" /></td>
			</tr>
			<tr>
				<td align="center"><input type="reset" value="Reset" ></td>
				<td align="center"><input type="submit" value="Submit"></td>
			</tr>

		</table>
	<br>
	<a href="/"><h3 style="color: red; text-align: center;">Login</h3></a>
	</form:form>
<script type="text/javascript" >
	$(document).ready(function() {
		$('#mai').blur(function() {
			 $('#dupEmail').html(" ");
			var mailId = $('#mai').val();
			$.ajax({
				type : 'GET',
				
				url : '/findDupEmail?emailId=' + mailId ,
						
				success : function(result) {
					if(result == 'DUPLICATE'){
						$("#dupEmail").html("Email Already Register..Please Try another one..");
						$("#mai").focus();
					}
				}
			});
		});
	}); 
</script>
</body>

<script>
  $(function() {
    $("#datepicker").datepicker();
  });
</script>

</html>
