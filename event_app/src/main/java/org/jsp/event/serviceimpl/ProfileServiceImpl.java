package org.jsp.event.serviceimpl;

import java.io.File;
import java.io.IOException;

import org.jsp.event.dao.ProfileDao;
import org.jsp.event.entity.Profile;
import org.jsp.event.responsestructure.ResponseStructure;
import org.jsp.event.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ProfileServiceImpl implements ProfileService {

	private static final String FOLDER_PATH = "/Users/mdadil/Desktop/event_profile/";
	
	@Autowired
	private ProfileDao profileDao;
	
	@Override
	public ResponseEntity<?> saveProfile(MultipartFile file) {
	
	String name = file.getOriginalFilename();
	String type = file.getContentType();
	String path = FOLDER_PATH + name;
	
	try {
		file.transferTo(new File(path));
	} catch (Exception e) {
		e.printStackTrace();
	}
		
    Profile p =	Profile.builder().name(name).type(type).path(path).build();
	
    p = profileDao.saveProfile(p);
    
    
    
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("profile saved Successfully").body(p).build());
	}

}
