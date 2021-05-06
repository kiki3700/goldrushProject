import static org.junit.Assert.*;

import org.junit.Test;

import com.goldrush.dao.DBHandler;
import com.goldrush.dao.OfferDAO;
import com.goldrush.dao.OfferDAOImpl;
import com.goldrush.dto.OfferDTO;
import com.goldrush.dto.TraderDTO;
import com.goldrush.service.TradeService;

public class junitForOffer {

//	@Test
//	public void test() {
//		OfferDAO dao = new OfferDAOImpl(new DBHandler());
//		OfferDTO dto = new OfferDTO();
//		
//		dto.setMembersId(2);
//		dto.setItemsId(1);
//		dto.setBuy(true);
//		dto.setOfferPrice(100);
//		dto.setQuantity(3);
//		System.out.println(dao.insertNewOffer(dto));
//	}

//		@Test
//		public void delete() {
//			OfferDAO dao = new OfferDAOImpl(new DBHandler());
//			OfferDTO dto = new OfferDTO();
//			dto.setOffersId(60);
//			System.out.println(dao.deleteOffer(dto));
//		}
	
//	@Test
//	public void updateBy() {
//		OfferDAO dao = new OfferDAOImpl(new DBHandler());
//		OfferDTO dto = new OfferDTO();
//		dto.setItemsId(3);
//		System.out.println(dao.updateOfferByQuantity(dto));		
//	}
//	@Test
//	public void selectButofferList() {
//		OfferDAO dao = new OfferDAOImpl(new DBHandler());
//		OfferDTO dto = new OfferDTO();
//		dto.setItemsId(1);
//		System.out.println(dao.selectBuyOfferList(dto));
//	}
	
//	@Test
//	public void selectButofferList() {
//		TradeService ser = new TradeService();
//		OfferDTO dto = new OfferDTO();
//		dto.setMembersId(4);
//		dto.setBuy(false);
//		dto.setItemsId(1);
//		dto.setOfferPrice(110);
//		dto.setQuantity(4);
//		System.out.println(ser.makeOffer(dto));
//	}
	@Test
	public void buytrade() {
		
		TraderDTO dto = new TraderDTO();
		dto.setBuy(false);
		dto.setItemsId(1);
		dto.setPrice(120);
		dto.setQuantity(6);
		dto.setMembersId(4);
		TradeService ser = new TradeService();
		System.out.println(ser.trade(dto));
		
//		OfferDTO offer = new OfferDTO();
//		offer.setMembersId(1);
//		ser.checkEnoughBalance(offer);
		
	}
}
