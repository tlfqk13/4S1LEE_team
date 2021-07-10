package myPage.vo;

public class ReviewBoardVO {
	
	private int reviewID;
	private String userID;
	private int reservationID;
	private int starRating;
	private String title;
	private String contents;
	private String reviewDate;
	
	public ReviewBoardVO() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public ReviewBoardVO(int reviewID, String userID, int reservationID, int starRating, String title, String contents,
			String reviewDate) {
		super();
		this.reviewID = reviewID;
		this.userID = userID;
		this.reservationID = reservationID;
		this.starRating = starRating;
		this.title = title;
		this.contents = contents;
		this.reviewDate = reviewDate;
	}



	public int getReviewID() {
		return reviewID;
	}
	public void setReviewID(int reviewID) {
		this.reviewID = reviewID;
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
	public int getStarRating() {
		return starRating;
	}
	public void setStarRating(int starRating) {
		this.starRating = starRating;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getReviewDate() {
		return reviewDate;
	}
	public void setReviewDate(String reviewDate) {
		this.reviewDate = reviewDate;
	}
	@Override
	public String toString() {
		return "ReviewBoardVO [reviewID=" + reviewID + ", userID=" + userID + ", reservationID=" + reservationID
				+ ", starRating=" + starRating + ", title=" + title + ", contents=" + contents + ", reviewDate="
				+ reviewDate + "]";
	}

}
