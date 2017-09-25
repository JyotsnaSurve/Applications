package com.cg.room.dto;

public class HotelOwnerDTO {
	private int hotlId;
	private int name;
	private String mobile;
	
	public HotelOwnerDTO()
	{
		
	}

	public HotelOwnerDTO(int hotlId, int name, String mobile) {
		super();
		this.hotlId = hotlId;
		this.name = name;
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return "HotelOwnerDTO [hotlId=" + hotlId + ", name=" + name
				+ ", mobile=" + mobile + "]";
	}

	public int getHotlId() {
		return hotlId;
	}

	public void setHotlId(int hotlId) {
		this.hotlId = hotlId;
	}

	public int getName() {
		return name;
	}

	public void setName(int name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	
}
