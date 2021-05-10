import static org.junit.Assert.*;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.goldrush.dto.accountDto.RequestToken3legger;
import com.goldrush.service.accountService.AccountService;

public class junitForOAuth {

	@Test
	public void test() {
		AccountService ser = new AccountService();
		RequestToken3legger dto = new RequestToken3legger();
		dto.setCode("ZGl24lSGEs0qNp9Sv26h6rA25a4wgK");
		
		try {
			System.out.println(ser.getTokenOAuth2legger());
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
