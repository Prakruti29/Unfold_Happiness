package com.unfoldhappiness_ngo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name="product")

public class Product {

		@Id
		private long id;
		private String name;
		private String description;
		private int price;
		private int quantity;
		private int discount;
		private long product_type;
		private long ngo_id;
		private String photo1;
		private String photo2;
		private int isdelete;
		@Transient
		private int status;
		@Transient
		private MultipartFile image1; 
		@Transient
		private MultipartFile image2; 
		private long createdBy;
		private long modifyBy;
		private Date createdDate;
		private Date modifyDate;
		

		public int getStatus() {
			return status;
		}
		public void setStatus(int status) {
			this.status = status;
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
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public int getPrice() {
			return price;
		}
		public void setPrice(int price) {
			this.price = price;
		}
		public int getQuantity() {
			return quantity;
		}
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
		public int getDiscount() {
			return discount;
		}
		public void setDiscount(int discount) {
			this.discount = discount;
		}
		public long getProduct_type() {
			return product_type;
		}
		public void setProduct_type(long product_type) {
			this.product_type = product_type;
		}
		public long getNgo_id() {
			return ngo_id;
		}
		public void setNgo_id(long ngo_id) {
			this.ngo_id = ngo_id;
		}
		public String getPhoto1() {
			return photo1;
		}
		public void setPhoto1(String photo1) {
			this.photo1 = photo1;
		}
		public String getPhoto2() {
			return photo2;
		}
		public void setPhoto2(String photo2) {
			this.photo2 = photo2;
		}
		public int getIsdelete() {
			return isdelete;
		}
		public void setIsdelete(int isdelete) {
			this.isdelete = isdelete;
		}
		public MultipartFile getImage1() {
			return image1;
		}
		public void setImage1(MultipartFile image1) {
			this.image1 = image1;
		}
		public MultipartFile getImage2() {
			return image2;
		}
		public void setImage2(MultipartFile image2) {
			this.image2 = image2;
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
