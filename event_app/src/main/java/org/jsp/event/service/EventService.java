package org.jsp.event.service;

import java.time.LocalDateTime;

import org.jsp.event.entity.Event;
import org.springframework.http.ResponseEntity;

public interface EventService {

	ResponseEntity<?> saveEvents(Event event);

	ResponseEntity<?> findAllEvents();

	ResponseEntity<?> findAllUpcommingEvents();

	ResponseEntity<?> findAllongoingEvents();

	ResponseEntity<?> findAllcompletedEvents();

	ResponseEntity<?> findAlldeletedEvents();

	ResponseEntity<?> setEventStatusToOngoing(int id);

	ResponseEntity<?> setEventStatusToUpcoming(int id);

	ResponseEntity<?> setEventStatusToCompleted(int id);

	ResponseEntity<?> setEventStatusToDeleted(int id);

	ResponseEntity<?> findEventsBetweenDates(LocalDateTime fromDateTime, LocalDateTime toDateTime);

}
