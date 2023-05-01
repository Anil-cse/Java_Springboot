package com.global.ParkingActivity3.modal;

import java.util.Date;

public class Token {
    private int tokenId;
    private Vehicle vehicle;
    private Date checkinTime;
    private Date checkoutTime;
    public Token(int tokenId, Vehicle vehicle, Date checkinTime) {
    	super();
        this.tokenId = tokenId;
        this.vehicle = vehicle;
        this.checkinTime = checkinTime;
    }
	public int getTokenId() {
		return tokenId;
	}
	public void setTokenId(int tokenId) {
		this.tokenId = tokenId;
	}
	public Vehicle getVehicle() {
		return vehicle;
	}
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	public Date getCheckinTime() {
		return checkinTime;
	}
	public void setCheckinTime(Date checkinTime) {
		this.checkinTime = checkinTime;
	}
	public Date getCheckoutTime() {
		return checkoutTime;
	}
	public void setCheckoutTime(Date checkoutTime) {
		this.checkoutTime = checkoutTime;
	}
	
    
}
