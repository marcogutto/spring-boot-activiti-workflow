package com.example.activiti.controller;

import java.util.List;

import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.activiti.service.ProcessService;

@RestController
public class ProcessController {

	@Autowired
	private ProcessService processService;

	/*
	 * Method will start the Activiti process engine and set employee to perform
	 * the task
	 */
	@RequestMapping(value = "/process")
	public String startProcessInstance(@RequestParam String assignee) {
		return processService.startTheProcess(assignee);
	}

	// Retrieve the tasks assigned to an employee
	@RequestMapping(value = "/tasks")
	public String getTasks(@RequestParam String assignee) {
		List<Task> tasks = processService.getTasks(assignee);
		return tasks.toString();
	}

	// Complete the task by their ID
	@RequestMapping(value = "/completetask")
	public String completeTask(@RequestParam String taskId) {
		processService.completeTask(taskId);
		return "Task with id " + taskId + " has been completed!";
	}
}