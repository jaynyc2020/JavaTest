package dev.patel.daotests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Set;

import javax.management.Query;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;

import dev.patel.daos.EmployeeDAO;
import dev.patel.daos.EmployeeDAOhibernate;
import dev.patel.entities.Employee;

@TestMethodOrder(OrderAnnotation.class) 
public class EmployeeDAOtests {
	
	private static EmployeeDAO edao = new EmployeeDAOhibernate();
	// Execute once
	
	@Test
	@Order(1)
	void createEmployee() { 
		// an object with an ID of 0 is understood to not be a record in the database
		Employee employee = new Employee(0,"jay patel","jayusername", "jaypassword");
		Employee employee2 = new Employee(0,"Karl Drogo","Karlusername", "karlpassword");
		edao.createEmployee(employee);
		edao.createEmployee(employee2);
		Assertions.assertNotEquals(0, employee.geteId());
	}
	
	
	@Test
	@Order(2)
	void getEmployeeById() {
		Employee employee = edao.getEmployeeById(1);
		Assertions.assertEquals(1, employee.geteId());
	}
	
	@Test
	@Order(3)
	void getAllEmployees() {
		
		List<Employee> employees = edao.getAllEmployees();
		Assertions.assertEquals(2,employees.size());
	}
	
	@Test
	@Order(4)
	void updateEmployee() {
		Employee employee = edao.getEmployeeById(1);
		employee.setName("Jay NameChange");
		edao.updateEmployee(employee);	
		Assertions.assertEquals("Jay NameChange",employee.getName());
	}
	
	@Test
	@Order(5)
	void deleteEmployee() {
		Employee employee = edao.getEmployeeById(1);	
		boolean result = edao.deleteEmployee(employee);
		Assertions.assertEquals(true,result);

	}
	

	
	
	
	
	

}
