package com.cg.room.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cg.room.dto.FlatRegistrationDTO;
import com.cg.room.exception.RoomApplicationException;

public interface IRoomRegistrationDAO {

	public int addBookingDetails(FlatRegistrationDTO details) throws RoomApplicationException, IOException;

	public ArrayList<Integer> getAllOwnerId() throws IOException, SQLException;

}
