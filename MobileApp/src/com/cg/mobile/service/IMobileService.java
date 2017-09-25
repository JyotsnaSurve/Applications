package com.cg.mobile.service;

import java.util.ArrayList;

import com.cg.mobile.DTO.MobileDetails;
import com.cg.mobile.DTO.PurchaseDetails;
import com.cg.mobile.exception.MobileApplicationException;

public interface IMobileService {
	public int addPurchaseDetails(PurchaseDetails p) throws MobileApplicationException;
	public boolean validateName(String name);
	public boolean validateEmail(String mail);
	public boolean validatePhoneNo(String phone);
	public boolean validateMobileId(String mobid);
	public ArrayList<MobileDetails>retrieveDetails();//not passing para since getting from db

}
