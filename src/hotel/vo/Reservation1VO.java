package hotel.vo;

public class Reservation1VO {
	private String userID;
	private int roomID;
	
	private int reservationID;
	private String checkInDate;
	private String checkOutDate;
	private int guestCount;
	
	public int getReservationID() {
		return reservationID;
	}
	public void setReservationID(int reservationID) {
		this.reservationID = reservationID;
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
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public int getRoomID() {
		return roomID;
	}
	public void setRoomID(int roomID) {
		this.roomID = roomID;
	}
	@Override
	public String toString() {
		return "Reservation1VO [userID=" + userID + ", roomID=" + roomID + ", reservationID=" + reservationID
				+ ", checkInDate=" + checkInDate + ", checkOutDate=" + checkOutDate + ", guestCount=" + guestCount
				+ "]";
	}

}

