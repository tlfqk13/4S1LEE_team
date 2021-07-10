package myPage.vo;

public class UseableRoomListSrcVO {
	private String roomTypename; 
	private String hotelName;
	
	public UseableRoomListSrcVO() {
		// TODO Auto-generated constructor stub
	}

	public UseableRoomListSrcVO(String roomTypename, String hotelName) {
		super();
		this.roomTypename = roomTypename;
		this.hotelName = hotelName;
	}

	public String getRoomTypename() {
		return roomTypename;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setRoomTypename(String roomTypename) {
		this.roomTypename = roomTypename;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	@Override
	public String toString() {
		return "UseableRoomListSrcVO [roomTypename=" + roomTypename + ", hotelName=" + hotelName + "]";
	}
	
	
	
}
