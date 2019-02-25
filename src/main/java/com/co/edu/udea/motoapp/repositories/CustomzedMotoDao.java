package com.co.edu.udea.motoapp.repositories;

import java.util.List;

import com.co.edu.udea.motoapp.model.Motorcycle;


public interface CustomzedMotoDao {
	public List<Motorcycle> findCustomLetters(String name);
}
