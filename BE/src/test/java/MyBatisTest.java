import static org.junit.Assert.*;
import javax.inject.Inject;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//Runner 클래스(테스트 메소드를 실행하는 클래스) 를 SpringJUnit4ClassRunner로 함
//@RunWith(SpringJUnit4ClassRunner.class)
//location 속성 경로에 있는 xml 파일을 이용해서 스프링이 로딩됨
//@ContextConfiguration(locations="classpath:dao-context.xml")

public class MyBatisTest {
	


	
	//MyBatis와 Mysql 서버가 제대로 연결되었는지 Test
	@Test
	public void testSession() throws Exception{
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:dao-context.xml");
		SqlSessionFactory sql  = (SqlSessionFactory) ctx.getBean("sqlSessionFactory");
		System.out.println(sql);
	}
}
