/**
 * 
 */
package org.spring.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
	public ContactPerson(){}
	
	public ContactPerson (String contactName, String contactEmail, String contactImg) {
		this.contactName = contactName;
		this.contactEmail = contactEmail;
		this.contactImg = contactImg;
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

}
