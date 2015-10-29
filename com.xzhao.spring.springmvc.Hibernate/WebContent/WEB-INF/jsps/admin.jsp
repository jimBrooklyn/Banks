<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/static/css/main.css" />
<title>Insert title here</title>
</head>
<body>
	<p>This is for administror only.</p>

	<table class="formtable">
		<tr>
			<th>Username</th>
			<th>Name</th>
			<th>Email</th>
			<th>Enabled</th>
			<th>Authority</th>
		</tr>
		<c:forEach var="user" items="${users}">

			<tr>
				<td><c:out value="${user.username}"></c:out></td>
				<td><c:out value="${user.name}"></c:out></td>
				<td><c:out value="${user.email}"></c:out></td>
				<td><c:out value="${user.enabled}"></c:out></td>
				<td><c:out value="${user.authority}"></c:out></td>
			</tr>


		</c:forEach>

	</table>

</body>
</html>