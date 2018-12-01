package com.epam.trainings.servletwithspring.servlet;

import static org.springframework.web.context.support.SpringBeanAutowiringSupport.processInjectionBasedOnServletContext;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

public class HelloSpringServlet extends HttpServlet {

	@Autowired
	private String message;
	
	
    @Override
	public void init() throws ServletException {
    	super.init();
    	processInjectionBasedOnServletContext(this, getServletContext());
    	
	}
    
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("message", message);
		req.getRequestDispatcher("/hello-spring.jsp").forward(req, resp);
	}

}
