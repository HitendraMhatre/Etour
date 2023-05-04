package com.etour.dto;

import java.sql.Date;

public class Searchdto
{
	public Searchdto() {
		super();
	}

	public Searchdto(int masterid, String categoryname, Date departuredate, Date enddate, int noofdays, double cost) {
		super();
		this.masterid = masterid;
		this.categoryname = categoryname;
		this.departuredate = departuredate;
		this.enddate = enddate;
		this.noofdays = noofdays;
		this.cost = cost;
	}

	private int masterid;
	
	private String categoryname;
	
	private Date departuredate;
	
	private Date enddate;
	
	private int noofdays;
	
	private double cost;

	public int getMasterid() {
		return masterid;
	}

	public void setMasterid(int masterid) {
		this.masterid = masterid;
	}

	public String getCategoryname() {
		return categoryname;
	}

	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
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

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}
	
	

}


