package neu.edu.data;

public class UserSession {
	
	private String username;
	private String email;
	private String NoteTitle;

	
	
	public UserSession() {
		// TODO Auto-generated constructor stub
	}

	public UserSession(String username, String email) {
		super();
		this.username = username;
	
	}

	public UserSession(String username, String email,String noteTitle) {
		super();
		this.username = username;
		this.email = email;
		this.NoteTitle = noteTitle;
	}
	
	



	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getNoteTitle() {
		return NoteTitle;
	}

	public void setNoteTile(String Notetitle) {
		this.NoteTitle = Notetitle;
	}


public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}



public String getCurrentPage() {
	// TODO Auto-generated method stub
	return null;
}
	
	

}
