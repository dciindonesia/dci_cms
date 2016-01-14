package com.dci.controller;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dci.dao.UsersDao;
import com.dci.model.Users;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;



@Controller
@RequestMapping("/report/")
public class ReportController {


    private static final Logger logger = LoggerFactory.getLogger(ReportController.class);

    @Autowired
	UsersDao usersDao;;
    
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value= "pdfhtml", method=RequestMethod.GET)
    public ModelAndView PdfHtmlReport(HttpServletRequest request, ModelAndView modelAndView){
    	logger.debug("--------------HTML PDF report----------");
    	
    	InputStream inputStream = null;
    	JasperDesign jasperDesign = null;
    	JasperReport jasperReport = null;
    	JasperPrint jasperPrint = null;

    	//Map<String,Object> parameterMap = new HashMap<String,Object>();
    	List<Users> usersList = usersDao.getAllUser();
    	
    	for (Users dep : usersList){
    		System.out.println(dep.getName());
    	}

    	JRDataSource JRdataSource = new JRBeanCollectionDataSource(usersList);
		Map parameters = new HashMap();

    	try {
			inputStream = new FileInputStream ("WEB-INF/reports/BookingOrder.jrxml");
			jasperDesign = JRXmlLoader.load(inputStream);
			jasperReport = JasperCompileManager.compileReport(jasperDesign);
			jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, JRdataSource);
			JasperExportManager.exportReportToPdfFile(jasperPrint, "src/test_jasper.pdf");
		} catch (Exception e) {
			logger.debug(String.valueOf(e));
			e.printStackTrace();
		}
    	
    	modelAndView = new ModelAndView("commoncrot");

        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.GET , value = "pdf")
    public ModelAndView generatePdfReport(HttpServletRequest request, ModelAndView modelAndView){

        logger.debug("--------------generate PDF report----------");

        Map<String,Object> parameterMap = new HashMap<String,Object>();

        List<Users> usersList = usersDao.getAllUser();
        for (Users dep : usersList){
        	System.out.println(dep.getName());
        }
        JRDataSource JRdataSource = new JRBeanCollectionDataSource(usersList);

        parameterMap.put("datasource", JRdataSource);
        @SuppressWarnings("deprecation")
		String realPath = request.getRealPath("/coffee.jpg");
        System.out.println(realPath);
        @SuppressWarnings({ "deprecation", "unused" })
		File reportFile = new File(request.getRealPath("/coffee.jpg"));
       // System.out.println(reportFile);
        /*parameterMap.put("BaseDir", reportFile.getParent()); *///departmentService.getAppPath()
        parameterMap.put("BaseDir", realPath); //departmentService.getAppPath()
        parameterMap.put("ReportTitle", "Address Report");

        //pdfReport bean has ben declared in the jasper-views.xml file
        modelAndView = new ModelAndView("pdfReport", parameterMap);

        return modelAndView;

    }//generatePdfReport



    @RequestMapping(method = RequestMethod.GET , value = "xls")
    public ModelAndView generateXlsReport(ModelAndView modelAndView){

        logger.debug("--------------generate XLS report----------");

        Map<String,Object> parameterMap = new HashMap<String,Object>();

        List<Users> usersList = usersDao.getAllUser();

        JRDataSource JRdataSource = new JRBeanCollectionDataSource(usersList);

        parameterMap.put("datasource", JRdataSource);

        //xlsReport bean has ben declared in the jasper-views.xml file
        modelAndView = new ModelAndView("xlsReport", parameterMap);

        return modelAndView;

    }//generatePdfReport


    @RequestMapping(method = RequestMethod.GET , value = "csv")
    public ModelAndView generateCsvReport(ModelAndView modelAndView){

        logger.debug("--------------generate CSV report----------");

        Map<String,Object> parameterMap = new HashMap<String,Object>();

        List<Users> usersList = usersDao.getAllUser();

        JRDataSource JRdataSource = new JRBeanCollectionDataSource(usersList);

        parameterMap.put("datasource", JRdataSource);

        //xlsReport bean has ben declared in the jasper-views.xml file
        modelAndView = new ModelAndView("csvReport", parameterMap);

        return modelAndView;

    }//generatePdfReport



    @RequestMapping(method = RequestMethod.GET , value = "html")
    public ModelAndView generateHtmlReport(ModelAndView modelAndView){

        logger.debug("--------------generate HTML report----------");

        Map<String,Object> parameterMap = new HashMap<String,Object>();

        List<Users> usersList = usersDao.getAllUser();

        JRDataSource JRdataSource = new JRBeanCollectionDataSource(usersList);

        parameterMap.put("datasource", JRdataSource);

        //xlsReport bean has ben declared in the jasper-views.xml file
        modelAndView = new ModelAndView("htmlReport", parameterMap);

        return modelAndView;

    }//generatePdfReport


}//ReportController
