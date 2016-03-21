package org.spring.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.spring.dao.CompanyDao;
import org.spring.dao.ContactPersonDao;
import org.spring.dao.CountryDao;
import org.spring.dao.IndustryDao;
import org.spring.dao.RegistrationDao;
import org.spring.dao.RoleDao;
import org.spring.dao.UsersDao;
import org.spring.model.Blog;
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
import org.spring.service.BlogService;
import org.spring.service.FilesSave;
import org.spring.service.MailSender;
import org.spring.service.RegistrationValidator;
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
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

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
  
  @Autowired
  RegistrationValidator registrationValidator;
  
  @Autowired
  MailSender mailSender;
  
  @Autowired
  BlogService blogService;

  @Autowired
  FilesSave filesSave;
  
  private Long compId;
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
  
  @ModelAttribute("blog")
	public Blog constructBlog() {
		return new Blog();
	}
  
  @ModelAttribute("countryList")
  public List<Countries> getCountryList() {
	  return (List<Countries>) countryDao.getAllCountry();
  }
  
  @ModelAttribute("industryList")
  public List<Industry> getIndustryList() {
	  return (List<Industry>) industryDao.getAllindustry();
  }
  
  private String getSessionSecurity(Principal principal) {
	  if (principal == null) {
		  return "";
	  } else {
		  return principal.getName();
	  }
  }

  @RequestMapping({"/admin"})
  public String getAdminPage(Locale locale, HttpServletRequest request, Model model, Principal principal)
  {
	model.addAttribute("message", "Spring Security Hello World");
    String name = this.getSessionSecurity(principal);
    if (name == "") { return "403"; }
    model.addAttribute("username", name);
    model.addAttribute("message", "Spring Security Custom Form example");

//    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//    User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    Object principals = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    HttpSession session = request.getSession(true);
    session.setAttribute("userDetails", principals);
    
    return "adminpage";
  }

  @RequestMapping({"/listuser"})
  public String getListUser(Locale locale, Model model, Principal principal) {
    List<Users> users = this.usersDao.getAllUser();
    String name = this.getSessionSecurity(principal);
    if (name == "") { return "403"; }
    model.addAttribute("username", name);
    model.addAttribute("userinv", new Users());
    model.addAttribute("userret", users);
    
    return "listuserpage";
  }
  
  @RequestMapping(value={"/settingPrivacy"}, method={RequestMethod.GET})
  public String getSettingPrivacy(Model model) {
//    @RequestParam("companyId") Long companyId, Principal principal, HttpServletRequest request, Model model) {
//	  String name = this.getSessionSecurity(principal);
//    if (name == "") { return "403"; }
    return "settingPrivacyPage";
  }
  
  @RequestMapping(value={"/settingCP"}, method={RequestMethod.GET})
  public String getSettingCP( Principal principal, HttpServletRequest request, Model model) {
    String name = this.getSessionSecurity(principal);
    if (name == "") { return "403"; }
    Users users = usersDao.findByName(name);
    model.addAttribute("username", users.getName());
    Company company = users.getCompany();
    this.compId = company.getCompanyId(); // --> set to getter-setter (Long) compId
    model.addAttribute("contactDtoList", filesSave.setContactPersonDto(compId));
	
	// this method for button add new contact person (set null to default value) ...
	ContactPersonDto newContact = new ContactPersonDto();
	String pathContactFoto = "resources" + File.separator + "img" + File.separator; 
	newContact.setContactFoto(pathContactFoto + "find_user.png");
	model.addAttribute("newContact", newContact);
	//..
    return "settingCPPage";
  }
  
  @RequestMapping(value={"/settingCP"}, method={RequestMethod.POST})
  public String setSettingCP(@ModelAttribute("contactDtoList") List<ContactPersonDto> contactDtoList, Principal principal, HttpServletRequest request, Model model) {
    String name = this.getSessionSecurity(principal);
    if (name == "") { return "403"; }
    Users users = usersDao.findByName(name);
    model.addAttribute("username", users.getName());
    /* to save Image, use different method: setEditContact & setNewContact (see settingCP.jsp form action="")*/
    
    return "redirect:/settingCPPage";
  }
  
  @SuppressWarnings("deprecation")
  @RequestMapping(value={"/editContact"}, method={RequestMethod.POST})
  public String setEditContact(@ModelAttribute("contactPersonDto") ContactPersonDto contactPersonDto, HttpServletRequest request,  Principal principal, Model model) { //  MultipartHttpServletRequest request, 
	String name = this.getSessionSecurity(principal);
	if (name == "") { return "403"; }
	Users users = usersDao.findByName(name);
    model.addAttribute("username", users.getName());
    contactPersonDao.update(filesSave.saveContactPerson(contactPersonDto, this.compId, request.getRealPath("/") + File.separator + "resources" + File.separator + "img"));
    return "redirect:/settingCPPage";
  }
  
  @SuppressWarnings("deprecation")
  @RequestMapping(value={"/newContact"}, method={RequestMethod.POST})
  public String setNewContact(@ModelAttribute("contactPersonDto") ContactPersonDto contactPersonDto, HttpServletRequest request,  Principal principal, Model model) { //  MultipartHttpServletRequest request, 
	String name = this.getSessionSecurity(principal);
	if (name == "") { return "403"; }
	Users users = usersDao.findByName(name);
    model.addAttribute("username", users.getName());
    
    /****
     * JUST FOR NOTE.
     * IF USING AUTOWIRED, DO NOT USE "New Class" AGAIN!!
     * THIS WILL IMPACT THE TARGET CLASS CAN NOT USE '@'AUTOWIRED AGAIN...
     * 
     * 
     *  filesSave = new FilesSave(request.getRealPath("/") + File.separator + "resources" + File.separator + "img");
     *  
     */
    
    contactPersonDao.update(filesSave.saveContactPerson(contactPersonDto, this.compId, request.getRealPath("/") + File.separator + "resources" + File.separator + "img"));
    return "redirect:/settingCPPage";
  }
  
  @RequestMapping(value={"/editCP"}, method={RequestMethod.POST})
  public String setEditCP(@ModelAttribute("companyDtos") CompanyDto companyDto, HttpServletRequest request,  Principal principal, Model model) { //  MultipartHttpServletRequest request, 
	String name = this.getSessionSecurity(principal);
	if (name == "") { return "403"; }
    Users users = usersDao.findByName(name);
    model.addAttribute("username", users.getName());
    Company companies = companyDao.findById(companyDto.getCompanyId());
    
//    MultipartHttpServletRequest multiPartRequest = (MultipartHttpServletRequest) request;
//    MultipartHttpServletRequest multiPartRequest = new DefaultMultipartHttpServletRequest(request);
//    CommonsMultipartFile imgCp =  (CommonsMultipartFile) multiPartRequest;
//    MultipartFile imgCp = multipartFile.getFile("getImg");
//    MultipartFile imgCp = null; //request.getParameter("getImg");
    
    
    String nameImage = companyDto.getCompanyLogo().getOriginalFilename();
	String extFile = nameImage.substring(nameImage.lastIndexOf("."), nameImage.length());
	String imageName = "Company-" + companyDto.getCompanyId() + extFile;
	companies.setCompanyLogo(imageName);
	companyDao.update(companies);
    File fileSave = new File( request.getRealPath("/") + File.separator + "resources" + File.separator + "img" );
    try {
		byte[] bytes = companyDto.getCompanyLogo().getBytes();
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
  
  @RequestMapping(value={"/pingme"}, method={RequestMethod.GET})
  public String getPingme(@ModelAttribute("companyModel") Company company, HttpServletRequest request,  Principal principal, Model model) { //  MultipartHttpServletRequest request, 
	String name = this.getSessionSecurity(principal);
	if (name == "") { return "403"; }
	Users users = usersDao.findByName(name);
    model.addAttribute("username", users.getName());
    
    return "pingmePage";
  }
  
  @RequestMapping(value={"/setting"}, method={RequestMethod.GET})
  public String getSettingPage(Principal principal, Model model) {
	  String name = this.getSessionSecurity(principal);
	  if (name == "") { return "403"; }
	  Users users = usersDao.findByName(name);
	  model.addAttribute("username", users.getName());
	  model.addAttribute("users", users);
	  return "settingPage";
  }
  
  @RequestMapping(value={"/setting"}, method={RequestMethod.POST})
  public String setSettingPage(Principal principal, Model model) {
	  String name = this.getSessionSecurity(principal);
	  if (name == "") { return "403"; }
	  Users users = usersDao.findByName(name);
	  model.addAttribute("username", users.getName());
	  return "redirect:/customerList";
  }
  
  
  
  @RequestMapping(value={"/settingTmp"}, method={RequestMethod.GET})
  public String getSettingTmpPage(Principal principal, Model model) {
	  String name = this.getSessionSecurity(principal);
	  if (name == "") { return "403"; }
	  Users users = usersDao.findByName(name);
	  model.addAttribute("username", users.getName());
	  CompanyDto companyDto = new CompanyDto();
	  List<ContactPersonDto> contactsList = new AutoPopulatingList<ContactPersonDto>(ContactPersonDto.class);
	  companyDto.setContactList(contactsList);
	  model.addAttribute("filess",companyDto);
	  return "settingTmpPage";
  }
  
  @SuppressWarnings("deprecation")
  @RequestMapping(value={"/settingTmp"}, method={RequestMethod.POST})
  public String setSettingTmpPage(@ModelAttribute("filess") CompanyDto filesDto, BindingResult result, HttpServletRequest request, SessionStatus status, Principal principal, Model model) {
	  String name = this.getSessionSecurity(principal);
	  if (name == "") { return "403"; }
	  Users users = usersDao.findByName(name);
	  model.addAttribute("username", users.getName());
	  Industry industry = industryDao.findById(Integer.parseInt(filesDto.getIndustry()));
	  Company companies = new Company(filesDto.getCompanyName(), filesDto.getCompanyDesc(), filesDto.getCompanySize(), filesDto.getCompanyFollower(), filesDto.getCompanyHQ(), industry);
	  String nameImage = filesDto.getCompanyLogo().getOriginalFilename();
	  String extFile = nameImage.substring(nameImage.lastIndexOf("."), nameImage.length());
	  Long companyIds = companyDao.persist(companies);
	  String imageName = "Company-" + companyIds + extFile;
	  File fileSave = new File( request.getRealPath("/") + File.separator + "resources" + File.separator + "img" );
	  filesSave = new FilesSave(imageName, filesDto, fileSave.getAbsolutePath() , companies);
	  filesSave.saveFile();
	  int counter = 1;
	  for (ContactPersonDto cpDto : filesDto.getContactList()) {
		MultipartFile parts = cpDto.getContactImg();
		try {
				byte[] bytes = parts.getBytes();
				String cpImage = parts.getOriginalFilename();
				String cpExtFile = cpImage.substring(cpImage.lastIndexOf("."), cpImage.length());
				String cpImageName = "Contact-" + companyIds + counter + cpExtFile;
			    File serverFile = new File( fileSave.getAbsoluteFile()
			    		+ File.separator + cpImageName);
			    if (serverFile.exists()) {serverFile.delete();}
			    BufferedOutputStream stream = new BufferedOutputStream(
			    		new FileOutputStream(serverFile));
			    stream.write(bytes);
				stream.close();
				
				ContactPerson contactPerson = new ContactPerson(cpDto.getContactName(), cpDto.getContactLastName(), cpDto.getContactPosition(), cpDto.getContactEmail(), cpImageName, companies);
				contactPersonDao.persist(contactPerson, companies.getCompanyId());
				counter++;
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
  public String getForgetPage(@RequestParam(value="error", required=false) boolean error, Principal principal, Model model) {
    model.addAttribute("sendPass", new String());
    return "forgetPage";
  }
  
  @RequestMapping(value={"/forget"}, method={RequestMethod.POST})
  public String setForgetPage( Principal principal, Model model, HttpServletRequest request){
	  String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"  
			   + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	  Pattern pattern; 
	  Matcher matcher;
	  String passStr = request.getParameter("sendPass");
	  
      if (passStr == "" || passStr == null) {
    	  model.addAttribute("errorMsg", "Your email address is invalid");  
		  return "forgetPage";
	  } else {
		   pattern = Pattern.compile(EMAIL_PATTERN);  
		   matcher = pattern.matcher(passStr);  
		   if (!matcher.matches()) {  
			   model.addAttribute("errorMsg", "Your email address doesn't meet criteria");
			   return "forgetPage";
		   }
	  }
      
      try {
		mailSender = new MailSender("","","");
        mailSender.sendMessage("rahadhitya.y@dci-indonesia.com", "test header", "Confirm perubahan password untuk user : " + passStr);
        model.addAttribute("message", passStr);
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
        } catch (Exception e) {
        	e.getMessage();
	        System.out.println("Gagal Mengirim Email");
	    }
	  	
      return "registration-successPage";
  }
  
  @RequestMapping(value={"/registration-successPage"}, method={RequestMethod.GET})
  public String getResetPass(Model model)
  {
	  model.addAttribute("message", "test");
	  return "registration-successPage";
  }

  @RequestMapping(value={"/edit"}, method={RequestMethod.GET})
  public String getEditPage(@RequestParam("id") String uid, HttpServletRequest request, HttpServletResponse response, ModelMap model, Principal principal)
  {
	 String name = this.getSessionSecurity(principal);
	 if (name == "") { return "403"; }
//    Users users = this.usersDao.findById(uid);
	 Users users = usersDao.findByName(name);
	 model.addAttribute("username", users.getName());
	 List<Role> groupList = this.roleDao.findByUsers(users.getUsername());
	 UsersDTO usersDTO = new UsersDTO();
	 usersDTO.setUsers(users);
	 usersDTO.setRoles(groupList);
	 model.addAttribute("usersDTO", usersDTO);
	 return "editpage";
  }

  @SuppressWarnings({ "rawtypes", "unchecked" })
@RequestMapping(value={"/edit"}, method={RequestMethod.POST})
  public String setEdit(@ModelAttribute("usersDTO") UsersDTO usersDTO, BindingResult result, HttpServletRequest request, SessionStatus status, Principal principal, Model model)
  {
	 String name = this.getSessionSecurity(principal);
	 if (name == "") { return "403"; } 
	 Users users = usersDao.findByName(name);
	 model.addAttribute("username", users.getName());
	 String[] userGrpArray = request.getParameterValues("usergroups");
	 List<Role> grpList = new ArrayList();
	 for (String str : userGrpArray) {
		 Role usrGroup = this.roleDao.findById(str);
		 grpList.add(usrGroup);
	 }
	 Users user = usersDTO.getUsers();
	 user.setRoles(new HashSet(grpList));
	 this.usersDao.update(user);
//	 status.setComplete();
	 return "redirect:/listuser";
  }

  @RequestMapping(value={"/recent"}, method={RequestMethod.GET})
  public String getUser(ModelMap model, Principal principal)
  {
	String name = this.getSessionSecurity(principal);
	if (name == "") { return "403"; }
    Users users = this.usersDao.findByName(name);
    model.addAttribute("username", users.getName().toUpperCase());
    return "recentPage";
  }

  @RequestMapping(value={"/login"}, method={RequestMethod.GET})
  public String getLoginPage(@RequestParam(value="error", required=false) boolean error, ModelMap model)
  {
    return "defaultPage";
  }

  @RequestMapping(value={"/default"}, method={RequestMethod.GET})
  public String getDefault() {
    return "defaultPage";
  }

  @RequestMapping(value={"/loginfailed"}, method={RequestMethod.GET})
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
	  String name = this.getSessionSecurity(principal);
	  if (name == "") { return "403"; }
	  Users users = this.usersDao.findByName(name);
	  model.addAttribute("username", users.getName().toUpperCase());
	  this.compId = custId;
	  Company company = companyDao.findById(custId);
	  CompanyDto companyDto = new CompanyDto();
	  companyDto.setCompanyId(company.getCompanyId());
	  companyDto.setCompanyName(company.getCompanyName());
	  companyDto.setCompanyDesc(company.getCompanyDesc());
	  companyDto.setCompanySize(company.getCompanySize());
	  companyDto.setCompanyFollower(company.getCompanyFollower());
	  companyDto.setCompanyHQ(company.getCompanyHQ());
	  companyDto.setCompanyService(company.getCompanyService());
	  companyDto.setIndustry(company.getIndustry().getIndustryName());
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
		  String pathContactFoto = File.separator + "resources" + File.separator + "img" + File.separator; //File.separator + "DCI" + 
		  cpDto.setContactFoto(pathContactFoto + cpo.getContactImg());
		  contactDtoList.add(cpDto);
//		  logger.info(cpDto.getContactId() + " " + cpDto.getContactName() + " " + cpDto.getContactEmail() + " " + cpDto.getContactFoto());
	  }
	  companyDto.setContactList(contactDtoList);
	  model.addAttribute("companyDto", companyDto);
	  model.addAttribute("companyDtos", companyDto);
	  return "custCommonPage";
  }
  
  @RequestMapping(value={"/custCommon"}, method={RequestMethod.POST})
  public String setCustomerCommon(@ModelAttribute("companyDtos") CompanyDto companyDto,  HttpServletRequest request, ModelMap model, Principal principal)
  {
	  String name = this.getSessionSecurity(principal);
	  if (name == "") { return "403"; }
	  Users users = this.usersDao.findByName(name);
	  model.addAttribute("username", users.getName());
	  Company company = companyDao.findById(companyDto.getCompanyId());
	  Company companyBuffer = new Company();
	  String cpImageName = null;
	  if (companyDto.getCompanyLogo() != null) {
		  File fileSave = new File( request.getRealPath("/") + File.separator + "resources" + File.separator + "img" );
	      MultipartFile parts = companyDto.getCompanyLogo();
	      try {
	    	  byte[] bytes = parts.getBytes();
	    	  String cpImage = parts.getOriginalFilename();
	    	  String cpExtFile = cpImage.substring(cpImage.lastIndexOf("."), cpImage.length());
	    	  cpImageName = "Company-" + companyDto.getCompanyId() + cpExtFile;
	    	  File serverFile = new File( fileSave.getAbsoluteFile()
		    	+ File.separator + cpImageName);
	    	  if (serverFile.exists()) {serverFile.delete();}
	    	  	BufferedOutputStream stream = new BufferedOutputStream(
		    		new FileOutputStream(serverFile));
	    	  stream.write(bytes);
	    	  stream.close();
	      } catch (IOException e) {
	    	  e.printStackTrace();
		  }
	  }
	  companyBuffer.setCompanyId(company.getCompanyId());
	  companyBuffer.setCompanyName(companyDto.getCompanyName() == null ? company.getCompanyName() : companyDto.getCompanyName());
	  companyBuffer.setCompanyDesc(companyDto.getCompanyDesc() == null ? company.getCompanyDesc() : companyDto.getCompanyDesc());
	  companyBuffer.setCompanyLogo(companyDto.getCompanyLogo() == null ? company.getCompanyLogo() : cpImageName);
	  companyBuffer.setCompanySize(companyDto.getCompanySize() == null ? company.getCompanySize() : companyDto.getCompanySize());
	  companyBuffer.setCompanyFollower(companyDto.getCompanyFollower() < 1 ? company.getCompanyFollower() : companyDto.getCompanyFollower());
	  companyBuffer.setCompanyHQ(companyDto.getCompanyHQ() == null ? company.getCompanyHQ() : companyDto.getCompanyHQ());
	  companyBuffer.setCompanyService(companyDto.getCompanyService() == null ? company.getCompanyService() : companyDto.getCompanyService());
	  Industry industry = industryDao.findById(1);
	  companyBuffer.setIndustry(companyDto.getIndustry() == null ? industry : industryDao.findById(Integer.parseInt(companyDto.getIndustry())));
	  companyDao.update(companyBuffer);
	  return "redirect:/custCommon?companyId=" + companyDto.getCompanyId();
  }
  
  @RequestMapping(value={"/customerSearch"}, method={RequestMethod.POST})
  public String getCustomerSearch(ModelMap model, HttpServletRequest request, Principal principal)
  {
	  String name = this.getSessionSecurity(principal);
	  if (name == "") { return "403"; }
	  String searchTxt = request.getParameter("searchInput");
	  Users users = this.usersDao.findByName(name);
	  model.addAttribute("username", users.getName().toUpperCase());
//	  companyDao.getAllCompSearch(searchTxt);
//	  List companies = new ArrayList();
//	  for (Company comp : companyDao.getAllCompany()) {
//		  String path = File.separator + "resources" + File.separator + "img" + File.separator + comp.getCompanyLogo();
//		  comp.setCompanyLogo(path);
//		  companies.add(comp);
//	  }
	  
	  List<Company> companies = new ArrayList<Company>(); 
	  for (Company comp : companyDao.getAllCompSearch(searchTxt)) {
		  String path = File.separator + "resources" + File.separator + "img" + File.separator + comp.getCompanyLogo();
		  comp.setCompanyLogo(path);
		  companies.add(comp);
	  }
	  model.addAttribute("companyList", companies);
	  return "custListPage";
  }

  @SuppressWarnings({ "unchecked", "rawtypes" })
  @RequestMapping(value={"/customerList"}, method={RequestMethod.GET})
  public String getCustomerList(ModelMap model, HttpServletRequest request, Principal principal)
  {
	  String name = this.getSessionSecurity(principal);
	  if (name == "") { return "403"; }
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
		  logger.debug(path);
		  
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
    Registration registration = new Registration();
    model.addAttribute("registration", registration);
    return "formPage";
  }

  @RequestMapping(value={"/form"}, method={RequestMethod.POST})
  public String setFormPage(@ModelAttribute("registration") Registration registration, BindingResult result, HttpServletRequest request, SessionStatus status, Principal principal, Model model)
  {
    registrationValidator.validate(registration, result);
	if (result.hasErrors()) 
	{				
		return "formPage";
	}
    String[] termsCond = request.getParameterValues("terms");
    System.out.println(termsCond.toString());

    this.registrationDao.persist(registration);
    status.setComplete();

    return "registration-successPage";
  }

  @RequestMapping(value={"/403"}, method={RequestMethod.GET})
  public String getDeniedPage()
  {
    return "deniedpage";
  }
  
  /*
   * 
    public CompanyDto setCompanyDto(Company company) {
	CompanyDto companyDto = new CompanyDto();
	companyDto.setCompanyId(company.getCompanyId());
	companyDto.setCompanyName(company.getCompanyName());
	companyDto.setCompanyDesc(company.getCompanyDesc());
	companyDto.setCompanySize(company.getCompanySize());
	companyDto.setCompanyFollower(company.getCompanyFollower());
	companyDto.setCompanyHQ(company.getCompanyHQ());
	File logoPath = new File( File.separator + "DCI" + File.separator + "resources" + File.separator + "img" + File.separator);
	companyDto.setCompanyImage(logoPath + company.getCompanyLogo());
	
	List<ContactPerson> cp = contactPersonDao.getAllContactPerson(company.getCompanyId());
	List<ContactPersonDto> contactDtoList = new AutoPopulatingList<ContactPersonDto>(ContactPersonDto.class);
//	List<ContactPersonDto> contactDtoList = new ArrayList<ContactPersonDto>();
	for (ContactPerson cpo : cp) {
		ContactPersonDto cpDto = new ContactPersonDto();
		cpDto.setContactId(cpo.getContactId());
		cpDto.setContactName(cpo.getContactName());
		cpDto.setContactEmail(cpo.getContactEmail());
		String pathContactFoto = File.separator + "resources" + File.separator + "img" + File.separator; //File.separator + "DCI" + 
		cpDto.setContactFoto(pathContactFoto + cpo.getContactImg());
		contactDtoList.add(cpDto);
//		  logger.info(cpDto.getContactId() + " " + cpDto.getContactName() + " " + cpDto.getContactEmail() + " " + cpDto.getContactFoto());
	}
	companyDto.setContactList(contactDtoList);
	
	return companyDto;
  }
   */
  
  	@RequestMapping(value ="/account", method = RequestMethod.GET)
	public String account(Model model, Principal principal) {
	  String name = this.getSessionSecurity(principal);
	  if (name == "") { return "403"; }
	  Users users = this.usersDao.findByName(name);
	  model.addAttribute("username", users.getName().toUpperCase());
//		model.addAttribute("user", userService.findOneWithBlogs(name));
	  return "account";
	}

	@RequestMapping(value = "/account", method = RequestMethod.POST)
	public String doAddBlog(Model model,
			@Valid @ModelAttribute("blog") Blog blog, BindingResult result,
			Principal principal) {
	   String name = this.getSessionSecurity(principal);
	   if (name == "") { return "403"; }
	   Users users = this.usersDao.findByName(name);
	   model.addAttribute("username", users.getName().toUpperCase());
	   if (result.hasErrors()) {
		   return account(model, principal);
	   }
	   blogService.save(blog, name);
	   return "redirect:/account.html";
	}
  

	public Long getCompId() {
		return compId;
	}
	
	public void setCompId(Long compId) {
		this.compId = compId;
	}
}