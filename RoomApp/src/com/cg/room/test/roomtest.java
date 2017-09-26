package com.cg.room.test;
import static org.junit.Assert.*;

import java.io.IOException;
import org.junit.BeforeClass;
import org.junit.Test;
import com.cg.room.dao.IRoomRegistrationDAO;
import com.cg.room.dao.RoomRegistrationDAOImpl;
import com.cg.room.dto.FlatRegistrationDTO;
import com.cg.room.exception.RoomApplicationException;


public class roomtest {

	static IRoomRegistrationDAO dao=null;
	static FlatRegistrationDTO bean=null;
	@BeforeClass
	public static void initialize() throws RoomApplicationException {
		System.out.println("hi");
		dao=new RoomRegistrationDAOImpl();
		bean=new FlatRegistrationDTO();
	}
	@Test
	public void testData()
	{
		bean.setHotelId(1);
		bean.setRoomType(1);
		bean.setRoomArea(100);
		bean.setRentAmount(200);
		bean.setPaidAmount(400);
	}
	
	@Test
	public void testAddDetails(){
		try {
			assertNotNull(dao.addBookingDetails(bean));
		} 
		catch (RoomApplicationException e) 
		{
			System.out.println("error here");
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
}
