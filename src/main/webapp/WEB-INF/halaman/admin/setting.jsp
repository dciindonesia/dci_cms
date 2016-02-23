<%@include file="/WEB-INF/includes/taglibs.jsp" %>

<form:form action="setting" method="POST" commandName="filess" enctype="multipart/form-data">
	
	<div class="inline">
		<form:label path="companyLogo">Insert Logo Company</form:label>
		<!--  <input type="file" path="file" id="imgInp" name="logoImg" class="btn btn-info"/> -->
		<form:input path="companyLogo" type="file" name="logoImg" class="imgInp" />
		<img id="imgResult" src="#" width="100px" height="100px" alt="" />
		<form:errors path="companyLogo" cssClass="error" />
	</div>
	
	<br>
	
	<form:label path="companyName">Your Company Name</form:label>
    <form:input path="companyName" name="companyName" class="input-text-cust form-control" 
     placeholder="Company Name" />
    <form:errors path="companyName" cssClass="error" />
    <br>
    
	<form:label path="companyDesc">Your Company Description</form:label>
	<form:textarea path="companyDesc" id="editor" placeholder="Enter text ..." style="width: 810px; height: 200px"></form:textarea>
    <form:errors path="companyDesc" cssClass="error" />
    <br>
    
    <div id='TextBoxesGroup'>
		<div id="TextBoxDiv1">
			<form:label path="contactImg">Contact Person 1</form:label>
			<form:input path="contactImg" type="file" name="contactImg" id="imgInp" />
			<img id="imgResult" src="#" width="100px" height="100px" alt="" />
			<form:errors path="contactImg" cssClass="error" />
			
			<form:label path="contactName">Name :</form:label>
		    <form:input path="contactName" name="contactName" class="input-text-cust form-control" 
		     	placeholder="Conract Name" />
		    <form:errors path="contactName" cssClass="error" />
		</div>
		<br><br>
	</div>
	
    <input type='button' value='Add Contact Person' id='addButton'> &nbsp;&nbsp;
	<input type='button' value='Remove Contact Person' id='removeButton'>
    <br>
    <button type="submit" class="btn btn-primary btn-lg">SUBMIT</button>
</form:form>