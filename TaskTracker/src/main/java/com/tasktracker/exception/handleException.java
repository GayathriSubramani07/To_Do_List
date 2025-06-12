package com.tasktracker.exception;



import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.tasktracker.response.ResponseStructure;

@RestControllerAdvice
public class handleException {
	
	@ExceptionHandler(DataSaveException.class)
	private ResponseEntity<ResponseStructure<String>> handlesaveException(DataSaveException ds){
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setMessage("Error saving task");
		structure.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		structure.setObj(ds.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ResponseStructure<Object>> handleValidationException(MethodArgumentNotValidException ex) {
	    Map<String, String> errors = new HashMap<>();
	    
	    ex.getBindingResult().getFieldErrors().forEach(error -> {
	        errors.put(error.getField(), error.getDefaultMessage());
	    });

	    ResponseStructure<Object> structure = new ResponseStructure<>();
	    structure.setMessage("Validation Failed");
	    structure.setStatus(HttpStatus.BAD_REQUEST.value());
	    structure.setObj(errors);  

	    return new ResponseEntity<>(structure, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(TaskNotFoundException.class)
	private ResponseEntity<ResponseStructure<String>> handlegetException(TaskNotFoundException te){
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setMessage("Data Not found");
		structure.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		structure.setObj(te.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	 @ExceptionHandler(TaskDeletionException.class)
	    public ResponseEntity<ResponseStructure<String>> handleTaskDeletionException(TaskDeletionException ex) {
	        ResponseStructure<String> structure = new ResponseStructure<>();
	        structure.setMessage("Data not found");
	        structure.setStatus(HttpStatus.NOT_FOUND.value());
	        structure.setObj(ex.getMessage());
	        return new ResponseEntity<>(structure, HttpStatus.NOT_FOUND);
	    }

}
