package dev.patel.servicetests;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;


import dev.patel.entities.Employee;
import dev.patel.entities.Manager;
import dev.patel.services.EmployeeService;
import dev.patel.services.EmployeeServiceImpl;
import dev.patel.services.ManagerService;
import dev.patel.services.ManagerServiceImpl;
import dev.patel.services.ReimburstmentService;
import dev.patel.services.ReimburstmentServiceImpl;

@TestMethodOrder(OrderAnnotation.class)

public class ManagerServicetests {
	
	public static ManagerService mserv = new ManagerServiceImpl();

	@Test
	@Order(1)
	void getManagerbyIdEmployee() {
		
		Manager man = mserv.getManagerById(1);
		Assertions.assertEquals(1, man.getmId());
	}

}
