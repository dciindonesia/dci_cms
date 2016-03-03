<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags" %>

<%! String scid=""; %>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
	<link href="./resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="./resources/bootstrap/css/bootstrap-theme.min.css" rel="stylesheet">
    <link href="./resources/bootstrap/css/customcss.css" rel="stylesheet">
    
    <script type="text/javascript" src="./resources/bootstrap/js/jquery-1.11.3.min.js" ></script> 
    <script type="text/javascript" src="./resources/bootstrap/js/bootstrap.min.js"></script>       
    <script type="text/javascript" src="./resources/bootstrap/js/custom.js"></script>
	<title><tiles:insertAttribute name="title" ignore="true" /></title>
	<link href="./resources/bootstrap/css/freelancer.css" rel="stylesheet" >
</head>
</html>