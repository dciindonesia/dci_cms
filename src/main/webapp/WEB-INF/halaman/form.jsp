<%@include file="/WEB-INF/includes/taglibs.jsp" %>
<html>

<body style="background-color:#F3F3F3;">
<div class="container" style="margin-top:40px;">
	<div class="jumbotron" style="height: 500px; background-color:#FFF;">
	<h3>Please provide your information in the form below to get an access to DCI Marketplace. Once your request is approved, you will get a confirmation email containing your account details</h3>
<form:form action="form" method="POST" commandName="registration" style="padding-top:40px;">
<div class="col-lg-4">
	<form:label path="title"></form:label>
    <form:input path="title" name="title" class="input-text-cust form-control" 
                        	placeholder="Title"  />
    <form:errors path="title" cssClass="error" />
    
    <form:label path="firstName"></form:label>
    <form:input path="firstName" name="firstName" class="input-text-cust form-control" 
                        	placeholder="First Name" />
    <form:errors path="firstName" cssClass="error" />
    
    <form:label path="lastName"></form:label>
    <form:input path="lastName" name="lastName" class="input-text-cust form-control" 
                        	placeholder="Last Name" />
    <form:errors path="lastName" cssClass="error" />
    
    <form:label path="email"></form:label>
    <form:input path="email" name="email" class="input-text-cust form-control" 
                        	placeholder="Email" />
    <form:errors path="email" cssClass="error" />
    
    <form:label path="phone"></form:label>
    <form:input path="phone" name="phone" class="input-text-cust form-control"
                        	placeholder="Phone" />
    <form:errors path="phone" cssClass="error" />
    
    <form:label path="password"></form:label>
    <form:password path="password" name="password" class="input-text-cust form-control" 
                        	placeholder="Password" />
    <form:errors path="password" cssClass="error" />
    
    <form:label path="confirmPassword"></form:label>
    <form:password path="confirmPassword" name="confirmPassword" class="input-text-cust form-control" 
                        	placeholder="Confirm your password" />
    <form:errors path="confirmPassword" cssClass="error" />
</div>

<div class="col-lg-4">
	<form:label path="country"></form:label>
    <form:select path="country" name="country" class="input-text-cust form-control" 
                        	placeholder="Country">
		<form:option value="">Select Country..</form:option>
		<form:options items="${countryList}" itemValue="countryId" itemLabel="countryName" />
	</form:select>
	
    <form:errors path="country" cssClass="error" />
    
    <form:label path="company"></form:label>
    <form:input path="company" name="company" class="input-text-cust form-control" 
                        	placeholder="Company" />
    <form:errors path="company" cssClass="error" />
    
    <form:label path="industry"></form:label>
    <form:select path="industry" name="industry" class="input-text-cust form-control" 
                        	placeholder="Industry">
		<form:option value="">Select Industry..</form:option>
		<form:options items="${industryList}" itemValue="industryId" itemLabel="industryName" />
	</form:select>	                  
    <form:errors path="industry" cssClass="error" />
    
    <br>
    
    <button type="submit" class="btn btn-primary btn-lg btn-block">JOIN NOW</button>
    <div class="col-lg-12">
    	<div class="col-lg-offset-8 col-lg-4"><p style="font-size:14px;">or <a href='#'>Cancel</a></p></div>
    </div>
    <input type="checkbox" name="terms" value="agree"> I agree to the <a href='#'>Terms & Conditions</a> and <a href='#'>Privacy Policy</a><br>
</div>

</form:form>
<div class="col-lg-4">
	<div class="well">
		<p style="font-size:16px;">1. Complete the provided form</p>
		<p style="font-size:16px;">2. Click JOIN NOW button to request an access</p>		
		<p style="font-size:16px;">3. Wait for our approval (Less than 24 hours)</p>
		<p style="font-size:16px;">4. You will get a confirmation email along with the link to complete your registration</p>
	</div>
</div>
</div>
</div>
</body>
</html>