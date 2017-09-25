package com.cg.room.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cg.room.dto.FlatRegistrationDTO;

public interface IRoomRegistrationDAO {

	public int addBookingDetails(FlatRegistrationDTO details);

	public ArrayList<Integer> getAllOwnerId() throws IOException, SQLException;

}
