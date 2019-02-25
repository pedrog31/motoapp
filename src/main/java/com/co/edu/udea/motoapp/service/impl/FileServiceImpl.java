package com.co.edu.udea.motoapp.service.impl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.logging.Logger;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.co.edu.udea.motoapp.service.FileService;

@Service
public class FileServiceImpl implements FileService {

	Logger log = Logger.getLogger(this.getClass().getName());
	public static final String UPLOAD_FILE_SERVER = "/Archivos-Adjuntos/";
	private Path rootLocation;

	public FileServiceImpl() {
		this.rootLocation = Paths.get(UPLOAD_FILE_SERVER);
	}

	@Override
	public String saveFile(MultipartFile file) throws Exception {
		try {
			String name = (new Date()).getTime() + "_" + file.getOriginalFilename();
            Files.copy(file.getInputStream(), this.rootLocation.resolve(name));
            return name;
        } catch (IOException ioe) {
            final String mensaje = "IOException: " + ioe.getMessage();
            log.info(mensaje);
            throw new Exception(mensaje);
        }
	}

	@Override
	public Resource getFile(String name) throws Exception {
		try {
			Path archivo = rootLocation.resolve(name);
			Resource resource = new UrlResource(archivo.toUri());
			if (resource.exists() || resource.isReadable()) {
				return resource;
			} else {
				final String mensaje = "Archivo no encontrado";
				log.info(mensaje);
				throw new Exception(mensaje);
			}
		} catch (MalformedURLException murle) {
			final String mensaje = "Error obteniendo archivo: " + murle.getMessage();
			log.info(mensaje);
			throw new Exception(mensaje);
		}
	}

	@Override
	public void init() {
		try {
			rootLocation = Paths.get(UPLOAD_FILE_SERVER);
			Files.createDirectory(rootLocation);
			log.info("Directorio " + UPLOAD_FILE_SERVER + " creado correctamente");
		} catch (IOException e) {
			log.info("Directorio " + UPLOAD_FILE_SERVER + " ya fue creado");
		}
	}

}
