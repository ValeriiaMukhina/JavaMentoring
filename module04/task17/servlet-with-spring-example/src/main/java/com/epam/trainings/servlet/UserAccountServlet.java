package com.epam.trainings.servlet;

import com.epam.trainings.dao.UserAccountDao;
import com.epam.trainings.domain.user.Player;
import com.epam.trainings.utils.DataUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.springframework.web.context.support.SpringBeanAutowiringSupport.processInjectionBasedOnServletContext;

public class UserAccountServlet extends HttpServlet {

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
		req.getRequestDispatcher("/home.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Copying all the input parameters in to local variables
		String username = request.getParameter("username");
		String birthday = request.getParameter("birthday");
		String account = request.getParameter("account");
		String currency = request.getParameter("currency");
		String balance = request.getParameter("balance");

		Player player = new Player();
		//Using Java Beans - An easiest way to play with group of related data
		player.setName(username);
		player.setDateOfBirth(DataUtils.getDate(birthday));
		player.setAccountNumber(account);
		player.setCurrency(DataUtils.getCurrency(currency));
		player.setBalance(Double.parseDouble(balance));

		UserAccountDao registerDao = new UserAccountDao();

		//The core Logic of the Registration application is present here. We are going to insert user data in to the database.
		String userRegistered = registerDao.registerUser(player);

		if(userRegistered.equals("SUCCESS"))   //On success, you can display a message to user on Home page
		{
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
		else   //On Failure, display a meaningful message to the User.
		{
			request.setAttribute("errMessage", userRegistered);
			request.getRequestDispatcher("/hello-spring.jsp").forward(request, response);
		}
	}

}
