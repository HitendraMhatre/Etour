package com.etour.repositories;

import java.util.List;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.etour.entities.Category_Master;

@Repository
public interface Category_MasterRepo extends JpaRepository<Category_Master, Integer> {

	
	@Query("from Category_Master where subcategoryid is null")
	public List<Category_Master> findData();
	
	@Query("from Category_Master where subcategoryid =:categoryid ")
	public List<Category_Master> findSubcat(@Param ("categoryid") String categoryid);

	
	@Modifying
	@Query("update Category_Master p set p.categoryid = :categoryid, p.subcategoryid=:subcategoryid,p.categoryname = :categoryname, p.categoryimage=:categoryimage,p.flag=:flag where p.masterid = :id")
	void update(@Param("categoryid") String categoryid,@Param("subcategoryid")String subcategoryid,@Param("categoryname") String categoryname,@Param("categoryimage") String categoryimage,@Param("flag") boolean flag, @Param("id")int id);
	
	
	@Query("from Category_Master p where p.subcategoryid=:cat")
	List<Category_Master> listCat(@Param("cat") String name);



}
