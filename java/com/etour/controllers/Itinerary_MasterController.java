package com.etour.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.etour.dto.ItineraryDto;
import com.etour.entities.Date_Master;
import com.etour.entities.Itinerary_Master;
import com.etour.services.Date_MasterManager;
import com.etour.services.Itinerary_MasterManager;

@RestController  
@CrossOrigin("http://localhost:3000")
public class Itinerary_MasterController {
	@Autowired
	private Itinerary_MasterManager  itineraryManager;
	 @GetMapping(value = "api/itineraries")
	public List<Itinerary_Master> getItineraries(){
		return itineraryManager.getAll();
	}
	 @PostMapping(value = "api/itineraries")
	public void addItineraries(@RequestBody Itinerary_Master itinerary){
		System.out.println("add dates called");
		itineraryManager.save(itinerary);
	}
	 @GetMapping(value = "api/itineraries/{pid}")
	 public Optional<Itinerary_Master> getItinerary(@PathVariable int pid)
	 {
		Optional<Itinerary_Master> p=itineraryManager.getItinerary(pid);
		return p;
	 }
	 @DeleteMapping(value = "api/itineraries/{pid}")
	 public void removeItinerary(@PathVariable int pid)
	 {
		 itineraryManager.delete(pid);
	 }
	 @PutMapping(value = "api/itineraries/{pid}")
	 public void updateItinerary(@RequestBody Itinerary_Master itinerary,@PathVariable int pid)
	 {
		System.out.println("inside updateItinerary of controller");
		itineraryManager.update(itinerary,pid);
	 }
	 
	 
	 @GetMapping("api/itinerary/{id}")
	    public ResponseEntity<List<ItineraryDto>> getItineraryById(@PathVariable Integer id) {
	        List<ItineraryDto> itinerary = itineraryManager.findItineraryById(id);
	        return ResponseEntity.ok(itinerary);
	    }
}
