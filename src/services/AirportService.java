package services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

import enums.AirportName;
import enums.IdenType;
import enums.Nationality;
import models.Airport;
import models.BoardingPass;
import models.Flight;
import models.Passenger;
import models.VIPPassenger;

public class AirportService {
	private ArrayList<Passenger> allPassengers;
	private ArrayList<BoardingPass> allBoardingPasses;
	private ArrayList<Airport> allAirports;
	private ArrayList<Flight> allFlights = new ArrayList<Flight>();
	public AirportService() {
		this.allPassengers = new ArrayList<>();
		this.allBoardingPasses = new ArrayList<>();
		this.allAirports = new ArrayList<>();
	}
	public static void main(String[] args) {
		AirportService s = new AirportService();
		s.addNewAirport(AirportName.RIGA , 200);
		s.addNewAirport(AirportName.BARSELONA , 300);
		s.addNewAirport(AirportName.OSLO , 250);
		s.addNewAirport(AirportName.TALLIN , 230);
		s.addNewAirport(AirportName.TALLIN , 252);
		/*
		System.out.println();
		s.deleteAirportByAirportName(AirportName.TALLIN);
		s.deleteAirportByAirportNr(s.allAirports.get(3).getAirportNr());
		s.sortAllAirportsByCapacity();
		*/
		Date date = new Date();
		
		s.addNewFlight(s.allAirports.get(0), s.allAirports.get(1), date, (byte)100);
		s.addNewFlight(s.allAirports.get(0), s.allAirports.get(2), date, (byte)90);
		s.addNewFlight(s.allAirports.get(1), s.allAirports.get(2), date, (byte)50);
		s.addNewFlight(s.allAirports.get(2), s.allAirports.get(0), date, (byte)90);
		s.addNewFlight(s.allAirports.get(1), s.allAirports.get(0), date, (byte)100);
		
		s.addNewPassenger("Janis", "Berzins", Nationality.LATVIAN, IdenType.PASSPORT, "12345", true, "");
		s.addNewPassenger("Edgars", "Sprogis", Nationality.ESTONIAN, IdenType.PASSPORT, "14124", true, "");
		s.addNewPassenger("Mikus", "Abele", Nationality.ITALIAN, IdenType.PASSPORT, "45223", true, "");
		s.addNewVipPassenger("Jana", "Krumina", Nationality.LATVIAN, IdenType.PASSPORT, "12312", true, "", "123");
		s.addNewVipPassenger("Gints", "Dzelzs", Nationality.LATVIAN, IdenType.PASSPORT, "12315", true, "", "124");
		s.addNewVipPassenger("Gunta", "Kale", Nationality.LATVIAN, IdenType.PASSPORT, "12318", true, "", "125");
		
	
		s.addNewBoardingPassByObjects(s.allFlights.get(0), s.allPassengers.get(0));
		s.addNewBoardingPassByObjects(s.allFlights.get(0), s.allPassengers.get(1));
		s.addNewBoardingPassByObjects(s.allFlights.get(1), s.allPassengers.get(2));
		s.addNewBoardingPassByObjects(s.allFlights.get(0), s.allPassengers.get(3));
		s.addNewBoardingPassByObjects(s.allFlights.get(2), s.allPassengers.get(4));
		//s.addNewBoardingPassByObjects(s.allFlights.get(3), s.allPassengers.get(5));
		//System.out.println(s.allPassengers.get(5).getIdenNr());
		//s.addNewBoardingPassByNr(AirportName.RIGA, s.allFlights.get(1).getFlightNr(), s.allPassengers.get(5).getIdenNr());
		
		
		//Delete methods
//		 System.out.println(s.allPassengers.size());
//		 s.deletePassengerByNameAndSurname("Mikus", "Abele");
//		 s.deletePassengerByIdenNr(s.allPassengers.get(0).getIdenNr());
//		 s.deleteVipPassengerVipNr(s.allPassengers.get(4).getVipNr());
//		 System.out.println(s.allPassengers.size());
		
//		 System.out.println(s.allBoardingPasses.size());
//		 s.deleteBoardingPassByBoardingPassNr(s.allBoardingPasses.get(0).getNr());
//		 System.out.println(s.allBoardingPasses.size()); 
		
//		 System.out.println(s.allFlights.size());
//		 s.deleteFlightInAirportByNr(AirportName.RIGA, 1);
//		 System.out.println(s.allFlights.size());
		 
		//Add methods
//		s.addNewVipPassenger("Asd", "Fgh", Nationality.ITALIAN, IdenType.IDCARD, "55555", true, "","555");
//		System.out.println();
//		for(BoardingPass pass : s.allFlights.get(0).getAllPassengers()) {
//			System.out.println(pass);
//		}
//		System.out.println();
//		s.addRegularPassengerInFlight(AirportName.RIGA, 0, "55555");
//		s.addVipPassengerInFlight(AirportName.RIGA, 0, "55555");
//		System.out.println();
//		for(BoardingPass pass : s.allFlights.get(0).getAllPassengers()) {
//			System.out.println(pass);
//		}
//		System.out.println(s.allFlights.size());
		
		System.out.println("---");
		//Show methods
		//s.showAllPassengersInFlight(AirportName.RIGA, 0);
		//s.showOnlyVIPPassengersInFlight(AirportName.RIGA, 0);
		//s.showAllFlightsFromAirport(AirportName.RIGA);
		//s.showAllArrivalsByTimeInAirport(AirportName.RIGA);
		s.showAllFlightsFromAirport(AirportName.RIGA);
		
		
	}
	public boolean addNewPassenger(String name, String surname, Nationality nationality, IdenType idenType, String idenNr, boolean isAdult, String extraNeeds) {
		Passenger newP = new Passenger(name, surname, nationality, idenType, idenNr, isAdult, extraNeeds);
		if(allPassengers.size() == 0) {
			this.allPassengers.add(newP);
			System.out.println(newP);
			return true;
		}
		for(Passenger temp : allPassengers) {
			if(temp.equals(newP)) {
				return false;
			}else {
				this.allPassengers.add(newP);
				System.out.println(newP);
				return true;
			}
		}
		return false;
	}
	public boolean addNewVipPassenger(String name, String surname, Nationality nationality, IdenType idenType, String idenNr, boolean isAdult, String extraNeeds, String loungeCardNr) {
		VIPPassenger newP = new VIPPassenger(name, surname, nationality, idenType, idenNr, isAdult, extraNeeds, loungeCardNr);
		for(Passenger temp : allPassengers) {
			if(temp.equals(newP)) {
				return false;
			}else {
				this.allPassengers.add(newP);
				System.out.println(newP);
				return true;
			}
		}
		return false;
	}
	public boolean addNewAirport(AirportName name, int capacity) {
		Airport newPort = new Airport(name, capacity);
		if(allAirports.size() == 0) {
			this.allAirports.add(newPort);
			System.out.println(newPort);
			return true;
		}
		for(Airport temp : allAirports) {
			if(temp.equals(newPort)) {
				return false;
			}else {
				this.allAirports.add(newPort);
				System.out.println(newPort);
				return true;
			}
		}
		return false;
	}
	public boolean addNewBoardingPassByObjects(Flight flight, Passenger passenger) {
		if(flight.addNewPassengerByBoardingPass(passenger)) {
			allBoardingPasses.add(flight.getAllPassengers().peek());
			//allFlights.add(flight);
			return true;
		}else {
			return false;
		}
	}
	public boolean addNewBoardingPassByNr(AirportName airportName, int flightNr, String passengerId) {
		for(Flight flight : allFlights) {
			if(flight.getFlightNr() == flightNr && flight.getAirportFrom().getName().equals(airportName)) {
				for(Passenger passenger : allPassengers) {
					if(passenger.getIdenNr().equals(passengerId)) {
						flight.addNewPassengerByBoardingPass(passenger);
						allBoardingPasses.add(flight.getAllPassengers().peek());
						//allFlights.add(flight);
						return true;
					}
				}
			}
		}
		return false;
	}
	public boolean addNewFlight(Airport airportFrom, Airport airportTo, Date date, byte duration) {
		if(airportFrom.equals(airportTo)) {
			return false;
		}else {
			Flight temp = new Flight(airportFrom, airportTo, date, duration);
			allFlights.add(temp);
			System.out.println(temp);
			return true;
		}
	}
	public boolean deletePassengerByNameAndSurname(String name, String surname) {
		for(Passenger passenger : allPassengers) {
			if(passenger.getName().equals(name) && passenger.getSurname().equals(surname)) {
				allPassengers.remove(passenger);
				return true;
			}
		}
		return false;
	}
	public boolean deletePassengerByIdenNr(String idenNr) {
		for(Passenger passenger : allPassengers) {
			if(passenger.getIdenNr().equals(idenNr)) {
				allPassengers.remove(passenger);
				return true;
			}
		}
		return false;
	}
	public boolean deleteVipPassengerVipNr(int vipNr) {
		//check all passenger list
		for(int i = 0 ; i < allPassengers.size(); i++) {
			if(allPassengers.get(i) instanceof VIPPassenger && allPassengers.get(i).getVipNr() == vipNr) {
				allPassengers.remove(allPassengers.get(i));
				return true;
			}
		}
		return false;
	}
	public boolean deleteAirportByAirportNr(String airportNr){
		for(Airport airport : allAirports) {
			if(airport.getAirportNr().equals(airportNr)) {
				allAirports.remove(airport);
				return true;
			}
		}
		return false;
	}
	public boolean deleteAirportByAirportName(AirportName name) {
		for(Airport airport : allAirports) {
			if(airport.getName().equals(name)) {
				allAirports.remove(airport);
				return true;
			}
		}
		return false;
	}
	public boolean deleteBoardingPassByBoardingPassNr(String BoardingPassNr) {
		for(BoardingPass pass : allBoardingPasses) {
			if(pass.getNr().equals(BoardingPassNr)) {
				allBoardingPasses.remove(pass);
				return true;
			}
		}
		return false;
	}
	public boolean deleteFlightInAirportByNr(AirportName airportName, int flightNr) {
		for(Flight flight : allFlights) {
			if(flight.getAirportFrom().getName().equals(airportName)&& flight.getFlightNr() == flightNr) {
				allFlights.remove(flight);
				return true;
			}
		}
		return false;
	}
	public boolean addRegularPassengerInFlight(AirportName airportName, int flightNr , String idenNr) {
		for(Flight flight : allFlights) {
			if(flight.getFlightNr() == flightNr && flight.getAirportFrom().getName().equals(airportName)) {
				for(Passenger passenger : allPassengers) {
					if(passenger.getIdenNr().equals(idenNr)) {
						flight.addNewPassengerByBoardingPass(passenger);
						return true;
					}
				}
			}
		}
		return false;
	}
	public boolean addVipPassengerInFlight(AirportName airportName, int flightNr, String idenNr) {
		for(Flight flight : allFlights) {
			if(flight.getFlightNr() == flightNr && flight.getAirportFrom().getName().equals(airportName)) {
				for(Passenger passenger : allPassengers) {
					if(passenger.getIdenNr().equals(idenNr)) {
						flight.addNewPassengerByBoardingPass(passenger);
						return true;
					}
				}
			}
		}
		return false;
	}
	public void showAllPassengersInFlight(AirportName airportFrom, int flightNr) {
		for(Flight flight : allFlights) {
			if(flight.getFlightNr() == flightNr && flight.getAirportFrom().getName().equals(airportFrom)) {
				System.out.println("FLIGHT: " + flight.getAirportFrom() + " to " + flight.getAirportTo());
				for(BoardingPass passenger : flight.getAllPassengers()) {
					System.out.println(passenger);
				}
			}
		}
	}
	public void showOnlyVIPPassengersInFlight(AirportName airportFrom, int flightNr) {
		for(Flight flight : allFlights) {
			if(flight.getFlightNr() == flightNr && flight.getAirportFrom().getName().equals(airportFrom)) {
				System.out.println("FLIGHT: " + flight.getAirportFrom() + " to " + flight.getAirportTo());
				for(BoardingPass passenger : flight.getAllPassengers()) {
					if(passenger.getPassenger() instanceof VIPPassenger ) {
						System.out.println(passenger);
					}
				}
				break;
			}
		}
	}
	public void showAllFlightsFromAirport(AirportName airportName) {
		for(Flight flight : allFlights) {
			if(flight.getAirportFrom().getName().equals(airportName)) {
				System.out.println(flight);
			}
		}
	}
	public void sortAllFlightsInDay() {
		for(int i = 0 ; i < allFlights.size()-1; i++) {
			for(int j = 0; j < allFlights.size()-i-1;j++) {
				if(allFlights.get(j).getDateAndTime().compareTo(allFlights.get(i).getDateAndTime()) > 0) {
					Collections.swap(allFlights, i, j);
				}
			}
		}
		for(Flight flight : allFlights) {
			System.out.println(flight);
		}
	}
	public void showAllArrivalsByTimeInAirport(AirportName airportTo) {
		sortAllFlightsInDay();
		System.out.println("Arrival flights: ");
		for(Flight flight : allFlights) {
			if(flight.getAirportTo().getName().equals(airportTo)) {
				System.out.println(flight);
			}
		}
	}
	public void sortAllAirportsByCapacity() {
		for(int i = 0 ; i < allAirports.size()-1; i++) {
			for(int j = 0; j < allAirports.size()-i-1;j++) {
				if(allAirports.get(j).getCapacity() < allAirports.get(i).getCapacity()) {
					Collections.swap(allAirports, i, j);
				}
			}
		}
		for(Airport airp : allAirports) {
			System.out.println(airp);
		}
	}
	
}
