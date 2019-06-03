package com.ander.cloud.propertymanagement.fileupload;

import org.springframework.web.multipart.MultipartFile;

public interface StorageService {
	public void uploadFile(MultipartFile file);

	public void getFileById(Long id);

	public void getFileByName(String name);

	public void deleteFileById(Long id);

	public void deleteAll();
}
