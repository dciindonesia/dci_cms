/*     */ package org.spring.model;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.GeneratedValue;
/*     */ import javax.persistence.GenerationType;
/*     */ import javax.persistence.Id;
/*     */ import javax.persistence.Table;
/*     */ 
/*     */ @Entity
/*     */ @Table(name="REGISTRATION")
/*     */ public class Registration
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */ 
/*     */   @Id
/*     */   @GeneratedValue(strategy=GenerationType.IDENTITY)
/*     */   private Long registrationId;
/*     */   private String title;
/*     */   private String firstName;
/*     */   private String lastName;
/*     */   private String email;
/*     */   private String phone;
/*     */   private String password;
/*     */   private String confirmPassword;
/*     */   private String country;
/*     */   private String company;
/*     */   private String industry;
/*     */ 
/*     */   public Registration()
/*     */   {
/*     */   }
/*     */ 
/*     */   public Registration(String title, String firstName, String lastName, String email, String phone, String password, String country, String company)
/*     */   {
/*  37 */     this.title = title;
/*  38 */     this.firstName = firstName;
/*  39 */     this.lastName = lastName;
/*  40 */     this.email = email;
/*  41 */     this.phone = phone;
/*  42 */     this.password = password;
/*  43 */     this.country = country;
/*  44 */     this.company = company;
/*     */   }
/*     */ 
/*     */   public Long getRegistrationId()
/*     */   {
/*  51 */     return this.registrationId;
/*     */   }
/*     */ 
/*     */   public void setRegistrationId(Long registrationId)
/*     */   {
/*  57 */     this.registrationId = registrationId;
/*     */   }
/*     */ 
/*     */   public String getTitle()
/*     */   {
/*  63 */     return this.title;
/*     */   }
/*     */ 
/*     */   public void setTitle(String title)
/*     */   {
/*  69 */     this.title = title;
/*     */   }
/*     */ 
/*     */   public String getFirstName()
/*     */   {
/*  75 */     return this.firstName;
/*     */   }
/*     */ 
/*     */   public void setFirstName(String firstName)
/*     */   {
/*  81 */     this.firstName = firstName;
/*     */   }
/*     */ 
/*     */   public String getLastName()
/*     */   {
/*  87 */     return this.lastName;
/*     */   }
/*     */ 
/*     */   public void setLastName(String lastName)
/*     */   {
/*  93 */     this.lastName = lastName;
/*     */   }
/*     */ 
/*     */   public String getEmail()
/*     */   {
/*  99 */     return this.email;
/*     */   }
/*     */ 
/*     */   public void setEmail(String email)
/*     */   {
/* 105 */     this.email = email;
/*     */   }
/*     */ 
/*     */   public String getPhone()
/*     */   {
/* 111 */     return this.phone;
/*     */   }
/*     */ 
/*     */   public void setPhone(String phone)
/*     */   {
/* 117 */     this.phone = phone;
/*     */   }
/*     */ 
/*     */   public String getPassword()
/*     */   {
/* 123 */     return this.password;
/*     */   }
/*     */ 
/*     */   public void setPassword(String password)
/*     */   {
/* 129 */     this.password = password;
/*     */   }
/*     */ 
/*     */   public String getConfirmPassword()
/*     */   {
/* 135 */     return this.confirmPassword;
/*     */   }
/*     */ 
/*     */   public void setConfirmPassword(String confirmPassword)
/*     */   {
/* 142 */     this.confirmPassword = confirmPassword;
/*     */   }
/*     */ 
/*     */   public String getCountry()
/*     */   {
/* 149 */     return this.country;
/*     */   }
/*     */ 
/*     */   public void setCountry(String country)
/*     */   {
/* 155 */     this.country = country;
/*     */   }
/*     */ 
/*     */   public String getCompany()
/*     */   {
/* 161 */     return this.company;
/*     */   }
/*     */ 
/*     */   public void setCompany(String company)
/*     */   {
/* 167 */     this.company = company;
/*     */   }
/*     */ 
/*     */   public String getIndustry()
/*     */   {
/* 173 */     return this.industry;
/*     */   }
/*     */ 
/*     */   public void setIndustry(String industry)
/*     */   {
/* 179 */     this.industry = industry;
/*     */   }
/*     */ }

/* Location:           /Users/rahadhitya/Downloads/DCI/WEB-INF/classes/
 * Qualified Name:     org.spring.model.Registration
 * JD-Core Version:    0.6.2
 */