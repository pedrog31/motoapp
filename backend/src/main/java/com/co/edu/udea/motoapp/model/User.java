package com.co.edu.udea.motoapp.model;

import java.util.ArrayList;
import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class User {
	
	@Id
	private String _uid;
	
	private String name;
	private String lastName;
	private String email;
	private String cellphone;
	private String uriPhoto;
	private Date birthdate;
	private ArrayList<UserMotorcycle> motorcycles;
	private ArrayList<ObjectId> groups;
	private long timeStamp;

	public String get_uid() {
		return _uid;
	}

	public void set_uid(String _uid) {
		this._uid = _uid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public String getUriPhoto() {
		return uriPhoto;
	}

	public void setUriPhoto(String uriPhoto) {
		this.uriPhoto = uriPhoto;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public ArrayList<UserMotorcycle> getMotorcycles() {
		return motorcycles;
	}

	public void setMotorcycles(ArrayList<UserMotorcycle> motorcycles) {
		this.motorcycles = motorcycles;
	}

	public ArrayList<ObjectId> getGroups() {
		return groups;
	}

	public void setGroups(ArrayList<ObjectId> groups) {
		this.groups = groups;
	}

	public long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}

}
