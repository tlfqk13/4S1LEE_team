package hotel.dao;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * Mybatis�� ȯ�� ���� �а� ��ü ����
 */
public class MybatisConfig {
	private static SqlSessionFactory sqlSessionFactory;

	static {
		String resource = "mybatis-config.xml";		//Mybatis ȯ�漳�� ���� �б�. src ��ο� ����.
		

		try {
			Reader reader = Resources.getResourceAsReader(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}
}
