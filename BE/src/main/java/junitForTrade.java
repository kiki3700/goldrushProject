import static org.junit.Assert.*;

import org.junit.Test;

import com.goldrush.dao.DBHandler;
import com.goldrush.dao.TradeDAO;
import com.goldrush.dao.TradeDAOImpl;
import com.goldrush.dto.MemberDTO;
import com.goldrush.dto.TradeDTO;

public class junitForTrade {

	@Test
	public void test() {
		TradeDAO dao = new TradeDAOImpl(new DBHandler());
		TradeDTO dto = new TradeDTO();
		dto.setMembersId(2);
		dto.setOffersId(5);
		dto.setQuantity(1);
		System.out.println(dao.insertTrade(dto));
	}
//	@Test
//	public void select() {
//		MemberDTO mem = new MemberDTO();
//		mem.setMembersId(1);
//		TradeDAO dao = new TradeDAOImpl(new DBHandler());
//		System.out.println(dao.selectTrade(mem));
//		
//	}

}
