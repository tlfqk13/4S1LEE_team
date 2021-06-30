package hotel.vo;

public class HotelVO {
	
	private int hotelID;
	private String hotelName;
	private String hotelAddress;
	private String hotelGrade;
	private String hotelCity;
	
	public HotelVO() {
		
	}

	public int getHotelID() {
		return hotelID;
	}

	public void setHotelID(int hotelID) {
		this.hotelID = hotelID;
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

	public String getHotelCity() {
		return hotelCity;
	}

	public void setHotelCity(String hotelCity) {
		this.hotelCity = hotelCity;
	}

	@Override
	public String toString() {
		return "HotelVO [hotelID=" + hotelID + ", hotelName=" + hotelName + ", hotelAddress=" + hotelAddress
				+ ", hotelGrade=" + hotelGrade + ", hotelCity=" + hotelCity + "]";
	}
	
	
	
}
