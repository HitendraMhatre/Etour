package com.etour.services;

import org.springframework.http.ResponseEntity;

import com.etour.dto.*;
public interface LoginMasterManager {
	ResponseEntity<LoginResponse> login(LoginRequest request);

}

