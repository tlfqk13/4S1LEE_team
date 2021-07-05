package hotel.dao;

import java.time.LocalDate;
import java.util.ArrayList;

import hotel.vo.HotelEventVO;
import hotel.vo.HotelInfoGetVO;
import hotel.vo.HotelInfoPrintVO;


public interface HotelMapper {
	public ArrayList<HotelInfoPrintVO> hotelsearch(HotelInfoGetVO hotelInfoGet) ;

	public ArrayList<HotelEventVO> ongoingEvent(String today);

	public ArrayList<HotelEventVO> printAllEvent();
}
