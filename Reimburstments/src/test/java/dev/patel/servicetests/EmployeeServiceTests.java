package dev.patel.servicetests;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;


import dev.patel.entities.Employee;
import dev.patel.services.EmployeeService;
import dev.patel.services.EmployeeServiceImpl;
import dev.patel.services.ReimburstmentService;
import dev.patel.services.ReimburstmentServiceImpl;

@TestMethodOrder(OrderAnnotation.class)
public class EmployeeServiceTests {
	
	public static EmployeeService eserv = new EmployeeServiceImpl();
	//public static ReimbursementService rserv = new ReimbursementServiceImpl();
	
	@Test
	@Order(1)
	void createEmployee() {
		Employee employee = new Employee(0,"jay patel","jayusername", "jaypassword");
		Employee employee2 = new Employee(0,"Karl Drogo","Karlusername", "karlpassword");
		eserv.createEmployee(employee);
		eserv.createEmployee(employee2);
	}
	
	@Test
	@Order(2)
	void getEmployeeById() {
		Employee employee = eserv.getEmployeeById(1);
		Assertions.assertEquals(1, employee.geteId());
	}
	
	@Test
	@Order(3)
	void updateEmployee() {
		Employee employee = eserv.getEmployeeById(1);
		employee.setName("Jay NameChange");
		eserv.updateEmployee(employee);	
		Assertions.assertEquals("Jay NameChange",employee.getName());
	}
	
	@Test
	@Order(4)
	void getAllEmployees() {
		
		List<Employee> employees = eserv.getAllEmployees();
		Assertions.assertEquals(2,employees.size());
	}
	/*
	@Test
	@Order(5)
	void getReimbursementsByEmployeeId() {
		Employee employee = eserv.getEmployeeById(1);
		eserv.getReimbursementsByEmployeeId(employee.geteId());
		int count = (employee.getReimbursement()).size();
		Assertions.assertEquals(0,count);
	}
	*/
	
	@Test
	@Order(5)
	void deleteEmployee() {
		Employee employee = eserv.getEmployeeById(1);	
		boolean result = eserv.deleteEmployee(employee);
		Assertions.assertEquals(true,result);

	}
	

}
