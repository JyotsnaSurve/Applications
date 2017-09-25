package com.cg.mobile.UI;

import java.util.ArrayList;
import java.util.Scanner;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.cg.mobile.DTO.MobileDetails;
import com.cg.mobile.DTO.PurchaseDetails;
import com.cg.mobile.exception.MobileApplicationException;
import com.cg.mobile.service.IMobileService;
import com.cg.mobile.service.MobileServiceImpl;

public class MobileUI {
		static Scanner sc=new Scanner(System.in); //static because used inside main and other methods also
		static PurchaseDetails details=null; //static obj so that can be used in methods
		static IMobileService service=new MobileServiceImpl();
		
		public static void main(String[] args) throws MobileApplicationException {
	
		System.out.println("Mobile Application");
		System.out.println("*****************");
		while(true)
		{
			System.out.println("1.Enter purchase details");
			System.out.println("2.Get the mobile details");
			System.out.println("3.Exit");
			System.out.println("Enter your choice");
			int choice=sc.nextInt();
			switch(choice)
			{
			case 1:addPurchasedetails();
			break;
			case 2:getMobileDetails();
			break;
			case 3:
				System.exit(0);
			break;
			}
		}
	}

	
	private static void addPurchasedetails() throws MobileApplicationException {
		
		PropertyConfigurator.configure("log4j.properties");
		try{
			
		System.out.println("Enter customer name");
		String name=sc.next();
		if(service.validateName(name))
		{
		System.out.println("Enter mailid");
		String mail=sc.next();
		if(service.validateEmail(mail))
		{
		System.out.println("Enter phone number");
		long phone=sc.nextLong();
		String num=String.valueOf(phone);
		if(service.validatePhoneNo(num))
		{
		System.out.println("Enter mobile id");
		int mobid=sc.nextInt();
		
		
		details=new PurchaseDetails(name,mail,phone,mobid);
		service=new MobileServiceImpl();
		int res=service.addPurchaseDetails(details);
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
		}
		}
		catch(Exception e)
		{
			
			throw new MobileApplicationException("Exception occured");

		}
	}
	private static void getMobileDetails() {
		ArrayList<MobileDetails> list=null; //creating obj list
		list=service.retrieveDetails();
		for(MobileDetails m:list)
		{
			System.out.println(m.getMobileId());
			System.out.println(m.getName());
			System.out.println(m.getPrice());
			System.out.println(m.getQuantity());
		}
	}
}
