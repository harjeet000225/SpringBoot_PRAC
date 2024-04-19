package com.harjeet.SpringFile;

import java.io.File;
import java.io.IOException;
import java.net.http.HttpHeaders;
import java.nio.file.Files;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
public class FileController {
	
	@Value("${uploadDir}")
	private String uploaddir="";
	
	@PostMapping("/uploads/")
	public boolean upload(@RequestParam("file") MultipartFile file) throws IllegalStateException, IOException {
		file.transferTo(new File(uploaddir+ file.getOriginalFilename()));
		System.out.print(file.getOriginalFilename());
		return true;
	}
	
	@GetMapping("/download/{filename}")
	public ResponseEntity<byte[]> download(@PathVariable("filename") String filename) throws IOException{
		byte[] filedata =Files.readAllBytes(new File(uploaddir+filename).toPath());
		org.springframework.http.HttpHeaders httpHeaders = new org.springframework.http.HttpHeaders();
		System.out.print(HttpStatus.OK);
		org.springframework.http.HttpHeaders httptest=new org.springframework.http.HttpHeaders();
		httptest.setContentType(MediaType.IMAGE_JPEG);
		return new ResponseEntity<>(filedata,httptest,HttpStatus.OK);
		
	}
	
}
