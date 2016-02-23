package org.spring.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.spring.dao.ContactPersonDao;
import org.spring.model.ContactPerson;
import org.spring.model.ContactPersonDto;
import org.spring.model.FilesClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

public class FilesSave{
	protected static Logger logger = Logger.getLogger(FilesSave.class);
	
	@Autowired
	ContactPersonDao contactPersonDao;
	
	private UtilsExtension utilsExt;
	
	private String 	fileName;
	private FilesClass filesClass;
	
	public FilesSave(String fileName, FilesClass filesClass){
		this.fileName = fileName;
		this.filesClass = filesClass;
	}
	
	public boolean isImage() throws IllegalStateException, IOException {
		boolean accepted = false;
		File convFile = new File( filesClass.getCompanyLogo().getOriginalFilename());
		filesClass.getCompanyLogo().transferTo(convFile);
		if (utilsExt.acceptImage((File) filesClass.getCompanyLogo())) {
			accepted = true;
		}
		
		return accepted;
	}
	
	public void iterateContactPerson() throws IOException {
		List<MultipartFile> parts = filesClass.getContactImg();
		List<ContactPersonDto> cpDtoList = null;
		if(null != parts && parts.size() > 0) {
			for (MultipartFile files : parts) {
				
			}	
				
				/*
			    for (String contactNames: filesClass.getContactName()) {
			    	for (String contactEmails: filesClass.getContactName()) {
			    		byte[] bytes = null;
						try {
							bytes = files.getBytes();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		            	String nameImage = files.getOriginalFilename();
		            	String extFile = nameImage.substring(nameImage.lastIndexOf("."), nameImage.length());
		            	String rootPath = System.getProperty("catalina.home");
		            	File dir = new File(rootPath);
		            	File serverFile = new File( dir.getAbsoluteFile()
		            			+ File.separator + files.getOriginalFilename() + extFile);
		            	if (! serverFile.exists()) {
			                BufferedOutputStream stream = new BufferedOutputStream(
			                        new FileOutputStream(serverFile));
			                stream.write(bytes);
			                stream.close();
			            }
		            	System.out.println(contactNames + " " + contactEmails + " " + files.getOriginalFilename());
			    		//ContactPerson contactPerson = new ContactPerson(contactNames, contactEmails, files.getOriginalFilename(), filesClass.getCompanyId());
			    		//contactPersonDao.persist(contactPerson);
			    	}
			    } 	
			} 	*/
	    }
	    
	}
	
	
	public String saveFile() {
		logger.info(filesClass.getCompanyLogo());
		if (!filesClass.getCompanyLogo().isEmpty()) {
            try {
            	logger.info("get in to getFiles");
            	byte[] bytes = filesClass.getCompanyLogo().getBytes();
            	String nameImage = filesClass.getCompanyLogo().getOriginalFilename();
            	String extFile = nameImage.substring(nameImage.lastIndexOf("."), nameImage.length());
             // Creating the directory to store file
                String rootPath = System.getProperty("catalina.home");
            	//String rootPath = System.getProperty("usr.home");
            	//String rootPath = getClass().getClassLoader().getResource("").getPath();
                
                File dir = new File(rootPath);
                
                //String f = new File (dir.getParent()).getParent();
                File serverFile = new File( dir.getAbsoluteFile() 
                		//f + File.separator + "resources" + File.separator + "img"
                		+ File.separator + fileName + extFile);
                //logger.info(serverFile + " " + FilesClass.getFile().getName());
                System.out.println(serverFile + " " + fileName + extFile);
                
                if (! serverFile.exists()) {
	                BufferedOutputStream stream = new BufferedOutputStream(
	                        new FileOutputStream(serverFile));
	                stream.write(bytes);
	                stream.close();
	            }
                
                /*
        	    byte[] bytes = fileInput.getBytes(); 

                //bytes to string conversion
                fileToStr = new String(bytes, "UTF-8");
                System.out.println(fileToStr);                    
                String name=fileInput.getOriginalFilename(); 

                String ext=name.substring(name.lastIndexOf("."),name.length()); 
                fileName=""+System.currentTimeMillis()+ext; 


                String rpath=request.getRealPath("/"); //path forstoring the file
                System.out.println(rpath); 
                File file=new File(rpath,"csv"); 
                if(!file.exists()){ 
                                file.mkdirs(); 
                } 

                File temp=new File(file,fileName); 
                System.out.println("Path : "+temp); 

                FileOutputStream fos= new FileOutputStream(temp); 
                fos.write(bytes); 
                fos.close(); 
        	    */
 				
                logger.info("Server File Location="
                        + serverFile.getAbsolutePath());
                this.iterateContactPerson();
                return "You successfully uploaded file=" + filesClass.getCompanyLogo().getOriginalFilename();
            } catch (Exception e) {
            	logger.info("You failed to upload " + filesClass.getCompanyLogo().getOriginalFilename() + " => " + e.getMessage());
                return "You failed to upload " + filesClass.getCompanyLogo().getOriginalFilename()+ " => " + e.getMessage();
            }
        } else {
        	logger.info("You failed to upload " + filesClass.getCompanyLogo().getOriginalFilename() + " because the file was empty.");
            return "You failed to upload " + filesClass.getCompanyLogo().getOriginalFilename()
                    + " because the file was empty.";
        }
	}
	



	/**
	 * @return the fileName
	 */
	public String getFileName() {
		return fileName;
	}


	/**
	 * @param fileName the fileName to set
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/**
	 * @return the FilesClass
	 */
	public FilesClass getFilesClass() {
		return filesClass;
	}

	/**
	 * @param FilesClass the FilesClass to set
	 */
	public void setFilesClass(FilesClass filesClass) {
		this.filesClass = filesClass;
	}


}
