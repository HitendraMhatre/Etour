package com.etour.entities;
import javax.persistence.*;

import java.sql.Date;
import java.util.Set;

@Entity
public class Booking_Master 
{
	


	public Booking_Master() {
		super();
	}

	public Booking_Master(Date bookingdate, int noofpassenger, double touramount, double taxes, double totalamount,
			Integer bookcustomerid, Integer bookmasterid, Integer bookdepartureid, boolean status,
			Set<Passenger_Master> passengermasters) {
		super();
		this.bookingdate = bookingdate;
		this.noofpassenger = noofpassenger;
		this.touramount = touramount;
		this.taxes = taxes;
		this.totalamount = totalamount;
		this.bookcustomerid = bookcustomerid;
		this.bookmasterid = bookmasterid;
		this.bookdepartureid = bookdepartureid;
		Status = status;
		this.passengermasters = passengermasters;
	}

	@Override
	public String toString() {
		return "Booking_Master [bookingid=" + bookingid + ", bookingdate=" + bookingdate + ", noofpassenger="
				+ noofpassenger + ", touramount=" + touramount + ", taxes=" + taxes + ", totalamount=" + totalamount
				+ ", bookcustomerid=" + bookcustomerid + ", bookmasterid=" + bookmasterid + ", bookdepartureid="
				+ bookdepartureid + ", Status=" + Status + ", passengermasters=" + passengermasters + "]";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="bookingid")
	private int bookingid;
    
	 @Column(name= "bookingdate")
    private Date bookingdate;
    
	 @Column(name = "noofpassenger")
    private int noofpassenger;
    
	 @Column(name = "touramount")
    private double touramount;
    
	 @Column(name = "taxes")
    private double taxes;
    
	 @Column(name = "totalamount")
    private double totalamount;
	 
	 @Column(name="bookcustomerid",nullable=true)
	 private Integer bookcustomerid;
	 
	 @Column(name="bookmasterid",nullable=true)
	 private Integer bookmasterid;
	 
	 @Column(name="bookdepartureid",nullable=true)
	 private Integer bookdepartureid;
    
	 @Column(name = "Status")
    private boolean Status;
    
    @OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "passbookingid", referencedColumnName="bookingid")
	private Set<Passenger_Master> passengermasters;

	public int getBookingid() {
		return bookingid;
	}

	public void setBookingid(int bookingid) {
		this.bookingid = bookingid;
	}

	public Date getBookingdate() {
		return bookingdate;
	}

	public void setBookingdate(Date bookingdate) {
		this.bookingdate = bookingdate;
	}

	public int getNoofpassenger() {
		return noofpassenger;
	}

	public void setNoofpassenger(int noofpassenger) {
		this.noofpassenger = noofpassenger;
	}

	public double getTouramount() {
		return touramount;
	}

	public void setTouramount(double touramount) {
		this.touramount = touramount;
	}

	public double getTaxes() {
		return taxes;
	}

	public void setTaxes(double taxes) {
		this.taxes = taxes;
	}

	public double getTotalamount() {
		return totalamount;
	}

	public void setTotalamount(double totalamount) {
		this.totalamount = totalamount;
	}

	public Integer getBookcustomerid() {
		return bookcustomerid;
	}

	public void setBookcustomerid(Integer bookcustomerid) {
		this.bookcustomerid = bookcustomerid;
	}

	public Integer getBookmasterid() {
		return bookmasterid;
	}

	public void setBookmasterid(Integer bookmasterid) {
		this.bookmasterid = bookmasterid;
	}

	public Integer getBookdepartureid() {
		return bookdepartureid;
	}

	public void setBookdepartureid(Integer bookdepartureid) {
		this.bookdepartureid = bookdepartureid;
	}

	public boolean isStatus() {
		return Status;
	}

	public void setStatus(boolean status) {
		Status = status;
	}

	public Set<Passenger_Master> getPassengermasters() {
		return passengermasters;
	}

	public void setPassengermasters(Set<Passenger_Master> passengermasters) {
		this.passengermasters = passengermasters;
	}
	
	

	
}