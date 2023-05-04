package com.etour.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.etour.entities.Customer_Master;
import com.etour.repositories.Customer_MasterRepository;

import com.etour.dto.*;

@Service
public class LoginMasterManagerImpl implements LoginMasterManager {

	@Autowired
	private Customer_MasterRepository repository;
	
public ResponseEntity<LoginResponse> login(LoginRequest request) {
        Customer_Master person = repository.findAll().stream()
            .filter(customer -> customer.getPhonenumber().equals(request.getPhonenumber()) && customer.getPassword().equals(request.getPassword()))
            .findFirst()
            .orElse(null);

        if (person != null && person.getPhonenumber().equals(request.getPhonenumber()) && person.getPassword().equals(request.getPassword())) {
            return ResponseEntity.ok().body(new LoginResponse(true, person));
        } else {
            return ResponseEntity.ok().body(new LoginResponse(false, null));
        }
    }
	

}
