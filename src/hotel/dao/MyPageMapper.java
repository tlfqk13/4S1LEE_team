package hotel.dao;

import java.util.List;

import hotel.vo.ReservationVO;
import myPage.vo.MyPageVO;
import myPage.vo.HomeUserVO;

public interface MyPageMapper {
	public int userInfoUpdate(HomeUserVO user);
	public ReservationVO selectOneReservation(int reservationID);
	public int reservationDelete(int reservationID);
	public int reservationUpdateChangeDate(ReservationVO reservation);
	public int reservationUpdateChangeRoomType(String roomType);
	public int reviewList(MyPageVO mypage);
	public List<ReservationVO> reservationList(String userID);
	public int deleteAccount(HomeUserVO user);
}
