package models;

public class Seat {
	private char row;
	private short seat;
	
	public Seat(char row, short seat) {
		this.row = row;
		this.seat = seat;
	}
	public char getRow() {
		return row;
	}
	public void setRow(char row) {
		this.row = row;
	}
	public short getSeat() {
		return seat;
	}
	public void setSeat(short seat) {
		this.seat = seat;
	}
	@Override
	public String toString() {
		return "Seat [row=" + row + ", seat=" + seat + "]";
	}
	
}
