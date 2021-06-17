import static org.junit.Assert.*;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.support.GenericXmlApplicationContext;

public class mybatis {
	
	@Test
	public void test() {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:dao-context.xml");
		SqlSessionFactory sql  = (SqlSessionFactory) ctx.getBean("sqlSessionFactory");
		System.out.println(sql);
		SqlSession session = sql.openSession();
		System.out.println(session);

	}

}
