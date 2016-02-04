package org.spring.model;

import java.io.File;

import org.springframework.web.multipart.MultipartFile;

public class FilesClass {
	private String companyName;
	private MultipartFile file;
	
	public String getCompanyName() {
		return companyName;
	}
	/**
	 * @param companyName the companyName to set
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	public MultipartFile getFile() {
        return file;
    }
 
    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
