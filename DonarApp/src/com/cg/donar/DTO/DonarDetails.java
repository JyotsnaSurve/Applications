package com.cg.donar.DTO;

import java.time.LocalDate;

public class DonarDetails {
	private String donarId;
	private String donarName;
	private String phoneNo;
	private String address;
	private int donationAmt;
	private LocalDate donationDate;
	
	public DonarDetails()
	{

	}
	
	
	public DonarDetails(String donarName, String phoneNo, String address,
			int donationAmt) {
		super();
		this.donarName = donarName;
		this.phoneNo = phoneNo;
		this.address = address;
		this.donationAmt = donationAmt;
	}




	public String getDonarId() {
		return donarId;
	}
	public void setDonarId(String donarId) {
		this.donarId = donarId;
	}
	public String getDonarName() {
		return donarName;
	}
	public void setDonarName(String donarName) {
		this.donarName = donarName;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getDonationAmt() {
		return donationAmt;
	}
	public void setDonationAmt(int donationAmt) {
		this.donationAmt = donationAmt;
	}
	public LocalDate getDonationDate() {
		return donationDate;
	}
	public void setDonationDate(LocalDate donationDate) {
		this.donationDate = donationDate;
	}
	
	
}
