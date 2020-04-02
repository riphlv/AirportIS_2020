package models;

import enums.IdenType;
import enums.Nationality;
import ifaces.INumberGenerator;

public class VIPPassenger extends Passenger implements INumberGenerator{
	private int vipNr;
	private String loungeCardNr;
	private static int idCounter = 0;
	public VIPPassenger(String loungeCardNr) {
		super();
		this.loungeCardNr = loungeCardNr;
		generateNr();
	}
	public VIPPassenger(String name, String surname, Nationality nationality, IdenType idenType, String idenNr,
			Boolean isAdult, String extraNeeds, String loungeCardNr) {
		super(name, surname, nationality, idenType, idenNr, isAdult, extraNeeds);
		this.loungeCardNr = loungeCardNr;
		generateNr();
	}
	public String getLoungeCardNr() {
		return loungeCardNr;
	}
	public void setLoungeCardNr(String loungeCardNr) {
		this.loungeCardNr = loungeCardNr;
	}
	@Override
	public int getVipNr() {
		return vipNr;
	}
	public void generateExtraNeeds() {
		//TODO
	}
	@SuppressWarnings("static-access")
	@Override
	public void generateNr() {
		this.vipNr = this.idCounter;
		this.idCounter++;
		
	}
	@Override
	public String toString() {
		return "VIPPassenger [vipNr=" + vipNr + ", loungeCardNr=" + loungeCardNr + ", toString()=" + super.toString()
				+ "]";
	}
	
	
}
