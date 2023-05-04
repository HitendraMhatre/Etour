package com.etour.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.etour.entities.Category_Master;

public interface Search_MasterRepo extends JpaRepository<Category_Master, Integer>{

	
	
//	@Query("Select c.categoryname,c.categoryid,d.departdate,d.enddate,cm.singlepersoncost,"
//			+ "d.noofdays from Category_Master c join Date_Master d on c.masterid=d.damasterid "
//			+ "join Cost_Master cm on c.masterid=cm.cosmasterid where d.departuredate>=:departuredate "
//			+ "AND d.enddate<=enddate AND cm.singlepersoncost<=singlepersoncost AND"
//			+ " d.noofdays<=noofdays AND where c.flag=true")
//	List<Object[]> searchcat(OBject)
	
	
}
