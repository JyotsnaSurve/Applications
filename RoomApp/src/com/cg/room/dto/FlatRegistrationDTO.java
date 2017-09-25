package com.cg.room.dto;

public class FlatRegistrationDTO {
	private int roomNo;
	private int hotelId;
	private int roomType;
	private int roomArea;
	private int rentAmount;
	private int paidAmount;
	
	public FlatRegistrationDTO()
	{
		
	}

	public FlatRegistrationDTO(int hotelId, int roomType, int roomArea,
			int rentAmount, int paidAmount) {
		super();
		this.hotelId = hotelId;
		this.roomType = roomType;
		this.roomArea = roomArea;
		this.rentAmount = rentAmount;
		this.paidAmount = paidAmount;
	}

	@Override
	public String toString() {
		return "FlatRegistrationDTO [roomNo=" + roomNo + ", hotelId=" + hotelId
				+ ", roomType=" + roomType + ", roomArea=" + roomArea
				+ ", rentAmount=" + rentAmount + ", paidAmount=" + paidAmount
				+ "]";
	}

	public int getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}

	public int getHotelId() {
		return hotelId;
	}

	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}

	public int getRoomType() {
		return roomType;
	}

	public void setRoomType(int roomType) {
		this.roomType = roomType;
	}

	public int getRoomArea() {
		return roomArea;
	}

	public void setRoomArea(int roomArea) {
		this.roomArea = roomArea;
	}

	public int getRentAmount() {
		return rentAmount;
	}

	public void setRentAmount(int rentAmount) {
		this.rentAmount = rentAmount;
	}

	public int getPaidAmount() {
		return paidAmount;
	}

	public void setPaidAmount(int paidAmount) {
		this.paidAmount = paidAmount;
	}
	
	
}
