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

<title>This is my homepage</title>
</head>
<body>

	<p>Hello there:</p>

	<table class="formtable">
		<tr>
			<th>Name</th>
			<th>AccountId</th>
			<th>Account Type</th>
			<th>Interest rate</th>
			<th>Balance</th>
		</tr>
		<c:forEach var="account" items="${accounts}">
			<tr>
				<td><c:out value="${account.user.name}"></c:out></td>
				<td><c:out value="${account.actid}"></c:out></td>

				<td><c:out value="${account.acttype}"></c:out></td>

				<td><c:out value="${account.inrate}"></c:out></td>

				<td><c:out value="${account.balance}"></c:out></td>
			</tr>

		</c:forEach>
	</table>

	<c:choose>

		<c:when test="${hasAccount}">

			<p>
				<a href="<c:url value="/createaccount"/>"> Edit your account</a>
			</p>


		</c:when>



		<c:otherwise>
			<p>
				<a href="<c:url value="/createaccount"/>"> Create a new account</a>
			</p>

		</c:otherwise>

	</c:choose>


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
			<a href="<c:url value="/admin"/>">Admin</a>
		</p>

	</sec:authorize>
</body>
</html>