package org.spring.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="REGISTRATION")
public class Registration implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long registrationId;
	private String title;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	private String password;
	private String confirmPassword;
	@ManyToOne
	@JoinColumn(name ="countryId")
	private Countries country;
	private String company;
	@ManyToOne
	@JoinColumn(name ="industryId")
	private Industry industry;

	public Registration(){}
	
	public Registration(String title, String firstName, String lastName, String email, String phone, String password, Countries country, String company)
	{
	this.title = title;
	this.firstName = firstName;
	this.lastName = lastName;
	this.email = email;
	this.phone = phone;
	this.password = password;
	this.country = country;
	this.company = company;
	}
	
	public Long getRegistrationId()
	{
	return this.registrationId;
	}
	
	public void setRegistrationId(Long registrationId)
	{
	this.registrationId = registrationId;
	}
	
	public String getTitle()
	{
	return this.title;
	}
	
	public void setTitle(String title)
	{
	this.title = title;
	}
	
	public String getFirstName()
	{
	return this.firstName;
	}
	
	public void setFirstName(String firstName)
	{
	this.firstName = firstName;
	}
	
	public String getLastName()
	{
	return this.lastName;
	}
	
	public void setLastName(String lastName)
	{
	this.lastName = lastName;
	}
	
	public String getEmail()
	{
	return this.email;
	}
	
	public void setEmail(String email)
	{
	this.email = email;
	}
	
	public String getPhone()
	{
	return this.phone;
	}
	
	public void setPhone(String phone)
	{
	this.phone = phone;
	}
	
	public String getPassword()
	{
	return this.password;
	}
	
	public void setPassword(String password)
	{
	this.password = password;
	}
	
	public String getConfirmPassword()
	{
	return this.confirmPassword;
	}
	
	public void setConfirmPassword(String confirmPassword)
	{
	this.confirmPassword = confirmPassword;
	}
	
	public Countries getCountry()
	{
	return this.country;
	}
	
	public void setCountry(Countries country)
	{
	this.country = country;
	}
	
	public String getCompany()
	{
	return this.company;
	}
	
	public void setCompany(String company)
	{
	this.company = company;
	}
	
	public Industry getIndustry()
	{
	return this.industry;
	}
	
	public void setIndustry(Industry industry)
	{
	this.industry = industry;
	}
}
