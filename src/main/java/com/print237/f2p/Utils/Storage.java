package com.print237.f2p.Utils;

import java.io.IOException;

import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Component;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

@Component
public class Storage {
	Logger log = LoggerFactory.getLogger(this.getClass().getName());
	private final Path rootLocation = Paths.get("print237-f2p-dir");
	
	// sauvegarde un fichier dans le store du serveur
	public Boolean store(MultipartFile file) {
		try {
			Path fichier = this.rootLocation.resolve(file.getOriginalFilename());
			if(Files.notExists(fichier)) {
    			Files.copy(file.getInputStream(), this.rootLocation.resolve(file.getOriginalFilename()));
    			return true;
			}else return false;
			
		} catch (Exception e) {
			throw new RuntimeException("ECHEC DE STOCKAGE DU FICHIER "+file.getOriginalFilename()+" !");
		}
	}
	
	
	public Resource loadFile(String filename){
		try {
			Path file = rootLocation.resolve(filename);
			Resource resource = new UrlResource(file.toUri());
			if (resource.exists() || resource.isReadable()) {
				return resource;
			} else {
				throw new RuntimeException("ECHEC DE CHARGEMENT DU FICHIER "+filename+" !");
			}
		} catch (MalformedURLException e) {
			
			throw new RuntimeException("ECHEC DE CHARGEMENT DU FICHIER "+filename+" !");
		}
	}
	
	public void init() {
		try {
			if (Files.notExists(rootLocation)) Files.createDirectory(rootLocation);
		} catch (IOException e) {
			throw new RuntimeException("Impossible d'initialiser le stockage!");
		}
	}
	
	public void deleteFile(String name) {
		Path locationOfFile = Paths.get("ylis-trp-dir/"+name);
		FileSystemUtils.deleteRecursively(locationOfFile.toFile());
	}
	


}
