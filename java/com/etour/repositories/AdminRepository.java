package com.etour.repositories;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.etour.entities.Admin;
@Repository
@Transactional
public interface AdminRepository extends JpaRepository<Admin,Integer>{

	@Modifying
	@Query("update Admin a set a.username =:name,a.password=:password where a.adminid=:id")
	void update(@Param("name") String name,@Param("password") String password,@Param("id") int id);

	Admin findByUsername(String username);
	
}
