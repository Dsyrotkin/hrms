package com.hrms.exc.exception;

public class OperationResult {
	private boolean succces = false;
	private String message = "The delete operation has been failed";
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isSuccces() {
		return succces;
	}

	public void setSuccces(boolean succces) {
		this.succces = succces;
	}


}
