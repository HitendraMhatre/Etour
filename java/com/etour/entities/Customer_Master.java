package com.etour.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
public class Customer_Master 
{
	public Customer_Master() {
		super();
	}

	

	public Customer_Master(String customername, String email, String password, String phonenumber, int age,
			String address, int countrycode, String proofid, String gender, Set<Passenger_Master> passengermasters,
			Set<Booking_Master> bookingmasters) {
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
		this.passengermasters = passengermasters;
		this.bookingmasters = bookingmasters;
	}



	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name = "customerid")
	private int customerid;
	
	 @Column(name = "customername")
	private String customername;
	
	 @Column(name = "email")
	private String email;
	
	 @Column(name = "password")
	private String password;
	
	 @Column(name = "phonenumber")
	private String phonenumber;
	
	 @Column(name = "age")
	private int age;
	
	 @Column(name = "address")
	private String address;
	
	 @Column(name = "countrycode")
	private int countrycode;
	
	 @Column(name = "proofid")
	private String proofid;
	
	 @Column(name = "gender")
	private String gender;
	 
	 @OneToMany(cascade = CascadeType.ALL)
	 @JoinColumn(name = "passcustomerid", referencedColumnName="customerid")
	 private Set<Passenger_Master> passengermasters;
	 
	 @OneToMany(cascade = CascadeType.ALL)
	 @JoinColumn(name = "bookcustomerid", referencedColumnName="customerid")
	 private Set<Booking_Master> bookingmasters;

	public int getCustomerid() {
		return customerid;
	}

	public void setCustomerid(int customerid) {
		this.customerid = customerid;
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



	public Set<Passenger_Master> getPassengermasters() {
		return passengermasters;
	}



	public void setPassengermasters(Set<Passenger_Master> passengermasters) {
		this.passengermasters = passengermasters;
	}



	public Set<Booking_Master> getBookingmasters() {
		return bookingmasters;
	}



	@Override
	public String toString() {
		return "Customer_Master [customerid=" + customerid + ", customername=" + customername + ", email=" + email
				+ ", password=" + password + ", phonenumber=" + phonenumber + ", age=" + age + ", address=" + address
				+ ", countrycode=" + countrycode + ", proofid=" + proofid + ", gender=" + gender + ", passengermasters="
				+ passengermasters + ", bookingmasters=" + bookingmasters + "]";
	}



	public void setBookingmasters(Set<Booking_Master> bookingmasters) {
		this.bookingmasters = bookingmasters;
	}


	
		 
	
}
