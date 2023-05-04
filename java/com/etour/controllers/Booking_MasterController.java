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
import com.etour.services.BookingManager;


@RestController  
@CrossOrigin("http://localhost:3000")
public class Booking_MasterController {

	@Autowired
	private BookingManager  booking_manager;
	 @GetMapping(value = "api/bookings")
	public List<Booking_Master> getBookings(){
		return booking_manager.getAll();
	}
	 @PostMapping(value = "api/postbookings")
	public void addBooking(@RequestBody Booking_Master booking){
		System.out.println("addBooking called");
		booking_manager.save(booking);
	}
	 
	 @GetMapping(value = "api/bookings/{pid}")
	 public Optional<Booking_Master> getBooking(@PathVariable int pid)
	 {
		Optional<Booking_Master> p=booking_manager.getBooking(pid);
		return p;
	 }
	 @DeleteMapping(value = "api/bookings/{pid}")
	 public void removeBooking(@PathVariable int pid)
	 {
		 booking_manager.delete(pid);
	 }
	 @PutMapping(value = "api/bookings/{pid}")
	 public void updateBooking(@RequestBody Booking_Master product,@PathVariable int pid)
	 {
		System.out.println("inside updatebooking of controller");
		booking_manager.update(product,pid);
	 }
}
