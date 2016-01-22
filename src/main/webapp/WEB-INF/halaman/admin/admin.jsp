<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<html>
<body>
	<h3>Welcome : ${username}</h3>
	<h1>Message ${message}</h1>
	
	<hr />
	<h3><spring:message code="form.admin"/></h3>
    <button type="submit" class="btn btn-small btn-success" onclick="location.href='listuser'">Edit User</button>
    <button type="submit" class="btn btn-small btn-success" onclick="location.href='user'">User page</button>
	

	<a href="<c:url value="/j_spring_security_logout" />" ><button class="btn btn-small btn-success">Logout</button></a>
</body>
</html>