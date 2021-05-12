import static org.junit.Assert.*;

import org.junit.Test;

import com.goldrush.dto.MemberDTO;
import com.goldrush.service.MemberService;

public class junitforMemberservice {
	@Test
	public void test() {
		MemberService memberService  = new MemberService();
		MemberDTO dto =new MemberDTO();
		
		System.out.println(memberService.getOfferLog(1));
		System.out.println(memberService.getTradeLog(1));
	}

}
