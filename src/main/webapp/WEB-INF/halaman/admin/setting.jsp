<%@include file="/WEB-INF/includes/taglibs.jsp" %>

<form:form action="setting" method="POST" commandName="filess" enctype="multipart/form-data">
	
	<div class="inline">
		Choose Logo Company
		<!--  <input type="file" path="file" id="imgInp" name="logoImg" class="btn btn-info"/> -->
		<form:input path="file" type="file" name="file" />
		<img id="imgResult" src="#" width="100px" height="100px" alt="Logo Company" />
		<form:errors path="file" cssClass="error" />
	</div>
	
	<form:label path="companyName"></form:label>
    <form:input path="companyName" name="companyName" class="input-text-cust form-control" 
     placeholder="Company Name" />
    <form:errors path="companyName" cssClass="error" />
    
    <button type="submit" class="btn btn-primary btn-lg btn-block">SUBMIT</button>
</form:form>

<script type="text/javascript">
$(document).ready(function(){
	$('#imgInp').on('change', function() {
    	readPath(this);
    });
});

function readPath(input) {
	if (input.files && input.files[0]) {
    	var reader = new FileReader();
    	
        reader.onload = function (e) {
        	$('#imgResult').attr('src', e.target.result);
        }
        reader.readAsDataURL(input.files[0]);
	}
}
</script>