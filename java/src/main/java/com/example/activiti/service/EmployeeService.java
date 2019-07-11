package com.example.activiti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.activiti.model.Employee;
import com.example.activiti.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	// create the list of Employees into the database who perform the task
	public void createEmployee() {

		if (employeeRepository.findAll().size() == 0) {

			employeeRepository.save(new Employee("Prince", "Software Enginner"));
			employeeRepository.save(new Employee("Gaurav", "Technical Lead"));
			employeeRepository.save(new Employee("Abhinav", "Test Lead"));
		}
	}
}