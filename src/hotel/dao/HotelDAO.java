package hotel.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import hotel.vo.HotelEventVO;
import hotel.vo.HotelInfoGetVO;
import hotel.vo.HotelInfoPrintVO;
import hotel.vo.Reservation1VO;
import hotel.vo.RoomVO;




public class HotelDAO {

	private SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory();

	public ArrayList<HotelInfoPrintVO> hotelsearch(HotelInfoGetVO hotelInfoGet) {
		SqlSession session = null;
		ArrayList<HotelInfoPrintVO> list = null;

		try {
			session = factory.openSession();
			HotelMapper mapper = session.getMapper(HotelMapper.class);
			list = mapper.hotelsearch(hotelInfoGet);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			if (session != null) {
				session.close();
			}
		}
		return list;

	}

	
	public ArrayList<HotelEventVO>ongoingEvent(String today){
		
		SqlSession session = null;
		ArrayList<HotelEventVO> list = null;

		try {
			session = factory.openSession();
			HotelMapper mapper = session.getMapper(HotelMapper.class);
			list = mapper.ongoingEvent(today);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			if (session != null) {
				session.close();
			}
		}
		return list;
		
		
	}

	public ArrayList<HotelInfoPrintVO> selectByHotel (String HotelName){
		SqlSession session = null;
		ArrayList<HotelInfoPrintVO> list = null;
		try {
			session = factory.openSession();
			HotelMapper mapper = session.getMapper(HotelMapper.class);
			list = mapper.selectByHotel(HotelName);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if (session != null) {
				session.close();
			}
		} return list;
	}
	
	public ArrayList<HotelEventVO> printAllEvent() {
		SqlSession session = null;
		ArrayList<HotelEventVO> list = null;

		try {
			session = factory.openSession();
			HotelMapper mapper = session.getMapper(HotelMapper.class);
			list = mapper.printAllEvent();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			if (session != null) {
				session.close();
			}
		}
		return list;
	}


	public int insertReservation (Reservation1VO hotel1) {
		SqlSession session = null;
		int cnt = 0;
		try {
			session = factory.openSession();
			HotelMapper mapper = session.getMapper(HotelMapper.class);
			cnt = mapper.insertReservation(hotel1);
			
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session != null) {
				session.close();
			}
		} return cnt;
	

	}
	public int searchPriceByRoomID (int roomID) {
		SqlSession session = null;
		int cnt = 0;
		try {
			session = factory.openSession();
			HotelMapper mapper = session.getMapper(HotelMapper.class);
			cnt = mapper.searchPriceByRoomID(roomID);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session != null) {
				session.close();
			}
		} return cnt;
	}

	

}
