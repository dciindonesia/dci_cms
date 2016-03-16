/**
 * 
 */
package org.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author rahadhitya
 *
 */
@Entity
@Table(name="INDUSTRY")
public class Industry implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "industry_id", updatable=false, nullable=false)
	private int industryId;
	@Column(name = "industry_name")
	private String industryName;
	
	/**
	 * @return the industryId
	 */
	public int getIndustryId() {
		return industryId;
	}
	/**
	 * @param industryId the industryId to set
	 */
	public void setIndustryId(int industryId) {
		this.industryId = industryId;
	}
	/**
	 * @return the industryname
	 */
	public String getIndustryName() {
		return industryName;
	}
	/**
	 * @param industryname the industryname to set
	 */
	public void setIndustryName(String industryName) {
		this.industryName = industryName;
	}

}
