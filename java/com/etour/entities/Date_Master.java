package com.etour.entities;

import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="Date_Master")
public class Date_Master 
{
	

	public Date_Master() {
		super();
	}
	
	public Date_Master(Date departuredate, Date enddate, int noofdays, Integer damasterid) {
		super();
		this.departuredate = departuredate;
		this.enddate = enddate;
		this.noofdays = noofdays;
		this.damasterid = damasterid;
	}
	

	public Date_Master(Date departuredate, Date enddate, int noofdays, Integer damasterid,
			Set<Booking_Master> bookingmasters) {
		super();
		this.departuredate = departuredate;
		this.enddate = enddate;
		this.noofdays = noofdays;
		this.damasterid = damasterid;
		this.bookingmasters = bookingmasters;
	}



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "departureid")
	private int departureid;
	
	@Column (name = "departuredate")
	private Date departuredate;
	
	@Column(name="enddate")
	private Date enddate;
	
	@Column(name="noofdays")
    private int noofdays;
	
	@Column(name="damasterid",nullable =true)
	private Integer damasterid;
	
	 @OneToMany(cascade = CascadeType.ALL)
	 @JoinColumn(name = "bookdepartureid", referencedColumnName="departureid")
	 private Set<Booking_Master> bookingmasters;

	public int getDepartureid() {
		return departureid;
	}

	public Integer getDamasterid() {
		return damasterid;
	}

	public void setDamasterid(Integer damasterid) {
		this.damasterid = damasterid;
	}

	public void setDepartureid(int departureid) {
		this.departureid = departureid;
	}

	public Date getDeparturedate() {
		return departuredate;
	}

	public void setDeparturedate(Date departuredate) {
		this.departuredate = departuredate;
	}

	public Date getEnddate() {
		return enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	public int getNoofdays() {
		return noofdays;
	}

	public void setNoofdays(int noofdays) {
		this.noofdays = noofdays;
	}

	public Integer getCosmasterid() {
		return damasterid;
	}

	public void setCosmasterid(Integer cosmasterid) {
		this.damasterid = cosmasterid;
	}



	public Set<Booking_Master> getBookingmasters() {
		return bookingmasters;
	}



	public void setBookingmasters(Set<Booking_Master> bookingmasters) {
		this.bookingmasters = bookingmasters;
	}

	 
}