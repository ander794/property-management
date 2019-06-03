package com.ander.cloud.propertymanagement.fileupload;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(path = "/upload")
public class FileUploadController {

	@Autowired
	private StorageService storageService;

	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public FileEntity uploadFile(@RequestParam("file") MultipartFile file) {
		storageService.uploadFile(file);
		return null;
	}

	@PostMapping(path="uploadFiles")
	@ResponseStatus(HttpStatus.OK)
	public List<FileEntity> uploadMultipleFiles(@RequestParam("file") MultipartFile[] files) {
		  Arrays.asList(files)
	                .stream()
	                .forEach(file -> storageService.uploadFile(file));
          			//.map(file -> uploadFile(file))
	                //.collect(Collectors.toList());
		  
		  return null;
	}
}
