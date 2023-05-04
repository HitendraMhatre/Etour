package com.etour.entities;

import java.util.HashSet;

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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author sagar
 *
 */
@Entity
@Table(name = "Category_Master")
public class Category_Master 
{


	public Category_Master() {
		super();
	}

	public Category_Master(String categoryid, String subcategoryid, String categoryname, String categoryimage,
			boolean flag, Set<Itinerary_Master> itineraries, Set<Date_Master> datemasters, Set<Cost_Master> costmasters,
			Set<Booking_Master> bookingmasters) {
		super();
		this.categoryid = categoryid;
		this.subcategoryid = subcategoryid;
		this.categoryname = categoryname;
		this.categoryimage = categoryimage;
		this.flag = flag;
		this.itineraries = itineraries;
		this.datemasters = datemasters;
		this.costmasters = costmasters;
		this.bookingmasters = bookingmasters;
	}

	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name = "masterid")
	 private int masterid;
	 
	 @Column(name = "categoryid")
     private String categoryid;
	 
	 @Column(name = "subcategoryid")
	 private String subcategoryid;
	 
	 @Column(name = "categoryname")
	 private String categoryname;
	 
	 @Column(name = "categoryimage")
	 private String categoryimage;
	 
	 @Column(name = "flag")
	 private boolean flag;
		 
	 @OneToMany(cascade = CascadeType.ALL)
	 @JoinColumn(name = "itimasterid", referencedColumnName="masterid")
	 private Set<Itinerary_Master> itineraries;

	 @OneToMany(cascade = CascadeType.ALL)
	 @JoinColumn(name = "damasterid", referencedColumnName="masterid")
	 private Set<Date_Master> datemasters;

	 @OneToMany(cascade = CascadeType.ALL)
	 @JoinColumn(name = "cosmasterid", referencedColumnName="masterid")
	 private Set<Cost_Master> costmasters;

	 @OneToMany(cascade = CascadeType.ALL)
	 @JoinColumn(name = "bookmasterid", referencedColumnName="masterid")
	 private Set<Booking_Master> bookingmasters;

	 //getters and setters
	 
	public int getMasterid() {
		return masterid;
	}

	public void setMasterid(int masterid) {
		this.masterid = masterid;
	}

	public String getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(String categoryid) {
		this.categoryid = categoryid;
	}

	public String getSubcategoryid() {
		return subcategoryid;
	}

	public void setSubcategoryid(String subcategoryid) {
		this.subcategoryid = subcategoryid;
	}

	public String getCategoryname() {
		return categoryname;
	}

	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}

	public String getCategoryimage() {
		return categoryimage;
	}

	public void setCategoryimage(String categoryimage) {
		this.categoryimage = categoryimage;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public Set<Itinerary_Master> getItireneries() {
		return itineraries;
	}

	public void setItireneries(Set<Itinerary_Master> itineraries) {
		this.itineraries = itineraries;
	}

	public Set<Date_Master> getDate_masters() {
		return datemasters;
	}

	public void setDate_masters(Set<Date_Master> date_masters) {
		this.datemasters = date_masters;
	}

	public Set<Cost_Master> getCost_masters() {
		return costmasters;
	}

	public void setCost_masters(Set<Cost_Master> cost_masters) {
		this.costmasters = cost_masters;
	}

	public Set<Booking_Master> getBookingmaster() {
		return bookingmasters;
	}

	public void setBookingmaster(Set<Booking_Master> bookingmaster) {
		this.bookingmasters = bookingmaster;
	}

	
	 
	 
}
