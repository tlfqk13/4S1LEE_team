package myPage.vo;

public class UnBookingRoomVO {
	private int roomid;
	
	public UnBookingRoomVO() {
		// TODO Auto-generated constructor stub
	}
	
	public UnBookingRoomVO(int roomid) {
		super();
		this.roomid = roomid;
	}
	public int getRoomid() {
		return roomid;
	}

	public void setRoomid(int roomid) {
		this.roomid = roomid;
	}

	@Override
	public String toString() {
		return "UnBookingRoomVO [roomid=" + roomid + "]";
	}
	
	
}
