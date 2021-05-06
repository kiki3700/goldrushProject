import static org.junit.Assert.*;

import org.junit.Test;

import com.goldrush.dao.DBHandler;
import com.goldrush.dao.InventoryDAO;
import com.goldrush.dao.InventoryDAOImpl;
import com.goldrush.dto.InventoryDTO;

public class junitForInventoryDAO {

//	@Test
//	public void test() {
//		InventoryDTO dto = new InventoryDTO();
//		InventoryDAO dao = new InventoryDAOImpl(new DBHandler());
//		
//		dto.setAveragePrice(60);
//		dto.setQuantity(1);
//		dto.setItemsId(1);
//		dto.setMembersId(1);
//		System.out.println(dao.insertInventory(dto));
//		
//	}
	
//	@Test
//	public void update() {
//		InventoryDTO dto = new InventoryDTO();
//		InventoryDAO dao = new InventoryDAOImpl(new DBHandler());
//		
//		dto.setAveragePrice(120);
//		dto.setQuantity(5);
//		dto.setItemsId(1);
//		dto.setMembersId(1);
//		System.out.println(dao.selectInv(2));
//	}
//
//	@Test
//	public void portfolio() {
//		InventoryDTO dto = new InventoryDTO();
//		InventoryDAO dao = new InventoryDAOImpl(new DBHandler());
//		
//		dto.setPrice(120);
//		dto.setQuantity(5);
//		dto.setItemsId(1);
//		dto.setMembersId(1);
//		System.out.println(dao.selectPortfolio(4));
//	}
//	
	@Test
	public void insert() {
		InventoryDAO dao = new InventoryDAOImpl(new DBHandler());
		InventoryDTO dto = new InventoryDTO();
		dto.setItemsId(1);
		dto.setMembersId(4);
		dto.setPrice(100);
		dto.setQuantity(20);
		dao.insertInventory(dto);
	}
}
