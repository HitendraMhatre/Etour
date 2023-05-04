package com.etour.dto;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component
public class SearchRequestdto 
{
	
	
	public SearchRequestdto() {
		super();
	}

	public SearchRequestdto(Date startdate, Date enddate, int noofdays, double maxcost) {
		super();
		this.startdate = startdate;
		this.enddate = enddate;
		this.noofdays = noofdays;
		this.maxcost = maxcost;
	}

	private Date startdate;
	
	private Date enddate;
	
	private int noofdays;
	
	
	private double maxcost;

	public Date getStartdate() {
		return startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
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


	public double getMaxcost() {
		return maxcost;
	}

	public void setMaxcost(double maxcost) {
		this.maxcost = maxcost;
	}
	
	
}
