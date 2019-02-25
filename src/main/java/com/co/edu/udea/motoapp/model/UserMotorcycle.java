package com.co.edu.udea.motoapp.model;

import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class UserMotorcycle {
	@Id
	@JsonSerialize(using=ObjectIdSerializer.class)
	private ObjectId _idMotorcycle;
	private Date soat;
	private Date tm;
	private String color;
	private int km;
	private Motorcycle moto;

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

	public Motorcycle getMoto() {
		return moto;
	}

	public void setMoto(Motorcycle moto) {
		this.moto = moto;
	}
}
