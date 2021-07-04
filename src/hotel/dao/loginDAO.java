package hotel.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import hotel.vo.ReservationVO;
import myPage.vo.HomeUserVO;

public class loginDAO {

	SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory();

	public HomeUserVO loginIdCheck(String userID) {
		SqlSession session=null;
		HomeUserVO result=null;
		try {
			session=factory.openSession();
			loginMapper mapper=session.getMapper(loginMapper.class);
			result=mapper.loginIdCheck(userID);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			if(session!=null)session.close();
		}
		return result;
	}

	public HomeUserVO loginPasswordCheck(String userPassword) {
		SqlSession session=null;
		HomeUserVO result=null;
		try {
			session=factory.openSession();
			loginMapper mapper=session.getMapper(loginMapper.class);
			result=mapper.loginPasswordCheck(userPassword);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			if(session!=null)session.close();
		}
		return result;
	}

}

