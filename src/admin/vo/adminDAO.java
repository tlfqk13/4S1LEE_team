package admin.vo;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import hotel.dao.MybatisConfig;
import hotel.dao.loginMapper;
import myPage.vo.HomeUserVO;

public class adminDAO {
	
	SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory();
	public AdminVO adminLogin(String managerID, String managerPassword) {
		SqlSession session=null;
		AdminVO result=null;
		HashMap<String,String>map=new HashMap<>();
		map.put("managerID",managerID );
		map.put("managerPassword",managerPassword);
		try {
			session=factory.openSession();
			AdminMapper mapper=session.getMapper(AdminMapper.class);
			result=mapper.adminLogin(map);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			if(session!=null)session.close();
		}
		return result;
	}
}
