package com.example.activiti.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.activiti.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	public Employee findByName(String name);

}
