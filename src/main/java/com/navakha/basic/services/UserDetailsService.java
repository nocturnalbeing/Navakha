package com.navakha.basic.services;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.navakha.basic.Entities.UserDetails;
import com.navakha.basic.Utils.UserDetailsUtil;
import com.navakha.basic.repositories.UserDetailsRepository;
import com.navakha.basic.response.UserDetailsResponse;

@Service
public class UserDetailsService {
	@Autowired
	UserDetailsRepository userDetailsRepository;
	@Autowired
	UserDetailsUtil userDetailsUtil;

	public UserDetailsResponse insertUserDetails(UserDetails details) {
		System.out.println(details);
		UserDetailsResponse response=new UserDetailsResponse();
		if ((!details.getUserEmail().equals(null))&&!details.getUserEmail().trim().equals("")) {
			List<UserDetails> emailResults = userDetailsRepository.findByUserEmail(details.getUserEmail());
			int size = emailResults.size();
			
			if (size != 0) {
				UserDetails userDetails = emailResults.get(0);
				System.out.println("in insert service");
				//userDetails.setProfilePicture(details.getProfilePicture());
				UserDetails savedUserDetails = userDetailsRepository.save(userDetails);
				savedUserDetails.setUserProfilePic(details.getUserProfilePic());
				response.setDetails(savedUserDetails);
				response.setMessage("details have been saved successfully");
				response.setStatus("Success");
				return response;
			} else {
				details.setUserToken(userDetailsUtil.generateBitKey());
				UserDetails savedUserDetails = userDetailsRepository.save(details);
				response.setDetails(savedUserDetails);
				response.setMessage("details have been saved successfully");
				response.setStatus("Success");
				return response;
			}
						//profilePicUpload(details.getProfilePicture(), details.getUserEmail());
		}
		response.setStatus("Failed");
		response.setMessage("unfortunately details not got inserted");
		return response;
		

	}

	public void profilePicUpload(MultipartFile file, String fileName) {
		String directoryPath = "C:\\Users\\sanjay\\Documents\\uploadedPics\\";
		uploadPictureToADirectory(file, fileName, directoryPath, true);

	}

	private void uploadPictureToADirectory(MultipartFile file, String fileName, String directoryPath, boolean unique) {
		if (file == null) {
			return;
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
		} catch (IOException e) {
			System.out.println();
			e.printStackTrace();
		}
	}

}
