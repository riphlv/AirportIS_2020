package models;

import java.util.ArrayList;
import java.util.Random;

import enums.IdenType;
import enums.Nationality;
import services.Verifications;

public class Passenger extends Person {
	private boolean isAdult;
	private String extraNeeds;
	public Passenger() {
		super();
		this.isAdult = true;
		setExtraNeeds("none");
	}
	public Passenger(String name, String surname, Nationality nationality, IdenType idenType, String idenNr, Boolean isAdult, String extraNeeds) {
		super(name, surname, nationality, idenType, idenNr);
		this.isAdult = isAdult;
		setExtraNeeds(extraNeeds);
	}
	public boolean isAdult() {
		return isAdult;
	}
	public void setAdult(boolean isAdult) {
		this.isAdult = isAdult;
	}
	public String getExtraNeeds() {
		return extraNeeds;
	}
	public void setExtraNeeds(String extraNeeds) {
		Verifications.verifyText(extraNeeds);
	}
	public void generateExtraNeeds() {
		ArrayList<String> needs = new ArrayList<String>();
		Random rand = new Random();
		needs.add("Extra peanuts");
		needs.add("Cheapest booze");
		needs.add("Extra leg space");
		needs.add("Seat next to a window");
		needs.add("Pair of earbuds");
		needs.add("Pillow");
		this.extraNeeds = needs.get(rand.nextInt(needs.size()+1));
	}
	public int getVipNr() {
		return -1;
	}
	@Override
	public String toString() {
		return "Passenger [isAdult=" + isAdult + ", extraNeeds=" + extraNeeds + ", toString()=" + super.toString()
				+ "]";
	}
	
	
}
