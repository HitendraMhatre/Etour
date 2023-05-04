package com.etour.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
public class Itinerary_Master
{
	

	public Itinerary_Master() {
		super();
	}

	public Itinerary_Master(int tourduration, String itrdetail, Integer itimasterid) {
		super();
		this.tourduration = tourduration;
		this.itrdetail = itrdetail;
		this.itimasterid = itimasterid;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "itrid")
    public int itrid;

	
    @Column(name = "tourduration")
    public int tourduration;
    
    @Column(name = "itrdetail" ,columnDefinition="LONGTEXT")
    public String itrdetail;
    
    @Column(name="itimasterid",nullable=true)
    public Integer itimasterid;

	public int getItrid() {
		return itrid;
	}

	public void setItrid(int itrid) {
		this.itrid = itrid;
	}

	public int getTourduration() {
		return tourduration;
	}

	public void setTourduration(int tourduration) {
		this.tourduration = tourduration;
	}

	public String getItrdetail() {
		return itrdetail;
	}

	public void setItrdetail(String itrdetail) {
		this.itrdetail = itrdetail;
	}

	public Integer getItimasterid() {
		return itimasterid;
	}

	public void setItimasterid(Integer itimasterid) {
		this.itimasterid = itimasterid;
	}

	
    
}
