package org.spring.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
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
import org.spring.dao.RegistrationDao;
import org.spring.dao.RoleDao;
import org.spring.dao.UsersDao;
import org.spring.model.Company;
import org.spring.model.FilesClass;
import org.spring.model.Registration;
import org.spring.model.Role;
import org.spring.model.Users;
import org.spring.model.UsersDTO;
import org.spring.service.FilesSave;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

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
  
  private FilesSave filesSave;

  @ModelAttribute("roleList")
  public List<Role> setRoles() { List roleLists = this.roleDao.getAllRoles();
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
    List users = this.usersDao.getAllUser();
    String name = principal.getName();
    model.addAttribute("username", name);
    model.addAttribute("userinv", new Users());
    model.addAttribute("userret", users);
    return "listuserpage";
  }
  
  @RequestMapping(value={"/setting"}, method={RequestMethod.GET})
  public String getSettingPage(Principal principal, Model model) {
    logger.info("Enter Setting Page");
    String name = principal.getName();
    Users users = usersDao.findByName(name);
    model.addAttribute("username", users.getName());
    model.addAttribute("filess",new FilesClass());
    return "settingPage";
  }
  
  @RequestMapping(value={"/setting"}, method={RequestMethod.POST})
  public String setSettingPage(@ModelAttribute("filess") FilesClass filesDto, BindingResult result, Principal principal, Model model) throws IOException {
	  logger.info("Leave Setting Page");
	    String name = principal.getName();
	    Users users = usersDao.findByName(name);
	    model.addAttribute("username", users.getName());
	    
	    Company companies = new Company(filesDto.getCompanyName(), "");
	    companyDao.persist(companies);
	    String imageName = "Company-" + companies.getCompanyId();
	    Company comp = companyDao.findById(companies.getCompanyId());
	    comp.setLogoImg(imageName);
	    companyDao.update(comp);
	    filesSave = new FilesSave(imageName, filesDto);
	    //if (filesSave.isImage()){
	    	filesSave.saveFile();
	    //}
	   
	    
	  return "redirect:/customer";
  }

  @RequestMapping(value={"/edit"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String getEditPage(@RequestParam("id") String uid, HttpServletRequest request, HttpServletResponse response, ModelMap model, Principal principal)
  {
    logger.debug("Received request to show common page");
    String name = principal.getName();
    model.addAttribute("username", name);

    Users users = this.usersDao.findById(uid);
    List groupList = this.roleDao.findByUsers(users.getUsername());

    UsersDTO usersDTO = new UsersDTO();
    usersDTO.setUsers(users);
    usersDTO.setRoles(groupList);

    model.addAttribute("usersDTO", usersDTO);

    return "editpage";
  }

  @RequestMapping(value={"/edit"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public String setEdit(@ModelAttribute("usersDTO") UsersDTO usersDTO, BindingResult result, HttpServletRequest request, SessionStatus status, Principal principal, Model model)
  {
    logger.debug("POST edit");

    String name = principal.getName();
    model.addAttribute("username", name);
    String[] userGrpArray = request.getParameterValues("usergroups");
    List grpList = new ArrayList();
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

  @RequestMapping(value={"/logout"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String logout(ModelMap model)
  {
    return "defaultPage";
  }

  @RequestMapping(value={"/customer"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String getCustomer(ModelMap model, Principal principal)
  {
	  String name = principal.getName();
	  Users users = this.usersDao.findByName(name);
	  model.addAttribute("username", users.getName().toUpperCase());
	  return "custPage";
  }

  @RequestMapping(value={"/form"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String getFormPage(Model model)
  {
    logger.debug("Received request to show form page");
    Registration registration = new Registration();
    model.addAttribute("registration", registration);
    return "formPage";
  }

  @RequestMapping(value={"/form"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
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