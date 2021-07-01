package hotel.vo;

public class HotelGradeVO {
	private int hotelGradeID;
	private String hotelGrade;
	
	public HotelGradeVO() {
		
	}

	public int getHotelGradeID() {
		return hotelGradeID;
	}

	public void setHotelGradeID(int hotelGradeID) {
		this.hotelGradeID = hotelGradeID;
	}

	public String getHotelGrade() {
		return hotelGrade;
	}

	public void setHotelGrade(String hotelGrade) {
		this.hotelGrade = hotelGrade;
	}

	@Override
	public String toString() {
		return "HotelGradeVO [hotelGradeID=" + hotelGradeID + ", hotelGrade=" + hotelGrade + "]";
	}
	
	
}
