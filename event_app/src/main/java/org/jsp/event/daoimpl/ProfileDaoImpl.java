package org.jsp.event.daoimpl;

import java.util.List;
import java.util.Optional;

import org.jsp.event.dao.ProfileDao;
import org.jsp.event.entity.Profile;
import org.jsp.event.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.parsing.ProblemReporter;
import org.springframework.stereotype.Repository;

@Repository
public class ProfileDaoImpl implements ProfileDao {
	
	@Autowired
	private ProfileRepository profilerepository;

	@Override
	public Profile saveProfile(Profile profile) {
		// TODO Auto-generated method stub
		return profilerepository.save(profile);
	}

	@Override
	public Profile updateProfile(Profile profile) {
		// TODO Auto-generated method stub
		return profilerepository.save(profile);
	}

	@Override
	public Optional<Profile> findProfileById(int id) {
		// TODO Auto-generated method stub
		return profilerepository.findById(id);
	}

	@Override
	public List<Profile> findAllProfile() {
		// TODO Auto-generated method stub
		return profilerepository.findAll();
	}

}
