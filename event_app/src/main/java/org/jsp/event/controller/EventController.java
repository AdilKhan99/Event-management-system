package org.jsp.event.controller;

import java.time.LocalDateTime;

import org.jsp.event.entity.Event;
import org.jsp.event.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/events")
public class EventController {
	
	@Autowired
	private EventService eventService;
	
	@PostMapping
	public ResponseEntity<?> saveEvent(@RequestBody Event event)
	{
		return eventService.saveEvents(event);
	}
	
	
	@GetMapping
	public ResponseEntity<?> findAllEvents()
	{
		return eventService.findAllEvents();
	}
	
	
	@GetMapping(value = "/upcomming")
	public ResponseEntity<?> findAllUpcommingEvents()
	{
		return eventService.findAllUpcommingEvents();
	}
	
	
	@GetMapping(value = "/ongoing")
	public ResponseEntity<?> findAllongoingEvent()
	{
		return eventService.findAllongoingEvents();
	}

	@GetMapping(value = "/completed")
	public ResponseEntity<?> findAllcompletedEvent()
	{
		return eventService.findAllcompletedEvents();
	}

	@GetMapping(value="/deleted")
	public ResponseEntity<?> findAlldeletedEvents()
	{
		return eventService.findAlldeletedEvents();
	}
	
	@PatchMapping(value = "/ongoing/{id}")
	public ResponseEntity<?> setEventStatusToOngoing(@PathVariable int id)
	{
		return eventService.setEventStatusToOngoing(id);
	}
	
	@PatchMapping(value="/upcoming/{id}")
	public ResponseEntity<?> setEventStatusToUpcoming(@PathVariable int id){
		return eventService.setEventStatusToUpcoming(id);
	}
	
	@PatchMapping(value="/completed/{id}")
	public ResponseEntity<?> setEventStatusToCompleted(@PathVariable int id){
		return eventService.setEventStatusToCompleted(id);
	}
	
	@PatchMapping(value="/deleted/{id}")
	public ResponseEntity<?> setEventStatusToDeleted(@PathVariable int id){
		return eventService.setEventStatusToDeleted(id);
	}
	
	@GetMapping(value = "/in-date")
	public ResponseEntity<?> findEventsBetweenDates(@RequestParam  LocalDateTime fromDateTime,@RequestParam  LocalDateTime toDateTime)
	{
		
		
		return eventService.findEventsBetweenDates(fromDateTime,toDateTime);
	}
	
	
	

}
