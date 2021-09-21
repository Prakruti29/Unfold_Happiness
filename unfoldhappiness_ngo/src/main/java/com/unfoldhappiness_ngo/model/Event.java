package com.unfoldhappiness_ngo.model;

import java.sql.Time;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "event")
public class Event {

	

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private long id;
	private String e_name;
	private String e_venue;
	private Date e_date;
	private String e_time;
	private String e_details;
	private int isdelete;
	private int isactive;
	private long ngo_id;
	private long createdBy;
	private long modifyBy;
	private Date createdDate;
	private Date modifyDate;

	public int getIsactive() {
		return isactive;
	}
	public void setIsactive(int isactive) {
		this.isactive = isactive;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getE_name() {
		return e_name;
	}
	public void setE_name(String e_name) {
		this.e_name = e_name;
	}
	public String getE_venue() {
		return e_venue;
	}
	public void setE_venue(String e_venue) {
		this.e_venue = e_venue;
	}
	public Date getE_date() {
		return e_date;
	}
	public void setE_date(Date e_date) {
		this.e_date = e_date;
	}
	public String getE_time() {
		return e_time;
	}
	public void setE_time(String e_time) {
		this.e_time = e_time;
	}
	public String getE_details() {
		return e_details;
	}
	public void setE_details(String e_details) {
		this.e_details = e_details;
	}
	public int getIsdelete() {
		return isdelete;
	}
	public void setIsdelete(int isdelete) {
		this.isdelete = isdelete;
	}
	
	public long getNgo_id() {
		return ngo_id;
	}
	public void setNgo_id(long ngo_id) {
		this.ngo_id = ngo_id;
	}
	public long getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(long createdBy) {
		this.createdBy = createdBy;
	}
	public long getModifyBy() {
		return modifyBy;
	}
	public void setModifyBy(long modifyBy) {
		this.modifyBy = modifyBy;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	
	

}
