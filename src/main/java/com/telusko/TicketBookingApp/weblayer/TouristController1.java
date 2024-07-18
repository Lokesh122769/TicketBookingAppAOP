package com.telusko.TicketBookingApp.weblayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.telusko.TicketBookingApp.Exception.TouristNotFoundException;
import com.telusko.TicketBookingApp.Model.Tourist;
import com.telusko.TicketBookingApp.service.ITouristManagement;
import java.util.*;

@RestController
@RequestMapping("/api1")
public class TouristController1
{

	@Autowired
	private ITouristManagement service;
	
	@PostMapping("/register")
	public ResponseEntity<String> enrollTourist(@RequestBody Tourist tourist)
	{
		try
		{
			String response=service.register(tourist);
			return new ResponseEntity<String>(response, HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<String>("Error while Registration", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	
	@GetMapping("/getAllTourist")
	public ResponseEntity<?> fetchAllTourist(@RequestBody Tourist tourist)
	{
		try
		{
			List<Tourist> list=service.fetchAll();
			return new ResponseEntity<>(list, HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<String>("Error while Fetching Tourist Data", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	
	@GetMapping("/getTouristById/{id}")
	public ResponseEntity<?> fetchTouristbyId(@PathVariable("id") Integer id)
	{
		try
		{
			Tourist tourist=service.fetchTouristById(id);   
			return new ResponseEntity<>(tourist, HttpStatus.OK);
		}
		catch(TouristNotFoundException e)
		{
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
	}
	
	
	
	@PutMapping("/update")
	public ResponseEntity<?> updateTourist(@RequestBody Tourist tourist)
	{
		try
		{
			String s=service.UpdateTourist(tourist);   
			return new ResponseEntity<>(s, HttpStatus.OK);
		}
		catch(TouristNotFoundException e)
		{
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
	}
	
	

	@PatchMapping("/updatebudget/{id}/{budget}")
	public ResponseEntity<?> updateBudget(@PathVariable Integer id,@PathVariable Double budget)
	{
		try
		{
			String s=service.updateBudget(id, budget);   
			return new ResponseEntity<>(s, HttpStatus.OK);
		}
		catch(TouristNotFoundException e)
		{
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id)
	{
		
			String response=service.removeTouristById(id);
			return new ResponseEntity<>(response,HttpStatus.OK);  
		
	}
	
}
