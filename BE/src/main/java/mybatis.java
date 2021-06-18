import static org.junit.Assert.*;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.goldrush.dao.MemberMapper;
import com.goldrush.dto.MemberDTO;

public class mybatis {
	MemberDTO dto = new MemberDTO();

	
	@Test
	public void test()  {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:dao-context.xml");
		SqlSessionFactory sql  = (SqlSessionFactory) ctx.getBean("sqlSessionFactory");
//		System.out.println(sql);
//		SqlSession session = sql.openSession();
//		System.out.println(session);
//		
//		session = (SqlSession) ctx.getBean("sqlSession");
//		System.out.println(session);
//		MemberDTO result = session.selectOne("mapper.memberMapper.selectByUserId","5575492@gmail.com");
//		System.out.println(result);
		dto.setName("공구리");
		dto.setPassword("6633");
		dto.setUserId("llo@naver.com");
		
		MemberMapper mm = (MemberMapper) ctx.getBean("MemberMapper");
		mm.insertNewMemeber(dto);
		System.out.println(mm.selectByUserId("5575492q@gmail.com"));

	}
	
	

}
