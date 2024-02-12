package neu.edu.controller;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import neu.edu.Models.NotesEntity;
import neu.edu.Models.ReplyNotesEntity;
import neu.edu.data.UserSession;

/**
 * Servlet implementation class Dashboard
 */
@WebServlet("/dashboard")
public class Dashboard extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static List<NotesEntity> listofNotes = new ArrayList<NotesEntity>();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Dashboard() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession session = request.getSession();
		UserSession userSession = (UserSession) session.getAttribute("userSession");
		var UserEmail = userSession.getUsername();

		if (UserEmail == null) {
			response.sendRedirect("login.jsp");
		}

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			var conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/noticeboard", "root", "Jdm25@modi");

			var stmt = conn.createStatement();

			ResultSet RSUser = stmt.executeQuery("select role from  noticeboard.user where email ='" + UserEmail + "'");
			String roleosstudent = "";
			while (RSUser.next()) {
				roleosstudent = RSUser.getString("role");

			}
			// ResultSet RS = null;
			// if(roleosstudent.toLowerCase() == "professor")
			// {
			ResultSet RS = stmt.executeQuery("Select * from noticeboard.notices");

			// }
			// else {
			// RS = stmt.executeQuery("Select * from noticeboard.notices where Createdby
			// ='"+UserEmail +"'");

			// }

			// int i = stmt.executeUpdate("update into user
			// (firstName,LastName,Password,email,role) values ('"+firstName+"',
			// '"+lastName+"', '"+newPassword+"', '"+email+"')");

			// update noticeboard.user set firstName = "" , lastName = "", password = "",
			// email = ""

			System.out.println(RS.getMetaData());
			// ResultSet rs = stmt.getResultSet();

			while (RS.next()) {

				int id = RS.getInt("id");

				String notetitle = RS.getString("noticeName");
				String noticeBody = RS.getString("noticeBody");
				String CreatedBy = RS.getString("CreatedBy");
				// ResultSet RSReply = stmt.executeQuery("SELECT * FROM noticeboard.repliednotes
				// where notesid ='"+id +"'");

				List<ReplyNotesEntity> Repliednotes = ListOfNotes(id);
				NotesEntity Notes = new NotesEntity(id, notetitle, noticeBody, CreatedBy, Repliednotes);

				// prod.setProductname(rs.getString("product_pck"));
				listofNotes.add(Notes);
			}

			System.out.println("All the notes has been fetched");

			// System.out.println("account created!");
			// HttpSession session = request.getSession();
			// UserSession userSession = new UserSession(email1, email1);
			// session.setAttribute("userSession", userSession);
			// response.sendRedirect("dashboard.jsp");

		} catch (Exception e) {

			e.printStackTrace();

		}
		// if(request.getAttribute("listOfNotes") != null) {
		// request.removeAttribute("listOfNotes")
		// ;}

		String x = String.valueOf(Math.random());

		request.setAttribute("Random", x);

		// request.removeAttribute("List");
		request.setAttribute(x, listofNotes);
		// RequestDispatcher rd=request.getRequestDispatcher("dashboard.jsp");

		// response.sendRedirect("dashboard.jsp");
		// rd.forward(request,response);

		request.getRequestDispatcher("/dashboard.jsp").include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		// update
		if (request.getParameter("update") != null) {
			var notetitle = request.getParameter("noticetitle");

			HttpSession session = request.getSession();

			session.setAttribute("notetitle", notetitle);
			response.sendRedirect("addnotes.jsp");

		} else if (request.getParameter("delete") != null) {
			var notetitle = request.getParameter("noticetitle");

			try {

				Class.forName("com.mysql.cj.jdbc.Driver");

				var conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/noticeboard", "root", "Jdm25@modi");

				var stmt = conn.createStatement();
				// delete
				int RSUser = stmt.executeUpdate("delete from notices where noticeName ='" + notetitle + "'");
				String roleosstudent = "";
			} catch (Exception e) {

				e.printStackTrace();

			}
			response.sendRedirect("dashboard");

		}
		// Reply
		else if (request.getParameter("reply") != null) {
			// int id=RSUser.getInt("id");//
			String notetitle = request.getParameter("noticetitle");
			var reply = request.getParameter("sentence");

			try {

				Class.forName("com.mysql.cj.jdbc.Driver");

				var conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/noticeboard", "root", "Jdm25@modi");

				var stmt = conn.createStatement();

				ResultSet RSUser = stmt.executeQuery("select * from notices where noticeName ='" + notetitle + "'");
				int id=0;
				while (RSUser.next()) {
					 id = RSUser.getInt("id");

				}
				HttpSession session = request.getSession();
				UserSession userSession = (UserSession) session.getAttribute("userSession");
				var UserEmail = userSession.getUsername();

				int insertRepliedData = stmt.executeUpdate("insert into repliednotes(notesid,reply,createdby)values ('"
						+ id + "','" + reply + "','" + UserEmail + "')");

			} catch (Exception e) {

				e.printStackTrace();

			}

			doGet(request, response);
			// response.sendRedirect("dashboard");
		}

	}

	public List<ReplyNotesEntity> ListOfNotes(int id) {
		List<ReplyNotesEntity> Repliednotes = new ArrayList();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			var conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/noticeboard", "root", "Jdm25@modi");

			var stmt = conn.createStatement();

			ResultSet RSReply = stmt
					.executeQuery("SELECT * FROM noticeboard.repliednotes where  notesid ='" + id + "'");

			while (RSReply.next()) {
				int replyid = RSReply.getInt("id");
				int notesid = RSReply.getInt("notesid");
				String reply = RSReply.getString("reply");
				String Createdby = RSReply.getString("createdby");

				ReplyNotesEntity replies = new ReplyNotesEntity(replyid, notesid, reply, Createdby);
				Repliednotes.add(replies);
			}

		} catch (Exception e) {

			e.printStackTrace();
		}
		return Repliednotes;

	}
}
