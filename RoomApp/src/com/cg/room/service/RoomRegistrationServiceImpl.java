package com.cg.room.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;



import com.cg.room.dao.IRoomRegistrationDAO;
import com.cg.room.dao.RoomRegistrationDAOImpl;
import com.cg.room.dto.FlatRegistrationDTO;
import com.cg.room.exception.RoomApplicationException;

public class RoomRegistrationServiceImpl implements IRoomRegistrationService{
	
	ArrayList<Integer> list=new ArrayList<Integer>();
	IRoomRegistrationDAO dao;
	@Override
	public int addBookingDetails(FlatRegistrationDTO details) throws RoomApplicationException, IOException {
	
		dao=new RoomRegistrationDAOImpl();
		return dao.addBookingDetails(details);
	}
	@Override
	public ArrayList<Integer> getAllOwnerId() throws IOException, SQLException {
		dao=new RoomRegistrationDAOImpl();
		list = dao.getAllOwnerId();
		return list;
	}
		
	public boolean validatePaidAmount(int paidAmount, int rentAmount) {
		if(paidAmount>rentAmount)
			return true;
		else
		{
			System.out.println("please enter valid paid amount");
			return false;
		}
	}
	public boolean validateRentAmount(int rentAmount) {
		if(rentAmount>0)
			return true;
		else
		{
			System.out.println("please enter valid rent amount");
			return false;
		}
	}
	public boolean validateRoomArea(int roomArea) {
		if(roomArea>0)
			return true;
		else
		{
			System.out.println("please enter valid room area");
			return false;
		}
	}
	public boolean validateRoomType(int roomType) {
		if(roomType==1 || roomType==2)
			return true;
		else
		{
			System.out.println("please enter valid room type");
			return false;
		}
	}
	public boolean validateHotelId(int hotelId) {
		if(list.contains(hotelId))
			return true;
		else
		{
			System.out.println("hotel owner  id does not exists");
			return false;
		}
	}

}
