<%@include file="/WEB-INF/includes/taglibs.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
	$(document).ready(function(){

        // Start indexing at the size of the current list
        var index = 0; 
        //${fn:length(filess.contactList)};
        var msg = "";
        
        // Add a new Employee
        $("#add").click(function () {
            $(this).before(function() {
            	
                var html = '<div id="contactList' + index + '.wrapper">';                    
                html += '<input type="file" id="contactList' + index + '.contactImg" name="contactList[' + index + '].contactImg" value="" />';
                html += '<input type="text" id="contactList' + index + '.contactName" name="contactList[' + index + '].contactName" value="" class="input-text-cust form-control" placeholder="Contact Name" />';
                html += '<input type="text" id="contactList' + index + '.contactEmail" name="contactList[' + index + '].contactEmail" value="" class="input-text-cust form-control" placeholder="Contact Email" />';
                html += '<a href="#" id="remove" data-index="' + index + '">remove</a>';
                html += '</div>';
                return html;
            });
            $("#contactList" + index + "\\.wrapper").show();
            index++;
            return false;
        });
        

        // Remove an Employee .frameworks\\.remove
        $(document).on('click', 'a#remove', function() {
            var index2remove = $(this).data("index");
            msg = "Field Address number: " + index2remove + " was removed";
            $("#contactList" + index2remove + "\\.wrapper").hide();
            $("#contactList" + index2remove + "\\.remove").val("1");
            alert(msg);
            return false;
        });
        
    });
    </script>	
</head>
<body>

<form:form action="settingTmp" method="POST" commandName="filess" enctype="multipart/form-data">
	
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
    
    <form:label path="companySize">Your Company Size</form:label>
    <form:input path="companySize" name="companySize" class="input-text-cust form-control" 
     placeholder="Company Size" />
    <form:errors path="companySize" cssClass="error" />
    <br>
    
    <form:label path="companyFollower">Your Company Follower</form:label>
    <form:input path="companyFollower" name="companyFollower" class="input-text-cust form-control" 
     placeholder="Company Follower" />
    <form:errors path="companyFollower" cssClass="error" />
    <br>
    
    <form:label path="companyHQ">Your Company Headquarter</form:label>
    <form:input path="companyHQ" name="companyHQ" class="input-text-cust form-control" 
     placeholder="Company Headquarter.." />
    <form:errors path="companyHQ" cssClass="error" />
    <br>
    
    <form:label path="industry"></form:label>
    <form:select path="industry" name="industry" class="input-text-cust form-control" 
                        	placeholder="Industry">
		<form:option value="">Select Industry..</form:option>
		<form:options items="${industryList}" itemValue="industryId" itemLabel="industryName" />
	</form:select>	                  
    <form:errors path="industry" class="label label-danger" />
    <br>
    
    <div id='TextBoxesGroup'>
	<c:forEach items="${filess.contactList}" varStatus="loop">
	<!-- Add a wrapping div -->
    <c:choose>
    	<c:when test="${filess.contactList[loop.index].remove eq 1}">
        	<div id="TextBoxDiv${loop.index}" class="hidden">
        </c:when>
	    <c:otherwise>
	    	<div id="TextBoxDiv${loop.index}">
		</c:otherwise>
    </c:choose>
    
   

	<!-- Generate the fields -->
	<form:label path="contactList[${loop.index}].contactImg">Contact Person 1</form:label>
	<form:input path="contactList[${loop.index}].contactImg" type="file" name="contactList[${loop.index}].contactImg" id="imgInp" />
	<img id="imgResult" src="#" width="100px" height="100px" alt="" />
	<form:errors path="contactList[${loop.index}].contactImg" cssClass="error" />
						
	<form:label path="contactList[${loop.index}].contactName">Name :</form:label>
	<form:input path="contactList[${loop.index}].contactName" name="contactList[${loop.index}]contactName" class="input-text-cust form-control" 
		placeholder="Contact Name" />
	<form:errors path="contactList[${loop.index}].contactName" cssClass="error" />
					    
	<form:label path="contactList[${loop.index}].contactEmail">Name :</form:label>
	<form:input path="contactList[${loop.index}].contactEmail" name="contactList[${loop.index}].contactEmail" class="input-text-cust form-control" 
		placeholder="Contact Email" />
	<form:errors path="contactList[${loop.index}].contactEmail" cssClass="error" />
						
    <!-- Add the remove flag -->
    <c:choose>
    	<c:when test="${contactList[loop.index].remove eq 1}">
        	<c:set var="hiddenValue" value="1" />
        </c:when>
	    <c:otherwise>
	    	<c:set var="hiddenValue" value="0" />
	    </c:otherwise>
    </c:choose>

    <form:hidden path="contactList[${loop.index}].remove" value="${hiddenValue}" />
    <!-- Add a link to remove the Frameworks -->
    <a href="#" id="remove" data-index="${loop.index}">Remove</a>
                        
    	</div>
	<br><br>
    </c:forEach>
    </div>
	<button id="add" type="button">Add Contact Person</button>
    
    <br>
    <button type="submit" class="btn btn-primary btn-lg">SUBMIT</button>
</form:form>
</body>
</html>