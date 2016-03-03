/**
 * 
 */
package org.spring.model;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author rahadhitya
 *
 */
public class ImageClass {
	private int	uid;
	private MultipartFile files;

	
	/**
	 * @return the uid
	 */
	public int getUid() {
		return uid;
	}

	/**
	 * @param uid the uid to set
	 */
	public void setUid(int uid) {
		this.uid = uid;
	}

	/**
	 * @return the files
	 */
	public MultipartFile getFiles() {
		return files;
	}

	/**
	 * @param files the files to set
	 */
	public void setFiles(MultipartFile files) {
		this.files = files;
	}
}
