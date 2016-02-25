package _00_Account.model;

public class RoleBean {
	private String role_ID;
	private String role_Name;
	
	public RoleBean(){}

	public RoleBean(String role_ID,
			String role_Name) {
		super();
		this.role_ID = role_ID;
		this.role_Name = role_Name;
	}
	
	@Override
	public String toString() {
		return "RoleBean [role_ID=" + role_ID + ", role_Name=" + role_Name + "]";
	}

	public String getRole_ID() {
		return role_ID;
	}

	public void setRole_ID(String role_ID) {
		this.role_ID = role_ID;
	}

	public String getRole_Name() {
		return role_Name;
	}

	public void setRole_Name(String role_Name) {
		this.role_Name = role_Name;
	}
	
}
