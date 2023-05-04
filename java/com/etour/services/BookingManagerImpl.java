package com.etour.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etour.dto.BookingRequest;
import com.etour.entities.Booking_Master;
import com.etour.entities.Passenger_Master;
import com.etour.repositories.Booking_MasterRepository;
import com.etour.repositories.Passenger_MasterRepo;
@Service
public class BookingManagerImpl implements BookingManager{
	
	@Autowired
	Booking_MasterRepository bookmasterrepository;
	
	@Autowired
	Passenger_MasterRepo passrepository;
	
	
	@Override
	public void save(Booking_Master ref) {
		// TODO Auto-generated method stub
		bookmasterrepository.save(ref);
	}

	@Override
	public List<Booking_Master> getAll() {
		// TODO Auto-generated method stub
		return bookmasterrepository.findAll();
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		bookmasterrepository.deleteById(id);
	}

	@Override
	public void update(Booking_Master booking, int id) {
		// TODO Auto-generated method stub
		bookmasterrepository.update(booking.getBookingdate(), booking.getNoofpassenger(), booking.getTouramount(), booking.getTaxes(), booking.getTotalamount(), booking.getBookcustomerid(), booking.getBookmasterid(), booking.getBookdepartureid(), booking.isStatus(), id);
	}

	@Override
	public Optional<Booking_Master> getBooking(int id) {
		// TODO Auto-generated method stub
		return bookmasterrepository.findById(id);
	}

	
	
	
	
	
	@Override
	public BookingRequest updateBookings(BookingRequest book) {
		double amt=0;
		final double _tax = 0.18;
		double total = 0;
		double taxAmount=0;
		
		
		
		List<Passenger_Master>passengers=book.getPassengers();		
		for(Passenger_Master p : passengers)
		{
			amt+=p.getAmount();
		}
		
		book.getBooking().setTouramount(amt);
		
		taxAmount= amt * _tax;
		book.getBooking().setTaxes(taxAmount);
		
		total= amt+taxAmount ;
		book.getBooking().setTotalamount(total);
		
		//Confirm booking
		book.getBooking().setStatus(true);
		//posting the record for booking
		bookmasterrepository.save(book.getBooking());
		//retrieving the most recent inserted record to obtain its bookingid
		Booking_Master latest_booking=bookmasterrepository.getLatestBooking();
		//retrieving booking_id
		int bookingid=latest_booking.getBookingid();
		
		for(Passenger_Master p : passengers)
		{
			p.setPassbookingid(bookingid);
			passrepository.save(p);
		}
		
		return book;
	}

}