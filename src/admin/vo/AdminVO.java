package admin.vo;

public class AdminVO {
	private int managerNumber;
	private String managerPassword;
	private String managerID;
	
	public AdminVO() {
		
	}

	public int getManagerNumber() {
		return managerNumber;
	}

	public void setManagerNumber(int managerNumber) {
		this.managerNumber = managerNumber;
	}

	public String getManagerPassword() {
		return managerPassword;
	}

	public void setManagerPassword(String managerPassword) {
		this.managerPassword = managerPassword;
	}

	public String getManagerID() {
		return managerID;
	}

	public void setManagerID(String managerID) {
		this.managerID = managerID;
	}

	@Override
	public String toString() {
		return "AdminVO [managerNumber=" + managerNumber + ", managerPassword=" + managerPassword + ", managerID="
				+ managerID + "]";
	}
	
	
}
