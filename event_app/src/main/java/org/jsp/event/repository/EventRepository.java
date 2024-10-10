package org.jsp.event.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.jsp.event.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EventRepository extends JpaRepository<Event, Integer> {

	@Query("select e from Event e where e.status='UP_COMMING'")
	List<Event> findAllUpcommingEvents();
	
	@Query("select e from Event e where e.status='UP_GOING'")
	List<Event> findAllOngoingEvents();
	
	@Query("select e from Event e where e.status='COMPLETED'")
	List<Event> findAllCompletedEvents();
	
	@Query("select e from Event e where e.status='DELETED'")
	List<Event> findAllDeletedEvents();
	
	//@Query("select e from Event e where e.fromDateTime between")
//	List<Event> findEventsBetweenDates(LocalDateTime fromDateTime, LocalDateTime toDateTime);
	
	
}
