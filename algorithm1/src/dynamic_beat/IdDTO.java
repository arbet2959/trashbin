package dynamic_beat;

public class IdDTO {
	private String id;
	private String password;
	private int age;
	private String email;
	private boolean admin;
	private boolean certification;
	
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public boolean isAdmin() {
		return admin;
	}
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	public boolean isCertification() {
		return certification;
	}
	public void setCertification(boolean certification) {
		this.certification = certification;
	}
}
