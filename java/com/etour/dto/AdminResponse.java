package com.etour.dto;

import com.etour.entities.Admin;

public class AdminResponse 
{
	
	
	public AdminResponse() {
		super();
	}

	public AdminResponse(boolean success, Admin admin) {
		super();
		this.success = success;
		this.admin = admin;
	}

	private boolean success;
	
	private Admin admin;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	@Override
	public String toString() {
		return "AdminResponse [success=" + success + ", admin=" + admin + "]";
	}
	
	
	

}
