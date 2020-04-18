package com.navakha.basic.services;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FilesService {
	public String uploadPictureToADirectory(MultipartFile file, String fileName, String directoryPath, boolean unique) {
		if (file == null) {
			return null;
		}
		try {
			System.out.println(" not empty");

// Get the file and save it somewhere
			byte[] bytes = file.getBytes();
			String UPLOADED_FOLDER = directoryPath;
			System.out.println(file.getOriginalFilename());
			Path path = Paths.get(UPLOADED_FOLDER + fileName
					+ file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")).toLowerCase());
			if (unique) {
				File filesList = new File(directoryPath);
				String[] fileList = filesList.list();
				for (String name : fileList) {
					System.out.println(name);
					if (name.contains(fileName)) {
						Path path1 = Paths.get(UPLOADED_FOLDER + name);
						Files.delete(path1);
					}
				}
			}
			Files.write(path, bytes);
			return UPLOADED_FOLDER + fileName
					+ file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")).toLowerCase();
			
		} catch (IOException e) {
			System.out.println();
			e.printStackTrace();
		}
		return null;
	}

}
