package com.co.edu.udea.motoapp.repositories;

import java.util.Collections;
import java.util.List;
import java.util.regex.PatternSyntaxException;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.co.edu.udea.motoapp.model.Motorcycle;

@Service
public class CustomzedMotoDaoImp implements CustomzedMotoDao {

	MongoOperations mongoOperations;
	 
	@Override
	public List<Motorcycle> findCustomLetters(String name) {
		try{
            Query query = new Query();
            query.addCriteria(Criteria.where("name").regex(toLikeRegex(name)));
            return mongoOperations.find(query, Motorcycle.class);
        } catch(PatternSyntaxException e) {
            return Collections.emptyList();
        }
	}
	
	private String toLikeRegex(String source) {
        return source.replaceAll("\\*", ".*");
    }

}
