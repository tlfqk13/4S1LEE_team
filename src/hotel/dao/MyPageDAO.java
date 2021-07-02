package hotel.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import hotel.vo.ReservationVO;



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

}
