package org.jsp.event.daoimpl;

import java.util.List;
import java.util.Optional;

import org.jsp.event.dao.EventDao;
import org.jsp.event.entity.Event;
import org.jsp.event.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
@Repository
public class EventDaoImpl implements EventDao{

	@Autowired
	private EventRepository eventRepository;
	
	
	
	@Override
	public Event saveEvent(Event event) {
		return eventRepository.save(event);
	}

	@Override
	public Event updateEvent(Event event) {
		return eventRepository.save(event);
	}

	@Override
	public Optional<Event> findEventById(int id) {
		
		return eventRepository.findById(id);
	}

	@Override
	public List<Event> findAllEvents() {
		
		return eventRepository.findAll();
	}

	@Override
	public List<Event> findAllUpcommingEvents() {
		
		return eventRepository.findAllUpcommingEvents();
	}

	@Override
	public List<Event> findAllOngoingEvents() {
	
		return eventRepository.findAllOngoingEvents();
	}

	@Override
	public List<Event> findAllCompletedEvents() {
		// TODO Auto-generated method stub
		return eventRepository.findAllCompletedEvents();
	}

	@Override
	public List<Event> findAllDeletedEvents() {

		return eventRepository.findAllDeletedEvents();
	}

}
