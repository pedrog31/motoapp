package com.co.edu.udea.motoapp.service;


import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {
	
	public String saveFile(MultipartFile file) throws Exception;
	
	public Resource getFile(String name) throws Exception;
	
	public void init();
}
