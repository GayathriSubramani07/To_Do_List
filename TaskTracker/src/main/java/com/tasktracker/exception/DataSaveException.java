package com.tasktracker.exception;

public class DataSaveException extends RuntimeException {
	private String message;

	public DataSaveException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
