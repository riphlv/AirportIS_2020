package models;

import java.util.Date;
import java.util.PriorityQueue;

import ifaces.INumberGenerator;

public class Flight implements INumberGenerator {
	private int flightNr;
	private Date dateAndTime;
	private byte duration;
	private PriorityQueue<BoardingPass> allPassengers = new PriorityQueue<BoardingPass>();
	private Airport airportFrom;
	private Airport airportTo;
	
	public Flight(Airport airportFrom, Airport airportTo, Date dateAndTime, byte duration) {
		generateNr();
		this.dateAndTime = dateAndTime;
		this.duration = duration;
		getAllPassengers();
		this.airportFrom = airportFrom;
		this.airportTo = airportTo;
		
	}
	public Date getDateAndTime() {
		return dateAndTime;
	}
	public void setDateAndTime(Date dateAndTime) {
		this.dateAndTime = dateAndTime;
	}
	public byte getDuration() {
		return duration;
	}
	public void setDuration(byte duration) {
		this.duration = duration;
	}
	public PriorityQueue<BoardingPass> getAllPassengers() {
		return allPassengers;
	}
	public void setAllPassengers(PriorityQueue<BoardingPass> allPassengers) {
		this.allPassengers = allPassengers;
	}
	public Airport getAirportFrom() {
		return airportFrom;
	}
	public void setAirportFrom(Airport airportFrom) {
		this.airportFrom = airportFrom;
	}
	public Airport getAirportTo() {
		return airportTo;
	}
	public void setAirportTo(Airport airportTo) {
		this.airportTo = airportTo;
	}
	public int getFlightNr() {
		return flightNr;
	}
	public boolean addNewPassengerByBoardingPass(Passenger passenger) {
		//Check if passenger is already registered in this flight
		for(BoardingPass temp : allPassengers) {
			if(temp.getPassenger().equals(passenger)) {
				return false;
			}
		}
		BoardingPass pass = new BoardingPass(passenger);
		allPassengers.add(pass);
		System.out.println(pass);
		return true;
	}
	@SuppressWarnings("static-access")
	@Override
	public void generateNr() {
		this.flightNr = this.airportTo.flightCounter;
		this.airportTo.flightCounter++;
	}
	@Override
	public String toString() {
		return "Flight [flightNr=" + flightNr + ", dateAndTime=" + dateAndTime + ", duration=" + duration
				+ ", allPassengers=" + allPassengers + ", airportFrom=" + airportFrom + ", airportTo=" + airportTo
				+ "]";
	}
	
	
}
