import static org.junit.Assert.*;

import org.junit.Test;

import com.goldrush.dao.DBHandler;
import com.goldrush.dao.OfferDAO;
import com.goldrush.dao.OfferDAOImpl;
import com.goldrush.dto.OfferDTO;

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
	@Test
	public void selectButofferList() {
		OfferDAO dao = new OfferDAOImpl(new DBHandler());
		OfferDTO dto = new OfferDTO();
		dto.setItemsId(1);
		System.out.println(dao.selectBuyOfferList(dto));
	}
}
