<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Person Information</title>
</head>
<body>
	<h1><spring:message code="app.admin"/></h1>
	
	<table class="table">
		<thead style="background:#fcf">
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Password</th>
				<th>#</th>
			</tr>
			<tr>
				<th colspan="4">...</th>
		    </tr>
		</thead>
		<tbody>
			<c:forEach items="${userret}" var="person">
				<tr>
					<td><c:out value="${person.email}" /></td>
					<td><c:out value="${person.email}" /></td>
					<td><c:out value="${person.email}" /></td>
					
					<td><a href="edit?id=${person.userId}">Edit</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<c:if test="${empty userret}">
		There are currently no users in the list.
	</c:if>
	
	<button type="submit" onclick="location.href='admin'">Admin</button>
	<button type="submit" onclick="location.href='user'">User</button>
	
	<a href="<c:url value="/j_spring_security_logout" />" >Logout</a>

</body>
</html>