package hotel.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Map;

import hotel.vo.HotelEventVO;
import hotel.vo.HotelInfoGetVO;
import hotel.vo.HotelInfoPrintVO;
import hotel.vo.PayVO;
import hotel.vo.Reservation1VO;
import hotel.vo.ReservationVO;


public interface HotelMapper {
	public ArrayList<HotelInfoPrintVO> hotelsearch(HotelInfoGetVO hotelInfoGet) ;

	public ArrayList<HotelEventVO> ongoingEvent(String today);

	public ArrayList<HotelEventVO> printAllEvent();
	
	public ArrayList<HotelInfoPrintVO> selectByHotel (String HotelName);
	public int insertReservation (Reservation1VO reservation);

	public ArrayList<Reservation1VO> reservation1voList(String string);

	public int payInsert(PayVO vo);

	public void payUpdate(int reservationID);

	public void payUpdate2(int reservationID);

}