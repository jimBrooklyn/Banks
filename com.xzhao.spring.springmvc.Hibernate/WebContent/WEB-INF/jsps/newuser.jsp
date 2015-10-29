<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/script/jquery.js"> </script>

<script type="text/javascript">

function onload(){
	$("#confirmpass").keyup(checkpass);
	$("#details").submit(canSubmit);
}

function canSubmit(){
	var password =$("#password").val();
	var confirmpass =$("#confirmpass").val();
	if(password ===confirmpass){
		return true;
	}else{
		return false;
	}
}

function checkpass(){
	var password =$("#password").val();
	var confirmpass =$("#confirmpass").val();
	
	if(password.length > 0){
		
		if(password===confirmpass){
			$("#matchpass").text("passwords match");
			$("#matchpass").addClass("good");
			$("#matchpass").removeClass("error");
		}else{
			$("#matchpass").text("passwords don't match");
			$("#matchpass").addClass("error");
			$("#matchpass").removeClass("good");
		}
	}
}

$(document).ready(onload);
</script>


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/static/css/main.css"/>
</head>

<body>
	<h4>Create a new user from here.</h4>

	<sf:form id="details" method="post" 
		action="${pageContext.request.contextPath}/createuser" commandName="user">

		<table class="formtable">
			<tr>
				<td>Username:</td>
				<td><sf:input name="username" path="username" type="text" /><br />
					<sf:errors path="username" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Name:</td>
				<td><sf:input path="name" name="name" type="text" /> <br />
					<sf:errors path="name" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><sf:input path="email" name="email" type="text" /> <br />
					<sf:errors path="email" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><sf:input id="password" path="password" name="password" type="password" /> <br />
					<sf:errors path="password" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Confirm Password:</td>
				<td><input id="confirmpass" name ="confirmpass" type="password" />
				<br/><div id="matchpass"></div>
			</td>				
			</tr>
			<tr>
				<td><input type="submit" value="Submit it"></td>
			</tr>

		</table>

	</sf:form>

</body>
</html>