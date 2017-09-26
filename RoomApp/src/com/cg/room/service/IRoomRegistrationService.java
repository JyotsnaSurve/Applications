package com.cg.room.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cg.room.dto.FlatRegistrationDTO;
import com.cg.room.exception.RoomApplicationException;

public interface IRoomRegistrationService {

	public int addBookingDetails(FlatRegistrationDTO details) throws RoomApplicationException, IOException;

	public ArrayList<Integer> getAllOwnerId() throws IOException, SQLException;

	public boolean validateHotelId(int ownerId);

	public boolean validateRoomType(int roomType);

	public boolean validateRoomArea(int roomArea);

	public boolean validateRentAmount(int rentAmount);

	public boolean validatePaidAmount(int paidAmount, int rentAmount);

}
