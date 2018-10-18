package com.co.edu.udea.motoapp.model;

import java.util.ArrayList;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class Trip {

	@Id
	@JsonSerialize(using=ObjectIdSerializer.class)
	private ObjectId _id;
	private String name;
	private String description;
	private String urlPicture;
	private Location start;
	private Location end;
	private boolean tripPublic;
	private String level;
	private int distance;
	private float score;
	private int scoreCount;
	private ArrayList<String> uids;
	public ObjectId get_id() {
		return _id;
	}
	public void set_id(ObjectId _id) {
		this._id = _id;
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
	public Location getStart() {
		return start;
	}
	public void setStart(Location start) {
		this.start = start;
	}
	public Location getEnd() {
		return end;
	}
	public void setEnd(Location end) {
		this.end = end;
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
	public ArrayList<String> getUids() {
		return uids;
	}
	public void setUids(ArrayList<String> uids) {
		this.uids = uids;
	}
	
	
	
}
