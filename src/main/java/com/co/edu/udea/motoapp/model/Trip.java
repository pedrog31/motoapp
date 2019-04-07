package com.co.edu.udea.motoapp.model;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class Trip {

	@Id
	@JsonSerialize(using=ObjectIdSerializer.class)
	private ObjectId id;
	private String name;
	private String description;
	private String urlPicture;
	private List<Location> breakPoints;
	private boolean tripPublic;
	private String level;
	private int distance;
	private float score;
	private int scoreCount;
	private List<String> uids;
	private List<String> guestUids;
	
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUrlPicture() {
		return urlPicture;
	}
	public void setUrlPicture(String urlPicture) {
		this.urlPicture = urlPicture;
	}
	public List<Location> getBreakPoints() {
		return breakPoints;
	}
	public void setBreakPoints(List<Location> breakPoints) {
		this.breakPoints = breakPoints;
	}
	public boolean isTripPublic() {
		return tripPublic;
	}
	public void setTripPublic(boolean tripPublic) {
		this.tripPublic = tripPublic;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
	public float getScore() {
		return score;
	}
	public void setScore(float score) {
		this.score = score;
	}
	public int getScoreCount() {
		return scoreCount;
	}
	public void setScoreCount(int scoreCount) {
		this.scoreCount = scoreCount;
	}
	public List<String> getUids() {
		return uids;
	}
	public void setUids(List<String> uids) {
		this.uids = uids;
	}
	public List<String> getGuestUids() {
		return guestUids;
	}
	public void setGuestUids(List<String> guestUids) {
		this.guestUids = guestUids;
	}
}
