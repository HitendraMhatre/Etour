package com.etour.repositories;

import java.sql.Date;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.etour.entities.Cost_Master;
@Repository
@Transactional
public interface Cost_MasterRepository extends JpaRepository<Cost_Master,Integer> {
	@Modifying
	@Query("update Cost_Master p set p.cost = :cost, p.singlepersoncost=:singlepersoncost,p.extrapersoncost = :extrapersoncost, p.childwithbed=:childwithbed,p.childwithoutbed=:childwithoutbed ,p.validfrom=:validfrom,p.validto=:validto,p.cosmasterid=:cosmasterid where p.costid = :id")
	void update(@Param("cost") double cost,@Param("singlepersoncost")double singlepersoncost,@Param("extrapersoncost") double extrapersoncost,@Param("childwithbed") double childwithbed,@Param("childwithoutbed") double childwithoutbed,@Param("validfrom") Date validfrom,@Param("validto") Date validto ,@Param("cosmasterid") Integer cosmasterid,@Param("id")int id);
	
	
}
