<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Account management</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/static/css/main.css" />
</head>

<body>
	<h4>user's accounts list</h4>
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


	<h4>Account transaction.</h4>

	<sf:form method="post"
		action="${pageContext.request.contextPath}/dotransaction">

		<table>
			<tr>
				<td>From/To AccountId</td>
				<td><select name="actId">
						<c:forEach var="account" items="${accounts}">
							<option value="${account.actid}" selected>${account.actid}</option>
						</c:forEach>
				</select></td>
			</tr>

			<tr>
				<td>Transaction Type</td>
				<td><input type="radio" name="transtype" value="deposit"
					checked />Deposit</td>
				<td><input type="radio" name="transtype" value="withdraw" />Withdraw</td>
			</tr>
			<tr>
				<td>Amount:</td>
				<td><input name="amount" type="text" value="0.00"></td>
			</tr>
			<tr>
				<td><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</sf:form>

</body>

</html>