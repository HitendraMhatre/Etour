package com.etour.jwt;

import com.etour.entities.Customer_Master;

public class JwtResponse 
{
	private String token;
	
	private Customer_Master master;
	
	
	private JwtResponse()
	{
		super();
	}
	

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Customer_Master getMaster() {
		return master;
	}

	public void setMaster(Customer_Master master) {
		this.master = master;
	}

	public JwtResponse(String token, Customer_Master master) {
		super();
		this.token = token;
		this.master = master;
	}

	
	
}
