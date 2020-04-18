package com.navakha.basic.miscellaneous;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.multipart.MultipartFile;

public class BASE64DecodedMultipartFile implements MultipartFile,Serializable {
	
	
	public BASE64DecodedMultipartFile(byte[] imgContent) {
		super();
		this.imgContent = imgContent;
	}

	public byte[] getImgContent() {
		return imgContent;
	}

	public void setImgContent(byte[] imgContent) {
		this.imgContent = imgContent;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public void setExt(String ext) {
		this.ext = ext;
	}

	private byte[] imgContent;
	private String fileName;
	private String ext;
  
	public String getExt() {
		return ext;
	}
	
	@Override
	public String getName() {
		return fileName;
	}

	@Override
	public String getOriginalFilename() {
		return fileName;
	}

	@Override
	public String getContentType() {
		if(getExt() == null) {
			return null;
		}
		return null;
	}

	@Override
	public boolean isEmpty() {
		return imgContent == null || imgContent.length == 0;
	}

	@Override
	public long getSize() {
		return imgContent.length;
	}

	@Override
	public byte[] getBytes() throws IOException {
		return imgContent;
	}

	@Override
	public InputStream getInputStream() throws IOException {
		return new ByteArrayInputStream(imgContent);
	}

	@Override
	public void transferTo(File dest) throws IOException {
		try (FileOutputStream f = new FileOutputStream(dest)) {
			f.write(imgContent);
		}
	}
}