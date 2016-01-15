<%@ include  file="/WEB-INF/includes/taglibs.jsp" %>
<h1>Admin Page</h1>
<%
scid=(String)session.getAttribute("scid");
%>
<div id="welcome">
<h2><span>Welcome:::<strong><font color='Red'><%= scid %></font></strong></span></h2> 
<h3>Welcome ${username}</h3>
</div>
<section>
<p>Only Administrator have access to this page.</p>
<p>Curabitur quis libero elit, dapibus iaculis nisl. Nullam quis velit eget odio 
adipiscing tristique non sed ligula. In auctor diam eget nisl condimentum laoreet..
</p>
<table id="table">
	<thead>
		<th>ID</th>
		<th>NAME</th>
		<th>USERNAME</th>
		<th>PASSWORD</th>
		<th>EMAIL</th>
		<th>LOCKED</th>
	</thead>
	<tbody>
		<c:forEach items="${userItems}" var="users">			
			<tr>
				<td><c:out value="${users.userId}" /></td>
				<td><c:out value="${users.name}" /></td>
				<td><c:out value="${users.userName}" /></td>
				<td><c:out value="${users.password}" /></td>
				<td><c:out value="${users.email}" /></td>
				<td><c:out value="${users.locked}" /></td>
			</tr>
		</c:forEach>
	</tbody>
	<tfoot>
		<th>Please used it carefully</th>
	</tfoot>
</table>
</section>