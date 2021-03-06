<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Login Page</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/static/css/main.css" />
</head>

<body onload='document.f.username.focus();'>
	<h3>Login with Username and Password</h3>
	<c:if test="${param.error !=null}">
		<p class="error">Login failed check you username and password</p>
	</c:if>

	<form name='f' action='${pageContext.request.contextPath}/login'
		method='POST'>
		<table class="formtable">
			<tr>
				<td>UserName:</td>
				<td><input type='text' name='username' value=''></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type='password' name='password' /></td>
			</tr>

			<tr>
				<td>Remember me</td>
				<td><input type='checkbox' name='remember-me'
					checked="checked" /></td>
			</tr>
			<tr>
				<td colspan='2'><input name="submit" type="submit"
					value="Login" /></td>
				<td><input name="_csrf" type="hidden" value="${_csrf.token}" /></td>
			</tr>

		</table>
	</form>

	<p>
		<a href="<c:url value="/newuser"/>">Create a new user </a>
	</p>

</body>

</html>