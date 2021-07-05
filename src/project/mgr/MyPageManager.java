package project.mgr;

import java.util.List;

import hotel.dao.MyPageDAO;
import hotel.vo.ReservationVO;

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

}
