package org.jsp.event.controller;

import org.jsp.event.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/profiles")
public class ProfileController {
	
	@Autowired
	private ProfileService profileService;
	
	
	@PostMapping
	public ResponseEntity<?> saveProfile(@RequestParam MultipartFile file)//catch any file png,
	{
	  return profileService.saveProfile(file);	
	}
	

}
