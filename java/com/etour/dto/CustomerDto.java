package com.etour.dto;

public class CustomerDto {

	
	private String customername;
	private String email ;
	private String password ;
	private String phonenumber ;
	private int age ;
	private String address;
	private int countrycode ;
	private String proofid ;
	private String gender ;
	 
	
	public CustomerDto()
	{
		
	}
	
	public CustomerDto(String customername, String email, String password, String phonenumber, int age, String address,
			int countrycode, String proofid, String gender) {
		super();
		this.customername = customername;
		this.email = email;
		this.password = password;
		this.phonenumber = phonenumber;
		this.age = age;
		this.address = address;
		this.countrycode = countrycode;
		this.proofid = proofid;
		this.gender = gender;
	}
	
	public String getCustomername() {
		return customername;
	}
	public void setCustomername(String customername) {
		this.customername = customername;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getCountrycode() {
		return countrycode;
	}
	public void setCountrycode(int countrycode) {
		this.countrycode = countrycode;
	}
	public String getProofid() {
		return proofid;
	}
	public void setProofid(String proofid) {
		this.proofid = proofid;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
}
