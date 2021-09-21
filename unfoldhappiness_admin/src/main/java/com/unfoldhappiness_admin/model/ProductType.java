package com.unfoldhappiness_admin.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product_type")

public class ProductType {

		@Id
		private long id;
		private String product_type;
		private int isdelete;
		public int getIsdelete() {
			return isdelete;
		}
		public void setIsdelete(int isdelete) {
			this.isdelete = isdelete;
		}
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public String getProduct_type() {
			return product_type;
		}
		public void setProduct_type(String product_type) {
			this.product_type = product_type;
		}
		
}
