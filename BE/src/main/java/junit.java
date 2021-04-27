import static org.junit.Assert.*;

import org.junit.Test;

import com.goldrush.dao.DBHandler;
import com.goldrush.dao.MemberDAO;

public class junit {

	@Test
	public void test() {
//		System.out.println("a");
		DBHandler db = new DBHandler();
//		db.connect();
		MemberDAO dao = new MemberDAO(db);
		System.out.println(dao.selectByUserId("admin").getPassword());
		
	}

}
