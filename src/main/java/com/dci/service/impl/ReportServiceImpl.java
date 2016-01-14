/**
 * 
 */
package com.dci.service.impl;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRXhtmlExporter;

import com.dci.controller.ReportController;
import com.dci.dao.UsersDao;
import com.dci.model.Users;
import com.dci.service.ReportService;

/**
 * @author Administrator
 *
 */
@Service
public class ReportServiceImpl implements ReportService {
	
	private static final Logger logger = LoggerFactory.getLogger(ReportServiceImpl.class);

    @Autowired
	UsersDao usersDao;


	/* (non-Javadoc)
	 * @see com.spring.security.service.ReportService#pdfService()
	 */
	@Override
	public Map<String, Object> pdfService() {
		logger.debug("--------------generate PDF report----------");

        Map<String,Object> parameterMap = new HashMap<String,Object>();

        List<Users> usersList = usersDao.getAllUser();
        for (Users dep : usersList){
        	System.out.println(dep.getName());
        }
        JRDataSource JRdataSource = new JRBeanCollectionDataSource(usersList);

        parameterMap.put("datasource", JRdataSource);
//        @SuppressWarnings("deprecation")
//		String realPath = request.getRealPath("/coffee.jpg");
//        System.out.println(realPath);
//        @SuppressWarnings("deprecation")
//		File reportFile = new File(request.getRealPath("/coffee.jpg"));
       // System.out.println(reportFile);
        /*parameterMap.put("BaseDir", reportFile.getParent()); *///departmentService.getAppPath()
//        parameterMap.put("BaseDir", realPath); //departmentService.getAppPath()
        parameterMap.put("ReportTitle", "Address Report");
        
        /*File reportFile = new File(application.getRealPath("/reports/WebappReport.jasper"));
        if (!reportFile.exists())
    		throw new JRRuntimeException("File WebappReport.jasper not found. The report design must be compiled first.");

    	JasperReport jasperReport = (JasperReport)JRLoader.loadObject(reportFile.getPath());
        
        JasperPrint jasperPrint = 
        		JasperFillManager.fillReport(
        			jasperReport, 
        			parameters, 
        			new WebappDataSource()
        			);
        
        JRXhtmlExporter exporter = new JRXhtmlExporter();

    	exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
    	exporter.setParameter(JRExporterParameter.OUTPUT_WRITER, out);
    	exporter.setParameter(JRHtmlExporterParameter.IMAGES_URI, "../servlets/image?image=");
    	
    	exporter.exportReport();*/
        
		return parameterMap;
	}

	/* (non-Javadoc)
	 * @see com.spring.security.service.ReportService#xlsService()
	 */
	@Override
	public Map<String, Object> xlsService() {
		logger.debug("--------------generate XLS report----------");

        Map<String,Object> parameterMap = new HashMap<String,Object>();

        List<Users> usersList = usersDao.getAllUser();

        JRDataSource JRdataSource = new JRBeanCollectionDataSource(usersList);

        parameterMap.put("datasource", JRdataSource);
		return parameterMap;
	}

	/* (non-Javadoc)
	 * @see com.spring.security.service.ReportService#htmlService()
	 */
	@Override
	public Map<String, Object> htmlService() {
		 logger.debug("--------------generate HTML report----------");

	        Map<String,Object> parameterMap = new HashMap<String,Object>();

	        List<Users> usersList = usersDao.getAllUser();

	        JRDataSource JRdataSource = new JRBeanCollectionDataSource(usersList);

	        parameterMap.put("datasource", JRdataSource);
		return parameterMap;
	}

	/* (non-Javadoc)
	 * @see com.spring.security.service.ReportService#csvService()
	 */
	@Override
	public Map<String, Object> csvService() {
		 logger.debug("--------------generate CSV report----------");

	        Map<String,Object> parameterMap = new HashMap<String,Object>();

	        List<Users> usersList = usersDao.getAllUser();

	        JRDataSource JRdataSource = new JRBeanCollectionDataSource(usersList);

	        parameterMap.put("datasource", JRdataSource);
		return parameterMap;
	}

}
