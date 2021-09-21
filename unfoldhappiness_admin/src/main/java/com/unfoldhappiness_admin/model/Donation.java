package com.unfoldhappiness_admin.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;
@Entity
@Table(name="donation")


public class Donation {
	@Id
	private long id;
	private long user_id;
	
	@Transient
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
	private String vol_name;
	@Transient
	private String uname;
	@Transient
	private long v_mobileno;
	@Transient
	private String v_email;
	@Transient
	private String photo;
	@Transient
	private MultipartFile profileImage; 
	@Transient
	private long mobileno; 
	@Transient
	private long u_mobileno;
	@Transient
	private String u_email;
	
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
	public String getVol_name() {
		return vol_name;
	}
	public void setVol_name(String vol_name) {
		this.vol_name = vol_name;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	public MultipartFile getProfileImage() {
		return profileImage;
	}
	public void setProfileImage(MultipartFile profileImage) {
		this.profileImage = profileImage;
	}
	public long getMobileno() {
		return mobileno;
	}
	public void setMobileno(long mobileno) {
		this.mobileno = mobileno;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public long getV_mobileno() {
		return v_mobileno;
	}
	public void setV_mobileno(long v_mobileno) {
		this.v_mobileno = v_mobileno;
	}
	public String getV_email() {
		return v_email;
	}
	public void setV_email(String v_email) {
		this.v_email = v_email;
	}
	public long getU_mobileno() {
		return u_mobileno;
	}
	public void setU_mobileno(long u_mobileno) {
		this.u_mobileno = u_mobileno;
	}
	public String getU_email() {
		return u_email;
	}
	public void setU_email(String u_email) {
		this.u_email = u_email;
	}
	
	

}
