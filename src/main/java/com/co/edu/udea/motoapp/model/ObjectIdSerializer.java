package com.co.edu.udea.motoapp.model;

import java.io.IOException;

import org.bson.types.ObjectId;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class ObjectIdSerializer extends JsonSerializer<ObjectId>{

	@Override
	public void serialize(ObjectId value, JsonGenerator jgen, SerializerProvider arg2) throws IOException {
		jgen.writeString(value.toString());
	}}
