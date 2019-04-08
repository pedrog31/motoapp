package com.co.edu.udea.motoapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.co.edu.udea.motoapp.model.Response;
import com.co.edu.udea.motoapp.service.FileService;

@RestController
@RequestMapping("/files")
public class FileController {

	@Autowired
	private FileService fileService;

	@CrossOrigin(origins = "*")
	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<String> save(@RequestParam("file") MultipartFile file) {
		try {
			String fileName = fileService.saveFile(file);
			return new ResponseEntity<>(fileName, HttpStatus.ACCEPTED);
		} catch (Exception ex) {
			String content = "<header><h2><span>Error guardando archivo</span></h2></header>";
			ex.printStackTrace();
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.setContentType(MediaType.TEXT_HTML);
			return new ResponseEntity<>(content, responseHeaders, HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping(value = "/{name}")
	public ResponseEntity<Object> obtenerArchivo(@PathVariable String name) {
		try {
			Resource file = fileService.getFile(name);
			return ResponseEntity.ok()
					.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
					.body(file);
		} catch (Exception ex) {
			String content = "<header><h2><span>Archivo no encontrado</span></h2></header>";
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.setContentType(MediaType.TEXT_HTML);

			return new ResponseEntity<>(content, responseHeaders, HttpStatus.NOT_FOUND);
		}
	}
}
