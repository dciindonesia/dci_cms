/**
 * 
 */
package org.spring.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author rahadhitya
 *
 */
@Entity
@Table(name="CONTACTPERSON")
public class ContactPerson implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int contactId;
	private String contactName;
	private String contactEmail;
	private String contactImg;
//	@ManyToOne
//	@JoinColumn(name = "company")
	@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="companyId", nullable=false)
	private Company company;
	
	
	public ContactPerson(){}
	
	public ContactPerson (String contactName, String contactEmail, String contactImg, Company company) {
		this.contactName = contactName;
		this.contactEmail = contactEmail;
		this.contactImg = contactImg;
		this.company = company;
	}
	
	/**
	 * @return the contactId
	 */
	public int getContactId() {
		return contactId;
	}
	/**
	 * @param contactId the contactId to set
	 */
	public void setContactId(int contactId) {
		this.contactId = contactId;
	}
	/**
	 * @return the contactName
	 */
	public String getContactName() {
		return contactName;
	}
	/**
	 * @param contactName the contactName to set
	 */
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	/**
	 * @return the contactEmail
	 */
	public String getContactEmail() {
		return contactEmail;
	}
	/**
	 * @param contactEmail the contactEmail to set
	 */
	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}
	/**
	 * @return the contactImg
	 */
	public String getContactImg() {
		return contactImg;
	}
	/**
	 * @param contactImg the contactImg to set
	 */
	public void setContactImg(String contactImg) {
		this.contactImg = contactImg;
	}
//	@ManyToOne(cascade = {CascadeType.ALL},fetch= FetchType.EAGER)
//	@JoinColumn(name = "companyId", referencedColumnName = "companyId")
	
	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

}
