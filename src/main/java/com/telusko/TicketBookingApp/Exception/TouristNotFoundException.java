package com.telusko.TicketBookingApp.Exception;

@SuppressWarnings("serial")
public class TouristNotFoundException extends RuntimeException
{
     public TouristNotFoundException(String msg)
     {
    	 super(msg);
     }
}
