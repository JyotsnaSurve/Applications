package com.cg.mobile.service;

import java.util.ArrayList;
import java.util.regex.Pattern;

import com.cg.mobile.DTO.MobileDetails;
import com.cg.mobile.DTO.PurchaseDetails;
import com.cg.mobile.dao.IMobileDAO;
import com.cg.mobile.dao.MobDaoImpl;
import com.cg.mobile.exception.MobileApplicationException;

public class MobileServiceImpl implements IMobileService{
	
	IMobileDAO dao=new MobDaoImpl();
	@Override
	public int addPurchaseDetails(PurchaseDetails p) {
		int res=0;
		
		try
		{
		 res= dao.addPurchaseDetails(p);
		} 
		catch (MobileApplicationException e) {
		
			e.printStackTrace();
		}
		return res;
	}
	
	public boolean validateName(String name)
	{
		String ptn="[A-Z]{1}[a-zA-Z]{2,19}";
		if(Pattern.matches(ptn, name))
		{
			return true;
		}
		else
		{
			System.out.println("Please enter the correct input customer name");
			return false;
		}
	}
	
	public boolean validateEmail(String mail)
	{
		String emailPattern="^[?=.*A-Za-z0-9]+@[A-Za-z]+\\.[A-Za-z]{2,6}$";
		if(Pattern.matches(emailPattern, mail))
		{
			return true;
		}
		else
		{
			System.out.println("Please enter the correct email");
			return false;
		}
	}
	public boolean validatePhoneNo(String phone)
	{
		String phonepattern="[0-9]{10}";
		if(Pattern.matches(phonepattern, phone))
		{
			return true;
		}
		else
		{
			System.out.println("Please enter the correct phone no");
			return false;
		}
	}
	
	public boolean validateMobileId(String mobid)
	{
		String mobidPattern="[1][0][0][1-3]{1}";
		if(Pattern.matches(mobidPattern, mobid))
		{
			return true;
		}
		else
		{
			System.out.println("Please enter the correct mobile id");
			return false;
		}
	}
	public ArrayList<MobileDetails>retrieveDetails()
	{
		return dao.retrieveDetails();

	}
	

}
