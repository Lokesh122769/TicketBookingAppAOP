package com.telusko.TicketBookingApp.service;

import com.telusko.TicketBookingApp.Model.Tourist;
import java.util.*;


public interface ITouristManagement
{

	
	public String register(Tourist tourist);
	
	public List<Tourist> fetchAll();
	
	
	public Tourist fetchTouristById(Integer id);
	
	
	public String UpdateTourist(Tourist tourist);
	
	public String updateBudget(Integer id,Double budget);
	
	public String removeTouristById(Integer id);
}
