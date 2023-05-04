package com.etour.controllers;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.etour.dto.BookingRequest;
import com.etour.dto.ProductPDFExporter;
import com.etour.entities.Booking_Master;
import com.etour.services.InvoiceManager;
import com.lowagie.text.DocumentException;

@RestController
@CrossOrigin("http://localhost:3000")
public class InvoiceController {

	@Autowired
	InvoiceManager manager;
	
		@GetMapping("api/invoice")
	 Booking_Master getInvoice()
	 {
		 return manager.printInvoice();
	 }
		
		 @GetMapping("/api/invoice/export/pdf")
		    public void exportToPDF(HttpServletResponse response) throws DocumentException, IOException {
		        response.setContentType("application/pdf");
		        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		        String currentDateTime = dateFormatter.format(new Date());
		         
		        String headerKey = "Content-Disposition";
		        String headerValue = "attachment; filename=Customers_" + currentDateTime + ".pdf";
		        response.setHeader(headerKey, headerValue);
		         
		        Booking_Master invoice = manager.printInvoice();
		         
		        ProductPDFExporter exporter = new ProductPDFExporter(invoice);
		        exporter.export(response);
		         
		    }
}
