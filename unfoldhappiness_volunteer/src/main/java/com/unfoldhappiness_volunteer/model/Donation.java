package com.unfoldhappiness_volunteer.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
@Entity
@Table(name="donation")


public class Donation {
	@Id
	private long id;
	private long user_id;
	@Transient
	private long mobileno;
	private long vol_id;
	private String donation_address;
	private int donation_qty;
	private int donation_amt;
	private String donation_type;
	private Date donation_date;
	private String donation_time;
	private int donation_area;
	private int status;
	private int isdelete;
	@Transient
	private String area_name;
	@Transient
	private String user_name;
	@Transient
	private String email;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getUser_id() {
		return user_id;
	}
	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}
	public long getVol_id() {
		return vol_id;
	}
	public void setVol_id(long vol_id) {
		this.vol_id = vol_id;
	}
	public String getDonation_address() {
		return donation_address;
	}
	public void setDonation_address(String donation_address) {
		this.donation_address = donation_address;
	}
	public int getDonation_qty() {
		return donation_qty;
	}
	public void setDonation_qty(int donation_qty) {
		this.donation_qty = donation_qty;
	}
	public int getDonation_amt() {
		return donation_amt;
	}
	public void setDonation_amt(int donation_amt) {
		this.donation_amt = donation_amt;
	}
	public String getDonation_type() {
		return donation_type;
	}
	public void setDonation_type(String donation_type) {
		this.donation_type = donation_type;
	}
	public Date getDonation_date() {
		return donation_date;
	}
	public void setDonation_date(Date donation_date) {
		this.donation_date = donation_date;
	}
	public String getDonation_time() {
		return donation_time;
	}
	public void setDonation_time(String donation_time) {
		this.donation_time = donation_time;
	}
	
	public int getDonation_area() {
		return donation_area;
	}
	public void setDonation_area(int donation_area) {
		this.donation_area = donation_area;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getIsdelete() {
		return isdelete;
	}
	public void setIsdelete(int isdelete) {
		this.isdelete = isdelete;
	}
	public String getArea_name() {
		return area_name;
	}
	public void setArea_name(String area_name) {
		this.area_name = area_name;
	}
	public long getMobileno() {
		return mobileno;
	}
	public void setMobileno(long mobileno) {
		this.mobileno = mobileno;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
