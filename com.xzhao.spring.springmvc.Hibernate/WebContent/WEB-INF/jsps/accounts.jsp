<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/static/css/main.css" />
</head>

<body>
	<h2>All accounts table </h2>
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

</body>

</html>