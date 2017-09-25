package com.cg.mobile.dao;

import java.util.ArrayList;

import com.cg.mobile.DTO.MobileDetails;
import com.cg.mobile.DTO.PurchaseDetails;
import com.cg.mobile.exception.MobileApplicationException;

public interface IMobileDAO {

	public int addPurchaseDetails(PurchaseDetails p) throws MobileApplicationException;

	public ArrayList<MobileDetails> retrieveDetails();
	
}
