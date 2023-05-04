package com.etour.repositories;

import java.sql.Date;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.etour.entities.Date_Master;
@Repository
@Transactional
public interface Date_MasterRepository extends JpaRepository<Date_Master,Integer>{

	@Modifying
	@Query("update Date_Master p set p.departuredate = :departuredate, p.enddate=:enddate,p.noofdays = :noofdays, p.damasterid=:damasterid where p.departureid = :id")
	void update(@Param("departuredate") Date departuredate,@Param("enddate")Date enddate,@Param("noofdays") int noofdays,@Param("damasterid") Integer damasterid,@Param("id")int id);
	
}
