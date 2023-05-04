package com.etour.services;

import java.util.List;
import java.util.Optional;

import com.etour.dto.ItineraryDto;
import com.etour.entities.Itinerary_Master;

public interface Itinerary_MasterManager {

	
	void save(Itinerary_Master ref);
	List<Itinerary_Master> getAll();
	void delete(int id);
	void update(Itinerary_Master date,int id);
	Optional<Itinerary_Master> getItinerary(int id);
	
	public List<ItineraryDto> findItineraryById(Integer id);
	
	
	
}
