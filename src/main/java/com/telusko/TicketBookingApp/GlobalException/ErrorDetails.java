package com.telusko.TicketBookingApp.GlobalException;

import java.time.LocalDateTime;

public class ErrorDetails
{
    private String errortype;
    
    private String errormsg;
    
    private LocalDateTime time;

	public ErrorDetails(String errortype, String errormsg, LocalDateTime time) {
		super();
		this.errortype = errortype;
		this.errormsg = errormsg;
		this.time = time;
	}

	public ErrorDetails() {
		super();
	}

	public String getErrortype() {
		return errortype;
	}

	public void setErrortype(String errortype) {
		this.errortype = errortype;
	}

	public String getErrormsg() {
		return errormsg;
	}

	public void setErrormsg(String errormsg) {
		this.errormsg = errormsg;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "ErrorDetails [errortype=" + errortype + ", errormsg=" + errormsg + ", time=" + time + "]";
	}
    
    
}
