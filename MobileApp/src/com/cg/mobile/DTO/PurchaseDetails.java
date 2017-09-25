package com.cg.mobile.DTO;

import java.time.LocalDate;

public class PurchaseDetails {
	private int purchaseId;
	private String cName;
	private String mailId;
	private long phoneno;
	private LocalDate purchaseDate;
	private int mobileId;
	
	//default constructor
	public PurchaseDetails()
	{
		
	}

	//parameterized constructor
	
	@Override
	public String toString() {
		return "PurchaseDetails [purchaseId=" + purchaseId + ", cName=" + cName
				+ ", mailId=" + mailId + ", phoneno=" + phoneno
				+ ", purchaseDate=" + purchaseDate + ", mobileId=" + mobileId
				+ "]";
	}

	public PurchaseDetails(String cName, String mailId, long phoneno,
			int mobileId) {
		super();
		this.cName = cName;
		this.mailId = mailId;
		this.phoneno = phoneno;
		this.mobileId = mobileId;
	}

	//getters and setters
	public int getPurchaseId() {
		return purchaseId;
	}

	public void setPurchaseId(int purchaseId) {
		this.purchaseId = purchaseId;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public String getMailId() {
		return mailId;
	}

	public void setMailId(String mailId) {
		this.mailId = mailId;
	}

	public long getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(long phoneno) {
		this.phoneno = phoneno;
	}

	public LocalDate getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(LocalDate purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public int getMobileId() {
		return mobileId;
	}

	public void setMobileId(int mobileId) {
		this.mobileId = mobileId;
	}
}
