package com.dci.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.sql.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.ListIterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dci.dao.UsersDao;
import com.dci.model.Users;
import com.dci.service.ReportService;

/**
 * Handles and retrieves the common or admin page depending on the URI template.
 * A user must be log-in first he can access these pages.  Only the admin can see
 * the adminpage, however.
 */

@Controller
@RequestMapping("/main")
public class MainController{

	protected static Logger logger = Logger.getLogger("controller");
	@Autowired
	private UsersDao usersDao;
	private String purchNum;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) 
	{
		//SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ"); 
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
	
	/**
	 * Handles and retrieves the common JSP page that everyone can see
	 * 
	 * @return the name of the JSP page
	 */
    @RequestMapping(value = "/common")
    public String getCommonPage() {
    	logger.debug("Received request to show common page GET");
    return "commoncrot";
	}

    /**
	 * Handles and retrieves the common JSP page that everyone can see
	 * 
	 * @return the name of the JSP page
	 */
    /*
    @RequestMapping(value = "/common", method = RequestMethod.POST)
    public String setCommonPage(@ModelAttribute ("listI") ListItis listI, HttpServletRequest request, ModelMap model) {
    	logger.debug("Received request to show common page POST");
    	String accName = null;
    	for (BookOrder its : listI.getListInvent()) {
    		System.out.printf("%s \t %s \t %s \t %s \n", its.getAccountNum(), its.getItemId(),its.getQty(),its.getPrice());
    		Double amt = its.getQty() * its.getPrice();
   		  	its.setAmount(amt);

            java.util.Date utilDate;
            java.util.Calendar cal = java.util.Calendar.getInstance(); 
            java.sql.Date timeNow = new Date(cal.getTimeInMillis());
            its.setDateTrans(timeNow);

   		  	accName = its.getAccountNum();
            bookOrderDao.parseUpdate(its);
    	}
    	Cust cust = custDao.findById(accName);
    	
    	 logger.debug("--------------generate PDF report----------");

         Map<String,Object> parameterMap = new HashMap<String,Object>();
    	
    	 JRDataSource JRdataSource = new JRBeanCollectionDataSource(listI.getListInvent());

         parameterMap.put("datasource", JRdataSource);
         @SuppressWarnings("deprecation")
 		String realPath = request.getRealPath("/coffee.jpg");
         System.out.println(realPath);
         @SuppressWarnings({ "deprecation", "unused" })
 		File reportFile = new File(request.getRealPath("/coffee.jpg"));
        // System.out.println(reportFile);
         //parameterMap.put("BaseDir", reportFile.getParent()); //departmentService.getAppPath()
         parameterMap.put("BaseDir", realPath); //departmentService.getAppPath()
         parameterMap.put("ReportTitle", "Address Report");

         //pdfReport bean has ben declared in the jasper-views.xml file
         model.addAttribute("pdfReport", parameterMap);
    	
    	orderManager.sendMail("rahadhitya@sriboga-smg.co.id", purchNum + " - "+ cust.getName(), cust.getName()); 
    return "commoncrot";
	}
	*/
	
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String getAdminPage(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
    	logger.debug("Received request to show admin page");
    	model.addAttribute("username", getAuthName().getName());
    return "adminpage";
	}
    
    @RequestMapping(value = "/superd", method = RequestMethod.GET)
    public String getSpvPage(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
    	logger.debug("Received request to show Supervisor page");
    	model.addAttribute("username", getAuthName().getName());
    return "spvtiles";
	}
    /*
	@RequestMapping(value = "/purc", method = RequestMethod.GET)
    public String getPurcPage(@RequestParam(required= false, defaultValue="") String searches, 
    		HttpServletRequest request, HttpServletResponse response, ModelMap model) {
        logger.debug("Received request to show purchase page");
        model.addAttribute("username", getAuthName().getName());
 
        model.addAttribute("itis", new BookOrderDTO());
        
        String[] strArray = {"25KG","1KG","50KG"};
        
        logger.debug("this from purc.GET : " + searches.trim());

        for (int i=0;i<strArray.length;i++){
        	logger.debug(strArray[i].toString());
        	String newStr = strArray[i].toString();
        	String strAttr = new String();
        	if (newStr == "25KG") { strAttr = "KG25";}
        	else if(newStr == "1KG") {strAttr = "KG1";}
        	else {strAttr = "KG50";}
        	   model.addAttribute(strAttr, itemService.getAllItems(String.valueOf(getAuthName().getAccountNum()), newStr,searches.trim()));
        }
        return "POtiles";
    }

    @RequestMapping(value = "/searching", method = RequestMethod.POST)
    public String getSearchPage(@RequestParam(required= false, defaultValue="") String searchs, ModelMap model) {

        logger.debug("Received request to redirect purchase page");
        model.addAttribute("username", getAuthName().getName());
 
        model.addAttribute("itis", new BookOrderDTO());
        
        String[] strArray = {"25KG","1KG","50KG"};
        
        logger.debug(searchs.trim());
        //model.addAttribute("searches", searchs.trim());
        
        for (int i=0;i<strArray.length;i++){
            logger.debug(strArray[i].toString());
            String newStr = strArray[i].toString();
            String strAttr = new String();
            
            if (newStr == "25KG") { strAttr = "KG25";}
            else if(newStr == "1KG") {strAttr = "KG1";}
            else {strAttr = "KG50";}
               model.addAttribute(strAttr, itemService.getAllItems(String.valueOf(getAuthName().getAccountNum()), newStr, searchs.trim()));
        }
        return "redirect:purc.do?searches=" + searchs.trim();
    }    
    */
    /**
	 * Handles and retrieves the common JSP page that everyone can see
	 * 
	 * @return the name of the JSP page
	 */
    /*
    @SuppressWarnings("rawtypes")
	@RequestMapping(value = "/purc", method = RequestMethod.POST)
    public String getResultPage(@ModelAttribute ("itis") BookOrderDTO itisDTO, ModelMap model) {
    	logger.debug("Retreive show result page from purchase page");

    	model.addAttribute("username", getAuthName().getName());
    	String purchCount = null;
    	BookOrderDTO itisDTO1 = (BookOrderDTO) itisDTO;
    	ListIterator iterator = itisDTO1.getIdList().listIterator(itisDTO1.getIdList().size());
		while (iterator.hasPrevious()) {
		  Object element = iterator.previous();
		  logger.debug("Adding new ItemList = " + element.toString());
		  BookOrder itss = new BookOrder();
		  
		  Calendar date = new GregorianCalendar();
		  int year = date.get(Calendar.YEAR);  // 2012
		  int month = date.get(Calendar.MONTH) + 1;  // 9 - October!!!
		  int day = date.get(Calendar.DAY_OF_MONTH);  // 5

		  RadhitView1 radhitView1 = radhitViewDao.findById(element.toString());
		  itss.setAccountNum(String.valueOf(getAuthName().getAccountNum()));
		  java.util.Date utilDate;
		  java.util.Calendar cal = java.util.Calendar.getInstance(); 
		  java.sql.Date timeNow = new Date(cal.getTimeInMillis());
		  itss.setDateTrans(timeNow);
		  
		  itss.setItemId(radhitView1.getItemId());
		  itss.setItemName(radhitView1.getItemName());
		  itss.setPrice(radhitView1.getAmounts());
		  itss.setAmount(1D);
		  itss.setQty(1D);
		  BookCounter bookCounter = bookCounterDao.findById(timeNow);
		  String yearStr = String.valueOf(year).substring(2,4);
		  int rcId = (Integer.parseInt(yearStr) *100000000) + (month * 1000000) + (day * 10000) + bookCounter.getBookCount();
		  itss.setRecId(rcId);
		  itss.setRecVersion(-1);
		  itss.setDataAreaId("srr");
          
		  if (purchCount == null){
			  purchCount = String.valueOf(bookCounter.getBookCount());
		  }
		  purchNum = "PR" + String.valueOf(year) + String.valueOf(month) + String.valueOf(day) + purchCount;
		  logger.debug(purchNum);
		  itss.setPrNum(purchNum);
         
		  bookOrderDao.add(itss);
		}

    	ListItis listI = new ListItis();
    	listI.setListInvent(bookOrderDao.findByPR(purchNum));
    	
    	model.addAttribute("listI", listI);
    	
    	return "resultTiles";
	}
    
    */
    
    
    private Users getAuthName(){
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
           //String name = auth.getName(); //get logged in username
           Cust cust = custDao.findById(auth.getName());
           String name = cust.getName();
           model.addAttribute("username", name);
        
        2. User user = (User)SecurityContextHolder.getContext().getAuthentication().
        						getPrincipal();
      	   String name = user.getUsername(); //get logged in username
      	   model.addAttribute("username", name);
      	
      	3. //create a new session
      	   Object principal = SecurityContextHolder.getContext()
    		     .getAuthentication().getPrincipal();
    		HttpSession session = request.getSession(true); 
    		
    		session.setAttribute("userDetails", principal);
    	*/
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	Users users = usersDao.findById(auth.getName());
//        String name = cust.getName();
    return users;
    }

	public String getPurchNum() {
		return purchNum;
	}

	public void setPurchNum(String purchNum) {
		this.purchNum = purchNum;
	}
    
    
}
