import static org.junit.Assert.*;

import org.junit.Test;

import com.goldrush.util.BankingUtils;

public class junitForUtils {

	@Test
	public void test() {
		BankingUtils u = new BankingUtils();
		System.out.println(u.getBank_tran_id());
	}

}
