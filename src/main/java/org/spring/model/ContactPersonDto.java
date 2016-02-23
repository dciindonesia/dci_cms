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
	private String contactName;
	private String contactEmail;
	private MultipartFile contactImg;
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
	public MultipartFile getContactImg() {
		return contactImg;
	}
	/**
	 * @param contactImg the contactImg to set
	 */
	public void setContactImg(MultipartFile contactImg) {
		this.contactImg = contactImg;
	}
}
