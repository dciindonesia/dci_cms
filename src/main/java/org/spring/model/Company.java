package org.spring.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="COMPANY")
public class Company implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long companyId;
	private String companyName;
	private String logoImg;
	
	/**
	 * @return the companyId
	 */
	
	public Company() {}
	
	public Company (String companyName, String logoImg) {
		this.companyName = companyName;
		this.logoImg = logoImg;
	}
	public Long getCompanyId() {
		return companyId;
	}
	/**
	 * @param companyId the companyId to set
	 */
	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}
	/**
	 * @return the companyName
	 */
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
	 * @return the logoImg
	 */
	public String getLogoImg() {
		return logoImg;
	}
	/**
	 * @param logoImg the logoImg to set
	 */
	public void setLogoImg(String logoImg) {
		this.logoImg = logoImg;
	}
	
}
