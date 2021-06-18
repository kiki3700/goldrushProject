import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.goldrush.dao.MemberMapper;

public class MemberMTest {
	
	@Test
	public void test() {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:dao-context.xml");
		MemberMapper mm = (MemberMapper) ctx.getBean("MemberMapper");
		System.out.println(mm.selectByUserId("5575492q@gmail.com"));
	}

}
