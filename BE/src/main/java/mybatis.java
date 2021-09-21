import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.junit.Test;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.goldrush.dao.MemberDAO;
import com.goldrush.dto.MemberDTO;
import com.goldrush.service.MemberService;

public class mybatis {
	
	@Autowired
	private SqlSessionFactory sqlFactory;
	
	@Test
	public void test()  {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:dao-context.xml");
		SqlSessionFactory sql  = (SqlSessionFactory) ctx.getBean("sqlSessionFactory");
		SimpleDriverDataSource db = (SimpleDriverDataSource) ctx.getBean("dataSource");
		System.out.println(db.getConnectionProperties());
		try {
			System.out.println(db.getConnection());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(sql);
		SqlSession session = sql.openSession();
		System.out.println(session);
		
		session = (SqlSession) ctx.getBean("sqlSession");
		System.out.println(session);
		MemberDTO result = session.selectOne("mapper.memberMapper.selectByUserId","5575492@gmail.com");
		System.out.println(result);

	}
	
	@Test
	public void memberTest() {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:dao-context.xml");
		MemberDAO memberDAO = (MemberDAO) ctx.getBean("MemberDAO");
		System.out.print(memberDAO.selectByUserId("5575492q@gmail.com"));
	}
	@Test
	public void bean() {
		System.out.println(sqlFactory);
		
	}
	@Test
	public void test1() {
		MemberService ser = new MemberService();
		MemberDTO dto = new MemberDTO();
		dto.setMembersId(9);
		dto.setName("lee");
		dto.setPassword("3700");
		dto.setUserId("5575492q@gmail.com");
		System.out.print(ser.signup(dto).getMessage());
		
	}

}
