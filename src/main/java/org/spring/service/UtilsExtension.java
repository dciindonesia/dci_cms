package org.spring.service;

import java.io.File;

public class UtilsExtension {

	    public final static String jpeg = "jpeg";
	    public final static String jpg = "jpg";
	    public final static String gif = "gif";
	    public final static String tiff = "tiff";
	    public final static String tif = "tif";
	    public final static String png = "png";

	    /*
	     * Get the extension of a file.
	     */  
	    public static String getExtension(File f) {
	        String ext = null;
	        String s = f.getName();
	        int i = s.lastIndexOf('.');

	        if (i > 0 &&  i < s.length() - 1) {
	            ext = s.substring(i+1).toLowerCase();
	        }
	        return ext;
	    }
	    
	    public boolean accept(File f) {
		    if (f.isDirectory()) {  
			    String extension = UtilsExtension.getExtension(f);
			    if (extension != null) {
			        if (extension.equals(UtilsExtension.tiff) ||
			            extension.equals(UtilsExtension.tif) ||
			            extension.equals(UtilsExtension.gif) ||
			            extension.equals(UtilsExtension.jpeg) ||
			            extension.equals(UtilsExtension.jpg) ||
			            extension.equals(UtilsExtension.png)) {
			            return true;
			        } else {
			            return false;
			        }
			    } else {
			    return false;
			    }
			} else {
		    	return false;
		    }
		}
	    
	    public boolean acceptImage(File f) {
	    	if (f.isDirectory()) {  
			    String extension = UtilsExtension.getExtension(f);
			    if (extension != null) {
			        if (extension.equals(UtilsExtension.tiff) ||
			            extension.equals(UtilsExtension.tif) ||
			            extension.equals(UtilsExtension.gif) ||
			            extension.equals(UtilsExtension.jpeg) ||
			            extension.equals(UtilsExtension.jpg) ||
			            extension.equals(UtilsExtension.png)) {
			            return true;
			        } else {
			            return false;
			        }
			    } else {
			    return false;
			    }
			} else {
		    	return false;
		    }
		}

}
