package org.spring.model;

import java.util.List;

import javax.persistence.Transient;

import org.spring.dao.CompanyDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

public class FilesClass {
	private int companyId;
	private String companyName;
	private String companyDesc;
	private MultipartFile companyLogo;
	private List<ContactPerson> contactList;	
	private List<String> contactName;
	private List<String> contactEmail;
	private List<MultipartFile> contactImg;
	
	@Autowired
	CompanyDao	companyDao;
	
	/**
	 * @return the companyId
	 */
	public Company getCompanyId() {
		return (Company) companyDao.findById(companyId);
	}
	/**
	 * @param companyId the companyId to set
	 */
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	public String getCompanyName() {
		return companyName;
	}
	/**
	 * @param companyName the companyName to set
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	/**
	 * @return the companyDesc
	 */
	public String getCompanyDesc() {
		return companyDesc;
	}
	/**
	 * @param companyDesc the companyDesc to set
	 */
	public void setCompanyDesc(String companyDesc) {
		this.companyDesc = companyDesc;
	}
	/**
	 * @return the companyLogo
	 */
	public MultipartFile getCompanyLogo() {
		return companyLogo;
	}
	/**
	 * @param companyLogo the companyLogo to set
	 */
	public void setCompanyLogo(MultipartFile companyLogo) {
		this.companyLogo = companyLogo;
	}
	/**
	 * @return the contactList
	 */
	public List<ContactPerson> getContactList() {
		return contactList;
	}
	/**
	 * @param contactList the contactList to set
	 */
	public void setContactList(List<ContactPerson> contactList) {
		this.contactList = contactList;
	}
	/**
	 * @return the contactName
	 */
	public List<String> getContactName() {
		return contactName;
	}
	/**
	 * @param contactName the contactName to set
	 */
	public void setContactName(List<String> contactName) {
		this.contactName = contactName;
	}
	/**
	 * @return the contactEmail
	 */
	public List<String> getContactEmail() {
		return contactEmail;
	}
	/**
	 * @param contactEmail the contactEmail to set
	 */
	public void setContactEmail(List<String> contactEmail) {
		this.contactEmail = contactEmail;
	}
	/**
	 * @return the contactImg
	 */
	public List<MultipartFile> getContactImg() {
		return contactImg;
	}
	/**
	 * @param contactImg the contactImg to set
	 */
	public void setContactImg(List<MultipartFile> contactImg) {
		this.contactImg = contactImg;
	}
	
}
