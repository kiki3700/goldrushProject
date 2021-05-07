import static org.junit.Assert.*;

import org.junit.Test;

import com.goldrush.dto.OfferDTO;
import com.goldrush.service.TradeService;

public class junitForIpo {

//	@Test
//	public void subscription() {
//		OfferDTO offer1 = new OfferDTO();
//		offer1.setItemsId(1);
//		offer1.setMembersId(2);
//		offer1.setQuantity(4);
//		OfferDTO offer2 = new OfferDTO();
//		offer2.setItemsId(1);
//		offer2.setMembersId(3);
//		offer2.setQuantity(5);
//		OfferDTO offer3 = new OfferDTO();
//		offer3.setItemsId(1);
//		offer3.setMembersId(4);
//		offer3.setQuantity(6);
//		OfferDTO offer4 = new OfferDTO();
//		offer4.setItemsId(1);@
//		offer4.setMembersId(5);
//		offer4.setQuantity(6);
//		OfferDTO offer5 = new OfferDTO();
//		offer5.setItemsId(1);
//		offer5.setMembersId(5);
//		offer5.setQuantity(6);
//		OfferDTO offer6 = new OfferDTO();
//		offer6.setItemsId(2);
//		offer6.setMembersId(2);
//		offer6.setQuantity(4);
//		TradeService ser = new TradeService();
//		System.out.println(ser.makeSubscription(offer1));
//		System.out.println(ser.makeSubscription(offer2));
//		System.out.println(ser.makeSubscription(offer3));
//		System.out.println(ser.makeSubscription(offer4));
//		System.out.println(ser.makeSubscription(offer5));
//		System.out.println(ser.makeSubscription(offer6));
//	}
	@Test
	public void ipoTest() {
		TradeService ser = new TradeService();
		ser.changeStage();
	}
}
