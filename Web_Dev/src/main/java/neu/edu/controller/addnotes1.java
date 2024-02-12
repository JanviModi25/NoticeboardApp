package neu.edu.controller;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import neu.edu.Models.NotesEntity;
import neu.edu.data.UserSession;

/**
 * Servlet implementation class addnotes1
 */
@WebServlet("/addnotes1")
public class addnotes1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addnotes1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		 HttpSession session = request.getSession();
			
		String notetitle = (String) session.getAttribute("notetitle");
		 if(notetitle!=null) {
			 NotesEntity Notes = null;
			 try {

					Class.forName("com.mysql.cj.jdbc.Driver");

					var conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/noticeboard", "root", "Jdm25@modi");

					var stmt = conn.createStatement();

					ResultSet RS = stmt.executeQuery("select * from noticeboard.notes where noticeName = '"+ notetitle +"'");
					
					 while(RS.next()){ 
				        	
				        	int id =RS.getInt("id");

				        	String notetitle1 = RS.getString("noticeName");
				        	String noticeBody = RS.getString("noticeBody");
				        	String CreatedBy  = RS.getString("CreatedBy");
				        	
				             Notes = new NotesEntity(id,notetitle1,noticeBody,CreatedBy);
				            
				            
				            
				             // prod.setProductname(rs.getString("product_pck"));
				                    
				    }

					} catch (Exception e) {

					e.printStackTrace();

					}
			 //Object Notes;
			request.setAttribute("Notes",Notes);
				
				RequestDispatcher rd=request.getRequestDispatcher("addnotes.jsp");    
				rd.forward(request,response); 
			 
		 }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		boolean success = false;

		String Createdby = "";

		String noticeName = request.getParameter("Title");
		String NoticeBody = request.getParameter("NoticeBody");
		
		HttpSession session = request.getSession();

		UserSession userSession =(UserSession)session.getAttribute("userSession");	
		
		if(userSession != null ) {
			
			Createdby =  userSession.getUsername();
		}
		else {
			
		}
		//add
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			var conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/noticeboard", "root", "Jdm25@modi");

			var stmt = conn.createStatement();

			int i = stmt.executeUpdate("insert into notices (noticeName,CreatedBy,noticeBody) values('"+noticeName+"','"+Createdby+"','"+NoticeBody+"')");
 
			

	       
	        
	        System.out.println();
	        

			System.out.println("Notice created!");
			
			response.sendRedirect("dashboard");

			} catch (Exception e) {

			e.printStackTrace();

			}
		
		
		

		
		//doGet(request, response);
	}

}
