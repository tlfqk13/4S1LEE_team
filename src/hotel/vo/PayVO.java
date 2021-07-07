package hotel.vo;

public class PayVO {
	
	private int payID;
	private int reservationID;
	private String payDay;	
	private int payTypeID;
	private String payStatus;

	public PayVO() {
		
	}
	public PayVO(int reservationID, int payTypeID, String payStatus) {
		this.reservationID=reservationID;
//		this.payDay=payDay;
		this.payTypeID=payTypeID;
		this.payStatus=payStatus;
	}
	public int getPayID() {
		return payID;
	}
	public void setPayID(int payID) {
		this.payID = payID;
	}
	public int getReservationID() {
		return reservationID;
	}
	public void setReservationID(int reservationID) {
		this.reservationID = reservationID;
	}
	public String getPayDay() {
		return payDay;
	}
	public void setPayDay(String payDay) {
		this.payDay = payDay;
	}
	public int getPayType() {
		return payTypeID;
	}
	public void setPayType(int payTypeID) {
		this.payTypeID = payTypeID;
	}
	public String getPayStatus() {
		return payStatus;
	}
	public void setPayStatus(String payStatus) {
		this.payStatus = payStatus;
	}
	
	@Override
	public String toString() {
		return "PayVO [payID=" + payID + ", reservationID=" + reservationID + ", payDay=" + payDay + ", payType="
				+ payTypeID + ", payStatus=" + payStatus + "]";
	}


}
