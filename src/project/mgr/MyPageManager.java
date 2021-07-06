package project.mgr;

import java.util.List;

import hotel.dao.MyPageDAO;
import hotel.vo.ReservationVO;
import myPage.vo.HomeUserVO;
import myPage.vo.ReviewBoardVO;
import myPage.vo.SearchHotelNameVO;
import myPage.vo.ShowRooomTypeVO;
import myPage.vo.UnBookingRoomVO;

public class MyPageManager {
	MyPageDAO myPagedao = new MyPageDAO();
	public int reservationDelete(int reservationID) {
		int result = myPagedao.reservationDelete(reservationID);
		return result;
	}
	public List<ReservationVO> reservationList(String userid) {
		List<ReservationVO> list = myPagedao.reservationList(userid);
		return list;
	}
	public ReservationVO selectOneReservation(int reservationid) {
		ReservationVO reservation = myPagedao.selectOneReservation(reservationid);
		return reservation;
	}
	

	public int reservationUpdateChangeDate(ReservationVO changeDate) {
		int result = myPagedao.reservationUpdateChangeDate(changeDate);
		return result;
	}
	public SearchHotelNameVO searchHotelName(int roomID) {
		SearchHotelNameVO result = myPagedao.searchHotelName(roomID);
		return result;
	}
	public List<ShowRooomTypeVO> showAvailableRoomByType(String hotelName) {
		List<ShowRooomTypeVO> list = myPagedao.showAvailableRoomByType(hotelName);
		return list;
	}
	public List<UnBookingRoomVO> showRoom(String changedRoomType) {
		List<UnBookingRoomVO> list = myPagedao.showRoom(changedRoomType);
		return list;
	}
	public int reservationUpdateChangeRoomType(ReservationVO update) {
		int result = myPagedao.reservationUpdateChangeRoomType(update);
		return result;
	}
	public boolean deleteAccount(HomeUserVO deleteUser) {
		return myPagedao.deleteAccount(deleteUser) > 0 ? true : false;
	}
	// ȸ�� ����
	public boolean userInfoUpdate(HomeUserVO user) {
		return myPagedao.userInfoUpdate(user) > 0 ? true : false;
	}
		
		// ���� ���
	public List<ReviewBoardVO> reviewList(){
		List<ReviewBoardVO> list1 = myPagedao.reviewList();
		return list1;
	}

}
