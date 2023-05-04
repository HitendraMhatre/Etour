package com.etour.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etour.dto.BookingRequest;
import com.etour.entities.Booking_Master;
import com.etour.entities.Passenger_Master;
import com.etour.repositories.Booking_MasterRepository;
import com.etour.repositories.Passenger_MasterRepo;


@Service
public class InvoiceManagerImpl implements InvoiceManager {
	
	@Autowired
	Booking_MasterRepository bkrepository;
	
	@Autowired
	Passenger_MasterRepo passrepository;
	
	
	@Override
	public BookingRequest getInvoice(int id) {
		// TODO Auto-generated method stub
		Booking_Master booking = bkrepository.getLatestBooking();
		System.out.println("Booking:"+booking);
		List<Passenger_Master> passengers = passrepository.getpassengers(id);
		System.out.println("passenegrs:"+passengers);
		BookingRequest book = new BookingRequest(booking , passengers);
		System.out.println("invoice"+book);
		return book;
	}


	@Override
	public Booking_Master printInvoice() {
		// TODO Auto-generated method stub
		
		return bkrepository.getLatestBooking();
	}
	

}
