package com.co.edu.udea.motoapp.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class Motorcycle {
	@Id
	@JsonSerialize(using=ObjectIdSerializer.class)
	private ObjectId id;
	
	private String name;
	private String brand;
	private String cyl;
	private String uri;
	
	
	
	public ObjectId getId() {
		return id;
	}
	public void setId(ObjectId id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getCyl() {
		return cyl;
	}
	public void setCyl(String cyl) {
		this.cyl = cyl;
	}
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	
	
	
}
