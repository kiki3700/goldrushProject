import static org.junit.Assert.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import org.junit.Before;
import org.junit.Test;

import com.goldrush.dao.DBHandler;
import com.goldrush.dao.ItemDAO;
import com.goldrush.dao.ItemDAOImpl;
import com.goldrush.dao.MemberDAOImpl;
import com.goldrush.dto.ItemDTO;
import com.goldrush.dto.MemberDTO;
import com.goldrush.dto.ResponseDTO;
import com.goldrush.service.MemberService;

public class junitForItemDAO {

	
	@Test
	public void test() {
		ItemDTO dto = new ItemDTO();
		dto.setItemsId(1);
		dto.setCode("rollie14");
		dto.setName("rollex");
		dto.setCategory("watch");
		dto.setStage("ipo");
		dto.setCost(6000);
		dto.setQuantity(100);
		dto.setOpeningDate(Timestamp.valueOf(LocalDateTime.of(2021,4,8,8,15,20,0)));
		dto.setIpoDate(Timestamp.valueOf(LocalDateTime.of(2021,5,9,8,15,20,0)));
		dto.setTradingDate(Timestamp.valueOf(LocalDateTime.of(2021,6,9,8,15,20,0)));
		dto.setClearingDate(Timestamp.valueOf(LocalDateTime.of(2021,7,9,8,15,20,0)));
		dto.setDescription("ㅇ리나");
		dto.setImgAddress("rollie.img");
		ItemDAO dao = new ItemDAOImpl(new DBHandler());
		System.out.println(dao.insertNewItem(dto));
	}
//	@Test
//	public void delete() {
//		ItemDTO dto = new ItemDTO();
//		dto.setItemsId(1);
//		dto.setCode("rollie3");
//		dto.setName("rollex");
//		dto.setCategory("watch");
//		dto.setStage("ipo");
//		dto.setCost(6000);
//		dto.setQuantity(100);
//		dto.setOpeningDate(Timestamp.valueOf(LocalDateTime.of(2021,4,8,8,15,20,0)));
//		dto.setIpoDate(Timestamp.valueOf(LocalDateTime.of(2021,5,9,8,15,20,0)));
//		dto.setTradingDate(Timestamp.valueOf(LocalDateTime.of(2021,6,9,8,15,20,0)));
//		dto.setClearingDate(Timestamp.valueOf(LocalDateTime.of(2021,7,9,8,15,20,0)));
//		dto.setDescription("연습으로 만든거에염");
//		dto.setImgAddress("rollie.img");
//		ItemDAO dao = new ItemDAOImpl(new DBHandler());
//		ResponseDTO res =dao.deleteItem(2);
//		System.out.println(res.getMessage());
//	}

}
