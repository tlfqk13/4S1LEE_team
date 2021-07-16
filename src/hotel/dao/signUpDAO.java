
package hotel.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import myPage.vo.HomeUserVO;

public class signUpDAO {
	
	SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory();
	
	//회원 가입
	public int signUp(HomeUserVO homeUserVO) {
		SqlSession session=null;
		int result=0;
		
		try {
			session=factory.openSession();
			signUpMapper mapper=session.getMapper(signUpMapper.class);
			result=mapper.signUp(homeUserVO);
			session.commit();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null) session.close();
		}
		return result;
	}
	
	//중복검사
	public HomeUserVO idDoubleCheck(String id) {
		SqlSession session=null;
		HomeUserVO homeUserVO=null;
		try {
			session=factory.openSession();
			signUpMapper mapper=session.getMapper(signUpMapper.class);
			homeUserVO=mapper.idDoubleCheck(id);
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			if(session!=null)session.close();
		}
		return homeUserVO;
	}

	public ArrayList<HomeUserVO> UserTable() {
		SqlSession session=null;
		ArrayList<HomeUserVO> homeUserVO=null;
		try {
			session=factory.openSession();
			signUpMapper mapper=session.getMapper(signUpMapper.class);
			homeUserVO=mapper.UserTable();
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			if(session!=null)session.close();
		}
		return homeUserVO;
	}
}