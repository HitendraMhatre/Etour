package com.etour.repositories;

import java.sql.Date;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.etour.entities.Admin;
import com.etour.entities.Customer_Master;


@Repository
@Transactional
public interface Customer_MasterRepository extends JpaRepository<Customer_Master,Integer> {
	@Modifying
	@Query("update Customer_Master p set p.customername = :customername, p.email=:email,p.password = :password, p.phonenumber=:phonenumber,p.age=:age ,p.address=:address,p.countrycode=:countrycode,p.proofid=:proofid,p.gender=:gender where p.customerid = :customerid")
	void update(@Param("customername") String customername,@Param("email")String email,@Param("password") String password,@Param("phonenumber") String phonenumber,@Param("age") int age,@Param("address") String address,@Param("countrycode") int countrycode ,@Param("proofid") String proofid,@Param("gender") String gender,@Param("customerid")int customerid);
	
	// from Category_Master p where p.subcategoryid=:cat
	@Query("from Customer_Master c where c.phonenumber = :phonenumber")
	Customer_Master findPhonenumber(@Param("phonenumber")String phonenumber);
	
}
