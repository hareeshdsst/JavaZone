package com.javapractice.examples2;

public class GpsTracking {

	private double xCoord = 0;
	private double yCoord = 0;
	private int buildingNumber;
	private String street,city,state,zip;
	
	public GpsTracking(double xCoord, double yCoord){
		this.xCoord = xCoord;
		this.yCoord = yCoord;
	}
	
	public double [] getAllCoords(){
		double [] arr = {this.xCoord, this.yCoord};
		return arr;
	}
}
