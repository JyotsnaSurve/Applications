package com.cg.room.UI;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.cg.room.dto.FlatRegistrationDTO;
import com.cg.room.exception.RoomApplicationException;
import com.cg.room.service.IRoomRegistrationService;
import com.cg.room.service.RoomRegistrationServiceImpl;

public class Client {
		
		static Scanner sc=new Scanner(System.in);
		static FlatRegistrationDTO details;
		static IRoomRegistrationService service=new RoomRegistrationServiceImpl();
		static int id;
		
		
	public static void main(String[] args) throws RoomApplicationException, IOException, SQLException {
		System.out.println("Room Registration");
		System.out.println("*****************");
		while(true)
		{
			System.out.println("1.Booking Room");
			System.out.println("2.Exit");
			System.out.println("Enter your choice");
			int choice=sc.nextInt();
			switch(choice)
			{
			case 1:addBookingDetails();
			break;
			case 2:
				System.exit(0);
			break;
			}
		}
	}


	private static void addBookingDetails() throws RoomApplicationException, IOException, SQLException
	{
		ArrayList<Integer> list=new ArrayList<Integer>();
		try 
		{
			list=service.getAllOwnerId();
			System.out.println("Existing HotelOwner IDS Are:-"+list);
			System.out.println("Please enter your hotel owner id from above list:");
			int ownerId=sc.nextInt();
			if(service.validateHotelId(ownerId))
			{
			System.out.println("Select  room type Type (1-1AC, 2-2NON-AC):");
			int roomType=sc.nextInt();
			if(service.validateRoomType(roomType))
			{
			System.out.println("Enter room area in sq. ft.: ");
			int roomArea=sc.nextInt();
			if(service.validateRoomArea(roomArea))
			{
			System.out.println("Enter desired rent amount Rs: ");
			int rentAmount=sc.nextInt();
			if(service.validateRentAmount(rentAmount))
			{
			System.out.println("Enter desired paid amount Rs: ");
			int paidAmount=sc.nextInt();
			if(service.validatePaidAmount(paidAmount,rentAmount))
			{
			details=new FlatRegistrationDTO(ownerId,roomType,roomArea,rentAmount,paidAmount);
			service=new RoomRegistrationServiceImpl();
			id=service.addBookingDetails(details);
			if(id!=1)
			{
				System.out.println("Room successfully registered. Room no:<"+id+">");
			}
			}
			}
			}
			}
			}
			
		} catch (RoomApplicationException e)
		{
			System.out.println("Exception occured in program"+e);
		}
		
	}
}
