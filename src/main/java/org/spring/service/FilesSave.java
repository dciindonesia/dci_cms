package org.spring.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.spring.dao.CompanyDao;
import org.spring.dao.ContactPersonDao;
import org.spring.dao.IndustryDao;
import org.spring.model.Company;
import org.spring.model.CompanyDto;
import org.spring.model.ContactPerson;
import org.spring.model.ContactPersonDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.AutoPopulatingList;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FilesSave{
	protected static Logger logger = Logger.getLogger(FilesSave.class);
	
	@Autowired
	CompanyDao			companyDao;
	@Autowired
	ContactPersonDao 	contactPersonDao;
	@Autowired
	IndustryDao 		industryDao;
	
	private UtilsExtension 			utilsExt;
	private String 					fileName;
	private String 					fileNameFull;
	private String 					filePath;
	private CompanyDto 				companyDtoLocal;
	private Company					company;
	private ContactPerson			contact;
	private ContactPersonDto		contactDtoLocal;
	private int 					counter;
	
	public FilesSave(){}
	
	public FilesSave(String filePath){
		this.filePath = filePath;
	}
	
	public FilesSave (Company company) {
		this.company = company;
	}
	
	public FilesSave (CompanyDto companyDtoLocal, String filePath) {
		this.companyDtoLocal 	= companyDtoLocal;
		this.filePath 		= filePath;
	}
	
	public FilesSave (Company company, CompanyDto companyDtoLocal, String filePath) {
		this.company		= company;
		this.companyDtoLocal 	= companyDtoLocal;
		this.filePath 		= filePath;
	}
	
	public FilesSave(String fileName, CompanyDto companyDtoLocal, String fileNameFull, Company company){
		this.fileName 		= fileName;
		this.companyDtoLocal 	= companyDtoLocal;
		this.fileNameFull 	= fileNameFull;
		this.company		= company;
	}
	
	public boolean isImage() throws IllegalStateException, IOException {
		boolean accepted = false;
		File convFile = new File( companyDtoLocal.getCompanyLogo().getOriginalFilename());
		companyDtoLocal.getCompanyLogo().transferTo(convFile);
		if (utilsExt.acceptImage((File) companyDtoLocal.getCompanyLogo())) {
			accepted = true;
		}
		return accepted;
	}
	
	public void newContactPerson() throws IOException {
		Long companyId = company.getCompanyId();
//		int counter = 1;
		
		for (ContactPersonDto cpDto : companyDtoLocal.getContactList()) {
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
			    if (serverFile.exists()) { serverFile.delete(); }
			    	BufferedOutputStream stream = new BufferedOutputStream(
			    			new FileOutputStream(serverFile));
			    	stream.write(bytes);
				    stream.close();
				
//			    System.out.println("Path= " + serverFile.getAbsolutePath());
//			    System.out.println(cpDto.getContactName() + " " + cpDto.getContactEmail() + " " + cpDto.getContactImg().getOriginalFilename());
				ContactPerson contactPerson = new ContactPerson(cpDto.getContactName(), cpDto.getContactLastName(), cpDto.getContactPosition(), cpDto.getContactEmail(), parts.getOriginalFilename(), company);
				contactPersonDao.persist(contactPerson, company.getCompanyId());
				counter++;
			} catch (IOException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
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
            	byte[] bytes = companyDtoLocal.getCompanyLogo().getBytes();
//            	String nameImage = companyDto.getCompanyLogo().getOriginalFilename();
//            	String extFile = nameImage.substring(nameImage.lastIndexOf("."), nameImage.length());
	             if (! serverFile.exists()) {
		                BufferedOutputStream stream = new BufferedOutputStream(
		                        new FileOutputStream(serverFile));
		                stream.write(bytes);
		                stream.close();
		         }
	             logger.info("Server File Location=" + serverFile.getAbsolutePath());
	             return "You successfully display image=" + companyDtoLocal.getCompanyLogo().getOriginalFilename();
            } catch (Exception e) {
            	logger.info("You failed to display image " + companyDtoLocal.getCompanyLogo().getOriginalFilename() + " => " + e.getMessage());
                return "You failed to upload " + companyDtoLocal.getCompanyLogo().getOriginalFilename()+ " => " + e.getMessage();
            }
        } else {
        	logger.info("You failed to upload " + companyDtoLocal.getCompanyLogo().getOriginalFilename() + " because the file was empty.");
            return "You failed to upload " + companyDtoLocal.getCompanyLogo().getOriginalFilename()
                    + " because the file was empty.";
        }
	}
	
	@SuppressWarnings("unused")
	public void getFiles(MultipartFile files, String filePath) {
		String imageName = null;
		try {
            byte[] bytes = files.getBytes();	
//            String rootPath = System.getProperty("catalina.home");
            File dir = new File(filePath); // rootPath
            File serverFile = new File( dir.getAbsoluteFile()
                		+ File.separator + this.fileName);
            if (serverFile.exists()) { serverFile.delete(); }
            BufferedOutputStream stream = new BufferedOutputStream(
	                	new FileOutputStream(serverFile));
	        stream.write(bytes);
	        stream.close();
        } catch (Exception e) {
        	logger.debug(e.getMessage());
        }
	}
	
	public Company saveCompany (CompanyDto companyDto, String filePath) {
		Company companyBuffer = null;
		
		if (companyDto.getCompanyId() == null || companyDto.getCompanyId() < 0 ) {
			companyBuffer = new Company();
			
		} else {
			companyBuffer = companyDao.findById(companyDto.getCompanyId());
		}
		this.company = companyBuffer;
		company.setCompanyName(companyDto.getCompanyName() == null ? companyBuffer.getCompanyName() : companyDto.getCompanyName());
		company.setCompanyDesc(companyDto.getCompanyDesc() == null ? companyBuffer.getCompanyDesc() : companyDto.getCompanyDesc());
		company.setCompanySize(companyDto.getCompanySize() == null ? companyBuffer.getCompanySize() : companyDto.getCompanySize());
		company.setCompanyFollower(companyDto.getCompanyFollower() < 1 ? companyBuffer.getCompanyFollower() : companyDto.getCompanyFollower());
		company.setCompanyHQ(companyDto.getCompanyHQ() == null ? companyBuffer.getCompanyHQ() : companyDto.getCompanyHQ());
		company.setCompanyService(companyDto.getCompanyService() == null ? companyBuffer.getCompanyService() : companyDto.getCompanyService());
		company.setIndustry(companyDto.getIndustry() == null ? companyBuffer.getIndustry() : industryDao.findById(Integer.parseInt(companyDto.getIndustry())));
		
		if (companyDto.getCompanyLogo() == null) {
			company.setCompanyLogo(company.getCompanyLogo());
		} else {
			String nameImage = companyDto.getCompanyLogo().getOriginalFilename();
			String extFile = nameImage.substring(nameImage.lastIndexOf("."), nameImage.length());
			this.fileName = "Company-" + companyDto.getCompanyId() + extFile;
			this.getFiles(companyDto.getCompanyLogo(), filePath);
			company.setCompanyLogo(this.fileName);
		}
		
		return company;
	}
	
	public ContactPerson saveContactPerson (List<ContactPersonDto> contactListDto, Company company, Long compId) {
		//TODO : please add Method!!
		return new ContactPerson();
	}
	
	public ContactPerson saveContactPerson (ContactPersonDto contactPersonDto, Long compId, String filePath) {
		List<ContactPerson> contactList = contactPersonDao.getAllContactPerson(compId);
		Company company = companyDao.findById(compId);
		boolean isNew = false;
		
		if (contactPersonDto.getContactId() == 0) {
			this.contact = new ContactPerson();
			isNew = true;
			counter = contactList.size() + 1;
		} else {
			this.contact = contactPersonDao.findById(contactPersonDto.getContactId());
			isNew = false;
		}
		this.contact.setContactName(contactPersonDto.getContactName() == null ? this.contact.getContactName(): contactPersonDto.getContactName());
		this.contact.setContactLastName(contactPersonDto.getContactLastName() == null ? this.contact.getContactLastName() : contactPersonDto.getContactLastName());
		this.contact.setContactPosition(contactPersonDto.getContactPosition() == null ? this.contact.getContactPosition() : contactPersonDto.getContactPosition());
		this.contact.setContactEmail(contactPersonDto.getContactEmail() == null ? this.contact.getContactEmail() : contactPersonDto.getContactEmail());
		if ((contactPersonDto.getContactImg().isEmpty())) {
			contact.setContactImg(this.contact.getContactImg());
		} else {
			String cpImage = contactPersonDto.getContactImg().getOriginalFilename();
			String cpExtFile = cpImage.substring(cpImage.lastIndexOf("."), cpImage.length());
			if (isNew == true){
				this.fileName = "Contact-" + compId + counter + cpExtFile;
			} else {
				this.fileName = "Contact-" + compId + contactPersonDto.getContactId() + cpExtFile;
			}
			this.getFiles(contactPersonDto.getContactImg(), filePath);
			contact.setContactImg(this.fileName);
		}
		this.contact.setCompany(company);
		return this.contact;
	}
		
	public List<ContactPerson> saveContactPersonList (List<ContactPersonDto> contactListDto, Long compId, String filePath) {
		List<ContactPerson> contactList = new ArrayList<ContactPerson>();
		for (ContactPersonDto contactDto : contactListDto) {
			contactList.add(this.saveContactPerson(contactDto, compId, filePath));
		}
		return contactList;
	}
	
	public List<ContactPersonDto> setContactPersonDto (Long companyId) {
		List<ContactPerson> contactList = contactPersonDao.getAllContactPerson(companyId);
		List<ContactPersonDto> contactDtoList = new AutoPopulatingList<ContactPersonDto>(ContactPersonDto.class);
		for (ContactPerson cpo : contactList) {
			this.contactDtoLocal = new ContactPersonDto();
			this.contactDtoLocal.setContactId(cpo.getContactId());
			this.contactDtoLocal.setContactName(cpo.getContactName());
			this.contactDtoLocal.setContactEmail(cpo.getContactEmail());
			String pathContactFoto = "resources" + File.separator + "img" + File.separator; 
			this.contactDtoLocal.setContactFoto(pathContactFoto + cpo.getContactImg());
			this.contactDtoLocal.setCompany(this.company);
			contactDtoList.add(this.contactDtoLocal);
		}
		return contactDtoList;
	}
	
	public String saveFile() {
		if (!companyDtoLocal.getCompanyLogo().isEmpty()) {
            try {
            	byte[] bytes = companyDtoLocal.getCompanyLogo().getBytes();
            	String nameImage = companyDtoLocal.getCompanyLogo().getOriginalFilename();
            	String extFile = nameImage.substring(nameImage.lastIndexOf("."), nameImage.length());
                //String rootPath = System.getProperty("catalina.home");
                String rootPath= this.fileNameFull;
            	//String rootPath = System.getProperty("usr.home");
            	//String rootPath = getClass().getClassLoader().getResource("").getPath();
                File dir = new File(rootPath);
                //String f = new File (dir.getParent()).getParent();
                File serverFile = new File( dir.getAbsoluteFile() 
                		//f + File.separator + "resources" + File.separator + "img"
                		+ File.separator + fileName ); //+ extFile
                if (serverFile.exists()) { serverFile.delete(); }
	                BufferedOutputStream stream = new BufferedOutputStream(
	                        new FileOutputStream(serverFile));
	                stream.write(bytes);
	                stream.close();
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
                return serverFile.getAbsolutePath();
            } catch (Exception e) {
            	System.out.println("You failed to upload " + companyDtoLocal.getCompanyLogo().getOriginalFilename()+ " => " + e.getMessage());
                 return ""; 
            }
        } else {
        	System.out.println("because the file was empty " + companyDtoLocal.getCompanyLogo().getOriginalFilename());
        	return "";
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
	public CompanyDto getCompanyDtoLocal() {
		return companyDtoLocal;
	}

	/**
	 * @param FilesClass the FilesClass to set
	 */
	public void setCompanyDtoLocal(CompanyDto companyDtoLocal) {
		this.companyDtoLocal = companyDtoLocal;
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

	public ContactPerson getContact() {
		return contact;
	}

	public void setContact(ContactPerson contact) {
		this.contact = contact;
	}

	public ContactPersonDto getContactDtoLocal() {
		return contactDtoLocal;
	}

	public void setContactDtoLocal(ContactPersonDto contactDtoLocal) {
		this.contactDtoLocal = contactDtoLocal;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}


}
