package hotel.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import hotel.vo.PayVO;
import hotel.vo.Reservation1VO;


public class PayDAO {
	
	private SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory();
	
	public ArrayList<Reservation1VO> reservation1voList(String string) {
		SqlSession session = null;
		ArrayList<Reservation1VO> list = null;

		try {
			session = factory.openSession();
			HotelMapper mapper = session.getMapper(HotelMapper.class);
			list = mapper.reservation1voList(string);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			if (session != null) {
				session.close();
			}
		}
		return list;
	}

	public int payInsert(PayVO vo) {		
		SqlSession session = null;
		int result=0;
		try {
			session = factory.openSession();
			HotelMapper mapper = session.getMapper(HotelMapper.class);
			result=mapper.payInsert(vo);
			session.commit();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if(session != null) session.close();
		} 
		return result;
	}

	public void payUpdate2(int reservationID) {
		SqlSession session = null;

		try {
			session = factory.openSession();
			HotelMapper mapper = session.getMapper(HotelMapper.class);
			mapper.payUpdate2(reservationID);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
	}

}
