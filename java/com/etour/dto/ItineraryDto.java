package com.etour.dto;

import java.math.BigDecimal;
import java.sql.Date;


import com.etour.entities.Date_Master;
import com.etour.entities.Itinerary_Master;

public class ItineraryDto {

	
//	c.singlepersoncost, c.extrapersoncost, c.childwithbed, 
//	c.childwithoutbed, c.validfrom, c.validto, cm.categoryname "
	
	private Itinerary_Master itinerary;
	private Date_Master date;
    private Double singlepersoncost;
    private Double extrapersoncost;
    private Double childwithbed;
    private Double childwithoutbed;
    private Date validfrom;
    private Date validto;
    private String categoryname;	
    private String categoryimage;
    
    
	public ItineraryDto(Itinerary_Master itinerary, Date_Master date, Double singlepersoncost, Double extrapersoncost,
		Double childwithbed, Double childwithoutbed, Date validfrom, Date validto, String categoryname, String categoryimage) {
	super();
	this.itinerary = itinerary;
	this.date = date;
	this.singlepersoncost = singlepersoncost;
	this.extrapersoncost = extrapersoncost;
	this.childwithbed = childwithbed;
	this.childwithoutbed = childwithoutbed;
	this.validfrom = validfrom;
	this.validto = validto;
	this.categoryname = categoryname;
	this.categoryimage = categoryimage;
}
	
	
	
    public Itinerary_Master getitinerary() {
		return itinerary;
	}
	public String getCategoryimage() {
		return categoryimage;
	}



	public void setCategoryimage(String categoryimage) {
		this.categoryimage = categoryimage;
	}



	public void setitinerary(Itinerary_Master itinerary) {
		this.itinerary = itinerary;
	}
	public Date_Master getdate() {
		return date;
	}
	public void setdate(Date_Master date) {
		this.date = date;
	}
	public Double getSinglepersoncost() {
		return singlepersoncost;
	}
	public void setSinglepersoncost(Double singlepersoncost) {
		this.singlepersoncost = singlepersoncost;
	}
	public Double getExtrapersoncost() {
		return extrapersoncost;
	}
	public void setExtrapersoncost(Double extrapersoncost) {
		this.extrapersoncost = extrapersoncost;
	}
	public Double getChildwithbed() {
		return childwithbed;
	}
	public void setChildwithbed(Double childwithbed) {
		this.childwithbed = childwithbed;
	}
	public Double getChildwithoutbed() {
		return childwithoutbed;
	}
	public void setChildwithoutbed(Double childwithoutbed) {
		this.childwithoutbed = childwithoutbed;
	}
	public Date getValidfrom() {
		return validfrom;
	}
	public void setValidfrom(Date validfrom) {
		this.validfrom = validfrom;
	}
	public Date getValidto() {
		return validto;
	}
	public void setValidto(Date validto) {
		this.validto = validto;
	}
	public String getCategoryname() {
		return categoryname;
	}
	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}
	
	}
