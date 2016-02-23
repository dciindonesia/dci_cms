package org.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="COUNTRY")

public class Countries implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1046959066355216773L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "COUNTRY_ID", updatable=false, nullable=false)
	private int countryId;
	@Column(name = "COUNTRY_CODE")
	private String countryCode;
	@Column(name = "COUNTRY_ISO")
	private String countryIso;
	private String tld;
	@Column(name = "COUNTRY_NAME")
	private String	countryName;
	
	/**
	 * @return the country_id
	 */
	public int getCountryId() {
		return countryId;
	}
	/**
	 * @param country_id the country_id to set
	 */
	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}
	/**
	 * @return the country_code
	 */
	public String getCountryCode() {
		return countryCode;
	}
	/**
	 * @param country_code the country_code to set
	 */
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	/**
	 * @return the countryIso
	 */
	public String getCountryIso() {
		return countryIso;
	}
	/**
	 * @param countryIso the countryIso to set
	 */
	public void setCountryIso(String countryIso) {
		this.countryIso = countryIso;
	}
	/**
	 * @return the tld
	 */
	public String getTld() {
		return tld;
	}
	/**
	 * @param tld the tld to set
	 */
	public void setTld(String tld) {
		this.tld = tld;
	}
	/**
	 * @return the country_name
	 */
	public String getCountryName() {
		return countryName;
	}
	/**
	 * @param country_name the country_name to set
	 */
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	
	
}
