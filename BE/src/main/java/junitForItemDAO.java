import static org.junit.Assert.*;

import java.sql.Timestamp;

import org.junit.Before;
import org.junit.Test;

import com.goldrush.dao.DBHandler;
import com.goldrush.dao.MemberDAOImpl;
import com.goldrush.dto.ItemDTO;
import com.goldrush.dto.MemberDTO;
import com.goldrush.service.MemberService;

public class junitForItemDAO {

	
	@Test
	public void test() {
		ItemDTO dto = new ItemDTO();
		dto.setItemsId(1);
		dto.setCode("rollie");
		dto.setName("rollex");
		dto.setCategory("watch");
		dto.setStage("ipo");
		dto.setOpeningDate(new Timestamp(System.currentTimeMillis()));
		dto.setIpoDate(new Timestamp(System.currentTimeMillis()));
		dto.setTradingDate(new Timestamp(System.currentTimeMillis()));
		dto.setClearingDate(new Timestamp(System.currentTimeMillis()));
	}

}
