package org.jsp.event.repository;

import org.jsp.event.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Integer>{

}
