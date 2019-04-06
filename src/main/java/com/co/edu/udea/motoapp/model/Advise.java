package com.co.edu.udea.motoapp.model;

import org.bson.types.ObjectId;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class Advise {
	
	private String uid;
	private String message;
	private String urlPicture;
	private int score;
	@JsonSerialize(using=ObjectIdSerializer.class)
	private ObjectId tripId;
	
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public ObjectId getTripId() {
		return tripId;
	}
	public void setTripId(ObjectId tripId) {
		this.tripId = tripId;
	}
	public String getUrlPicture() {
		return urlPicture;
	}
	public void setUrlPicture(String urlPicture) {
		this.urlPicture = urlPicture;
	}
}
