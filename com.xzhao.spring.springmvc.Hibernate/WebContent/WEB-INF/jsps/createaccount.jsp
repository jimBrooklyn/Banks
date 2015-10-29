<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/script/jquery.js"> </script>

<script>

$(document).ready(function(){
	$("#delete").click(function(event){		
		var doDelete = confirm("are you sure to delete this account ?")
		if(doDelete == false){
			event.preventDefault();	
		}	
	});
});
</script>




<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/static/css/main.css" />
</head>
<body>
	<h4>Create a new account from here.</h4>

	<sf:form method="post"
		action="${pageContext.request.contextPath}/docreate"
		commandName="account">

		<table>
			<sf:input type="hidden" path="actid" name="actid" />
			<tr>
				<td>Acount Type:</td>
				<td><input name="acttype" type="radio" value="checking" checked />Checking</td>
				<td><input name="acttype" type="radio" value="saving" />Saving</td>
			</tr>
			<tr>
				<td>Balance:</td>
				<td><input name="balance" type="text" value="0.00"></td>
			</tr>
			<tr>
				<td>Interest Rate:</td>
				<td><sf:input path="inrate" name="inrate" type="text" value="0.000" />
					<br />
				<sf:errors path="inrate" cssClass="error" />
			</tr>
	<tr> <td><input type="submit" value="Edit this accout"></td>	</tr>


<c:if test="${account.actid!= 0}">	

	<tr> <td> <span style="color:blue; font-size:14pt">&nbsp &nbsp &nbsp&nbsp OR</span> </td>	</tr>
	
	<tr> <td><input class="delete" id="delete" type="submit" name="delete" value="Delete this account"></td>	</tr>
	
</c:if>	

		</table>

	</sf:form>

</body>
</html>