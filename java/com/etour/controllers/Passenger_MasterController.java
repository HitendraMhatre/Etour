package com.etour.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.etour.entities.Itinerary_Master;
import com.etour.entities.Passenger_Master;
import com.etour.services.Passenger_MasterManager;
@RestController  
@CrossOrigin("http://localhost:3000")
public class Passenger_MasterController {
	@Autowired
	private Passenger_MasterManager  passengerManager;
	 @GetMapping(value = "api/passengers")
	public List<Passenger_Master> getPassengers(){
		return passengerManager.getAll();
	}
	 @PostMapping(value = "api/passengers")
	public void addPassengers(@RequestBody Passenger_Master passenger){
		System.out.println("add passenger called");
		passengerManager.save(passenger);
	}
	 @GetMapping(value = "api/passengers/{pid}")
	 public Optional<Passenger_Master> getPassenger(@PathVariable int pid)
	 {
		Optional<Passenger_Master> p=passengerManager.getPassenger(pid);
		return p;
	 }
	 @DeleteMapping(value = "api/passengers/{pid}")
	 public void removePassenger(@PathVariable int pid)
	 {
		 passengerManager.delete(pid);
	 }
	 @PutMapping(value = "api/passengers/{pid}")
	 public void updatePassenger(@RequestBody Passenger_Master passenegr,@PathVariable int pid)
	 {
		System.out.println("inside updatePassenger of controller");
		passengerManager.update(passenegr,pid);
	 }
}
