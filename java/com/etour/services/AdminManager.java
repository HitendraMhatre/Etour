package com.etour.services;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.etour.dto.AdminDTO;
import com.etour.dto.AdminResponse;
import com.etour.entities.Admin;

public interface AdminManager
{
	void addAdmin(Admin admin);
	
	List<Admin> getAdmins();
	
	Optional<Admin> getAdmin(int id);
	
	void removeAdmin(int id);
	
	void updateAdmin(Admin admin,int id);	
	
	ResponseEntity<AdminResponse> login(AdminDTO admin);

}
