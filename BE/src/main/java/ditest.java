import static org.junit.Assert.*;

import org.junit.Test;

import com.goldrush.dto.accountDto.RequestOAuth3legger;
import com.goldrush.dto.accountDto.RequestToken3legger;

public class ditest {

	@Test
	public void test() {
		RequestOAuth3legger legger = new RequestOAuth3legger();
		System.out.println(legger);
		RequestToken3legger tocken = new  RequestToken3legger();
		System.out.println(tocken);
	}

}
