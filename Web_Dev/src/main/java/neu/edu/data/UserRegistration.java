package neu.edu.data;

public class UserRegistration {
	private String username;
	private String password;
	private String email;
	public UserRegistration() {
		// TODO Auto-generated constructor stub
	}
	
	
	public UserRegistration(String username, String password, String email) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
	}


	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	


}