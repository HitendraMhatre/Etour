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
public class Cost_Master 
{
	
	public Cost_Master() {
		super();
	}

	public Cost_Master(double cost, double singlepersoncost, double extrapersoncost, double childwithbed,
			double childwithoutbed, Date validfrom, Date validto, Integer cosmasterid) {
		super();
		this.cost = cost;
		this.singlepersoncost = singlepersoncost;
		this.extrapersoncost = extrapersoncost;
		this.childwithbed = childwithbed;
		this.childwithoutbed = childwithoutbed;
		this.validfrom = validfrom;
		this.validto = validto;
		this.cosmasterid = cosmasterid;
	}

	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "costid")
	 private int costid;
	
	 @Column(name = "cost")
	private double cost;
	
	 @Column(name = "singlepersoncost")
	private double singlepersoncost;
	
	 @Column(name = "extrapersoncost")
	private double extrapersoncost;
	
	 @Column(name = "childwithbed")
	private double childwithbed;
	
	 @Column(name = "childwithoutbed")
	private double childwithoutbed;
	
	 @Column(name= "validfrom")
	private Date validfrom;
	
	 @Column(name = "validto")
	private Date validto;

	 @Column(name="cosmasterid",nullable=true)
	 private Integer cosmasterid;

	public int getCostid() {
		return costid;
	}

	public void setCostid(int costid) {
		this.costid = costid;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public double getSinglepersoncost() {
		return singlepersoncost;
	}

	public void setSinglepersoncost(double singlepersoncost) {
		this.singlepersoncost = singlepersoncost;
	}

	public double getExtrapersoncost() {
		return extrapersoncost;
	}

	public void setExtrapersoncost(double extrapersoncost) {
		this.extrapersoncost = extrapersoncost;
	}

	public double getChildwithbed() {
		return childwithbed;
	}

	public void setChildwithbed(double childwithbed) {
		this.childwithbed = childwithbed;
	}

	public double getChildwithoutbed() {
		return childwithoutbed;
	}

	public void setChildwithoutbed(double childwithoutbed) {
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

	public Integer getCosmasterid() {
		return cosmasterid;
	}

	public void setCosmasterid(Integer cosmasterid) {
		this.cosmasterid = cosmasterid;
	}
	 	 
	
}
