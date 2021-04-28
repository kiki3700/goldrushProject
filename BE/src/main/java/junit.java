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
		MemberService ser = new MemberService();
		
		MemberDTO dto = new MemberDTO();
		dto.setName("sh");
		dto.setUserId("kiki");
		dto.setPassword("god");
		int a = ser.signup(dto);
		System.out.println(a);
	}

}
