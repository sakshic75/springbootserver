package com.bezkoder.spring.mssql.model;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Products {

  @Id 
  private Integer id;
  
  public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public double getPrice() {
	return price;
}



@Override
public String toString() {
	return "Products [id=" + id + ", name=" + name + ", price=" + price + ", description=" + description + "]";
}

public void setPrice(double d) {
	this.price = d;
}

public Products() {
	super();
	// TODO Auto-generated constructor stub
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

public Products(int id, String name, double price, String description) {
	super();
	this.id = id;
	this.name = name;
	this.price = price;
	this.description = description;
//	this.createdAt = createdAt;
}

//public LocalDateTime getCreatedAt() {
//	return createdAt;
//}
//
//public void setCreatedAt(LocalDateTime createdAt) {
//	this.createdAt = createdAt;
//}

@Column(name = "name")
  private String name;

  @Column(name = "price")
  private double price;
  
  @Column(name = "description")
  private String description;
  
//  @Column(name = "createdAt")
//  private LocalDateTime createdAt;
  
  

  
  



  


}
