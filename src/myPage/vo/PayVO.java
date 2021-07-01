package myPage.vo;

public class PayVO {
	private int payID;
	private int reservationID;
	private String payDay;
	private String payType;
	private String payStatus;
	
	public PayVO() {
		
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

	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
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
				+ payType + ", payStatus=" + payStatus + "]";
	}
	
	
}
