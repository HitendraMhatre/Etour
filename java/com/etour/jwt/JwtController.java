package com.etour.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.etour.dto.AdminDTO;
import com.etour.dto.CustomerDto;
import com.etour.entities.Customer_Master;
import com.etour.repositories.Customer_MasterRepository;


@RestController
@CrossOrigin("http://localhost:3000")
public class JwtController 
{
	@Autowired
	private AuthenticationManager authenticationmanager;
	
	@Autowired
	 private Customer_MasterRepository repository;
	
	@Autowired
	private JwtUtil jwtutil;
	
	@Autowired
	private CustomUserDetailsService customuserdetailsservice;
	
	@PostMapping("/token")
	public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtrequest) throws Exception {
		System.out.println("inside token method");
		System.out.println("Commmmmmmmmmming Request : "+jwtrequest);
	    try {
	        authenticationmanager.authenticate(new UsernamePasswordAuthenticationToken(jwtrequest.getPhonenumber(), jwtrequest.getPassword()));
	    } catch(UsernameNotFoundException e)
		{
			e.printStackTrace();
			
			throw new Exception("Bad Credentials");
		}

	    UserDetails userdetails = customuserdetailsservice.loadUserByUsername(jwtrequest.getPhonenumber());
	   System.out.println("usssssssssssserrrrrrrrrrrrr : "+userdetails);
	   Customer_Master user = repository.findPhonenumber(jwtrequest.getPhonenumber());
	    String token = jwtutil.generateToken(userdetails);
	    System.out.println("JWT " + token);
	    return ResponseEntity.ok(new JwtResponse(token,user));
	}

//	
//	@PostMapping("/token")
//	public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtrequest) throws Exception
//	{
//		
//		System.out.println("inside token method");
//		System.out.println(jwtrequest);
//		try
//		{
//			this.authenticationmanager.authenticate(new UsernamePasswordAuthenticationToken(jwtrequest.getPhonenumber(),jwtrequest.getPassword()));
//		}
//		catch(UsernameNotFoundException e)
//		{
//			e.printStackTrace();
//			throw new Exception("Bad Credentials");
//		}
//		UserDetails userdetails=this.customuserdetailsservice.loadUserByUsername(jwtrequest.getPhonenumber());
//		String token=this.jwtutil.generateToken(userdetails);
//		System.out.println("JWT "+token);
//		return ResponseEntity.ok(new JwtResponse(token));
//	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<?> saveUser(@RequestBody CustomerDto user) throws Exception {
		return ResponseEntity.ok(customuserdetailsservice.save(user));
	}
}
