package com.etour.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
public class Passenger_Master
{
	public Passenger_Master() {
		super();
	}

	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "paxid")
	private int paxid;

	public int getPaxid() {
		return paxid;
	}

	public Passenger_Master(String paxname, Date paxbirthdate, String paxtype, double amount, Integer passcustomerid,
			Integer passbookingid) {
		super();
		this.paxname = paxname;
		this.paxbirthdate = paxbirthdate;
		this.paxtype = paxtype;
		this.amount = amount;
		this.passcustomerid = passcustomerid;
		this.passbookingid = passbookingid;
	}

	public void setPaxid(int paxid) {
		this.paxid = paxid;
	}

	public String getPaxname() {
		return paxname;
	}

	public void setPaxname(String paxname) {
		this.paxname = paxname;
	}

	public Date getPaxbirthdate() {
		return paxbirthdate;
	}

	public void setPaxbirthdate(Date paxbirthdate) {
		this.paxbirthdate = paxbirthdate;
	}

	public String getPaxtype() {
		return paxtype;
	}

	public void setPaxtype(String paxtype) {
		this.paxtype = paxtype;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Integer getPasscustomerid() {
		return passcustomerid;
	}

	public void setPasscustomerid(Integer passcustomerid) {
		this.passcustomerid = passcustomerid;
	}

	public Integer getPassbookingid() {
		return passbookingid;
	}

	public void setPassbookingid(Integer passbookingid) {
		this.passbookingid = passbookingid;
	}

	@Column(name = "paxname")
	private String paxname ;
	
	@Column(name = "paxbirthdate")
	private Date paxbirthdate;
	
	@Column(name = "paxtype")
	private String paxtype;
	
	@Column(name = "amount")
	private double amount;
	
	@Column(name="passcustomerid")
	private Integer passcustomerid;
	
	@Column(name="passbookingid")
	private Integer passbookingid;


}
