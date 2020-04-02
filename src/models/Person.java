package models;
import enums.IdenType;
import enums.Nationality;
import services.Verifications;

public class Person {
	private String name;
	private String surname;
	private String idenNr;
	private Nationality nationality;
	private IdenType idenType;
	
	public Person(String name, String surname, Nationality nationality, IdenType idenType, String idenNr) {
		setName(name);
		setSurname(surname);
		this.nationality = nationality;
		this.idenType = idenType;
		this.idenNr = idenNr;
	}
	
	public Person() {
		setName("default");
		setSurname("default");
		this.nationality = Nationality.LATVIAN;
		this.idenType = IdenType.PASSPORT;
		this.idenNr = "none";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = Verifications.verifyName(name);
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = Verifications.verifyName(surname);
	}

	public String getIdenNr() {
		return idenNr;
	}

	public void setIdenNr(String idenNr) {
		this.idenNr = idenNr;
	}

	public Nationality getNationality() {
		return nationality;
	}

	public void setNationality(Nationality nationality) {
		this.nationality = nationality;
		/*
		for(Nationality temp : Nationality.values()) {
			if(temp.name().equals(nationality)) {
				this.nationality = nationality;
				return;
			}
		}
		this.nationality = Nationality.LATVIAN;
		*/
	}

	public IdenType getIdenType() {
		return idenType;
	}

	public void setIdenType(IdenType idenType) {
		this.idenType = idenType;
		/*
		for(IdenType temp : IdenType.values()) {
			if(temp.name().equals(idenType)) {
				this.idenType = idenType;
				return;
			}
		}
		this.idenType = IdenType.PASSPORT;
		*/
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", surname=" + surname + ", idenNr=" + idenNr + ", nationality=" + nationality
				+ ", idenType=" + idenType + "]";
	}
	
	
	
}
