import static org.junit.Assert.*;

import org.junit.Test;

import com.goldrush.dao.DBHandler;
import com.goldrush.dao.TradeDAO;
import com.goldrush.dao.TradeDAOImpl;
import com.goldrush.dto.MemberDTO;
import com.goldrush.dto.OfferDTO;
import com.goldrush.dto.TradeDTO;
import com.goldrush.dto.TraderDTO;
import com.goldrush.service.TradeService;

public class junitForTrade {

//	@Test
//	public void test() {
//		TradeDAO dao = new TradeDAOImpl(new DBHandler());
//		TradeDTO dto = new TradeDTO();
//		dto.setMembersId(2);
//		dto.setOffersId(5);
//		dto.setQuantity(1);
//		System.out.println(dao.insertTrade(dto));
//	}
//	@Test
//	public void select() {
//		MemberDTO mem = new MemberDTO();
//		mem.setMembersId(1);
//		TradeDAO dao = new TradeDAOImpl(new DBHandler());
//		System.out.println(dao.selectTrade(mem));
//		
//	}
//	@Test
//	public void test() {
//		TradeDAO dao = new TradeDAOImpl(new DBHandler());
//		TradeDTO dto = new TradeDTO();
//
//		System.out.println(dao.selectTradeLog(1));
//	}
	
//	@Test
//	public void test() {
//		TradeService trade = new TradeService();
//		OfferDTO dto = new OfferDTO();
//		dto.setMembersId(1);
//		dto.setQuantity(3);
//		dto.setOfferPrice(200);
//		System.out.println(trade.checkEnoughQuantity(dto));
//		System.out.println(trade.checkEnoughBalance(dto));
//	}
	
	@Test
	public void test() {
		TraderDTO dto = new TraderDTO();
		dto.setBuy(true);
		dto.setItemsId(1);
		dto.setMembersId(1);
		dto.setPrice(130);
		dto.setQuantity(3);
		TradeService trade = new TradeService();
		trade.trade(dto);
	}
}
