package com.co.edu.udea.motoapp.model;

import org.bson.types.ObjectId;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class Advise {
	
	private String _uid;
	private String message;
	private String urlPicture;
	private int score;
	@JsonSerialize(using=ObjectIdSerializer.class)
	private ObjectId _tripId;
	
	public String get_uid() {
		return _uid;
	}
	public void set_uid(String _uid) {
		this._uid = _uid;
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
	public ObjectId get_tripId() {
		return _tripId;
	}
	public void set_tripId(ObjectId _tripId) {
		this._tripId = _tripId;
	}
	public String getUrlPicture() {
		return urlPicture;
	}
	public void setUrlPicture(String urlPicture) {
		this.urlPicture = urlPicture;
	}
}
