package com.telusko.TicketBookingApp.GlobalException;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.telusko.TicketBookingApp.Exception.TouristNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler
{

	
	@ExceptionHandler(TouristNotFoundException.class)
	public ResponseEntity<?> touristNotFound(TouristNotFoundException te)
	{
		ErrorDetails ed=new ErrorDetails("404 Not Found",te.getMessage(),LocalDateTime.now());
		return new ResponseEntity<ErrorDetails>(ed, HttpStatus.BAD_REQUEST);
	}
	
}
