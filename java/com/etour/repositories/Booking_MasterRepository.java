package com.etour.repositories;

import java.sql.Date;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.etour.entities.Booking_Master;
@Repository
@Transactional
public interface Booking_MasterRepository extends JpaRepository<Booking_Master,Integer> 
{

	@Query(nativeQuery = true, value = "SELECT * FROM Booking_Master ORDER BY Bookingid DESC LIMIT 1")
	Booking_Master getLatestBooking();
	
	
	
	@Modifying
	@Query("update Booking_Master p set p.bookingdate = :bookingdate, p.noofpassenger=:noofpassenger,p.touramount = :touramount, p.taxes=:taxes,p.totalamount=:totalamount,p.bookcustomerid=:bookcustomerid,p.bookmasterid=:bookmasterid,p.bookdepartureid=:bookdepartureid,p.Status=:Status where p.bookingid = :id")
	void update(@Param("bookingdate") Date bookingdate,@Param("noofpassenger")int noofpassenger,@Param("touramount") double touramount,@Param("taxes") double taxes,@Param("totalamount") double totalamount,@Param("bookcustomerid") int bookcustomerid,@Param("bookmasterid") int bookmasterid,@Param("bookdepartureid") int bookdepartureid,@Param("Status") boolean Status,@Param("id")int id);
	
	
	
}