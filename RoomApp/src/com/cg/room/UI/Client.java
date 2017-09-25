package com.cg.room.UI;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;






import com.cg.room.dto.FlatRegistrationDTO;
import com.cg.room.service.IRoomRegistrationService;
import com.cg.room.service.RoomRegistrationServiceImpl;

public class Client {
		
		static Scanner sc=new Scanner(System.in);
		static FlatRegistrationDTO details=null;
		static IRoomRegistrationService service=new RoomRegistrationServiceImpl();
	
	public static void main(String[] args) throws IOException, SQLException {
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


	private static void addBookingDetails() throws IOException, SQLException {
		
		ArrayList<Integer> list=new ArrayList<Integer>();
		list=service.getAllOwnerId();
		System.out.println("Existing HotelOwner IDS Are:-"+list);
		System.out.println("Please enter your hotel owner id   from above list:");
		int ownerId=sc.nextInt();
	
		System.out.println("Select  room type Type (1-1AC, 2-2NON-AC):");
		int roomType=sc.nextInt();
		System.out.println("Enter room area in sq. ft.: ");
		int roomArea=sc.nextInt();
		System.out.println("Enter desired rent amount Rs: ");
		int rentAmount=sc.nextInt();
		System.out.println("Enter desired paid amount Rs: ");
		int paidAmount=sc.nextInt();
		
		details=new FlatRegistrationDTO(ownerId,roomType,roomArea,rentAmount,paidAmount);
		service=new RoomRegistrationServiceImpl();
		int res=service.addBookingDetails(details);
		System.out.println(res+"  inserted");
		if(res==1)
		{
			System.out.println("Value added in database");
		}
		else
		{
			System.out.println("Value not added");
		}
		
		
	}
}
