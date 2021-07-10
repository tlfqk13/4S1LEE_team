package hotel.dao;

import java.util.List;

import hotel.vo.ReservationVO;
import myPage.vo.MyPageVO;
import myPage.vo.ReviewBoardVO;
import myPage.vo.SearchHotelNameVO;
import myPage.vo.ShowRooomTypeVO;
import myPage.vo.UnBookingRoomVO;
import myPage.vo.UseableRoomListSrcVO;
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
	
	public int reservationUpdateChangeRoomType(ReservationVO reservation);
	
	public List<ShowRooomTypeVO> showAvailableRoomByType(String hotelName);
	public List<UnBookingRoomVO> useableRoom(UseableRoomListSrcVO roomlist);
	
	public SearchHotelNameVO searchHotelName(int roomID);
	//public List<UnBookingRoomVO> showRoom(String changedRoomType);
	public List<ReservationVO> reservationListAll();
	
	
	public List<ReviewBoardVO> reviewList();
}
