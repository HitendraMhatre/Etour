package com.etour.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.etour.dto.ItineraryDto;
import com.etour.entities.Itinerary_Master;


@Repository
public interface Itinerary_MasterRepo extends JpaRepository<Itinerary_Master, Integer> {

	
	@Query(nativeQuery = true, value = "SELECT i.*,"
			+ "d.*, c.singlepersoncost, c.extrapersoncost, c.childwithbed, c.childwithoutbed, c.validfrom, c.validto, cm.categoryname, cm.categoryimage "
	        + "FROM itinerary_master i "
	        + "INNER JOIN category_master cm ON i.itimasterid = cm.masterid "
	        + "INNER JOIN cost_master c ON i.itimasterid = c.cosmasterid "
	        + "INNER JOIN date_master d ON c.cosmasterid = d.damasterid "
	        + "WHERE cm.masterid = :id")
	    List<Object[]> findItineraryById(@Param("id") Integer id);
	    
	    
	    @Modifying
		@Query("update Itinerary_Master p set p.tourduration = :tourduration, p.itrdetail=:itrdetail,p.itimasterid = :itimasterid where p.itrid = :id")
		void update(@Param("tourduration") int tourduration,@Param("itrdetail")String itrdetail,@Param("itimasterid") Integer itimasterid,@Param("id")int id);
		

}

