package myPage.vo;

public class HomeUserVO {
	private String userID;
	private String userPassword;
	private String userEmail;
	private String userPhone;
	private String userName;
	private String userBirth;
	private String userGrade;
	
	public HomeUserVO() {
		
	}
	
	


	public HomeUserVO(String userID, String userPassword, String userEmail, String userPhone, String userName,
			String userBirth, String userGrade) {
		super();
		this.userID = userID;
		this.userPassword = userPassword;
		this.userEmail = userEmail;
		this.userPhone = userPhone;
		this.userName = userName;
		this.userBirth = userBirth;
		this.userGrade = userGrade;
	}




	public HomeUserVO(String userId, String userPassword, String userPhone, 
			String userEmail, String userName,String userBirth) {
		this.userID=userId;
		this.userPassword=userPassword;
		this.userPhone=userPhone;
		this.userEmail=userEmail;
		this.userName=userName;
		this.userBirth=userBirth;
	}
	
	public HomeUserVO(String usedId) {
		this.userID=usedId;
	}


	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserBirth() {
		return userBirth;
	}

	public void setUserBirth(String userBirth) {
		this.userBirth = userBirth;
	}

	public String getUserGrade() {
		return userGrade;
	}

	public void setUserGrade(String userGrade) {
		this.userGrade = userGrade;
	}

	@Override
	public String toString() {
		return "UserVO [userID=" + userID + ", userPassword=" + userPassword
				+ ", userEmail=" + userEmail + ", userPhone=" + userPhone + ", userName=" + userName + ", userBirth="
				+ userBirth + ", userGrade=" + userGrade + "]";
	}
	
	
	
}
