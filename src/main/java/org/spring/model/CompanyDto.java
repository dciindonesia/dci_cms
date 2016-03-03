package org.spring.model;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;
import javax.persistence.Transient;

public class CompanyDto {
	private Long companyId;
	private String companyName;
	private String companyDesc;
	private String companyImage;
	private MultipartFile companyLogo;
	private List<ContactPersonDto> contactList = new ArrayList<ContactPersonDto>(0);
	
	
	public CompanyDto(){}
	
	public Long getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}
	public String getCompanyImage() {
		return companyImage;
	}
	public void setCompanyImage(String companyImage) {
		this.companyImage = companyImage;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCompanyDesc() {
		return companyDesc;
	}
	public void setCompanyDesc(String companyDesc) {
		this.companyDesc = companyDesc;
	}
	public MultipartFile getCompanyLogo() {
		return companyLogo;
	}
	public void setCompanyLogo(MultipartFile companyLogo) {
		this.companyLogo = companyLogo;
	}
	public List<ContactPersonDto> getContactList() {
		return contactList;
	}
	public void setContactList(List<ContactPersonDto> contactList) {
		this.contactList = contactList;
	}
	
	
}
