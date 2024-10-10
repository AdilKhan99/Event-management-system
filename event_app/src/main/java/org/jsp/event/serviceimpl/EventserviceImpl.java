package org.jsp.event.serviceimpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.jsp.event.dao.EventDao;
import org.jsp.event.entity.Event;
import org.jsp.event.exceptionclasses.InvalidEventIdException;
import org.jsp.event.exceptionclasses.NoEventFoundException;
import org.jsp.event.responsestructure.ResponseStructure;
import org.jsp.event.service.EventService;
import org.jsp.event.util.EventStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EventserviceImpl  implements EventService{
    
	@Autowired
	private EventDao eventDao;
	
	
	
	
	@Override
	public ResponseEntity<?> saveEvents(Event event) {
	event.setStatus(EventStatus.UP_COMING);
	Event dbEvent =	eventDao.saveEvent(event);
	return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("Event Saved Successfully").body(dbEvent).build());
	}




	@Override
	public ResponseEntity<?> findAllEvents() {
	List<Event> events = eventDao.findAllEvents();
	if(events.isEmpty())

		throw NoEventFoundException.builder().message("No Event found in the Database table").build();
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("All Event Found Successfully").body(events).build());
	
	 
	}


    @Override
	public ResponseEntity<?> findAllUpcommingEvents() {
	List<Event> events = eventDao.findAllUpcommingEvents();
	if(events.isEmpty())
		throw NoEventFoundException
		.builder()
		.message("No UP_COMMING Events Found in the data base ")
		.build();
		return ResponseEntity
		.status(HttpStatus.OK)
		.body(ResponseStructure
				.builder().status(HttpStatus.OK.value())
				.message("ALL UP_COMMING Events Found in the data base successfully ")
				.body(events).build());
	}




	@Override
	public ResponseEntity<?> findAllongoingEvents() {
		List<Event> events = eventDao.findAllOngoingEvents();
	
		if(events.isEmpty())
			throw NoEventFoundException
			.builder()
			.message("No ON_GOING Events Found in the data base ")
			.build();
			return ResponseEntity
			.status(HttpStatus.OK)
			.body(ResponseStructure
					.builder().status(HttpStatus.OK.value())
					.message("ALL ON_GOING Events Found  successfully ")
					.body(events).build());
		}




	@Override
	public ResponseEntity<?> findAllcompletedEvents() {
		List<Event> events = eventDao.findAllOngoingEvents();
		
		if(events.isEmpty())
			throw NoEventFoundException
			.builder()
			.message("")
			.build();
			return ResponseEntity
			.status(HttpStatus.OK)
			.body(ResponseStructure
					.builder().status(HttpStatus.OK.value())
					.message(" ")
					.body(events).build());
	}




	@Override
	public ResponseEntity<?> findAlldeletedEvents() {
		List<Event> events = eventDao.findAllDeletedEvents();
		if(events.isEmpty())
			throw NoEventFoundException.builder().message("No DELETED Events Found In The Database Table").build();
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(ResponseStructure
						.builder().status(HttpStatus.OK.value()).message("All Deleted Events Found Successfully").body(events).build());


	}




	@Override
	public ResponseEntity<?> setEventStatusToOngoing(int id) 
	{
		Optional<Event> event =  eventDao.findEventById(id);
		if(event.isEmpty())
		throw InvalidEventIdException.builder().message("Invalid Event Id Unable To Set Status To ON_GOING").build();
		
		Event e = event.get();
		e.setStatus(EventStatus.ON_GOING);
		e = eventDao.updateEvent(e);
		return ResponseEntity
		.status(HttpStatus.OK)
		.body(ResponseStructure
		.builder()
		.status(HttpStatus.OK.value()).message("Event Status Updated To ON_GOING").body(e).build());

	}




	@Override
	public ResponseEntity<?> setEventStatusToUpcoming(int id) {
		Optional<Event> event =  eventDao.findEventById(id);
		if(event.isEmpty())
		throw InvalidEventIdException.builder().message("Invalid Event Id Unable To Set Status To Completed").build();
		
		Event e = event.get();
		e.setStatus(EventStatus.ON_GOING);
		e = eventDao.updateEvent(e);
		return ResponseEntity
		.status(HttpStatus.OK)
		.body(ResponseStructure
		.builder()
		.status(HttpStatus.OK.value()).message("Event Status Updated To Completed").body(e).build());
	}




	@Override
	public ResponseEntity<?> setEventStatusToCompleted(int id) {
		Optional<Event> event =  eventDao.findEventById(id);
		if(event.isEmpty())
		throw InvalidEventIdException.builder().message("Invalid Event Id Unable To Set Status To Completed").build();
		
		Event e = event.get();
		e.setStatus(EventStatus.ON_GOING);
		e = eventDao.updateEvent(e);
		return ResponseEntity
		.status(HttpStatus.OK)
		.body(ResponseStructure
		.builder()
		.status(HttpStatus.OK.value()).message("Event Status Updated To Completed").body(e).build());
	}




	@Override
	public ResponseEntity<?> setEventStatusToDeleted(int id) {
		Optional<Event> event =  eventDao.findEventById(id);
		if(event.isEmpty())
		throw InvalidEventIdException.builder().message("Invalid Event Id Unable To Set Status To Completed").build();
		
		Event e = event.get();
		e.setStatus(EventStatus.ON_GOING);
		e = eventDao.updateEvent(e);
		return ResponseEntity
		.status(HttpStatus.OK)
		.body(ResponseStructure
		.builder()
		.status(HttpStatus.OK.value()).message("Event Status Updated To Completed").body(e).build());
		
	}




	@Override
	public ResponseEntity<?> findEventsBetweenDates(LocalDateTime fromDateTime,LocalDateTime toDateTime) {
      List<Event> events = eventDao.findAllEvents();
      if(events.isEmpty())
    	  throw NoEventFoundException.builder().message("No Event found in the date base table....").build();
		
      ArrayList<Event> eventsInRange = new ArrayList<>();
      
      
      
		for(Event e : events)
		{
			if(e.getFromDateTime().isAfter(fromDateTime) && e.getToDateTime().isBefore(toDateTime))
			{
				eventsInRange.add(e);
			}
		}
		
		if(eventsInRange.isEmpty())
			throw NoEventFoundException.builder().message("No Event found inthe given date range...").build();
		
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(ResponseStructure
						.builder()
						.status(HttpStatus.OK.value())
						.message("All events found in the given date range")
						.body(eventsInRange)
						.build());
	}



    
	






		
		
		
		
    
    
    
    
    
    
    
    
    
    
    
    

}
