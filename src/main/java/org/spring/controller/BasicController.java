/**
 * 
 */
package org.spring.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.spring.dao.UsersDao;
import org.spring.dao.RoleDao;
import org.spring.model.Role;
import org.spring.model.Users;
import org.spring.model.UsersDTO;
import org.springframework.beans.factory.annotation.Autowired;
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

/**
 * @author Radhit
 *
 */

/**
 * Handles requests for the application home page.
 */
@Controller
public class BasicController {
	protected static Logger logger = Logger.getLogger("controller");
	
	@Autowired
	UsersDao usersDao;
	
	@Autowired
	RoleDao roleDao;
	
	
	
	@ModelAttribute("roleList")
	public List<Role> setRoles() {
		List<Role> roleLists = roleDao.getAllRoles();
		return roleLists;
	}
	
    @RequestMapping(value = "/admin")
    public String getAdminPage(Locale locale
    		, HttpServletRequest request, Model model, Principal principal) {
    	logger.info("Welcome home! the client locale is "+ locale.toString());
		
		model.addAttribute("message", "Spring Security Hello World");
		String name = principal.getName();
		logger.info(name);
		model.addAttribute("username", name);
		model.addAttribute("message", "Spring Security Custom Form example");
    
    	// Do your work here. Whatever you like
    	// i.e call a custom service to do your business
    	// Prepare a model to be used by the JSP page
    	/*
    	 * -- there is three option --
    	 * 
    	 * 
    	 * 
    	public String printWelcome(ModelMap model, Principal principal ) {
    	
    	
    	1. Authentication auth = SecurityContextHolder.getContext().getAuthentication();
           String name = auth.getName(); //get logged in username
           model.addAttribute("username", name);
        
        2. User user = (User)SecurityContextHolder.getContext().getAuthentication().
        						getPrincipal();
      	   String name = user.getUsername(); //get logged in username
      	   model.addAttribute("username", name);
    	*/
    	Object principals = SecurityContextHolder.getContext()
    		     .getAuthentication().getPrincipal();
    		HttpSession session = request.getSession(true); //create a new session

    		// put the UserDetails object here.
    		session.setAttribute("userDetails", principals);
    	
    	// This will resolve to /WEB-INF/jsp/adminpage.jsp
    	return "adminpage";
	}
	
	@RequestMapping(value = "/listuser")
	public String getListUser(Locale locale, Model model, Principal principal) {
		logger.info("list of USer");	
		List<Users> users = usersDao.getAllUser();
		String name = principal.getName();
		model.addAttribute("username", name);
		model.addAttribute("userinv", new Users());
		model.addAttribute("userret", users);
		return "listuserpage";
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.GET) 
    public String getEditPage(@RequestParam("id")String uid
    		,HttpServletRequest request, HttpServletResponse response, ModelMap model
    		, Principal principal) {
		
        logger.debug("Received request to show common page");
        String name = principal.getName();
        model.addAttribute("username", name); //get logged in username
        
        Users users = usersDao.findById(uid);
        List<Role> groupList = roleDao.findByUsers(users.getUsername());
        
        UsersDTO usersDTO = new UsersDTO();
        usersDTO.setUsers(users);
        usersDTO.setRoles(groupList);
        
        model.addAttribute("usersDTO", usersDTO);
        
        return "editpage";
    }
	
	@RequestMapping(value="/edit", method=RequestMethod.POST)
	public String setEdit(@ModelAttribute ("usersDTO") UsersDTO usersDTO, BindingResult result
			,HttpServletRequest request, SessionStatus status, Principal principal, Model model){
		//System.out.println(users.getUsergroups());
		logger.debug("POST edit");
		/*
		valid.validate(users, result);
		if (result.hasErrors()) {
			//if validator failed
			return "editpage";
		} else {
		*/
	        
			String name = principal.getName();
	        model.addAttribute("username", name);
	        String[] userGrpArray = request.getParameterValues("usergroups");
			List<Role> grpList=new ArrayList<Role>();
			for (String str : userGrpArray) {
				Role usrGroup = roleDao.findById(str);
	    		grpList.add(usrGroup);
			}
			Users user = usersDTO.getUsers();
	    	user.setRoles( new HashSet<Role>(grpList) );
	    	usersDao.update(user);
	        status.setComplete();
		//}
		return "redirect:/listuser";
	}
	
	
	/**
	 * just User Authority Access..
	 */
	@RequestMapping(value="/recent", method = RequestMethod.GET)
	public String getUser(ModelMap model, Principal principal) {

		String name = principal.getName();
		Users users = usersDao.findByName(name);
		model.addAttribute("username", users.getName().toUpperCase());

		return "recentPage";
 
	}
	
	
	
	/**
	 * Handles and retrieves the login JSP page
	 * 
	 * @return the name of the JSP page
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String getLoginPage(@RequestParam(value="error", required=false) boolean error, 
			ModelMap model) {
		logger.debug("Received request to show login page");

		// Add an error message to the model if login is unsuccessful
		// The 'error' parameter is set to true based on the when the authentication has failed. 
		// We declared this under the authentication-failure-url attribute inside the spring-security.xml
		/* See below:
		 <form-login 
				login-page="/krams/auth/login" 
				authentication-failure-url="/krams/auth/login?error=true" 
				default-target-url="/krams/main/common"/>
		 */
		
		// sementara di matikan . by RAD
		/*
		if (error == true) {
			// Assign an error message
			model.put("error", "You have entered an invalid username or password!");
		} else {
			model.put("error", "");
		}
		*/
		// This will resolve to /WEB-INF/jsp/loginpage.jsp
		return "defaultPage";
	}
	
	@RequestMapping(value="/default", method = RequestMethod.GET)
	public String getDefault() {
		logger.info("this is default page");
		return "defaultPage";
	}
	
	
 
	@RequestMapping(value="/loginfailed", method = RequestMethod.GET)
	public String loginerror(ModelMap model) {
		model.addAttribute("error", "true");
		return "defaultPage";
	}
 
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logout(ModelMap model) {
 
		return "defaultPage";
 
	}
	
	/**
	 * Handles and retrieves the denied JSP page. This is shown whenever a regular user
	 * tries to access an admin only page.
	 * 
	 * @return the name of the JSP page
	 */
	@RequestMapping(value = "/403", method = RequestMethod.GET)
 	public String getDeniedPage() {
		logger.debug("Received request to show denied page");
		// This will resolve to /WEB-INF/jsp/deniedpage.jsp
		return "deniedpage";
	}
	
}
