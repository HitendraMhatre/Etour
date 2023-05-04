package com.etour.services;

import com.etour.dto.BookingRequest;
import com.etour.entities.Booking_Master;

public interface InvoiceManager {
 
	BookingRequest getInvoice(int id);
	
	Booking_Master printInvoice();
}
