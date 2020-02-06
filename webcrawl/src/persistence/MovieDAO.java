package persistence;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import domain.MovieDTO;
import mybatis.SqlMapConfig;

public class MovieDAO {
	
	SqlSessionFactory sqlSessionFactory = SqlMapConfig.getSqlSession();
	SqlSession sqlSession;
	int result;
	
	
	// Oracle DB�� ũ�Ѹ� �����͸� �����ϴ� ���
	// mDto <= ���� 1��
	public void addMovie(MovieDTO mDto) {
		sqlSession = sqlSessionFactory.openSession(true);
		try {
			result = sqlSession.insert("movie.addMovie", mDto);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}

}
