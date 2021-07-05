package hotel.dao;

import java.util.List;

import hotel.vo.ReservationVO;
import myPage.vo.HomeUserVO;
import myPage.vo.MyPageVO;
import myPage.vo.ReviewBoardVO;
import myPage.vo.SearchHotelNameVO;
import myPage.vo.ShowRooomTypeVO;
import myPage.vo.UnBookingRoomVO;

public interface MyPageMapper {
	public int userInfoUpdate(HomeUserVO user);
	public ReservationVO selectOneReservation(int reservationID);
	public int reservationDelete(int reservationID);
	public int reservationUpdateChangeDate(ReservationVO reservation);
	public int reservationUpdateChangeRoomType(String roomType);
	public int reservationUpdateChangeRoomType(ReservationVO reservation);
	
	public List<ShowRooomTypeVO> showAvailableRoomByType(String hotelName);
	public SearchHotelNameVO searchHotelName(int roomID);
	public List<UnBookingRoomVO> showRoom(String changedRoomType);
	
	public int reviewList(MyPageVO mypage);
	public List<ReviewBoardVO> reviewList();
	public List<ReservationVO> reservationList(String userID);
	public int deleteAccount(HomeUserVO user);
}
