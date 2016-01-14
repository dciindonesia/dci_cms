/**
 * 
 */
package com.dci.service;

import java.util.Map;

/**
 * @author Administrator
 *
 */
public interface ReportService {
	
	Map<String,Object> pdfService();
	Map<String,Object> xlsService();
	Map<String,Object> htmlService();
	Map<String,Object> csvService();
	
}
