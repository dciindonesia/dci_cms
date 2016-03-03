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
import org.spring.model.Company;
import org.spring.model.CompanyDto;
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
	
	private String 		fileName;
	private String 		fileNameFull;
	private CompanyDto 	filesClass;
	private Company		company;
	
	public FilesSave(String fileName, CompanyDto filesClass, String fileNameFull, Company company){
		this.fileName 		= fileName;
		this.filesClass 	= filesClass;
		this.fileNameFull 	= fileNameFull;
		this.company		= company;
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
		System.out.println("into contact person");
		Long companyId = company.getCompanyId();
		int counter = 1;
		
		for (ContactPersonDto cpDto : filesClass.getContactList()) {
			System.out.println("loop contact person");
			MultipartFile parts = cpDto.getContactImg();
			
			try {
				byte[] bytes = parts.getBytes();
				String nameImage = parts.getOriginalFilename();
				String extFile = nameImage.substring(nameImage.lastIndexOf("."), nameImage.length());
			    //String rootPath = System.getProperty("catalina.home");
				String imageName = "Contactperson-" + companyId + counter + extFile;
			    String rootPath= this.fileNameFull;
				File dir = new File(rootPath);
			    File serverFile = new File( dir.getAbsoluteFile()
			    		+ File.separator + imageName);
			    if (! serverFile.exists()) {
			    	BufferedOutputStream stream = new BufferedOutputStream(
			    			new FileOutputStream(serverFile));
			    	stream.write(bytes);
				    stream.close();
				}
			    System.out.println("Path= " + serverFile.getAbsolutePath());
			    System.out.println(cpDto.getContactName() + " " + cpDto.getContactEmail() + " " + cpDto.getContactImg().getOriginalFilename());
				ContactPerson contactPerson = new ContactPerson(cpDto.getContactName(), cpDto.getContactEmail(), parts.getOriginalFilename(), company);
				contactPersonDao.persist(contactPerson);
				counter++;
			} catch (IOException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
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
                //String rootPath = System.getProperty("catalina.home");
                String rootPath= this.fileNameFull;
            	//String rootPath = System.getProperty("usr.home");
            	//String rootPath = getClass().getClassLoader().getResource("").getPath();
                
                File dir = new File(rootPath);
                
                //String f = new File (dir.getParent()).getParent();
                File serverFile = new File( dir.getAbsoluteFile() 
                		//f + File.separator + "resources" + File.separator + "img"
                		+ File.separator + fileName ); //+ extFile
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
                //this.iterateContactPerson();
                return serverFile.getAbsolutePath();
            } catch (Exception e) {
            	System.out.println("You failed to upload " + filesClass.getCompanyLogo().getOriginalFilename()+ " => " + e.getMessage());
                 return ""; 
            }
        } else {
        	System.out.println("because the file was empty " + filesClass.getCompanyLogo().getOriginalFilename());
        	return "";
        }
	}
	
	public String uploadImage(String paths) {
		logger.info("get " + paths);
		if (!paths.isEmpty()) {
            try {
            	logger.info("get in to getFiles");
                String rootPath = System.getProperty("catalina.home");
            	File dir = new File(rootPath);
            	File serverFile = new File( dir.getAbsoluteFile() 
            			+ File.separator + paths);
                System.out.println(serverFile + " " + fileName + paths);
            	
            	
            	
            	byte[] bytes = filesClass.getCompanyLogo().getBytes();
            	String nameImage = filesClass.getCompanyLogo().getOriginalFilename();
            	String extFile = nameImage.substring(nameImage.lastIndexOf("."), nameImage.length());
             
                
                if (! serverFile.exists()) {
	                BufferedOutputStream stream = new BufferedOutputStream(
	                        new FileOutputStream(serverFile));
	                stream.write(bytes);
	                stream.close();
	            }
                
                
 				
                logger.info("Server File Location="
                        + serverFile.getAbsolutePath());
                
                return "You successfully display image=" + filesClass.getCompanyLogo().getOriginalFilename();
            } catch (Exception e) {
            	logger.info("You failed to display image " + filesClass.getCompanyLogo().getOriginalFilename() + " => " + e.getMessage());
                return "You failed to upload " + filesClass.getCompanyLogo().getOriginalFilename()+ " => " + e.getMessage();
            }
        } else {
        	logger.info("You failed to upload " + filesClass.getCompanyLogo().getOriginalFilename() + " because the file was empty.");
            return "You failed to upload " + filesClass.getCompanyLogo().getOriginalFilename()
                    + " because the file was empty.";
        }
	}
	
	public String getFiles(MultipartFile files) {
		logger.info(files.getOriginalFilename());
		if (!files.isEmpty()) {
            try {
            	logger.info("get in to getFiles");
            	byte[] bytes = files.getBytes();
            	String nameImage = files.getOriginalFilename();
            	String extFile = nameImage.substring(nameImage.lastIndexOf("."), nameImage.length());
             // Creating the directory to store file
                String rootPath = System.getProperty("catalina.home");
                
                File dir = new File(rootPath);
                
                File serverFile = new File( dir.getAbsoluteFile()
                		+ File.separator + fileName + extFile);                
                System.out.println(serverFile + " " + fileName + extFile);
                
                if (! serverFile.exists()) {
	                BufferedOutputStream stream = new BufferedOutputStream(
	                        new FileOutputStream(serverFile));
	                stream.write(bytes);
	                stream.close();
	            }
               
                logger.info("Server File Location="
                        + serverFile.getAbsolutePath());
                this.iterateContactPerson();
                return "You successfully uploaded file=" + files.getOriginalFilename();
            } catch (Exception e) {
            	logger.info("You failed to upload " + files.getOriginalFilename() + " => " + e.getMessage());
                return "You failed to upload " + files.getOriginalFilename()+ " => " + e.getMessage();
            }
        } else {
        	logger.info("You failed to upload " + files.getOriginalFilename() + " because the file was empty.");
            return "You failed to upload " + files.getOriginalFilename()
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
	public CompanyDto getFilesClass() {
		return filesClass;
	}

	/**
	 * @param FilesClass the FilesClass to set
	 */
	public void setFilesClass(CompanyDto filesClass) {
		this.filesClass = filesClass;
	}

	/**
	 * @return the fileNameFull
	 */
	public String getFileNameFull() {
		return fileNameFull;
	}

	/**
	 * @param fileNameFull the fileNameFull to set
	 */
	public void setFileNameFull(String fileNameFull) {
		this.fileNameFull = fileNameFull;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}


}
