package hotel.vo;

public class RoomVO {
	private int roomID;
	private int hotelID;
	private String roomInfoString;
	private String bookingStatus;
	private String roomType;
	
	public RoomVO() {
		
	}
	public int getRoomID() {
		return roomID;
	}
	public void setRoomID(int roomID) {
		this.roomID = roomID;
	}
	public int getHotelID() {
		return hotelID;
	}
	public void setHotelID(int hotelID) {
		this.hotelID = hotelID;
	}
	public String getRoomInfoString() {
		return roomInfoString;
	}
	public void setRoomInfoString(String roomInfoString) {
		this.roomInfoString = roomInfoString;
	}
	public String getBookingStatus() {
		return bookingStatus;
	}
	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	@Override
	public String toString() {
		return "RoomVO [roomID=" + roomID + ", hotelID=" + hotelID + ", roomInfoString=" + roomInfoString
				+ ", bookingStatus=" + bookingStatus + ", roomType=" + roomType + "]";
	}
	
	
}
