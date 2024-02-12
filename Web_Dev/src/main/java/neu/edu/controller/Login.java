package neu.edu.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import neu.edu.data.UserRegistration;
import neu.edu.data.UserSession;

/**
 * Servlet implementation class Login
 */
@WebServlet(
		urlPatterns =  {"/Login","/login"},
		initParams = {@WebInitParam(name = "user1@gmail.com",value = "pass1")}
)
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
		requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//String username = request.getParameter("username");
		//String password = request.getParameter("password");
		
		
		ServletContext application = request.getServletContext();
		
		//ArrayList<UserRegistration> userRegistrations = (ArrayList<UserRegistration>) application.getAttribute("userRegistrations");
		
		

		//Connection conn;
		/*try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/noticeboard", "root", "Jdm25@modi");
			var stmt = conn.createStatement();

			ResultSet i = stmt.executeQuery("select * from students");
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
//--------------------------------------------------------------------
		boolean loginStatus = false;
		String username = request.getParameter("username");

		String password = request.getParameter("password");
		
		HttpSession session = request.getSession();
		if(session!=null) {
			session.removeAttribute("userSession");
		}
		UserSession userSession =  new UserSession(username, username);

		

		// Unsafe query which uses string concatenation

		String query = "select * from user where email='" + username + "' and password = '" + password + "'";

		Connection conn = null;

		//statement stmt= null;
		Statement stmt = null;

		try {

		Class.forName("com.mysql.cj.jdbc.Driver");

		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/noticeboard", "root", "Jdm25@modi");

		 stmt = conn.createStatement();

		ResultSet rs = stmt.executeQuery(query);

		if (rs.next()) {

		// Login Successful if match is found

			loginStatus = true;

		}

		} catch (Exception e) {

		e.printStackTrace();

		} finally {

		try {

		stmt.close();

		conn.close();

		} catch (Exception e) {}

		}

		if (loginStatus) {
			
			session.setAttribute("userSession", userSession);
		response.sendRedirect("dashboard");

		} else {

request.setAttribute("errorMsg",errorMsg);
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
			requestDispatcher.forward(request, response);

		}

		}	
//--------------------------------------------------------------------
	

		
		//boolean loginStatus = false;
		String errorMsg = "Error: Invalid username or password";
		
		/*if(userRegistrations!=null) {
			for(UserRegistration userRegistration:userRegistrations) {
				
				if(username.equals(userRegistration.getUsername()) && password.equals(userRegistration.getPassword())) {
					HttpSession session = request.getSession();
					UserSession userSession =  new UserSession(userRegistration.getUsername(), userRegistration.getEmail());
					session.setAttribute("userSession", userSession);
					
					loginStatus = true;
					break;
				}
			}
		}else {
			errorMsg = "Error: Invalid username or password";
		}*/
		
		/*if(loginStatus) {
			response.sendRedirect("dashboard");

		}else {
			
			request.setAttribute("errorMsg",errorMsg);
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
			requestDispatcher.forward(request, response);
		}*/

		
	}

