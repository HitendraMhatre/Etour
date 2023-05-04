package com.etour.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.etour.dto.AdminDTO;
import com.etour.dto.AdminResponse;
import com.etour.entities.Admin;
import com.etour.entities.Booking_Master;
import com.etour.entities.Category_Master;
import com.etour.entities.Cost_Master;
import com.etour.entities.Customer_Master;
import com.etour.entities.Date_Master;
import com.etour.entities.Itinerary_Master;
import com.etour.entities.Passenger_Master;
import com.etour.services.AdminManagerImpl;
import com.etour.services.BookingManagerImpl;
import com.etour.services.Category_MasterManagerImpl;
import com.etour.services.Cost_MasterManagerImpl;
import com.etour.services.Customer_MasterManagerImpl;
import com.etour.services.Date_MasterManagerImpl;
import com.etour.services.Itinerary_MasterManagerImpl;
import com.etour.services.Passenger_MasterManagerImpl;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin("http://localhost:3000")
public class AdminController 
{
	@Autowired
	AdminManagerImpl manager;
	
	@Autowired
	BookingManagerImpl bookmanager;
	
	@Autowired
	Cost_MasterManagerImpl costmanager;
	
	@Autowired
	Category_MasterManagerImpl categorymanager;
	
	@Autowired
	Date_MasterManagerImpl datemanager;
	
	@Autowired
	Itinerary_MasterManagerImpl itinerarymanager;
	
	@Autowired
	Passenger_MasterManagerImpl passengermanager;
	
	@Autowired
	Customer_MasterManagerImpl customermanager;
	
	
	//Login   
	@PostMapping(value="/login")
	public ResponseEntity<AdminResponse> login(@RequestBody AdminDTO admin)
	{
		return manager.login(admin);
	}
	
	
	//Admin managment
	

	@GetMapping(value="/showadmins")
	public List<Admin> getalladmin()
	{
		return manager.getAdmins();
	}
	
	@GetMapping(value="/descadmin/{id}")
	public Optional<Admin> getadmin(@PathVariable int id)
	{
		return manager.getAdmin(id);
	}
	
	@PutMapping(value="/updateadmin/{id}")
	public void upadteadmin(@RequestBody Admin admin ,@PathVariable int id)
	{
		manager.updateAdmin(admin, id);
	}
	
	@PostMapping(value="/addadmin")
	public void addadmin(@RequestBody Admin admin)
	{
		manager.addAdmin(admin);
	}
	
	//Admin manipulation of data
	
	/*
	 * category manipulation
	 */
	
	 @GetMapping(value = "/showcategories")
		public List<Category_Master> getCategories(){
			return categorymanager.getAll();
		}
//		 @GetMapping(value = "api/Hello")
//		public String Hello(){
//			return "Hello";
//		}
		 @GetMapping(value = "/desccategory/{pid}")
		 public Optional<Category_Master> getCategory(@PathVariable int pid)
		 {
			Optional<Category_Master> p=categorymanager.getCategory(pid);
			return p;
		 }
		 @DeleteMapping(value = "/deletecategory/{pid}")
		 public void removeCategory(@PathVariable int pid)
		 {
			 categorymanager.delete(pid);
		 }
		 @PutMapping(value = "/updatecategory/{pid}")
		 public void updateCategory(@RequestBody Category_Master product,@PathVariable int pid)
		 {
			//System.out.println("inside updatecategory of controller");
			categorymanager.update(product,pid);
		 }
		 @PostMapping(value = "api/addcategories")
		public void addCategory(@RequestBody Category_Master category){
			//System.out.println("add category called");
			categorymanager.save(category);
		}
		 
		 /*
		  * itineray manipulation
		  */
		 
		 @GetMapping(value = "/showitineraries")
			public List<Itinerary_Master> getItineraries()
		 {
				return itinerarymanager.getAll();
			}
			
			 @PostMapping(value = "/additinerary")
			public void addItineraries(@RequestBody Itinerary_Master itinerary){
				System.out.println("add dates called");
				itinerarymanager.save(itinerary);
			}
			 @GetMapping(value = "/descitinerary/{pid}")
			 public Optional<Itinerary_Master> getItinerary(@PathVariable int pid)
			 {
				Optional<Itinerary_Master> p=itinerarymanager.getItinerary(pid);
				return p;
			 }
			 @DeleteMapping(value = "/removeitinerary/{pid}")
			 public void removeItinerary(@PathVariable int pid)
			 {
				 itinerarymanager.delete(pid);
			 }
			 @PutMapping(value = "/updateitinerary/{pid}")
			 public void updateItinerary(@RequestBody Itinerary_Master itinerary,@PathVariable int pid)
			 {
				System.out.println("inside updateItinerary of controller");
				itinerarymanager.update(itinerary,pid);
			 }
			 
			 /*
			  * cost manipulation
			  */
			 
			 @GetMapping(value = "/showcosts")
				public List<Cost_Master> getCosts(){
					return costmanager.getAll();
				}
				 @PostMapping(value = "/addcost")
				public void addCost(@RequestBody Cost_Master cost){
					//System.out.println("addBooking called");
					costmanager.save(cost);
				}
				 @GetMapping(value = "/desccost/{pid}")
				 public Optional<Cost_Master> getCost(@PathVariable int pid)
				 {
					Optional<Cost_Master> p=costmanager.getCost(pid);
					return p;
				 }
				 @DeleteMapping(value = "/removecosts/{pid}")
				 public void removeCost(@PathVariable int pid)
				 {
					 costmanager.delete(pid);
				 }
				 @PutMapping(value = "/updatecost/{pid}")
				 public void updateCost(@RequestBody Cost_Master cost,@PathVariable int pid)
				 {
					System.out.println("inside updatecost of controller");
					costmanager.update(cost,pid);
				 }
				 
				 /*
				  * date-manipulation
				  */
				 
				 @GetMapping(value = "/showdates")
					public List<Date_Master> getDates(){
						return datemanager.getAll();
					}
					 @PostMapping(value = "/adddates")
					public void addDate(@RequestBody Date_Master date){
						System.out.println("add dates called");
						datemanager.save(date);
					}
					 @GetMapping(value = "/descdate/{pid}")
					 public Optional<Date_Master> getDate(@PathVariable int pid)
					 {
						Optional<Date_Master> p=datemanager.getDate(pid);
						return p;
					 }
					 @DeleteMapping(value = "/removedate/{pid}")
					 public void removeDate(@PathVariable int pid)
					 {
						 datemanager.delete(pid);
					 }
					 @PutMapping(value = "/updatedate/{pid}")
					 public void updateDate(@RequestBody Date_Master date,@PathVariable int pid)
					 {
						System.out.println("inside updateDate of controller");
						datemanager.update(date,pid);
					 }
					 
				 /*
				  * passenger-manipulation
				  */
					 

					 @GetMapping(value = "/showpassengers")
					public List<Passenger_Master> getPassengers(){
						return passengermanager.getAll();
					}
//					 @PostMapping(value = "/addpassengers")
//					public void addPassengers(@RequestBody Passenger_Master passenger){
//						System.out.println("add passenger called");
//						passengermanager.save(passenger);
//					}
					 @GetMapping(value = "/descpassenger/{pid}")
					 public Optional<Passenger_Master> getPassenger(@PathVariable int pid)
					 {
						Optional<Passenger_Master> p=passengermanager.getPassenger(pid);
						return p;
					 }
					 @DeleteMapping(value = "/removepassengers/{pid}")
					 public void removePassenger(@PathVariable int pid)
					 {
						 passengermanager.delete(pid);
					 }
//					 @PutMapping(value = "/updatepassenger/{pid}")
//					 public void updatePassenger(@RequestBody Passenger_Master passenegr,@PathVariable int pid)
//					 {
//						System.out.println("inside updatePassenger of controller");
//						passengermanager.update(passenegr,pid);
//					 }
					 
			/*
			 * booking manipulation
			 */
					 
					 @GetMapping(value = "/showbookings")
						public List<Booking_Master> getBookings(){
							return bookmanager.getAll();
						}
//						 @PostMapping(value = "/addbookings")
//						public void addsBooking(@RequestBody Booking_Master booking){
//							System.out.println("addBooking called");
//							bookmanager.save(booking);
//						}
						 
						 @GetMapping(value = "/descbooking/{pid}")
						 public Optional<Booking_Master> getBooking(@PathVariable int pid)
						 {
							Optional<Booking_Master> p=bookmanager.getBooking(pid);
							return p;
						 }
						 @DeleteMapping(value = "/removebookings/{pid}")
						 public void removeBooking(@PathVariable int pid)
						 {
							 bookmanager.delete(pid);
						 }
						 @PutMapping(value = "/updatebookings/{pid}")
						 public void updateBooking(@RequestBody Booking_Master product,@PathVariable int pid)
						 {
							 System.out.println(product);
							System.out.println("inside updatebooking of controller");
							bookmanager.update(product,pid);
						 }
					 

						 /**
						  * customer manipulation
						  */
						 @GetMapping(value = "/showcustomers")
							public List<Customer_Master> getCustomers(){
								return customermanager.getAll();
							}
//							 @PostMapping(value = "/addcustomers")
//							public void addCustomers(@RequestBody Customer_Master customer){
//								System.out.println("addBooking called");
//								customermanager.save(customer);
//							}
							 @GetMapping(value = "/desccustomer/{pid}")
							 public Optional<Customer_Master> getCustomer(@PathVariable int pid)
							 {
								Optional<Customer_Master> p=customermanager.getCustomer(pid);
								return p;
							 }
							 @DeleteMapping(value = "/reomovecustomer/{pid}")
							 public void removeCustomer(@PathVariable int pid)
							 {
								 customermanager.delete(pid);
							 }
							 @PutMapping(value = "/updatecustomer/{pid}")
							 public void updateCustomer(@RequestBody Customer_Master cost,@PathVariable int pid)
							 {
								System.out.println("inside updateCustomer of controller");
								customermanager.update(cost,pid);
							 }
}
