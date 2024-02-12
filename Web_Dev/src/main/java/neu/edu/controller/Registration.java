package neu.edu.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.xdevapi.Statement;

import neu.edu.dao.LoginDAO;
import neu.edu.data.UserRegistration;
import neu.edu.data.UserSession;

/**
 * Servlet implementation class Register
 */
@WebServlet(urlPatterns = {"/Registration","/registration"})
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registration() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd = request.getRequestDispatcher("registration.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//String username = request.getParameter("username");
		//String password = request.getParameter("password");
		//String email = request.getParameter("email");
		
//		UserRegistration userRegistration = new UserRegistration(username, password, email);
//		System.out.println("User Object - " + username + password + email);
//		
//		ServletContext application = request.getServletContext();
//		
//		ArrayList<UserRegistration> userRegistrations = (ArrayList<UserRegistration>) application.getAttribute("userRegistrations");
//		
//		if(userRegistrations == null) {
//			userRegistrations = new ArrayList<UserRegistration>();
//		}
//		
//		userRegistrations.add(userRegistration);
//		application.setAttribute("userRegistrations", userRegistrations);
//		
//		
		//new code
		//protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			boolean success = false;

			String firstName1 = request.getParameter("username");

			String password1 = request.getParameter("password");
			String email1 = request.getParameter("email");
			
			String lastName1 = request.getParameter("lastname");
			String role1 = request.getParameter("role");


			// Unsafe query which uses string concatenation

			//String query = "insert into tbluser (username,password) values ('"+username1+"','"+password1+"')";

			Connection conn = null;

			java.sql.Statement stmt = null;

			try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/noticeboard", "root", "Jdm25@modi");

			stmt = conn.createStatement();

			int i = stmt.executeUpdate("insert into user (firstName,LastName,Password,email,role) values ('"+firstName1+"', '"+lastName1+"', '"+password1+"', '"+email1+"', '"+role1+"')");
 
			

	       
	        
	        System.out.println();
	        

			//System.out.println("account created!");
			//HttpSession session = request.getSession();
			//UserSession userSession =  new UserSession(email1, email1);
			//session.setAttribute("userSession", userSession);
		     response.sendRedirect("login.jsp");

			} catch (Exception e) {

			e.printStackTrace();

			}
		// INSERT into MySQL
				//LoginDAO loginDAO = new LoginDAO();
				
				//UserSession user = loginDAO.validateLogin2("test", "test");
				//System.out.println("FROM DB  - " + user.getUsername() + " " + user.getEmail());
				
				
//				if(!loginDAO.insertUserData(userRegistration)) {
//					String errorMsg = "username already taken!";
//					request.setAttribute("errorMsg",errorMsg);
////					RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/registration.jsp");
//					RequestDispatcher rd = request.getRequestDispatcher("registration.jsp");
//					rd.forward(request, response);
//				} else {
////					RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/registrationStatus.jsp");
//					RequestDispatcher rd = request.getRequestDispatcher("registrationStatus.jsp");
//					rd.forward(request, response);
//				}
		
		//response.sendRedirect("login");
		
	}

}