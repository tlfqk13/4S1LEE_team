package hotel.vo;

public class HotelInfoPrintVO {
	private String hotelName;
	private String hotelAddress;
	private String hotelGrade;
	private String roomTypeName;
	
	private String roomID;
	
	//test 용도
	private String hotelCity;
	
	private int maxPeople;
	
	
	
	public int getMaxPeople() {
		return maxPeople;
	}
	public void setMaxPeople(int maxPeople) {
		this.maxPeople = maxPeople;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public String getHotelAddress() {
		return hotelAddress;
	}
	public void setHotelAddress(String hotelAddress) {
		this.hotelAddress = hotelAddress;
	}
	public String getHotelGrade() {
		return hotelGrade;
	}
	public void setHotelGrade(String hotelGrade) {
		this.hotelGrade = hotelGrade;
	}
	public String getRoomTypeName() {
		return roomTypeName;
	}
	public void setRoomTypeName(String roomTypeName) {
		this.roomTypeName = roomTypeName;
	}
	public String getHotelCity() {
		return hotelCity;
	}
	public void setHotelCity(String hotelCity) {
		this.hotelCity = hotelCity;
	}
	
	public String getRoomID() {
		return roomID;
	}
	public void setRoomID(String roomID) {
		this.roomID = roomID;
	}
	
	@Override
	public String toString() {
		return "HotelInfoPrintVO [hotelName=" + hotelName + ", hotelAddress=" + hotelAddress + ", hotelGrade="
				+ hotelGrade + ", roomTypeName=" + roomTypeName + ", hotelCity=" + hotelCity + ", maxPeople="
				+ maxPeople + "]";
	}


}
