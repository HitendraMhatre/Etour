package com.etour.services;

import java.util.List;
import java.util.Optional;

import com.etour.dto.*;
import com.etour.entities.Booking_Master;

public interface BookingManager {

	void save(Booking_Master ref);
	List<Booking_Master> getAll();
	void delete(int id);
	void update(Booking_Master category,int id);
	Optional<Booking_Master> getBooking(int id);
public BookingRequest updateBookings(BookingRequest book);
}