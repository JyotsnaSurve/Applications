package com.cg.donar.UI;

import java.util.Scanner;

import com.cg.donar.DTO.DonarDetails;
import com.cg.donar.service.DonarServiceImpl;
import com.cg.donar.service.IDonarService;

public class DonarUI {
	static Scanner sc=new Scanner(System.in); 
	static DonarDetails details=null; 
	static IDonarService service=new DonarServiceImpl();
	public static void main(String[] args){
		
		System.out.println("Donar Application");
		System.out.println("*****************");
		while(true)
		{
			System.out.println("1.Enter Donar details");
			System.out.println("2.Exit");
			System.out.println("Enter your choice");
			int choice=sc.nextInt();
			switch(choice)
			{
			case 1:addDonarDetails();
			break;
			case 2:
				System.exit(0);
			break;
			}
		}
	}
	private static void addDonarDetails() {
		
		System.out.println("Enter the donar name:");
		String name=sc.next();
		
		System.out.println("Enter phone number:");
		String phone=sc.next();
		
		System.out.println("Enter address:");
		String address=sc.next();
		
		System.out.println("Enter donation amount:");
		int amt=sc.nextInt();
		
		details=new DonarDetails(name,phone,address,amt);
		service=new DonarServiceImpl();
		int res=service.addDonarDetails(details);
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
