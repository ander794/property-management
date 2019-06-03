package com.ander.cloud.propertymanagement.fileupload;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

@Service
public class PictureStorageService implements StorageService {

	@Autowired
	private GridFsTemplate gridFsTemplate;
	
	@Override
	public void uploadFile(MultipartFile file) {
		InputStream inputStream;
		try {
			inputStream = new FileInputStream("src/main/resources/test.jpg");
			DBObject metaData = new BasicDBObject();
			metaData.put("user", "alex");
			gridFsTemplate.store(inputStream, "test.png", "image/png", metaData).toString();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void getFileById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getFileByName(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteFileById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

}
