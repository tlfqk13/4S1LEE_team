package myPage.vo;

public class UserGradeVO {
	private String userGrade;
	private String userID;
	
	public UserGradeVO() {
		
	}

	public String getUserGrade() {
		return userGrade;
	}

	public void setUserGrade(String userGrade) {
		this.userGrade = userGrade;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	@Override
	public String toString() {
		return "UserGradeVO [userGrade=" + userGrade + ", userID=" + userID + "]";
	}
	
	
}
