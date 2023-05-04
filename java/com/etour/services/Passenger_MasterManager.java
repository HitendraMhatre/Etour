package com.etour.services;

import java.util.List;
import java.util.Optional;

import com.etour.entities.Booking_Master;
import com.etour.entities.Passenger_Master;

public interface Passenger_MasterManager {

	
	void save(Passenger_Master ref);
	List<Passenger_Master> getAll();
	void delete(int id);
	void update(Passenger_Master passenger,int id);
	Optional<Passenger_Master> getPassenger(int id);
}
