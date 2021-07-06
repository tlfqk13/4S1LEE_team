package myPage.vo;

public class SearchHotelNameVO {
	private int roomID;
	private String hotelName;
	
	public SearchHotelNameVO() {
		// TODO Auto-generated constructor stub
	}

	public SearchHotelNameVO(int roomID, String hotelName) {
		super();
		this.roomID = roomID;
		this.hotelName = hotelName;
	}

	public int getRoomID() {
		return roomID;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setRoomID(int roomID) {
		this.roomID = roomID;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	@Override
	public String toString() {
		return "SearchHotelNameVO [roomID=" + roomID + ", hotelName=" + hotelName + "]";
	}
	
	
	
}
