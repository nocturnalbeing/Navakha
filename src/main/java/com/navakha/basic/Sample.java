package com.navakha.basic;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import org.springframework.core.io.ClassPathResource;
import org.springframework.util.StreamUtils;
import org.springframework.web.multipart.MultipartFile;

import com.navakha.basic.miscellaneous.BASE64DecodedMultipartFile;

public class Sample {
	public static void main(String[] args) {
		/*
		 * new
		 * Sample().getStream("C:/Users/sanjay/Documents/uploadedPosts/NAVAKHAPOST2.JPG"
		 * ); ClassPathResource imgFile = new ClassPathResource(
		 * "C://Users//sanjay//Documents//uploadedPosts//NAVAKHAPOST2.JPG");
		 * System.out.println(imgFile); try { byte[] bytes =
		 * StreamUtils.copyToByteArray(imgFile.getInputStream());
		 * System.out.println(bytes); MultipartFile file = new
		 * BASE64DecodedMultipartFile(bytes); // post.setPhotoStatus(file); } catch
		 * (IOException e) { // TODO Auto-generated catch block e.printStackTrace(); }
		 */
		BufferedImage image = null;
        try {
            File sourceimage = new File("C:/Users/sanjay/Documents/uploadedPosts/NAVAKHAPOST2.JPG");
              BufferedImage read = ImageIO.read(sourceimage);
              ByteArrayOutputStream baos = new ByteArrayOutputStream();
              ImageIO.write( read, "jpg", baos );
              baos.flush();
              byte[] imageInByte = baos.toByteArray();
              System.out.println(imageInByte);
              baos.close();
              
              System.out.println(read);
              

        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	public InputStream getStream(String path) {
		InputStream in = getClass()
			      .getResourceAsStream(path);
		System.out.println(in.toString());
		return in;
	}
	
}
