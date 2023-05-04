package com.etour.repositories;

import java.sql.Date;
import java.util.List;
import java.util.Locale.Category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.etour.entities.Category_Master;
import com.etour.services.SearchManager;

public interface SearchRepository extends JpaRepository<Category_Master,Integer>
{
	
	@Query(nativeQuery = true,value =" select cost.cost,date.departuredate,date.enddate,date.noofdays,category.masterid,category.categoryname "
			+ "from category_Master as category "
			+ "inner join date_master as date on category.masterid = date.damasterid "
			+ "inner join cost_master as cost on category.masterid = cost.cosmasterid "
			+ "where cost.cost<=:maxcost "
			+ "and date.departuredate>=:startdate and date.enddate<=:enddate "
					+ "and date.noofdays<=:noofdays and category.flag = true")
	public List<Object[]> searchspec(@Param("startdate") Date startdate,@Param("enddate") Date enddate
			,@Param("maxcost") double maxcost, @Param("noofdays") int noofdays);

}
