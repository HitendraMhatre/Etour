package com.etour.dto;

import java.util.List;

import com.etour.entities.Booking_Master;
import com.etour.entities.Passenger_Master;

public class BookingRequest {
	private Booking_Master booking;

	private List<Passenger_Master> passengers;

	
	public BookingRequest()
	{
		
	}
	

@Override
	public String toString() {
		return "BookingRequest [booking=" + booking + ", passengers=" + passengers + "]";
	}


public BookingRequest(Booking_Master booking, List<Passenger_Master> passengers) {
	super();
	this.booking = booking;
	this.passengers = passengers;
}
	
	public Booking_Master getBooking() {
		return booking;
	}

	public void setBooking(Booking_Master booking) {
		this.booking = booking;
	}

	public List<Passenger_Master> getPassengers() {
		return passengers;
	}

	public void setPassengers(List<Passenger_Master> passengers) {
		this.passengers = passengers;
	}

}