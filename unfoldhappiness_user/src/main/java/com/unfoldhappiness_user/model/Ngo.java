package com.unfoldhappiness_user.model;

import java.time.LocalDate;

import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

	@Entity
	@Table(name="ngo")
	public class Ngo
	{
		@Id
		private long id;
		private String name;
		private String email;
		private String address;
		private long mobileno;
		private LocalDate do_establish;
		private String website;
		private String password;
		private long area;
		 
		private String service;
		@Transient
		private String conpassword;
		private int isdelete;
		@Transient
		private String npassword;
		
		
		public String getNpassword() {
			return npassword;
		}
		public void setNpassword(String npassword) {
			this.npassword = npassword;
		}
		public String getConpassword() {
			return conpassword;
		}
		public void setConpassword(String conpassword) {
			this.conpassword = conpassword;
		}
		 public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public long getMobileno() {
			return mobileno;
		}
		public void setMobileno(long mobileno) {
			this.mobileno = mobileno;
		}
		
		public LocalDate getDo_establish() {
			return do_establish;
		}
		public void setDo_establish(LocalDate do_establish) {
			this.do_establish = do_establish;
		}
		public String getWebsite() {
			return website;
		}
		public void setWebsite(String website) {
			this.website = website;
		}
		public int getIsdelete() {
			return isdelete;
		}
		public void setIsdelete(int isdelete) {
			this.isdelete = isdelete;
		}
	public String getPassword() { 
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public long getArea() {
			return area;
		}
		public void setArea(long area) {
			this.area = area;
		}
		public String getService() {
			return service;
		}
		public void setService(String service) {
			this.service = service;
		}
		
		
		
	}