package models;

import java.util.Random;

import enums.AirportName;
import ifaces.INumberGenerator;

public class Airport implements INumberGenerator {
	private String airportNr;
	private int capacity;
	private AirportName name;
	static int flightCounter = 0;
	public Airport(AirportName name, int capacity) {
		this.capacity = capacity;
		setName(name);
		generateNr();
	}

	public int getCapacity() {
		return capacity;
	}


	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}


	public AirportName getName() {
		return name;
	}


	public void setName(AirportName name) {
		this.name = name;
		/*
		for(AirportName temp : AirportName.values()) {
			if(temp.name().equals(name)) {
				this.name = name;
				return;
			}
		}
		this.name = AirportName.RIGA;
		*/
	}


	public String getAirportNr() {
		return airportNr;
	}


	@Override
	public void generateNr() {
		Random rand = new Random();
		//Random number between 10 and 100
		int number = rand.nextInt((100-10)+1)+10;
		String temp = ""+this.getName();
		//get first two characters of string
		this.airportNr = temp.substring(0,3) + number;
	}

	@Override
	public String toString() {
		return "Airport [airportNr=" + airportNr + ", capacity=" + capacity + ", name=" + name + "]";
	}
	

}
