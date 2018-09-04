package com.co.edu.udea.motoapp.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Trip {
	@Id
	private ObjectId _id;
	
	private String name;
	private String description;
	
}
