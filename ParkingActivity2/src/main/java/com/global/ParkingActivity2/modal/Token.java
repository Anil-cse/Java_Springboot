package com.global.ParkingActivity2.modal;

import java.time.LocalDateTime;

public class Token {
	private int tokenId;
	private Vehicle vehicle;
	private LocalDateTime checkinTime;
	private LocalDateTime checkoutTime;

	public Token(int tokenId, Vehicle vehicle, LocalDateTime checkinTime) {
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

	public LocalDateTime getCheckinTime() {
		return checkinTime;
	}

	public void setCheckinTime(LocalDateTime checkinTime) {
		this.checkinTime = checkinTime;
	}

	public LocalDateTime getCheckoutTime() {
		return checkoutTime;
	}

	public void setCheckoutTime(LocalDateTime checkoutTime) {
		this.checkoutTime = checkoutTime;
	}

}
