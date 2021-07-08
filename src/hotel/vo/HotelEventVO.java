package hotel.vo;

public class HotelEventVO {
 private String eventTitle;
 private String eventContent;
 private String startDate;
 private String endDate;
 private int eventDiscount;
 
 
public String getEventTitle() {
	return eventTitle;
}
public void setEventTitle(String eventTitle) {
	this.eventTitle = eventTitle;
}
public String getEventContent() {
	return eventContent;
}
public void setEventContent(String eventContent) {
	this.eventContent = eventContent;
}
public String getStartDate() {
	return startDate;
}
public void setStartDate(String startDate) {
	this.startDate = startDate;
}
public String getEndDate() {
	return endDate;
}
public void setEndDate(String endDate) {
	this.endDate = endDate;
}
public int geteventDiscount() {
	return eventDiscount;
}
public void seteventDiscount(int discount) {
	this.eventDiscount = discount;
}

}
