/**
 * 
 */
package org.spring.model;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author rahadhitya
 *
 */
public class ContactPersonDto {
	private int contactId;
	private String contactName;
	private String contactLastName;
	private String contactPosition;
	private String contactEmail;
	private MultipartFile contactImg;
	private String contactFoto;
	private Company company;
	
	
	
	public int getContactId() {
		return contactId;
	}
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
	
	public String getContactLastName() {
		return contactLastName;
	}
	
	public void setContactLastName(String contactLastName) {
		this.contactLastName = contactLastName;
	}
	
	public String getContactPosition() {
		return contactPosition;
	}
	
	public void setContactPosition(String contactPosition) {
		this.contactPosition = contactPosition;
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
	public MultipartFile getContactImg() {
		return contactImg;
	}
	/**
	 * @param contactImg the contactImg to set
	 */
	public void setContactImg(MultipartFile contactImg) {
		this.contactImg = contactImg;
	}
	public String getContactFoto() {
		return contactFoto;
	}
	public void setContactFoto(String contactFoto) {
		this.contactFoto = contactFoto;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
}
