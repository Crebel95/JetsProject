package com.skilldistillery.jets.entities;

import java.util.Objects;

public abstract class Jet {
	private int idNum;
	private String model;
	private double speed;
	private int range;
	private long price;
	private static int count;
	
	public Jet(String model, double speed, int range, long price) {
		this.model = model;
		this.speed = speed;
		this.range = range;
		this.price = price;
		count++;
		idNum = count;
	}
	

	public String fly() {
		double flightTime = range / speed;
		double rounded = Math.round(flightTime * 100) / 100.0;
		return "Now flying Jet model= " + model + ", speed= " + speed + " mph" + ", range= " +
				range + " miles, price= $" + price + ", Max amount of flight time: " + rounded + " hours";
		
	}
	
	double getSpeedInMach(double speed) {
		return speed;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(model, price, range, speed);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jet other = (Jet) obj;
		return Objects.equals(model, other.model) && price == other.price && range == other.range
				&& Double.doubleToLongBits(speed) == Double.doubleToLongBits(other.speed);
	}
	
	@Override
	public String toString() {
		return "Jet number= " +idNum + "[model=" + model + ", speed=" + 
	speed + " mph " + ", range=" + range + ", price=" + price + "]";
	}


}
