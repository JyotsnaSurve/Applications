package com.cg.room.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cg.room.dao.IRoomRegistrationDAO;
import com.cg.room.dao.RoomRegistrationDAOImpl;
import com.cg.room.dto.FlatRegistrationDTO;

public class RoomRegistrationServiceImpl implements IRoomRegistrationService{
	
	IRoomRegistrationDAO dao;
	@Override
	public int addBookingDetails(FlatRegistrationDTO details) {
		int res=0;
		res=dao.addBookingDetails(details);
		return res;
	}
	@Override
	public ArrayList<Integer> getAllOwnerId() throws IOException, SQLException {
		dao=new RoomRegistrationDAOImpl();
		return dao.getAllOwnerId();
	}

}
