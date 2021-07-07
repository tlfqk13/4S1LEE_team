package hotel.vo;

public class ReservationVO {
	private int reservationID;
	private int roomID;
	private String userID;
	private String checkInDate;
	private String checkOutDate;
	private int guestCount;
	
	public ReservationVO() {
		
	}

	public int getReservationID() {
		return reservationID;
	}

	public void setReservationID(int reservationID) {
		this.reservationID = reservationID;
	}

	public int getRoomID() {
		return roomID;
	}

	public void setRoomID(int roomID) {
		this.roomID = roomID;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getCheckInDate() {
		return checkInDate;
	}

	public void setCheckInDate(String checkInDate) {
		this.checkInDate = checkInDate;
	}

	public String getCheckOutDate() {
		return checkOutDate;
	}

	public void setCheckOutDate(String checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

	public int getGuestCount() {
		return guestCount;
	}

	public void setGuestCount(int guestCount) {
		this.guestCount = guestCount;
	}
	
	@Override
	public String toString() {
		return "ReservationVO [reservationID=" + reservationID + ", roomID=" + roomID + ", userID=" + userID
				+ ", checkInDate=" + checkInDate + ", checkOutDate=" + checkOutDate + ", guestCount=" + guestCount
				+ "]";
	}


	
	
}
