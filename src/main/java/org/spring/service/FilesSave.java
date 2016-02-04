package org.spring.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.log4j.Logger;
import org.spring.model.FilesClass;
import org.springframework.stereotype.Service;

public class FilesSave{
	protected static Logger logger = Logger.getLogger(FilesSave.class);
	
	private UtilsExtension utilsExt;
	
	private String 	fileName;
	private FilesClass filesClass;
	
	public FilesSave(String fileName, FilesClass filesClass){
		this.fileName = fileName;
		this.filesClass = filesClass;
	}
	
	public boolean isImage() throws IllegalStateException, IOException {
		boolean accepted = false;
		File convFile = new File( filesClass.getFile().getOriginalFilename());
		filesClass.getFile().transferTo(convFile);
		if (utilsExt.acceptImage((File) filesClass.getFile())) {
			accepted = true;
		}
		
		return accepted;
	}
	
	
	public String saveFile() {
		logger.info(filesClass.getCompanyName());
		if (!filesClass.getFile().isEmpty()) {
            try {
            	logger.info("get in to getFiles");
            	byte[] bytes = filesClass.getFile().getBytes();
            	String nameImage = filesClass.getFile().getOriginalFilename();
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
                //logger.info(serverFile + " " + filesClass.getFile().getName());
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
 
                return "You successfully uploaded file=" + filesClass.getCompanyName();
            } catch (Exception e) {
            	logger.info("You failed to upload " + filesClass.getCompanyName() + " => " + e.getMessage());
                return "You failed to upload " + filesClass.getCompanyName() + " => " + e.getMessage();
            }
        } else {
        	logger.info("You failed to upload " + filesClass.getCompanyName() + " because the file was empty.");
            return "You failed to upload " + filesClass.getCompanyName()
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
	 * @return the filesClass
	 */
	public FilesClass getFilesClass() {
		return filesClass;
	}

	/**
	 * @param filesClass the filesClass to set
	 */
	public void setFilesClass(FilesClass filesClass) {
		this.filesClass = filesClass;
	}


}
