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

import com.etour.entities.Customer_Master;
import com.etour.entities.Date_Master;
import com.etour.services.Customer_MasterManager;
import com.etour.services.Date_MasterManager;

@RestController  
@CrossOrigin("http://localhost:3000")
public class Date_MasterController {
	@Autowired
	private Date_MasterManager  dateManager;
	 @GetMapping(value = "api/dates")
	public List<Date_Master> getDates(){
		return dateManager.getAll();
	}
	 @PostMapping(value = "api/dates")
	public void addDate(@RequestBody Date_Master date){
		System.out.println("add dates called");
		dateManager.save(date);
	}
	 @GetMapping(value = "api/dates/{pid}")
	 public Optional<Date_Master> getDate(@PathVariable int pid)
	 {
		Optional<Date_Master> p=dateManager.getDate(pid);
		return p;
	 }
	 @DeleteMapping(value = "api/dates/{pid}")
	 public void removeDate(@PathVariable int pid)
	 {
		 dateManager.delete(pid);
	 }
	 @PutMapping(value = "api/dates/{pid}")
	 public void updateDate(@RequestBody Date_Master date,@PathVariable int pid)
	 {
		System.out.println("inside updateDate of controller");
		dateManager.update(date,pid);
	 }
}
