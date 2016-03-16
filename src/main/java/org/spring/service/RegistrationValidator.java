package org.spring.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.spring.model.Registration;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
@Component
public class RegistrationValidator implements Validator{
	private Pattern pattern; 
	private Matcher matcher; 
	
	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"  
			   + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";  
    String ID_PATTERN = "[0-9]+";  
	String STRING_PATTERN = "[a-zA-Z]+";  
	String MOBILE_PATTERN = "[0-9]{10}";
	
	@Override
	public boolean supports(@SuppressWarnings("rawtypes") Class clazz) {
		return Registration.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Registration registration = (Registration) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "company","required.company", "Company is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title","required.title", "Title is required.");
		
		
		
		
		// phone number validation  
		if (!(registration.getPhone() != null && registration.getPhone().isEmpty())) {  
			pattern = Pattern.compile(MOBILE_PATTERN);  
			matcher = pattern.matcher(registration.getPhone());  
			if (!matcher.matches()) {  
				errors.rejectValue("phone", "phone.incorrect",  
				      "Enter a correct phone number");  
			}  
		} else {
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phone","required.phone", "Phone is required.");
		}
		
		// email validation in spring  
		if (!(registration.getEmail() != null && registration.getEmail().isEmpty())) {  
			   pattern = Pattern.compile(EMAIL_PATTERN);  
			   matcher = pattern.matcher(registration.getEmail());  
			   if (!matcher.matches()) {  
			    errors.rejectValue("email", "email.incorrect",  
			      "Enter a correct email");  
			   }  
		} else {
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email","required.email", "Email is required.");
		}
		
		if ((!(registration.getFirstName() != null && registration.getFirstName().isEmpty()))) {
			pattern = Pattern.compile(STRING_PATTERN);  
			matcher = pattern.matcher(registration.getFirstName());
			if (!matcher.matches()) {  
				errors.rejectValue("firstName", "name.containNonChar",  
			      "Enter a valid name");
			}  
		}  else {
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName","required.firstName", "First Name is required.");
		}
		// input string conatains characters only  
		if ((!((registration.getLastName() != null) && registration.getLastName().isEmpty()))) {  
			pattern = Pattern.compile(STRING_PATTERN);  
			matcher = pattern.matcher(registration.getLastName());
			if (!matcher.matches()) {
				errors.rejectValue("lastName", "name.containNonChar",  
					      "Enter a valid name"); 
			}  
		}  else {
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName","required.lastName", "Last Name is required.");
		}
		
		// it doesn't need validation. message.properties handle typeMismatch.org.spring.model....
		/*
		if (registration.getCountry() == null || registration.getIndustry() == null) {	
			errors.rejectValue("country","typeMismatch.org.spring.model.Countries");
		} else {
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "country","typeMismatch.org.spring.model.Countries", "Country is required.");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "industry","typeMismatch.org.spring.model.Industry", "Industry is required.");
		}
		*/
		if (! registration.getPassword().equals(registration.getConfirmPassword())) {
			errors.rejectValue("password","different.password", "Password does not match");
			errors.rejectValue("confirmPassword","different.password", "Password does not match");
		} else {
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password","required.password", "Password is required.");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword","required.confirmPassword", "Confirm Password is required.");
		}
		
		/*
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id", "required.id",  
			"Id is required.");  
				  
		// input string conatains numeric values only  
		if (student.getId() != null) {  
			pattern = Pattern.compile(ID_PATTERN);  
			matcher = pattern.matcher(student.getId().toString());  
			if (!matcher.matches()) {  
				errors.rejectValue("id", "id.incorrect",  
					"Enter a numeric value");  
			}  
				  
			// input string can not exceed that a limit  
			if (student.getId().toString().length() > 5) {  
				errors.rejectValue("id", "id.exceed",  
				      "Id should not contain more than 5 digits");  
			}  
		}
		*/
		
	}

	
	
}
