import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cg.mobile.DTO.PurchaseDetails;
import com.cg.mobile.dao.IMobileDAO;
import com.cg.mobile.dao.MobDaoImpl;
import com.cg.mobile.exception.MobileApplicationException;


public class TestMobileApplication {

	static IMobileDAO dao=null;
	static PurchaseDetails bean=null;
	
	@BeforeClass
	public static void initialize() throws MobileApplicationException {
		System.out.println("hi");
		dao=new MobDaoImpl();
		bean=new PurchaseDetails();
	}
	@Test
	public void testData()
	{
		bean.setcName("123aman");
		bean.setMailId("abc@gmail.com");
		bean.setMobileId(1001);
		bean.setPhoneno(123);
		bean.setPurchaseId(10);
	}
	
	@Test
	public void testAddDetails() throws MobileApplicationException{
		assertNotNull(dao.addPurchaseDetails(bean));
	}
	
	@Test
	public void getDetails()
	{
		assertNotNull(dao.retrieveDetails());
	}

}
