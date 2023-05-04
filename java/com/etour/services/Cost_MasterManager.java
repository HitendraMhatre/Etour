package com.etour.services;

import java.util.List;
import java.util.Optional;

import com.etour.entities.Booking_Master;
import com.etour.entities.Cost_Master;

public interface Cost_MasterManager {
	void save(Cost_Master ref);
	List<Cost_Master> getAll();
	void delete(int id);
	void update(Cost_Master cost,int id);
	Optional<Cost_Master> getCost(int id);
}
