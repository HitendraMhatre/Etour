package com.etour.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.etour.dto.BookingRequest;
import com.etour.services.BookingManager;

@RestController
@CrossOrigin("http://localhost:3000")
public class BookingController {

	@Autowired
	private BookingManager manager;
	
	
	@PostMapping("/api/booking")
	private BookingRequest addBooking(@RequestBody BookingRequest book)
	{
		System.out.println("In controller\t"+book);
		
		if(book == null)
		{
		
			System.out.println("Ues");
		}
		else
		{
			System.out.println(book.getBooking());
		}
		return manager.updateBookings(book);
		
	}
	
	
	
	
	
	
	
	
}