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
import dev.patel.daos.ManagerDAO;
import dev.patel.daos.ManagerDAOhibernate;
import dev.patel.entities.Employee;
import dev.patel.entities.Manager;


@TestMethodOrder(OrderAnnotation.class) 
public class ManagerDAOtests {

	
	private static ManagerDAO mdao = new ManagerDAOhibernate();

	@Test
	@Order(1)
	void getManagerById() {
		Manager manager = mdao.getManagerById(1);
		Assertions.assertEquals(1, manager.getmId());
	}

}
