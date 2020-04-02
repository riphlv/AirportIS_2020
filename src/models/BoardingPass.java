package models;
import java.util.Random;

import ifaces.INumberGenerator;

public class BoardingPass implements INumberGenerator, Comparable<BoardingPass> {
	private String boardingPassNr;
	private short group;
	private Seat seat;
	private Passenger passenger;
	
	public BoardingPass(Passenger passenger) {
		setPassenger(passenger);
		generateGroupByPriority();
		generateSeatByPriority();
		generateNr();
	}

	public Seat getSeat() {
		return seat;
	}

	public void setSeat(Seat seat) {
		this.seat = seat;
	}

	public Passenger getPassenger() {
		return passenger;
	}

	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}

	public String getNr() {
		return boardingPassNr;
	}
	
	public void generateGroupByPriority() {
		//TODO VIP stuff
		Random rand = new Random();
		//random number between 2 and 5
		int number = rand.nextInt((5-2)+1)+2;
		this.boardingPassNr = ""+number;
	}
	
	public void generateSeatByPriority() {
		//ROW 		- A B C D E F
		//COLUMN 	- 1 2 3
		Random rand = new Random();
		//ASCII 97 to 102 = a b c d e f
		//ASCII 65 to 70 = A B C D E F
		char row = (char) (rand.nextInt((70-65)+1)+65);
		short column = (short)(rand.nextInt((3-1)+1)+1);
		setSeat(new Seat(row, column));
		//TODO
	}

	@Override
	public void generateNr() {
		this.boardingPassNr = this.passenger.getName().substring(0,1)
				+ this.passenger.getSurname().substring(0,1)
				+ this.seat.getSeat()+this.seat.getRow()+this.group;
	}

	@Override
	public int compareTo(BoardingPass o) {
		// TODO Auto-generated method stub
		if(passenger instanceof VIPPassenger) {
			return 1;
		}else if(o.getPassenger() instanceof Passenger){
			return -1;
		}
		return 0;
	}

	@Override
	public String toString() {
		return "BoardingPass [boardingPassNr=" + boardingPassNr + ", group=" + group + ", seat=" + seat + ", passenger="
				+ passenger + ", getSeat()=" + getSeat() + ", getPassenger()=" + getPassenger() + ", getNr()=" + getNr()
				+ "]";
	}
	
	
}
