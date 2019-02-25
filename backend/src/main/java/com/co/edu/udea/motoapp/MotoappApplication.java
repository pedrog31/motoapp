package com.co.edu.udea.motoapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.co.edu.udea.motoapp.service.FileService;

@SpringBootApplication
public class MotoappApplication implements CommandLineRunner {

    @Autowired
    FileService servicioCargaArchivos;
    
	public static void main(String[] args) {
		SpringApplication.run(MotoappApplication.class, args);
	}
	
	@Override
    public void run(String... arg) {
        servicioCargaArchivos.init();
    }
}
