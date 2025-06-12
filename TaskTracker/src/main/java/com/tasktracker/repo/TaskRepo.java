package com.tasktracker.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tasktracker.entity.Task;

public interface TaskRepo  extends JpaRepository<Task, Long>{

}
