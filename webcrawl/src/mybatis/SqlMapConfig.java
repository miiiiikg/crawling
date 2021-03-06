package mybatis;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlMapConfig {
	private static SqlSessionFactory sqlSessionFactory;
	
	static { // ? ? λΈλ­, ?΄??€ λ‘λ©? 1?λ§? ?€??¨
		String resource = "mybatis/Configuration.xml";
		try {
			Reader reader = Resources.getResourceAsReader(resource); // resourceλ³?? κ²½λ‘? ?? ??Ό? ? μ€μ© ?½?΄? reader? ?£?
			
			if(sqlSessionFactory == null) {
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader); // λΉλ ?¨?΄
			}
		} catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public static SqlSessionFactory getSqlSession() {
		return sqlSessionFactory;
	}
}
