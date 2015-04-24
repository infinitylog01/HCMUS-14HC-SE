package hcmus14hc.cnpm.airplaneticket.pojo;

public class UserEntity {
	public static enum ROLE {MANAGER, ADMINISTRATOR, TICKET_OFFICER};
	
	private ROLE role;
	private String uID;
	private String userName;
	
	public UserEntity(int argRole, String argUID, String argName) {
		switch (argRole) {
		case 1:
			this.role = ROLE.MANAGER;
			break;
		case 2:
			this.role = ROLE.ADMINISTRATOR;
			break;
		case 3:
			this.role = ROLE.TICKET_OFFICER;
			break;
		default:
			break;
		}
		this.uID = argUID;
		this.userName = argName;
	}

	public ROLE getRole() {
		return role;
	}

	public String getuID() {
		return uID;
	}

	public String getUserName() {
		return userName;
	}
}
