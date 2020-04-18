package com.navakha.basic.services;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StreamUtils;
import org.springframework.web.multipart.MultipartFile;

import com.navakha.basic.Entities.Post;
import com.navakha.basic.VO.PostVO;
import com.navakha.basic.miscellaneous.BASE64DecodedMultipartFile;
import com.navakha.basic.miscellaneous.PropertiesFile;
import com.navakha.basic.repositories.PostRepository;

@Service
public class PostService {
	@Autowired
	PostRepository postRepository;
	@Autowired
	FilesService filesService;
	@Autowired
	MiscellaneousService miscellaneousService;

	public Post uploadAPost(Post post) {
		if (post.getPhotoStatus() != null) {
			String postName = miscellaneousService.generateBitKeyForPost();

			String directoryPath = PropertiesFile.uploadedPostsFolder;
			String path = filesService.uploadPictureToADirectory(post.getPhotoStatus(), postName, directoryPath, false);
			post.setPhotoDirectory(path);
		}
		Post savedPost = postRepository.save(post);

		return savedPost;

	}

	public void populatePhotosPostFromDirectory(List<PostVO> postList) {
		System.out.println("populating");
		postList.forEach(post -> {
			if (post.getPhotoDirectory() != null) {

				/*
				 * ClassPathResource imgFile = new ClassPathResource(post.getPhotoDirectory());
				 * System.out.println(imgFile); try { byte[] bytes =
				 * StreamUtils.copyToByteArray(imgFile.getInputStream()); MultipartFile file=new
				 * BASE64DecodedMultipartFile(bytes); post.setPhotoStatus(file); } catch
				 * (IOException e) { // TODO Auto-generated catch block e.printStackTrace(); }
				 */
				File sourceimage = new File(post.getPhotoDirectory());
				BufferedImage read;
				try {
					read = ImageIO.read(sourceimage);

					ByteArrayOutputStream baos = new ByteArrayOutputStream();
					ImageIO.write(read, "jpg", baos);
					baos.flush();
					byte[] imageInByte = baos.toByteArray();
					System.out.println(baos);
					baos.close();
				//	byte[] bytes = StreamUtils.copyToByteArray(imgFile.getInputStream());
					MultipartFile file = new BASE64DecodedMultipartFile(imageInByte);
					post.setPhotoStatus(file);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}

}
