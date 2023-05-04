package com.etour.jwt;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.etour.entities.Admin;
import com.etour.entities.Customer_Master;
import com.etour.dto.AdminDTO;
import com.etour.dto.CustomerDto;
import com.etour.repositories.AdminRepository;
import com.etour.repositories.Customer_MasterRepository;



@Service
public class CustomUserDetailsService implements UserDetailsService
{
 @Autowired 
 private Customer_MasterRepository repository;

 @Autowired
	private PasswordEncoder encoder;
 
	@Override
	public UserDetails loadUserByUsername(String phonenumber) throws UsernameNotFoundException {
		Customer_Master user = repository.findPhonenumber(phonenumber);
		System.out.println("usersdjskjsbkfjbndfkjbndfkbjndfkbjndfbkjdnfbkjdfnbkdfjjbn : "+user);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with phonenumber: " + phonenumber);
		}
		return new org.springframework.security.core.userdetails.User(user.getPhonenumber(),user.getPassword(),new ArrayList<>());
	}
	
	public Customer_Master save(CustomerDto user) {
		Customer_Master newUser = new Customer_Master();
		newUser.setAddress(user.getAddress());
		newUser.setAge(user.getAge());
		newUser.setCountrycode(user.getCountrycode());
		newUser.setCustomername(user.getCustomername());
		newUser.setEmail(user.getEmail());
		newUser.setGender(user.getGender());
		newUser.setProofid(user.getProofid());
		newUser.setPhonenumber(user.getPhonenumber());
		newUser.setPassword(encoder.encode(user.getPassword()));
		return repository.save(newUser);
	}

}
