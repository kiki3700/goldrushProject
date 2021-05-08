import static org.junit.Assert.*;

import org.junit.Test;

import com.goldrush.dto.accountDto.RequestToken3legger;
import com.goldrush.service.accountService.AccountService;

public class junitForOAuth {

	@Test
	public void test() {
		AccountService ser = new AccountService();
		RequestToken3legger dto = new RequestToken3legger();
		dto.setCode("ZGl24lSGEs0qNp9Sv26h6rA25a4wgK");
		
		System.out.println(ser.getToken3legger(dto));
	}

}
