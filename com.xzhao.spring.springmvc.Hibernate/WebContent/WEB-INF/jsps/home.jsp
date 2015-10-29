<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/static/css/main.css" />

<title>This is your homepage</title>
</head>
<body>

	<div id="bankhead"> 
	<p style="text-align:center; font-size:large; color:red"> Welcome to <span id="banklogo">Alphabet Bank Online</span></p>
	</div>


	<c:choose>
		<c:when test="${hasAccount}">
			<p>
				<a href="<c:url value="/accounts"/>"> Manage your accounts</a>
			</p>
		</c:when>
	</c:choose>
			<p>
				<a href="<c:url value="/createaccount"/>"> Create a new account</a>
			</p>
	<sec:authorize access="!isAuthenticated()">

		<p>
			<a href="<c:url value="/login"/>">Log in</a>
		</p>

	</sec:authorize>

	<sec:authorize access="isAuthenticated()">
		<c:url var="logoutUrl" value="/logout" />
		<form action="${logoutUrl}" method="post">
			<input type="submit" value="Log out" /> <input type="hidden"
				name="${_csrf.parameterName}" value="${_csrf.token}" />
		</form>
	</sec:authorize>

	<sec:authorize access="hasRole('ROLE_ADMIN')">
		<p>
			<a href="<c:url value="/admin"/>">All users list</a>
		</p>
		
		<p>
			<a href="<c:url value="/allaccounts"/>">All bank accounts list</a>
		</p>
	</sec:authorize>
</body>
</html>