<%@ include  file="/WEB-INF/includes/taglibs.jsp" %>
<div class="page-header">
	<h3>${username}</h3>
</div>
<p>User Security has access to this page.</p>
<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam ac velit et ante 
laoreet eleifend. Donec vitae augue nec sem condimentum varius.</p>
<hr />

<form:form action="../main/editUser" method="POST" commandName="usersDao">

 <div class="hero-unit">
 	<form:hidden path="id" />
 	<form:label path="username">User Name</form:label>
    <form:input path="username" name="username"/>
    <form:errors path="username" cssClass="error" />
    
    <form:label path="password">Password</form:label>
    <form:input path="password" name="password"/>
    <form:errors path="password" cssClass="error" />
    
    <form:label path="name">Name Alias</form:label>
    <form:input path="name" name="name"/>
    <form:errors path="name" cssClass="error" />
    
    <form:label path="email">Email</form:label>
    <form:input path="email" name="email"/>
    <form:errors path="email" cssClass="error" />
    
    <form:label path="locked">enabled</form:label>
    <form:input path="locked" name="locked"/>
    <form:errors path="locked" cssClass="error" />
    <br/>
		<form:checkboxes path="roles" items="${roleList}" itemValue="roleId" itemLabel="roleName" />
 </div>
<hr />
			
	<input type="submit" value="Submit" />

</form:form>

<script type="text/javascript">

function reply_click(clicked_id) {
	var chk = "c" + clicked_id
    alert(chk);
    document.getElementById(clicked_id).setAttribute("disabled", "disabled")
    document.getElementById(chk).setAttribute("checked", "checked")
}

function toggleCheckBoxes() {
	var searchIDs = $('input:checked').map(function(){
		return $(this).val();
	});
	console.log(searchIDs.get());
};

$(document).ready(function () {
	/*
	$('button').click(function(){
		$('button').attr("disabled", true);
		
	});
	*/
});
	</script>
</body>
</html>