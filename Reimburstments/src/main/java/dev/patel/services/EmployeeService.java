package dev.patel.services;

import dev.patel.entities.Employee;

import java.util.Set;
import dev.patel.entities.Employee;
import java.util.List;

public interface EmployeeService {
	
	// create 
	Employee createEmployee(Employee employee);
	// read
	Employee getEmployeeById(int id);
	Employee getEmployeeByUsername(String username);
	List<Employee> getAllEmployees();
	
	//update
	Employee updateEmployee(Employee employee);
	
	//Delete
	boolean deleteEmployee(Employee employee);
	
	//void getReimbursementsByEmployeeId(int geteId);
}
