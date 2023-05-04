package com.etour.jwt;

public class JwtRequest 
{
	private String phonenumber,password;

	@Override
	public String toString() {
		return "JwtRequest [phonenumber=" + phonenumber + ", password=" + password + "]";
	}

	public JwtRequest(String phonenumber, String password) {
		super();
		this.phonenumber = phonenumber;
		this.password = password;
		System.out.println("JwtRequest parameterized constructor");
	}

	public JwtRequest() {
		super();
		// TODO Auto-generated constructor stub
		System.out.println("JwtRequest default constructor");
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
		System.out.println("JwtRequest set phonenumber method");
	}

	public void setPassword(String password) {
		this.password = password;
		System.out.println("JwtRequest set password method");
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public String getPassword() {
		return password;
	}
	
}
