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

import com.etour.entities.Booking_Master;
import com.etour.entities.Category_Master;
import com.etour.entities.Cost_Master;
import com.etour.services.Category_MasterManager;
import com.etour.services.Cost_MasterManager;
@RestController  
@CrossOrigin("http://localhost:3000")
public class Cost_MasterController {

	@Autowired
	private Cost_MasterManager  costManager;
	 @GetMapping(value = "api/costs")
	public List<Cost_Master> getCosts(){
		return costManager.getAll();
	}
	 @PostMapping(value = "api/costs")
	public void addCost(@RequestBody Cost_Master cost){
		System.out.println("addBooking called");
		costManager.save(cost);
	}
	 @GetMapping(value = "api/costs/{pid}")
	 public Optional<Cost_Master> getCost(@PathVariable int pid)
	 {
		Optional<Cost_Master> p=costManager.getCost(pid);
		return p;
	 }
	 @DeleteMapping(value = "api/costs/{pid}")
	 public void removeCost(@PathVariable int pid)
	 {
		 costManager.delete(pid);
	 }
	 @PutMapping(value = "api/costs/{pid}")
	 public void updateCost(@RequestBody Cost_Master cost,@PathVariable int pid)
	 {
		System.out.println("inside updatecost of controller");
		costManager.update(cost,pid);
	 }
}
