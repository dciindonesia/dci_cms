package org.spring.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.spring.dao.CompanyDao;
import org.spring.dao.ContactPersonDao;
import org.spring.dao.CountryDao;
import org.spring.dao.IndustryDao;
import org.spring.dao.RegistrationDao;
import org.spring.dao.RoleDao;
import org.spring.dao.UsersDao;
import org.spring.model.Company;
import org.spring.model.CompanyDto;
import org.spring.model.ContactPerson;
import org.spring.model.ContactPersonDto;
import org.spring.model.Countries;
import org.spring.model.Industry;
import org.spring.model.Registration;
import org.spring.model.Role;
import org.spring.model.Users;
import org.spring.model.UsersDTO;
import org.spring.service.FilesSave;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.AutoPopulatingList;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

@Controller
public class BasicController
{
  protected static Logger logger = Logger.getLogger("controller");

  @Autowired
  UsersDao usersDao;

  @Autowired
  RoleDao roleDao;

  @Autowired
  RegistrationDao registrationDao;
  
  @Autowired
  CompanyDao companyDao;
  
  @Autowired
  CountryDao countryDao;
  
  @Autowired
  IndustryDao industryDao;
  
  @Autowired
  ContactPersonDao contactPersonDao;
  
  private FilesSave filesSave;
  /*
  @ModelAttribute("countries")
	public List<Country> setCountry() {
		return countryDao.getAllCountry();
	}
*/
  @ModelAttribute("roleList")
  public List<Role> setRoles() { List<Role> roleLists = this.roleDao.getAllRoles();
    return roleLists;
  }

  @RequestMapping({"/admin"})
  public String getAdminPage(Locale locale, HttpServletRequest request, Model model, Principal principal)
  {
    logger.info("Welcome home! the client locale is " + locale.toString());

    model.addAttribute("message", "Spring Security Hello World");
    String name = principal.getName();
    logger.info(name);
    model.addAttribute("username", name);
    model.addAttribute("message", "Spring Security Custom Form example");

    Object principals = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

    HttpSession session = request.getSession(true);

    session.setAttribute("userDetails", principals);

    return "adminpage";
  }

  @RequestMapping({"/listuser"})
  public String getListUser(Locale locale, Model model, Principal principal) {
    logger.info("list of USer");
    List<Users> users = this.usersDao.getAllUser();
    String name = principal.getName();
    model.addAttribute("username", name);
    model.addAttribute("userinv", new Users());
    model.addAttribute("userret", users);
    return "listuserpage";
  }
  
  
  
  @RequestMapping(value={"/editCP"}, method={RequestMethod.GET})
  public String getEditCP(@RequestParam("companyId") Long companyId, Principal principal, HttpServletRequest request, Model model) {
    logger.info("Enter Edit Contact Person Page");
    String name = principal.getName();
    Users users = usersDao.findByName(name);
    model.addAttribute("username", users.getName());
    model.addAttribute("companyId", companyId);
    Company company = companyDao.findById(companyId);
    String logoimg = company.getCompanyLogo();
    File logoPath = new File( File.separator + "DCI" + File.separator + "resources" + File.separator + "img" + File.separator + logoimg);
    model.addAttribute("logoPath", logoPath);
    
    
    model.addAttribute("editImage", new String());
    return "editCPPage";
  }
  
  @RequestMapping(value={"/editCPs"}, method={RequestMethod.GET})
  public String setEditCP(@RequestParam("companyId") Long companyId, HttpServletRequest request, Principal principal, Model model) {
    logger.info("Leave Edit Contact Person Page");
    String name = principal.getName();
    Users users = usersDao.findByName(name);
    model.addAttribute("username", users.getName());
    Company companies = companyDao.findById(companyId);
    MultipartRequest multipartRequest = (MultipartRequest) request;
    MultipartFile imgCp = multipartRequest.getFile("getImg");
    //MultipartFile imgCp = null; //request.getParameter("getImg");
    String nameImage = imgCp.getOriginalFilename();
	String extFile = nameImage.substring(nameImage.lastIndexOf("."), nameImage.length());
	String imageName = "Company-" + companyId + extFile;
	companies.setCompanyLogo(imageName);
	companyDao.update(companies);
    File fileSave = new File( request.getRealPath("/") + File.separator + "resources" + File.separator + "img" );
    try {
		byte[] bytes = imgCp.getBytes();
	    String rootPath = fileSave.getAbsolutePath();
		File dir = new File(rootPath);
	    File serverFile = new File( dir.getAbsoluteFile()
	    		+ File.separator + imageName);
	    if (serverFile.exists()) {serverFile.delete();}
	    BufferedOutputStream stream = new BufferedOutputStream(
	    		new FileOutputStream(serverFile));
	    stream.write(bytes);
		stream.close();
	} catch (IOException e) {
		e.printStackTrace();
	}
    
    return "redirect:/custCommon";
  }
  
  @RequestMapping(value={"/setting"}, method={RequestMethod.GET})
  public String getSettingPage(Principal principal, Model model) {
    logger.info("Enter Setting Page");
    String name = principal.getName();
    Users users = usersDao.findByName(name);
    model.addAttribute("username", users.getName());
    CompanyDto companyDto = new CompanyDto();
    List<ContactPersonDto> contactsList = new AutoPopulatingList<ContactPersonDto>(ContactPersonDto.class);
    companyDto.setContactList(contactsList);
    model.addAttribute("filess",companyDto);
    return "settingPage";
  }
  
  @SuppressWarnings("deprecation")
  @RequestMapping(value={"/setting"}, method={RequestMethod.POST})
  public String setSettingPage(@ModelAttribute("filess") CompanyDto filesDto, BindingResult result, HttpServletRequest request, SessionStatus status, Principal principal, Model model) {
	  logger.info("Leave Setting Page");
	  for (ContactPersonDto	cp : filesDto.getContactList()) {
		  System.out.println(cp.getContactName());
	  }
		  
	    String name = principal.getName();
	    Users users = usersDao.findByName(name);
	    model.addAttribute("username", users.getName());
	    
	    Company companies = new Company(filesDto.getCompanyName(), filesDto.getCompanyDesc());
	    String nameImage = filesDto.getCompanyLogo().getOriginalFilename();
    	String extFile = nameImage.substring(nameImage.lastIndexOf("."), nameImage.length());
    	Long companyIds = companyDao.persist(companies);
    	String imageName = "Company-" + companyIds + extFile;
	    File fileSave = new File( request.getRealPath("/") + File.separator + "resources" + File.separator + "img" );
    	filesSave = new FilesSave(imageName, filesDto, fileSave.getAbsolutePath() , companies);
    	filesSave.saveFile();
    	
    	//int counter = 1;
    	for (ContactPersonDto cpDto : filesDto.getContactList()) {
			System.out.println("loop contact person");
			MultipartFile parts = cpDto.getContactImg();
			
			try {
				byte[] bytes = parts.getBytes();
				//String cpImage = parts.getOriginalFilename();
				//String cpExtFile = cpImage.substring(cpImage.lastIndexOf("."), cpImage.length());
			    //String rootPath = System.getProperty("catalina.home");
				//String cpImageName = "Contactperson-" + companyIds + counter + extFile;
			    String rootPath = fileSave.getAbsolutePath();
				File dir = new File(rootPath);
			    File serverFile = new File( dir.getAbsoluteFile()
			    		+ File.separator + imageName);
			    if (serverFile.exists()) {serverFile.delete();}
			    BufferedOutputStream stream = new BufferedOutputStream(
			    		new FileOutputStream(serverFile));
			    stream.write(bytes);
				stream.close();
				
			    System.out.println("Path= " + serverFile.getAbsolutePath());
			    System.out.println(cpDto.getContactName() + " " + cpDto.getContactEmail() + " " + cpDto.getContactImg().getOriginalFilename());
				ContactPerson contactPerson = new ContactPerson(cpDto.getContactName(), cpDto.getContactEmail(), parts.getOriginalFilename());
				contactPersonDao.persist(contactPerson, companies.getCompanyId());
				//counter++;
			} catch (IOException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}
    	
    	
    	companies.setCompanyLogo(imageName);
		companyDao.update(companies);
		
	  return "redirect:/customerList";
  }
  
  @RequestMapping(value={"/forget"}, method={RequestMethod.GET})
  public String getForgetPage(Principal principal, Model model) {
    logger.info("Enter Setting Page");
    model.addAttribute("forgetMethod", new String());
    model.addAttribute("sendPass", new String());
    return "forgetPage";
  }
  
  @RequestMapping(value={"/forget"}, method={RequestMethod.POST})
  public String setForgetPage( BindingResult result, Principal principal, Model model) throws IOException {
	  //@RequestParam("forgetMethod") String forgetParam,
	  logger.info("Leave Setting Page");
	  /*
	  Users users = usersDao.findByName(forgetParam);
	  if (users != null ) {
		  //TODO : proses Email..
		  return "registration-successPage";
	  } else {
		  model.addAttribute("message", "Users doesn't exist");
		  return "redirect:/forgetPage";
	  }
	  */
	  return "registration-successPage";
  }

  @RequestMapping(value={"/edit"}, method={RequestMethod.GET})
  public String getEditPage(@RequestParam("id") String uid, HttpServletRequest request, HttpServletResponse response, ModelMap model, Principal principal)
  {
    logger.debug("Received request to show common page");
    String name = principal.getName();
    model.addAttribute("username", name);

    Users users = this.usersDao.findById(uid);
    List<Role> groupList = this.roleDao.findByUsers(users.getUsername());

    UsersDTO usersDTO = new UsersDTO();
    usersDTO.setUsers(users);
    usersDTO.setRoles(groupList);

    model.addAttribute("usersDTO", usersDTO);

    return "editpage";
  }

  @SuppressWarnings({ "rawtypes", "unchecked" })
@RequestMapping(value={"/edit"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public String setEdit(@ModelAttribute("usersDTO") UsersDTO usersDTO, BindingResult result, HttpServletRequest request, SessionStatus status, Principal principal, Model model)
  {
    logger.debug("POST edit");

    String name = principal.getName();
    model.addAttribute("username", name);
    String[] userGrpArray = request.getParameterValues("usergroups");
    List<Role> grpList = new ArrayList();
    for (String str : userGrpArray) {
      Role usrGroup = this.roleDao.findById(str);
      grpList.add(usrGroup);
    }
    Users user = usersDTO.getUsers();
    user.setRoles(new HashSet(grpList));
    this.usersDao.update(user);
    status.setComplete();

    return "redirect:/listuser";
  }

  @RequestMapping(value={"/recent"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String getUser(ModelMap model, Principal principal)
  {
    String name = principal.getName();
    Users users = this.usersDao.findByName(name);
    model.addAttribute("username", users.getName().toUpperCase());

    return "recentPage";
  }

  @RequestMapping(value={"/login"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String getLoginPage(@RequestParam(value="error", required=false) boolean error, ModelMap model)
  {
    logger.debug("Received request to show login page");

    return "defaultPage";
  }

  @RequestMapping(value={"/default"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String getDefault() {
    logger.info("this is default page");
    return "defaultPage";
  }

  @RequestMapping(value={"/loginfailed"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String loginerror(ModelMap model)
  {
    model.addAttribute("error", "true");
    return "defaultPage";
  }

  @RequestMapping(value={"/logout"}, method={RequestMethod.GET})
  public String logout(ModelMap model)
  {
    return "defaultPage";
  }
  
  
  @RequestMapping(value={"/custCommon"}, method={RequestMethod.GET})
  public String getCustomerCommon(@RequestParam("companyId") Long custId, HttpServletRequest request, ModelMap model, Principal principal)
  {
	  logger.debug("Received request to show form page");
	  String name = principal.getName();
	  Users users = this.usersDao.findByName(name);
	  model.addAttribute("username", users.getName().toUpperCase());
	  
	  Company company = companyDao.findById(custId);
	  CompanyDto companyDto = new CompanyDto();
	  companyDto.setCompanyId(company.getCompanyId());
	  companyDto.setCompanyName(company.getCompanyName());
	  companyDto.setCompanyDesc(company.getCompanyDesc());
	  companyDto.setCompanySize(company.getCompanySize());
	  companyDto.setCompanyFollower(company.getCompanyFollower());
	  companyDto.setCompanyHQ(company.getCompanyHQ());
	  String path = File.separator + "DCI" + File.separator + "resources" + File.separator + "img" + File.separator;
	  companyDto.setCompanyImage(path + company.getCompanyLogo());
	  //List<ContactPerson> cp = contactPersonDao.getAllContactPerson(company.getCompanyId());
	  List<ContactPerson> cp = contactPersonDao.getAllContactPerson(company.getCompanyId());
	  List<ContactPersonDto> contactDtoList = new ArrayList<ContactPersonDto>();
	  for (ContactPerson cpo : cp) {
		  ContactPersonDto cpDto = new ContactPersonDto();
		  cpDto.setContactId(cpo.getContactId());
		  cpDto.setContactName(cpo.getContactName());
		  cpDto.setContactEmail(cpo.getContactEmail());
		  cpDto.setContactFoto(path + cpo.getContactImg());
		  contactDtoList.add(cpDto);
		  logger.info(cpDto.getContactId() + " " + cpDto.getContactName() + " " + cpDto.getContactEmail() + " " + cpDto.getContactFoto());
	  }
	  companyDto.setContactList(contactDtoList);
	  model.addAttribute("companyDto", companyDto);
	  return "custCommonPage";
  }

  @SuppressWarnings({ "unchecked", "rawtypes" })
@RequestMapping(value={"/customerList"}, method={RequestMethod.GET})
  public String getCustomerList(ModelMap model, HttpServletRequest request, Principal principal)
  {
	  
	  String name = principal.getName();
	  Users users = this.usersDao.findByName(name);
	  model.addAttribute("username", users.getName().toUpperCase());
	  
	  
	  List companies = new ArrayList();
	  /*
	  String rootPath = System.getProperty("catalina.home");
	  String rpath=request.getRealPath("/");
	  File dir = new File(rpath);
	  
	  */
	  
	  for (Company comp : companyDao.getAllCompany()) {
		 // File serverFile = new File( dir.getAbsoluteFile()
		  //  		+ File.separator + "resources" + File.separator + "img" + File.separator + comp.getCompanyLogo());
		  String path = File.separator + "resources" + File.separator + "img" + File.separator + comp.getCompanyLogo();
		  comp.setCompanyLogo(path);
		  companies.add(comp);
	  }
			  
	  //Registration companies = registrationDao.findById((long) 1);
	  //System.out.println(companies.getCompany());
	  model.addAttribute("companyList", companies);
	  
	  return "custListPage";
  }

  @RequestMapping(value={"/form"}, method={RequestMethod.GET})
  public String getFormPage(Model model)
  {
    logger.debug("Received request to show form page");
    List<Countries> countryList = countryDao.getAllCountry();
    model.addAttribute("countryList", countryList);
    List<Industry> industryList = industryDao.getAllindustry();
    model.addAttribute("industryList", industryList);
    Registration registration = new Registration();
    model.addAttribute("registration", registration);
    return "formPage";
  }

  @RequestMapping(value={"/form"}, method={RequestMethod.POST})
  public String setFormPage(@ModelAttribute("registration") Registration registration, BindingResult result, HttpServletRequest request, SessionStatus status, Principal principal, Model model)
  {
    logger.debug("POST form");

    String[] termsCond = request.getParameterValues("terms");
    System.out.println(termsCond.toString());

    this.registrationDao.persist(registration);
    status.setComplete();

    return "registration-successPage";
  }

  @RequestMapping(value={"/403"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String getDeniedPage()
  {
    logger.debug("Received request to show denied page");

    return "deniedpage";
  }
}