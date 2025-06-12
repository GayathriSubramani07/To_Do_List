package com.tasktracker.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tasktracker.entity.Task;
import com.tasktracker.exception.TaskDeletionException;
import com.tasktracker.exception.TaskNotFoundException;
import com.tasktracker.repo.TaskRepo;

@Repository
public class TaskDao {
	
	@Autowired
	private TaskRepo repo;
	
	public Task saveTask(Task task) {
		
		Task t= repo.save(task);
		return t;
	}

	public Task getById(Long id) {
	Optional<Task> optional = repo.findById(id);
	if(optional.isPresent()) {
		Task t=optional.get();
		return t;
	}
	else
	{
		throw new TaskNotFoundException("Task id is not found");
	}
		
		
	}

	public List<Task> getAll() {
	    List<Task> tasks = repo.findAll();
	    if (tasks.isEmpty()) {
	        throw new TaskNotFoundException("No tasks found to fetch");
	    }
	    return tasks;
	}


	public Task updateById(Long id ,Task task) {
		Optional<Task> optional=repo.findById(id);
		if(optional.isPresent())
		{
			Task t=optional.get();
			task.setId(id);
			
			return repo.save(task);
		}
		throw new TaskNotFoundException("Task id is not found");
		
		
	}

	public Task deleteById(Long id) {
	    Optional<Task> optional = repo.findById(id);
	    if (optional.isPresent()) {
	        Task taskToDelete = optional.get();
	        repo.deleteById(id);
	        return taskToDelete;
	    } else {
	        throw new TaskDeletionException("Task with ID " + id + " not found.");
	    }
	}

	public void delete() {
	    if (repo.count() == 0) {
	        throw new TaskDeletionException("No tasks found to delete.");
	    }

	    try {
	        repo.deleteAll();
	    } catch (Exception e) {
	        throw new TaskDeletionException("Something went wrong during deletion.");
	    }
	}


}
