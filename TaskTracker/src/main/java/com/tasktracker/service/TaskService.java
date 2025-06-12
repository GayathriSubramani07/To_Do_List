package com.tasktracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tasktracker.dao.TaskDao;
import com.tasktracker.entity.Task;
import com.tasktracker.exception.DataSaveException;
import com.tasktracker.exception.TaskNotFoundException;
import com.tasktracker.response.ResponseStructure;
@Service
public class TaskService {
	@Autowired
	private TaskDao dao;
	
	public ResponseEntity<ResponseStructure<Task>> saveTask(Task task) {
			Task t= dao.saveTask(task);
			if(t !=null)
			{
				ResponseStructure<Task> structure =new ResponseStructure<>();
				structure.setMessage("Data saves successfully");
				structure.setStatus(HttpStatus.OK.value());
				structure.setObj(t);
				return new ResponseEntity<ResponseStructure<Task>>(structure,HttpStatus.OK);
			}
			else
			{
				throw new DataSaveException ("failed to save the data");
			}
		 
	}

	public ResponseEntity<ResponseStructure<Task>> getById(Long id) {
		Task t=dao.getById(id);
		
		ResponseStructure<Task> structure =new ResponseStructure<>();
		structure.setMessage("Data fetched successfully");
		structure.setStatus(HttpStatus.OK.value());
		structure.setObj(t);
		return new ResponseEntity<ResponseStructure<Task>>(structure,HttpStatus.OK);
		
			
		
	}

	public ResponseEntity<ResponseStructure<List<Task>>> getAll() {
		List<Task> t=dao.getAll();
	
		ResponseStructure<List<Task>> structure =new ResponseStructure<>();
		structure.setMessage("Data fetched successfully");
		structure.setStatus(HttpStatus.OK.value());
		structure.setObj(t);
		return new ResponseEntity<ResponseStructure<List<Task>>>(structure, HttpStatus.OK);
		
	}

	public ResponseEntity<ResponseStructure<Task>> updateById(Long id,Task task) {
		
		Task t=dao.updateById(id,task);
		
		ResponseStructure<Task> structure =new ResponseStructure<>();
		structure.setMessage("Data Updated successfully");
		structure.setStatus(HttpStatus.OK.value());
		structure.setObj(t);
		return new ResponseEntity<ResponseStructure<Task>>(structure, HttpStatus.OK);

		
			
		
	
	
}

	public ResponseEntity<ResponseStructure<Task>> deleteById(Long id) {
	    Task t = dao.deleteById(id);  

	    ResponseStructure<Task> structure = new ResponseStructure<>();
	    structure.setMessage("Data deleted successfully");
	    structure.setStatus(HttpStatus.OK.value());
	    structure.setObj(t);

	    return new ResponseEntity<>(structure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<String>> delete() {
	    dao.delete(); 
	    ResponseStructure<String> structure = new ResponseStructure<>();
	    structure.setMessage("All tasks deleted successfully");
	    structure.setStatus(HttpStatus.OK.value());
	    structure.setObj("All task records have been removed");
	    return new ResponseEntity<>(structure, HttpStatus.OK);
	}

	
}
