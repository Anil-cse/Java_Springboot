package com.global.ParkingActivity2.modal;

public class Vehicle {
	private String vehicleId;
	private String vehicleName;
	private String ownerName;

	public Vehicle(String vehicleId, String vehicleName, String ownerName) {
		super();
		this.vehicleId = vehicleId;
		this.vehicleName = vehicleName;
		this.ownerName = ownerName;
	}

	public String getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(String vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getVehicleName() {
		return vehicleName;
	}

	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

}
