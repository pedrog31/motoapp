package com.co.edu.udea.motoapp.model;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class User {
	
	@Id
	private String uid;
	
	private String name;
	private String lastName;
	private String email;
	private String cellphone;
	private String uriPhoto;
	private Date birthdate;
	private float level;
	private List<String> friends;
	private List<UserMotorcycle> motorcycles;
	private Set<String> challenges;
	private List<ObjectId> groups;
	private long timeStamp;
	
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
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
	public float getLevel() {
		return level;
	}
	public void setLevel(float level) {
		this.level = level;
	}
	public List<String> getFriends() {
		return friends;
	}
	public void setFriends(List<String> friends) {
		this.friends = friends;
	}
	public List<UserMotorcycle> getMotorcycles() {
		return motorcycles;
	}
	public void setMotorcycles(List<UserMotorcycle> motorcycles) {
		this.motorcycles = motorcycles;
	}
	public Set<String> getChallenges() {
		return challenges;
	}
	public void setChallenges(Set<String> challenges) {
		this.challenges = challenges;
	}
	public List<ObjectId> getGroups() {
		return groups;
	}
	public void setGroups(List<ObjectId> groups) {
		this.groups = groups;
	}
	public long getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}
}
