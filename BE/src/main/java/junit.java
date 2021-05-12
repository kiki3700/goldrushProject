import static org.junit.Assert.*;

import org.junit.Test;

import com.goldrush.dao.DBHandler;
import com.goldrush.dao.MemberDAOImpl;
import com.goldrush.dto.MemberDTO;
import com.goldrush.service.MemberService;

public class junit {

	@Test
	public void test() {
//		System.out.println("a");
//		DBHandler db = new DBHandler();
//		db.connect();
//		MemberDAOImpl dao = new MemberDAOImpl(db);
//		System.out.println(dao.selectByUserId("admin").getPassword());
		String a = ".alb";
		System.out.println(a.indexOf("."));
		System.out.println(a.substring(0));
	}

}
