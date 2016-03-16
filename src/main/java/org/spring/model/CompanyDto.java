package org.spring.model;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;

public class CompanyDto {
	private Long companyId;
	private String companyName;
	private String companyDesc;
	private String companyImage;
	private MultipartFile companyLogo;
	private String companySize;
	private int companyFollower;
	private String companyHQ;
	private String companyService;
	private String industry;
	private List<ContactPersonDto> contactList = new ArrayList<ContactPersonDto>(0);
	private List<Users> userList = new ArrayList<Users>(0);
	
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
	public String getCompanySize() {
		return companySize;
	}

	public void setCompanySize(String companySize) {
		this.companySize = companySize;
	}

	public int getCompanyFollower() {
		return companyFollower;
	}

	public void setCompanyFollower(int companyFollower) {
		this.companyFollower = companyFollower;
	}

	public String getCompanyHQ() {
		return companyHQ;
	}

	public void setCompanyHQ(String companyHQ) {
		this.companyHQ = companyHQ;
	}
	public String getCompanyService() {
		return companyService;
	}

	public void setCompanyService(String companyService) {
		this.companyService = companyService;
	}

	public List<ContactPersonDto> getContactList() {
		return contactList;
	}
	public void setContactList(List<ContactPersonDto> contactList) {
		this.contactList = contactList;
	}
	
	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public List<Users> getUserList() {
		return userList;
	}

	public void setUserList(List<Users> userList) {
		this.userList = userList;
	}
	
}
