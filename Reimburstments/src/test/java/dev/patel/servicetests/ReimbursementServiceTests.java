package dev.patel.servicetests;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;

import dev.patel.daos.EmployeeDAO;
import dev.patel.daos.ReimburstmentDAOhibernate;
import dev.patel.entities.Employee;
import dev.patel.entities.Reimburstment;
import dev.patel.services.EmployeeService;
import dev.patel.services.EmployeeServiceImpl;
import dev.patel.services.ReimburstmentService;
import dev.patel.services.ReimburstmentServiceImpl;

@TestMethodOrder(OrderAnnotation.class)
public class ReimbursementServiceTests {
	
	public static ReimburstmentService rserv = new ReimburstmentServiceImpl();
	public static EmployeeService eserv = new EmployeeServiceImpl();

	@Test
	@Order(1)
	void createReimbursement() {
		//Employee employee = eserv.getEmployeeById(2);
		Reimburstment reimburstment = new Reimburstment(0,1.0,"Pending", "na", 2 );
		rserv.createReimburstment(reimburstment);
	}
	
	@Test
	@Order(2)
	void getReimbursementById() {
		Reimburstment reimburstment = rserv.getReimbursementById(1);
		Assertions.assertEquals(1, reimburstment.getrId());
	}
	
	@Test
	@Order(3)
	void updateReimbursement() {
		Reimburstment reimburstment = rserv.getReimbursementById(1);
		reimburstment.setAmount(2);
		rserv.updateReimbursement(reimburstment);	
		Assertions.assertEquals(2,reimburstment.getAmount());
	}
	
	@Test
	@Order(4)
	void getAllReimbursements() {
		
		List<Reimburstment> reimburstment = rserv.getAllReimbursements();
		Assertions.assertEquals(1,reimburstment.size());
	}
	

	
	
	
	@Test
	@Order(5)
	void deletereimbursement() {
		Reimburstment reimburstment = rserv.getReimbursementById(1);	
		boolean result = rserv.deleteReimbursement(reimburstment);
		Assertions.assertEquals(true,result);

	}
	

}
