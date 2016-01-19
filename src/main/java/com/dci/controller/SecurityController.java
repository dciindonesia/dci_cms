package com.dci.controller;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dci.dao.UsersDao;
import com.dci.model.Users;

@Controller
@RequestMapping("/main")
public class SecurityController {
protected static Logger logger = Logger.getLogger("controller");
	@Autowired
	UsersDao usersDao;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		
	    String username = request.getParameter("username");
	    //String password = request.getParameter("password");
	    Users user = usersDao.findByName(username);
	    if (user != null) {
	        request.getSession().setAttribute("user", user); 
	        response.sendRedirect("home");
	    } else {
	        request.setAttribute("message", "Unknown username/password combo.");
	        request.getRequestDispatcher("login").forward(request, response);
	    }
	}
	
}
