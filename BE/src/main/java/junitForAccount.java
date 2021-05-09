import static org.junit.Assert.*;

import org.junit.Test;

import com.goldrush.dao.AccountDAO;
import com.goldrush.dao.AccountDAOImpl;
import com.goldrush.dao.DBHandler;

public class junitForAccount {

	@Test
	public void test() {
		AccountDAO dao = new AccountDAOImpl(new DBHandler());
		
		System.out.println(dao.selectBalacne(1));
		System.out.println(dao.selectAccountLog(2));
		System.out.println(dao.selectCount());
	}

}
