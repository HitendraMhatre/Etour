package com.etour.repositories;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.etour.entities.Passenger_Master;

public interface Passenger_MasterRepo extends JpaRepository<Passenger_Master, Integer> {

	
	@Modifying
	@Query("update Passenger_Master p set p.paxname = :paxname, p.paxbirthdate=:paxbirthdate,p.paxtype = :paxtype,p.amount=:amount,p.passcustomerid=:passcustomerid,p.passbookingid=:passbookingid where p.paxid = :id")
	void update(@Param("paxname") String paxname,@Param("paxbirthdate")Date paxbirthdate,@Param("paxtype") String paxtype,@Param("amount") double amount,@Param("passcustomerid") Integer passcustomerid,@Param("passbookingid") Integer passbookingid,@Param("id")int id);
	
	
	@Query("from Passenger_Master p where p.passbookingid=:id")
	List<Passenger_Master> getpassengers(@Param("id") int id);
}
