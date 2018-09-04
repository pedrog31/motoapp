package com.co.edu.udea.motoapp.model;

import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class UserMotorcycle {
	@Id
	private ObjectId _id;
	
	private ObjectId _idMotorcycle;
	private Date soat;
	private Date tm;
	private String color;
	private int km;

	public ObjectId get_id() {
		return _id;
	}

	public void set_id(ObjectId _id) {
		this._id = _id;
	}

	public ObjectId get_idMotorcycle() {
		return _idMotorcycle;
	}

	public void set_idMotorcycle(ObjectId _idMotorcycle) {
		this._idMotorcycle = _idMotorcycle;
	}

	public Date getSoat() {
		return soat;
	}

	public void setSoat(Date soat) {
		this.soat = soat;
	}

	public Date getTm() {
		return tm;
	}

	public void setTm(Date tm) {
		this.tm = tm;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getKm() {
		return km;
	}

	public void setKm(int km) {
		this.km = km;
	}
}
