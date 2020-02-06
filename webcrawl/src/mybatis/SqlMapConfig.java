package mybatis;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlMapConfig {
	private static SqlSessionFactory sqlSessionFactory;
	
	static { // ?��?��블럭, ?��?��?�� 로딩?�� 1?���? ?��?��?��
		String resource = "mybatis/Configuration.xml";
		try {
			Reader reader = Resources.getResourceAsReader(resource); // resource�??�� 경로?�� ?��?�� ?��?��?�� ?�� 줄씩 ?��?��?�� reader?�� ?��?��
			
			if(sqlSessionFactory == null) {
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader); // 빌드 ?��?��
			}
		} catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public static SqlSessionFactory getSqlSession() {
		return sqlSessionFactory;
	}
}
