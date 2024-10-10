package org.jsp.event.exceptionhandler;

import org.jsp.event.exceptionclasses.InvalidEventIdException;
import org.jsp.event.exceptionclasses.NoEventFoundException;
import org.jsp.event.responsestructure.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class EventExceptionHandler {
	
	@ExceptionHandler(NoEventFoundException.class)
	public ResponseEntity<?> noEventExceptionHandler(NoEventFoundException e)
	{
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ResponseStructure.builder().status(HttpStatus.NOT_FOUND.value()).message("No Event Found").body(e.getMessage()).build());
	}
	
	@ExceptionHandler(InvalidEventIdException.class)
	public ResponseEntity<ResponseStructure<String>>  invalidEventIdException(InvalidEventIdException e)
	{
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setMessage("Invalid Event Id");
		structure.setBody(e.getMessage());
		return new ResponseEntity(structure, HttpStatus.NOT_FOUND);
	}

}
