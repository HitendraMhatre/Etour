package com.etour.services;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.etour.dto.AdminDTO;
import com.etour.entities.Admin;
import com.etour.dto.*;
import com.etour.repositories.AdminRepository;

@Service
public class AdminManagerImpl implements AdminManager
{
	@Autowired
	AdminRepository repository;
	
	@Autowired
	PasswordEncoder bcryptEncoder;

	@Override
	public void addAdmin(Admin admin) 
	{
		String password = admin.getPassword();
		String hashedvalue = sha256(password);
		admin.setPassword(hashedvalue);
		repository.save(admin);
		
	}

	@Override
	public List<Admin> getAdmins() 
	{
		return repository.findAll();
	}

	@Override
	public Optional<Admin> getAdmin(int id) {
		
		return repository.findById(id);
	}

	@Override
	public void removeAdmin(int id) 
	{
		repository.deleteById(id);
		
	}

	@Override
	public void updateAdmin(Admin admin,int id) 
	{
		repository.update(admin.getUsername(),admin.getPassword(),id);
		
	}
	

	private String sha256(String password)
	{
		try
		{
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] hash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
			StringBuilder hexstring = new StringBuilder();
			for(byte b : hash)
			{
				String hex =Integer.toHexString(0xff & b);
				if(hex.length()==1)
					hexstring.append('0');
				hexstring.append(hex);
			}
			return hexstring.toString();
		}
		catch(NoSuchAlgorithmException e)
		{
			throw new RuntimeException(e);
		}
	}

	@Override
	public ResponseEntity<AdminResponse> login(AdminDTO admin) 
	{
		String passwordHash = sha256(admin.getPassword()); // hash the password using SHA-256
		Admin person = repository.findAll().stream()
				.filter(customer -> customer.getUsername().equals(admin.getUsername()) && customer.getPassword().equals(passwordHash))
				.findFirst()
				.orElse(null);
		//System.out.print(person);

		if (person != null && person.getUsername().equals(admin.getUsername()) && person.getPassword().equals(passwordHash)) 
		{
				return ResponseEntity.ok().body(new AdminResponse(true, person));
		} 
		else 
		{
			return ResponseEntity.ok().body(new AdminResponse(false, null));
		}
	}

}



