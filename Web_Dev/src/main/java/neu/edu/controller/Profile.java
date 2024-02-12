package neu.edu.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import neu.edu.data.UserSession;

/**
 * Servlet implementation class Profile
 */
@WebServlet("/profile")
public class Profile extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private  String UserEmail = "";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Profile() {
    	
    	
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		UserSession userSession = (UserSession)session.getAttribute("userSession");
		UserEmail = userSession.getUsername();
		
		request.getRequestDispatcher("/WEB-INF/profile.jsp").forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		boolean success = false;

		String firstName = request.getParameter("firstName");

		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		
		String ConfirmPassword = request.getParameter("confirm_password");
		String newPassword = request.getParameter("password");
		
		doGet(request, response);
		
		Connection conn = null;

		java.sql.Statement stmt = null;
		
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/noticeboard", "root", "Jdm25@modi");

			stmt = conn.createStatement();

			//int i = stmt.executeUpdate("update into user (firstName,LastName,Password,email,role) values ('"+firstName+"', '"+lastName+"', '"+newPassword+"', '"+email+"')");
			
			int i = stmt.executeUpdate("update noticeboard.user set firstName = '"+firstName+"'  , lastName = '"+lastName+"', password = '"+newPassword+"', email = '"+email+"' where email = '"+UserEmail+"' ");

 
			
             //update noticeboard.user set firstName = "" , lastName = "", password = "", email = "" 
	       
	        
	        System.out.println("Profile details has been updated");
	        

			//System.out.println("account created!");
			//HttpSession session = request.getSession();
			//UserSession userSession =  new UserSession(email1, email1);
			//session.setAttribute("userSession", userSession);
		     response.sendRedirect("dashboard.jsp");

			} catch (Exception e) {

			e.printStackTrace();

			}
	}

}
