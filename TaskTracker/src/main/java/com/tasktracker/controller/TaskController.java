package com.tasktracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tasktracker.entity.Task;
import com.tasktracker.response.ResponseStructure;
import com.tasktracker.service.TaskService;

import jakarta.validation.Valid;

@RestController
public class TaskController {
	
	@Autowired
	private TaskService service;
	
	@PostMapping("/save")
	public ResponseEntity<ResponseStructure<Task>> saveTask(@Valid @RequestBody Task task)
	{
		return service.saveTask(task);
	}
	
	@GetMapping("getById")
	public ResponseEntity<ResponseStructure<Task>> getById(@RequestParam Long id){
		return service.getById(id);
	}
	
	
	@GetMapping("getAll")
	public ResponseEntity<ResponseStructure<List<Task>>> getAll(){
		return service.getAll();
	}
	
	
	@PutMapping("/updateById")
	public ResponseEntity<ResponseStructure<Task>> updateById(@RequestParam Long id, @Valid @RequestBody Task task) {
	    return service.updateById(id, task);
	}
	
	@DeleteMapping("/deleteById")
	public ResponseEntity<ResponseStructure<Task>> deleteById(@RequestParam Long id) {
	    return service.deleteById(id);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<ResponseStructure<String>> delete() {
	    return service.delete();
	}



}
