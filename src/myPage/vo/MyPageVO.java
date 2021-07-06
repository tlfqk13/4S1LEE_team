package myPage.vo;

public class MyPageVO {
	private String userID;
	private int reservationID;
	private int payID;
	private String review;
	
	public MyPageVO() {
	
	}
	
	

	public MyPageVO(String userID, int reservationID, int payID, String review) {
		super();
		this.userID = userID;
		this.reservationID = reservationID;
		this.payID = payID;
		this.review = review;
	}



	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public int getReservationID() {
		return reservationID;
	}

	public void setReservationID(int reservationID) {
		this.reservationID = reservationID;
	}

	public int getPayID() {
		return payID;
	}

	public void setPayID(int payID) {
		this.payID = payID;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	@Override
	public String toString() {
		return "MyPageVO [userID=" + userID + ", reservationID=" + reservationID + ", payID=" + payID + ", review="
				+ review + "]";
	}
	
	
	
}
