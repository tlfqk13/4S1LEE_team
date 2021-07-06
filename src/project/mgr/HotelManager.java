package project.mgr;


import java.util.ArrayList;

import hotel.dao.HotelDAO;
import hotel.dao.loginDAO;
import hotel.vo.HotelEventVO;
import hotel.vo.HotelInfoGetVO;
import hotel.vo.HotelInfoPrintVO;
import myPage.vo.HomeUserVO;


public class HotelManager {
	
	private HotelDAO dao = new HotelDAO();

	public ArrayList<HotelInfoPrintVO> hotelsearch(HotelInfoGetVO hotelInfoGet)  {
		ArrayList<HotelInfoPrintVO> list = dao.hotelsearch(hotelInfoGet);
		return list;
	}
	
	public ArrayList<HotelEventVO>ongoingEvent(String today){
		ArrayList<HotelEventVO> list = dao.ongoingEvent(today);
		return list;
		
	}

	public ArrayList<HotelEventVO> printAllEvent() {
		ArrayList<HotelEventVO> list = dao.printAllEvent();
		return list;
	}
	
}
