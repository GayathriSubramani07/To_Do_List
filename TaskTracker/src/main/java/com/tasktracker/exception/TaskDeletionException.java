package com.tasktracker.exception;

public class TaskDeletionException extends RuntimeException {
	
	private String message;

	public TaskDeletionException(String message) {
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
