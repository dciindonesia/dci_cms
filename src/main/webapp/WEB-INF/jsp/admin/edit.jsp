<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<style type="text/css">
		.hidden {
			display: none;
		}
	</style>
</head>
<body>
	<div class="page-header">
		<h3>${username}</h3>
	</div>
<p>User Security has access to this page.</p>
<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam ac velit et ante 
laoreet eleifend. Donec vitae augue nec sem condimentum varius.</p>
<hr />

<form:form action="edit" method="POST" commandName="usersDTO">

 <div class="hero-unit">
 	<form:hidden path="users.uid" />
 	<form:label path="users.firstName">First Name</form:label>
    <form:input path="users.firstName" name="firstName"/>
    <form:errors path="users.firstName" cssClass="error" />
    
    <form:label path="users.lastName">Last Name</form:label>
    <form:input path="users.lastName" name="lastName"/>
    <form:errors path="users.lastName" cssClass="error" />
    
    <form:label path="users.password">password</form:label>
    <form:password path="users.password" name="password"/>
    <form:errors path="users.password" cssClass="error" />
    
    <form:label path="users.address1">address1</form:label>
    <form:input path="users.address1" name="address1"/>
    <form:errors path="users.address1" cssClass="error" />
    
    <form:label path="users.address2">address2</form:label>
    <form:input path="users.address2" name="address2"/>
    <form:errors path="users.address2" cssClass="error" />
    
    <form:label path="users.enabled">Active?</form:label>
    <form:checkbox path="users.enabled" name="enabled"/>
    <form:errors path="users.enabled" cssClass="error" />
    
    <form:label path="users.email">email</form:label>
    <form:input path="users.email" name="email"/>
    <form:errors path="users.email" cssClass="error" />
    
    <form:label path="users.phone">phone</form:label>
    <form:input path="users.phone" name="phone"/>
    <form:errors path="users.phone" cssClass="error" />
    
    <form:label path="users.city">city</form:label>
    <form:input path="users.city" name="city"/>
    <form:errors path="users.city" cssClass="error" />
    
    <form:label path="users.postCode">postCode</form:label>
    <form:input path="users.postCode" name="postCode"/>
    <form:errors path="users.postCode" cssClass="error" />
    <br/>
		<form:checkboxes path="usergroups" items="${roleList}" itemValue="groupid" itemLabel="groupName" />
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