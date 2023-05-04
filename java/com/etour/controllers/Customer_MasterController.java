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

import com.etour.entities.Cost_Master;
import com.etour.entities.Customer_Master;
import com.etour.services.Cost_MasterManager;
import com.etour.services.Customer_MasterManager;

@RestController  
@CrossOrigin("http://localhost:3000")
public class Customer_MasterController {
	@Autowired
	private Customer_MasterManager  customerManager;
	 @GetMapping(value = "api/customers")
	public List<Customer_Master> getCustomers(){
		return customerManager.getAll();
	}
	 @PostMapping(value = "api/customers")
	public void addCustomers(@RequestBody Customer_Master cost){
		System.out.println("addBooking called");
		customerManager.save(cost);
	}
	 @GetMapping(value = "api/customers/{pid}")
	 public Optional<Customer_Master> getCustomer(@PathVariable int pid)
	 {
		Optional<Customer_Master> p=customerManager.getCustomer(pid);
		return p;
	 }
	 @DeleteMapping(value = "api/customers/{pid}")
	 public void removeCustomer(@PathVariable int pid)
	 {
		 customerManager.delete(pid);
	 }
	 @PutMapping(value = "api/customers/{pid}")
	 public void updateCustomer(@RequestBody Customer_Master cost,@PathVariable int pid)
	 {
		System.out.println("inside updateCustomer of controller");
		customerManager.update(cost,pid);
	 }
}
