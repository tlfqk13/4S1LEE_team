package hotel.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import hotel.vo.ReservationVO;
import myPage.vo.HomeUserVO;
import myPage.vo.ReviewBoardVO;
import myPage.vo.SearchHotelNameVO;
import myPage.vo.ShowRooomTypeVO;
import myPage.vo.UnBookingRoomVO;
import myPage.vo.UseableRoomListSrcVO;



public class MyPageDAO {
	
	SqlSessionFactory factory =MybatisConfig.getSqlSessionFactory();
	
	public int reservationDelete(int reservationID) {
		
		SqlSession session = factory.openSession();
		MyPageMapper mapper = session.getMapper(MyPageMapper.class);
		
		int result = mapper.reservationDelete(reservationID);
		session.commit();
		return result;
	}

	public List<ReservationVO> reservationList(String userID) {
		SqlSession session = factory.openSession();
		MyPageMapper mapper = session.getMapper(MyPageMapper.class);
		
		List<ReservationVO> list = mapper.reservationList(userID);
		return list;
	}

	public ReservationVO selectOneReservation(int reservationID) {
		SqlSession session = factory.openSession();
		MyPageMapper mapper = session.getMapper(MyPageMapper.class);
		
		ReservationVO reservation = mapper.selectOneReservation(reservationID);
		return reservation;
	}
	

	public int reservationUpdateChangeDate(ReservationVO changeDate) {
		SqlSession session = factory.openSession();
		MyPageMapper mapper = session.getMapper(MyPageMapper.class);
		
		int result = mapper.reservationUpdateChangeDate(changeDate);
		session.commit();
		return result;
	}

	public SearchHotelNameVO searchHotelName(int roomID) {
		SqlSession session = factory.openSession();
		MyPageMapper mapper = session.getMapper(MyPageMapper.class);
		
		SearchHotelNameVO result = mapper.searchHotelName(roomID);
		return result;
	}

	public List<ShowRooomTypeVO> showAvailableRoomByType(String hotelName) {
		SqlSession session = factory.openSession();
		MyPageMapper mapper = session.getMapper(MyPageMapper.class);
		
		List<ShowRooomTypeVO> list = mapper.showAvailableRoomByType(hotelName);
		return list;
	}


	public int reservationUpdateChangeRoomType(ReservationVO update) {
		SqlSession session = factory.openSession();
		MyPageMapper mapper = session.getMapper(MyPageMapper.class);
		
		int result = mapper.reservationUpdateChangeRoomType(update);
		session.commit();
		return result;
	}
	//승경
	
	public int userInfoUpdate(HomeUserVO user) {
		SqlSession session = null;
		int cnt = 0;
		try {
			session = factory.openSession();
			MyPageMapper mapper = session.getMapper(MyPageMapper.class);
			cnt = mapper.userInfoUpdate(user);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) {
				session.close();
			}
		}
		return cnt;
	}
		
	// ���� ���
	public List<ReviewBoardVO> reviewList(){
		SqlSession session = null;
		List<ReviewBoardVO> list1 = null;
		
		try {
			session = factory.openSession();
			MyPageMapper mapper = session.getMapper(MyPageMapper.class);
			
			list1 = mapper.reviewList();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) {
				session.close();
			}
		}
		return list1;
	}
	
	//승경
	public int deleteAccount(HomeUserVO user) {
		SqlSession session = null;
		int cnt = 0;
		try {
			session = factory.openSession();
			MyPageMapper mapper = session.getMapper(MyPageMapper.class);
			cnt = mapper.deleteAccount(user);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) {
				session.close();
			}
		}
		return cnt;
	}
	
	
	public List<ReservationVO> reservationListAll() {
		SqlSession session = factory.openSession();
		MyPageMapper mapper = session.getMapper(MyPageMapper.class);
		
		List<ReservationVO> list = mapper.reservationListAll();
		return list;
	}

	public List<UnBookingRoomVO> useableRoom(UseableRoomListSrcVO roomListSrc) {
		SqlSession session = factory.openSession();
		MyPageMapper mapper = session.getMapper(MyPageMapper.class);
		
		List<UnBookingRoomVO> list = mapper.useableRoom(roomListSrc);
		session.commit();
		return list;
	}

	public int payDelete(int reservationID) {
		SqlSession session = factory.openSession();
		MyPageMapper mapper = session.getMapper(MyPageMapper.class);
		
		int result = mapper.payDelete(reservationID);
		session.commit();
		return result;
	}

}

